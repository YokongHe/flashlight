package com.adsdk.sdk.mraid;

import com.adsdk.sdk.mraid.MraidCommand;
import com.adsdk.sdk.mraid.MraidCommandClose;
import com.adsdk.sdk.mraid.MraidCommandCreateCalendarEvent;
import com.adsdk.sdk.mraid.MraidCommandExpand;
import com.adsdk.sdk.mraid.MraidCommandFactory$MraidJavascriptCommand;
import com.adsdk.sdk.mraid.MraidCommandGetCurrentPosition;
import com.adsdk.sdk.mraid.MraidCommandGetDefaultPosition;
import com.adsdk.sdk.mraid.MraidCommandGetMaxSize;
import com.adsdk.sdk.mraid.MraidCommandGetResizeProperties;
import com.adsdk.sdk.mraid.MraidCommandGetScreenSize;
import com.adsdk.sdk.mraid.MraidCommandOpen;
import com.adsdk.sdk.mraid.MraidCommandPlayVideo;
import com.adsdk.sdk.mraid.MraidCommandResize;
import com.adsdk.sdk.mraid.MraidCommandSetResizeProperties;
import com.adsdk.sdk.mraid.MraidCommandStorePicture;
import com.adsdk.sdk.mraid.MraidCommandUseCustomClose;
import com.adsdk.sdk.mraid.MraidView;
import java.util.Map;

class MraidCommandFactory {
   // $FF: synthetic field
   private static int[] $SWITCH_TABLE$com$adsdk$sdk$mraid$MraidCommandFactory$MraidJavascriptCommand;
   protected static MraidCommandFactory instance = new MraidCommandFactory();

   // $FF: synthetic method
   static int[] $SWITCH_TABLE$com$adsdk$sdk$mraid$MraidCommandFactory$MraidJavascriptCommand() {
      int[] var0 = $SWITCH_TABLE$com$adsdk$sdk$mraid$MraidCommandFactory$MraidJavascriptCommand;
      if(var0 != null) {
         return var0;
      } else {
         var0 = new int[MraidCommandFactory$MraidJavascriptCommand.values().length];

         try {
            var0[MraidCommandFactory$MraidJavascriptCommand.CLOSE.ordinal()] = 1;
         } catch (NoSuchFieldError var16) {
            ;
         }

         try {
            var0[MraidCommandFactory$MraidJavascriptCommand.CREATE_CALENDAR_EVENT.ordinal()] = 14;
         } catch (NoSuchFieldError var15) {
            ;
         }

         try {
            var0[MraidCommandFactory$MraidJavascriptCommand.EXPAND.ordinal()] = 2;
         } catch (NoSuchFieldError var14) {
            ;
         }

         try {
            var0[MraidCommandFactory$MraidJavascriptCommand.GET_CURRENT_POSITION.ordinal()] = 10;
         } catch (NoSuchFieldError var13) {
            ;
         }

         try {
            var0[MraidCommandFactory$MraidJavascriptCommand.GET_DEFAULT_POSITION.ordinal()] = 11;
         } catch (NoSuchFieldError var12) {
            ;
         }

         try {
            var0[MraidCommandFactory$MraidJavascriptCommand.GET_MAX_SIZE.ordinal()] = 12;
         } catch (NoSuchFieldError var11) {
            ;
         }

         try {
            var0[MraidCommandFactory$MraidJavascriptCommand.GET_RESIZE_PROPERTIES.ordinal()] = 6;
         } catch (NoSuchFieldError var10) {
            ;
         }

         try {
            var0[MraidCommandFactory$MraidJavascriptCommand.GET_SCREEN_SIZE.ordinal()] = 13;
         } catch (NoSuchFieldError var9) {
            ;
         }

         try {
            var0[MraidCommandFactory$MraidJavascriptCommand.OPEN.ordinal()] = 4;
         } catch (NoSuchFieldError var8) {
            ;
         }

         try {
            var0[MraidCommandFactory$MraidJavascriptCommand.PLAY_VIDEO.ordinal()] = 8;
         } catch (NoSuchFieldError var7) {
            ;
         }

         try {
            var0[MraidCommandFactory$MraidJavascriptCommand.RESIZE.ordinal()] = 5;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            var0[MraidCommandFactory$MraidJavascriptCommand.SET_RESIZE_PROPERTIES.ordinal()] = 7;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            var0[MraidCommandFactory$MraidJavascriptCommand.STORE_PICTURE.ordinal()] = 9;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            var0[MraidCommandFactory$MraidJavascriptCommand.UNSPECIFIED.ordinal()] = 15;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            var0[MraidCommandFactory$MraidJavascriptCommand.USECUSTOMCLOSE.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
            ;
         }

         $SWITCH_TABLE$com$adsdk$sdk$mraid$MraidCommandFactory$MraidJavascriptCommand = var0;
         return var0;
      }
   }

   public static MraidCommand create(String var0, Map var1, MraidView var2) {
      return instance.internalCreate(var0, var1, var2);
   }

   @Deprecated
   public static void setInstance(MraidCommandFactory var0) {
      instance = var0;
   }

   protected MraidCommand internalCreate(String var1, Map var2, MraidView var3) {
      MraidCommandFactory$MraidJavascriptCommand var4 = MraidCommandFactory$MraidJavascriptCommand.access$2(var1);
      switch($SWITCH_TABLE$com$adsdk$sdk$mraid$MraidCommandFactory$MraidJavascriptCommand()[var4.ordinal()]) {
      case 1:
         return new MraidCommandClose(var2, var3);
      case 2:
         return new MraidCommandExpand(var2, var3);
      case 3:
         return new MraidCommandUseCustomClose(var2, var3);
      case 4:
         return new MraidCommandOpen(var2, var3);
      case 5:
         return new MraidCommandResize(var2, var3);
      case 6:
         return new MraidCommandGetResizeProperties(var2, var3);
      case 7:
         return new MraidCommandSetResizeProperties(var2, var3);
      case 8:
         return new MraidCommandPlayVideo(var2, var3);
      case 9:
         return new MraidCommandStorePicture(var2, var3);
      case 10:
         return new MraidCommandGetCurrentPosition(var2, var3);
      case 11:
         return new MraidCommandGetDefaultPosition(var2, var3);
      case 12:
         return new MraidCommandGetMaxSize(var2, var3);
      case 13:
         return new MraidCommandGetScreenSize(var2, var3);
      case 14:
         return new MraidCommandCreateCalendarEvent(var2, var3);
      case 15:
      default:
         return null;
      }
   }
}
