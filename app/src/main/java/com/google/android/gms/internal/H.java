package com.google.android.gms.internal;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class H {
   public static final com.google.android.gms.internal.I a = new com.google.android.gms.internal.I() {
      public final void a(com.google.android.gms.internal.bL var1, Map var2) {
      }
   };
   public static final com.google.android.gms.internal.I b = new com.google.android.gms.internal.I() {
      public final void a(com.google.android.gms.internal.bL var1, Map var2) {
         String var11 = (String)var2.get("urls");
         if(TextUtils.isEmpty(var11)) {
            com.google.android.gms.internal.bJ.e("URLs missing in canOpenURLs GMSG.");
         } else {
            String[] var6 = var11.split(",");
            HashMap var7 = new HashMap();
            PackageManager var8 = var1.getContext().getPackageManager();
            int var4 = var6.length;

            for(int var3 = 0; var3 < var4; ++var3) {
               String var9 = var6[var3];
               String[] var12 = var9.split(";", 2);
               String var10 = var12[0].trim();
               if(var12.length > 1) {
                  var11 = var12[1].trim();
               } else {
                  var11 = "android.intent.action.VIEW";
               }

               boolean var5;
               if(var8.resolveActivity(new Intent(var11, Uri.parse(var10)), 65536) != null) {
                  var5 = true;
               } else {
                  var5 = false;
               }

               var7.put(var9, Boolean.valueOf(var5));
            }

            var1.a((String)"openableURLs", (Map)var7);
         }
      }
   };
   public static final com.google.android.gms.internal.I c = new com.google.android.gms.internal.I() {
      public final void a(com.google.android.gms.internal.bL param1, Map param2) {
         // $FF: Couldn't be decompiled
      }
   };
   public static final com.google.android.gms.internal.I d = new com.google.android.gms.internal.I() {
      public final void a(com.google.android.gms.internal.bL var1, Map var2) {
         com.google.android.gms.internal.as var3 = var1.d();
         if(var3 == null) {
            com.google.android.gms.internal.bJ.e("A GMSG tried to close something that wasn\'t an overlay.");
         } else {
            var3.a();
         }
      }
   };
   public static final com.google.android.gms.internal.I e = new com.google.android.gms.internal.I() {
      public final void a(com.google.android.gms.internal.bL var1, Map var2) {
         com.google.android.gms.internal.as var3 = var1.d();
         if(var3 == null) {
            com.google.android.gms.internal.bJ.e("A GMSG tried to use a custom close button on something that wasn\'t an overlay.");
         } else {
            var3.a("1".equals(var2.get("custom_close")));
         }
      }
   };
   public static final com.google.android.gms.internal.I f = new com.google.android.gms.internal.I() {
      public final void a(com.google.android.gms.internal.bL var1, Map var2) {
         String var3 = (String)var2.get("u");
         if(var3 == null) {
            com.google.android.gms.internal.bJ.e("URL missing from httpTrack GMSG.");
         } else {
            (new com.google.android.gms.internal.bH(var1.getContext(), var1.h().b, var3)).e();
         }
      }
   };
   public static final com.google.android.gms.internal.I g = new com.google.android.gms.internal.I() {
      public final void a(com.google.android.gms.internal.bL var1, Map var2) {
         com.google.android.gms.internal.bJ.c("Received log message: " + (String)var2.get("string"));
      }
   };
   public static final com.google.android.gms.internal.I h = new com.google.android.gms.internal.I() {
      public final void a(com.google.android.gms.internal.bL param1, Map param2) {
         // $FF: Couldn't be decompiled
      }
   };
   public static final com.google.android.gms.internal.I i = new com.google.android.gms.internal.L();
}
