package com.facebook.ads.a;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import java.util.HashMap;
import java.util.Map;

class ac$a implements OnClickListener, OnTouchListener {
   // $FF: synthetic field
   final com.facebook.ads.a.ac a;
   private int b;
   private int c;
   private int d;
   private int e;
   private float f;
   private float g;
   private int h;
   private int i;
   private boolean j;

   private ac$a(com.facebook.ads.a.ac var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   ac$a(com.facebook.ads.a.ac var1, Object var2) {
      this(var1);
   }

   public Map a() {
      HashMap var1 = new HashMap();
      var1.put("clickX", Integer.valueOf(this.b));
      var1.put("clickY", Integer.valueOf(this.c));
      var1.put("width", Integer.valueOf(this.d));
      var1.put("height", Integer.valueOf(this.e));
      var1.put("adPositionX", Float.valueOf(this.f));
      var1.put("adPositionY", Float.valueOf(this.g));
      var1.put("visibleWidth", Integer.valueOf(this.i));
      var1.put("visibleHeight", Integer.valueOf(this.h));
      return var1;
   }

   public void onClick(View var1) {
      if(com.facebook.ads.a.ac.access$000(this.a) != null) {
         com.facebook.ads.a.ac.access$000(this.a).onAdClicked(this.a);
      }

      if(!this.j) {
         Log.e("FBAudienceNetworkLog", "No touch data recorded, please ensure touch events reach the ad View by returning false if you intercept the event.");
      }

      com.facebook.ads.a.ac.access$200(this.a).a(com.facebook.ads.a.ac.access$800(this.a), this.a(), false);
   }

   public boolean onTouch(View var1, MotionEvent var2) {
      boolean var4 = false;
      if(var2.getAction() == 0 && com.facebook.ads.a.ac.access$900(this.a) != null) {
         this.d = com.facebook.ads.a.ac.access$900(this.a).getWidth();
         this.e = com.facebook.ads.a.ac.access$900(this.a).getHeight();
         int[] var5 = new int[2];
         com.facebook.ads.a.ac.access$900(this.a).getLocationInWindow(var5);
         this.f = (float)var5[0];
         this.g = (float)var5[1];
         Rect var6 = new Rect();
         com.facebook.ads.a.ac.access$900(this.a).getGlobalVisibleRect(var6);
         this.i = var6.width();
         this.h = var6.height();
         int[] var7 = new int[2];
         var1.getLocationInWindow(var7);
         this.b = (int)var2.getX() + var7[0] - var5[0];
         int var3 = (int)var2.getY();
         this.c = var7[1] + var3 - var5[1];
         this.j = true;
      }

      if(com.facebook.ads.a.ac.access$1000(this.a) != null) {
         var4 = com.facebook.ads.a.ac.access$1000(this.a).onTouch(var1, var2);
      }

      return var4;
   }
}
