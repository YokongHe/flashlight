package com.flurry.sdk;

import com.flurry.sdk.hc;
import com.flurry.sdk.si;
import com.flurry.sdk.si$a;
import com.flurry.sdk.si$b;
import com.flurry.sdk.sp;

public final class ie {
   protected final Object a;
   protected hc b;
   protected final boolean c;
   protected final si d;
   protected byte[] e = null;
   protected byte[] f = null;
   protected char[] g = null;
   protected char[] h = null;
   protected char[] i = null;

   public ie(si var1, Object var2, boolean var3) {
      this.d = var1;
      this.a = var2;
      this.c = var3;
   }

   public final Object a() {
      return this.a;
   }

   public final void a(hc var1) {
      this.b = var1;
   }

   public final void a(byte[] var1) {
      if(var1 != null) {
         if(var1 != this.e) {
            throw new IllegalArgumentException("Trying to release buffer not owned by the context");
         }

         this.e = null;
         this.d.a(si$a.a, var1);
      }

   }

   public final void a(char[] var1) {
      if(var1 != null) {
         if(var1 != this.g) {
            throw new IllegalArgumentException("Trying to release buffer not owned by the context");
         }

         this.g = null;
         this.d.a(si$b.a, var1);
      }

   }

   public final char[] a(int var1) {
      if(this.i != null) {
         throw new IllegalStateException("Trying to call allocNameCopyBuffer() second time");
      } else {
         this.i = this.d.a(si$b.d, var1);
         return this.i;
      }
   }

   public final hc b() {
      return this.b;
   }

   public final void b(byte[] var1) {
      if(var1 != null) {
         if(var1 != this.f) {
            throw new IllegalArgumentException("Trying to release buffer not owned by the context");
         }

         this.f = null;
         this.d.a(si$a.b, var1);
      }

   }

   public final void b(char[] var1) {
      if(var1 != null) {
         if(var1 != this.h) {
            throw new IllegalArgumentException("Trying to release buffer not owned by the context");
         }

         this.h = null;
         this.d.a(si$b.b, var1);
      }

   }

   public final void c(char[] var1) {
      if(var1 != null) {
         if(var1 != this.i) {
            throw new IllegalArgumentException("Trying to release buffer not owned by the context");
         }

         this.i = null;
         this.d.a(si$b.d, var1);
      }

   }

   public final boolean c() {
      return this.c;
   }

   public final sp d() {
      return new sp(this.d);
   }

   public final byte[] e() {
      if(this.e != null) {
         throw new IllegalStateException("Trying to call allocReadIOBuffer() second time");
      } else {
         this.e = this.d.a(si$a.a);
         return this.e;
      }
   }

   public final byte[] f() {
      if(this.f != null) {
         throw new IllegalStateException("Trying to call allocWriteEncodingBuffer() second time");
      } else {
         this.f = this.d.a(si$a.b);
         return this.f;
      }
   }

   public final char[] g() {
      if(this.g != null) {
         throw new IllegalStateException("Trying to call allocTokenBuffer() second time");
      } else {
         this.g = this.d.a(si$b.a);
         return this.g;
      }
   }

   public final char[] h() {
      if(this.h != null) {
         throw new IllegalStateException("Trying to call allocConcatBuffer() second time");
      } else {
         this.h = this.d.a(si$b.b);
         return this.h;
      }
   }
}
