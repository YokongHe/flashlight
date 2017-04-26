package com.inmobi.re.container.mraidimpl;

import android.media.AudioRecord;
import com.inmobi.commons.internal.Log;
import com.inmobi.re.container.mraidimpl.AudioTriggerCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class AudioTriggerer {
   static boolean a;
   public static AudioRecord audioRecorder = null;
   static boolean b;
   static Timer c;
   public static List callbacks = new ArrayList();
   static long d = 0L;
   static long e = 50L;
   private static int[] f = new int[]{8000, 11025, 22050, '걄'};

   private static void a(double var0) {
      Iterator var2 = callbacks.iterator();

      while(var2.hasNext()) {
         AudioTriggerCallback var3 = (AudioTriggerCallback)var2.next();

         try {
            var3.audioLevel(var0);
         } catch (Exception var4) {
            Log.internal("[InMobi]-[RE]-4.5.2", "AudioTriggerer: One of the mic listeners has a problem.");
         }
      }

   }

   public static void addEventListener(AudioTriggerCallback var0) {
      callbacks.add(var0);
      if(callbacks.size() == 1) {
         b();
      }

   }

   private static void b() {
      a = true;
      audioRecorder = h();
      Timer var0 = new Timer();
      c = var0;
      var0.scheduleAtFixedRate(new TimerTask() {
         public final void run() {
            AudioTriggerer.d();
         }
      }, d, e);
   }

   private static void c() {
      a = false;
      if(audioRecorder != null) {
         if(f()) {
            b = false;
         }

         try {
            audioRecorder.stop();
            audioRecorder.release();
            c.cancel();
            c.purge();
         } catch (IllegalStateException var1) {
            var1.printStackTrace();
            return;
         } catch (RuntimeException var2) {
            var2.printStackTrace();
            return;
         }
      }

   }

   private static void d() {
      if(audioRecorder != null && audioRecorder.getState() == 1) {
         short[] var5 = new short[512];
         float[] var6 = new float[3];
         b = true;

         try {
            audioRecorder.startRecording();
         } catch (Exception var7) {
            return;
         }

         while(f()) {
            int var3 = audioRecorder.read(var5, 0, var5.length);
            int var2 = 0;

            float var0;
            float var1;
            for(var0 = 0.0F; var2 < var3; var0 = var1) {
               short var4 = (short)(var5[var2] | var5[var2 + 1]);
               var1 = var0;
               if(var4 != 0) {
                  var1 = var0 + (float)(Math.abs(var4) / var3);
               }

               var2 += 2;
            }

            var6[0] = var0;
            var0 = 0.0F;

            for(var2 = 0; var2 < 3; ++var2) {
               var0 += var6[var2];
            }

            a((double)(var0 / (float)var3 / 32.0F));
         }

         e();
      }
   }

   private static void e() {
      if(audioRecorder != null) {
         if(f()) {
            b = false;
         }

         try {
            audioRecorder.stop();
            audioRecorder.release();
         } catch (IllegalStateException var1) {
            var1.printStackTrace();
            return;
         } catch (RuntimeException var2) {
            var2.printStackTrace();
            return;
         }
      }

   }

   private static boolean f() {
      return b;
   }

   private static void g() {
      b = false;
   }

   private static AudioRecord h() {
      // $FF: Couldn't be decompiled
   }

   public static void removeEventListener(AudioTriggerCallback var0) {
      callbacks.remove(var0);
      if(callbacks.size() == 0) {
         c();
      }

   }
}
