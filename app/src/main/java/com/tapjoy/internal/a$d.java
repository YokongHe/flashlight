package com.tapjoy.internal;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.tapjoy.internal.a$l;
import java.util.ArrayList;

public final class a$d {
   Context a;
   public CharSequence b;
   public CharSequence c;
   public PendingIntent d;
   PendingIntent e;
   RemoteViews f;
   Bitmap g;
   CharSequence h;
   int i;
   int j;
   boolean k;
   a$l l;
   CharSequence m;
   int n;
   int o;
   boolean p;
   ArrayList q = new ArrayList();
   public Notification r = new Notification();

   public a$d(Context var1) {
      this.a = var1;
      this.r.when = System.currentTimeMillis();
      this.r.audioStreamType = -1;
      this.j = 0;
   }

   public final a$d a(a$l var1) {
      if(this.l != var1) {
         this.l = var1;
         if(this.l != null) {
            var1 = this.l;
            if(var1.d != this) {
               var1.d = this;
               if(var1.d != null) {
                  var1.d.a(var1);
               }
            }
         }
      }

      return this;
   }
}
