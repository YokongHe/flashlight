package com.millennialmedia.a.a.b;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class r {
   private static final Map a;
   private static final Map b;

   static {
      HashMap var0 = new HashMap(16);
      HashMap var1 = new HashMap(16);
      a(var0, var1, Boolean.TYPE, Boolean.class);
      a(var0, var1, Byte.TYPE, Byte.class);
      a(var0, var1, Character.TYPE, Character.class);
      a(var0, var1, Double.TYPE, Double.class);
      a(var0, var1, Float.TYPE, Float.class);
      a(var0, var1, Integer.TYPE, Integer.class);
      a(var0, var1, Long.TYPE, Long.class);
      a(var0, var1, Short.TYPE, Short.class);
      a(var0, var1, Void.TYPE, Void.class);
      a = Collections.unmodifiableMap(var0);
      b = Collections.unmodifiableMap(var1);
   }

   public static Class a(Class var0) {
      Class var1 = (Class)a.get(com.millennialmedia.a.a.b.a.a(var0));
      return var1 == null?var0:var1;
   }

   private static void a(Map var0, Map var1, Class var2, Class var3) {
      var0.put(var2, var3);
      var1.put(var3, var2);
   }

   public static boolean a(Type var0) {
      return a.containsKey(var0);
   }
}
