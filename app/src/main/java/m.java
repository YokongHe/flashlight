import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Dictionary;
import java.util.Map;

public final class m extends g {
   private final String e;
   private PdxValue$Dictionary f;
   private String g;

   public m(bn var1, cM var2, String var3, boolean var4, boolean var5, String var6, String var7, PdxValue$Dictionary var8, E var9, E var10, E var11, E var12, J var13, d var14, b var15) {
      super(var1, var2, var4, var5, var6, var9, var10, var11, var12, var13, var14, var15);
      this.e = var3;
      this.f = var8;
      this.g = var7;
   }

   protected final void a(bb var1) {
      super.a(var1);
      var1.b("dictation_language", this.b);
      var1.b("dictation_type", this.e);
      if(this.g != null) {
         var1.b("application_session_id", this.g);
      }

   }

   protected final void b() {
      bb var1 = this.u();
      var1.b("start", 0);
      var1.b("end", 0);
      var1.b("text", "");
      var1.a("appserver_data", com.nuance.nmdp.speechkit.recognitionresult.b.a((cL)this, (Map)(new cT(this.f)).a()));
      com.nuance.nmdp.speechkit.recognitionresult.b.a((Object)this, (String)("REQUEST_INFO: " + var1));
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
