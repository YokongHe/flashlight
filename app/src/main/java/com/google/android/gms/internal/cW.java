package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient$Info;
import com.google.android.gms.internal.di;
import com.google.android.gms.internal.dj;
import com.google.android.gms.internal.dm;
import java.io.IOException;

public final class cW extends com.google.android.gms.internal.cU {
   private cW(Context var1, di var2, dj var3) {
      super(var1, var2, var3);
   }

   public static com.google.android.gms.internal.cW a(String var0, Context var1) {
      com.google.android.gms.internal.bN var2 = new com.google.android.gms.internal.bN();
      a(var0, var1, var2);
      return new com.google.android.gms.internal.cW(var1, var2, new dm(239));
   }

   private com.google.android.gms.internal.cX d(Context var1) {
      int var2 = 0;

      AdvertisingIdClient$Info var5;
      try {
         var5 = AdvertisingIdClient.getAdvertisingIdInfo(var1);
      } catch (com.google.android.gms.common.f var7) {
         throw new IOException(var7);
      }

      String var8 = var5.getId();
      if(var8 != null && var8.matches("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$")) {
         byte[] var6 = new byte[16];

         int var4;
         for(int var3 = 0; var2 < var8.length(); var2 = var4 + 2) {
            label31: {
               if(var2 != 8 && var2 != 13 && var2 != 18) {
                  var4 = var2;
                  if(var2 != 23) {
                     break label31;
                  }
               }

               var4 = var2 + 1;
            }

            var6[var3] = (byte)((Character.digit(var8.charAt(var4), 16) << 4) + Character.digit(var8.charAt(var4 + 1), 16));
            ++var3;
         }

         var8 = this.c.a(var6, true);
      }

      return new com.google.android.gms.internal.cX(this, var8, var5.isLimitAdTrackingEnabled());
   }

   protected final void b(Context param1) {
      // $FF: Couldn't be decompiled
   }
}
