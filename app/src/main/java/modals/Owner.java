package modals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by C.limbachiya on 7/7/2016.
 */
public class Owner {

    @SerializedName("profile_image")
    @Expose
    private String profile_image;

    @SerializedName("user_id")
    @Expose
    private String user_id;

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
