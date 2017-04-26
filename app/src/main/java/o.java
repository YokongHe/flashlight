import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Dictionary;
import java.util.Map;

public final class o extends g {
   private PdxValue$Dictionary e;
   private String f;

   public o(bn var1, cM var2, String var3, String var4, PdxValue$Dictionary var5, J var6, d var7, b var8) {
      super(var1, var2, false, false, var3, (E)null, (E)null, (E)null, (E)null, var6, var7, var8);
      this.e = var5;
      this.f = var4;
   }

   protected final void a(bb var1) {
      super.a(var1);
      var1.b("dictation_language", this.b);
      if(this.f != null) {
         var1.b("application_session_id", this.f);
      }

   }

   protected final void b() {
      bb var1 = this.u();
      var1.a("appserver_data", com.nuance.nmdp.speechkit.recognitionresult.b.a((cL)this, (Map)(new cT(this.e)).a()));
      com.nuance.nmdp.speechkit.recognitionresult.b.a((Object)this, (String)("REQUEST_INFO: " + var1));
      this.a("REQUEST_INFO", var1);
   }

   protected final String c() {
      return this.d.y();
   }

   protected final String d() {
      return "AUDIO_INFO";
   }

   protected final boolean e() {
      return false;
   }
}
