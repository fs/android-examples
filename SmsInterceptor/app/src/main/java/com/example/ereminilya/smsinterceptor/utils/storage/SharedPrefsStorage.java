package com.example.ereminilya.smsinterceptor.utils.storage;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by ereminilya on 24/11/16.
 */
public class SharedPrefsStorage implements Storage {

    private final SharedPreferences sp;

    public SharedPrefsStorage(SharedPreferences sp) {
        this.sp = sp;
    }

    @Override public boolean contains(@NonNull String key) {
        return sp.contains(key);
    }

    @Override public void putLong(@NonNull String key, long number) {
        sp.edit().putLong(key, number).apply();
    }

    @Override public long getLong(@NonNull String key, long defaultValue) {
        return sp.getLong(key, defaultValue);
    }

    @Override public void putInt(@NonNull String key, int number) {
        sp.edit().putInt(key, number).apply();
    }

    @Override public int getInt(@NonNull String key, int defaultValue) {
        return sp.getInt(key, defaultValue);
    }

    @Override public void putBoolean(@NonNull String key, boolean value) {
        sp.edit().putBoolean(key, value).apply();
    }

    @Override public boolean getBoolean(@NonNull String key, boolean defaultValue) {
        return sp.getBoolean(key, defaultValue);
    }

    @Override public void putString(@NonNull String key, @NonNull String str) {
        sp.edit().putString(key, str).apply();
    }

    @Nullable @Override public String getString(@NonNull String key) {
        return sp.getString(key, null);
    }

    @Override public void remove(@NonNull String key) {
        sp.edit().remove(key).apply();
    }

    @Override public void clear() {
        sp.edit().clear().apply();
    }
}
