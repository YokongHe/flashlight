package com.tapjoy.internal;

import android.graphics.Point;
import android.os.SystemClock;
import com.tapjoy.internal.fj;
import com.tapjoy.internal.gi;
import com.tapjoy.internal.gl;
import com.tapjoy.internal.gm;
import com.tapjoy.internal.gp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class gn extends gl {
   public static final com.tapjoy.internal.bo m = new com.tapjoy.internal.bo() {
      // $FF: synthetic method
      public final Object a(com.tapjoy.internal.bt var1) {
         return new gn(var1);
      }
   };
   public gp a;
   public gp b;
   public gp c;
   public Point d;
   public gp e;
   public gp f;
   public String g;
   public fj h;
   public ArrayList i = new ArrayList();
   public ArrayList j = new ArrayList();
   public Map k;
   public long l;

   public gn() {
   }

   gn(com.tapjoy.internal.bt var1) {
      var1.i();

      while(true) {
         while(var1.k()) {
            String var6 = var1.m();
            if("frame".equals(var6)) {
               var1.i();

               while(var1.k()) {
                  var6 = var1.m();
                  if("portrait".equals(var6)) {
                     this.a = (gp)var1.a(gp.b);
                  } else if("landscape".equals(var6)) {
                     this.b = (gp)var1.a(gp.b);
                  } else if("close_button".equals(var6)) {
                     this.c = (gp)var1.a(gp.b);
                  } else if("close_button_offset".equals(var6)) {
                     this.d = (Point)var1.a(com.tapjoy.internal.bp.a);
                  } else {
                     var1.t();
                  }
               }

               var1.j();
            } else if("creative".equals(var6)) {
               var1.i();

               while(var1.k()) {
                  var6 = var1.m();
                  if("portrait".equals(var6)) {
                     this.e = (gp)var1.a(gp.b);
                  } else if("landscape".equals(var6)) {
                     this.f = (gp)var1.a(gp.b);
                  } else {
                     var1.t();
                  }
               }

               var1.j();
            } else if("url".equals(var6)) {
               this.g = var1.c();
            } else if(gi.a(var6)) {
               this.h = gi.a(var6, var1);
            } else if(!"mappings".equals(var6)) {
               if("meta".equals(var6)) {
                  this.k = var1.e();
               } else if("ttl".equals(var6)) {
                  double var2 = var1.q();
                  long var4 = SystemClock.elapsedRealtime();
                  this.l = (long)(var2 * 1000.0D) + var4;
               } else {
                  var1.t();
               }
            } else {
               var1.i();

               while(var1.k()) {
                  var6 = var1.m();
                  if("portrait".equals(var6)) {
                     var1.a((List)this.i, (com.tapjoy.internal.bo)gm.g);
                  } else if("landscape".equals(var6)) {
                     var1.a((List)this.j, (com.tapjoy.internal.bo)gm.g);
                  } else {
                     var1.t();
                  }
               }

               var1.j();
            }
         }

         var1.j();
         if(this.g == null) {
            this.g = "";
         }

         return;
      }
   }

   public final boolean a() {
      return this.c != null && this.a != null && this.e != null;
   }

   public final boolean b() {
      return this.c != null && this.b != null && this.f != null;
   }

   public final void c() {
      if(this.a != null) {
         this.a.b();
      }

      if(this.b != null) {
         this.b.b();
      }

      this.c.b();
      if(this.e != null) {
         this.e.b();
      }

      if(this.f != null) {
         this.f.b();
      }

   }

   public final boolean d() {
      return this.c != null && this.c.a() != null && (this.b != null && this.f != null && this.b.a() != null && this.f.a() != null || this.a != null && this.e != null && this.a.a() != null && this.e.a() != null);
   }
}
