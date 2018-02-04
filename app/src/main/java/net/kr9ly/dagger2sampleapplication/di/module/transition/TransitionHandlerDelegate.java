package net.kr9ly.dagger2sampleapplication.di.module.transition;

import net.kr9ly.dagger2sampleapplication.infra.transition.TransitionHandler;

public interface TransitionHandlerDelegate {

    TransitionHandler provide();
}
