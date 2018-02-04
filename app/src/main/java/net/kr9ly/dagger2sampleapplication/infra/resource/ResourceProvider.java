package net.kr9ly.dagger2sampleapplication.infra.resource;

import android.content.Context;
import android.support.annotation.StringRes;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ResourceProvider {

    private final Context context;

    @Inject
    public ResourceProvider(Context context) {
        this.context = context;
    }

    public String getString(@StringRes int resId) {
        return context.getString(resId);
    }

    public String getString(@StringRes int resId, Object... formatArgs) {
        return context.getString(resId, formatArgs);
    }
}
