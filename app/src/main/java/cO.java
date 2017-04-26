import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Dictionary;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Sequence;
import java.util.List;

public final class cO {
   private cI a;
   private bn b;
   private aH c = null;
   private aI d = null;
   private aI e = null;
   private M f;
   private M g;
   private final bp h;
   private cM i;
   private String j;
   private boolean k;
   private final Object l;

   public cO(cM var1) {
      this.i = var1;
      this.a = null;
      this.h = new bp() {
         // $FF: synthetic field
         private cO a = cO.this;

         public final void a() {
            com.nuance.nmdp.speechkit.recognitionresult.b.a((Object)this.a, (String)"Shutdown Complte");
         }

         public final void a(String var1) {
            Object var2 = this.a.l;
            synchronized(var2) {
               com.nuance.nmdp.speechkit.recognitionresult.b.a((Object)this.a, (String)("Connected with session ID " + var1));
               this.a.j = var1;
            }
         }

         public final void a(short var1) {
            com.nuance.nmdp.speechkit.recognitionresult.b.a((Object)this.a, (String)("Disconnected reasoncode [" + var1 + "]"));
         }

         public final void b(short var1) {
            com.nuance.nmdp.speechkit.recognitionresult.b.b(this.a, "Connection failed reasonCode [" + var1 + "]");
         }
      };
      this.j = null;
      this.k = true;
      this.l = new Object();
      this.f = this.i.r();
      this.g = this.i.s();
      this.b = this.e();
      if(this.b == null) {
         this.k = false;
         this.i = null;
      } else {
         this.c = this.b.a();
         if(this.c != null) {
            try {
               aK var4 = this.c.c("SpeechKit");
               var4.a("Version", "1.6.0.0B06");
               var4.a("DnsAddress", this.i.d());
               this.d = var4.a();
               var4 = this.d.a("SpeechKit App");
               var4.a("Version", this.i.e());
               this.e = var4.a();
               return;
            } catch (aG var2) {
               com.nuance.nmdp.speechkit.recognitionresult.b.b(this, "Application Session is already open");
               return;
            } catch (aJ var3) {
               com.nuance.nmdp.speechkit.recognitionresult.b.b(this, "Session event already committed");
               return;
            }
         }
      }

   }

   // $FF: synthetic method
   static void a(cO var0) {
      com.nuance.nmdp.speechkit.recognitionresult.b.b(var0, "Restarting NMSP manager");
      var0.f = var0.i.r();
      var0.g = var0.i.s();
      var0.a = null;
      var0.b.h_();
      var0.b = var0.e();
      if(var0.b == null) {
         var0.i = null;
         var0.k = false;
      }

   }

   // $FF: synthetic method
   static void a(cO var0, cI var1) {
      if(var1 == var0.a) {
         var0.a = null;
      }

   }

   private bn e() {
      // $FF: Couldn't be decompiled
   }

   private void f() {
      M var1 = this.i.r();
      M var2 = this.i.s();
      if(this.f != var1 || this.g != var2) {
         com.nuance.nmdp.speechkit.recognitionresult.b.b(this, "Supported codecs changed, restarting NMSP manager");
         this.a = null;
         this.f = var1;
         this.g = var2;
         this.b.h_();
         this.b = this.e();
         if(this.b == null) {
            this.i = null;
            this.k = false;
         }
      }

   }

   public final cI a(final cJ var1) {
      if(this.k && this.a == null) {
         this.f();
         var1 = new cJ() {
            // $FF: synthetic field
            private cJ a = var1;
            // $FF: synthetic field
            private cO b = cO.this;

            public final void a(cI var1) {
               cO.a(this.b, var1);
               this.a.a(var1);
            }

            public final void a(cI var1, int var2, String var3, String var4) {
               this.a.a(var1, var2, var3, var4);
               if(var2 == 1) {
                  cO.a(this.b);
               }

            }
         };
         cX var2 = new cX(this.b, this.i, var1);
         this.a = var2;
         return var2;
      } else {
         return null;
      }
   }

   public final cI a(String var1, String var2, String var3, boolean var4, final r var5) {
      if(!this.k) {
         return null;
      } else {
         if(this.a != null) {
            this.a.p();
         }

         this.f();
         bn var6 = this.b;
         cM var7 = this.i;
         M var8 = this.f;
         v var9 = new v(var6, var7, var1, var2, var3, var4, new r() {
            // $FF: synthetic field
            private r a = var5;
            // $FF: synthetic field
            private cO b = cO.this;

            public final void a(cI var1) {
               cO.a(this.b, var1);
               this.a.a(var1);
            }

            public final void a(cI var1, int var2, String var3, String var4) {
               this.a.a(var1, var2, var3, var4);
               if(var2 == 1) {
                  cO.a(this.b);
               }

            }

            public final void b(cI var1) {
               this.a.b(var1);
            }
         });
         this.a = var9;
         return var9;
      }
   }

   public final cI a(String var1, List var2, J var3, final cJ var4) {
      if(!this.k) {
         return null;
      } else {
         if(this.a != null) {
            this.a.p();
         }

         this.f();
         cR var5 = new cR(this.b, this.i, var1, var2, var3, new cJ() {
            // $FF: synthetic field
            private cJ a = var4;
            // $FF: synthetic field
            private cO b = cO.this;

            public final void a(cI var1) {
               cO.a(this.b, var1);
               this.a.a(var1);
            }

            public final void a(cI var1, int var2, String var3, String var4) {
               this.a.a(var1, var2, var3, var4);
               if(var2 == 1) {
                  cO.a(this.b);
               }

            }
         });
         this.a = var5;
         return var5;
      }
   }

   public final cI a(List var1, String var2, J var3, final cJ var4) {
      if(!this.k) {
         return null;
      } else {
         if(this.a != null) {
            this.a.p();
         }

         this.f();
         cW var5 = new cW(this.b, this.i, var1, var2, var3, new cJ() {
            // $FF: synthetic field
            private cJ a = var4;
            // $FF: synthetic field
            private cO b = cO.this;

            public final void a(cI var1) {
               cO.a(this.b, var1);
               this.a.a(var1);
            }

            public final void a(cI var1, int var2, String var3, String var4) {
               this.a.a(var1, var2, var3, var4);
               if(var2 == 1) {
                  cO.a(this.b);
               }

            }
         });
         this.a = var5;
         return var5;
      }
   }

   public final db a(String var1, String var2, PdxValue$Dictionary var3, J var4, d var5, final b var6) {
      if(!this.k) {
         return null;
      } else {
         if(this.a != null) {
            this.a.p();
         }

         this.f();
         o var7 = new o(this.b, this.i, var1, var2, var3, var4, var5, new b() {
            // $FF: synthetic field
            private b a = var6;
            // $FF: synthetic field
            private cO b = cO.this;

            public final void a(cI var1) {
               cO.a(this.b, var1);
               this.a.a(var1);
            }

            public final void a(cI var1, int var2, String var3, String var4) {
               this.a.a(var1, var2, var3, var4);
               if(var2 == 1) {
                  cO.a(this.b);
               }

            }

            public final void b(cI var1) {
               this.a.b(var1);
            }

            public final void c(cI var1) {
               this.a.c(var1);
            }

            public final void d(cI var1) {
               this.a.d(var1);
            }
         });
         this.a = var7;
         return var7;
      }
   }

   public final db a(String var1, boolean var2, boolean var3, String var4, E var5, E var6, E var7, E var8, J var9, d var10, final b var11) {
      if(!this.k) {
         return null;
      } else {
         if(this.a != null) {
            this.a.p();
         }

         this.f();
         n var12 = new n(this.b, this.i, var1, var2, var3, var4, (PdxValue$Sequence)null, var5, var6, var7, var8, var9, var10, new b() {
            // $FF: synthetic field
            private b a = var11;
            // $FF: synthetic field
            private cO b = cO.this;

            public final void a(cI var1) {
               cO.a(this.b, var1);
               this.a.a(var1);
            }

            public final void a(cI var1, int var2, String var3, String var4) {
               this.a.a(var1, var2, var3, var4);
               if(var2 == 1) {
                  cO.a(this.b);
               }

            }

            public final void b(cI var1) {
               this.a.b(var1);
            }

            public final void c(cI var1) {
               this.a.c(var1);
            }

            public final void d(cI var1) {
               this.a.d(var1);
            }
         });
         this.a = var12;
         return var12;
      }
   }

   public final db a(String var1, boolean var2, boolean var3, String var4, PdxValue$Sequence var5, E var6, E var7, E var8, E var9, J var10, d var11, final b var12) {
      if(!this.k) {
         return null;
      } else {
         if(this.a != null) {
            this.a.p();
         }

         this.f();
         n var13 = new n(this.b, this.i, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, new b() {
            // $FF: synthetic field
            private b a = var12;
            // $FF: synthetic field
            private cO b = cO.this;

            public final void a(cI var1) {
               cO.a(this.b, var1);
               this.a.a(var1);
            }

            public final void a(cI var1, int var2, String var3, String var4) {
               this.a.a(var1, var2, var3, var4);
               if(var2 == 1) {
                  cO.a(this.b);
               }

            }

            public final void b(cI var1) {
               this.a.b(var1);
            }

            public final void c(cI var1) {
               this.a.c(var1);
            }

            public final void d(cI var1) {
               this.a.d(var1);
            }
         });
         this.a = var13;
         return var13;
      }
   }

   public final db a(String var1, boolean var2, boolean var3, String var4, String var5, PdxValue$Dictionary var6, E var7, E var8, E var9, E var10, J var11, d var12, final b var13) {
      if(!this.k) {
         return null;
      } else {
         if(this.a != null) {
            this.a.p();
         }

         this.f();
         m var14 = new m(this.b, this.i, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, new b() {
            // $FF: synthetic field
            private b a = var13;
            // $FF: synthetic field
            private cO b = cO.this;

            public final void a(cI var1) {
               cO.a(this.b, var1);
               this.a.a(var1);
            }

            public final void a(cI var1, int var2, String var3, String var4) {
               this.a.a(var1, var2, var3, var4);
               if(var2 == 1) {
                  cO.a(this.b);
               }

            }

            public final void b(cI var1) {
               this.a.b(var1);
            }

            public final void c(cI var1) {
               this.a.c(var1);
            }

            public final void d(cI var1) {
               this.a.d(var1);
            }
         });
         this.a = var14;
         return var14;
      }
   }

   public final void a() {
      this.k = false;
      if(this.a != null) {
         this.a.p();
         this.a = null;
      }

      if(this.b != null) {
         this.b.h_();
         this.b = null;
      }

      this.i = null;
   }

   public final void a(String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   public final boolean b() {
      return this.k;
   }

   public final String c() {
      Object var1 = this.l;
      synchronized(var1) {
         String var2 = this.j;
         return var2;
      }
   }

   public final void d() {
      if(this.a != null) {
         this.a.p();
         this.a = null;
      }

   }
}
