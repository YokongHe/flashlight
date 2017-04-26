package com.google.a.a.a;

final class b extends com.google.android.gms.ads.a {
   private final com.google.a.a.a.a a;
   private final com.google.android.gms.ads.a.d b;

   public b(com.google.a.a.a.a var1, com.google.android.gms.ads.a.d var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void onAdClosed() {
      com.google.android.gms.ads.a.d var1 = this.b;
      com.google.a.a.a.a var2 = this.a;
      var1.c();
   }

   public final void onAdFailedToLoad(int var1) {
      com.google.android.gms.ads.a.d var2 = this.b;
      com.google.a.a.a.a var3 = this.a;
      var2.a(var1);
   }

   public final void onAdLeftApplication() {
      com.google.android.gms.ads.a.d var1 = this.b;
      com.google.a.a.a.a var2 = this.a;
      var1.d();
   }

   public final void onAdLoaded() {
      com.google.android.gms.ads.a.d var1 = this.b;
      com.google.a.a.a.a var2 = this.a;
      var1.a();
   }

   public final void onAdOpened() {
      com.google.android.gms.ads.a.d var1 = this.b;
      com.google.a.a.a.a var2 = this.a;
      var1.e();
      var1 = this.b;
      var2 = this.a;
      var1.b();
   }
}
