package net.kr9ly.dagger2sampleapplication.infra.transition;

import net.kr9ly.dagger2sampleapplication.infra.transition.intent.IntentBuilder;

public interface TransitionHandler {

    void startActivity(IntentBuilder intentBuilder);
}
