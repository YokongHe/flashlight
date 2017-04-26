package com.flurry.sdk;

import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.sdk.dn;
import com.flurry.sdk.dr;
import com.flurry.sdk.eo;
import com.flurry.sdk.fe;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map.Entry;

public class ag {
   private static final String a = com.flurry.sdk.ag.class.getSimpleName();
   private final FlurryAdModule b;

   public ag(FlurryAdModule var1) {
      this.b = var1;
   }

   private boolean a(String var1, String var2) {
      return var2.equals("%{" + var1 + "}");
   }

   public String a(com.flurry.sdk.e var1, AdUnit var2, com.flurry.sdk.a var3, String var4, String var5) {
      Iterator var9;
      String var10;
      Entry var11;
      if(this.a("fids", var5)) {
         StringBuilder var7 = new StringBuilder();
         var9 = dn.a().l().entrySet().iterator();
         boolean var6 = true;

         while(var9.hasNext()) {
            var11 = (Entry)var9.next();
            if(!var6) {
               var7.append(",");
            }

            var7.append(((dr)var11.getKey()).d).append(":");
            if(((dr)var11.getKey()).e) {
               var7.append(new String(((ByteBuffer)var11.getValue()).array()));
               var6 = false;
            } else {
               var7.append(fe.a(((ByteBuffer)var11.getValue()).array()));
               var6 = false;
            }
         }

         eo.a(3, a, "Replacing param fids with: " + var7.toString());
         var10 = var4.replace(var5, fe.b(var7.toString()));
      } else {
         String var8;
         if(this.a("sid", var5)) {
            var8 = String.valueOf(this.b.h());
            eo.a(3, a, "Replacing param sid with: " + var8);
            return var4.replace(var5, fe.b(var8));
         }

         if(this.a("lid", var5)) {
            var8 = String.valueOf(var1.a());
            eo.a(3, a, "Replacing param lid with: " + var8);
            return var4.replace(var5, fe.b(var8));
         }

         if(this.a("guid", var5)) {
            var8 = var1.b();
            eo.a(3, a, "Replacing param guid with: " + var8);
            return var4.replace(var5, fe.b(var8));
         }

         if(this.a("ats", var5)) {
            var8 = String.valueOf(System.currentTimeMillis());
            eo.a(3, a, "Replacing param ats with: " + var8);
            return var4.replace(var5, fe.b(var8));
         }

         if(this.a("apik", var5)) {
            var8 = this.b.j();
            eo.a(3, a, "Replacing param apik with: " + var8);
            return var4.replace(var5, fe.b(var8));
         }

         if(this.a("hid", var5)) {
            var8 = var2.b().toString();
            eo.a(3, a, "Replacing param hid with: " + var8);
            return var4.replace(var5, fe.b(var8));
         }

         if(this.a("eso", var5)) {
            var8 = Long.toString(System.currentTimeMillis() - this.b.h());
            eo.a(3, a, "Replacing param eso with: " + var8);
            return var4.replace(var5, fe.b(var8));
         }

         if(!this.a("uc", var5)) {
            eo.a(3, a, "Unknown param: " + var5);
            return var4.replace(var5, "");
         }

         var9 = this.b.B().entrySet().iterator();

         for(var8 = ""; var9.hasNext(); var8 = var8 + "c_" + fe.b((String)var11.getKey()) + "=" + fe.b((String)var11.getValue()) + "&") {
            var11 = (Entry)var9.next();
         }

         eo.a(3, a, "Replacing param uc with: " + var8);
         String var12 = var4.replace(var5, var8);
         var10 = var12;
         if(var8.equals("")) {
            var10 = var12;
            if(var12.length() > 0) {
               return var12.substring(0, var12.length() - 1);
            }
         }
      }

      return var10;
   }
}
