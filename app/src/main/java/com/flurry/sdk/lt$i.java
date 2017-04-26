package com.flurry.sdk;

import com.flurry.sdk.iz;
import com.flurry.sdk.lt;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.UUID;

public class lt$i extends lt {
   public lt$i() {
      super(UUID.class);
   }

   // $FF: synthetic method
   protected Object a(Object var1, iz var2) {
      return this.b(var1, var2);
   }

   // $FF: synthetic method
   protected Object a(String var1, iz var2) {
      return this.b(var1, var2);
   }

   protected UUID b(Object var1, iz var2) {
      if(var1 instanceof byte[]) {
         byte[] var3 = (byte[])var1;
         if(var3.length != 16) {
            var2.b("Can only construct UUIDs from 16 byte arrays; got " + var3.length + " bytes");
         }

         DataInputStream var4 = new DataInputStream(new ByteArrayInputStream(var3));
         return new UUID(var4.readLong(), var4.readLong());
      } else {
         super.a(var1, var2);
         return null;
      }
   }

   protected UUID b(String var1, iz var2) {
      return UUID.fromString(var1);
   }
}
