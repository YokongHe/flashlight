package com.flurry.sdk;

import android.util.Pair;
import android.widget.Toast;
import com.flurry.android.impl.ads.avro.protocol.v10.SdkLogRequest;
import com.flurry.android.impl.ads.avro.protocol.v10.SdkLogResponse;
import com.flurry.sdk.de;
import com.flurry.sdk.de$a;
import com.flurry.sdk.do;
import com.flurry.sdk.eo;
import com.flurry.sdk.gw;
import com.flurry.sdk.w$a;
import java.nio.ByteBuffer;
import java.util.Iterator;

public class s extends de {
   private final com.flurry.sdk.w a;

   public s() {
      this((de$a)null);
   }

   public s(de$a var1) {
      super("Ads", com.flurry.sdk.s.class.getSimpleName());
      this.a = new com.flurry.sdk.w();
      this.g = "AnalyticsData_";
      this.a((de$a)var1);
   }

   protected Pair a(byte[] var1) {
      byte var3 = 0;
      byte[] var6 = new byte[4];
      byte[] var5 = new byte[var1.length - 4];

      int var2;
      for(var2 = 0; var2 < var1.length; ++var2) {
         if(var2 < 4) {
            var6[var2] = var1[var2];
         } else {
            var5[var2 - 4] = var1[var2];
         }
      }

      int var4 = ByteBuffer.wrap(var6).getInt();
      var1 = new byte[var4];
      var6 = new byte[var5.length - var4];

      for(var2 = var3; var2 < var5.length; ++var2) {
         if(var2 < var4) {
            var1[var2] = var5[var2];
         } else {
            var6[var2 - var4] = var5[var2];
         }
      }

      return new Pair(new String(var1), var6);
   }

   public SdkLogResponse a(SdkLogRequest var1, String var2, String var3, String var4) {
      byte[] var5 = com.flurry.sdk.v.a((gw)var1, SdkLogRequest.class);
      if(var5 != null) {
         this.b(this.a(var5, var2), var3, var4);
      }

      SdkLogResponse var6 = new SdkLogResponse();
      var6.a("success");
      return var6;
   }

   protected void a(byte[] var1, final String var2, final String var3) {
      Pair var4;
      try {
         var4 = this.a(var1);
      } catch (Exception var5) {
         eo.a(6, this.d, "Internal ERROR! Report is corrupt!");
         this.c(var2, var3);
         return;
      }

      String var6 = (String)var4.first;
      byte[] var7 = (byte[])var4.second;
      eo.a(4, this.d, "FlurryAdLogsManager: start upload data " + var7 + " with id = " + var2 + " to " + var6);
      this.a.a(this, var6, var7, SdkLogResponse.class, new w$a() {
         public void a(int var1, SdkLogResponse var2x) {
            if(var2x != null && var2x.b().toString().equals("success")) {
               eo.a(5, s.this.d, "FlurryAdLogsManager: ad report " + var2 + " sent. HTTP response: " + var1);
               if(eo.c() <= 3 && eo.d()) {
                  do.a().a(new Runnable() {
                     public void run() {
                        Toast.makeText(do.a().b(), "Ad log report sent", 0).show();
                     }
                  });
               }

               s.this.a(var2, var3, var1);
               s.this.d();
            } else {
               if(var2x != null) {
                  Iterator var4 = var2x.c().iterator();

                  while(var4.hasNext()) {
                     CharSequence var3x = (CharSequence)var4.next();
                     eo.a(6, s.this.d, var3x.toString());
                  }
               }

               s.this.b(var2, var3);
            }
         }
      });
   }

   protected byte[] a(byte[] var1, String var2) {
      byte[] var6 = var2.getBytes();
      int var3 = var6.length;
      byte[] var4 = ByteBuffer.allocate(4).putInt(var3).array();
      byte[] var5 = new byte[var4.length + var6.length + var1.length];

      for(var3 = 0; var3 < var5.length; ++var3) {
         if(var3 < var4.length) {
            var5[var3] = var4[var3];
         } else if(var3 >= var4.length && var3 < var6.length + var4.length) {
            var5[var3] = var6[var3 - 4];
         } else {
            var5[var3] = var1[var3 - 4 - var6.length];
         }
      }

      return var5;
   }
}
