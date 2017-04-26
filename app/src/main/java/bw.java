import java.io.ByteArrayOutputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class bw implements ah, bq, bv {
   private static final ae g = bh.a(bw.class);
   private static long o = 1L;
   protected bu a;
   public Vector b;
   protected bn c;
   protected int d = 0;
   protected Object e;
   protected byte f = 0;
   private bs h;
   private bv i;
   private M j;
   private M k;
   private byte l;
   private af m;
   private Hashtable n;
   private long p;
   private Hashtable q;

   public bw(bt var1, bs var2, Vector var3) {
      this.c = var1;
      this.a = var1.h();
      this.h = var2;
      this.j = var1.e();
      this.k = var1.f();
      this.l = 5;
      this.m = var1.i_();
      this.e = new Object();
      this.f = this.a.h();
      this.n = new Hashtable();
      this.q = new Hashtable();
      this.p = this.a.g();
      this.b = new Vector();
      if(var3 != null) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            bf var5 = ((bf)var3.elementAt(var4)).e();
            this.b.addElement(var5);
         }
      }

   }

   private static bg a(String var0) {
      return var0.equalsIgnoreCase("sdk")?bg.a:(var0.equalsIgnoreCase("nmsp")?bg.b:(var0.equalsIgnoreCase("app")?bg.c:(var0.equalsIgnoreCase("nss")?bg.d:(var0.equalsIgnoreCase("slog")?bg.e:(var0.equalsIgnoreCase("nsslog")?bg.f:(var0.equalsIgnoreCase("gwlog")?bg.g:(var0.equalsIgnoreCase("svsp")?bg.h:(var0.equalsIgnoreCase("sip")?bg.i:(var0.equalsIgnoreCase("sdp")?bg.j:null)))))))));
   }

   private void a(Vector var1, long var2) {
      if(this.d != 2) {
         bs var6 = this.h;
      }

      this.n.put(new Long(var2), new Byte((byte)2));
      this.q.put(new Long(var2), var1);
      String var10 = "<gp><rid>" + var2 + "</rid>";

      String var7;
      for(int var5 = 0; var5 < var1.size(); var10 = var7) {
         label23: {
            bf var8 = (bf)var1.elementAt(var5);
            if(var8.d() != bg.c && var8.d() != bg.b && var8.d() != bg.d) {
               var7 = var10;
               if(var8.d() != bg.h) {
                  break label23;
               }
            }

            var7 = var10 + "<" + var8.d() + " p=\"" + var8.a() + "\"/>";
         }

         ++var5;
      }

      var10 = var10 + "</gp>";
      bu var9 = this.a;
      byte[] var11 = var10.getBytes();
      byte var4 = this.f;
      bv var12 = this.i;
      var9.a((short)2583, "SEND_BCP_GET_PARAMS", var11, new byte[0], var4, var2, var12, false);
   }

   public static long i() {
      return 0L;
   }

   public void a() {
      g.b((Object)"freeResource, disconnect timeout: 0");
      Object var1 = this.e;
      synchronized(var1) {
         if(this.d == 2) {
            this.d = 0;
            Integer var3 = new Integer(0);
            af var2 = this.m;
            ag var6 = new ag((byte)3, var3);
            Thread var4 = Thread.currentThread();
            this.m.a();
            var2.a(var6, this, var4);
         } else {
            g.e("ResourceException the resource was unloaded. ");
            throw new br("the resource was unloaded. ");
         }
      }
   }

   public final void a(byte var1, long var2, short var4, short var5, short var6) {
      g.b((Object)("onBcpResponse, TID: " + var1 + ", RID: " + var2 + ", status code: " + var4 + " , request state: " + var5 + ", completion cause: " + var6));
      if(var4 != 200) {
         Byte var7 = (Byte)this.n.get(new Long(var2));
         if(var7 != null) {
            bs var8;
            switch(var7.byteValue()) {
            case 1:
               this.n.remove(new Long(var2));
               var8 = this.h;
               return;
            case 2:
               this.n.remove(new Long(var2));
               var8 = this.h;
               return;
            }
         }
      }

   }

   public final void a(byte var1, long var2, short var4, byte[] var5) {
      g.b((Object)("onBcpSetParamsComplete, TID: " + var1 + ", RID: " + var2 + ", status code: " + var4));
      if(this.n.remove(new Long(var2)) == null) {
         g.d("onBcpSetParamsComplete, RID: " + var2 + " already removed!");
      } else {
         Vector var7 = new Vector();
         if(var5 != null) {
            String var10 = new String(var5);
            int var9;
            if(var10.startsWith(";")) {
               var9 = 1;
            } else {
               var9 = 0;
            }

            while(true) {
               int var6 = var10.indexOf(";", var9);
               if(var6 == -1) {
                  if(var9 < var10.length()) {
                     var10 = var10.substring(var9);
                     var9 = var10.indexOf(".");
                     if(var9 != -1) {
                        var7.addElement(new bf(var10.substring(var9 + 1), a(var10.substring(0, var9))));
                     }
                  }
                  break;
               }

               String var8 = var10.substring(var9, var6);
               var9 = var8.indexOf(".");
               if(var9 != -1) {
                  var7.addElement(new bf(var8.substring(var9 + 1), a(var8.substring(0, var9))));
               }

               var9 = var6 + 1;
            }
         }

         bs var11;
         if(var4 != 200 && var4 != 201) {
            var11 = this.h;
         } else {
            var11 = this.h;
         }
      }
   }

   public void a(byte var1, short var2) {
      g.b((Object)("onBcpEvent, TID: " + var1 + ", event code: " + var2));
      if(this.d == 2) {
         this.d = 0;
         Enumeration var3 = this.n.keys();

         while(var3.hasMoreElements()) {
            Long var4 = (Long)var3.nextElement();
            bs var6;
            switch(((Byte)this.n.remove(var4)).byteValue()) {
            case 1:
               var6 = this.h;
               break;
            case 2:
               var6 = this.h;
            }
         }

         bs var5 = this.h;
         this.a.b((bv)this);
      }

   }

   public void a(byte var1, byte[] var2) {
   }

   protected final void a(bv var1) {
      g.b((Object)"loadResource");
      if((new com.nuance.a.a.a.a.k(this.b)).a()) {
         this.j = ax.c(this.j);
         this.k = ax.c(this.k);
         ((bt)this.c).a(this.j);
         ((bt)this.c).b(this.k);
      }

      this.i = var1;
      this.a.a(var1);
      if(this.d == 0) {
         if(this.a.f() != null) {
            this.d = 2;
         } else {
            this.a.a(this.j, this.k);
            this.d = 1;
         }

         long var2 = this.h();
         String var4 = "<lr><rid>" + var2 + "</rid>";
         switch(this.l) {
         case 1:
            var4 = var4 + "<nr9><reco/></nr9>";
            break;
         case 2:
            var4 = var4 + "<nr9><tts/></nr9>";
            break;
         case 3:
            var4 = var4 + "<oper></oper>";
            break;
         case 4:
            var4 = var4 + "<dict>";
            var4 = var4 + "</dict>";
            break;
         case 5:
            return;
         }

         byte[] var5 = (var4 + "</lr>").getBytes();
         this.a.a((short)2599, "SEND_BCP_LOAD_RESOURCE", var5, (byte[])null, this.f, var2, var1, false);
      }

   }

   public void a(Object var1, Object var2) {
      ag var13 = (ag)var1;
      int var3;
      long var5;
      String var14;
      bs var17;
      Object[] var18;
      switch(var13.a) {
      case 1:
         var18 = (Object[])var13.b;
         Vector var15 = (Vector)var18[0];
         var5 = ((Long)var18[1]).longValue();
         if(this.d != 2) {
            var17 = this.h;
            return;
         } else {
            boolean var7 = true;
            ByteArrayOutputStream var8 = new ByteArrayOutputStream();
            byte[] var9 = new byte[4];
            this.n.put(new Long(var5), new Byte((byte)1));
            var14 = "<sp><rid>" + var5 + "</rid>";
            int var4 = 1;
            var3 = 0;

            for(; var3 < var15.size(); ++var3) {
               bf var10 = (bf)var15.elementAt(var3);
               if(var10.d() != bg.c && var10.d() != bg.b && var10.d() != bg.d) {
                  if(var10.d() == bg.h) {
                     var7 = false;
                  }

                  var14 = var14 + "<" + var10.d().toString() + " p=\"" + var10.a() + "\" v=\"" + var4 + "\"/>";
                  byte[] var19 = var10.b();
                  au.a((int)var19.length, var9, 0);
                  var8.write(var9, 0, 4);
                  var8.write(var19, 0, var19.length);
                  ++var4;
               } else {
                  var7 = false;
                  String var11 = new String(var10.b());
                  var14 = var14 + "<" + var10.d() + " p=\"" + var10.a() + "\" v=\"" + ax.a(var11) + "\"/>";
               }
            }

            var14 = var14 + "</sp>";
            this.a.a((short)2581, "SEND_BCP_SET_PARAMS", var14.getBytes(), var8.toByteArray(), this.f, var5, this.i, var7);

            try {
               var8.close();
               return;
            } catch (Exception var12) {
               return;
            }
         }
      case 2:
         var18 = (Object[])var13.b;
         this.a((Vector)var18[0], ((Long)var18[1]).longValue());
         return;
      case 3:
         var3 = ((Integer)var13.b).intValue();
         this.a.a(this.f, var3, this.i);
         var17 = this.h;
         return;
      case 4:
         var3 = ((Integer)var13.b).intValue();
         var5 = this.h();
         var14 = "<fr><rid>" + var5 + "</rid>";
         var14 = var14 + "<n>1</n>";
         var14 = var14 + "<resids>";
         var14 = var14 + "<res1><id>" + this.p + "</id>";
         var14 = var14 + "<timeout>" + var3 + "<timeout></res1>";
         var14 = var14 + "</resids>";
         byte[] var16 = (var14 + "</fr>").getBytes();
         this.a.a((short)2608, "SEND_BCP_FREE_RESOURCE_ID", var16, (byte[])null, this.f, var5, this.i, true);
         return;
      default:
      }
   }

   public void a(short var1) {
      if(g.b()) {
         g.b((Object)("onSessionDisconnected, reason code: " + var1));
      }

      Enumeration var2 = this.n.keys();

      bs var6;
      while(var2.hasMoreElements()) {
         Long var3 = (Long)var2.nextElement();
         switch(((Byte)this.n.remove(var3)).byteValue()) {
         case 1:
            var6 = this.h;
            break;
         case 2:
            var6 = this.h;
         }
      }

      Object var5 = this.e;
      synchronized(var5) {
         if(this.d == 2) {
            var6 = this.h;
         }

         this.d = 0;
      }
   }

   public void a(byte[] var1) {
      if(g.b()) {
         g.b((Object)("onSessionConnected, SID: " + var1));
      }

      Object var4 = this.e;
      synchronized(var4) {
         this.d = 2;
      }
   }

   public final void b() {
      bs var1 = this.h;
   }

   public final void b(byte var1, long var2, short var4, byte[] var5) {
      byte var6 = 0;
      g.b((Object)("onBcpGetParamsComplete, TID: " + var1 + ", RID: " + var2));
      if(this.n.remove(new Long(var2)) == null) {
         g.d("onBcpGetParamsComplete, RID: " + var2 + " already removed!");
         this.q.remove(new Long(var2));
      } else {
         Vector var8 = (Vector)this.q.remove(new Long(var2));
         if(var8 == null) {
            g.e("Could not find the grammars associated with RID: " + var2);
         } else {
            String var12 = new String(var5);
            int var11;
            int var14;
            if(var12.startsWith(";")) {
               var11 = 1;
               var14 = 0;
            } else {
               byte var7 = 0;
               var11 = var6;
               var14 = var7;
            }

            while(true) {
               int var15 = var12.indexOf(";", var11);
               if(var15 == -1) {
                  if(var11 < var12.length()) {
                     var12 = var12.substring(var11);
                     if(var12.indexOf(":") == -1) {
                        bf var16 = (bf)var8.elementAt(var14);
                        var8.setElementAt(new bf(var16.a(), var12.getBytes(), var16.d()), var14);
                     }
                  }

                  bs var13;
                  if(var4 != 200 && var4 != 201) {
                     var13 = this.h;
                     return;
                  }

                  var13 = this.h;
                  return;
               }

               String var9 = var12.substring(var11, var15);
               if(var9.indexOf(":") == -1) {
                  bf var10 = (bf)var8.elementAt(var14);
                  var8.setElementAt(new bf(var10.a(), var9.getBytes(), var10.d()), var14);
               }

               ++var14;
               var11 = var15 + 1;
            }
         }
      }
   }

   public void c() {
   }

   public void d() {
   }

   public void e() {
   }

   public void f() {
   }

   public final bn g() {
      return this.c;
   }

   protected long h() {
      synchronized(this){}

      long var1;
      try {
         var1 = o;
         o = 1L + var1;
         if(o == Long.MIN_VALUE) {
            o = 1L;
         }
      } finally {
         ;
      }

      return var1;
   }
}
