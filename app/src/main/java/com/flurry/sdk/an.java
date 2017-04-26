package com.flurry.sdk;

import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class an {
   private static final String a = com.flurry.sdk.an.class.getSimpleName();
   private com.flurry.sdk.au b = new com.flurry.sdk.au();
   private int c = 0;
   private final Map d = new HashMap();

   public List a(String param1, int param2, int param3) {
      // $FF: Couldn't be decompiled
   }

   public void a() {
      synchronized(this){}

      try {
         this.b.a();
      } finally {
         ;
      }

   }

   public void a(String var1) {
      synchronized(this){}

      try {
         this.b.a(var1);
      } finally {
         ;
      }

   }

   public void a(String var1, int var2) {
      synchronized(this){}

      try {
         this.b.a(var1, com.flurry.sdk.cc.a(), var2);
      } finally {
         ;
      }

   }

   public void a(String var1, AdUnit var2) {
      synchronized(this){}

      try {
         this.b.a(var1, com.flurry.sdk.cc.a(), var2);
      } finally {
         ;
      }

   }

   public void a(String var1, String var2) {
      synchronized(this){}

      try {
         this.b.a(var1, com.flurry.sdk.cc.a(), var2);
      } finally {
         ;
      }

   }

   public void a(String var1, List var2) {
      synchronized(this){}

      try {
         this.b.a(var1, com.flurry.sdk.cc.a(), var2);
      } finally {
         ;
      }

   }

   public void a(List param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean a(AdUnit var1) {
      return ((AdFrame)var1.d().get(0)).e().e().equals("takeover");
   }

   public void b(String var1) {
      synchronized(this){}
      if(var1 != null) {
         try {
            if(var1.length() > 0) {
               this.c = this.b.b(var1, com.flurry.sdk.cc.a());
               this.d.put(var1, Integer.valueOf(this.c));
            }
         } finally {
            ;
         }
      }

   }

   public boolean b(List var1) {
      return var1 == null || var1.size() == 0 || ((AdUnit)var1.get(0)).d().size() == 0 || ((AdFrame)((AdUnit)var1.get(0)).d().get(0)).e() == null;
   }

   public int c(String param1) {
      // $FF: Couldn't be decompiled
   }

   public List d(String param1) {
      // $FF: Couldn't be decompiled
   }
}
