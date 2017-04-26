import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Sequence;
import java.util.List;

public final class n extends g {
   private final String e;
   private PdxValue$Sequence f;

   public n(bn var1, cM var2, String var3, boolean var4, boolean var5, String var6, PdxValue$Sequence var7, E var8, E var9, E var10, E var11, J var12, d var13, b var14) {
      super(var1, var2, var4, var5, var6, var8, var9, var10, var11, var12, var13, var14);
      this.e = var3;
      this.f = var7;
   }

   protected final void a(bb var1) {
      super.a(var1);
      var1.b("dictation_language", this.b);
      var1.b("dictation_type", this.e);
   }

   protected final void b() {
      bb var1 = this.u();
      var1.b("start", 0);
      var1.b("end", 0);
      var1.b("text", "");
      if(this.f != null) {
         var1.a("grammar_list", com.nuance.nmdp.speechkit.recognitionresult.b.a((cL)this, (List)(new cT(this.f)).b()));
      }

      var1.b("binary_results", 1);
      this.a("REQUEST_INFO", var1);
   }

   protected final String c() {
      return this.d.u();
   }

   protected final String d() {
      return "AUDIO_INFO";
   }

   protected final boolean e() {
      return true;
   }
}
