package com.mopub.common;

import android.content.Context;
import android.content.SharedPreferences;

public final class SharedPreferencesHelper {
   public static final String PREFERENCE_NAME = "mopubSettings";

   public static SharedPreferences getSharedPreferences(Context var0) {
      return var0.getSharedPreferences("mopubSettings", 0);
   }
}
