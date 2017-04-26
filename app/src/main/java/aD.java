import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class aD implements ah, ak, an, ao, ap {
   private static ae c = bh.a(aD.class);
   private aE A;
   private aI B;
   private aP C = null;
   private Queue D = new LinkedList();
   private Queue E = new LinkedList();
   protected byte a;
   public byte[] b;
   private aq d;
   private int e = 30;
   private aq f;
   private int g = 50;
   private aq h;
   private String i = null;
   private short j = 0;
   private Vector k;
   private boolean l = false;
   private Vector m = null;
   private af n = null;
   private Object o;
   private as p = null;
   private short q = 0;
   private short r = 9;
   private String s = "Not specified";
   private String t = "Not specified";
   private byte[] u = null;
   private aj v = null;
   private String w = "";
   private int x;
   private short y;
   private short z;

   public aD(String var1, short var2, String var3, byte[] var4, String var5, aE var6, Vector var7, af var8) {
      this.i = var1;
      this.j = var2;
      this.s = var3;
      this.u = var4;
      this.t = var5;
      this.A = var6;
      if(var7 != null) {
         this.k = var7;
      } else {
         this.k = new Vector();
      }

      this.n = var8;
      if(c.b()) {
         c.b((Object)("XMode() server: " + var1 + " port: " + var2));
      }

      Enumeration var10 = var7.elements();

      while(true) {
         while(true) {
            bf var11;
            do {
               if(!var10.hasMoreElements()) {
                  this.a = 3;
                  return;
               }

               var11 = (bf)var10.nextElement();
               if(c.b()) {
                  c.b((Object)("XMode() " + var11.d() + " : " + var11.a() + " = " + new String(var11.b())));
               }
            } while(var11.d() != bg.a);

            if(var11.a().equals("IdleSessionTimeout")) {
               int var9 = Integer.parseInt(new String(var11.b()));
               if(var9 > 0) {
                  this.g = var9;
               }
            } else if(var11.a().equals("ConnectionTimeout")) {
               this.e = Integer.parseInt(new String(var11.b()));
            } else if(var11.a().equals("SSL_Socket_Enable") || var11.a().equals("SSL_Cert_Summary") || var11.a().equals("SSL_Cert_Data") || var11.a().equals("SSL_SelfSigned_Cert")) {
               if(var11.a().equals("SSL_Socket_Enable") && ((new String(var11.b())).equals("TRUE") || (new String(var11.b())).equals("true"))) {
                  this.l = true;
               }

               if(this.m == null) {
                  this.m = new Vector();
               }

               this.m.addElement(var11);
            }
         }
      }
   }

   // $FF: synthetic method
   static short a(aD var0) {
      var0.q = 3;
      return (short)3;
   }

   private void a(byte var1, Object var2) {
      try {
         af var3 = this.n;
         ag var6 = new ag(var1, var2);
         Thread var4 = Thread.currentThread();
         this.n.a();
         var3.a(var6, this, var4);
      } catch (Exception var5) {
         if(c.e()) {
            c.e("XMode.sendCmdMsg() " + var5.getMessage());
            return;
         }
      }

   }

   private void a(as var1, byte[] var2) {
      if(c.b()) {
         c.b((Object)("XMode.parseXModeMsg() protocol: " + var1.a + " cmd: " + var1.b));
      }

      switch(var1.a) {
      case 1:
         if(this.h != null && this.n.a(this.h)) {
            this.h = new aq() {
               // $FF: synthetic field
               private aD a = aD.this;

               public final void run() {
                  try {
                     aD.a(this.a);
                     if(aD.c.e()) {
                        aD.c.e("Session Idle for too long, longer than [" + this.a.g + "] (initiated from XMode.parseVap)");
                     }

                     this.a.a = 2;
                     this.a.a((byte)4, (Object)null);
                  } catch (Exception var2) {
                     if(aD.c.e()) {
                        aD.c.e("XMode.parseXModeMsg() " + var2.getClass().getName() + " " + var2.getMessage());
                        return;
                     }
                  }

               }
            };
            this.n.a(this.h, (long)(this.g * 1000));
         }

         this.A.a(var1, var2);
         return;
      case 2:
         if(this.h != null && this.n.a(this.h)) {
            this.h = new aq() {
               // $FF: synthetic field
               private aD a = aD.this;

               public final void run() {
                  try {
                     aD.a(this.a);
                     if(aD.c.e()) {
                        aD.c.e("Session Idle for too long, longer than [" + this.a.g + "] (initiated from XMode.parseBcp)");
                     }

                     this.a.a = 2;
                     this.a.a((byte)4, (Object)null);
                  } catch (Exception var2) {
                     if(aD.c.e()) {
                        aD.c.e("XMode.parseXModeMsg() " + var2.getClass().getName() + " " + var2.getMessage());
                        return;
                     }
                  }

               }
            };
            this.n.a(this.h, (long)(this.g * 1000));
         }

         if(var1.b != 2641) {
            this.A.a(var1, var2);
            return;
         }

         int var4 = au.b(var2, 17);
         short var5 = au.a(var2, 21);
         aL var10 = (aL)((aS)this.B).c;
         if(var5 == 0 || var5 == 1 || var5 == 3) {
            var10.a(var4);
            return;
         }

         if(c.e()) {
            c.e("XMode.parseXModeMsgBcpLogResponse() XMODE_BCP_LOG_WRITE_ERROR. ");
            return;
         }
         break;
      case 3:
         switch(var1.b) {
         case 257:
            this.n.a(this.f);
            if(this.C != null) {
               this.C.a();
               this.C = null;
            }

            this.b = new byte[16];
            System.arraycopy(var2, 0, this.b, 0, 16);
            af var6 = this.n;
            byte[] var11 = this.b;
            aj var12 = this.v;
            Object var13 = this.o;
            var11 = this.b;
            if(this.B != null) {
               aL var14 = (aL)((aS)this.B).c;
               if(var14 != null) {
                  var14.c();
               }
            }

            this.w = ae.b(this.b);
            ae var15 = c;
            String var7 = this.w;
            var15.f();

            try {
               if(c.b()) {
                  c.b((Object)("Received COP_Connected " + this.w));
               }

               this.a((byte)10, (Object)null);
            } finally {
               c.g();
            }

            this.a("SocketOpened");
            this.h = new aq() {
               // $FF: synthetic field
               private aD a = aD.this;

               public final void run() {
                  try {
                     aD.a(this.a);
                     if(aD.c.e()) {
                        aD.c.e("Session Idle for too long, longer than [" + this.a.g + "] (initiated from XMode.parseCopConnected)");
                     }

                     this.a.a = 2;
                     this.a.a((byte)4, (Object)null);
                  } catch (Exception var2) {
                     if(aD.c.e()) {
                        aD.c.e("XMode.parseXModeMsg() " + var2.getClass().getName() + " " + var2.getMessage());
                        return;
                     }
                  }

               }
            };
            this.n.a(this.h, (long)(this.g * 1000));
            break;
         case 258:
            this.x = au.b(var2, 0);
            this.a((byte)8, (Object)null);
            break;
         case 512:
            if(this.h != null) {
               this.n.a(this.h);
            }

            this.r = au.a(var2, 0);
            this.a = 2;
            this.q = 6;
            if(c.d()) {
               c.d("XMode.parseXModeMsgCopDisconnect() Received COP DISCONNECT. ");
            }

            this.a((byte)4, (Object)null);
            break;
         case 768:
            short var3 = au.a(var2, 0);
            au.b(var2, 2);
            this.q = 7;
            this.r = var3;
            this.a = 2;
            if(c.e()) {
               c.e("XMode.parseXModeMsgCopConnectFailed() COP CONNECT failure. ");
            }

            this.a((byte)4, (Object)null);
         }

         this.A.a(var1, var2);
         return;
      case 15:
         break;
      default:
         if(c.e()) {
            c.e("XMode.parseXModeMsg() unknown protocol: " + Integer.toHexString(var1.a));
         }
      }

   }

   private void a(String var1) {
      if(this.B != null) {
         this.B.a(var1).a();
      }

   }

   // $FF: synthetic method
   static aP d(aD var0) {
      var0.C = null;
      return null;
   }

   public final void a() {
      if(c.b()) {
         c.b((Object)("XMode.closeSocketCallback() " + this.w));
      }

      this.a = 3;
      if(this.d != null) {
         this.n.a(this.d);
         this.d = null;
      }

      if(this.h != null) {
         this.n.a(this.h);
         this.h = null;
      }

      if(this.o != null) {
         this.A.a(this.q, this.r);
      }

      if(this.B != null) {
         aL var1 = (aL)((aS)this.B).c;
         if(var1 != null) {
            var1.a(this.q, this.r);
         }
      }

      this.o = null;
      this.v = null;
      this.b = null;
      this.w = "";
   }

   public final void a(int var1) {
      if(c.b()) {
         c.b((Object)("XMode.startStreaming() audio id: " + var1));
      }

      if(this.a == 1) {
         byte[] var2 = new byte[6];
         au.a((int)var1, var2, 0);
         au.a((short)this.y, var2, 4);
         this.a((byte[])ar.a((byte)1, (byte)18, (short)257, var2), (int)3, "SEND_VAP_RECORD_BEGIN");
      }
   }

   public final void a(aI var1) {
      if(var1 != null) {
         this.B = var1.a("NMSPSocket").a();
      }

   }

   public final void a(am var1, Object var2) {
      if(c.b()) {
         c.b((Object)"XMode.openSocketCallback() ");
      }

      if(var1 == am.a) {
         this.o = var2;
         if(this.a != 0) {
            this.a = 2;
            this.v.a(this.o);
            return;
         }

         if(this.B != null) {
            this.a((byte)13, (Object)null);
            return;
         }

         this.a((byte)7, (Object)null);
      } else {
         if(var1 == am.b) {
            if(c.e()) {
               c.e("XMode.openSocketCallback() NETWORK_ERROR");
            }

            this.a = 3;
            this.q = 4;
            this.A.a(this.q, this.r);
            this.o = null;
            this.v = null;
            this.b = null;
            this.w = "";
            return;
         }

         if(var1 == am.c) {
            this.q = 4;
            if(c.e()) {
               c.e("XMode.openSocketCallback() NETWORK_MEMORY_ERROR");
               return;
            }
         }
      }

   }

   public final void a(am var1, Object var2, int var3, int var4, Object var5) {
      byte var7 = 0;
      byte var6 = 0;
      String var8 = (String)((aF)var5).b;
      if(var1 == am.a && var3 == var4) {
         if(var8.equals("SEND_COP_CONNECT")) {
            this.a((byte)5, (Object)null);
         } else if(var8.equals("SEND_COP_DISCONNECT")) {
            this.v.a(var2);
         }

         this.a((byte)11, var8);
         this.D.remove(var5);
         if(this.D.size() == 0 && this.E.size() > 0) {
            this.a((byte)14, (Object)null);
         }
      } else if(var1 == am.b) {
         if(this.q != 1 && this.q != 3) {
            this.q = 8;
            if(c.e()) {
               c.e("XMode.writeSocketCallback() NETWORK_ERROR");
            }
         }

         this.a((byte)12, var8);
         this.D.remove(var5);
         if(this.D.size() == 0) {
            var4 = this.E.size();

            for(var3 = var6; var3 < var4; ++var3) {
               this.a((byte)12, ((aF)this.E.remove()).b);
            }
         }
      } else if(var1 == am.c) {
         if(this.q != 1 && this.q != 3) {
            this.q = 8;
            if(c.e()) {
               c.e("XMode.writeSocketCallback() NETWORK_MEMORY_ERROR");
            }
         }

         this.a((byte)12, var8);
         this.D.remove(var5);
         if(this.D.size() == 0) {
            var4 = this.E.size();

            for(var3 = var7; var3 < var4; ++var3) {
               this.a((byte)12, ((aF)this.E.remove()).b);
            }
         }
      }

   }

   public final void a(am var1, Object var2, byte[] var3, int var4, int var5, Object var6) {
      String var7 = (String)var6;
      if(c.b()) {
         c.b((Object)"Read callback");
      }

      if(c.a()) {
         c.a(var3);
      }

      if(var1 == am.a) {
         if(var7.equals("READ_XMODE_HEADER")) {
            if(var5 == 0) {
               this.d = new aq() {
                  // $FF: synthetic field
                  private aD a = aD.this;

                  public final void run() {
                     try {
                        this.a.a((byte)5, (Object)null);
                     } catch (Exception var2) {
                        if(aD.c.e()) {
                           aD.c.e("XMode.readSocketCallback() " + var2.getClass().getName() + " " + var2.getMessage());
                           return;
                        }
                     }

                  }
               };
               this.n.a(this.d, 20L);
            } else {
               if(var5 == var4) {
                  this.p = new as(var3);
                  if(this.p.c == 0) {
                     this.a((as)this.p, (byte[])null);
                     this.a((byte)5, (Object)null);
                     return;
                  }

                  if(this.p.c <= 512000 && this.p.c >= 0) {
                     this.a((byte)6, (Object)null);
                     return;
                  }

                  this.v.b(var2);
                  this.a((byte)5, (Object)null);
                  return;
               }

               if(c.e()) {
                  c.e("----***---- readSocketCallback fatal error in readSocketCallback NET_CONTEXT_READ_XMODE_HEADER bytesRead:[" + var5 + "] bufferLen:[" + var4 + "]");
                  return;
               }
            }
         } else if(var7.equals("READ_XMODE_PAYLOAD")) {
            if(var5 == 0) {
               if(c.b()) {
                  c.b((Object)(Integer.toHexString(this.p.b) + " payload not read bytesRead is 0"));
               }

               this.d = new aq() {
                  // $FF: synthetic field
                  private aD a = aD.this;

                  public final void run() {
                     try {
                        this.a.a((byte)6, (Object)null);
                     } catch (Exception var2) {
                        if(aD.c.e()) {
                           aD.c.e("XMode.readSocketCallback() " + var2.getClass().getName() + " " + var2.getMessage());
                           return;
                        }
                     }

                  }
               };
               this.n.a(this.d, 20L);
               return;
            }

            if(var5 == var4) {
               if(this.p.c <= var4) {
                  this.a(this.p, var3);
               }

               this.a((byte)5, (Object)null);
               return;
            }

            if(c.e()) {
               c.e("----***---- readSocketCallback fatal error in readSocketCallback NET_CONTEXT_READ_XMODE_PAYLOAD bytesRead:[" + var5 + "] bufferLen:[" + var4 + "]");
               return;
            }
         }
      } else {
         if(var1 == am.b) {
            if(this.q != 1 && this.q != 3 && this.q != 6) {
               this.q = 8;
               if(c.e()) {
                  c.e("XMode.readSocketCallback() NETWORK_ERROR");
               }
            }

            this.a((byte)4, (Object)null);
            return;
         }

         if(var1 == am.c && this.q != 1 && this.q != 3) {
            this.q = 8;
            if(c.e()) {
               c.e("XMode.readSocketCallback() NETWORK_MEMORY_ERROR");
               return;
            }
         }
      }

   }

   public final void a(Object var1, Object var2) {
      ag var7 = (ag)var1;
      String var8;
      byte[] var9;
      byte[] var10;
      switch(var7.a) {
      case 1:
         if(c.b()) {
            c.b((Object)"XMode.handleMessage() CMD_CONNECT");
         }

         if(this.a == 0) {
            this.a((byte)3, (Object)null);
            return;
         }

         this.A.a(this.q, this.r);
         return;
      case 2:
         if(c.b()) {
            c.b((Object)"XMode.handleMessage() CMD_DISCONNECT");
         }

         var9 = new byte[2];
         au.a((short)0, var9, 0);
         var9 = ar.a((byte)3, (byte)23, (short)512, var9);
         this.v.b(this.o);
         this.a((byte[])var9, (int)3, "SEND_COP_DISCONNECT");
         return;
      case 3:
         if(c.b()) {
            c.b((Object)"XMode.handleMessage() CMD_OPEN_SOCKET");
         }

         if(this.a == 0) {
            this.v = new com.nuance.a.a.a.a.s(this.n);
            if(this.l) {
               this.v.a(this.i, this.j, this.m, this, this);
               return;
            }

            this.v.a(this.i, this.j, this, this);
            return;
         }

         this.A.a(this.q, this.r);
         return;
      case 4:
         if(c.b()) {
            c.b((Object)"XMode.handleMessage() CMD_CLOSE_SOCKET");
         }

         if(this.v != null && this.o != null) {
            this.v.a(this.o);
            return;
         }
         break;
      case 5:
         if(this.v != null && this.o != null) {
            var9 = new byte[8];
            this.v.a(this.o, al.a, var9, 8, this, "READ_XMODE_HEADER");
            return;
         }
         break;
      case 6:
         if(this.p.c > 0 && this.p.c <= 512000) {
            var9 = new byte[this.p.c];
            if(this.v != null && this.o != null) {
               this.v.a(this.o, al.a, var9, var9.length, this, "READ_XMODE_PAYLOAD");
               return;
            }
         }
         break;
      case 7:
         if(c.b()) {
            c.b((Object)"XMode.handleMessage() CMD_COP_CONNECT");
         }

         if(this.a == 0) {
            var8 = (String)var7.b;
            StringBuilder var11 = (new StringBuilder("<?xml version=\"1.0\"?><cc><s></s><t>7</t><b>20091023</b><tsc>")).append(this.y).append("</tsc><fsc>").append(this.z).append("</fsc><nmaid>").append(this.s).append("</nmaid><uid>").append(this.t).append("</uid>");
            if(var8 != null) {
               var8 = "<rootlog>" + var8 + "</rootlog>";
            } else {
               var8 = "";
            }

            var8 = var11.append(var8).toString();
            Enumeration var5 = this.k.elements();
            boolean var3 = false;

            String var12;
            while(var5.hasMoreElements()) {
               bf var6;
               label118: {
                  var6 = (bf)var5.nextElement();
                  var12 = var8;
                  if(var6.d() == bg.b) {
                     var12 = new String(var6.b());
                     var8 = var8 + "<nmsp p=\"" + var6.a() + "\" v=\"" + ax.a(var12) + "\"/>";
                     var12 = var8;
                     if(var6.a().equals("Ping_IntervalSecs")) {
                        var3 = true;
                        break label118;
                     }
                  }

                  var8 = var12;
               }

               if(var6.d() == bg.c) {
                  var12 = new String(var6.b());
                  var8 = var8 + "<app p=\"" + var6.a() + "\" v=\"" + ax.a(var12) + "\"/>";
               }
            }

            var12 = var8;
            if(!var3) {
               var12 = var8 + "<nmsp p=\"Ping_IntervalSecs\" v=\"0\"/>";
            }

            var9 = (var12 + "</cc>").getBytes();
            int var13 = var9.length;
            int var4 = var13 + 4 + 1;
            var10 = new byte[var4];
            au.a((int)(var4 - 4), var10, 0);
            var10[4] = 0;
            System.arraycopy(var9, 0, var10, 5, var13);
            this.a((byte[])ar.a((byte)3, (byte)23, (short)256, var10), (int)3, "SEND_COP_CONNECT");
            this.f = new aq() {
               // $FF: synthetic field
               private aD a = aD.this;

               public final void run() {
                  try {
                     if(aD.c.e()) {
                        aD.c.e("XMode.handleSendCopConnect() COP CONNECT timed out. ");
                     }

                     if(this.a.C != null) {
                        this.a.C.b();
                        aD.d(this.a);
                     }

                     this.a.a((byte)9, (Object)null);
                  } catch (Exception var2) {
                     if(aD.c.e()) {
                        aD.c.e("XMode.handleSendCopConnect() " + var2.getClass().getName() + " " + var2.getMessage());
                        return;
                     }
                  }

               }
            };
            this.n.a(this.f, (long)(this.e * 1000));
            this.a = 1;
            this.A.a();
            return;
         }
         break;
      case 8:
         if(c.b()) {
            c.b((Object)"XMode.handleMessage() CMD_COP_PING_RESPONSE");
         }

         var9 = new byte[8];
         au.a((int)this.x, var9, 0);
         au.a((int)0, var9, 4);
         this.a((byte[])ar.a((byte)3, (byte)23, (short)259, var9), (int)3, "SEND_COP_PING_RESPONSE");
         return;
      case 9:
         if(c.b()) {
            c.b((Object)"XMode.handleMessage() CMD_COP_CONNECT_TIMED_OUT");
         }

         if(this.a == 1) {
            this.a = 2;
            this.q = 5;
            if(c.e()) {
               c.e("XMode.handleCopConnectTimeout() COP CONNECT timed out. ");
            }

            this.a((byte)4, (Object)null);
            return;
         }
         break;
      case 10:
         if(c.b()) {
            c.b((Object)"XMode.handleMessage() CMD_COP_CONFIRM");
         }

         var9 = ai.b(this.u, this.b);
         var10 = new byte[var9.length + 4];
         au.a((int)var9.length, var10, 0);
         System.arraycopy(var9, 0, var10, 4, var9.length);
         this.a((byte[])ar.a((byte)3, (byte)23, (short)262, var10), (int)3, "SEND_COP_CONFIRM");
         return;
      case 11:
         var8 = (String)var7.b;
         this.A.a(var8);
         return;
      case 12:
         var8 = (String)var7.b;
         this.A.b(var8);
         return;
      case 13:
         if(c.b()) {
            c.b((Object)"XMode.handleMessage() CMD_GENERATE_COP_REF_ID");
         }

         this.C = aP.a((aS)((aS)this.B).e(), "NMSP_GATEWAY", new aQ() {
            // $FF: synthetic field
            private aD a = aD.this;

            public final void a(String var1) {
               this.a.a((byte)7, var1);
            }
         });
         return;
      case 14:
         if(c.b()) {
            c.b((Object)"XMode.handleMessage() CMD_SEND_LOW_PRIORITY_MSG");
         }

         this.a((byte[])null, (int)2, (Object)null);
         return;
      }

   }

   public final void a(short var1, short var2) {
      if(c.b()) {
         c.b((Object)("XMode.connect() codec: " + var2));
      }

      if(this.a != 1 && this.a != 0) {
         if(this.a == 2) {
            if(this.d != null) {
               this.n.a(this.d);
            }

            if(this.h != null) {
               this.n.a(this.h);
            }

            this.a("OpenSocket");
            this.o = null;
            this.v = null;
            this.b = null;
            this.w = "";
            this.y = var1;
            this.z = var2;
            this.a = 0;
            this.a((byte)1, (Object)null);
         } else if(this.a == 3) {
            this.a("OpenSocket");
            this.y = var1;
            this.z = var2;
            this.a = 0;
            this.a((byte)1, (Object)null);
            return;
         }
      }

   }

   public final void a(byte[] var1, int var2) {
      if(c.b()) {
         c.b((Object)("XMode.sendVapRecordMsg() audio id: " + var2));
      }

      if(this.a == 1) {
         int var3 = var1.length;
         byte[] var4 = new byte[var3 + 8];
         au.a((int)var2, var4, 0);
         au.a((int)var3, var4, 4);
         System.arraycopy(var1, 0, var4, 8, var3);
         this.a((byte[])ar.a((byte)1, (byte)18, (short)513, var4), (int)3, "SEND_VAP_RECORD");
      }
   }

   public final void a(byte[] var1, int var2, Object var3) {
      if(c.b()) {
         c.b((Object)("XMode.sendXModeMsg() " + var3 + ", buffer.length:" + var1.length));
      }

      if(this.h != null && this.n.a(this.h)) {
         this.h = new aq() {
            // $FF: synthetic field
            private aD a = aD.this;

            public final void run() {
               try {
                  aD.a(this.a);
                  if(aD.c.e()) {
                     aD.c.e("Session Idle for too long, longer than [" + this.a.g + "] ()");
                  }

                  this.a.a = 2;
                  this.a.a((byte)4, (Object)null);
               } catch (Exception var2) {
                  if(aD.c.e()) {
                     aD.c.e("XMode.sendXModeMsg() " + var2.getClass().getName() + " " + var2.getMessage());
                     return;
                  }
               }

            }
         };
         this.n.a(this.h, (long)(this.g * 1000));
      }

      if(this.v != null && this.o != null) {
         if(var2 != 3 && var2 != 2 && (this.D.size() != 0 || this.E.size() != 0)) {
            this.E.add(new aF(var1, var3));
            return;
         }

         aF var4;
         if(var2 == 2) {
            var4 = (aF)this.E.remove();
            var1 = var4.a;
         } else {
            var4 = new aF((byte[])null, var3);
         }

         this.D.add(var4);
         this.v.a(this.o, var1, var1.length, this, var4);
      } else if(var2 == 1) {
         this.E.add(new aF(var1, var3));
         return;
      }

   }

   public final void b() {
      if(c.b()) {
         c.b((Object)("XMode.disconnect() state:" + this.a + ", socket:" + this.o));
      }

      if(this.a == 3) {
         this.q = 1;
         this.A.a(this.q, this.r);
      } else if(this.a != 2) {
         if(this.a == 0) {
            this.a("CloseSocket");
            this.q = 1;
            this.a = 2;
            if(this.o != null) {
               this.v.a(this.o);
               return;
            }
         } else if(this.a == 1) {
            this.a = 2;
            this.q = 1;
            this.a((byte)2, (Object)null);
            return;
         }
      }

   }

   public final void b(int var1) {
      if(c.b()) {
         c.b((Object)("XMode.sendVapRecordEnd() audio id: " + var1));
      }

      if(this.a == 1) {
         byte[] var2 = new byte[4];
         au.a((int)var1, var2, 0);
         this.a((byte[])ar.a((byte)1, (byte)18, (short)256, var2), (int)3, "SEND_VAP_RECORD_END");
      }
   }
}
