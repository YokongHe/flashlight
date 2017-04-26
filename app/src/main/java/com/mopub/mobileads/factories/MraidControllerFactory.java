package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.common.AdReport;
import com.mopub.common.VisibleForTesting;
import com.mopub.mraid.MraidController;
import com.mopub.mraid.PlacementType;

public class MraidControllerFactory {
   protected static MraidControllerFactory instance = new MraidControllerFactory();

   public static MraidController create(Context var0, AdReport var1, PlacementType var2) {
      return instance.internalCreate(var0, var1, var2);
   }

   @VisibleForTesting
   public static void setInstance(MraidControllerFactory var0) {
      instance = var0;
   }

   protected MraidController internalCreate(Context var1, AdReport var2, PlacementType var3) {
      return new MraidController(var1, var2, var3);
   }
}
