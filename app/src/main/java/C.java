import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;

public final class C extends Thread {
   private Handler a = null;
   private final ArrayList b = new ArrayList();
   private final Object c;

   public C(Object var1) {
      this.c = var1;
      this.start();
   }

   public static void a() {
      Looper.myLooper().quit();
   }

   public final void a(Runnable var1, int var2) {
      if(this.a != null) {
         if(var2 > 0) {
            this.a.postDelayed(var1, (long)var2);
         } else {
            this.a.post(var1);
         }
      } else {
         this.b.add(new D(var1, var2));
      }
   }

   public final void run() {
      // $FF: Couldn't be decompiled
   }
}
