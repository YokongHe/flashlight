package com.nuance.a.a.a.a;

import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Vector;

public class s implements .ah, .aj {
   private static final .ae a = .bh.a(com.nuance.a.a.a.a.s.class);
   private static final Integer c = new Integer(0);
   private static final Integer d = new Integer(1);
   private static final Integer e = new Integer(2);
   private static final Integer f = new Integer(3);
   private .af b = null;
   private Object g = new Object();

   public s(.af var1) {
      this.b = var1;
   }

   // $FF: synthetic method
   static .ae a() {
      return a;
   }

   // $FF: synthetic method
   static Object a(com.nuance.a.a.a.a.s var0) {
      return var0.g;
   }

   // $FF: synthetic method
   static void a(com.nuance.a.a.a.a.s var0, Object[] var1) {
      var0.a(var1);
   }

   private void a(Object[] var1) {
      .af var2 = this.b;
      Object var3 = this.b.b();
      this.b.a();
      var2.a(var1, this, var3);
   }

   // $FF: synthetic method
   static Integer b() {
      return c;
   }

   // $FF: synthetic method
   static Integer c() {
      return e;
   }

   public final .am a(Object var1, .al var2, byte[] var3, int var4, .ao var5, Object var6) {
      if(var2 != .al.a) {
         if(a.e()) {
            a.e("Blackberry NetworkSystem only supports NETWORK_READ_FULL");
         }

         return .am.b;
      } else {
         com.nuance.a.a.a.a.t var7 = (com.nuance.a.a.a.a.t)var1;
         if(var7.f != null) {
            if(!com.nuance.a.a.a.a.v.a(var7.f)) {
               com.nuance.a.a.a.a.u var8 = new com.nuance.a.a.a.a.u(var3, var4, var5, var6);
               return var7.f.a(var8);
            } else {
               if(a.e()) {
                  a.e("socket read thread is stopping");
               }

               return .am.b;
            }
         } else {
            if(a.b()) {
               a.b((Object)"SOCKET READ ERROR: socket read thread is null");
            }

            return .am.b;
         }
      }
   }

   public final .am a(Object var1, byte[] var2, int var3, .ap var4, Object var5) {
      if(a.b()) {
         a.b((Object)("socketWrite(bufferLen:" + var3 + ") start"));
      }

      com.nuance.a.a.a.a.t var6 = (com.nuance.a.a.a.a.t)var1;
      if(var6.a != null && var6.d != null) {
         OutputStream var8 = var6.d;

         try {
            var8.write(var2, 0, var3);
            var8.flush();
         } catch (Exception var7) {
            if(a.e()) {
               a.e("Socket Write Exception - [" + var7.getClass().getName() + "] Message - [" + var7.getMessage() + "]");
            }

            this.a(new Object[]{f, var4, .am.b, var1, var2, new Integer(0), new Integer(var3), new Integer(0), var5});
            this.a(var1);
            return .am.b;
         }

         this.a(new Object[]{f, var4, .am.a, var1, var2, new Integer(0), new Integer(var3), new Integer(var3), var5});
         if(a.b()) {
            a.b((Object)("socketWrite(bufferLen:" + var3 + ") end"));
         }

         return .am.a;
      } else {
         return .am.b;
      }
   }

   public final void a(Object param1) {
      // $FF: Couldn't be decompiled
   }

   public final void a(Object var1, Object var2) {
      Object[] var3 = (Object[])var1;
      if(var3[0] == c) {
         ((.an)var3[1]).a((.am)var3[2], var3[3]);
      } else {
         if(var3[0] == d) {
            ((.ak)var3[1]).a();
            return;
         }

         if(var3[0] == e) {
            ((.ao)var3[1]).a((.am)var3[2], var3[3], (byte[])var3[4], ((Integer)var3[6]).intValue(), ((Integer)var3[7]).intValue(), var3[8]);
            return;
         }

         if(var3[0] == f) {
            ((.ap)var3[1]).a((.am)var3[2], var3[3], ((Integer)var3[6]).intValue(), ((Integer)var3[7]).intValue(), var3[8]);
            return;
         }
      }

   }

   public final void a(String var1, int var2, .an var3, .ak var4) {
      com.nuance.a.a.a.a.v var6 = new com.nuance.a.a.a.a.v(this, var1, var2, var3, var4);

      try {
         var6.start();
      } catch (Exception var5) {
         if(a.e()) {
            a.e("Open Socket Exception - [" + var5.getClass().getName() + "] Message - [" + var5.getMessage() + "]");
         }

         this.a(new Object[]{c, var3, .am.b, null, null});
      }
   }

   public final void a(String var1, int var2, Vector var3, .an var4, .ak var5) {
      .cj var6 = new .cj();
      Enumeration var10 = var3.elements();

      while(var10.hasMoreElements()) {
         .bf var7 = (.bf)var10.nextElement();
         if(var7.a().equals("SSL_SelfSigned_Cert") && ((new String(var7.b())).equals("TRUE") || (new String(var7.b())).equals("true"))) {
            var6.a = true;
         }

         if(var7.a().equals("SSL_Cert_Summary")) {
            var6.b = new String(var7.b());
         }

         if(var7.a().equals("SSL_Cert_Data")) {
            var6.c = new String(var7.b());
         }
      }

      com.nuance.a.a.a.a.v var9 = new com.nuance.a.a.a.a.v(this, var1, var2, var6, var4, var5);

      try {
         var9.start();
      } catch (Exception var8) {
         if(a.e()) {
            a.e("Open Socket Exception - [" + var8.getClass().getName() + "] Message - [" + var8.getMessage() + "]");
         }

         this.a(new Object[]{c, var4, .am.b, null, null});
      }
   }

   public final void b(Object var1) {
      com.nuance.a.a.a.a.t var2 = (com.nuance.a.a.a.a.t)var1;
      if(var2.f != null) {
         var2.f.b();
      } else {
         if(a.b()) {
            a.b((Object)"SOCKET WRITE ERROR: socket read thread is null");
         }

         this.a(var1);
      }
   }
}
