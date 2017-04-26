import android.content.Context;
import android.media.AudioManager;

final class cg extends bZ {
   private AudioManager c;

   public cg(Context var1) {
      super(var1);
      this.c = (AudioManager)this.a.getSystemService("audio");
   }

   public final void d() {
      if(!bX.c) {
         this.c.startBluetoothSco();
      }

   }

   public final void e() {
      if(!bX.c) {
         this.c.stopBluetoothSco();
      }

   }

   public final int f() {
      return this.b()?0:3;
   }

   public final int g() {
      return this.b()?bY.a:6;
   }
}
