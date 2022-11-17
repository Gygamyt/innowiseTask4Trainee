package POJOs.VkPOJOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FromIdPOJO {
    @JsonIgnore
    private String id, date, text, can_edit, post_id, owner_id;

    @JsonProperty("can_post")
    @JsonIgnore
    private String can_post;

    private String show_reply_button, groups_can_post;

    @JsonIgnore
    private List parents_stack;

    public List getItems() {
        return items;
    }

    @JsonProperty("items")
    private List items;

    public List items() {
        return items;
    }

    public int getFrom_id() {
        return from_id;
    }
    @JsonProperty("from_id")
    private int from_id;
}