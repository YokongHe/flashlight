package com.nexage.android.d;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
   private static ActivityManager c = null;
   private static MemoryInfo d = null;
   private static boolean e = true;
   public String a;
   public com.nexage.android.d.b[] b;
   private String f;
   private boolean g = true;

   static com.nexage.android.d.a a(JSONObject var0) {
      com.nexage.android.d.a var3 = new com.nexage.android.d.a();
      var3.a = var0.getString("name");
      JSONArray var4 = var0.getJSONArray("adTags");
      int var2 = var4.length();
      var3.b = new com.nexage.android.d.b[var2];

      for(int var1 = 0; var1 < var2; ++var1) {
         JSONObject var5 = var4.getJSONObject(var1);
         var3.b[var1] = com.nexage.android.d.b.a(var5);
      }

      if(com.nexage.android.a.p.c) {
         var3.f = var0.toString(2);
      }

      return var3;
   }

   public static boolean a(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public final com.nexage.android.a.a a(com.nexage.android.a.m param1, Activity param2, boolean param3) {
      // $FF: Couldn't be decompiled
   }

   public final void a() {
      if(com.nexage.android.a.p.c && this.g) {
         com.nexage.android.a.p.c("json tag info for position: " + this.a + ": " + this.f);
         this.g = false;
      }

   }

   public final String toString() {
      return this.a;
   }
}
