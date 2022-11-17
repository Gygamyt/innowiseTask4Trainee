package POJOs.VkPOJOs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostId {
    @JsonProperty("post_id")
    private int post_id;
    public int getPostId() {
        return post_id;
    }
}
