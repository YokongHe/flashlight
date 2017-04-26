package com.adsdk.sdk.mraid;

import com.adsdk.sdk.mraid.MraidView;
import com.adsdk.sdk.mraid.MraidView$PlacementType;
import java.util.Map;

abstract class MraidCommand {
   protected static final String URI_KEY = "uri";
   protected Map mParams;
   protected MraidView mView;

   MraidCommand(Map var1, MraidView var2) {
      this.mParams = var1;
      this.mView = var2;
   }

   abstract void execute();

   protected boolean getBooleanFromParamsForKey(String var1) {
      return "true".equals(this.mParams.get(var1));
   }

   protected float getFloatFromParamsForKey(String var1) {
      if((String)this.mParams.get(var1) == null) {
         return 0.0F;
      } else {
         try {
            float var2 = Float.parseFloat(var1);
            return var2;
         } catch (NumberFormatException var3) {
            return 0.0F;
         }
      }
   }

   protected int getIntFromParamsForKey(String var1) {
      var1 = (String)this.mParams.get(var1);
      if(var1 == null) {
         return -1;
      } else {
         try {
            int var2 = Integer.parseInt(var1, 10);
            return var2;
         } catch (NumberFormatException var3) {
            return -1;
         }
      }
   }

   protected String getStringFromParamsForKey(String var1) {
      return (String)this.mParams.get(var1);
   }

   protected boolean isCommandDependentOnUserClick(MraidView$PlacementType var1) {
      return false;
   }
}
