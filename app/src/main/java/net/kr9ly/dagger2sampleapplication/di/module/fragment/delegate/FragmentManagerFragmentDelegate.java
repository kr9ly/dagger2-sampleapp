package net.kr9ly.dagger2sampleapplication.di.module.fragment.delegate;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class FragmentManagerFragmentDelegate implements FragmentManagerDelegate {

    private final Fragment fragment;

    public FragmentManagerFragmentDelegate(Fragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public FragmentManager provide() {
        return fragment.getChildFragmentManager();
    }
}
