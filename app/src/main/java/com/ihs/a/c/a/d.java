package com.ihs.a.c.a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class d implements com.ihs.a.c.a.c {
   protected int a = -1;
   protected int b = -1;
   protected int c = 0;
   private com.ihs.a.c.a.a d;
   private String e;
   private List f;
   private com.ihs.a.c.a.k g;

   public d(String var1, com.ihs.a.c.b.g var2, com.ihs.a.c.b.e var3, String var4, com.ihs.a.c.a.e var5) {
      this.g = com.ihs.a.c.a.k.a;
      if(TextUtils.isEmpty(var1)) {
         throw new IllegalArgumentException("URL can not be empty");
      } else if(var5 == null) {
         throw new IllegalArgumentException("Listener can not be null");
      } else {
         this.f = new ArrayList();
         this.f.add(var5);
         this.e = var1;
         this.d = new com.ihs.a.c.a.a();
         this.d.a(var2);
         this.d.a(var3);
         if(var4 != null) {
            this.d.a(var4.getBytes());
         }

         this.g = com.ihs.a.c.a.k.a;
         this.b = -1;
         this.c = 0;
      }
   }

   public final com.ihs.a.c.a.f a() {
      return this.d.a();
   }

   public final void a(int var1, String var2, Map var3) {
      this.a = var1;
      if(var3.containsKey("Content-Length")) {
         this.b = Integer.parseInt((String)var3.get("Content-Length"));
      } else if(var3.containsKey("content-length")) {
         this.b = Integer.parseInt((String)var3.get("content-length"));
      }

      this.c = 0;
      Iterator var4 = (new ArrayList(this.f)).iterator();

      while(var4.hasNext()) {
         ((com.ihs.a.c.a.e)var4.next()).a(var1, var2, var3);
      }

   }

   public final void a(com.ihs.a.c.a.a var1) {
      this.g = com.ihs.a.c.a.k.c;
      if(this.a / 100 != 2) {
         this.a(new Exception("HTTP Status Code:" + this.a));
      } else {
         Iterator var2 = (new ArrayList(this.f)).iterator();

         while(var2.hasNext()) {
            ((com.ihs.a.c.a.e)var2.next()).a();
         }
      }

   }

   public final void a(com.ihs.a.c.a.e var1) {
      this.f.remove(var1);
      if(this.f.isEmpty()) {
         this.d.b();
         this.d = null;
      }

   }

   public final void a(Exception var1) {
      boolean var2;
      if(this.g == com.ihs.a.c.a.k.c) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.g = com.ihs.a.c.a.k.d;
      Iterator var3 = (new ArrayList(this.f)).iterator();

      while(var3.hasNext()) {
         ((com.ihs.a.c.a.e)var3.next()).a(var2, var1);
      }

   }

   public final void a(byte[] var1) {
      if(var1.length != 0) {
         this.c += var1.length;
         Iterator var2 = (new ArrayList(this.f)).iterator();

         while(var2.hasNext()) {
            ((com.ihs.a.c.a.e)var2.next()).a(var1);
         }
      }

   }

   protected final float b() {
      return this.b > 0 && this.c <= this.b?(float)this.c / (float)this.b:1.0F;
   }

   public final void c() {
      this.g = com.ihs.a.c.a.k.b;
      this.d.a((String)this.e, (com.ihs.a.c.a.c)this);
   }
}
