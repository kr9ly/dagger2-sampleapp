package net.kr9ly.dagger2sampleapplication.di.module.transition;

import android.support.v4.app.FragmentActivity;

import net.kr9ly.dagger2sampleapplication.infra.transition.ActivityTransitionHandler;
import net.kr9ly.dagger2sampleapplication.infra.transition.TransitionHandler;

public class TransitionHandlerActivityDelegate implements TransitionHandlerDelegate {

    private final FragmentActivity fragmentActivity;

    public TransitionHandlerActivityDelegate(FragmentActivity fragmentActivity) {
        this.fragmentActivity = fragmentActivity;
    }

    @Override
    public TransitionHandler provide() {
        return new ActivityTransitionHandler(fragmentActivity);
    }
}
