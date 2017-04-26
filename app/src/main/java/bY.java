import android.media.MediaRecorder.AudioSource;

public final class bY {
   public static final int a;

   static {
      new cd();
      Integer var1 = (Integer)cd.a(AudioSource.class, "VOICE_RECOGNITION");
      Integer var0 = var1;
      if(var1 == null) {
         var0 = Integer.valueOf(0);
      }

      a = var0.intValue();
   }
}
