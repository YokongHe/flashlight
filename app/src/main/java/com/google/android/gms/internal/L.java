package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.util.Map;

public final class L implements com.google.android.gms.internal.I {
   private static int a(DisplayMetrics var0, Map var1, String var2, int var3) {
      String var6 = (String)var1.get(var2);
      int var4 = var3;
      if(var6 != null) {
         try {
            var4 = com.google.android.gms.internal.bI.a(var0, Integer.parseInt(var6));
         } catch (NumberFormatException var5) {
            com.google.android.gms.internal.bJ.e("Could not parse " + var2 + " in a video GMSG: " + var6);
            return var3;
         }
      }

      return var4;
   }

   public final void a(com.google.android.gms.internal.bL var1, Map var2) {
      String var12 = (String)var2.get("action");
      if(var12 == null) {
         com.google.android.gms.internal.bJ.e("Action missing from video GMSG.");
      } else {
         com.google.android.gms.internal.as var11 = var1.d();
         if(var11 == null) {
            com.google.android.gms.internal.bJ.e("Could not get ad overlay for a video GMSG.");
         } else {
            boolean var7 = "new".equalsIgnoreCase(var12);
            boolean var8 = "position".equalsIgnoreCase(var12);
            int var3;
            int var4;
            DisplayMetrics var14;
            if(!var7 && !var8) {
               com.google.android.gms.internal.az var17 = var11.b();
               if(var17 == null) {
                  com.google.android.gms.internal.az.a(var1, "no_video_view", (String)null);
               } else if("click".equalsIgnoreCase(var12)) {
                  var14 = var1.getContext().getResources().getDisplayMetrics();
                  var3 = a(var14, var2, "x", 0);
                  var4 = a(var14, var2, "y", 0);
                  long var9 = SystemClock.uptimeMillis();
                  MotionEvent var16 = MotionEvent.obtain(var9, var9, 0, (float)var3, (float)var4, 0);
                  var17.a(var16);
                  var16.recycle();
               } else {
                  String var15;
                  if("controls".equalsIgnoreCase(var12)) {
                     var15 = (String)var2.get("enabled");
                     if(var15 == null) {
                        com.google.android.gms.internal.bJ.e("Enabled parameter missing from controls video GMSG.");
                     } else {
                        var17.a(Boolean.parseBoolean(var15));
                     }
                  } else if("currentTime".equalsIgnoreCase(var12)) {
                     var15 = (String)var2.get("time");
                     if(var15 == null) {
                        com.google.android.gms.internal.bJ.e("Time parameter missing from currentTime video GMSG.");
                     } else {
                        try {
                           var17.a((int)(Float.parseFloat(var15) * 1000.0F));
                        } catch (NumberFormatException var13) {
                           com.google.android.gms.internal.bJ.e("Could not parse time parameter from currentTime video GMSG: " + var15);
                        }
                     }
                  } else if("hide".equalsIgnoreCase(var12)) {
                     var17.setVisibility(4);
                  } else if("load".equalsIgnoreCase(var12)) {
                     var17.b();
                  } else if("pause".equalsIgnoreCase(var12)) {
                     var17.c();
                  } else if("play".equalsIgnoreCase(var12)) {
                     var17.d();
                  } else if("show".equalsIgnoreCase(var12)) {
                     var17.setVisibility(0);
                  } else if("src".equalsIgnoreCase(var12)) {
                     var17.a((String)var2.get("src"));
                  } else {
                     com.google.android.gms.internal.bJ.e("Unknown video action: " + var12);
                  }
               }
            } else {
               var14 = var1.getContext().getResources().getDisplayMetrics();
               var3 = a(var14, var2, "x", 0);
               var4 = a(var14, var2, "y", 0);
               int var5 = a(var14, var2, "w", -1);
               int var6 = a(var14, var2, "h", -1);
               if(var7 && var11.b() == null) {
                  var11.b(var3, var4, var5, var6);
               } else {
                  var11.a(var3, var4, var5, var6);
               }
            }
         }
      }
   }
}
