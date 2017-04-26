package com.ihs.a.c.a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class o extends com.ihs.a.c.a.j {
   protected ByteArrayOutputStream l;
   protected com.ihs.a.c.a.p m;

   public o(String var1) {
      this(var1, com.ihs.a.c.b.g.a, (String)null, (com.ihs.a.c.a.p)null);
   }

   private o(String var1, com.ihs.a.c.b.g var2, String var3, com.ihs.a.c.a.p var4) {
      super(var1, var2, (String)null, (com.ihs.a.c.a.l)null);
      this.l = new ByteArrayOutputStream();
      this.m = null;
   }

   protected final void a(int var1, boolean var2, String var3) {
      super.a(var1, var2, var3);
      if(this.m != null) {
         com.ihs.a.c.a.p var4 = this.m;
      }

   }

   public void a(byte[] var1) {
      super.a(var1);

      try {
         this.l.write(var1);
      } catch (IOException var2) {
         this.a(this.c(), false, var2.getMessage());
      }
   }

   protected void b() {
      super.b();
      if(this.m != null) {
         com.ihs.a.c.a.p var1 = this.m;
         this.l.toString();
      }

   }

   protected final void f() {
      super.f();

      try {
         this.l.close();
      } catch (IOException var2) {
         var2.printStackTrace();
      }
   }

   protected final byte[] g() {
      return this.l.toByteArray();
   }
}
