package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.is;
import com.flurry.sdk.jk;
import com.flurry.sdk.jt;
import com.flurry.sdk.ju$a;
import com.flurry.sdk.jw;
import com.flurry.sdk.jz;
import com.flurry.sdk.kb;
import com.flurry.sdk.pw;
import com.flurry.sdk.sh;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@kb
public class pn extends pw implements jt {
   protected final Method a;
   protected jk b;
   protected final is c;
   protected boolean d;

   public pn(Method var1, jk var2, is var3) {
      super(Object.class);
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public void a(jw var1) {
      if(this.b == null && (var1.a(ju$a.h) || Modifier.isFinal(this.a.getReturnType().getModifiers()))) {
         sh var2 = var1.a(this.a.getGenericReturnType());
         this.b = var1.a(var2, false, this.c);
         this.d = this.a(var2, this.b);
      }

   }

   public void a(Object param1, hf param2, jw param3) {
      // $FF: Couldn't be decompiled
   }

   public void a(Object param1, hf param2, jw param3, jz param4) {
      // $FF: Couldn't be decompiled
   }

   protected boolean a(sh var1, jk var2) {
      Class var3 = var1.p();
      if(var1.t()) {
         if(var3 != Integer.TYPE && var3 != Boolean.TYPE && var3 != Double.TYPE) {
            return false;
         }
      } else if(var3 != String.class && var3 != Integer.class && var3 != Boolean.class && var3 != Double.class) {
         return false;
      }

      if(var2.getClass().getAnnotation(kb.class) != null) {
         return true;
      } else {
         return false;
      }
   }

   public String toString() {
      return "(@JsonValue serializer for method " + this.a.getDeclaringClass() + "#" + this.a.getName() + ")";
   }
}
