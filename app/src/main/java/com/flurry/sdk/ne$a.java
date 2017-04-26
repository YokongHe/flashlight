package com.flurry.sdk;

import com.flurry.org.codehaus.jackson.annotate.JsonAutoDetect;
import com.flurry.org.codehaus.jackson.annotate.JsonAutoDetect$Visibility;
import com.flurry.org.codehaus.jackson.annotate.JsonMethod;
import com.flurry.sdk.mp;
import com.flurry.sdk.mq;
import com.flurry.sdk.mr;
import com.flurry.sdk.ne;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

@JsonAutoDetect(
   creatorVisibility = JsonAutoDetect$Visibility.ANY,
   fieldVisibility = JsonAutoDetect$Visibility.PUBLIC_ONLY,
   getterVisibility = JsonAutoDetect$Visibility.PUBLIC_ONLY,
   isGetterVisibility = JsonAutoDetect$Visibility.PUBLIC_ONLY,
   setterVisibility = JsonAutoDetect$Visibility.ANY
)
public class ne$a implements ne {
   protected static final ne$a a = new ne$a((JsonAutoDetect)ne$a.class.getAnnotation(JsonAutoDetect.class));
   protected final JsonAutoDetect$Visibility b;
   protected final JsonAutoDetect$Visibility c;
   protected final JsonAutoDetect$Visibility d;
   protected final JsonAutoDetect$Visibility e;
   protected final JsonAutoDetect$Visibility f;

   public ne$a(JsonAutoDetect$Visibility var1, JsonAutoDetect$Visibility var2, JsonAutoDetect$Visibility var3, JsonAutoDetect$Visibility var4, JsonAutoDetect$Visibility var5) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.e = var4;
      this.f = var5;
   }

   public ne$a(JsonAutoDetect var1) {
      JsonMethod[] var3 = var1.value();
      JsonAutoDetect$Visibility var2;
      if(a(var3, JsonMethod.GETTER)) {
         var2 = var1.getterVisibility();
      } else {
         var2 = JsonAutoDetect$Visibility.NONE;
      }

      this.b = var2;
      if(a(var3, JsonMethod.IS_GETTER)) {
         var2 = var1.isGetterVisibility();
      } else {
         var2 = JsonAutoDetect$Visibility.NONE;
      }

      this.c = var2;
      if(a(var3, JsonMethod.SETTER)) {
         var2 = var1.setterVisibility();
      } else {
         var2 = JsonAutoDetect$Visibility.NONE;
      }

      this.d = var2;
      if(a(var3, JsonMethod.CREATOR)) {
         var2 = var1.creatorVisibility();
      } else {
         var2 = JsonAutoDetect$Visibility.NONE;
      }

      this.e = var2;
      JsonAutoDetect$Visibility var4;
      if(a(var3, JsonMethod.FIELD)) {
         var4 = var1.fieldVisibility();
      } else {
         var4 = JsonAutoDetect$Visibility.NONE;
      }

      this.f = var4;
   }

   public static ne$a a() {
      return a;
   }

   private static boolean a(JsonMethod[] var0, JsonMethod var1) {
      boolean var5 = false;
      int var3 = var0.length;
      int var2 = 0;

      boolean var4;
      while(true) {
         var4 = var5;
         if(var2 >= var3) {
            break;
         }

         JsonMethod var6 = var0[var2];
         if(var6 == var1 || var6 == JsonMethod.ALL) {
            var4 = true;
            break;
         }

         ++var2;
      }

      return var4;
   }

   // $FF: synthetic method
   public ne a(JsonAutoDetect$Visibility var1) {
      return this.f(var1);
   }

   // $FF: synthetic method
   public ne a(JsonAutoDetect var1) {
      return this.b(var1);
   }

   public boolean a(mp var1) {
      return this.a(var1.e());
   }

   public boolean a(mq var1) {
      return this.a(var1.i());
   }

   public boolean a(mr var1) {
      return this.a(var1.e());
   }

   public boolean a(Field var1) {
      return this.f.isVisible(var1);
   }

   public boolean a(Member var1) {
      return this.e.isVisible(var1);
   }

   public boolean a(Method var1) {
      return this.b.isVisible(var1);
   }

   public ne$a b(JsonAutoDetect var1) {
      if(var1 == null) {
         return this;
      } else {
         JsonMethod[] var3 = var1.value();
         JsonAutoDetect$Visibility var2;
         if(a(var3, JsonMethod.GETTER)) {
            var2 = var1.getterVisibility();
         } else {
            var2 = JsonAutoDetect$Visibility.NONE;
         }

         ne$a var4 = this.f(var2);
         if(a(var3, JsonMethod.IS_GETTER)) {
            var2 = var1.isGetterVisibility();
         } else {
            var2 = JsonAutoDetect$Visibility.NONE;
         }

         var4 = var4.g(var2);
         if(a(var3, JsonMethod.SETTER)) {
            var2 = var1.setterVisibility();
         } else {
            var2 = JsonAutoDetect$Visibility.NONE;
         }

         var4 = var4.h(var2);
         if(a(var3, JsonMethod.CREATOR)) {
            var2 = var1.creatorVisibility();
         } else {
            var2 = JsonAutoDetect$Visibility.NONE;
         }

         ne$a var6 = var4.i(var2);
         JsonAutoDetect$Visibility var5;
         if(a(var3, JsonMethod.FIELD)) {
            var5 = var1.fieldVisibility();
         } else {
            var5 = JsonAutoDetect$Visibility.NONE;
         }

         return var6.j(var5);
      }
   }

   // $FF: synthetic method
   public ne b(JsonAutoDetect$Visibility var1) {
      return this.g(var1);
   }

   public boolean b(mr var1) {
      return this.b(var1.e());
   }

   public boolean b(Method var1) {
      return this.c.isVisible(var1);
   }

   // $FF: synthetic method
   public ne c(JsonAutoDetect$Visibility var1) {
      return this.h(var1);
   }

   public boolean c(mr var1) {
      return this.c(var1.e());
   }

   public boolean c(Method var1) {
      return this.d.isVisible(var1);
   }

   // $FF: synthetic method
   public ne d(JsonAutoDetect$Visibility var1) {
      return this.i(var1);
   }

   // $FF: synthetic method
   public ne e(JsonAutoDetect$Visibility var1) {
      return this.j(var1);
   }

   public ne$a f(JsonAutoDetect$Visibility var1) {
      if(var1 == JsonAutoDetect$Visibility.DEFAULT) {
         var1 = a.b;
      }

      return this.b == var1?this:new ne$a(var1, this.c, this.d, this.e, this.f);
   }

   public ne$a g(JsonAutoDetect$Visibility var1) {
      if(var1 == JsonAutoDetect$Visibility.DEFAULT) {
         var1 = a.c;
      }

      return this.c == var1?this:new ne$a(this.b, var1, this.d, this.e, this.f);
   }

   public ne$a h(JsonAutoDetect$Visibility var1) {
      if(var1 == JsonAutoDetect$Visibility.DEFAULT) {
         var1 = a.d;
      }

      return this.d == var1?this:new ne$a(this.b, this.c, var1, this.e, this.f);
   }

   public ne$a i(JsonAutoDetect$Visibility var1) {
      if(var1 == JsonAutoDetect$Visibility.DEFAULT) {
         var1 = a.e;
      }

      return this.e == var1?this:new ne$a(this.b, this.c, this.d, var1, this.f);
   }

   public ne$a j(JsonAutoDetect$Visibility var1) {
      if(var1 == JsonAutoDetect$Visibility.DEFAULT) {
         var1 = a.f;
      }

      return this.f == var1?this:new ne$a(this.b, this.c, this.d, this.e, var1);
   }

   public String toString() {
      return "[Visibility: getter: " + this.b + ", isGetter: " + this.c + ", setter: " + this.d + ", creator: " + this.e + ", field: " + this.f + "]";
   }
}
