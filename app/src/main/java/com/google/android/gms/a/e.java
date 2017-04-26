package com.google.android.gms.a;

import android.os.IBinder;
import java.lang.reflect.Field;

public final class e extends com.google.android.gms.a.c {
   private final Object a;

   private e(Object var1) {
      this.a = var1;
   }

   public static com.google.android.gms.a.b a(Object var0) {
      return new com.google.android.gms.a.e(var0);
   }

   public static Object a(com.google.android.gms.a.b var0) {
      if(var0 instanceof com.google.android.gms.a.e) {
         return ((com.google.android.gms.a.e)var0).a;
      } else {
         IBinder var5 = var0.asBinder();
         Field[] var1 = var5.getClass().getDeclaredFields();
         if(var1.length == 1) {
            Field var7 = var1[0];
            if(!var7.isAccessible()) {
               var7.setAccessible(true);

               try {
                  Object var6 = var7.get(var5);
                  return var6;
               } catch (NullPointerException var2) {
                  throw new IllegalArgumentException("Binder object is null.", var2);
               } catch (IllegalArgumentException var3) {
                  throw new IllegalArgumentException("remoteBinder is the wrong class.", var3);
               } catch (IllegalAccessException var4) {
                  throw new IllegalArgumentException("Could not access the field in remoteBinder.", var4);
               }
            } else {
               throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
            }
         } else {
            throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
         }
      }
   }
}
