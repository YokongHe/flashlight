package com.nuance.a.a.a.a;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class m implements .ac {
   private File a = null;
   private FileInputStream b = null;

   static {
      .bh.a(com.nuance.a.a.a.a.s.class);
   }

   public final int a(byte[] var1, int var2) {
      if(this.a == null) {
         return -1;
      } else {
         if(this.b == null) {
            try {
               this.b = new FileInputStream(this.a);
            } catch (FileNotFoundException var5) {
               this.a = null;
               return -1;
            }
         }

         try {
            var2 = this.b.read(var1, 0, var2);
            return var2;
         } catch (Exception var4) {
            try {
               this.b.close();
            } catch (IOException var3) {
               ;
            }

            this.b = null;
            this.a = null;
            return -1;
         }
      }
   }

   public final void a() {
      if(this.b != null) {
         try {
            this.b.close();
         } catch (IOException var2) {
            ;
         }
      }

      this.b = null;
      this.a = null;
   }

   public final boolean a(String var1, .ad var2) {
      this.a = new File(var1);
      boolean var3;
      if(var2 == .ad.a) {
         if(!this.a.exists()) {
            var3 = true;
         } else {
            var3 = false;
         }
      } else {
         var3 = false;
      }

      if(var3) {
         this.a = null;
      }

      return !var3;
   }

   public final long b() {
      return this.a == null?-1L:this.a.length();
   }

   public final boolean c() {
      if(this.a != null) {
         if(this.b != null) {
            try {
               this.b.close();
            } catch (IOException var2) {
               ;
            }
         }

         this.b = null;
         File var1 = this.a;
         this.a = null;
         return var1.delete();
      } else {
         return false;
      }
   }
}
