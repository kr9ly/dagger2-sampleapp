package net.kr9ly.dagger2sampleapplication.di;

import android.content.Context;

import net.kr9ly.dagger2sampleapplication.di.component.ApplicationComponent;
import net.kr9ly.dagger2sampleapplication.di.component.DaggerApplicationComponent;
import net.kr9ly.dagger2sampleapplication.di.module.resource.ResourceProviderModule;

import java.util.WeakHashMap;

public class ApplicationComponentManager {

    private static final WeakHashMap<Context, ApplicationComponent> components = new WeakHashMap<>();

    public static synchronized ApplicationComponent get(Context context) {
        Context appContext = context.getApplicationContext();
        ApplicationComponent component = components.get(appContext);
        if (component != null) {
            return component;
        }

        component = DaggerApplicationComponent.builder()
                .resourceProviderModule(new ResourceProviderModule(appContext))
                .build();

        components.put(context, component);

        return component;
    }
}
