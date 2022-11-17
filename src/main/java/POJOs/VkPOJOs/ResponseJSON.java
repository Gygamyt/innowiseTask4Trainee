package POJOs.VkPOJOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.simple.JSONObject;

public class ResponseJSON {
    @JsonProperty("response")
    private JSONObject response;
    public JSONObject getResponse() {
        return response;
    }
}