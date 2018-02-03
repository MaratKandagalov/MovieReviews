package ru.mkandagalov.moviereviews.presenters;

import ru.mkandagalov.moviereviews.api.ApiError;
import ru.mkandagalov.moviereviews.api.Service;
import ru.mkandagalov.moviereviews.interfaces.PresenterInterface;
import ru.mkandagalov.moviereviews.models.ReviewResponse;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Марат on 03.02.2018.
 */

public class DefaultPresenter {
    private final Service mService;
    private final PresenterInterface mView;
    private CompositeSubscription mSubscriptions;

    public DefaultPresenter(Service service, PresenterInterface view) {
        this.mService = service;
        this.mView = view;
        this.mSubscriptions = new CompositeSubscription();
    }

    public void getReviewsList() {
        mView.showProgress(true);

        Subscription subscription = mService.getReviewsList(new Service.GetReviewsListCallback() {
            @Override
            public void onSuccess(ReviewResponse reviewResponse) {
                mView.showProgress(false);
                mView.showResult(reviewResponse);
            }

            @Override
            public void onError(ApiError apiError) {
                mView.showProgress(false);
                mView.showError(apiError.getAppErrorMessage());
            }
        });

        mSubscriptions.add(subscription);
    }
    public void onStop() {
        mSubscriptions.unsubscribe();
    }
}
