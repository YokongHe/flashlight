package com.nuance.nmdp.speechkit.recognitionresult;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Dictionary;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Sequence;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class b {
   private boolean a;
   private final Context b;

   public b(Object var1) {
      this.b = (Context)var1;
      this.a = Build.PRODUCT.equals("sdk");
   }

   public static .bb a(.cL var0, Map var1) {
      .bb var2 = var0.u();
      Iterator var5 = var1.entrySet().iterator();

      while(var5.hasNext()) {
         Entry var4 = (Entry)var5.next();
         String var3 = (String)var4.getKey();
         .cT var6 = (.cT)var4.getValue();
         switch(var6.f()) {
         case 0:
            var2.b(var3, var6.c());
            break;
         case 1:
            var2.b(var3, var6.d());
            break;
         case 2:
            var2.a(var3, a(var0, var6.a()));
            break;
         case 3:
            var2.a(var3, a(var0, var6.b()));
            break;
         case 4:
            var2.a(var3, var6.e());
         }
      }

      return var2;
   }

   public static .bc a(.cL var0, List var1) {
      .bc var2 = var0.v();
      Iterator var4 = var1.iterator();

      while(var4.hasNext()) {
         .cT var3 = (.cT)var4.next();
         switch(var3.f()) {
         case 0:
            var2.a(var3.c());
            break;
         case 1:
            var2.i(var3.d());
            break;
         case 2:
            var2.a(a(var0, var3.a()));
            break;
         case 3:
            var2.a(a(var0, var3.b()));
            break;
         case 4:
            var2.b(var3.e());
         }
      }

      return var2;
   }

   public static PdxValue$Dictionary a(.bb var0) {
      PdxValue$Dictionary var1 = new PdxValue$Dictionary((Map)null);
      Enumeration var2 = var0.a();

      while(var2.hasMoreElements()) {
         String var3 = (String)var2.nextElement();
         switch(var0.c(var3)) {
         case 4:
            var1.put(var3, var0.e(var3));
            break;
         case 16:
            var1.put(var3, a(var0.i(var3)));
            break;
         case 22:
            var1.put(var3, var0.g(var3));
            break;
         case 192:
            var1.put(var3, var0.d(var3));
            break;
         case 193:
            var1.put(var3, var0.f(var3));
            break;
         case 224:
            var1.put(var3, a(var0.h(var3)));
            break;
         default:
            b("PdxValue", "Unsupported PDX type found in dictionary, skipping");
         }
      }

      return var1;
   }

   private static PdxValue$Sequence a(.bc var0) {
      PdxValue$Sequence var2 = new PdxValue$Sequence((List)null);

      for(int var1 = 0; var1 < var0.a(); ++var1) {
         switch(var0.b(var1)) {
         case 4:
            var2.add(var0.d(var1));
            break;
         case 16:
            var2.add((PdxValue)a(var0.h(var1)));
            break;
         case 22:
            var2.add(var0.f(var1));
            break;
         case 192:
            var2.add(var0.c(var1));
            break;
         case 193:
            var2.add(var0.e(var1));
            break;
         case 224:
            var2.add((PdxValue)a(var0.g(var1)));
            break;
         default:
            b("PdxValue", "Unsupported PDX type found in sequence, skipping");
         }
      }

      return var2;
   }

   public static List a(byte[] var0) {
      if(var0 != null && var0.length >= 4) {
         .cn var3 = .co.a(var0);
         ArrayList var2 = new ArrayList();

         for(int var1 = 0; var1 < var3.a(); ++var1) {
            var2.add(new com.nuance.nmdp.speechkit.recognitionresult.c(var3.a(var1)));
         }

         return var2;
      } else {
         throw new IllegalArgumentException("Cannot parse results: The buffer length is too small to be containing any results.");
      }
   }

   public static void a(Object var0, String var1) {
      Log.i("SpeechKit", d(var0, var1));
   }

   public static void a(Object var0, String var1, Throwable var2) {
      Log.e("SpeechKit", d(var0, var1), var2);
   }

   public static void b(Object var0, String var1) {
      Log.w("SpeechKit", d(var0, var1));
   }

   public static void c(Object var0, String var1) {
      Log.e("SpeechKit", d(var0, var1));
   }

   private static String d(Object var0, String var1) {
      if(!.x.a && var0 != null) {
         String var3 = var0.getClass().getName();
         if(var3 != null && var3.length() != 0) {
            int var2 = var3.lastIndexOf(46);
            String var4 = var3;
            if(var2 >= 0) {
               ++var2;
               var4 = var3;
               if(var2 < var3.length()) {
                  var4 = var3.substring(var2);
               }
            }

            return var4 + ": " + var1;
         }
      }

      return var1;
   }

   public static String h() {
      return com.nuance.a.a.a.a.l.e().a();
   }

   public static String i() {
      return com.nuance.a.a.a.a.l.e().b();
   }

   public static String j() {
      return com.nuance.a.a.a.a.l.e().c();
   }

   public static String k() {
      return com.nuance.a.a.a.a.l.e().d();
   }

   public final String a() {
      String var2 = ((TelephonyManager)this.b.getSystemService("phone")).getNetworkOperatorName();
      String var1;
      if(var2 != null) {
         var1 = var2;
         if(var2.length() != 0) {
            return var1;
         }
      }

      var1 = "carrier";
      return var1;
   }

   public final String b() {
      NetworkInfo var1 = ((ConnectivityManager)this.b.getSystemService("connectivity")).getActiveNetworkInfo();
      if(var1 != null) {
         String var2 = var1.getTypeName();
         if(var2 != null && var2.length() > 0) {
            return var1.getTypeName();
         }
      }

      return null;
   }

   public final String c() {
      String var2 = (new com.nuance.a.a.a.a.l(this.b)).f();
      String var1 = var2;
      if(var2 != null) {
         var1 = var2;
         if(var2.length() == 0) {
            var1 = null;
         }
      }

      return var1;
   }

   public final .M d() {
      return !((AudioManager)this.b.getSystemService("audio")).isBluetoothScoOn() && !this.a?.M.b:.M.a;
   }

   public final .M e() {
      return ((AudioManager)this.b.getSystemService("audio")).isBluetoothScoOn()?.M.a:.M.b;
   }

   public final byte[] f() {
      try {
         ApplicationInfo var1 = this.b.getApplicationInfo();
         if(var1.name != null) {
            return var1.name.getBytes("UTF-8");
         }

         if(var1.packageName != null) {
            String[] var3 = var1.packageName.split(".");
            if(var3.length > 1) {
               byte[] var4 = var3[var3.length - 1].getBytes("UTF-8");
               return var4;
            }
         }
      } catch (UnsupportedEncodingException var2) {
         ;
      }

      return new byte[0];
   }

   public final byte[] g() {
      try {
         ApplicationInfo var1 = this.b.getApplicationInfo();
         if(var1.packageName != null) {
            byte[] var3 = var1.packageName.getBytes("UTF-8");
            return var3;
         }
      } catch (UnsupportedEncodingException var2) {
         ;
      }

      return new byte[0];
   }
}
