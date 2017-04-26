package com.flurry.sdk;

import com.flurry.sdk.de$a;
import com.flurry.sdk.df;
import com.flurry.sdk.dg;
import com.flurry.sdk.do;
import com.flurry.sdk.eo;
import com.flurry.sdk.eu;
import com.flurry.sdk.ev;
import com.flurry.sdk.ff;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class de implements eu {
   protected final String d;
   Set e = new HashSet();
   dg f;
   protected String g = "defaultDataKey_";

   public de(String var1, String var2) {
      this.d = var2;
      ev.a().a((eu)this);
      this.a(var1);
   }

   protected String a(String var1, String var2) {
      return this.g + var1 + "_" + var2;
   }

   protected void a(final de$a var1) {
      this.a(new ff() {
         public void a() {
            de.this.f();
            if(var1 != null) {
               var1.a();
            }

         }
      });
   }

   protected void a(ff var1) {
      do.a().c(var1);
   }

   protected void a(final String var1) {
      this.a(new ff() {
         public void a() {
            de.this.f = new dg(var1);
         }
      });
   }

   protected void a(final String var1, final String var2, int var3) {
      this.a(new ff() {
         public void a() {
            if(!de.this.f.a(var1, var2)) {
               eo.a(6, de.this.d, "Internal error. Block wasn\'t deleted with id = " + var1);
            }

            if(!de.this.e.remove(var1)) {
               eo.a(6, de.this.d, "Internal error. Block with id = " + var1 + " was not in progress state");
            }

         }
      });
   }

   public void a(boolean var1) {
      eo.a(4, this.d, "onNetworkStateChanged : isNetworkEnable = " + var1);
      if(var1) {
         this.d();
      }

   }

   protected abstract void a(byte[] var1, String var2, String var3);

   protected void a(byte[] var1, String var2, String var3, de$a var4) {
      if(var1 != null && var1.length != 0) {
         this.c(var1, var2, var3);
         this.a(var4);
      } else {
         eo.a(6, this.d, "Report that has to be sent is EMPTY or NULL");
      }
   }

   protected void b(final String var1, String var2) {
      this.a(new ff() {
         public void a() {
            if(!de.this.e.remove(var1)) {
               eo.a(6, de.this.d, "Internal error. Block with id = " + var1 + " was not in progress state");
            }

         }
      });
   }

   public void b(byte[] var1, String var2, String var3) {
      this.a(var1, var2, var3, (de$a)null);
   }

   protected int c() {
      return this.e.size();
   }

   protected void c(String var1, String var2) {
      if(!this.f.a(var1, var2)) {
         eo.a(6, this.d, "Internal error. Block wasn\'t deleted with id = " + var1);
      }

      if(!this.e.remove(var1)) {
         eo.a(6, this.d, "Internal error. Block with id = " + var1 + " was not in progress state");
      }

   }

   protected void c(final byte[] var1, final String var2, final String var3) {
      this.a(new ff() {
         public void a() {
            de.this.d(var1, var2, var3);
         }
      });
   }

   protected String d(byte[] var1, String var2, String var3) {
      var2 = this.a(var2, var3);
      df var5 = new df();
      var5.a(var1);
      String var4 = var5.a();
      this.f.a(var5, var2);
      return var4;
   }

   protected void d() {
      this.a((de$a)null);
   }

   protected boolean e() {
      return this.c() <= 5;
   }

   protected void f() {
      if(!ev.a().c()) {
         eo.a(5, this.d, "Reports were not sent! No Internet connection!");
      } else {
         List var2 = this.f.a();
         if(var2 == null || var2.isEmpty()) {
            eo.a(4, this.d, "No more reports to send.");
            return;
         }

         Iterator var7 = var2.iterator();

         while(var7.hasNext()) {
            String var3 = (String)var7.next();
            if(!this.e()) {
               break;
            }

            List var4 = this.f.c(var3);
            eo.a(4, this.d, "Number of not sent blocks = " + var4.size());

            for(int var1 = 0; var1 < var4.size(); ++var1) {
               String var5 = (String)var4.get(var1);
               if(!this.e.contains(var5)) {
                  if(!this.e()) {
                     break;
                  }

                  byte[] var6 = (new df(var5)).b();
                  if(var6 != null && var6.length != 0) {
                     this.e.add(var5);
                     this.a(var6, var5, var3);
                  } else {
                     eo.a(6, this.d, "Internal ERROR! Report is empty!");
                     this.f.a(var5, var3);
                  }
               }
            }
         }
      }

   }
}
