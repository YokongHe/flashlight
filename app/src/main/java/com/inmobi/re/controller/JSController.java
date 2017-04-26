package com.inmobi.re.controller;

import android.content.Context;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.controller.JSController$ExpandProperties;
import org.json.JSONObject;

public abstract class JSController {
   public static final String EXIT = "exit";
   public static final String FULL_SCREEN = "fullscreen";
   public static final String STYLE_NORMAL = "normal";
   protected JSController$ExpandProperties expProps;
   protected IMWebView imWebView;
   protected Context mContext;
   protected JSController$ExpandProperties temporaryexpProps;

   public JSController(IMWebView var1, Context var2) {
      this.imWebView = var1;
      this.mContext = var2;
      this.expProps = new JSController$ExpandProperties();
      this.temporaryexpProps = new JSController$ExpandProperties();
   }

   protected static Object getFromJSON(JSONObject param0, Class param1) {
      // $FF: Couldn't be decompiled
   }

   public abstract void stopAllListeners();
}
