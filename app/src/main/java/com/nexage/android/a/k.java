package com.nexage.android.a;

final class k extends Thread {
   // $FF: synthetic field
   final com.nexage.android.a.j a;
   private String b;

   public k(com.nexage.android.a.j var1) {
      this.a = var1;
      this.b = "FetchThread-" + com.nexage.android.a.j.a(var1);
      this.setName(this.b);
      com.nexage.android.a.p.b("NAF", this.b + " created");
   }

   public final void run() {
      // $FF: Couldn't be decompiled
   }
}
