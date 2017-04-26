public final class cb {
   // $FF: synthetic field
   private cc a;

   cb(cc var1) {
      this.a = var1;
      super();
   }

   public final void a() {
      // $FF: Couldn't be decompiled
   }

   public final void b() {
      if(cc.e().c()) {
         cc.e().c((Object)"BluetoothHeadsetOEM reflected onServiceDisconnected()");
      }

      Object var1 = cc.a(this.a);
      synchronized(var1) {
         cc.d(this.a);
         if(!cc.b(this.a)) {
            cc.c(this.a);
            cc.a(this.a).notify();
         }

      }
   }
}
