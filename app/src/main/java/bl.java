import java.io.ByteArrayOutputStream;
import java.util.LinkedList;
import java.util.Vector;

public class bl implements O, Q, aa, ah, bd, db {
   private static final ae a = bh.a(bl.class);
   private M b;
   private N c;
   private ay d;
   private ByteArrayOutputStream e;
   private Vector f;
   private boolean g;
   private LinkedList h;
   private boolean i;
   private short j = -1;
   private Vector k;
   private af l = null;
   private Object m = new Object();
   private Y n;
   private aI o;

   public bl(ay var1, bn var2, Vector var3, L var4) {
      this.b = ((bt)var2).f();
      this.d = var1;
      this.l = ((bt)var2).i_();
      this.k = var3;
      this.c = new com.nuance.a.a.a.a.a(this.l, this.b, var3);
      this.e = new ByteArrayOutputStream();
      this.f = new Vector();
      this.i = false;
      this.g = false;
      if(var4.equals(L.d)) {
         this.n = Y.d;
      } else if(var4.equals(L.c)) {
         this.n = Y.c;
      } else if(var4.equals(L.b)) {
         this.n = Y.b;
      } else if(var4.equals(L.a)) {
         this.n = Y.a;
      } else if(var4.equals(L.e)) {
         this.n = Y.e;
      }

      if(ax.b(this.b)) {
         this.h = new LinkedList();
      }

      aL var5 = (aL)var2.a();
      if(var5 != null) {
         aI var6 = var5.b();
         if(var6 != null) {
            this.o = var6.a("NMSPPlayer").a();
         }
      }

   }

   private void a(String var1) {
      if(this.d != null) {
         try {
            this.d.a(var1);
         } catch (Throwable var3) {
            if(a.e()) {
               a.e("Got an exp while calling NMSPAudioPlaybackListener.playerUpdate(" + var1 + ")[" + var3.getClass().getName() + "] msg [" + var3.getMessage() + "]");
               return;
            }
         }
      }

   }

   private void b(String var1) {
      if(this.o != null) {
         this.o.a(var1).a();
      }

   }

   public final void a() {
      if(a.b()) {
         a.b((Object)"PlayerImpl.start()");
      }

      this.b("PlayerStart");
      af var1 = this.l;
      ag var2 = new ag((byte)1, this);
      Thread var3 = Thread.currentThread();
      this.l.a();
      var1.a(var2, this, var3);
   }

   public final void a(P var1) {
      if(a.b()) {
         a.b((Object)"audio stop call back is called");
      }

      this.j = 5;
      String var2;
      if(var1.equals(P.b)) {
         var2 = "PLAYBACK_ERROR";
      } else {
         var2 = "STOPPED";
      }

      this.a(var2);
   }

   public final void a(P var1, Object var2) {
      if(a.b()) {
         a.b((Object)"PlayerImpl.doneCallback()");
      }

      af var3 = this.l;
      ag var4 = new ag((byte)7, new Object[]{var1, var2});
      Thread var5 = Thread.currentThread();
      this.l.a();
      var3.a(var4, this, var5);
   }

   public final void a(Object param1, Object param2) {
      // $FF: Couldn't be decompiled
   }

   public final void a(byte[] var1, int var2, int var3, boolean var4) {
      if(a.c()) {
         a.c((Object)("addAudioBuf(" + var1 + ", " + var4 + ")"));
      }

      if(var1 == null && !var4) {
         throw new NullPointerException("buffer is null!");
      } else if(var1 != null && var2 < 0) {
         throw new IllegalArgumentException("offset cannot be negative!!!");
      } else if(var1 != null && var3 <= 0) {
         throw new IllegalArgumentException("length can only be positive!!!");
      } else if((this.b == M.c || this.b == M.b || this.b == M.a) && var3 > 153600) {
         this.a("PLAYBACK_ERROR");
         this.f();
      } else if(this.g) {
         throw new bk("audio player is full, the last buffer has already apended!");
      } else {
         if(!this.g && var4) {
            this.g = true;
         }

         byte[] var5 = null;
         if(var1 != null) {
            var5 = new byte[var3];
            System.arraycopy(var1, var2, var5, 0, var3);
         }

         Boolean var6 = new Boolean(var4);
         af var7 = this.l;
         ag var8 = new ag((byte)6, new Object[]{var5, var6});
         Thread var9 = Thread.currentThread();
         this.l.a();
         var7.a(var8, this, var9);
      }
   }

   public final void a(byte[] param1, Object param2, W param3, W param4, Float param5) {
      // $FF: Couldn't be decompiled
   }

   public final void f() {
      if(a.b()) {
         a.b((Object)"PlayerImpl.start()");
      }

      this.b("PlayerStop");
      af var1 = this.l;
      ag var2 = new ag((byte)2, this);
      Thread var3 = Thread.currentThread();
      this.l.a();
      var1.a(var2, this, var3);
   }
}
