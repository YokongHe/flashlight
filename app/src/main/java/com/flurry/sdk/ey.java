package com.flurry.sdk;

import com.flurry.sdk.ex;
import com.flurry.sdk.fe;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ey implements ex {
   // $FF: synthetic method
   public Object a(InputStream var1) {
      return this.b(var1);
   }

   public void a(OutputStream var1, String var2) {
      if(var1 != null && var2 != null) {
         byte[] var3 = var2.getBytes("utf-8");
         var1.write(var3, 0, var3.length);
      }
   }

   public String b(InputStream var1) {
      if(var1 == null) {
         return null;
      } else {
         ByteArrayOutputStream var2 = new ByteArrayOutputStream();
         fe.a(var1, var2);
         return var2.toString();
      }
   }
}
