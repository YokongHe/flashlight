package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.is;
import com.flurry.sdk.jk;
import com.flurry.sdk.jt;
import com.flurry.sdk.ju$a;
import com.flurry.sdk.jw;
import com.flurry.sdk.jz;
import com.flurry.sdk.kb;
import com.flurry.sdk.ov;
import com.flurry.sdk.ov$d;
import com.flurry.sdk.pf;
import com.flurry.sdk.qs;
import com.flurry.sdk.sh;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

@kb
public class po extends pf implements jt {
   protected static final sh a = qs.b();
   protected final is b;
   protected final HashSet c;
   protected final boolean d;
   protected final sh e;
   protected final sh f;
   protected jk g;
   protected jk h;
   protected final jz i;
   protected ov j;

   protected po() {
      this((HashSet)null, (sh)null, (sh)null, false, (jz)null, (jk)null, (jk)null, (is)null);
   }

   protected po(HashSet var1, sh var2, sh var3, boolean var4, jz var5, jk var6, jk var7, is var8) {
      super(Map.class, false);
      this.b = var8;
      this.c = var1;
      this.e = var2;
      this.f = var3;
      this.d = var4;
      this.i = var5;
      this.g = var6;
      this.h = var7;
      this.j = ov.a();
   }

   public static po a(String[] var0, sh var1, boolean var2, jz var3, is var4, jk var5, jk var6) {
      HashSet var7 = a(var0);
      sh var8;
      if(var1 == null) {
         var8 = a;
         var1 = var8;
      } else {
         var8 = var1.k();
         var1 = var1.g();
      }

      if(!var2) {
         if(var1 != null && var1.u()) {
            var2 = true;
         } else {
            var2 = false;
         }
      }

      return new po(var7, var8, var1, var2, var3, var5, var6, var4);
   }

   private static HashSet a(String[] var0) {
      HashSet var3;
      if(var0 != null && var0.length != 0) {
         HashSet var4 = new HashSet(var0.length);
         int var2 = var0.length;
         int var1 = 0;

         while(true) {
            var3 = var4;
            if(var1 >= var2) {
               break;
            }

            var4.add(var0[var1]);
            ++var1;
         }
      } else {
         var3 = null;
      }

      return var3;
   }

   protected final jk a(ov var1, sh var2, jw var3) {
      ov$d var4 = var1.a(var2, var3, this.b);
      if(var1 != var4.b) {
         this.j = var4.b;
      }

      return var4.a;
   }

   protected final jk a(ov var1, Class var2, jw var3) {
      ov$d var4 = var1.a(var2, var3, this.b);
      if(var1 != var4.b) {
         this.j = var4.b;
      }

      return var4.a;
   }

   public pf a(jz var1) {
      po var2 = new po(this.c, this.e, this.f, this.d, var1, this.g, this.h, this.b);
      if(this.h != null) {
         var2.h = this.h;
      }

      return var2;
   }

   public void a(jw var1) {
      if(this.d && this.h == null) {
         this.h = var1.a(this.f, this.b);
      }

      if(this.g == null) {
         this.g = var1.b(this.e, this.b);
      }

   }

   public void a(Map var1, hf var2, jw var3) {
      var2.d();
      if(!var1.isEmpty()) {
         if(this.h != null) {
            this.a(var1, var2, var3, this.h);
         } else {
            this.b(var1, var2, var3);
         }
      }

      var2.e();
   }

   protected void a(Map param1, hf param2, jw param3, jk param4) {
      // $FF: Couldn't be decompiled
   }

   public void a(Map var1, hf var2, jw var3, jz var4) {
      var4.b(var1, var2);
      if(!var1.isEmpty()) {
         if(this.h != null) {
            this.a(var1, var2, var3, this.h);
         } else {
            this.b(var1, var2, var3);
         }
      }

      var4.e(var1, var2);
   }

   public void b(Map var1, hf var2, jw var3) {
      if(this.i != null) {
         this.c(var1, var2, var3);
      } else {
         jk var8 = this.g;
         HashSet var9 = this.c;
         boolean var4;
         if(!var3.a(ju$a.v)) {
            var4 = true;
         } else {
            var4 = false;
         }

         ov var5 = this.j;
         Iterator var10 = var1.entrySet().iterator();

         while(true) {
            Object var11;
            Object var12;
            while(true) {
               if(!var10.hasNext()) {
                  return;
               }

               Entry var6 = (Entry)var10.next();
               var11 = var6.getValue();
               var12 = var6.getKey();
               if(var12 == null) {
                  var3.c().a((Object)null, var2, var3);
                  break;
               }

               if((!var4 || var11 != null) && (var9 == null || !var9.contains(var12))) {
                  var8.a(var12, var2, var3);
                  break;
               }
            }

            if(var11 == null) {
               var3.a(var2);
            } else {
               Class var7 = var11.getClass();
               jk var15 = var5.a(var7);
               if(var15 == null) {
                  jk var14;
                  if(this.f.e()) {
                     var14 = this.a(var5, var3.a(this.f, var7), var3);
                  } else {
                     var14 = this.a(var5, var7, var3);
                  }

                  ov var16 = this.j;
                  var15 = var14;
                  var5 = var16;
               }

               try {
                  var15.a(var11, var2, var3);
               } catch (Exception var13) {
                  this.a((jw)var3, (Throwable)var13, (Object)var1, (String)("" + var12));
               }
            }
         }
      }
   }

   protected void c(Map var1, hf var2, jw var3) {
      jk var9 = this.g;
      HashSet var10 = this.c;
      boolean var4;
      if(!var3.a(ju$a.v)) {
         var4 = true;
      } else {
         var4 = false;
      }

      Iterator var11 = var1.entrySet().iterator();
      Class var6 = null;
      jk var5 = null;

      while(true) {
         while(true) {
            Object var12;
            Object var13;
            while(true) {
               if(!var11.hasNext()) {
                  return;
               }

               Entry var7 = (Entry)var11.next();
               var12 = var7.getValue();
               var13 = var7.getKey();
               if(var13 == null) {
                  var3.c().a((Object)null, var2, var3);
                  break;
               }

               if((!var4 || var12 != null) && (var10 == null || !var10.contains(var13))) {
                  var9.a(var13, var2, var3);
                  break;
               }
            }

            if(var12 == null) {
               var3.a(var2);
            } else {
               Class var17 = var12.getClass();
               jk var8;
               Class var15;
               jk var16;
               if(var17 == var6) {
                  var17 = var6;
                  var16 = var5;
                  var8 = var5;
                  var15 = var17;
               } else {
                  var8 = var3.a(var17, this.b);
                  var16 = var8;
                  var15 = var17;
               }

               jk var18;
               try {
                  var8.a(var12, var2, var3, this.i);
               } catch (Exception var14) {
                  this.a((jw)var3, (Throwable)var14, (Object)var1, (String)("" + var13));
                  var18 = var16;
                  var6 = var15;
                  var5 = var18;
                  continue;
               }

               var18 = var16;
               var6 = var15;
               var5 = var18;
            }
         }
      }
   }
}
