package com.flatstack.analytics.util;

import android.content.Context;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.CustomEvent;

import java.util.Map;

import io.fabric.sdk.android.Fabric;

/**
 * Created by yaroslavsudnik on 07/06/17.
 */

public class CrashlyticsLogger implements EventLogger {

    public CrashlyticsLogger(Context context) {
        Fabric.with(context, new Crashlytics());
    }

    @Override public void log(String event) {
        Answers.getInstance().logCustom(new CustomEvent(event));
    }

    @Override public void logParam(String eventName, Map<String, String> events) {
        for (String string : events.keySet()) {
            Answers.getInstance().logCustom(new CustomEvent(eventName)
                .putCustomAttribute(string, events.get(string)));
        }
    }

    @Override public void logError(String errorId, String message, Throwable exception) {
        Crashlytics.logException(exception);
    }

    @Override public void performUserInfo(User user) {
        Crashlytics.setUserIdentifier(user.getId());
        Crashlytics.setUserEmail(user.getEmail());
        Crashlytics.setUserName(user.getName());
    }

    @Override public void onStartSession() {
        // automatic start session
        // https://support.crashlytics.com/knowledgebase/articles/397163-session-length-for-answers
    }

    @Override public void onStopSession() {
        // automatic stop session
        // https://support.crashlytics.com/knowledgebase/articles/397163-session-length-for-answers
    }

}
