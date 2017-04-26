package com.flurry.sdk;

import com.flurry.sdk.eo;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d {
   private static final String a = com.flurry.sdk.d.class.getSimpleName();

   public static List a(DataInput var0) {
      if('뗺' != var0.readUnsignedShort()) {
         throw new IOException("Unexpected data format");
      } else {
         return b(var0);
      }
   }

   public static void a(List var0, DataOutput var1) {
      var1.writeShort('뗺');
      b(var0, var1);
      var1.writeShort(0);
   }

   private static List b(DataInput var0) {
      ArrayList var1 = new ArrayList();

      while(true) {
         try {
            if(1 != var0.readUnsignedShort()) {
               return var1;
            }

            var1.add(new com.flurry.sdk.e(var0));
         } catch (IOException var2) {
            eo.a(3, a, "unable to read adLog: ", var2);
            return var1;
         }
      }
   }

   private static void b(List var0, DataOutput var1) {
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         com.flurry.sdk.e var4 = (com.flurry.sdk.e)var2.next();

         try {
            var1.writeShort(1);
            var4.a(var1);
         } catch (IOException var3) {
            eo.a(3, a, "unable to write adLog with GUID: " + var4.b(), var3);
            break;
         }
      }

   }
}
