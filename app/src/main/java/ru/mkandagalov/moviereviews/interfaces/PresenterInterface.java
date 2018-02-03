package ru.mkandagalov.moviereviews.interfaces;

import ru.mkandagalov.moviereviews.models.ReviewResponse;

/**
 * Created by Марат on 03.02.2018.
 */

public interface PresenterInterface {
    void showProgress(boolean showProgress);
    void showError(String apiError);
    void showResult(ReviewResponse reviewResponse);
}
