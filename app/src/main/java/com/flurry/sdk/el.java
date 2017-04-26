package com.flurry.sdk;

import com.flurry.sdk.el$a;
import com.flurry.sdk.en;
import com.flurry.sdk.en$c;
import com.flurry.sdk.ex;
import java.io.InputStream;
import java.io.OutputStream;

public class el extends en {
   private el$a a;
   private Object b;
   private Object c;
   private ex d;
   private ex e;

   private void m() {
      this.a((en$c)(new en$c() {
         public void a(en var1) {
            el.this.n();
         }

         public void a(en var1, InputStream var2) {
            if(var1.d() && el.this.e != null) {
               el.this.c = el.this.e.a(var2);
            }
         }

         public void a(en var1, OutputStream var2) {
            if(el.this.b != null && el.this.d != null) {
               el.this.d.a(var2, el.this.b);
            }

         }
      }));
   }

   private void n() {
      if(this.a != null && !this.b()) {
         this.a.a(this, this.c);
      }
   }

   public void a() {
      this.m();
      super.a();
   }

   public void a(el$a var1) {
      this.a = var1;
   }

   public void a(ex var1) {
      this.d = var1;
   }

   public void a(Object var1) {
      this.b = var1;
   }

   public void b(ex var1) {
      this.e = var1;
   }
}
