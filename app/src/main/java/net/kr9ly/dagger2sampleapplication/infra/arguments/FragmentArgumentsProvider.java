package net.kr9ly.dagger2sampleapplication.infra.arguments;

import android.support.v4.app.Fragment;

public class FragmentArgumentsProvider implements ArgumentsProvider {

    private final Fragment fragment;

    public FragmentArgumentsProvider(Fragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public String getString(String key, String defaultValue) {
        return fragment.getArguments().getString(key, defaultValue);
    }

    @Override
    public int getInt(String key, int defaultValue) {
        return fragment.getArguments().getInt(key, defaultValue);
    }
}
