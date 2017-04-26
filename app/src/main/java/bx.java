import android.os.Build.VERSION;
import java.util.Vector;

public class bx extends bw implements bS {
   private static final ae g = bh.a(bx.class);
   private static String k;
   private af h;
   private bs i;
   private bO j;

   static {
      k = VERSION.RELEASE;
   }

   public bx(bt var1, bs var2, Vector var3) {
      super(var1, var2, var3);
      this.i = var2;
      this.h = var1.i_();
      this.a = var1.h();
      this.a.a((bq)this);
      this.j = null;
      af var4 = this.h;
      ag var5 = new ag((byte)0, (Object)null);
      Thread var6 = Thread.currentThread();
      this.h.a();
      var4.a(var5, this, var6);
   }

   private void a(byte var1) {
      if(var1 == this.j.a) {
         Vector var3 = (Vector)((bt)this.g()).i();
         if(var3 != null && var3.size() > 0) {
            g.b((Object)("clearResLogsToServer() before clean the log vector tranId[" + var1 + "] log list size [" + var3.size() + "]"));
            int var2 = 0;

            while(var2 < var3.size()) {
               bP var4 = (bP)var3.elementAt(var2);
               if(var4.e()) {
                  var3.removeElement(var4);
               } else {
                  ++var2;
               }
            }

            g.b((Object)("clearResLogsToServer() after clean the log vector tranId[" + var1 + "] log list size [" + var3.size() + "]"));
         }
      }

   }

   public final X a(String var1, bb var2) {
      if(var1 == null) {
         throw new NullPointerException("name can not be null");
      } else if(var2 == null) {
         throw new NullPointerException("dict can not be null");
      } else {
         return new bz(var1, (aW)var2);
      }
   }

   public final X a(String var1, bb var2, bd var3) {
      if(var1 == null) {
         throw new NullPointerException("name can not be null");
      } else if(var2 == null) {
         throw new NullPointerException("tts_dict can not be null");
      } else if(var3 == null) {
         throw new NullPointerException("audioSink can not be null");
      } else {
         return new bM(var1, this.a, (aW)var2, var3);
      }
   }

   public final X a(String var1, String var2) {
      if(var1 == null) {
         throw new NullPointerException("name can not be null");
      } else if(var2 == null) {
         throw new NullPointerException("text can not be null");
      } else {
         return new bN(var1, var2);
      }
   }

   public final bQ a(bU var1, String var2, String var3, String var4, String var5, String var6, bb var7) {
      String var9 = "";
      if(var1 == null) {
         var9 = "" + "commandListener is invalid; ";
      }

      String var8;
      label63: {
         if(var2 != null) {
            var8 = var9;
            if(!var2.equals("")) {
               break label63;
            }
         }

         var8 = var9 + "cmd should be non-null; ";
      }

      label58: {
         if(var3 != null) {
            var9 = var8;
            if(!var3.equals("")) {
               break label58;
            }
         }

         var9 = var8 + "scriptVersion should be non-null; ";
      }

      label53: {
         if(var4 != null) {
            var8 = var9;
            if(!var4.equals("")) {
               break label53;
            }
         }

         var8 = var9 + "dictationLanguage should be non-null; ";
      }

      label48: {
         if(var6 != null) {
            var9 = var8;
            if(!var6.equals("")) {
               break label48;
            }
         }

         var9 = var8 + "phoneModel should be non-null; ";
      }

      var8 = var9;
      if(30000L <= 0L) {
         var8 = var9 + "commandTimeout is invalid; ";
      }

      if(!var8.equals("")) {
         g.e("NMASResourceImpl.createCommand() " + var8);
         throw new IllegalArgumentException(var8);
      } else {
         Object var14 = this.e;
         synchronized(var14) {
            if(this.j != null) {
               this.j.e();
            }

            bu var15 = this.a;
            bu.d();
            if(this.d == 0) {
               af var16 = this.h;
               ag var10 = new ag((byte)0, (Object)null);
               Thread var11 = Thread.currentThread();
               this.h.a();
               var16.a(var10, this, var11);
            }

            this.f = this.a.h();
            this.j = new bO(this.h, var1, var2, ((bt)this.c).b, this.a, ((bt)this.c).d(), "1", k, var3, "enus", "ne", ((bt)this.c).e(), var4, var5, var6, ((bt)this.c).d(), "", var7, this, this.i, this.f);
            bO var13 = this.j;
            return var13;
         }
      }
   }

   public final bd a(String var1) {
      if(var1 == null) {
         throw new NullPointerException("name can not be null");
      } else {
         return new by(var1, this.a, this.h);
      }
   }

   public final void a() {
      g.b((Object)"freeResource() disconnectTimeout:0");
      if(this.j != null) {
         this.j.e();
      }

      Object var1 = this.e;
      synchronized(var1) {
         if(this.d == 2) {
            this.d = 0;
            Integer var3 = new Integer(0);
            af var2 = this.h;
            ag var6 = new ag((byte)3, var3);
            Thread var4 = Thread.currentThread();
            this.h.a();
            var2.a(var6, this, var4);
         } else {
            throw new br("the resource was unloaded. ");
         }
      }
   }

   public final void a(byte var1, short var2) {
      if(var1 == this.f) {
         if(this.j != null) {
            this.j.e();
         }

         super.a(var1, var2);
      }
   }

   public final void a(byte var1, byte[] var2) {
      bB var3 = bC.a(var2);
      switch(var3.e()) {
      case 29185:
         this.a(var1);
         if(this.j != null) {
            this.j.a((bJ)var3, var1);
            return;
         }
         break;
      case 29186:
         if(this.j != null) {
            this.j.a((bG)var3, var1);
            return;
         }
         break;
      case 29187:
      case 29188:
      default:
         g.e("Session.parseXModeMsgBcpData() Unknown command: " + var3.e() + ". ");
         break;
      case 29189:
         this.a(var1);
         if(this.j != null) {
            this.j.a((bK)var3, var1);
            return;
         }
      }

   }

   public final void a(Object var1, Object var2) {
      switch(((ag)var1).a) {
      case 0:
         super.a((bv)this);
         return;
      case 1:
      case 2:
      default:
         super.a(var1, var2);
         return;
      case 3:
         this.a.b((bv)this);
         bs var3 = this.i;
      }
   }

   public final void a(short var1) {
      g.b((Object)("onSessionDisconnected() reasonCode:" + var1));
      if(this.j != null) {
         this.j.a(var1);
      }

      super.a(var1);
   }

   public final void a(byte[] var1) {
      super.a(var1);
      if(this.j != null) {
         this.j.a(var1);
      }

   }

   public final X b(String var1, bb var2) {
      if(var1 == null) {
         throw new NullPointerException("name can not be null");
      } else if(var2 == null) {
         throw new NullPointerException("dict can not be null");
      } else {
         return new bL(var1, (aW)var2, (byte)2);
      }
   }

   public final X c(String var1, bb var2) {
      if(var1 == null) {
         throw new NullPointerException("name can not be null");
      } else if(var2 == null) {
         throw new NullPointerException("dict can not be null");
      } else {
         return new bL(var1, (aW)var2, (byte)3);
      }
   }

   public final void c() {
      this.j.f();
   }

   public final X d(String var1, bb var2) {
      if(var1 == null) {
         throw new NullPointerException("name can not be null");
      } else if(var2 == null) {
         throw new NullPointerException("dict can not be null");
      } else {
         return new bL(var1, (aW)var2, (byte)1);
      }
   }

   public final void d() {
      this.j.b();
   }

   public final void e() {
      this.j.c();
   }

   public final void f() {
      this.j.d();
   }

   public final long h() {
      return super.h();
   }

   public final bb j() {
      return new aW();
   }

   public final bc k() {
      return new aZ();
   }
}
