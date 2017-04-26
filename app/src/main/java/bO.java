import java.util.Vector;

public class bO implements ah, bQ {
   private static final ae b = bh.a(bO.class);
   protected byte a;
   private bx c;
   private bs d;
   private bU e = null;
   private bu f = null;
   private aI g;
   private short h = -1;
   private af i;
   private aq j;
   private long k;
   private boolean l;
   private String m;
   private boolean n = false;
   private bP o;
   private Object p;

   protected bO(af var1, bU var2, String var3, String var4, bu var5, String var6, String var7, String var8, String var9, String var10, String var11, M var12, String var13, String var14, String var15, String var16, String var17, bb var18, bx var19, bs var20, byte var21) {
      if(b.b()) {
         b.b((Object)"PDXTransactionImpl()");
      }

      this.p = new Object();
      this.i = var1;
      this.f = var5;
      this.e = var2;
      this.k = 30000L;
      this.c = var19;
      this.d = var20;
      this.a = var21;
      this.m = var3;
      this.l = false;
      if(((bt)var19.g()).i() != null) {
         this.o = new bP(this.a, this);
         b(this.o, "INTERNAL_ERROR");
      }

      Object var23 = this.p;
      synchronized(var23) {
         this.h = 0;
      }

      Object[] var24 = new Object[]{var6, var7, var8, var9, var10, var11, var12, var13, new Short((short)1), new Short((short)1), var14, var15, var16, var17, var4, var3, var18, null};
      ag var25 = new ag((byte)1, var24);
      Thread var26 = Thread.currentThread();
      var1.a();
      var1.a(var25, this, var26);
   }

   // $FF: synthetic method
   static Object a(bO var0) {
      return var0.p;
   }

   // $FF: synthetic method
   static void a(bO var0, bP var1) {
      Vector var2 = (Vector)((bt)var0.c.g()).i();
      if(var2 == null) {
         b.c((Object)"appendLogToResLogs: NMSPDefines.DEVICE_CMD_LOG_TO_SERVER_ENABLED is disabled.");
      } else if(!var2.contains(var1)) {
         var2.addElement(var1);
         return;
      }

   }

   // $FF: synthetic method
   static void a(bO var0, String var1) {
      var0.a(var1);
   }

   // $FF: synthetic method
   static void a(bP var0, String var1) {
      b(var0, var1);
   }

   private void a(String var1) {
      if(this.g != null) {
         this.g.a(var1).a();
      }

   }

   private void a(String param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   private static String b(byte[] var0) {
      StringBuffer var2 = new StringBuffer();

      for(int var1 = 0; var1 < var0.length; ++var1) {
         String var3 = Integer.toHexString(var0[var1]);
         if(var3.length() > 1) {
            var2.append(var3.substring(var3.length() - 2));
         } else {
            var2.append(var3);
         }

         if(var1 == 3 || var1 == 5 || var1 == 7 || var1 == 9) {
            var2.append('-');
         }
      }

      return var2.toString();
   }

   // $FF: synthetic method
   static short b(bO var0) {
      var0.h = -1;
      return (short)-1;
   }

   private static void b(bP var0, String var1) {
      if(var0 != null) {
         bP.a(var0, var1);
      }

   }

   // $FF: synthetic method
   static bU c(bO var0) {
      return var0.e;
   }

   // $FF: synthetic method
   static bP d(bO var0) {
      return var0.o;
   }

   // $FF: synthetic method
   static bu e(bO var0) {
      return var0.f;
   }

   // $FF: synthetic method
   static ae g() {
      return b;
   }

   public final void a() {
      // $FF: Couldn't be decompiled
   }

   public final void a(X param1) {
      // $FF: Couldn't be decompiled
   }

   public final void a(bG param1, byte param2) {
      // $FF: Couldn't be decompiled
   }

   public final void a(bJ param1, byte param2) {
      // $FF: Couldn't be decompiled
   }

   public final void a(bK param1, byte param2) {
      // $FF: Couldn't be decompiled
   }

   public final void a(Object var1, Object var2) {
      ag var25 = (ag)var1;
      var2 = var25.b;
      int var5;
      switch(var25.a) {
      case 1:
         Object[] var35 = (Object[])var2;
         String var8 = (String)var35[0];
         String var9 = (String)var35[1];
         String var10 = (String)var35[2];
         String var11 = (String)var35[3];
         String var12 = (String)var35[4];
         String var13 = (String)var35[5];
         M var33 = (M)var35[6];
         String var14 = (String)var35[7];
         short var3 = ((Short)var35[8]).shortValue();
         short var4 = ((Short)var35[9]).shortValue();
         String var15 = (String)var35[10];
         String var16 = (String)var35[11];
         String var17 = (String)var35[12];
         String var18 = (String)var35[13];
         byte[] var41 = this.f.f();
         String var19 = (String)var35[14];
         String var20 = (String)var35[15];
         bb var21 = (bb)var35[16];
         M var37 = var33;
         if((new com.nuance.a.a.a.a.k(this.c.b)).a()) {
            var37 = ax.c(var33);
         }

         bw.i();
         aI var36 = this.f.j();
         if(var36 != null) {
            aK var38 = var36.a("NMASCommand");

            try {
               this.g = var38.a("Name", this.m).a("TransID", (new Integer(this.a)).toString()).a();
            } catch (aJ var24) {
               ;
            }
         }

         bE var40 = new bE(var8, var9, var10, var11, var12, var13, var37, var14, var3, var4, var15, var16, var17, var18, var41, var19, var20, var21);
         Vector var39 = (Vector)((bt)this.c.g()).i();
         if(var39 == null) {
            b.c((Object)"appendLogToQueryBegin: NMSPDefines.DEVICE_CMD_LOG_TO_SERVER_ENABLED is disabled");
         } else if(var39.size() == 0) {
            b.c((Object)"appendLogToQueryBegin: nmasResLogsToServer is empty, nothing to log to server");
         } else {
            int var6 = var39.size();
            aW var42 = new aW();
            aZ var43 = new aZ();

            for(var5 = 0; var5 < var6; ++var5) {
               bP var44 = (bP)var39.elementAt(var5);
               if(var44.a() != this.a) {
                  aW var45 = new aW();
                  var45.a("id", (String)(var44.b() + ":" + var44.a()), (short)193);
                  var45.a("status", (String)var44.c().toString(), (short)193);
                  var43.a((bb)var45);
                  var44.d();
               }
            }

            var42.a("device_log", (bc)var43);
            var40.a("app_info", var42);
         }

         this.f.a((short)2597, "SEND_BCP_BEGIN" + this.a, var40.f(), (byte[])null, this.a, 0L, this.c, false);
         if(var41 != null) {
            try {
               if(!this.n) {
                  this.n = true;
                  b.b((Object)("PDXCommandCreated() called from handleInit()" + b(var41) + ":" + this.a + " (" + this + "," + this.d + ")"));
                  this.d.a(b(var41) + ":" + this.a);
                  return;
               }
            } catch (Throwable var23) {
               b.e("got exp in PDXCommandListener.PDXCommandCreated() [" + var23.getClass().getName() + "] msg [" + var23.getMessage() + "]");
               return;
            }
         }
         break;
      case 2:
         X var31 = (X)var2;
         if(((bD)var31).c() == 127) {
            this.f.a(((bM)var31).a(), ((bM)var31).e(), this.c);
         }

         bw.i();
         if(var31 instanceof by) {
            String var32 = ((by)var31).b();
            var5 = ((by)var31).a();
            if(this.g != null) {
               aK var7 = this.g.a("NMASAudioParameter");

               try {
                  var7.a("Name", var32).a("AudioID", var5).a();
               } catch (aJ var22) {
                  ;
               }
            }
         }

         bH var34 = new bH((bD)var31);
         this.f.a((short)2585, "SEND_BCP_DATA", var34.d(), (byte[])null, this.a, 0L, this.c, false);
         return;
      case 3:
         byte[] var28 = (byte[])var2;
         bw.i();
         bA var29 = new bA(var28);
         this.f.a((short)2585, "SEND_BCP_DATA", var29.d(), (byte[])null, this.a, 0L, this.c, false);
         return;
      case 4:
         bw.i();
         bF var27 = new bF();
         this.f.a((short)2585, "SEND_BCP_DATA", var27.d(), (byte[])null, this.a, 0L, this.c, false);
         this.j = new aq() {
            // $FF: synthetic field
            private bO a = bO.this;

            public final void run() {
               // $FF: Couldn't be decompiled
            }
         };
         this.i.a(this.j, this.k);
         return;
      case 5:
         this.e.a((short)4);
         return;
      case 6:
         bR var26 = (bR)var2;
         bP var30 = this.o;
         if(var30 != null) {
            var30.a(var26);
            return;
         }
      }

   }

   public final void a(short param1) {
      // $FF: Couldn't be decompiled
   }

   public final void a(byte[] param1) {
      // $FF: Couldn't be decompiled
   }

   public final void b() {
      this.f();
   }

   public final void c() {
      this.f();
   }

   public final void d() {
      this.f();
   }

   public final void e() {
      Object var1 = this.p;
      synchronized(var1) {
         if(this.h == 1 && this.j != null) {
            this.i.a(this.j);
         }

         if(this.h != 2) {
            if(this.h != -1) {
               if(!this.l) {
                  this.a("CommandAbort");
               }

               af var2 = this.i;
               ag var3 = new ag((byte)5, (Object)null);
               Thread var4 = Thread.currentThread();
               this.i.a();
               var2.a(var3, this, var4);
            }

            this.h = 2;
         }
      }
   }

   protected final void f() {
      if(this.j != null) {
         this.i.a(this.j);
         this.i.a(this.j, this.k);
      }

   }
}
