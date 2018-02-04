package net.kr9ly.dagger2sampleapplication.infra.lifecycle.callbacks;

import android.os.Bundle;

public interface OnSaveInstanceStateCallback extends LifecycleCallback {

    void onSaveInstanceState(Bundle outState);
}
