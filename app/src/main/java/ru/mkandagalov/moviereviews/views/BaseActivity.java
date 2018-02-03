package ru.mkandagalov.moviereviews.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.File;

import ru.mkandagalov.moviereviews.api.ApiModule;
import ru.mkandagalov.moviereviews.interfaces.DaggerDepsInject;
import ru.mkandagalov.moviereviews.interfaces.DepsInject;

/**
 * Created by Марат on 03.02.2018.
 */

public class BaseActivity extends AppCompatActivity {
    DepsInject mDeps;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File cacheFile = new File(getCacheDir(), "responses");
        mDeps = DaggerDepsInject.builder().apiModule(new ApiModule(cacheFile)).build();

    }

    public DepsInject getDeps() {
        return mDeps;
    }
}
