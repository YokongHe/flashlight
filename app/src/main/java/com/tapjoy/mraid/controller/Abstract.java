package com.tapjoy.mraid.controller;

import android.content.Context;
import com.tapjoy.mraid.view.MraidView;
import org.json.JSONObject;

public abstract class Abstract {
   public static final String EXIT = "exit";
   public static final String FULL_SCREEN = "fullscreen";
   public static final String STYLE_NORMAL = "normal";
   protected MraidView a;
   protected Context b;

   public Abstract(MraidView var1, Context var2) {
      this.a = var1;
      this.b = var2;
   }

   protected static Object a(JSONObject param0, Class param1) {
      // $FF: Couldn't be decompiled
   }

   public abstract void stopAllListeners();
}
