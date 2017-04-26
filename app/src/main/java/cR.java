import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class cR extends cL {
   private final List e;
   private final J f;
   private final String g;

   public cR(bn var1, cM var2, String var3, List var4, J var5, cJ var6) {
      super(var1, var2, var6);
      this.e = var4;
      this.f = var5;
      this.g = var3;
      this.a = new cU(this);
   }

   protected void a(bb var1) {
      super.a(var1);
      var1.b("dictation_language", "eng-USA");
   }

   protected final void b() {
      String var2;
      if(this.e != null) {
         for(Iterator var1 = this.e.iterator(); var1.hasNext(); com.nuance.nmdp.speechkit.recognitionresult.b.a((Object)this, (String)("Send custom param " + var2))) {
            cS var3 = (cS)var1.next();
            var2 = var3.a();
            cT var4 = var3.b();
            switch(var4.f()) {
            case 0:
               this.a(var2, var4.c());
               break;
            case 1:
               com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "INT is an unsupported param type");
               break;
            case 2:
               this.a(var2, com.nuance.nmdp.speechkit.recognitionresult.b.a((cL)this, (Map)var4.a()));
               break;
            case 3:
               com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "SEQ is an unsupported param type");
            case 4:
            default:
               break;
            case 5:
               this.b(var2, com.nuance.nmdp.speechkit.recognitionresult.b.a((cL)this, (Map)var4.a()));
               break;
            case 6:
               this.c(var2, com.nuance.nmdp.speechkit.recognitionresult.b.a((cL)this, (Map)var4.a()));
               break;
            case 7:
               this.d(var2, com.nuance.nmdp.speechkit.recognitionresult.b.a((cL)this, (Map)var4.a()));
            }
         }
      }

   }

   final String c() {
      return this.g;
   }

   final J d() {
      return this.f;
   }
}
