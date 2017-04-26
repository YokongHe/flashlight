package com.amazon.device.ads;

import com.amazon.device.ads.ILog;
import com.amazon.device.ads.Log;
import java.util.Iterator;

class Log$LogcatLogger implements ILog {
   private static final int MAX_LENGTH = 1000;

   private Log$LogcatLogger() {
   }

   // $FF: synthetic method
   Log$LogcatLogger(Object var1) {
      this();
   }

   public void d(String var1, String var2) {
      Iterator var3 = Log.split(var2, 1000).iterator();

      while(var3.hasNext()) {
         android.util.Log.d(var1, (String)var3.next());
      }

   }

   public void d(String var1, String var2, Object... var3) {
      this.d(var1, String.format(var2, var3));
   }

   public void e(String var1, String var2) {
      Iterator var3 = Log.split(var2, 1000).iterator();

      while(var3.hasNext()) {
         android.util.Log.e(var1, (String)var3.next());
      }

   }

   public void e(String var1, String var2, Object... var3) {
      this.e(var1, String.format(var2, var3));
   }

   public void i(String var1, String var2) {
      Iterator var3 = Log.split(var2, 1000).iterator();

      while(var3.hasNext()) {
         android.util.Log.i(var1, (String)var3.next());
      }

   }

   public void i(String var1, String var2, Object... var3) {
      this.i(var1, String.format(var2, var3));
   }

   public void v(String var1, String var2) {
      Iterator var3 = Log.split(var2, 1000).iterator();

      while(var3.hasNext()) {
         android.util.Log.v(var1, (String)var3.next());
      }

   }

   public void v(String var1, String var2, Object... var3) {
      this.v(var1, String.format(var2, var3));
   }

   public void w(String var1, String var2) {
      Iterator var3 = Log.split(var2, 1000).iterator();

      while(var3.hasNext()) {
         android.util.Log.w(var1, (String)var3.next());
      }

   }

   public void w(String var1, String var2, Object... var3) {
      this.w(var1, String.format(var2, var3));
   }
}
