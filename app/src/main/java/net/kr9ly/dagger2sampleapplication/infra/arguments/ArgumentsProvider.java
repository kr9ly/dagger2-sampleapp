package net.kr9ly.dagger2sampleapplication.infra.arguments;

public interface ArgumentsProvider {

    String getString(String key, String defaultValue);

    int getInt(String key, int defaultValue);
}
