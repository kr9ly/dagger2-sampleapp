package net.kr9ly.dagger2sampleapplication.infra.transition;

import android.support.v4.app.Fragment;

import net.kr9ly.dagger2sampleapplication.infra.transition.intent.IntentBuilder;

public class FragmentTransitionHandler implements TransitionHandler {

    private final Fragment fragment;

    public FragmentTransitionHandler(Fragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void startActivity(IntentBuilder intentBuilder) {
        fragment.startActivity(intentBuilder.build(fragment.getContext()));
    }

    @Override
    public void finish() {
        fragment.getActivity().finish();
    }
}
