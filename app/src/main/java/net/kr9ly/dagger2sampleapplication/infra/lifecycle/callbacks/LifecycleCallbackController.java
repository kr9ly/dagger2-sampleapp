package net.kr9ly.dagger2sampleapplication.infra.lifecycle.callbacks;

import android.os.Bundle;

import net.kr9ly.dagger2sampleapplication.di.scope.ViewScope;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

@ViewScope
public class LifecycleCallbackController {

    private final List<OnCreateCallback> onCreateCallbackList = new ArrayList<>();

    private final List<OnStartCallback> onStartCallbackList = new ArrayList<>();

    private final List<OnResumeCallback> onResumeCallbackList = new ArrayList<>();

    private final List<OnPauseCallback> onPauseCallbackList = new ArrayList<>();

    private final List<OnStopCallback> onStopCallbackList = new ArrayList<>();

    private final List<OnSaveInstanceStateCallback> onSaveInstanceStateCallbackList = new ArrayList<>();

    private final List<OnRestoreInstanceStateCallback> onRestoreInstanceStateCallbackList = new ArrayList<>();

    @Inject
    public LifecycleCallbackController() {
        
    }

    public void register(LifecycleCallback callback) {
        if (callback instanceof OnCreateCallback) {
            onCreateCallbackList.add((OnCreateCallback) callback);
        }

        if (callback instanceof OnStartCallback) {
            onStartCallbackList.add((OnStartCallback) callback);
        }

        if (callback instanceof OnResumeCallback) {
            onResumeCallbackList.add((OnResumeCallback) callback);
        }

        if (callback instanceof OnPauseCallback) {
            onPauseCallbackList.add((OnPauseCallback) callback);
        }

        if (callback instanceof OnStopCallback) {
            onStopCallbackList.add((OnStopCallback) callback);
        }

        if (callback instanceof OnSaveInstanceStateCallback) {
            onSaveInstanceStateCallbackList.add((OnSaveInstanceStateCallback) callback);
        }

        if (callback instanceof OnRestoreInstanceStateCallback) {
            onRestoreInstanceStateCallbackList.add((OnRestoreInstanceStateCallback) callback);
        }
    }

    public void onCreate() {
        for (OnCreateCallback onCreateCallback : onCreateCallbackList) {
            onCreateCallback.onCreate();
        }
    }

    public void onResume() {
        for (OnResumeCallback onResumeCallback : onResumeCallbackList) {
            onResumeCallback.onResume();
        }
    }

    public void onStart() {
        for (OnStartCallback onStartCallback : onStartCallbackList) {
            onStartCallback.onStart();
        }
    }

    public void onPause() {
        for (OnPauseCallback onPauseCallback : onPauseCallbackList) {
            onPauseCallback.onPause();
        }
    }

    public void onStop() {
        for (OnStopCallback onStopCallback : onStopCallbackList) {
            onStopCallback.onStop();
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        for (OnSaveInstanceStateCallback onSaveInstanceStateCallback : onSaveInstanceStateCallbackList) {
            onSaveInstanceStateCallback.onSaveInstanceState(outState);
        }
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        for (OnRestoreInstanceStateCallback onRestoreInstanceStateCallback : onRestoreInstanceStateCallbackList) {
            onRestoreInstanceStateCallback.onRestoreInstanceState(savedInstanceState);
        }
    }


}
