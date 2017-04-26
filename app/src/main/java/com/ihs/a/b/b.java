package com.ihs.a.b;

import android.content.Context;
import java.util.Map;

public final class b {
   private static com.ihs.a.b.a a;

   public static int a(int var0, String... var1) {
      return a.a(10000, var1);
   }

   public static String a(String var0, String... var1) {
      return a.a(var0, var1);
   }

   public static void a() {
      a.a();
   }

   public static void a(Context var0, String var1, boolean var2) {
      synchronized(com.ihs.a.b.b.class){}

      try {
         if(a == null) {
            a = new com.ihs.a.b.a();
         }

         a.a(var0, var1, var2);
      } finally {
         ;
      }

   }

   public static boolean a(String... var0) {
      return a.a(var0);
   }

   public static String b(String... var0) {
      return a.b(var0);
   }

   public static boolean b() {
      return a.b();
   }

   public static String c() {
      return a.c();
   }

   public static Map d() {
      return a.d();
   }
}
