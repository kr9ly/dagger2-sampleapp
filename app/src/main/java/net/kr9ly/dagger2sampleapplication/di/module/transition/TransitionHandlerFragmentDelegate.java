package net.kr9ly.dagger2sampleapplication.di.module.transition;

import android.support.v4.app.Fragment;

import net.kr9ly.dagger2sampleapplication.infra.transition.FragmentTransitionHandler;
import net.kr9ly.dagger2sampleapplication.infra.transition.TransitionHandler;

public class TransitionHandlerFragmentDelegate implements TransitionHandlerDelegate {

    private final Fragment fragment;

    public TransitionHandlerFragmentDelegate(Fragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public TransitionHandler provide() {
        return new FragmentTransitionHandler(fragment);
    }
}
