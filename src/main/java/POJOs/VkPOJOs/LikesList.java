package POJOs.VkPOJOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LikesList {
    @JsonProperty("count")
    @JsonIgnore()
    private String count;

    @JsonProperty("type")
    @JsonIgnore()
    private String type;

    @JsonProperty("first_name")
    @JsonIgnore()
    private String first_name;

    @JsonProperty("last_name")
    @JsonIgnore()
    private String last_name;

    @JsonProperty("can_access_closed")
    @JsonIgnore()
    private String can_access_closed;

    @JsonProperty("is_closed")
    @JsonIgnore()
    private String is_closed;

    @JsonProperty("id")
    private int id;

    public int getId() {
        return id;
    }

    @JsonProperty("items")
    private List<LikesList> likesLists;

    public List<LikesList> getLikesLists() {
        return likesLists;
    }
}
