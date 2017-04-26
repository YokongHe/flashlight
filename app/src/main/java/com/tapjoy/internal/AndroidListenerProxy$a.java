package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;
import com.tapjoy.internal.fp;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class AndroidListenerProxy$a implements InvocationHandler {
   private final Object a;
   private final Thread b;
   private final Looper c;

   public AndroidListenerProxy$a(Object var1, Thread var2, Looper var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public final Object invoke(Object var1, final Method var2, final Object[] var3) {
      Object var4 = null;
      if(this.b == Thread.currentThread()) {
         var1 = var2.invoke(this.a, var3);
         return var1;
      } else if(!var2.getReturnType().equals(Void.TYPE)) {
         throw new UnsupportedOperationException("method not return void: " + var2.getName());
      } else {
         Runnable var5 = new Runnable() {
            public final void run() {
               try {
                  var2.invoke(AndroidListenerProxy$a.this.a, var3);
               } catch (IllegalArgumentException var2x) {
                  throw com.tapjoy.internal.cw.a(var2x);
               } catch (IllegalAccessException var3x) {
                  throw com.tapjoy.internal.cw.a(var3x);
               } catch (InvocationTargetException var4) {
                  throw com.tapjoy.internal.cw.a(var4);
               }
            }
         };
         if(this.c != null) {
            var1 = var4;
            if((new Handler(this.c)).post(var5)) {
               return var1;
            }
         }

         if(this.b == fp.b()) {
            var1 = var4;
            if(fp.a.a(var5)) {
               return var1;
            }
         }

         Looper var6 = Looper.getMainLooper();
         if(var6 != null) {
            var1 = var4;
            if((new Handler(var6)).post(var5)) {
               return var1;
            }
         }

         return var2.invoke(this.a, var3);
      }
   }
}
