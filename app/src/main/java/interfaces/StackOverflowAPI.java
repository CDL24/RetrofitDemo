package interfaces;

import modals.StackOverflowQuestions;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by C.limbachiya on 7/7/2016.
 */
public interface StackOverflowAPI {

    //Actual URL :: https://api.stackexchange.com/2.2/search?order=desc&sort=activity&tagged=android&site=stackoverflow

    @GET("/2.2/questions?order=desc&sort=creation&site=stackoverflow")
    Call<StackOverflowQuestions> loadQuestions(@Query("tagged") String tags);
}
