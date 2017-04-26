package com.flurry.sdk;

import com.flurry.sdk.eo;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class db {
   private int a;
   private String b;
   private Map c;
   private long d;
   private boolean e;
   private boolean f;
   private long g;

   public db(int var1, String var2, Map var3, long var4, boolean var6) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var6;
      if(this.e) {
         this.f = false;
      } else {
         this.f = true;
      }
   }

   public final void a(long var1) {
      this.f = true;
      this.g = var1 - this.d;
      eo.a(3, "FlurryAgent", "Ended event \'" + this.b + "\' (" + this.d + ") after " + this.g + "ms");
   }

   public final void a(Map var1) {
      if(this.c != null && this.c.size() != 0) {
         Iterator var3 = var1.entrySet().iterator();

         while(var3.hasNext()) {
            Entry var2 = (Entry)var3.next();
            if(this.c.containsKey(var2.getKey())) {
               this.c.remove(var2.getKey());
               this.c.put(var2.getKey(), var2.getValue());
            } else {
               this.c.put(var2.getKey(), var2.getValue());
            }
         }
      } else {
         this.c = var1;
      }

   }

   public final boolean a() {
      return this.e;
   }

   public final boolean a(String var1) {
      return this.e && this.g == 0L && this.b.equals(var1);
   }

   public final void b(Map var1) {
      this.c = var1;
   }

   public final boolean b() {
      return this.f;
   }

   public final Map c() {
      return this.c;
   }

   public final int d() {
      return this.e().length;
   }

   public final byte[] e() {
      // $FF: Couldn't be decompiled
   }
}
