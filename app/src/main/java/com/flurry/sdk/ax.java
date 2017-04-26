package com.flurry.sdk;

import android.text.TextUtils;
import com.flurry.sdk.aw$c;
import com.flurry.sdk.fe;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;

public class ax extends com.flurry.sdk.as {
   protected final com.flurry.sdk.aw a;
   protected final String b;
   protected aw$c c;

   public ax(com.flurry.sdk.aw var1, String var2) {
      this.a = var1;
      this.b = var2;
   }

   protected OutputStream f() {
      if(this.c != null) {
         return this.c.a();
      } else if(this.a == null) {
         throw new IOException("No cache specified");
      } else if(TextUtils.isEmpty(this.b)) {
         throw new IOException("No cache key specified");
      } else {
         this.c = this.a.b(this.b);
         if(this.c == null) {
            throw new IOException("Could not open writer for key: " + this.b);
         } else {
            return this.c.a();
         }
      }
   }

   protected void g() {
      fe.a((Closeable)this.c);
      this.c = null;
   }

   protected void h() {
      if(this.a != null && !TextUtils.isEmpty(this.b)) {
         this.a.c(this.b);
      }
   }
}
