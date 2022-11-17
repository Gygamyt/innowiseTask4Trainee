package POJOs.VkPOJOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Comments {
    @JsonProperty("likes")
    @JsonIgnore
    private String likes;
    @JsonProperty("comment_id")
    private int commentId;

    public int getCommentId() {
        return commentId;
    }

    @JsonProperty("parents_stack")
    @JsonIgnore
    private String parents_stack;

    @JsonIgnore
    @JsonProperty("parents_stack")
    ArrayList<JSONObject> parentsStack;
}
