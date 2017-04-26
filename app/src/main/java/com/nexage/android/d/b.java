package com.nexage.android.d;

import org.json.JSONObject;

public final class b {
   public String a;
   public String b;
   public String c;
   public String d;
   public String e;
   public String f;
   public String g;
   public String h;
   public boolean i;
   public String j;

   static com.nexage.android.d.b a(JSONObject var0) {
      com.nexage.android.d.b var1 = new com.nexage.android.d.b();
      var1.a = a(var0, "name");
      var1.b = a(var0, "tagId");
      var1.c = a(var0, "networkId");
      var1.d = a(var0, "siteId");
      var1.e = a(var0, "adSpaceId");
      var1.f = a(var0, "adRequestUrl");
      var1.g = a(var0, "adGetParams");
      var1.h = a(var0, "adPostParams");
      var1.i = var0.getBoolean("useSDK");
      var1.j = a(var0, "adValidateRegex");
      return var1;
   }

   private static String a(JSONObject var0, String var1) {
      try {
         String var3 = var0.getString(var1);
         return var3;
      } catch (Exception var2) {
         return null;
      }
   }
}
