package com.flurry.sdk;

import com.flurry.sdk.fe;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class at extends com.flurry.sdk.as {
   private final File a;
   private OutputStream b;

   public at(File var1) {
      this.a = var1;
   }

   protected OutputStream f() {
      if(this.b != null) {
         return this.b;
      } else if(this.a == null) {
         throw new IOException("No file specified");
      } else {
         this.b = new FileOutputStream(this.a);
         return this.b;
      }
   }

   protected void g() {
      fe.a((Closeable)this.b);
      this.b = null;
   }

   protected void h() {
      if(this.a != null) {
         this.a.delete();
      }
   }
}
