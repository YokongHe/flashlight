import java.util.Vector;

public abstract class cL implements cI {
   protected cK a;
   protected final String b;
   protected final bn c;
   protected final cM d;
   private cJ e;
   private bS f;
   private bQ g;
   private final bs h;
   private final bU i;

   public cL(bn var1, cM var2, cJ var3) {
      this(var1, var2, var2.j(), var3);
   }

   public cL(bn var1, cM var2, String var3, cJ var4) {
      this.e = var4;
      this.c = var1;
      this.d = var2;
      String var5 = var3;
      if(var3 == null) {
         var5 = var2.j();
      }

      this.b = var5;
      this.h = new bs() {
         public final void a() {
            com.nuance.nmdp.speechkit.recognitionresult.b.c(cL.this, "PDX Create Command Failed");
            y.a(new Runnable() {
               // $FF: synthetic field
               private <undefinedtype> a = <VAR_NAMELESS_ENCLOSURE>;

               public final void run() {
                  cL.this.a.d();
               }
            });
         }

         public final void a(final String var1) {
            y.a(new Runnable() {
               // $FF: synthetic field
               private String a = var1;
               // $FF: synthetic field
               private <undefinedtype> b = <VAR_NAMELESS_ENCLOSURE>;

               public final void run() {
                  cK var1 = cL.this.a;
                  String var2 = this.a;
               }
            });
         }
      };
      this.i = new bU() {
         public final void a(final bV var1) {
            com.nuance.nmdp.speechkit.recognitionresult.b.a((Object)cL.this, (String)("PDX Query Error Returned: " + var1.g() + "(" + var1.h() + ")"));
            y.a(new Runnable() {
               // $FF: synthetic field
               private bV a = var1;
               // $FF: synthetic field
               private <undefinedtype> b = <VAR_NAMELESS_ENCLOSURE>;

               public final void run() {
                  cK var1 = cL.this.a;
                  this.a.g();
                  var1.a(this.a.h());
               }
            });
         }

         public final void a(bW var1) {
            com.nuance.nmdp.speechkit.recognitionresult.b.a((Object)cL.this, (String)("PDX Query Retry Returned: " + var1.h() + "(" + var1.g() + ")"));
            y.a(new Runnable() {
               // $FF: synthetic field
               private String a;
               // $FF: synthetic field
               private String b;
               // $FF: synthetic field
               private <undefinedtype> c = <VAR_NAMELESS_ENCLOSURE>;

               {
                  this.a = var2;
                  this.b = var3;
               }

               public final void run() {
                  cK var1 = cL.this.a;
                  String var2 = this.a;
                  String var3 = this.b;
                  var1.b(var2);
               }
            });
         }

         public final void a(final bb var1) {
            com.nuance.nmdp.speechkit.recognitionresult.b.a((Object)cL.this, (String)"PDX Query Result Returned");
            y.a(new Runnable() {
               // $FF: synthetic field
               private bb a = var1;
               // $FF: synthetic field
               private <undefinedtype> b = <VAR_NAMELESS_ENCLOSURE>;

               public final void run() {
                  cL.this.a.a(this.a);
               }
            });
         }

         public final void a(final short var1) {
            switch(var1) {
            case 1:
            case 3:
               com.nuance.nmdp.speechkit.recognitionresult.b.a((Object)cL.this, (String)("PDX Command Event: " + var1));
               y.a(new Runnable() {
                  // $FF: synthetic field
                  private short a = var1;
                  // $FF: synthetic field
                  private <undefinedtype> b = <VAR_NAMELESS_ENCLOSURE>;

                  public final void run() {
                     cK var2 = cL.this.a;
                     short var1 = this.a;
                     var2.e();
                  }
               });
               return;
            case 2:
            default:
            }
         }
      };
      this.f = null;
      this.g = null;
   }

   private void a(X var1) {
      try {
         this.g.a(var1);
      } catch (bi var2) {
         throw new cN("Error sending parameter (TransactionAlreadyFinishedException)", var2);
      } catch (bj var3) {
         throw new cN("Error sending parameter (TransactionExpiredException)", var3);
      }
   }

   public final void a() {
      this.a.g();
   }

   protected void a(bb var1) {
   }

   public final void a(cK var1) {
      this.a.k();
      this.a = var1;
      this.a.h();
   }

   public final void a(String var1) {
      if(this.f != null) {
         bb var4 = this.u();
         String var5 = this.d.i();
         String var6 = this.d.k();
         String var2 = this.d.l();
         String var3 = this.d.m();
         String var8 = this.d.o();
         cM var7 = this.d;
         String var15 = cM.q();
         cM var9 = this.d;
         String var16 = cM.n();
         String var10 = this.d.b();
         String var11 = this.d.g();
         var4.b("ui_language", this.b.substring(0, 2).toLowerCase());
         var4.b("phone_submodel", var6);
         var4.b("phone_OS", var2);
         var4.b("locale", var3);
         var4.b("nmdp_version", var16);
         var4.b("nmaid", var10);
         var4.b("network_type", var8);
         if(var11 != null) {
            var4.b("subscription_id", var11);
         }

         byte[] var13 = new byte[100];

         label17: {
            byte[] var14;
            try {
               var14 = this.d.a(var13);
            } catch (Throwable var12) {
               break label17;
            }

            var13 = var14;
         }

         var4.a("app_transaction_id", var13);
         this.a(var4);
         this.g = this.f.a(this.i, var1, var15, this.b, var5, var6, var4);
      }

   }

   public final void a(String var1, bb var2) {
      this.a(this.f.a(var1, var2));
   }

   public final void a(String var1, String var2) {
      this.a(this.f.a(var1, var2));
   }

   public final void a(String var1, String var2, bd var3) {
      bb var4 = this.u();
      var4.b("tts_input", var2);
      var4.b("tts_type", var1);
      this.a(this.f.a("TEXT_TO_READ", var4, var3));
   }

   public final bd b(String var1) {
      bd var2 = this.f.a(var1);
      this.a((X)var2);
      return var2;
   }

   public final void b(String var1, bb var2) {
      this.a(this.f.d(var1, var2));
   }

   public final void c(String var1, bb var2) {
      this.a(this.f.b(var1, var2));
   }

   public final void d(String var1, bb var2) {
      this.a(this.f.c(var1, var2));
   }

   public final void p() {
      this.a.i();
   }

   public final cJ q() {
      return this.e;
   }

   public final void r() {
      Vector var1 = new Vector();
      var1.add(new bf("Android_Context", this.d.a(), bg.a));
      bn var2 = this.c;
      bs var3 = this.h;
      this.d.b();
      this.f = bT.a(var2, var3, var1);
   }

   public final void s() {
      if(this.f != null) {
         try {
            this.f.a();
         } catch (br var2) {
            ;
         }

         this.f = null;
      }

   }

   public final void t() {
      try {
         this.g.a();
      } catch (bi var2) {
         throw new cN("Error ending PDX command (TransactionAlreadyFinishedException)", var2);
      } catch (bj var3) {
         throw new cN("Error ending PDX command (TransactionExpiredException)", var3);
      }
   }

   public final bb u() {
      return this.f.j();
   }

   public final bc v() {
      return this.f.k();
   }
}
