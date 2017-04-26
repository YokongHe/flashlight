package com.mopub.mraid;

import com.mopub.mraid.PlacementType;

public enum MraidJavascriptCommand {
   CLOSE("close"),
   CREATE_CALENDAR_EVENT("createCalendarEvent") {
      boolean requiresClick(PlacementType var1) {
         return true;
      }
   },
   EXPAND("expand") {
      boolean requiresClick(PlacementType var1) {
         return var1 == PlacementType.INLINE;
      }
   },
   OPEN("open") {
      boolean requiresClick(PlacementType var1) {
         return true;
      }
   },
   PLAY_VIDEO("playVideo") {
      boolean requiresClick(PlacementType var1) {
         return var1 == PlacementType.INLINE;
      }
   },
   RESIZE("resize") {
      boolean requiresClick(PlacementType var1) {
         return true;
      }
   },
   SET_ORIENTATION_PROPERTIES("setOrientationProperties"),
   STORE_PICTURE("storePicture") {
      boolean requiresClick(PlacementType var1) {
         return true;
      }
   },
   UNSPECIFIED(""),
   USE_CUSTOM_CLOSE("usecustomclose");

   private final String mJavascriptString;

   private MraidJavascriptCommand(String var3) {
      this.mJavascriptString = var3;
   }

   // $FF: synthetic method
   MraidJavascriptCommand(String var3, MraidJavascriptCommand var4) {
      this(var3);
   }

   static MraidJavascriptCommand fromJavascriptString(String var0) {
      MraidJavascriptCommand[] var5 = values();
      int var2 = var5.length;
      int var1 = 0;

      MraidJavascriptCommand var3;
      while(true) {
         if(var1 >= var2) {
            var3 = UNSPECIFIED;
            break;
         }

         MraidJavascriptCommand var4 = var5[var1];
         var3 = var4;
         if(var4.mJavascriptString.equals(var0)) {
            break;
         }

         ++var1;
      }

      return var3;
   }

   boolean requiresClick(PlacementType var1) {
      return false;
   }

   String toJavascriptString() {
      return this.mJavascriptString;
   }
}
