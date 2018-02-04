package net.kr9ly.dagger2sampleapplication.infra.arguments;

import android.support.v4.app.FragmentActivity;

public class ActivityArgumentsProvider implements ArgumentsProvider {

    private final FragmentActivity fragmentActivity;

    public ActivityArgumentsProvider(FragmentActivity fragmentActivity) {
        this.fragmentActivity = fragmentActivity;
    }

    @Override
    public String getString(String key, String defaultValue) {
        return fragmentActivity.getIntent().hasExtra(key) ? fragmentActivity.getIntent().getStringExtra(key) : defaultValue;
    }

    @Override
    public int getInt(String key, int defaultValue) {
        return fragmentActivity.getIntent().getIntExtra(key, defaultValue);
    }
}
