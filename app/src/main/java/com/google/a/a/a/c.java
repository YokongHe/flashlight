package com.google.a.a.a;

final class c extends com.google.android.gms.ads.a {
   private final com.google.a.a.a.a a;
   private final com.google.android.gms.ads.a.f b;

   public c(com.google.a.a.a.a var1, com.google.android.gms.ads.a.f var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void onAdClosed() {
      com.google.android.gms.ads.a.f var1 = this.b;
      com.google.a.a.a.a var2 = this.a;
      var1.h();
   }

   public final void onAdFailedToLoad(int var1) {
      com.google.android.gms.ads.a.f var2 = this.b;
      com.google.a.a.a.a var3 = this.a;
      var2.b(var1);
   }

   public final void onAdLeftApplication() {
      com.google.android.gms.ads.a.f var1 = this.b;
      com.google.a.a.a.a var2 = this.a;
      var1.i();
   }

   public final void onAdLoaded() {
      com.google.android.gms.ads.a.f var1 = this.b;
      com.google.a.a.a.a var2 = this.a;
      var1.f();
   }

   public final void onAdOpened() {
      com.google.android.gms.ads.a.f var1 = this.b;
      com.google.a.a.a.a var2 = this.a;
      var1.g();
   }
}
