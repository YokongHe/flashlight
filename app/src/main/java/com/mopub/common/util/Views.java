package com.mopub.common.util;

import android.view.View;
import android.view.ViewGroup;

public class Views {
   public static void removeFromParent(View var0) {
      if(var0 != null && var0.getParent() != null && var0.getParent() instanceof ViewGroup) {
         ((ViewGroup)var0.getParent()).removeView(var0);
      }
   }
}
