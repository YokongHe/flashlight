package com.ihs.a.c.a;

import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public final class h extends com.ihs.a.c.a.o {
   protected String a;
   protected com.ihs.a.c.a.i b;

   public h(String var1, String var2, com.ihs.a.c.a.l var3) {
      super(var1);
      this.a = var2;
      this.a(var3);
   }

   private boolean b(byte[] var1) {
      if(!TextUtils.isEmpty(this.a)) {
         label39: {
            FileOutputStream var2;
            IOException var6;
            label34: {
               try {
                  (new File(this.a)).getParentFile().mkdirs();
                  var2 = new FileOutputStream(this.a, false);
               } catch (IOException var5) {
                  var6 = var5;
                  var2 = null;
                  break label34;
               }

               try {
                  var2.write(var1);
                  var2.flush();
                  var2.close();
                  break label39;
               } catch (IOException var4) {
                  var6 = var4;
               }
            }

            this.a(this.c(), true, var6.getMessage());
            if(!TextUtils.isEmpty(var6.getMessage()) && var6.getMessage().contains("No space left on device")) {
               com.ihs.a.d.a.a("HS_DISK_NO_SPACE_LEFT");
            }

            if(var2 != null) {
               try {
                  var2.close();
               } catch (IOException var3) {
                  var3.printStackTrace();
               }
            }

            (new File(this.a)).delete();
            return false;
         }
      }

      super.b();
      return true;
   }

   public final void a(byte[] var1) {
      super.a(var1);
      if(this.b != null) {
         com.ihs.a.c.a.i var2 = this.b;
         this.d.b();
      }

   }

   protected final void b() {
      this.b(this.g());
   }
}
