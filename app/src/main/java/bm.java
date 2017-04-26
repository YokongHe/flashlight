import java.util.Enumeration;
import java.util.Vector;

public class bm implements O, R, S, T, U, X, Z, aC, aa, ah {
   private static final ae a = bh.a(bm.class);
   private M b;
   private N c;
   private az d;
   private af e = null;
   private bd f;
   private long g;
   private aI h;
   private int i;
   private aq j;
   private boolean k = false;
   private boolean l = false;
   private boolean m = false;
   private V n;
   private Vector o;
   private int p = -1;

   public bm(az var1, bn var2, Vector var3, K var4) {
      a(var3);
      this.d = var1;
      this.b = ((bt)var2).e();
      this.j = null;
      this.e = ((bt)var2).i_();
      this.o = var3;
      this.k = a(var3, "ep.enable");
      this.l = a(var3, "NMSP_DEFINES_RECORDER_CONTINUES_ON_ENDPOINTER_AND_TIMER_STOPPING");
      this.m = a(var3, "NMSP_DEFINES_CAPTURING_CONTINUES_ON_ENDPOINTER");
      this.c = new com.nuance.a.a.a.a.a(this.e, this.b, var3);
      if(var4.equals(K.c)) {
         this.n = V.c;
      } else if(var4.equals(K.a)) {
         this.n = V.a;
      } else if(var4.equals(K.b)) {
         this.n = V.b;
      } else if(var4.equals(K.d)) {
         this.n = V.d;
      }

      aL var5 = (aL)var2.a();
      if(var5 != null) {
         aI var6 = var5.b();
         if(var6 != null) {
            this.h = var6.a("NMSPRecorder").a();
         }
      }

      this.p = 0;
   }

   // $FF: synthetic method
   static aq a(bm var0) {
      var0.j = null;
      return null;
   }

   private void a(bd var1, int var2) {
      if(a.b()) {
         a.b((Object)("RecorderImpl.handleStartRecording(" + var1 + ") _state:" + this.p));
      }

      if((new com.nuance.a.a.a.a.k(this.o)).a()) {
         this.b = ax.c(this.b);
      }

      this.i = var2;
      if(this.p == 0) {
         this.f = var1;
         N var4 = this.c;
         V var5 = this.n;
         boolean var3;
         if(this.k && var1 != null) {
            var3 = true;
         } else {
            var3 = false;
         }

         if(var4.a(var5, var3, this, this, this, this, this, this, this)) {
            if(this.k) {
               if(var1 == null) {
                  this.p = 1;
               } else {
                  this.p = 2;
               }
            } else if(var1 == null) {
               this.p = 1;
            } else {
               this.h();
               this.p = 4;
            }

            this.a((String)"STARTED", (Object)null);
            return;
         }

         if(a.e()) {
            a.e("RecorderImpl.handleStartRecording() startRecording() failed!!!");
         }

         this.p = 8;
         this.a((String)"RECORD_ERROR", (Object)null);
      }

   }

   private void a(String var1) {
      if(this.h != null) {
         this.h.a(var1).a();
      }

   }

   private void a(String var1, Object var2) {
      if(this.d != null) {
         try {
            this.d.a(this, var1, var2);
         } catch (Throwable var4) {
            if(a.e()) {
               a.e("Got an exp while calling NMSPAudioRecordListener.recorderUpdate(" + var1 + ", " + var2 + ")[" + var4.getClass().getName() + "] msg [" + var4.getMessage() + "]");
               return;
            }
         }
      }

   }

   private static void a(Vector var0) {
      if(var0 != null) {
         Enumeration var2 = var0.elements();

         while(var2.hasMoreElements()) {
            bf var1 = (bf)var2.nextElement();
            if(var1.d() != bg.a) {
               throw new IllegalArgumentException("Parameter type: " + var1.d() + " not allowed. ");
            }
         }
      }

   }

   private static boolean a(Vector var0, String var1) {
      if(var0 != null) {
         Enumeration var3 = var0.elements();

         while(var3.hasMoreElements()) {
            bf var2 = (bf)var3.nextElement();
            if(var2.d() == bg.a && var2.a().equals(var1)) {
               if((new String(var2.b())).equals("TRUE")) {
                  return true;
               }

               return false;
            }
         }
      }

      return false;
   }

   private void b(boolean var1) {
      if(a.b()) {
         a.b((Object)("RecorderImpl.handleStopRecording() _state:" + this.p));
      }

      if(this.p != 2 && this.p != 4 && this.p != 5) {
         if(this.p == 1 || this.p == 3 || this.p == 6) {
            this.c.a((aa)this);
            this.p = 7;
            return;
         }
      } else {
         if(var1) {
            this.a((String)"CAPTURE_TIMEOUT", (Object)null);
         }

         if(this.p == 4) {
            this.i();
         }

         this.c.a((aa)this);
         this.p = 9;
      }

   }

   // $FF: synthetic method
   static void c(bm var0) {
      var0.b(true);
   }

   private void h() {
      if(this.i > 0) {
         this.j = new aq() {
            // $FF: synthetic field
            private bm a = bm.this;

            public final void run() {
               bm.a(this.a);
               if(this.a.l) {
                  this.a.a(true);
               } else {
                  bm.c(this.a);
               }
            }
         };
         this.e.a(this.j, (long)this.i);
      }

   }

   private void i() {
      if(this.j != null) {
         this.e.a(this.j);
         this.j = null;
      }

   }

   private void j() {
      try {
         this.f.a((byte[])null, 0, 0, true);
      } catch (bk var2) {
         if(a.d()) {
            a.e("RecorderImpl.finishAudioSink() TransactionProcessingException:" + var2);
         }
      }

      if(a.b()) {
         a.b((Object)"RecorderImpl::finishAudioSink send the last audio buffer from recorder");
      }

   }

   public final void a() {
      if(a.b()) {
         a.b((Object)("RecorderImpl::endOfSpeechCallback() _state:" + this.p));
      }

      if(this.p == 4) {
         this.a((String)"END_OF_SPEECH", (Object)null);
         if(!this.m) {
            this.a(false);
         }
      }

   }

   public final void a(P var1) {
      if(a.b()) {
         a.b((Object)("RecorderImpl.stopCallback() _state:" + this.p));
      }

      this.a("StreamStop");
      if(this.p != 1 && this.p != 3 && this.p != 7) {
         if(this.p == 2 || this.p == 4 || this.p == 5 || this.p == 6 || this.p == 9) {
            if(this.p == 4) {
               this.i();
            }

            this.j();
            this.a((String)"STOPPED", (Object)null);
            this.p = 8;
            return;
         }
      } else {
         this.a((String)"STOPPED", (Object)null);
         this.p = 8;
      }

   }

   public final void a(bd var1) {
      if(a.b()) {
         a.b((Object)("RecorderImpl.startCapturing(" + var1 + ")"));
      }

      if(var1 == null) {
         throw new IllegalArgumentException("audioSink cannot be null.");
      } else {
         af var2 = this.e;
         ag var4 = new ag((byte)4, new Object[]{var1, new Integer('\uea60')});
         Thread var3 = Thread.currentThread();
         this.e.a();
         var2.a(var4, this, var3);
      }
   }

   public final void a(Object var1, Object var2) {
      ag var4 = (ag)var1;
      Object[] var5;
      switch(var4.a) {
      case 1:
         this.a((bd)null, 0);
         return;
      case 2:
         var5 = (Object[])var4.b;
         this.a((bd)var5[0], ((Integer)var5[1]).intValue());
         return;
      case 3:
         this.b(false);
         return;
      case 4:
         var5 = (Object[])var4.b;
         bd var6 = (bd)var5[0];
         int var3 = ((Integer)var5[1]).intValue();
         if(a.b()) {
            a.b((Object)("RecorderImpl.handleStartCapturing(" + var6 + ") _state:" + this.p));
         }

         this.i = var3;
         this.f = var6;
         if(this.p == 1) {
            if(this.k) {
               this.c.a((S)this);
               this.p = 2;
               return;
            }

            this.h();
            this.p = 4;
            return;
         } else if(this.p == 3) {
            this.p = 2;
            return;
         } else if(this.p == 6) {
            this.p = 5;
            return;
         }
      default:
         return;
      case 5:
         this.a(false);
      }
   }

   public final void a(boolean var1) {
      if(a.b()) {
         a.b((Object)("RecorderImpl.handleStopCapturing() _state:" + this.p));
      }

      if(this.p == 2) {
         this.j();
         if(var1) {
            this.a((String)"CAPTURE_TIMEOUT", (Object)null);
         }

         this.p = 3;
      } else {
         if(this.p == 4) {
            this.j();
            if(var1) {
               this.a((String)"CAPTURE_TIMEOUT", (Object)null);
            }

            if(this.p == 4) {
               this.i();
            }

            if(this.k) {
               this.c.a((T)this);
               this.p = 6;
               return;
            }

            this.p = 1;
            return;
         }

         if(this.p == 5) {
            this.j();
            this.p = 6;
            return;
         }
      }

   }

   public final void a(byte[] var1, Object var2, W var3, W var4, Float var5) {
      int var6 = 0;
      if(a.b()) {
         a.b((Object)("RecorderImpl.audioCallback() _state:" + this.p));
      }

      if(this.p == 4) {
         if(this.g == 0L) {
            this.g = System.currentTimeMillis();
            this.a("StreamStart");
         }

         M var7 = this.b;
         ax.a();
         if(ax.b(this.b)) {
            var1 = (byte[])var2;
            var6 = var4.a;
         } else if(ax.a(this.b)) {
            var6 = var3.a;
         } else {
            var1 = null;
         }

         if(a.b()) {
            a.b((Object)("========================= Recorder::audioCallback len[" + var6 + "] ======================"));
         }

         try {
            this.f.a(var1, 0, var6, false);
         } catch (bk var8) {
            if(a.d()) {
               a.d("RecorderImpl.audioCallback() TransactionProcessingException:" + var8);
            }

            this.a((String)"RECORD_ERROR", (Object)null);
            if(this.p == 4) {
               this.i();
            }

            this.c.a((aa)this);
            this.p = 7;
            return;
         }

         this.a((String)"BUFFER_RECORDED", (Object)var5);
      }

   }

   public final void b() {
      if(a.b()) {
         a.b((Object)("RecorderImpl::endPointerStartedCallback() _state:" + this.p));
      }

      if(this.p == 2) {
         this.h();
         this.p = 4;
      } else if(this.p == 3) {
         this.c.a((T)this);
         this.p = 6;
         return;
      }

   }

   public final void c() {
      if(a.b()) {
         a.b((Object)("RecorderImpl::endPointerStoppedCallback() _state:" + this.p));
      }

      if(this.p == 5) {
         this.c.a((S)this);
         this.p = 2;
      } else if(this.p == 6) {
         this.p = 1;
         return;
      }

   }

   public final void d() {
      if(a.b()) {
         a.b((Object)("RecorderImpl.errorCallback() _state:" + this.p));
      }

      if(this.p == 1 || this.p == 2 || this.p == 3 || this.p == 4 || this.p == 5 || this.p == 6) {
         if(this.p == 4) {
            this.i();
         }

         this.a((String)"RECORD_ERROR", (Object)null);
         this.p = 7;
      }

   }

   public final void e() {
      if(a.b()) {
         a.b((Object)("RecorderImpl::startOfSpeechCallback() _state:" + this.p));
      }

      if(this.p == 4) {
         this.a((String)"START_OF_SPEECH", (Object)null);
      }

   }

   public final void f() {
      if(a.b()) {
         a.b((Object)"RecorderImpl.startRecording()");
      }

      this.g = 0L;
      this.a("RecorderStart");
      af var1 = this.e;
      ag var2 = new ag((byte)1, (Object)null);
      Thread var3 = Thread.currentThread();
      this.e.a();
      var1.a(var2, this, var3);
   }

   public final void g() {
      if(a.b()) {
         a.b((Object)"RecorderImpl.stop()");
      }

      this.a("RecorderStop");
      af var1 = this.e;
      ag var2 = new ag((byte)3, (Object)null);
      Thread var3 = Thread.currentThread();
      this.e.a();
      var1.a(var2, this, var3);
   }
}
