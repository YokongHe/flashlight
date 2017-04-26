package com.facebook.ads.a;

import com.facebook.ads.a.f$a;

class ac$c implements f$a {
   // $FF: synthetic field
   final com.facebook.ads.a.ac b;

   private ac$c(com.facebook.ads.a.ac var1) {
      this.b = var1;
   }

   // $FF: synthetic method
   ac$c(com.facebook.ads.a.ac var1, Object var2) {
      this(var1);
   }

   public boolean a() {
      return com.facebook.ads.a.ac.access$1300(this.b);
   }

   public void b() {
      if(com.facebook.ads.a.ac.access$100(this.b) != null) {
         com.facebook.ads.a.ac.access$100(this.b).a("on imp sent");
      }

   }

   public void c() {
      if(com.facebook.ads.a.ac.access$1400(this.b) != null) {
         com.facebook.ads.a.ac.access$1400(this.b).onLoggingImpression(this.b);
      }

   }

   public boolean d() {
      return false;
   }
}
