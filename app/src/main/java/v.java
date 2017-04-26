public final class v extends cL implements cI {
   private final String e;
   private final String f;
   private final String g;
   private final B h;
   private G i;

   public v(bn var1, cM var2, String var3, String var4, String var5, boolean var6, r var7) {
      super(var1, var2, var5, var7);
      this.f = var3;
      String var8;
      if(var6) {
         var8 = "ssml";
      } else {
         var8 = "text";
      }

      this.g = var8;
      this.e = var4;
      this.h = new B() {
         public final void a(Object var1) {
            com.nuance.nmdp.speechkit.recognitionresult.b.c(v.this, "Player error");
            y.a(new Runnable() {
               // $FF: synthetic field
               private <undefinedtype> a = <VAR_NAMELESS_ENCLOSURE>;

               public final void run() {
                  v.a(v.this).a();
               }
            });
         }

         public final void b(Object var1) {
            y.a(new Runnable() {
               // $FF: synthetic field
               private <undefinedtype> a = <VAR_NAMELESS_ENCLOSURE>;

               public final void run() {
                  v.a(v.this).b();
               }
            });
         }

         public final void c(Object var1) {
            y.a(new Runnable() {
               // $FF: synthetic field
               private <undefinedtype> a = <VAR_NAMELESS_ENCLOSURE>;

               public final void run() {
                  v.a(v.this).c();
               }
            });
         }
      };
      this.i = new G(this.c, this, var2.a(), this.h);
      this.a = new t(this);
   }

   // $FF: synthetic method
   static s a(v var0) {
      return (s)var0.a;
   }

   protected final void a(bb var1) {
      if(this.e != null) {
         var1.b("tts_voice", this.e);
      } else {
         var1.b("tts_language", this.b);
      }
   }

   public final String b() {
      return this.f;
   }

   public final String c() {
      return this.g;
   }

   public final void d() {
      this.i.a();
   }

   public final void e() {
      this.i.b();
   }

   protected final String e_() {
      return this.d.z();
   }

   public final bd f() {
      return this.i.c();
   }
}
