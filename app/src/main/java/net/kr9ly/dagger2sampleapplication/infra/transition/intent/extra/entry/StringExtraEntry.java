package net.kr9ly.dagger2sampleapplication.infra.transition.intent.extra.entry;

import android.content.Intent;

import net.kr9ly.dagger2sampleapplication.infra.transition.intent.extra.ExtraEntry;

public class StringExtraEntry implements ExtraEntry {

    private final String key;

    private final String value;

    public StringExtraEntry(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public void setExtra(Intent intent) {
        intent.putExtra(key, value);
    }
}
