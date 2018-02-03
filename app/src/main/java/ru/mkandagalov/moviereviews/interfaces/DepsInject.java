package ru.mkandagalov.moviereviews.interfaces;

import javax.inject.Singleton;

import dagger.Component;
import ru.mkandagalov.moviereviews.MainActivity;
import ru.mkandagalov.moviereviews.api.ApiModule;

/**
 * Created by Марат on 03.02.2018.
 */

@Singleton
@Component(modules = {ApiModule.class,})
public interface DepsInject {
    void inject(MainActivity activity);
}