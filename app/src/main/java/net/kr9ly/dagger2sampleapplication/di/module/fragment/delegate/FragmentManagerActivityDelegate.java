package net.kr9ly.dagger2sampleapplication.di.module.fragment.delegate;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class FragmentManagerActivityDelegate implements FragmentManagerDelegate {

    private final FragmentActivity fragmentActivity;

    public FragmentManagerActivityDelegate(FragmentActivity fragmentActivity) {
        this.fragmentActivity = fragmentActivity;
    }

    @Override
    public FragmentManager provide() {
        return fragmentActivity.getSupportFragmentManager();
    }
}
