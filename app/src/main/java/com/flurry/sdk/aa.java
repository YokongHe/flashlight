package com.flurry.sdk;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import com.flurry.sdk.fc;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class aa {
   private static final String a = com.flurry.sdk.aa.class.getSimpleName();
   private boolean b;
   private Bitmap c;
   private Bitmap d;
   private Bitmap e;
   private Bitmap f;

   private Bitmap a(InputStream var1, boolean var2) {
      if(var1 == null) {
         return null;
      } else {
         Bitmap var4 = BitmapFactory.decodeStream(var1);
         if(var4 != null) {
            short var3;
            if(var2) {
               var3 = 320;
            } else {
               var3 = 160;
            }

            var4.setDensity(var3);
         }

         return var4;
      }
   }

   private Bitmap a(String var1) {
      if(var1 != null) {
         byte[] var2 = Base64.decode(var1, 0);
         if(var2 != null) {
            return this.a(new ByteArrayInputStream(var2), false);
         }
      }

      return null;
   }

   private void a(InputStream var1, String var2) {
      if(var1 != null) {
         if(this.g()) {
            if("closeX_retina.png".equals(var2)) {
               this.c = this.a(var1, true);
               return;
            }

            if("pause_button_retina.png".equals(var2)) {
               this.d = this.a(var1, true);
               return;
            }

            if("play_button_retina.png".equals(var2)) {
               this.e = this.a(var1, true);
               return;
            }

            if("more_info_retina.png".equals(var2)) {
               this.f = this.a(var1, true);
               return;
            }
         } else {
            if("closeX.png".equals(var2)) {
               this.c = this.a(var1, false);
               return;
            }

            if("pause_button.png".equals(var2)) {
               this.d = this.a(var1, false);
               return;
            }

            if("play_button.png".equals(var2)) {
               this.e = this.a(var1, false);
               return;
            }

            if("more_info.png".equals(var2)) {
               this.f = this.a(var1, false);
               return;
            }
         }
      }

   }

   private boolean g() {
      return fc.d() >= 1.5F;
   }

   public boolean a() {
      return this.c != null && this.d != null && this.e != null && this.f != null;
   }

   public Bitmap b() {
      return this.c;
   }

   public Bitmap c() {
      return this.d;
   }

   public Bitmap d() {
      return this.e;
   }

   public Bitmap e() {
      return this.f;
   }

   public void f() {
      // $FF: Couldn't be decompiled
   }
}
