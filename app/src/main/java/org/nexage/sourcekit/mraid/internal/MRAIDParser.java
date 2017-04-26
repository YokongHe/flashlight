package org.nexage.sourcekit.mraid.internal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.nexage.sourcekit.mraid.internal.MRAIDLog;

public class MRAIDParser {
   private static final String TAG = "MRAIDParser";

   private boolean checkParamsForCommand(String var1, Map var2) {
      boolean var3 = true;
      if(var1.equals("createCalendarEvent")) {
         var3 = var2.containsKey("eventJSON");
      } else {
         if(var1.equals("open") || var1.equals("playVideo") || var1.equals("storePicture")) {
            return var2.containsKey("url");
         }

         if(var1.equals("setOrientationProperties")) {
            if(!var2.containsKey("allowOrientationChange") || !var2.containsKey("forceOrientation")) {
               return false;
            }
         } else if(var1.equals("setResizeProperties")) {
            if(!var2.containsKey("width") || !var2.containsKey("height") || !var2.containsKey("offsetX") || !var2.containsKey("offsetY") || !var2.containsKey("customClosePosition") || !var2.containsKey("allowOffscreen")) {
               return false;
            }
         } else if(var1.equals("useCustomClose")) {
            return var2.containsKey("useCustomClose");
         }
      }

      return var3;
   }

   private boolean isValidCommand(String var1) {
      return Arrays.asList(new String[]{"close", "createCalendarEvent", "expand", "open", "playVideo", "resize", "setOrientationProperties", "setResizeProperties", "storePicture", "useCustomClose"}).contains(var1);
   }

   public Map parseCommandUrl(String var1) {
      MRAIDLog.d("MRAIDParser", "parseCommandUrl " + var1);
      String var6 = var1.substring(8);
      HashMap var7 = new HashMap();
      int var2 = var6.indexOf(63);
      String var5;
      if(var2 != -1) {
         var5 = var6.substring(0, var2);
         String[] var10 = var6.substring(var2 + 1).split("&");
         int var3 = var10.length;

         for(var2 = 0; var2 < var3; ++var2) {
            String var8 = var10[var2];
            int var4 = var8.indexOf(61);
            var7.put(var8.substring(0, var4), var8.substring(var4 + 1));
         }
      } else {
         var5 = var6;
      }

      if(!this.isValidCommand(var5)) {
         MRAIDLog.w("command " + var5 + " is unknown");
         return null;
      } else if(!this.checkParamsForCommand(var5, var7)) {
         MRAIDLog.w("command URL " + var1 + " is missing parameters");
         return null;
      } else {
         HashMap var9 = new HashMap();
         var9.put("command", var5);
         var9.putAll(var7);
         return var9;
      }
   }
}
