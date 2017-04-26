import java.util.List;

public final class cW extends cR {
   private final String e;

   public cW(bn var1, cM var2, List var3, String var4, J var5, cJ var6) {
      super(var1, var2, var2.w(), var3, var5, var6);
      this.e = var4;
   }

   protected final void a(bb var1) {
      super.a(var1);
      String var2 = this.e;
      var1.b("application_session_id", this.e);
   }
}
