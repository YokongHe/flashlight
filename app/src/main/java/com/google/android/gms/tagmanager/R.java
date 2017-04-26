package com.google.android.gms.tagmanager;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

final class R {
   private static com.google.android.gms.tagmanager.x a(com.google.android.gms.tagmanager.x var0) {
      try {
         com.google.android.gms.tagmanager.x var1 = new com.google.android.gms.tagmanager.x(com.google.android.gms.tagmanager.P.a((Object)URLEncoder.encode(com.google.android.gms.tagmanager.P.a((com.google.android.gms.internal.bj)var0.a()), "UTF-8").replaceAll("\\+", "%20")), var0.b());
         return var1;
      } catch (UnsupportedEncodingException var2) {
         com.google.android.gms.tagmanager.n.a("Escape URI: unsupported encoding", var2);
         return var0;
      }
   }

   static com.google.android.gms.tagmanager.x a(com.google.android.gms.tagmanager.x var0, int... var1) {
      int var3 = var1.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         int var4 = var1[var2];
         if(!(com.google.android.gms.tagmanager.P.c((com.google.android.gms.internal.bj)var0.a()) instanceof String)) {
            com.google.android.gms.tagmanager.n.a("Escaping can only be applied to strings.");
         } else {
            switch(var4) {
            case 12:
               var0 = a(var0);
               break;
            default:
               com.google.android.gms.tagmanager.n.a("Unsupported Value Escaping: " + var4);
            }
         }
      }

      return var0;
   }
}
