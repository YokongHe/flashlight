package com.adsdk.sdk.mraid;

enum MraidCommandFactory$MraidJavascriptCommand {
   CLOSE("close"),
   CREATE_CALENDAR_EVENT("createCalendarEvent"),
   EXPAND("expand"),
   GET_CURRENT_POSITION("getCurrentPosition"),
   GET_DEFAULT_POSITION("getDefaultPosition"),
   GET_MAX_SIZE("getMaxSize"),
   GET_RESIZE_PROPERTIES("getResizeProperties"),
   GET_SCREEN_SIZE("getScreenSize"),
   OPEN("open"),
   PLAY_VIDEO("playVideo"),
   RESIZE("resize"),
   SET_RESIZE_PROPERTIES("setResizeProperties"),
   STORE_PICTURE("storePicture"),
   UNSPECIFIED(""),
   USECUSTOMCLOSE("usecustomclose");

   private String mCommand;

   private MraidCommandFactory$MraidJavascriptCommand(String var3) {
      this.mCommand = var3;
   }

   // $FF: synthetic method
   static MraidCommandFactory$MraidJavascriptCommand access$2(String var0) {
      return fromString(var0);
   }

   private static MraidCommandFactory$MraidJavascriptCommand fromString(String var0) {
      MraidCommandFactory$MraidJavascriptCommand[] var5 = values();
      int var2 = var5.length;
      int var1 = 0;

      MraidCommandFactory$MraidJavascriptCommand var3;
      while(true) {
         if(var1 >= var2) {
            var3 = UNSPECIFIED;
            break;
         }

         MraidCommandFactory$MraidJavascriptCommand var4 = var5[var1];
         var3 = var4;
         if(var4.mCommand.equals(var0)) {
            break;
         }

         ++var1;
      }

      return var3;
   }

   final String getCommand() {
      return this.mCommand;
   }
}
