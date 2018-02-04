package net.kr9ly.dagger2sampleapplication.infra.dispose;

import android.arch.lifecycle.LifecycleOwner;

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.AutoDisposeConverter;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

public class DisposeHelper {

    private final LifecycleOwner lifecycleOwner;

    public DisposeHelper(LifecycleOwner lifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner;
    }

    public <T> AutoDisposeConverter<T> autoDispose() {
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(lifecycleOwner));
    }

}
