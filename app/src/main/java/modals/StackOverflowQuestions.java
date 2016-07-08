package modals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by C.limbachiya on 7/7/2016.
 */
public class StackOverflowQuestions {

    @SerializedName("items")
    @Expose
    private List<JsonListItem> items;
    @SerializedName("has_more")
    @Expose
    private boolean has_more;
    @SerializedName("quota_max")
    @Expose
    private int quota_max;
    @SerializedName("quota_remaining")
    @Expose
    private int quota_remaining;

    public List<JsonListItem> getItems() {
        return items;
    }

    public void setItems(List<JsonListItem> items) {
        this.items = items;
    }
}
