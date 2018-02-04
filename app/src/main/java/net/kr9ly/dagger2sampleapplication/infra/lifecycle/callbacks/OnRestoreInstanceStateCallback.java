package net.kr9ly.dagger2sampleapplication.infra.lifecycle.callbacks;

import android.os.Bundle;

public interface OnRestoreInstanceStateCallback extends LifecycleCallback {

    void onRestoreInstanceState(Bundle savedInstanceState);
}
