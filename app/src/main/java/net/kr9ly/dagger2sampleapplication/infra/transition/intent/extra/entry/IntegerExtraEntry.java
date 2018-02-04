package net.kr9ly.dagger2sampleapplication.infra.transition.intent.extra.entry;

import android.content.Intent;

import net.kr9ly.dagger2sampleapplication.infra.transition.intent.extra.ExtraEntry;

public class IntegerExtraEntry implements ExtraEntry {

    private final String key;

    private final int value;

    public IntegerExtraEntry(String key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public void setExtra(Intent intent) {
        intent.putExtra(key, value);
    }
}
