import java.util.Vector;

public class bt extends be implements bn {
   private static final ae c = bh.a(bt.class);
   public String b;
   private bu d;
   private Object e;
   private aH f;

   public bt(String var1, short var2, String var3, byte[] var4, String var5, M var6, M var7, String var8, Vector var9, bp var10) {
      super(var1, var2, var5, var6, var7);
      if(var3 == null) {
         throw new IllegalArgumentException(" application id is null.");
      } else {
         this.b = var3;
         if(var4 == null) {
            throw new IllegalArgumentException(" application key is null");
         } else {
            boolean var11 = true;
            long var16 = 5242880L;
            int var12 = 7;
            var1 = null;
            Vector var21;
            if(var9 != null && var9.size() != 0) {
               Vector var23 = new Vector(var9.size());

               boolean var13;
               for(int var14 = 0; var14 < var9.size(); var11 = var13) {
                  bf var20 = (bf)var9.elementAt(var14);
                  String var22 = var1;
                  long var18 = var16;
                  int var15 = var12;
                  var13 = var11;
                  if(var20.d() == bg.a) {
                     if(var20.a().equals("DEVICE_CMD_LOG_TO_SERVER_ENABLED")) {
                        this.e = new Vector();
                        var13 = var11;
                        var15 = var12;
                        var18 = var16;
                        var22 = var1;
                     } else if(var20.a().equals("Calllog_Disable")) {
                        if(!(new String(var20.b())).equals("TRUE") && !(new String(var20.b())).equals("true")) {
                           label55: {
                              if(!(new String(var20.b())).equals("FALSE")) {
                                 var22 = var1;
                                 var18 = var16;
                                 var15 = var12;
                                 var13 = var11;
                                 if(!(new String(var20.b())).equals("false")) {
                                    break label55;
                                 }
                              }

                              var13 = true;
                              var22 = var1;
                              var18 = var16;
                              var15 = var12;
                           }
                        } else {
                           var13 = false;
                           var22 = var1;
                           var18 = var16;
                           var15 = var12;
                        }
                     } else if(var20.a().equals("Calllog_Root_Id")) {
                        var22 = new String(var20.b());
                        var18 = var16;
                        var15 = var12;
                        var13 = var11;
                     } else if(var20.a().equals("Calllog_Size_Limit")) {
                        var18 = Long.parseLong(new String(var20.b()));
                        var22 = var1;
                        var15 = var12;
                        var13 = var11;
                     } else {
                        var22 = var1;
                        var18 = var16;
                        var15 = var12;
                        var13 = var11;
                        if(var20.a().equals("Calllog_Retention_Days")) {
                           var15 = Integer.parseInt(new String(var20.b()));
                           var22 = var1;
                           var18 = var16;
                           var13 = var11;
                        }
                     }
                  }

                  var23.addElement(var20);
                  ++var14;
                  var1 = var22;
                  var16 = var18;
                  var12 = var15;
               }

               var21 = var23;
            } else {
               var21 = new Vector();
               var16 = 5242880L;
               var1 = null;
               var12 = 7;
               var11 = true;
            }

            if(var8 == null && var11) {
               c.e("NullPointerException calllogFileName is NULL.");
               throw new NullPointerException("calllogFileName can not be null!");
            } else if(var16 < 0L) {
               c.e("NMSP_DEFINES_CALLLOG_FILE_SIZE_LIMIT can not be negative!");
               throw new NullPointerException("NMSP_DEFINES_CALLLOG_FILE_SIZE_LIMIT can not be negative!");
            } else {
               this.d = new bu(this.b(), this.c(), var3, var4, var5, var21, this.i_(), var10);
               if(var11) {
                  this.f = new aL(var8, var16, var12, var1, this.a, this.b, this.i_(), this.d.b());
                  this.d.a(((aL)this.f).b());
               }

            }
         }
      }
   }

   public final aH a() {
      return this.f;
   }

   public final bu h() {
      return this.d;
   }

   public final void h_() {
      c.b((Object)"shutdown");
      if(this.f != null) {
         aI var1 = ((aL)this.f).b();
         if(var1 != null) {
            var1.a("NMSP_ShutDown").a();
         }
      }

      this.d.e();
   }

   public final Object i() {
      return this.e;
   }
}
