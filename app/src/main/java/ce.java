import android.content.Context;
import android.media.AudioManager;

final class ce extends bZ {
   private AudioManager c;

   public ce(Context var1) {
      super(var1);
      this.c = (AudioManager)this.a.getSystemService("audio");
   }

   public final void d() {
      this.c.startBluetoothSco();
   }

   public final void e() {
      this.c.stopBluetoothSco();
   }

   public final int f() {
      return this.b()?0:3;
   }

   public final int g() {
      return this.b()?bY.a:6;
   }
}
