package com.nuance.a.a.a.a;

import android.content.Context;
import android.media.AudioRecord;
import android.media.AudioTrack;
import java.util.Vector;

public final class a implements .N, .ah {
   private static Object C = new Object();
   private static Object D = new Object();
   private static Object E = new Object();
   private static final Integer P;
   private static final Integer Q;
   private static final Integer R;
   public static boolean a;
   public static Object b;
   public static Object c;
   public static int d;
   public static int e;
   private com.nuance.a.a.a.a.d A;
   private com.nuance.a.a.a.a.e B;
   private com.nuance.a.a.a.a.f F = null;
   private short[] G;
   private byte[] H;
   private int I;
   private int J;
   private int K;
   private com.nuance.a.a.a.a.c L;
   private boolean M = false;
   private .af N;
   private boolean O = false;
   private Context S = null;
   private .bZ T = null;
   private .M U;
   private .ae f = .bh.a(this.getClass());
   private int g;
   private int h;
   private int i;
   private int j;
   private int k;
   private int l;
   private int m;
   private int n;
   private int o;
   private int p;
   private int q;
   private int r;
   private int s;
   private int t;
   private int u;
   private int v;
   private int w;
   private int x;
   private int y;
   private int z;

   static {
      System.loadLibrary("nmsp_speex");
      a = false;
      b = new Object();
      c = new Object();
      d = 0;
      e = 0;
      P = new Integer(1);
      Q = new Integer(2);
      R = new Integer(3);
   }

   public a(.af var1, .M var2, Vector var3) {
      this.U = var2;
      this.a(var2);
      this.N = var1;
      this.F = new com.nuance.a.a.a.a.f();
      this.F.a(var3);
      if(var3 != null) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            .bf var5 = (.bf)var3.get(var4);
            String var6 = var5.a();
            if(var5.d() == .bg.a) {
               if(var6.equals("USE_ENERGY_LEVEL")) {
                  if((new String(var5.b())).equalsIgnoreCase("TRUE")) {
                     if(this.f.b()) {
                        this.f.b((Object)"Use energy level is activated.");
                     }

                     this.M = true;
                  }
               } else if(var6.equals("NMSP_DEFINES_RECORDER_CONTINUES_ON_ENDPOINTER_AND_TIMER_STOPPING")) {
                  if((new String(var5.b())).equalsIgnoreCase("TRUE")) {
                     if(this.f.b()) {
                        this.f.b((Object)"_continuesOnEndPointerAndTimerStopping is activated.");
                     }

                     this.O = true;
                  }
               } else if(var6.equals("NMSP_DEFINES_CAPTURING_CONTINUES_ON_ENDPOINTER")) {
                  if((new String(var5.b())).equalsIgnoreCase("TRUE") && this.f.b()) {
                     this.f.b((Object)"_capturingContinuesOnEndPointer is activated.");
                  }
               } else if(var6.equals("Android_Context")) {
                  this.S = (Context)var5.c();
                  if(this.f.b()) {
                     this.f.b((Object)("NMSP_DEFINES_ANDROID_CONTEXT is passed in as" + this.S));
                  }
               }
            }
         }
      }

   }

   // $FF: synthetic method
   static boolean A(com.nuance.a.a.a.a.a var0) {
      return var0.M;
   }

   // $FF: synthetic method
   static boolean B(com.nuance.a.a.a.a.a var0) {
      return var0.O;
   }

   // $FF: synthetic method
   static int C(com.nuance.a.a.a.a.a var0) {
      return var0.v;
   }

   public static native int a(int var0, int var1, int var2);

   public static native int a(int var0, int var1, int var2, int var3, int var4);

   public static native int a(byte[] var0, int var1, short[] var2, int var3);

   public static native int a(short[] var0, byte[] var1, int var2);

   // $FF: synthetic method
   static .bZ a(com.nuance.a.a.a.a.a var0) {
      return var0.T;
   }

   public static native String a(int var0);

   private void a(.M var1) {
      label58: {
         if(var1 != .M.d) {
            if(var1 == .M.e) {
               this.L = com.nuance.a.a.a.a.c.b;
               this.K = 11000;
               this.I = -1;
               this.J = -1;
               break label58;
            }

            if(var1 == .M.f) {
               this.L = com.nuance.a.a.a.a.c.b;
               this.K = 16000;
               this.I = -1;
               this.J = -1;
               break label58;
            }

            if(var1 == .M.g) {
               this.L = com.nuance.a.a.a.a.c.b;
               this.K = 32000;
               this.I = -1;
               this.J = -1;
               break label58;
            }

            if(var1 == .M.a) {
               this.L = com.nuance.a.a.a.a.c.a;
               this.K = 8000;
               this.J = 6;
               this.I = 0;
               break label58;
            }

            if(var1 == .M.b) {
               this.L = com.nuance.a.a.a.a.c.a;
               this.K = 16000;
               this.J = 8;
               this.I = 1;
               break label58;
            }

            if(var1 == .M.c) {
               this.L = com.nuance.a.a.a.a.c.a;
               this.K = 16000;
               this.J = 8;
               this.I = 1;
               break label58;
            }

            if(this.f.e()) {
               this.f.e("Codec " + var1 + " is not handled, using PCM_16_8K by default.");
            }
         }

         this.L = com.nuance.a.a.a.a.c.b;
         this.K = 8000;
         this.I = -1;
         this.J = -1;
      }

      this.h = 1;
      this.i = this.K;
      this.q = 750;
      this.r = this.q * this.i / 1000;
      this.s = this.r << 1;
      this.j = 300;
      this.k = this.i * this.j / 1000;
      this.l = this.k << 1;
      int var2 = this.l * 5;
      int var3 = AudioTrack.getMinBufferSize(this.i, 2, 2);
      if(var3 != -2 && var3 != -1 && var3 > var2) {
         this.n = var3;
      } else {
         this.n = var2;
      }

      this.m = this.n / 2;
      this.o = 500;
      this.p = this.i * this.o / 1000;
      this.u = this.K;
      this.v = 100;
      this.w = this.u * this.v / 1000;
      this.x = this.w << 1;
      var2 = this.x * 3;
      var3 = AudioRecord.getMinBufferSize(this.u, 2, 2);
      if(var3 != -2 && var3 != -1 && var3 > var2) {
         this.y = var3;
      } else {
         this.y = var2;
      }

      this.z = this.x;
   }

   // $FF: synthetic method
   static byte[] a(com.nuance.a.a.a.a.a var0, byte[] var1) {
      var0.H = var1;
      return var1;
   }

   // $FF: synthetic method
   static short[] a(com.nuance.a.a.a.a.a var0, short[] var1) {
      var0.G = var1;
      return var1;
   }

   // $FF: synthetic method
   static void b(com.nuance.a.a.a.a.a var0) {
      var0.l();
   }

   // $FF: synthetic method
   static int c(com.nuance.a.a.a.a.a var0) {
      return var0.l;
   }

   // $FF: synthetic method
   static int d(com.nuance.a.a.a.a.a var0) {
      return var0.p;
   }

   public static native void d();

   // $FF: synthetic method
   static int e(com.nuance.a.a.a.a.a var0) {
      return var0.g;
   }

   public static native void e();

   // $FF: synthetic method
   static int f(com.nuance.a.a.a.a.a var0) {
      return var0.i;
   }

   // $FF: synthetic method
   static Object f() {
      return D;
   }

   // $FF: synthetic method
   static int g(com.nuance.a.a.a.a.a var0) {
      return var0.m;
   }

   // $FF: synthetic method
   static Object g() {
      return E;
   }

   // $FF: synthetic method
   static int h(com.nuance.a.a.a.a.a var0) {
      return var0.h;
   }

   // $FF: synthetic method
   static Object h() {
      return C;
   }

   // $FF: synthetic method
   static com.nuance.a.a.a.a.c i(com.nuance.a.a.a.a.a var0) {
      return var0.L;
   }

   // $FF: synthetic method
   static Integer i() {
      return P;
   }

   // $FF: synthetic method
   static int j(com.nuance.a.a.a.a.a var0) {
      return var0.I;
   }

   // $FF: synthetic method
   static Integer j() {
      return Q;
   }

   // $FF: synthetic method
   static int k(com.nuance.a.a.a.a.a var0) {
      return var0.K;
   }

   // $FF: synthetic method
   static Integer k() {
      return R;
   }

   private void l() {
      if(this.T != null) {
         this.T.c();
         this.T = null;
      }

   }

   // $FF: synthetic method
   static short[] l(com.nuance.a.a.a.a.a var0) {
      return var0.G;
   }

   private void m() {
      if(this.U != .M.b && this.U != .M.c) {
         if(this.U == .M.e || this.U == .M.f || this.U == .M.h || this.U == .M.g) {
            this.U = .M.d;
            this.a(this.U);
            return;
         }
      } else {
         this.U = .M.a;
         this.a(this.U);
      }

   }

   // $FF: synthetic method
   static byte[] m(com.nuance.a.a.a.a.a var0) {
      return var0.H;
   }

   // $FF: synthetic method
   static int n(com.nuance.a.a.a.a.a var0) {
      return var0.k;
   }

   // $FF: synthetic method
   static int o(com.nuance.a.a.a.a.a var0) {
      return var0.r;
   }

   // $FF: synthetic method
   static .af p(com.nuance.a.a.a.a.a var0) {
      return var0.N;
   }

   // $FF: synthetic method
   static int q(com.nuance.a.a.a.a.a var0) {
      return var0.s;
   }

   // $FF: synthetic method
   static int r(com.nuance.a.a.a.a.a var0) {
      return var0.q;
   }

   // $FF: synthetic method
   static int s(com.nuance.a.a.a.a.a var0) {
      return var0.J;
   }

   // $FF: synthetic method
   static int t(com.nuance.a.a.a.a.a var0) {
      return var0.t;
   }

   // $FF: synthetic method
   static int u(com.nuance.a.a.a.a.a var0) {
      return var0.u;
   }

   // $FF: synthetic method
   static int v(com.nuance.a.a.a.a.a var0) {
      return var0.y;
   }

   // $FF: synthetic method
   static int w(com.nuance.a.a.a.a.a var0) {
      return var0.w;
   }

   // $FF: synthetic method
   static int x(com.nuance.a.a.a.a.a var0) {
      return var0.x;
   }

   // $FF: synthetic method
   static int y(com.nuance.a.a.a.a.a var0) {
      return var0.z;
   }

   // $FF: synthetic method
   static com.nuance.a.a.a.a.f z(com.nuance.a.a.a.a.a var0) {
      return var0.F;
   }

   public final void a(.S var1) {
      if(this.f.b()) {
         this.f.b((Object)"++++++++++++========== turnOnEndPointer()");
      }

      if(var1 != null && this.B != null) {
         this.B.a(var1);
      }
   }

   public final void a(.T var1) {
      if(this.f.b()) {
         this.f.b((Object)"++++++++++++========== turnOnEndPointer()");
      }

      if(var1 != null && this.B != null) {
         this.B.a(var1);
      }
   }

   public final void a(.aa var1) {
      if(this.f.b()) {
         this.f.b((Object)"++++++++++++========== stopRecording()");
      }

      if(var1 != null) {
         if(this.B == null) {
            var1.a(.P.a);
         } else {
            this.B.a((.aa)var1, (.R)null);
         }
      }
   }

   public final void a(Object var1, Object var2) {
      if(this.f.b()) {
         this.f.b((Object)("---------------------- AudioSystemAndroid +++++ handleMessage() Thread:" + Thread.currentThread()));
      }

   }

   public final boolean a() {
      this.f.c((Object)"++++++++++++========== pausePlayback() is not implemented");
      return false;
   }

   public final boolean a(.V var1, boolean var2, .O var3, .aa var4, .U var5, .Z var6, .R var7, .S var8, .T var9) {
      if(this.f.b()) {
         this.f.b((Object)"++++++++++++========== startRecording()");
      }

      if(this.B != null) {
         if(this.f.b()) {
            this.f.b((Object)"previous recording still running!");
         }

         return false;
      } else if(var3 == null) {
         if(this.f.e()) {
            this.f.e("audioCallback cannot be null.");
         }

         return false;
      } else if(this.S == null) {
         if(this.f.e()) {
            this.f.e("inputDevice is BLUETOOTH_HEADSET, but ANDROID_CONTEXT parameter is not passed in!!!");
         }

         return false;
      } else {
         this.T = .bZ.a(this.S);
         if(this.T.b()) {
            this.m();
         }

         if(var1 == .V.a) {
            this.t = 6;
            this.l();
         } else {
            if(var1 != .V.c) {
               if(this.f.e()) {
                  this.f.e("Unexpected inputDevice.");
               }

               this.l();
               return false;
            }

            this.t = this.T.g();
            if(!this.T.b()) {
               this.l();
            }
         }

         this.B = new com.nuance.a.a.a.a.e(this, (byte)0);

         try {
            this.B.a(var2, var3, var4, var5, var6, var7, var8, var9);
            return true;
         } catch (com.nuance.a.a.a.a.b var10) {
            com.nuance.a.a.a.a.e.a(this.B, var10);
            this.B = null;
            return false;
         }
      }
   }

   public final boolean a(.Y var1, .O var2, .Q var3) {
      if(this.f.b()) {
         this.f.b((Object)"++++++++++++========== startPlayback()");
      }

      if(var2 == null) {
         if(this.f.e()) {
            this.f.e("audioCallback cannot be null.");
         }
      } else {
         if(this.S != null) {
            this.T = .bZ.a(this.S);
            if(this.T.b()) {
               this.m();
            }

            if(var1 == .Y.a) {
               this.g = 3;
               this.l();
            } else {
               if(var1 != .Y.c) {
                  if(this.f.e()) {
                     this.f.e("Unexpected outputDevice.");
                  }

                  this.l();
                  return false;
               }

               this.g = this.T.f();
               if(!this.T.b()) {
                  this.l();
               }
            }

            this.A = new com.nuance.a.a.a.a.d(this, (byte)0);

            try {
               this.A.a(var2, var3);
               return true;
            } catch (com.nuance.a.a.a.a.b var4) {
               com.nuance.a.a.a.a.d.a(this.A, var4);
               this.A = null;
               return false;
            }
         }

         if(this.f.e()) {
            this.f.e("inputDevice is BLUETOOTH_HEADSET, but ANDROID_CONTEXT parameter is not passed in!!!");
            return false;
         }
      }

      return false;
   }

   public final void b(.aa var1) {
      if(this.f.b()) {
         this.f.b((Object)"++++++++++++========== stopPlayback()");
      }

      if(this.A != null) {
         this.A.a(var1);
      }

      this.A = null;
   }

   public final boolean b() {
      this.f.c((Object)"++++++++++++========== previousPlayback() is not implemented");
      return false;
   }

   public final boolean c() {
      this.f.c((Object)"++++++++++++========== nextPlayback() is not implemented");
      return false;
   }
}
