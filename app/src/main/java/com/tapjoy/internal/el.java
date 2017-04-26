package com.tapjoy.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.WindowManager;
import com.tapjoy.internal.eh;
import com.tapjoy.internal.el$a;
import com.tapjoy.internal.ew;
import com.tapjoy.internal.ex;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

class el {
   private static final String a = el.class.getSimpleName();

   static String a() {
      StringBuilder var5 = new StringBuilder();
      ew var6 = new ew(Environment.getDataDirectory().getPath());
      long var1 = var6.b();
      long var3 = var6.c();
      float var0 = 1.0F;
      if(var3 * var1 != 0L) {
         var0 = (float)var3 * (float)var1 / 1024.0F / 1024.0F / 1024.0F;
      }

      var5.append(var0);
      var5.append(" - ");
      var5.append(Long.toString((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000L));
      String var7 = a;
      (new StringBuilder("getDeviceState: ")).append(ex.b(var5.toString()));
      return ex.b(var5.toString());
   }

   static String a(Context var0, Context var1) {
      String var4 = a;
      StringBuilder var11 = new StringBuilder();
      if(Thread.currentThread().isInterrupted()) {
         return "";
      } else {
         TelephonyManager var5 = (TelephonyManager)var1.getSystemService("phone");
         String var9 = "Unknown";
         if(var5.getPhoneType() == 1) {
            var9 = var5.getNetworkOperatorName();
         }

         var11.append(var9);
         var11.append(var5.getSimCountryIso());
         ew var10 = new ew(Environment.getDataDirectory().getPath());
         long var2 = var10.b();
         var11.append((float)var10.a() * (float)var2 / 1024.0F / 1024.0F / 1024.0F);
         eh var6 = new eh(((WindowManager)var0.getSystemService("window")).getDefaultDisplay());
         var11.append(var6.a()).append("x").append(var6.b());
         String var7 = a;
         ArrayList var8 = new ArrayList();
         Collections.addAll(var8, new String[]{"Processor", "BogoMips", "Hardware", "Serial"});
         var7 = a("/proc/cpuinfo", var8, ":");
         var9 = a;
         (new StringBuilder("getCPUInfo returned: ")).append(var7);
         var11.append(var7);
         var7 = a;
         var8 = new ArrayList();
         Collections.addAll(var8, new String[]{"MemTotal"});
         var7 = a("/proc/meminfo", var8, ":");
         var9 = a;
         (new StringBuilder("getMemInfo returned: ")).append(var7);
         var11.append(var7);
         var11.append(Build.DEVICE).append(" ").append(Build.MODEL).append(" ").append(Build.PRODUCT).append(" ").append(Build.MANUFACTURER).append(" ").append(VERSION.RELEASE);
         var7 = a;
         (new StringBuilder("getDeviceFingerprint returned: hash(")).append(var11.toString()).append(")");
         return ex.b(var11.toString());
      }
   }

   private static String a(String param0, List param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   static String a(StringBuilder var0) {
      String[] var4 = null;
      if(com.a.a.a.a.a()) {
         List var10 = com.a.a.a.a.e("/system/fonts");
         String var6 = var4;
         if(var10 != null) {
            var6 = var4;
            if(!var10.isEmpty()) {
               var6 = var4;
               if(var10.size() == 2) {
                  var6 = (String)var10.get(0);
                  var0.append((String)var10.get(1));
               }
            }
         }

         return var6;
      } else {
         ArrayList var3 = new ArrayList();
         var4 = (new File("/system/fonts/")).list();
         if(var4 != null) {
            int var2 = var4.length;

            for(int var1 = 0; var1 < var2; ++var1) {
               String var5 = var4[var1];
               if(var5 != null && var5.endsWith(".ttf")) {
                  StringBuilder var8 = new StringBuilder(var5);
                  var3.add(var8.substring(0, var8.length() - 4));
               }
            }
         }

         StringBuilder var7 = new StringBuilder();
         Iterator var9 = var3.iterator();

         while(var9.hasNext()) {
            var7.append((String)var9.next());
         }

         var0.append(var3.size());
         return ex.b(var7.toString());
      }
   }

   static String a(List param0) {
      // $FF: Couldn't be decompiled
   }

   static List a(Context var0, List var1) {
      byte var3 = 0;
      ArrayList var6 = new ArrayList();
      if(var1 != null && !var1.isEmpty()) {
         String[] var7 = com.a.a.a.a.a((String[])var1.toArray(new String[var1.size()]));
         String var8 = Build.TAGS;
         PackageManager var9 = var0.getPackageManager();
         Iterator var10 = var1.iterator();
         int var2 = 0;

         String var14;
         while(var10.hasNext()) {
            String var11 = (String)var10.next();
            if(Thread.currentThread().isInterrupted()) {
               throw new InterruptedException();
            }

            URI var15;
            try {
               var15 = new URI(var11);
            } catch (URISyntaxException var12) {
               var14 = a;
               var15 = null;
            }

            if(var15 != null) {
               boolean var5;
               if(var15.getScheme().equals("file")) {
                  var5 = (new File(var15)).exists();
               } else {
                  label74: {
                     if(var15.getScheme().equals("tags")) {
                        if(var8 != null) {
                           var14 = var15.getHost();
                           if(var14 != null && !var14.isEmpty()) {
                              var5 = var8.contains(var14);
                              break label74;
                           }
                        }
                     } else if(var15.getScheme().equals("pkg") && var9 != null) {
                        label87: {
                           var14 = var15.getHost();

                           try {
                              var9.getPackageInfo(var14, 1);
                           } catch (NameNotFoundException var13) {
                              break label87;
                           }

                           var5 = true;
                           break label74;
                        }
                     }

                     var5 = false;
                  }
               }

               if(var5) {
                  var6.add(var11);
               } else {
                  ++var2;
               }
            }
         }

         var14 = a;
         (new StringBuilder("matched ")).append(var2).append("/").append(var1.size());
         if(var7 != null && var7.length > 0) {
            int var4 = var7.length;

            for(var2 = var3; var2 < var4; ++var2) {
               var14 = var7[var2];
               var6.add("z" + var14);
            }
         }

         Collections.sort(var6);
         if(!var6.isEmpty() && Log.isLoggable(a, 3)) {
            var14 = a;
            (new StringBuilder("found ")).append(ex.a((List)var6, ";"));
         }

         return var6;
      } else {
         return var6;
      }
   }

   static boolean a(el$a var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("tzInfo cannot be null");
      } else {
         TimeZone var1 = TimeZone.getDefault();
         if(var1 != null) {
            var0.a = var1.getRawOffset() / '\uea60';
            var0.b = var1.getDSTSavings() / '\uea60';
            String var2 = a;
            (new StringBuilder("getTimeZoneInfo: dstDiff=")).append(var0.b).append(" gmfOffset=").append(var0.a);
            return true;
         } else {
            Log.w(a, "getTimeZoneInfo: FAILED");
            return false;
         }
      }
   }
}
