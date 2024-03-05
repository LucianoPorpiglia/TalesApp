package com.example.storiesapp.util;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.Nullable;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.Date;

public class Preferences {

    private final SharedPreferences preferences;
    private final SharedPreferences.Editor editor;

    public static final int NO_VALUE_INT = -1;
    public static final int NO_VALUE_LONG = -1;

    protected Preferences(@Nullable Context context, @Nullable String name) {
        preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    @Nullable
    protected String get(@Nullable String key) {
        return preferences.getString(key, "");
    }

    protected void set(@Nullable String key, @Nullable String value) {
        editor.putString(key, value);
        editor.apply();
    }

    protected boolean getBoolean(@Nullable String key) {
        return preferences.getBoolean(key, false);
    }

    protected void set(@Nullable String key, boolean value) {
        editor.putBoolean(key, value);
        editor.apply();
    }

    protected int getInt(@Nullable String key) {
        return preferences.getInt(key, NO_VALUE_INT);
    }

    protected void set(@Nullable String key, int value) {
        editor.putInt(key, value);
        editor.apply();
    }

    protected long getLong(@Nullable String key) {
        return preferences.getLong(key, NO_VALUE_LONG);
    }

    protected void set(@Nullable String key, long value) {
        editor.putLong(key, value);
        editor.apply();
    }

    @Nullable
    protected Date getDate(@Nullable String key) {
        return getObject(key, Date.class);
    }

    @Nullable
    protected <T> T getObject(@Nullable String key, @Nullable Type objectClass) {
        String json = preferences.getString(key, "");
        return fromJson(json, objectClass);
    }

    protected void set(@Nullable String key, @Nullable Object value) {
        String json = new Gson().toJson(value);
        editor.putString(key, json);
        editor.apply();
    }

    protected void set(@Nullable String key, @Nullable Date value) {
        String json = new Gson().toJson(value);
        editor.putString(key, json);
        editor.apply();
    }

    private <T> T fromJson(String json, Type type) {
        try {
            return new Gson().fromJson(json, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void clear() {
        editor.clear();
        editor.apply();
    }

    public void commit() {
        editor.commit();
    }
}
