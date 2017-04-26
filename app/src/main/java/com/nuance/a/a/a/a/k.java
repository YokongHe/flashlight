package com.nuance.a.a.a.a;

import android.content.Context;
import java.util.Vector;

public final class k {
   private .ae a = .bh.a(this.getClass());
   private Context b = null;
   private boolean c = false;

   public k(Vector var1) {
      if(var1 != null) {
         for(int var2 = 0; var2 < var1.size(); ++var2) {
            .bf var3 = (.bf)var1.get(var2);
            String var4 = var3.a();
            if(var3.d() == .bg.a) {
               if(var4.equals("Android_Context")) {
                  this.b = (Context)var3.c();
                  if(this.a.b()) {
                     this.a.b((Object)("NMSP_DEFINES_ANDROID_CONTEXT is passed in as" + this.b));
                  }
               } else if(var4.equals("Disable_Bluetooth") && (new String(var3.b())).equalsIgnoreCase("TRUE")) {
                  if(this.a.b()) {
                     this.a.b((Object)"Disable_Bluetooth is true.");
                  }

                  this.c = true;
               }
            }
         }
      }

   }

   public final boolean a() {
      if(!this.c) {
         if(this.b != null) {
            .bZ var2 = .bZ.a(this.b);
            boolean var1 = var2.b();
            var2.c();
            return var1;
         }

         if(this.a.e()) {
            this.a.e("ANDROID_CONTEXT parameter is not passed in!!!");
            return false;
         }
      }

      return false;
   }
}
