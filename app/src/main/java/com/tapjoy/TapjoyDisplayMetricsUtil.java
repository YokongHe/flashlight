package com.tapjoy;

import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class TapjoyDisplayMetricsUtil {
   private Context a;
   private Configuration b;
   private DisplayMetrics c;

   public TapjoyDisplayMetricsUtil(Context var1) {
      this.a = var1;
      this.c = new DisplayMetrics();
      ((WindowManager)this.a.getSystemService("window")).getDefaultDisplay().getMetrics(this.c);
      this.b = this.a.getResources().getConfiguration();
   }

   public int getScreenDensityDPI() {
      return this.c.densityDpi;
   }

   public float getScreenDensityScale() {
      return this.c.density;
   }

   public int getScreenLayoutSize() {
      return this.b.screenLayout & 15;
   }
}