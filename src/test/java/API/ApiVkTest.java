package API;

import POJOs.VkPOJOs.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

@SuppressWarnings("rawtypes")
public class ApiVkTest {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final String ACCESS_TOKEN = " ";
    private static final int OWNER_id = 34223423;
    private static final String API_VERSION = "5.131";
    private static final String METHOD_POST = "wall.post";
    private static final String METHOD_LIKE = "likes.add";
    private static final String METHOD_COMMENT = "wall.createComment";
    private static final String METHOD_IS_LIKED = "likes.getList";
    private static final String METHOD_GET_COMMENT = "wall.getComment";
    public static ValidatableResponse validatableResponse;
    public static int postId;
    public static int commentId;
    static ResponseJSON responseJSON;
    static JsonNode jsonNode;

    public static void postMessage(String text) throws JsonProcessingException {
        RestAssured.baseURI = "https://api.vk.com/method";
        String request = String.format("/%s?owner_id=%s&message=%s&access_token=%s&v=%s", METHOD_POST, OWNER_id, text, ACCESS_TOKEN, API_VERSION);
        Response response = given().post(request);
        validatableResponse = response.then().statusCode(200);
        ResponseBody responseBody = response.getBody();
        responseJSON = mapper.readValue(responseBody.asString(), ResponseJSON.class);
        PostId postIdDeserialized = mapper.readValue(responseJSON.getResponse().toString(), PostId.class);
        postId = postIdDeserialized.getPostId();
    }

    public static void likePost(int postId) {
        String request = String.format("/%s?type=%s&item_id=%s&access_token=%s&v=%s", METHOD_LIKE, "post", postId, ACCESS_TOKEN, API_VERSION);
        Response response = given().post(request);
        validatableResponse = response.then().statusCode(200);
    }

    public static void commentPost(String comment, int postId) throws JsonProcessingException {
        String request = String.format("/%s?post_id=%s&message=%s&access_token=%s&v=%s", METHOD_COMMENT, postId, comment, ACCESS_TOKEN, API_VERSION);
        Response response = given().post(request);
        ResponseBody responseBody = response.getBody();
        responseJSON = mapper.readValue(responseBody.asString(), ResponseJSON.class);
        Comments commentsIdDeserialized = mapper.readValue(responseJSON.getResponse().toString(), Comments.class);
        commentId = commentsIdDeserialized.getCommentId();
        validatableResponse = response.then().statusCode(200);
    }

    public static void checkLikes(int postId) throws JsonProcessingException {
        String request = String.format("/%s?item_id=%s&type=%s&extended=%s&access_token=%s&v=%s", METHOD_IS_LIKED, postId, "post", "1", ACCESS_TOKEN, API_VERSION);
        Response response = given().post(request);
        ResponseBody responseBody = response.getBody();
        responseJSON = mapper.readValue(responseBody.asString(), ResponseJSON.class);
        LikesList likesList = mapper.readValue(responseJSON.getResponse().toJSONString(), LikesList.class);
        for (int i = 0; i < likesList.getLikesLists().size(); i++) {
            Assertions.assertEquals(OWNER_id, likesList.getLikesLists().get(i).getId());
        }
    }

    public static void checkComment(int commentId) throws JsonProcessingException {
        String request = String.format("/%s?comment_id=%s&access_token=%s&v=%s", METHOD_GET_COMMENT, commentId, ACCESS_TOKEN, API_VERSION);
        Response response = given().post(request);
        ResponseBody responseBody = response.getBody();
        jsonNode = mapper.readTree(responseBody.asString()).path("response");
        FromIdPOJO pojo4Check = mapper.treeToValue(jsonNode, FromIdPOJO.class);
        Assertions.assertEquals(OWNER_id, pojo4Check.getFrom_id());
    }

//    @Test
    public void vkApiTest() throws JsonProcessingException {
        postMessage("foo");
        likePost(postId);
        commentPost("bar", postId);
        checkLikes(postId);
        checkComment(commentId);
    }
}