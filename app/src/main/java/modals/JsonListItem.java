package modals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by C.limbachiya on 7/8/2016.
 */
public class JsonListItem {

    @SerializedName("owner")
    @Expose
    private Owner owner;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("question_id")
    @Expose
    private String questionId;

    @SerializedName("tags")
    @Expose
    private List<String> tags;

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String question_id) {
        this.questionId = question_id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
