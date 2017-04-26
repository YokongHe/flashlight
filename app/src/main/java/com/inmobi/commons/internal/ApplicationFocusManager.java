package com.inmobi.commons.internal;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.HandlerThread;
import android.os.Build.VERSION;
import com.inmobi.commons.internal.ApplicationFocusManager$FocusChangedListener;
import com.inmobi.commons.internal.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApplicationFocusManager {
   protected static final int MSG_PAUSED = 1001;
   protected static final int MSG_RESUMED = 1002;
   private static List a = new ArrayList();
   private static Object b;
   private static HandlerThread c = null;
   private static Application d;

   // $FF: synthetic method
   static void a(Boolean var0) {
      b(var0);
   }

   public static void addFocusChangedListener(ApplicationFocusManager$FocusChangedListener var0) {
      if(VERSION.SDK_INT >= 14) {
         a.add(var0);
         if(a.size() == 1) {
            b();
            return;
         }
      }

   }

   @TargetApi(14)
   private static void b() {
      // $FF: Couldn't be decompiled
   }

   private static void b(Boolean var0) {
      Iterator var1 = a.iterator();

      while(var1.hasNext()) {
         ((ApplicationFocusManager$FocusChangedListener)var1.next()).onFocusChanged(var0.booleanValue());
      }

   }

   @TargetApi(14)
   private static void c() {
      try {
         if(b != null) {
            Application.class.getMethod("unregisterActivityLifecycleCallbacks", (Class[])null).invoke(d, (Object[])b);
         }

         c.stop();
         c = null;
      } catch (Exception var1) {
         var1.printStackTrace();
         Log.internal("[InMobi]-4.5.2", "Exception unregister app lifecycle callback", var1);
      }
   }

   @SuppressLint({"NewApi"})
   public static void init(Context var0) {
      if(VERSION.SDK_INT >= 14 && d == null) {
         if(!(var0 instanceof Activity)) {
            d = (Application)var0.getApplicationContext();
            return;
         }

         d = ((Activity)var0).getApplication();
      }

   }

   public static void removeFocusChangedListener(ApplicationFocusManager$FocusChangedListener var0) {
      if(VERSION.SDK_INT >= 14) {
         a.remove(var0);
         if(a.size() == 0) {
            c();
            return;
         }
      }

   }
}
