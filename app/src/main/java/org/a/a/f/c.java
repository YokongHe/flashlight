package org.a.a.f;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class c extends org.a.a.f.d {
   private Type a;
   private boolean b;
   private Class[] c;

   public c(String var1, Class var2, Type var3) {
      super(var1, var2);
      this.a = var3;
      boolean var4;
      if(var3 == null) {
         var4 = true;
      } else {
         var4 = false;
      }

      this.b = var4;
   }

   public final Class[] a() {
      if(!this.b) {
         if(this.a instanceof ParameterizedType) {
            Type[] var4 = ((ParameterizedType)this.a).getActualTypeArguments();
            if(var4.length > 0) {
               this.c = new Class[var4.length];

               for(int var1 = 0; var1 < var4.length; ++var1) {
                  if(var4[var1] instanceof Class) {
                     this.c[var1] = (Class)var4[var1];
                  } else if(var4[var1] instanceof ParameterizedType) {
                     this.c[var1] = (Class)((ParameterizedType)var4[var1]).getRawType();
                  } else {
                     if(!(var4[var1] instanceof GenericArrayType)) {
                        this.c = null;
                        break;
                     }

                     Type var3 = ((GenericArrayType)var4[var1]).getGenericComponentType();
                     if(!(var3 instanceof Class)) {
                        this.c = null;
                        break;
                     }

                     this.c[var1] = Array.newInstance((Class)var3, 0).getClass();
                  }
               }
            }
         } else if(this.a instanceof GenericArrayType) {
            Type var2 = ((GenericArrayType)this.a).getGenericComponentType();
            if(var2 instanceof Class) {
               this.c = new Class[]{(Class)var2};
            }
         } else if(this.a instanceof Class && ((Class)this.a).isArray()) {
            this.c = new Class[1];
            this.c[0] = this.b().getComponentType();
         }

         this.b = true;
      }

      return this.c;
   }
}
