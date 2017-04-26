import java.util.LinkedList;
import java.util.List;

import static com.google.android.gms.internal.G.ag;

public class aL implements aE, aH, ah {
   private static final ae a = bh.a(aL.class);
   private static byte[] l = new byte[16];
   private final String b;
   private final long c;
   private final List d = new LinkedList();
   private int e = 0;
   private long f = 0L;
   private boolean g = false;
   private aI h;
   private af i;
   private aD j = null;
   private int k = 1;

   public aL(String var1, long var2, int var4, String var5, String var6, String var7, af var8, aD var9) {
      this.b = var1;
      this.c = var2;
      this.j = var9;
      this.i = var8;
      if(var5 != null && var5.length() != 0) {
         var1 = var5;
      } else {
         var1 = ai.b();
      }

      try {
         this.h = aP.a(var1, "CLIENT", "2.0", var4, this, "CLIENT").a("UniqueID", var6).a("ApplicationID", var7).a("client_hardware_model", com.nuance.nmdp.speechkit.recognitionresult.b.h()).a("client_hardware_submodel", com.nuance.nmdp.speechkit.recognitionresult.b.i()).a("client_os_type", com.nuance.nmdp.speechkit.recognitionresult.b.j()).a("client_os_version", com.nuance.nmdp.speechkit.recognitionresult.b.k()).a("client_sdk_release", "NMSP 5.0 client SDK - build 009").a();
      } catch (aJ var10) {
         ;
      }

      af var11 = this.i;
      ag var12 = new ag((byte)17, (Object)null);
      Thread var13 = Thread.currentThread();
      this.i.a();
      var11.a(var12, this, var13);
   }

//   private void b(int var1) {
//      while(true) {
//         if(this.d.size() > 0) {
//            <undefinedtype> var2 = (<undefinedtype>)this.d.get(0);
//            if(var1 >= var2.a) {
//               this.f -= (long)var2.b.length;
//               this.d.remove(0);
//               --this.e;
//               this.d();
//               continue;
//            }
//         }
//
//         return;
//      }
//   }

   private void d() {
      if(this.g) {
         if(a.b()) {
            a.b((Object)("trySendingLogs() _sessionConnected:" + this.g + ", _outstandingEvents:" + this.e + ", _events.size()" + this.d.size()));
         }

//         while(this.e < 5 && this.e < this.d.size()) {
//            <undefinedtype> var2 = (<undefinedtype>)this.d.get(this.e);
//            if(a.b()) {
//               a.b((Object)("bcpLog, packet len [" + var2.b.length + "]"));
//            }
//
//            af var1 = this.i;
//            ag var4 = new ag((byte)18, new Object[]{var2});
//            Thread var3 = Thread.currentThread();
//            this.i.a();
//            var1.a(var4, this, var3);
//            ++this.e;
//         }
      }

   }

   private void e() {
      com.nuance.a.a.a.a.m var13 = new com.nuance.a.a.a.a.m();
      if(this.b != null && var13.a(this.b, ad.a)) {
         if(var13.b() <= 2147483647L) {
            long var7 = var13.b();
            long var5 = 0L;
            int var2 = this.d.size();

            boolean var17;
            while(true) {
               if(var5 >= var7) {
                  var17 = false;
                  break;
               }

               byte[] var14 = new byte[1];
               if(var13.a(var14, var14.length) != var14.length) {
                  var17 = true;
                  break;
               }

               long var9 = (long)var14.length;
               var14 = new byte[var14[0]];
               if(var13.a(var14, var14.length) != var14.length) {
                  var17 = true;
                  break;
               }

               long var11 = (long)var14.length;
               int var1;
               if(var14.length == 1) {
                  var1 = var14[0] & 255;
               } else {
                  byte var16;
                  if(var14.length == 2) {
                     var16 = var14[1];
                     var1 = (var14[0] & 255) + ((var16 & 255) << 8);
                  } else {
                     byte var3;
                     if(var14.length == 3) {
                        var16 = var14[2];
                        var3 = var14[1];
                        var1 = (var14[0] & 255) + ((var16 & 255) << 16) + ((var3 & 255) << 8);
                     } else {
                        var16 = var14[3];
                        var3 = var14[2];
                        byte var4 = var14[1];
                        var1 = (var14[0] & 255) + ((var16 & 255) << 24) + ((var3 & 255) << 16) + ((var4 & 255) << 8);
                     }
                  }
               }

               var14 = new byte[var1];
               if(var13.a(var14, var14.length) != var14.length) {
                  var17 = true;
                  break;
               }

               Object var15 = new Object() {
                  public int a;
                  public byte[] b;
               };
//               ((<undefinedtype>)var15).b = var14;
               this.f += (long)var14.length;
               this.d.add(var15);
               var5 = var5 + var9 + var11 + (long)var14.length;
            }

            var13.a();
            if(var17) {
               var13.c();
               if(a.e()) {
                  a.e("handleLoadFile() failed!!!");
               }
            } else if(a.c()) {
               a.c((Object)("handleLoadFile() " + (this.d.size() - var2) + " events are loaded"));
            }

            this.f();
            return;
         }

         if(a.e()) {
            a.e("calllog file too big (" + var13.b() + " > 2147483647)!!!");
         }

         var13.a();
      } else if(a.c()) {
         a.c((Object)("handleLoadFile() cannot open + file:" + this.b));
         return;
      }

   }

   private void f() {
      if(this.f > this.c) {
         int var1;
         byte[] var2;
         for(var1 = this.d.size(); this.f > this.c; this.f -= (long)var2.length) {
            var2 = (byte[])this.d.remove(0);
         }

         if(a.c()) {
            a.c((Object)("trimEventsList() " + (var1 - this.d.size()) + " events are removed due to size limit (" + this.c + ")"));
            return;
         }
      }

   }

   public final void a() {
      if(a.b()) {
         a.b((Object)"socketOpened()");
      }

   }

   public final void a(int var1) {
      if(a.b()) {
         a.b((Object)("bcpLogResponse requestId = " + var1));
      }

      af var2 = this.i;
      ag var3 = new ag((byte)19, new Object[]{new Integer(var1)});
      Thread var4 = Thread.currentThread();
      this.i.a();
      var2.a(var3, this, var4);
   }

   public final void a(aS var1, aQ var2) {
      af var3 = this.i;
      ag var4 = new ag((byte)20, new Object[]{var1, var2});
      Thread var5 = Thread.currentThread();
      this.i.a();
      var3.a(var4, this, var5);
   }

   final void a(aS var1, aR var2) {
      af var3 = this.i;
      ag var4 = new ag((byte)16, new Object[]{var1, var2});
      Thread var5 = Thread.currentThread();
      this.i.a();
      var3.a(var4, this, var5);
   }

   public final void a(as var1, byte[] var2) {
   }

   public final void a(Object var1, Object var2) {
      ag var6 = (ag)var1;
      aS var7;
      switch(var6.a) {
      case 16:
         var7 = (aS)((Object[])var6.b)[0];
         var2 = new Object() {
            public int a;
            public byte[] b;
         };
//         ((<undefinedtype>)var2).b = var7.f();
         if(this.f < this.c) {
            (new StringBuilder()).append(var7.b.b()).append(var7.d);
            this.d.add(var2);
            long var4 = this.f;
//            this.f = (long)((<undefinedtype>)var2).b.length + var4;
            this.d();
            return;
         }
         break;
      case 17:
         this.e();
         return;
      case 18:
//         <undefinedtype> var8 = (<undefinedtype>)((Object[])var6.b)[0];
         int var3 = this.k;
         this.k = var3 + 1;
         var8.a = var3;
         byte[] var12 = new byte[var8.b.length + 25];
         var12[0] = 0;
         au.a((int)var8.a, var12, 1);
         var12 = ar.a(var12, l);
         au.a((int)var8.b.length, var12, 21);
         System.arraycopy(var8.b, 0, var12, 25, var8.b.length);
         byte[] var9 = ar.a((byte)2, (byte)34, (short)2640, var12);
         this.j.a((byte[])var9, (int)1, "SEND_BCP_LOG");
         return;
      case 19:
         this.b(((Integer)((Object[])var6.b)[0]).intValue());
         return;
      case 20:
         Object[] var10 = (Object[])var6.b;
         var7 = (aS)var10[0];
         aQ var11 = (aQ)var10[1];
         var7.c();
         if(var11 != null) {
            if(var7 instanceof aN) {
               var11.a(((aN)var7).b());
               return;
            }

            var11.a((String)null);
            return;
         }
      }

   }

   public final void a(String var1) {
      if(var1.startsWith("SEND_BCP_LOG") && a.b()) {
         a.b((Object)("onMsgSent(" + var1 + ")"));
      }

   }

   public final void a(short var1, short var2) {
      if(a.b()) {
         a.b((Object)("socketClosed() reason [" + var1 + "] subReason [" + var2 + "]"));
      }

      this.g = false;
   }

   public final aI b() {
      return this.h;
   }

   public final void b(String var1) {
      if(var1.startsWith("SEND_BCP_LOG")) {
         if(a.b()) {
            a.b((Object)("onMsgNotSent(" + var1 + ")"));
         }

//         <undefinedtype> var2 = (<undefinedtype>)this.d.remove(0);
         this.f -= (long)var2.b.length;
         --this.e;
         this.d.add(this.e, var2);
         this.d();
      }

   }

   public final aK c(String var1) {
      if(a.b()) {
         a.b((Object)("openSession(" + var1 + ")"));
      }

      if(((aO)this.h).a != null) {
         throw new aG("Application session already opened.");
      } else {
         aN var2 = (aN)aP.a((aS)this.h, "APP_REMOTEEVENT", (aQ)null).a(new aR());
         aP var3 = aP.a(var2, var1);
         ((aO)this.h).a = var2;
         return var3;
      }
   }

   public final void c() {
      this.g = true;
      this.d();
   }
}
