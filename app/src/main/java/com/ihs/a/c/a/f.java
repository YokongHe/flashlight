package com.ihs.a.c.a;

import android.os.Build;
import android.os.Build.VERSION;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

final class f {
   int a = 0;
   int b = 0;
   Boolean c = Boolean.valueOf(true);
   Boolean d = Boolean.valueOf(true);
   com.ihs.a.c.b.g e;
   com.ihs.a.c.a.g f;
   String g;
   int h;
   int i;
   String j;
   File k;
   byte[] l;
   InputStream m;
   List n;
   private com.ihs.a.c.a.a o;

   public f(com.ihs.a.c.a.a var1) {
      this.e = com.ihs.a.c.b.g.a;
      this.f = new com.ihs.a.c.a.g();
      this.g = "HSHttpURLConnection (" + Build.MANUFACTURER + " " + Build.MODEL + "; Android " + VERSION.RELEASE + "/" + VERSION.SDK_INT + ")";
      this.h = 8192;
      this.i = 8192;
      this.n = new ArrayList();
      this.o = var1;
   }

   final com.ihs.a.c.a.a a() {
      return this.o;
   }

   public final com.ihs.a.c.a.f a(byte[] var1) {
      if(var1 == null) {
         return this;
      } else {
         this.l = null;
         this.k = null;
         this.m = null;
         this.l = var1;
         return this;
      }
   }
}
