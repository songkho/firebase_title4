package com.idsoft.firebase_title.analytics;

import android.content.Context;
import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

class AnalyticsWebInterface {

    public static final String TAG = "AnalyticsWebInterface";
    private FirebaseAnalytics mAnalytics;

    public AnalyticsWebInterface(Context context) {
        mAnalytics = FirebaseAnalytics.getInstance(context);
    }

    public void logEvent(String name, String itemId, String itemName){
        mAnalytics.logEvent(name, bundleFromJson(itemId, itemName));
    }

    private Bundle bundleFromJson(String itemId, String itemName){
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, itemId);
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, itemId);

        return bundle;
    }
}
