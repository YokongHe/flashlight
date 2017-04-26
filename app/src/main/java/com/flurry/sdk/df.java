package com.flurry.sdk;

import com.flurry.sdk.do;
import com.flurry.sdk.eo;
import java.io.File;
import java.util.UUID;

public class df {
   private static final String d = df.class.getSimpleName();
   String a = null;
   long b = -1L;
   int c = -1;
   private File e = null;

   public df() {
      this.a = UUID.randomUUID().toString();
      this.e = do.a().b().getFileStreamPath(".flurrydatasenderblock." + this.a);
   }

   public df(String var1) {
      this.a = var1;
      this.e = do.a().b().getFileStreamPath(".flurrydatasenderblock." + this.a);
   }

   public String a() {
      return this.a;
   }

   public boolean a(byte[] param1) {
      // $FF: Couldn't be decompiled
   }

   public byte[] b() {
      // $FF: Couldn't be decompiled
   }

   public boolean c() {
      if(this.e.exists()) {
         if(this.e.delete()) {
            eo.a(4, d, "Deleted persistence file");
            this.b = -1L;
            this.c = -1;
            return true;
         }

         eo.a(6, d, "Cannot delete persistence file");
      }

      return false;
   }
}
