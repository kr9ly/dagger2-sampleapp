package net.kr9ly.dagger2sampleapplication.di.module.recycler;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import dagger.Module;
import dagger.Provides;

@Module
public class LayoutManagerModule {

    private final Context context;

    public LayoutManagerModule(Context context) {
        this.context = context;
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(context);
    }
}
