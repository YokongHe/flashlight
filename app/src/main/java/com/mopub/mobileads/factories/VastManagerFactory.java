package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.mobileads.util.vast.VastManager;

public class VastManagerFactory {
   protected static VastManagerFactory instance = new VastManagerFactory();

   public static VastManager create(Context var0) {
      return instance.internalCreate(var0);
   }

   @Deprecated
   public static void setInstance(VastManagerFactory var0) {
      instance = var0;
   }

   public VastManager internalCreate(Context var1) {
      return new VastManager(var1);
   }
}
