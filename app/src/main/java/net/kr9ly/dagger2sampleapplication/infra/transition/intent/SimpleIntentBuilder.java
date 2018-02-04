package net.kr9ly.dagger2sampleapplication.infra.transition.intent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import net.kr9ly.dagger2sampleapplication.infra.transition.intent.extra.ExtraEntry;
import net.kr9ly.dagger2sampleapplication.infra.transition.intent.extra.entry.IntegerExtraEntry;
import net.kr9ly.dagger2sampleapplication.infra.transition.intent.extra.entry.StringExtraEntry;

import java.util.ArrayList;
import java.util.List;

public class SimpleIntentBuilder implements IntentBuilder {

    private final List<ExtraEntry> extras = new ArrayList<>();

    private final Class<? extends Activity> targetActivityClass;

    public SimpleIntentBuilder(Class<? extends Activity> targetActivityClass) {
        this.targetActivityClass = targetActivityClass;
    }

    public SimpleIntentBuilder putExtra(String key, String value) {
        extras.add(new StringExtraEntry(key, value));
        return this;
    }

    public SimpleIntentBuilder putExtra(String key, int value) {
        extras.add(new IntegerExtraEntry(key, value));
        return this;
    }

    @Override
    public Intent build(Context context) {
        Intent intent = new Intent(context, targetActivityClass);
        for (ExtraEntry extra : extras) {
            extra.setExtra(intent);
        }
        return intent;
    }
}
