package ru.mkandagalov.moviereviews.api;

import ru.mkandagalov.moviereviews.BuildConfig;
import ru.mkandagalov.moviereviews.models.ReviewResponse;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Марат on 03.02.2018.
 */

public class Service {
    private final ApiService mApiService;

    public Service (ApiService apiService) {
        this.mApiService = apiService;
    }

    public Subscription getReviewsList(final GetReviewsListCallback callback) {

        return mApiService.getReviews(BuildConfig.APIKEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends ReviewResponse>>() {
                    @Override
                    public Observable<? extends ReviewResponse> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<ReviewResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new ApiError(e));

                    }

                    @Override
                    public void onNext(ReviewResponse reviewResponse) {
                        callback.onSuccess(reviewResponse);

                    }
                });
    }

    public interface GetReviewsListCallback {
        void onSuccess(ReviewResponse reviewResponse);

        void onError(ApiError apiError);
    }
}
