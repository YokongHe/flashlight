package com.adsdk.sdk.mraid;

import com.adsdk.sdk.mraid.MraidProperty;
import com.adsdk.sdk.mraid.MraidView$PlacementType;

class MraidPlacementTypeProperty extends MraidProperty {
   private final MraidView$PlacementType mPlacementType;

   MraidPlacementTypeProperty(MraidView$PlacementType var1) {
      this.mPlacementType = var1;
   }

   public static MraidPlacementTypeProperty createWithType(MraidView$PlacementType var0) {
      return new MraidPlacementTypeProperty(var0);
   }

   public String toJsonPair() {
      return "placementType: \'" + this.mPlacementType.toString().toLowerCase() + "\'";
   }
}
