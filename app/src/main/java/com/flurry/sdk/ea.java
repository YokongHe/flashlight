package com.flurry.sdk;

import android.os.Looper;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.flurry.sdk.do;
import com.flurry.sdk.dx;
import com.flurry.sdk.fd;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public final class ea {
   private static final String a = ea.class.getSimpleName();
   private static final Set b = i();
   private static String c;

   public static String a() {
      synchronized(ea.class){}

      String var0;
      try {
         if(Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new IllegalStateException("Must be called from a background thread!");
         }

         if(TextUtils.isEmpty(c)) {
            c = g();
         }

         var0 = c;
      } finally {
         ;
      }

      return var0;
   }

   private static String a(DataInput var0) {
      return 1 != var0.readInt()?null:var0.readUTF();
   }

   private static void a(String var0, DataOutput var1) {
      var1.writeInt(1);
      var1.writeUTF(var0);
   }

   static void a(String param0, File param1) {
      // $FF: Couldn't be decompiled
   }

   static boolean a(String var0) {
      return !TextUtils.isEmpty(var0) && !c(var0.toLowerCase(Locale.US));
   }

   static String b() {
      String var0 = Secure.getString(do.a().b().getContentResolver(), "android_id");
      return !a(var0)?null:"AND" + var0;
   }

   private static String b(DataInput var0) {
      if('뗺' == var0.readUnsignedShort() && 2 == var0.readUnsignedShort()) {
         var0.readUTF();
         return var0.readUTF();
      } else {
         return null;
      }
   }

   static void b(String var0) {
      if(!TextUtils.isEmpty(var0)) {
         File var1 = do.a().b().getFileStreamPath(h());
         if(fd.a(var1)) {
            a(var0, var1);
            return;
         }
      }

   }

   static String c() {
      String var1 = e();
      String var0 = var1;
      if(TextUtils.isEmpty(var1)) {
         var1 = f();
         var0 = var1;
         if(TextUtils.isEmpty(var1)) {
            var0 = d();
         }

         b(var0);
      }

      return var0;
   }

   private static boolean c(String var0) {
      return b.contains(var0);
   }

   static String d() {
      long var0 = Double.doubleToLongBits(Math.random());
      long var2 = System.nanoTime();
      long var4 = (long)(dx.c(do.a().b()).hashCode() * 37);
      return "ID" + Long.toString(var0 + 37L * (var2 + var4), 16);
   }

   static String e() {
      // $FF: Couldn't be decompiled
   }

   static String f() {
      // $FF: Couldn't be decompiled
   }

   private static String g() {
      String var0 = b();
      return !TextUtils.isEmpty(var0)?var0:c();
   }

   private static String h() {
      return ".flurryb.";
   }

   private static Set i() {
      HashSet var0 = new HashSet();
      var0.add("null");
      var0.add("9774d56d682e549c");
      var0.add("dead00beef");
      return Collections.unmodifiableSet(var0);
   }
}
