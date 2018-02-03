package ru.mkandagalov.moviereviews.api;

import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.mkandagalov.moviereviews.models.ReviewResponse;
import rx.Observable;

/**
 * Created by Марат on 03.02.2018.
 */

public interface ApiService {

    @GET("all.json")
    Observable<ReviewResponse> getReviews(@Query("api_key") String api_key);
}
