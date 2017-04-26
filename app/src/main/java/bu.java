import java.io.ByteArrayOutputStream;
import java.util.Hashtable;
import java.util.Vector;

public class bu implements aE, ah {
   private static final ae a = bh.a(bu.class);
   private static byte[] m = new byte[16];
   private static int p = 1;
   private static String[] v = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
   private Hashtable b;
   private Hashtable c;
   private Hashtable d;
   private aD e;
   private String f;
   private short g;
   private Vector h;
   private af i;
   private bp j;
   private Vector k;
   private byte[] l = null;
   private M n;
   private M o;
   private boolean q = false;
   private bq r;
   private long s = 1L;
   private byte t = 1;
   private aI u;

   public bu(String var1, short var2, String var3, byte[] var4, String var5, Vector var6, af var7, bp var8) {
      this.f = var1;
      this.g = var2;
      this.i = var7;
      this.j = var8;
      this.r = null;
      this.k = new Vector();
      this.b = new Hashtable();
      this.c = new Hashtable();
      this.d = new Hashtable();
      this.h = new Vector();
      this.e = new aD(this.f, this.g, var3, var4, var5, this, var6, var7);
   }

   public static String a(byte[] var0) {
      if(var0 == null) {
         return "";
      } else {
         StringBuffer var4 = new StringBuffer();

         for(int var1 = 0; var1 < 16; ++var1) {
            byte var3 = var0[var1];
            byte var2 = (byte)((byte)((byte)(var3 & 240) >>> 4) & 15);
            var3 = (byte)(var3 & 15);
            var4.append(v[var2] + v[var3]);
            if(var1 == 3 || var1 == 5 || var1 == 7 || var1 == 9) {
               var4.append("-");
            }
         }

         return var4.toString().toLowerCase();
      }
   }

   private void a(byte var1, Object var2) {
      af var3 = this.i;
      ag var5 = new ag(var1, var2);
      Thread var4 = Thread.currentThread();
      this.i.a();
      var3.a(var5, this, var4);
   }

   private void b(byte[] var1) {
      byte var2 = var1[16];
      short var3 = au.a(var1, 17);

      for(int var4 = 0; var4 < this.h.size(); ++var4) {
         ((bv)this.h.elementAt(var4)).a(var2, var3);
      }

   }

   private void c(String var1) {
      if(this.u != null) {
         aK var2 = this.u.a(var1);
         if(var1.compareTo("ConnectionEstablished") == 0) {
            try {
               var2.a("SessionID", a(this.l));
            } catch (aJ var3) {
               ;
            }
         }

         var2.a();
      }

   }

   private void c(byte[] var1) {
      int var6 = au.b(var1, 0);
      if(this.c.size() != 0) {
         bd var7 = (bd)this.c.get(new Integer(var6));
         if(var7 == null) {
            a.e("Could not find the audio sink associated with AID: " + var6);
            return;
         }

         int var4 = au.b(var1, 4);
         int var2 = 8;
         int var5 = var2;
         int var3 = var4;
         if(ax.b(this.o)) {
            for(var3 = var4; (var1[var2] & 128) > 0; --var3) {
               ++var2;
            }

            var5 = var2 + 1;
            --var3;
         }

         if(var3 > 0 && var3 <= var1.length - var5) {
            try {
               var7.a(var1, var5, var3, false);
            } catch (bk var8) {
               a.e(var8.getMessage());
            }
         }

         if(this.d.size() != 0) {
            bv var9 = (bv)this.d.get(new Integer(var6));
            if(var9 == null) {
               a.e("parseXModeMsgVapPlay:: Could not find the session listener associated with AID: " + var6);
               return;
            }

            var9.e();
            return;
         }
      }

   }

   public static void d() {
   }

   private void k() {
      while(!this.k.isEmpty()) {
         ag var1 = (ag)this.k.firstElement();
         this.k.removeElementAt(0);
         switch(var1.a) {
         case 1:
            this.a((byte)1, var1.b);
            break;
         case 2:
            this.a((byte)2, var1.b);
         case 3:
         default:
            break;
         case 4:
            this.a((byte)4, var1.b);
            break;
         case 5:
            this.a((byte)5, var1.b);
            break;
         case 6:
            this.a((byte)6, var1.b);
            break;
         case 7:
            this.a((byte)7, var1.b);
            break;
         case 8:
            this.a((byte)8, var1.b);
         }
      }

   }

   public final void a() {
   }

   public final void a(byte var1, int var2, bv var3) {
      a.b((Object)("freeResource, TID: " + var1 + ", disconnect timeout: " + var2));
      this.h.removeElement(var3);
      Object[] var4 = new Object[]{new Byte(var1), new Integer(var2)};
      if(this.l != null && this.k.isEmpty()) {
         this.a((byte)4, var4);
      } else {
         this.k.addElement(new ag((byte)4, var4));
      }
   }

   public final void a(int var1) {
      if(a.b()) {
         a.b((Object)("vapRecordBegin, AID: " + var1));
      }

      Integer var2 = new Integer(var1);
      if(this.l != null && this.k.isEmpty()) {
         this.a((byte)5, var2);
      } else {
         this.k.addElement(new ag((byte)5, var2));
      }
   }

   public final void a(int var1, bd var2, bv var3) {
      this.c.put(new Integer(var1), var2);
      this.d.put(new Integer(var1), var3);
   }

   public final void a(M var1, M var2) {
      if(a.b()) {
         a.b((Object)"connect()");
      }

      this.c("Connect");
      this.n = var1;
      this.o = var2;
      this.a((byte)1, (Object)null);
   }

   public final void a(aI var1) {
      this.u = var1.a("NMSPSession").a();
      this.e.a(this.u);
   }

   public final void a(as var1, byte[] var2) {
      if(a.b()) {
         a.b((Object)("xmodeMsgCallback, protocol: " + var1.a + ", command: " + var1.b));
      }

      int var7;
      bq var11;
      bv var17;
      switch(var1.a) {
      case 1:
         switch(var1.b) {
         case 512:
            this.c(var2);
            return;
         case 528:
            var7 = au.b(var2, 0);
            if(this.d.size() != 0) {
               var17 = (bv)this.d.get(new Integer(var7));
               if(var17 == null) {
                  a.e("parseVapPlayBegin:: Could not find the session listener associated with AID: " + var7);
                  return;
               }

               var17.d();
               return;
            }

            return;
         case 1024:
            var7 = au.b(var2, 0);
            if(this.c.size() != 0) {
               bd var18 = (bd)this.c.remove(new Integer(var7));
               if(var18 == null) {
                  a.e("Could not find the audio sink associated with AID: " + var7);
                  return;
               }

               try {
                  var18.a((byte[])null, 0, 0, true);
               } catch (bk var12) {
                  a.e(var12.getMessage());
               }

               var17 = (bv)this.d.remove(new Integer(var7));
               if(var17 == null) {
                  a.e("parseXModeMsgVapPlayEnd:: Could not find the session listener associated with AID: " + var7);
                  return;
               }

               var17.f();
               return;
            }

            return;
         default:
            return;
         }
      case 2:
         byte var3;
         short var4;
         int var8;
         long var9;
         byte[] var14;
         bv var16;
         switch(var1.b) {
         case 2576:
            var3 = var2[16];
            var7 = au.b(var2, 17);
            var4 = au.a(var2, 21);
            short var5 = au.a(var2, 23);
            short var6 = au.a(var2, 25);
            var17 = (bv)this.b.get(new Long((long)var7));
            if(var17 != null) {
               var17.a(var3, (long)var7, var4, var5, var6);
               if(var4 != 200) {
                  this.b.remove(new Long((long)var7));
                  return;
               }
            }

            return;
         case 2577:
            var9 = (long)au.b(var2, 17);
            au.b(var2, 21);
            au.a(var2, 25);
            this.b.remove(new Long(var9));
            return;
         case 2578:
            return;
         case 2579:
            var9 = (long)au.b(var2, 17);
            au.a(var2, 21);
            var7 = au.b(var2, 23);
            if(var7 > 0 && var7 <= var2.length - 27) {
               System.arraycopy(var2, 27, new byte[var7], 0, var7);
            }

            this.b.remove(new Long(var9));
            return;
         case 2580:
            var9 = (long)au.b(var2, 17);
            au.a(var2, 21);
            var7 = au.b(var2, 23);
            if(var7 > 0 && var7 <= var2.length - 27) {
               System.arraycopy(var2, 27, new byte[var7], 0, var7);
            }

            this.b.get(new Long(var9));
            return;
         case 2582:
            var11 = null;
            var3 = var2[16];
            var7 = au.b(var2, 17);
            var4 = au.a(var2, 21);
            var8 = au.b(var2, 23);
            var14 = (byte[])var11;
            if(var8 > 0) {
               var14 = (byte[])var11;
               if(var8 <= var2.length - 27) {
                  var14 = new byte[var8];
                  System.arraycopy(var2, 27, var14, 0, var8);
               }
            }

            var16 = (bv)this.b.remove(new Long((long)var7));
            if(var16 != null) {
               var16.a(var3, (long)var7, var4, var14);
               return;
            }

            return;
         case 2584:
            var11 = null;
            var3 = var2[16];
            var7 = au.b(var2, 17);
            var4 = au.a(var2, 21);
            var8 = au.b(var2, 23);
            var14 = (byte[])var11;
            if(var8 > 0) {
               var14 = (byte[])var11;
               if(var8 <= var2.length - 27) {
                  var14 = new byte[var8];
                  System.arraycopy(var2, 27, var14, 0, var8);
               }
            }

            var16 = (bv)this.b.remove(new Long((long)var7));
            if(var16 != null) {
               var16.b(var3, (long)var7, var4, var14);
               return;
            }

            return;
         case 2585:
            var3 = var2[16];
            var7 = au.b(var2, 21);
            if(var7 > 0 && var7 <= var2.length - 25) {
               var14 = new byte[var7];
               System.arraycopy(var2, 25, var14, 0, var7);
               var16 = (bv)this.b.get(new Long(0L));
               if(var16 != null) {
                  var16.a(var3, var14);
                  return;
               }
            }

            return;
         case 2600:
            this.b(var2);
            return;
         default:
            a.e("Unknown BCP command");
            return;
         }
      case 3:
         switch(var1.b) {
         case 257:
            this.l = this.e.b;
            if(a.b()) {
               a.b((Object)("connected(" + a(this.l) + ") called on " + this.j));
            }

            this.c("ConnectionEstablished");
            bp var13 = this.j;
            String var15 = a(this.l);
            var11 = this.r;
            var13.a(var15);

            for(var7 = 0; var7 < this.h.size(); ++var7) {
               ((bv)this.h.elementAt(var7)).a(this.l);
            }

            this.k();
            return;
         case 512:
         case 768:
            return;
         default:
            return;
         }
      default:
         a.e("Unknown Xmode protocol");
      }
   }

   public final void a(bq var1) {
      this.r = var1;
   }

   public final void a(bv var1) {
      if(!this.h.contains(var1)) {
         this.h.addElement(var1);
      }

   }

   public final void a(Object var1, Object var2) {
      ag var13 = (ag)var1;
      byte var3;
      int var5;
      int var6;
      byte[] var14;
      Object[] var17;
      switch(var13.a) {
      case 1:
         this.e.a(this.n.a(), this.o.a());
         return;
      case 2:
         this.e.b();
         return;
      case 3:
         this.q = true;
         this.e.b();
         return;
      case 4:
         if(this.l != null) {
            var17 = (Object[])var13.b;
            var3 = ((Byte)var17[0]).byteValue();
            var5 = ((Integer)var17[1]).intValue();
            var14 = new byte[5];
            var14[0] = var3;
            au.a((int)var5, var14, 1);
            var14 = ar.a((byte)2, (byte)34, (short)2601, ar.a(var14, this.l));
            this.e.a((byte[])var14, (int)3, "SEND_BCP_FREE_RESOURCE");
            return;
         }
         break;
      case 5:
         if(this.l != null) {
            var5 = ((Integer)var13.b).intValue();
            this.e.a(var5);
            return;
         }
         break;
      case 6:
         if(this.l != null) {
            var17 = (Object[])var13.b;
            byte[] var16 = (byte[])var17[0];
            var6 = ((Integer)var17[1]).intValue();

            for(var5 = 0; var5 < this.h.size(); ++var5) {
               ((bv)this.h.elementAt(var5)).c();
            }

            this.e.a(var16, var6);
            return;
         }
         break;
      case 7:
         if(this.l != null) {
            var5 = ((Integer)var13.b).intValue();
            this.e.b(var5);
            return;
         }
         break;
      case 8:
         if(this.l != null) {
            Object[] var12 = (Object[])var13.b;
            short var4 = ((Short)var12[0]).shortValue();
            String var15 = (String)var12[1];
            var14 = (byte[])var12[2];
            byte[] var11 = (byte[])var12[3];
            var3 = ((Byte)var12[4]).byteValue();
            long var7 = ((Long)var12[5]).longValue();
            bv var10 = (bv)var12[6];
            boolean var9 = ((Boolean)var12[7]).booleanValue();
            this.b.put(new Long(var7), var10);
            var6 = var14.length + 5;
            var5 = var6;
            if(var4 == 2585) {
               var5 = var6 + 4;
            }

            byte[] var19 = new byte[var5];
            var19[0] = var3;
            byte var18 = 1;
            if(var4 == 2585) {
               au.a((int)((int)var7), var19, 1);
               var18 = 5;
            }

            au.a((int)var14.length, var19, var18);
            System.arraycopy(var14, 0, var19, var18 + 4, var14.length);
            if(this.l != null) {
               var14 = this.l;
            } else {
               var14 = m;
            }

            var14 = ar.a(var19, var14);
            ByteArrayOutputStream var20 = new ByteArrayOutputStream();
            var20.write(var14, 0, var14.length);
            if(var11 != null) {
               var20.write(var11, 0, var11.length);
            }

            var14 = ar.a((byte)2, (byte)34, var4, var20.toByteArray());
            this.e.a((byte[])var14, (int)3, var15);
            if(var9) {
               if(var4 == 2581) {
                  if(var10 != null) {
                     var10.a(var3, var7, (short)200, (byte[])null);
                     return;
                  }
               } else if(var4 == 2608 && var10 != null) {
                  this.h.removeElement(var10);
                  var10.b();
                  return;
               }
            }
         }
         break;
      default:
         a.e("Unknown command");
      }

   }

   public final void a(String var1) {
   }

   public final void a(short var1, String var2, byte[] var3, byte[] var4, byte var5, long var6, bv var8, boolean var9) {
      if(a.b()) {
         a.b((Object)("postBcpMessage, BCP: " + var1 + ", TID: " + var5 + ", RID: " + var6));
      }

      Object[] var10 = new Object[]{new Short(var1), var2, var3, var4, new Byte(var5), new Long(var6), var8, new Boolean(var9)};
      if(this.l != null && this.k.isEmpty()) {
         this.a((byte)8, var10);
      } else {
         this.k.addElement(new ag((byte)8, var10));
      }
   }

   public final void a(short var1, short var2) {
      if(a.b()) {
         a.b((Object)("socketClosed, reason: " + var1));
      }

      if(a.b()) {
         a.b((Object)("socketClosed() sessionListeners.size():" + this.h.size()));
      }

      for(int var3 = 0; var3 < this.h.size(); ++var3) {
         ((bv)this.h.elementAt(var3)).a(var1);
      }

      if(!this.k.isEmpty()) {
         this.k.removeAllElements();
      }

      this.h.removeAllElements();
      bp var4;
      bq var5;
      if(var1 != 4 && var1 != 5) {
         if(var1 == 7) {
            var4 = this.j;
            var5 = this.r;
            var4.b(var2);
         } else if(var1 == 8 && this.l == null) {
            var4 = this.j;
            var5 = this.r;
            var4.b((short)9);
         } else if(this.l != null) {
            var4 = this.j;
            var5 = this.r;
            var4.a(var2);
         }
      } else {
         var4 = this.j;
         var5 = this.r;
         var4.b((short)9);
      }

      if(var1 == 1 && this.q) {
         this.i.c();
         this.j.a();
      }

      this.l = null;
   }

   public final void a(byte[] var1, int var2) {
      if(a.b()) {
         a.b((Object)("vapRecord, AID: " + var2));
      }

      Object[] var3 = new Object[]{var1, new Integer(var2)};
      if(this.l != null && this.k.isEmpty()) {
         this.a((byte)6, var3);
      } else {
         this.k.addElement(new ag((byte)6, var3));
      }
   }

   public final aD b() {
      return this.e;
   }

   public final void b(int var1) {
      if(a.b()) {
         a.b((Object)("vapRecordEnd, AID: " + var1));
      }

      Integer var2 = new Integer(var1);
      if(this.l != null && this.k.isEmpty()) {
         this.a((byte)7, var2);
      } else {
         this.k.addElement(new ag((byte)7, var2));
      }
   }

   public final void b(bv var1) {
      this.h.removeElement(var1);
   }

   public final void b(String var1) {
   }

   public final int c() {
      synchronized(this){}

      int var1;
      try {
         var1 = p;
         p = var1 + 1;
         if(p == Integer.MIN_VALUE) {
            p = 1;
         }
      } finally {
         ;
      }

      return var1;
   }

   public final void e() {
      if(a.b()) {
         a.b((Object)"disconnectAndShutdown");
      }

      this.a((byte)3, (Object)null);
   }

   public final byte[] f() {
      return this.l;
   }

   public final long g() {
      long var1 = this.s;
      this.s = var1 + 1L;
      if(this.s == Long.MIN_VALUE) {
         this.s = 1L;
      }

      return var1;
   }

   public final byte h() {
      byte var1 = this.t;
      this.t = (byte)(var1 + 1);
      if(this.t == -128) {
         this.t = 1;
      }

      return var1;
   }

   public final M i() {
      return this.n;
   }

   public final aI j() {
      return this.u;
   }
}
