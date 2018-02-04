package net.kr9ly.dagger2sampleapplication.data.api;

import net.kr9ly.dagger2sampleapplication.data.entity.SampleListItemEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;

@Singleton
public class SampleApiClient {

    private final List<SampleListItemEntity> entities = Collections.unmodifiableList(new ArrayList<SampleListItemEntity>() {{
        add(new SampleListItemEntity(1, "りんご", 1));
        add(new SampleListItemEntity(2, "みかん", 3));
        add(new SampleListItemEntity(3, "バナナ", 5));
        add(new SampleListItemEntity(4, "メロン", 2));
        add(new SampleListItemEntity(5, "かき", 4));
        add(new SampleListItemEntity(6, "パッションフルーツ", 7));
        add(new SampleListItemEntity(7, "ドリアン", 1));
        add(new SampleListItemEntity(8, "マンゴー", 2));
    }});

    @Inject
    public SampleApiClient() {
    }

    public Single<List<SampleListItemEntity>> getItems() {
        return Single
                .just(entities)
                .delay(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<SampleListItemEntity> getItem(final int id) {
        return Single
                .fromCallable(new Callable<SampleListItemEntity>() {
                    @Override
                    public SampleListItemEntity call() throws Exception {
                        for (SampleListItemEntity entity : entities) {
                            if (entity.getId() == id) {
                                return entity;
                            }
                        }
                        throw new IllegalArgumentException();
                    }
                })
                .delay(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread());
    }
}
