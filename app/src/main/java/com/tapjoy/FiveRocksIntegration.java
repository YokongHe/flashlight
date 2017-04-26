package com.tapjoy;

import com.tapjoy.TJActionRequest;
import com.tapjoy.TJPlacement;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.internal.fj;
import com.tapjoy.internal.fk;
import com.tapjoy.internal.fm;
import com.tapjoy.internal.fv;
import java.util.Hashtable;

public class FiveRocksIntegration {
   private static com.tapjoy.internal.be a = new com.tapjoy.internal.be();

   public static void a(Hashtable var0) {
      if(var0 != null) {
         String var1 = String.valueOf(var0.get("TJC_OPTION_ENABLE_LOGGING"));
         if(var1 != null && var1.equalsIgnoreCase("true")) {
            fv.a().a(true);
         }
      }

      fv.a().b();
      fm var2 = new fm() {
         private fk e(final String var1) {
            return new fk() {
               public final void a(final String var1x, String var2) {
                  com.tapjoy.internal.be var3 = FiveRocksIntegration.a;
                  TJPlacement var4;
                  synchronized(var3) {
                     var4 = (TJPlacement)FiveRocksIntegration.a.get(var1);
                  }

                  if(var4 != null && var4.a() != null) {
                     TJActionRequest var6 = new TJActionRequest() {
                        public final void cancelled() {
                        }

                        public final void completed() {
                        }

                        public final String getRequestId() {
                           return var1x;
                        }

                        public final String getToken() {
                           return null;
                        }
                     };
                     var4.a().onPurchaseRequest(var4, var6, var2);
                  }

               }

               public final void a(final String var1x, String var2, int var3, final String var4) {
                  com.tapjoy.internal.be var5 = FiveRocksIntegration.a;
                  TJPlacement var6;
                  synchronized(var5) {
                     var6 = (TJPlacement)FiveRocksIntegration.a.get(var1);
                  }

                  if(var6 != null && var6.a() != null) {
                     TJActionRequest var8 = new TJActionRequest() {
                        public final void cancelled() {
                        }

                        public final void completed() {
                        }

                        public final String getRequestId() {
                           return var1x;
                        }

                        public final String getToken() {
                           return var4;
                        }
                     };
                     var6.a().onRewardRequest(var6, var8, var2, var3);
                  }

               }
            };
         }

         public final void a(String var1) {
         }

         public final void a(String var1, fj var2) {
            if(var2 != null) {
               var2.a(this.e(var1));
            }

         }

         public final void b(String var1) {
            com.tapjoy.internal.be var2 = FiveRocksIntegration.a;
            TJPlacement var4;
            synchronized(var2) {
               var4 = (TJPlacement)FiveRocksIntegration.a.get(var1);
            }

            if(var4 != null && var4.a() != null) {
               var4.a().onContentReady(var4);
            }

         }

         public final void b(String var1, fj var2) {
            if(var2 != null) {
               var2.a(this.e(var1));
            }

            TapjoyConnectCore.viewWillClose(0);
            TapjoyConnectCore.viewDidClose(0);
            com.tapjoy.internal.be var5 = FiveRocksIntegration.a;
            TJPlacement var4;
            synchronized(var5) {
               var4 = (TJPlacement)FiveRocksIntegration.a.get(var1);
            }

            if(var4 != null && var4.a() != null) {
               var4.a().onContentDismiss(var4);
            }

         }

         public final void c(String var1) {
            TapjoyConnectCore.viewDidOpen(0);
            com.tapjoy.internal.be var2 = FiveRocksIntegration.a;
            TJPlacement var4;
            synchronized(var2) {
               var4 = (TJPlacement)FiveRocksIntegration.a.get(var1);
            }

            if(var4 != null && var4.a() != null) {
               var4.a().onContentShow(var4);
            }

         }

         public final void d(String var1) {
         }
      };
      fv.a().a(var2);
   }

   public static void addPlacementCallback(String var0, TJPlacement var1) {
      com.tapjoy.internal.be var2 = a;
      synchronized(var2) {
         a.put(var0, var1);
      }
   }
}
