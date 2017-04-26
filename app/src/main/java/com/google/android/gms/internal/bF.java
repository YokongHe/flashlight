package com.google.android.gms.internal;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.view.MotionEvent;
import java.util.Iterator;
import java.util.Map;

public final class bF {
   private final Context a;
   private String b;
   private final float c;
   private float d;
   private float e;
   private float f;
   private int g;

   public bF(Context var1) {
      this.g = 0;
      this.a = var1;
      this.c = var1.getResources().getDisplayMetrics().density;
   }

   public bF(Context var1, String var2) {
      this(var1);
      this.b = var2;
   }

   private void a(int var1, float var2, float var3) {
      if(var1 == 0) {
         this.g = 0;
         this.d = var2;
         this.e = var3;
         this.f = var3;
      } else if(this.g != -1) {
         if(var1 == 2) {
            if(var3 > this.e) {
               this.e = var3;
            } else if(var3 < this.f) {
               this.f = var3;
            }

            if(this.e - this.f > 30.0F * this.c) {
               this.g = -1;
               return;
            }

            if(this.g != 0 && this.g != 2) {
               if((this.g == 1 || this.g == 3) && var2 - this.d <= -50.0F * this.c) {
                  this.d = var2;
                  ++this.g;
               }
            } else if(var2 - this.d >= 50.0F * this.c) {
               this.d = var2;
               ++this.g;
            }

            if(this.g != 1 && this.g != 3) {
               if(this.g == 2 && var2 < this.d) {
                  this.d = var2;
                  return;
               }
            } else if(var2 > this.d) {
               this.d = var2;
               return;
            }
         } else if(var1 == 1 && this.g == 4) {
            final String var8;
            if(!TextUtils.isEmpty(this.b)) {
               Uri var5 = (new Builder()).encodedQuery(this.b).build();
               StringBuilder var4 = new StringBuilder();
               Map var9 = com.google.android.gms.internal.bD.a(var5);
               Iterator var6 = var9.keySet().iterator();

               while(var6.hasNext()) {
                  String var7 = (String)var6.next();
                  var4.append(var7).append(" = ").append((String)var9.get(var7)).append("\n\n");
               }

               var8 = var4.toString().trim();
               if(TextUtils.isEmpty(var8)) {
                  var8 = "No debug information";
               }
            } else {
               var8 = "No debug information";
            }

            android.app.AlertDialog.Builder var10 = new android.app.AlertDialog.Builder(this.a);
            var10.setMessage(var8);
            var10.setTitle("Ad Information");
            var10.setPositiveButton("Share", new OnClickListener() {
               public final void onClick(DialogInterface var1, int var2) {
                  bF.this.a.startActivity(Intent.createChooser((new Intent("android.intent.action.SEND")).setType("text/plain").putExtra("android.intent.extra.TEXT", var8), "Share via"));
               }
            });
            var10.setNegativeButton("Close", new OnClickListener() {
               public final void onClick(DialogInterface var1, int var2) {
               }
            });
            var10.create().show();
            return;
         }
      }

   }

   public final void a(MotionEvent var1) {
      int var3 = var1.getHistorySize();

      for(int var2 = 0; var2 < var3; ++var2) {
         this.a(var1.getActionMasked(), var1.getHistoricalX(0, var2), var1.getHistoricalY(0, var2));
      }

      this.a(var1.getActionMasked(), var1.getX(), var1.getY());
   }

   public final void a(String var1) {
      this.b = var1;
   }
}
