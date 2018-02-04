package net.kr9ly.dagger2sampleapplication.infra.transition;

import android.support.v4.app.FragmentActivity;

import net.kr9ly.dagger2sampleapplication.infra.transition.intent.IntentBuilder;

public class ActivityTransitionHandler implements TransitionHandler {

    private final FragmentActivity activity;

    public ActivityTransitionHandler(FragmentActivity activity) {
        this.activity = activity;
    }

    @Override
    public void startActivity(IntentBuilder intentBuilder) {
        activity.startActivity(intentBuilder.build(activity));
    }

    @Override
    public void finish() {
        activity.finish();
    }
}
