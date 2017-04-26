import java.util.Enumeration;

public class bE extends bB {
   private static final ae a = bh.a(bE.class);

   public bE(String var1, String var2, String var3, String var4, String var5, String var6, M var7, String var8, short var9, short var10, String var11, String var12, String var13, String var14, byte[] var15, String var16, String var17, bb var18) {
      super((short)514);
      if(a.b()) {
         a.b((Object)"PDXQueryBegin()");
      }

      this.a("uid", var1, (short)193);
      this.a("pdx_version", var2, (short)193);
      this.a("client_version", var3, (short)193);
      this.a("script_version", var4, (short)193);
      this.a("language", var5, (short)193);
      this.a("region", var6, (short)193);
      this.a("device_codec", var7.a());
      this.a("dictation_language", var8, (short)193);
      this.a("lcd_width", var9);
      this.a("lcd_height", var10);
      if(var11 == null) {
         this.a("carrier", new byte[0], (short)5);
      } else {
         this.a("carrier", var11, (short)193);
      }

      this.a("phone_model", var12, (short)193);
      this.a("phone_number", var13, (short)193);
      this.a("original_session_id", var14, (short)22);
      if(var15 != null) {
         this.a("new_session_id", bu.a(var15), (short)193);
      }

      this.a("application", var16, (short)22);
      this.a("nmaid", var16, (short)22);
      this.a("command", var17, (short)22);
      if(var18 != null) {
         Enumeration var19 = var18.a();

         while(var19.hasMoreElements()) {
            var2 = (String)var19.nextElement();
            switch(((aW)var18).b(var2).c()) {
            case 4:
               this.a(var2, var18.e(var2), (short)4);
               break;
            case 5:
               this.a(var2, (byte[])null, (short)5);
               break;
            case 16:
               a.e("PDXQueryBegin() Sequence not accepted in optionalKeys");
               break;
            case 22:
               this.a(var2, var18.g(var2), (short)22);
               break;
            case 192:
               this.a(var2, var18.d(var2));
               break;
            case 193:
               this.a(var2, var18.f(var2), (short)193);
               break;
            case 224:
               a.e("PDXQueryBegin() Dictionary not accepted in optionalKeys");
            }
         }
      }

   }
}
