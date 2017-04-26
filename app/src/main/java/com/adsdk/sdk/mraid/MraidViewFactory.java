package com.adsdk.sdk.mraid;

import android.content.Context;
import com.adsdk.sdk.mraid.MraidView;
import com.adsdk.sdk.mraid.MraidView$ExpansionStyle;
import com.adsdk.sdk.mraid.MraidView$NativeCloseButtonStyle;
import com.adsdk.sdk.mraid.MraidView$PlacementType;

public class MraidViewFactory {
   protected static MraidViewFactory instance = new MraidViewFactory();

   public static MraidView create(Context var0) {
      return instance.internalCreate(var0);
   }

   public static MraidView create(Context var0, MraidView$ExpansionStyle var1, MraidView$NativeCloseButtonStyle var2, MraidView$PlacementType var3) {
      return instance.internalCreate(var0, var1, var2, var3);
   }

   @Deprecated
   public static void setInstance(MraidViewFactory var0) {
      instance = var0;
   }

   protected MraidView internalCreate(Context var1) {
      return new MraidView(var1);
   }

   protected MraidView internalCreate(Context var1, MraidView$ExpansionStyle var2, MraidView$NativeCloseButtonStyle var3, MraidView$PlacementType var4) {
      return new MraidView(var1, var2, var3, var4);
   }
}
