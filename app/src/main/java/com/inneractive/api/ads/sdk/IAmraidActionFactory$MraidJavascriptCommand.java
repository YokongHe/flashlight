package com.inneractive.api.ads.sdk;

enum IAmraidActionFactory$MraidJavascriptCommand {
   a("close"),
   b("expand"),
   c("usecustomclose"),
   d("open"),
   e("resize"),
   f("getResizeProperties"),
   g("setResizeProperties"),
   h("setOrientationProperties"),
   i("playVideo"),
   j("storePicture"),
   k("getCurrentPosition"),
   l("getDefaultPosition"),
   m("getMaxSize"),
   n("getScreenSize"),
   o("createCalendarEvent"),
   p("");

   private String q;

   private IAmraidActionFactory$MraidJavascriptCommand(String var3) {
      this.q = var3;
   }

   // $FF: synthetic method
   static IAmraidActionFactory$MraidJavascriptCommand a(String var0) {
      IAmraidActionFactory$MraidJavascriptCommand[] var3 = values();
      int var2 = var3.length;

      for(int var1 = 0; var1 < var2; ++var1) {
         IAmraidActionFactory$MraidJavascriptCommand var4 = var3[var1];
         if(var4.q.equals(var0)) {
            return var4;
         }
      }

      return p;
   }

   final String a() {
      return this.q;
   }
}
