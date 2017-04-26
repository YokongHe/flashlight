public abstract class cm extends cK {
   protected final int a;
   private final String c;
   private final String d;
   private final boolean e;

   public cm(cL var1, int var2, String var3, String var4, boolean var5) {
      super(var1);
      this.a = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
   }

   public void h() {
      com.nuance.nmdp.speechkit.recognitionresult.b.a((Object)this, (String)("Transaction error code: " + this.a));
      if(this.c != null && this.c.length() > 0) {
         com.nuance.nmdp.speechkit.recognitionresult.b.a((Object)this, (String)("Transaction error text: " + this.c));
      }

      if(this.d != null && this.d.length() > 0) {
         com.nuance.nmdp.speechkit.recognitionresult.b.a((Object)this, (String)("Transaction suggestion: " + this.d));
      }

      this.b.s();
      final cJ var1 = this.b.q();
      if(this.e) {
         var1.a(this.b, this.a, this.c, this.d);
         var1.a(this.b);
      } else {
         y.a(new Runnable() {
            // $FF: synthetic field
            private cJ a = var1;
            // $FF: synthetic field
            private cm b = cm.this;

            public final void run() {
               this.a.a(this.b.b, this.b.a, this.b.c, this.b.d);
               this.a.a(this.b.b);
            }
         });
      }
   }
}
