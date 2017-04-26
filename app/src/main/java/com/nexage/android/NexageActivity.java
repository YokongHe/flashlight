package com.nexage.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class NexageActivity extends Activity {
   boolean a = false;
   private com.nexage.android.b.a b;
   private String c;
   private FrameLayout d;

   public final void a() {
      synchronized(this){}

      try {
         com.nexage.android.a.p.b("NexageActivity", "dismiss");
         com.nexage.android.g.a.a.a.a(this.c);
         com.nexage.android.a.o.a(true);
         this.finish();
      } finally {
         ;
      }

   }

   public final void a(ViewGroup var1) {
      ((com.nexage.android.a.h)var1).a((Context)this);
      this.d = new FrameLayout(this);
      LayoutParams var2 = new LayoutParams(-1, -1);
      var2.setMargins(0, 0, 0, 0);
      this.d.setLayoutParams(var2);
      if(var1.getParent() != null) {
         ((ViewGroup)var1.getParent()).removeView(var1);
      }

      this.d.addView(var1);
      FrameLayout var3 = (FrameLayout)this.findViewById(2130837506);
      if(var3 != null) {
         Log.v("NexageActivity", "Logging before calling close button removal");
         this.d.removeView(var3);
      }

      this.setContentView(this.d);
   }

   protected void onActivityResult(int var1, int var2, Intent var3) {
      synchronized(this){}

      try {
         super.onActivityResult(var1, var2, var3);
         com.nexage.android.a.p.b("NexageActivity onActivityResult");
         if(this.b != null && this.b.a(var1, var3)) {
            this.a();
         }
      } finally {
         ;
      }

   }

   public void onBackPressed() {
      synchronized(this){}

      try {
         this.a();
      } finally {
         ;
      }

   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      int var2 = this.getRequestedOrientation();
      com.nexage.android.a.p.b("NexageActivity", "NexageActivity orientation from manifest: " + var2);
      if(var2 == -1) {
         com.nexage.android.a.p.b("NexageActivity", "setting requested orientation to SCREEN_ORIENTATION_BEHIND");
         this.setRequestedOrientation(3);
      }

      Intent var3 = this.getIntent();
      this.c = var3.getStringExtra("com.nexage.InterstitialAdPosition");
      if(this.c == null || com.nexage.android.g.a.a.a.a(this, this.c) == null) {
         var2 = var3.getIntExtra("com.nexage.InterstitialAdID", -1);
         if(var2 != -1) {
            this.b = com.nexage.android.b.a.a(this, var2);
            if(this.b != null) {
               return;
            }
         }

         this.finish();
      }
   }

   protected void onPause() {
      super.onPause();
      this.a = true;
   }

   protected void onResume() {
      super.onResume();
      if(this.a && !com.nexage.android.b.y()) {
         this.a = false;
      }

   }
}
