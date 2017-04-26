package com.millennialmedia.a.a.b;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class v {
   public static v a() {
      v var6;
      try {
         Class var8 = Class.forName("sun.misc.Unsafe");
         Field var2 = var8.getDeclaredField("theUnsafe");
         var2.setAccessible(true);
         final Object var7 = var2.get((Object)null);
         var6 = new v() {
            // $FF: synthetic field
            final Method a;

            {
               this.a = var1;
            }

            public final Object a(Class var1) {
               return this.a.invoke(var7, new Object[]{var1});
            }
         };
         return var6;
      } catch (Exception var5) {
         final Method var1;
         try {
            var1 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});
            var1.setAccessible(true);
            var6 = new v() {
               public final Object a(Class var1x) {
                  return var1.invoke((Object)null, new Object[]{var1x, Object.class});
               }
            };
            return var6;
         } catch (Exception var4) {
            try {
               var1 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});
               var1.setAccessible(true);
               final int var0 = ((Integer)var1.invoke((Object)null, new Object[]{Object.class})).intValue();
               var1 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Integer.TYPE});
               var1.setAccessible(true);
               var6 = new v() {
                  public final Object a(Class var1x) {
                     return var1.invoke((Object)null, new Object[]{var1x, Integer.valueOf(var0)});
                  }
               };
               return var6;
            } catch (Exception var3) {
               return new v() {
                  public final Object a(Class var1) {
                     throw new UnsupportedOperationException("Cannot allocate " + var1);
                  }
               };
            }
         }
      }
   }

   public abstract Object a(Class var1);
}
