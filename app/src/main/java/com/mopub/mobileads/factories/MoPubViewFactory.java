package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.mobileads.MoPubView;

public class MoPubViewFactory {
   protected static MoPubViewFactory instance = new MoPubViewFactory();

   public static MoPubView create(Context var0) {
      return instance.internalCreate(var0);
   }

   @Deprecated
   public static void setInstance(MoPubViewFactory var0) {
      instance = var0;
   }

   protected MoPubView internalCreate(Context var1) {
      return new MoPubView(var1);
   }
}
