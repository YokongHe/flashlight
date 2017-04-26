import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public final class cd {
   public cd() {
      bh.a(this.getClass());
   }

   public static Class a(String var0) {
      try {
         Class var2 = Class.forName(var0);
         return var2;
      } catch (ClassNotFoundException var1) {
         var1.printStackTrace();
         throw new RuntimeException("getClassForName failed", var1);
      }
   }

   public static Object a(Class var0, String var1) {
      try {
         Object var3 = var0.getField(var1).get((Object)null);
         return var3;
      } catch (Exception var2) {
         var2.printStackTrace();
         throw new RuntimeException("getFieldValue failed", var2);
      }
   }

   public static Object a(Class var0, String var1, Object var2) {
      try {
         Object var4 = var0.getField(var1).get((Object)null);
         return var4;
      } catch (Exception var3) {
         return var2;
      }
   }

   public static Constructor a(Class var0, Class... var1) {
      try {
         Constructor var3 = var0.getConstructor(var1);
         return var3;
      } catch (Exception var2) {
         var2.printStackTrace();
         throw new RuntimeException("getConstructor failed", var2);
      }
   }

   public static Method a(Class var0, String var1, Class... var2) {
      try {
         Method var4 = var0.getMethod(var1, var2);
         return var4;
      } catch (Exception var3) {
         var3.printStackTrace();
         throw new RuntimeException("getMethod failed", var3);
      }
   }

   public static Method b(Class var0, String var1, Class... var2) {
      try {
         Method var4 = var0.getMethod(var1, var2);
         return var4;
      } catch (Exception var3) {
         return null;
      }
   }
}
