package com.inmobi.monetization.internal.configs;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.util.Map;

public class PkParams {
   public static String SK_ALGORITHM = "";
   public static String SK_EXPONENT = "";
   public static String SK_MODULUS = "";
   public static String SK_VERSION = "";
   private Map a;

   public String getAlgorithm() {
      return SK_ALGORITHM;
   }

   public Map getDeviceIdMaskMap() {
      return this.a;
   }

   public String getExponent() {
      return SK_EXPONENT;
   }

   public String getModulus() {
      return SK_MODULUS;
   }

   public String getVersion() {
      return SK_VERSION;
   }

   public void setFromMap(Map var1) {
      var1 = (Map)var1.get("pk");
      String var2 = InternalSDKUtil.getStringFromMap(var1, "ver");
      SK_VERSION = var2;
      if(var2.equals("")) {
         Log.internal("[InMobi]-4.5.2", "Key ver has illegal value");
         throw new IllegalArgumentException();
      } else {
         var2 = InternalSDKUtil.getStringFromMap(var1, "alg");
         SK_ALGORITHM = var2;
         if(var2.equals("")) {
            Log.internal("[InMobi]-4.5.2", "Key alg has illegal value");
            throw new IllegalArgumentException();
         } else {
            if(SK_ALGORITHM.equalsIgnoreCase("rsa")) {
               var1 = (Map)var1.get("val");
               SK_EXPONENT = InternalSDKUtil.getStringFromMap(var1, "e");
               String var3 = InternalSDKUtil.getStringFromMap(var1, "m");
               SK_MODULUS = var3;
               if(var3.equals("")) {
                  Log.internal("[InMobi]-4.5.2", "Key m has illegal value");
                  throw new IllegalArgumentException();
               }

               if(SK_EXPONENT.equals("")) {
                  Log.internal("[InMobi]-4.5.2", "Key e has illegal value");
                  throw new IllegalArgumentException();
               }

               if(!InternalSDKUtil.isHexString(SK_EXPONENT)) {
                  Log.internal("[InMobi]-4.5.2", "Key e has illegal value");
                  throw new IllegalArgumentException();
               }

               if(!InternalSDKUtil.isHexString(SK_MODULUS)) {
                  Log.internal("[InMobi]-4.5.2", "Key m has illegal value");
                  throw new IllegalArgumentException();
               }
            }

         }
      }
   }
}
