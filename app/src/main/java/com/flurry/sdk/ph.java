package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.is;
import com.flurry.sdk.jk;
import com.flurry.sdk.jt;
import com.flurry.sdk.jw;
import com.flurry.sdk.jz;
import com.flurry.sdk.kb;
import com.flurry.sdk.pf;
import com.flurry.sdk.pi;
import com.flurry.sdk.pw;
import com.flurry.sdk.rb;
import com.flurry.sdk.sh;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map.Entry;

@kb
public class ph extends pf implements jt {
   protected final boolean a;
   protected final rb b;
   protected final sh c;
   protected final is d;
   protected jk e;
   protected final jz f;

   public ph(sh var1, boolean var2, rb var3, jz var4, is var5, jk var6) {
      label14: {
         boolean var7 = false;
         super(EnumMap.class, false);
         if(!var2) {
            var2 = var7;
            if(var1 == null) {
               break label14;
            }

            var2 = var7;
            if(!var1.u()) {
               break label14;
            }
         }

         var2 = true;
      }

      this.a = var2;
      this.c = var1;
      this.b = var3;
      this.f = var4;
      this.d = var5;
      this.e = var6;
   }

   public pf a(jz var1) {
      return new ph(this.c, this.a, this.b, var1, this.d, this.e);
   }

   public void a(jw var1) {
      if(this.a && this.e == null) {
         this.e = var1.a(this.c, this.d);
      }

   }

   public void a(EnumMap var1, hf var2, jw var3) {
      var2.d();
      if(!var1.isEmpty()) {
         this.b(var1, var2, var3);
      }

      var2.e();
   }

   protected void a(EnumMap var1, hf var2, jw var3, jk var4) {
      rb var6 = this.b;
      Iterator var7 = var1.entrySet().iterator();

      while(true) {
         while(var7.hasNext()) {
            Entry var8 = (Entry)var7.next();
            Enum var9 = (Enum)var8.getKey();
            rb var5 = var6;
            if(var6 == null) {
               var5 = ((pi)((pw)var3.a(var9.getDeclaringClass(), this.d))).d();
            }

            var2.a(var5.a(var9));
            Object var11 = var8.getValue();
            if(var11 == null) {
               var3.a(var2);
               var6 = var5;
            } else {
               try {
                  var4.a(var11, var2, var3);
               } catch (Exception var10) {
                  this.a((jw)var3, (Throwable)var10, (Object)var1, (String)((Enum)var8.getKey()).name());
                  var6 = var5;
                  continue;
               }

               var6 = var5;
            }
         }

         return;
      }
   }

   public void a(EnumMap var1, hf var2, jw var3, jz var4) {
      var4.b(var1, var2);
      if(!var1.isEmpty()) {
         this.b(var1, var2, var3);
      }

      var4.e(var1, var2);
   }

   protected void b(EnumMap var1, hf var2, jw var3) {
      if(this.e != null) {
         this.a(var1, var2, var3, this.e);
      } else {
         rb var7 = this.b;
         Iterator var9 = var1.entrySet().iterator();
         Class var5 = null;
         jk var4 = null;

         while(true) {
            while(var9.hasNext()) {
               Entry var10 = (Entry)var9.next();
               Enum var8 = (Enum)var10.getKey();
               rb var6 = var7;
               if(var7 == null) {
                  var6 = ((pi)((pw)var3.a(var8.getDeclaringClass(), this.d))).d();
               }

               var2.a(var6.a(var8));
               Object var11 = var10.getValue();
               if(var11 == null) {
                  var3.a(var2);
                  var7 = var6;
               } else {
                  Class var15 = var11.getClass();
                  Class var13;
                  jk var14;
                  jk var16;
                  if(var15 == var5) {
                     var15 = var5;
                     var14 = var4;
                     var16 = var4;
                     var13 = var15;
                  } else {
                     var16 = var3.a(var15, this.d);
                     var14 = var16;
                     var13 = var15;
                  }

                  try {
                     var16.a(var11, var2, var3);
                  } catch (Exception var12) {
                     this.a((jw)var3, (Throwable)var12, (Object)var1, (String)((Enum)var10.getKey()).name());
                     var16 = var14;
                     var7 = var6;
                     var5 = var13;
                     var4 = var16;
                     continue;
                  }

                  var16 = var14;
                  var7 = var6;
                  var5 = var13;
                  var4 = var16;
               }
            }

            return;
         }
      }
   }
}
