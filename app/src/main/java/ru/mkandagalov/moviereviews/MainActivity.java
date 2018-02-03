package ru.mkandagalov.moviereviews;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import javax.inject.Inject;

import ru.mkandagalov.moviereviews.adapters.ReviewsAdapter;
import ru.mkandagalov.moviereviews.api.Service;
import ru.mkandagalov.moviereviews.interfaces.PresenterInterface;
import ru.mkandagalov.moviereviews.models.ReviewResponse;
import ru.mkandagalov.moviereviews.presenters.DefaultPresenter;
import ru.mkandagalov.moviereviews.views.BaseActivity;

public class MainActivity extends BaseActivity implements PresenterInterface, ReviewsAdapter.OnItemClickListener{

    private RecyclerView mReviewsRecyclerView;
    @Inject Service mService;
    private ProgressBar mProgressBar;
    private ReviewsAdapter mReviewsAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDeps().inject(this);
        setContentView(R.layout.activity_main);
        init();
        DefaultPresenter presenter = new DefaultPresenter(mService, this);
        presenter.getReviewsList();
    }

    private void init(){
        mReviewsRecyclerView = findViewById(R.id.reviews_list);
        mProgressBar = findViewById(R.id.progress);
        mReviewsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showProgress(boolean showProgress) {
        mProgressBar.setVisibility(showProgress ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showError(String apiError) {
        Toast.makeText(this, apiError, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showResult(ReviewResponse reviewResponse) {
        mReviewsAdapter = new ReviewsAdapter(this, reviewResponse.getResults(), this);
        mReviewsRecyclerView.setAdapter(mReviewsAdapter);
    }

    @Override
    public void onClick(String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        String title = getResources().getString(R.string.intent_chooser_title);
        Intent intentChooser = Intent.createChooser(intent, title);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intentChooser);
        }
    }
}
