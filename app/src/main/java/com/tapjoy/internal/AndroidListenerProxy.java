package com.tapjoy.internal;

import android.os.Looper;
import com.tapjoy.internal.AndroidListenerProxy$a;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class AndroidListenerProxy {
   public static Object getListener(Object var0) {
      InvocationHandler var1 = Proxy.getInvocationHandler(var0);
      if(var1 instanceof AndroidListenerProxy$a) {
         return AndroidListenerProxy$a.a((AndroidListenerProxy$a)var1);
      } else {
         throw new IllegalArgumentException("not a proxy instance from " + AndroidListenerProxy.class.getSimpleName());
      }
   }

   public static Object newProxyInstance(Object var0, Class var1) {
      ClassLoader var2 = var1.getClassLoader();
      AndroidListenerProxy$a var3 = new AndroidListenerProxy$a(var0, Thread.currentThread(), Looper.myLooper());
      return Proxy.newProxyInstance(var2, new Class[]{var1}, var3);
   }
}
