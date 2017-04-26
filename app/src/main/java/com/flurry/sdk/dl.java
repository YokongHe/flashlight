package com.flurry.sdk;

import android.content.Context;
import com.flurry.sdk.dj;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class dl {
   private static final String a = dl.class.getSimpleName();
   private static dl b;
   private final Map c = new HashMap();
   private final Map d = new WeakHashMap();
   private final Object e = new Object();
   private dj f;

   public static dl a() {
      synchronized(dl.class){}

      dl var0;
      try {
         if(b == null) {
            b = new dl();
         }

         var0 = b;
      } finally {
         ;
      }

      return var0;
   }

   public void a(Context param1) {
      // $FF: Couldn't be decompiled
   }

   public void a(Context param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   public void a(dj var1) {
      Object var2 = this.e;
      synchronized(var2) {
         this.f = var1;
      }
   }

   public void a(String param1) {
      // $FF: Couldn't be decompiled
   }

   public int b() {
      synchronized(this){}

      int var1;
      try {
         var1 = this.d.size();
      } finally {
         ;
      }

      return var1;
   }

   public dj c() {
      Object var1 = this.e;
      synchronized(var1) {
         dj var2 = this.f;
         return var2;
      }
   }

   public void d() {
      // $FF: Couldn't be decompiled
   }
}
