package com.flurry.sdk;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class aw$a extends BufferedOutputStream {
   private boolean a;

   private aw$a(OutputStream var1) {
      super(var1);
      this.a = false;
   }

   // $FF: synthetic method
   aw$a(OutputStream var1, Object var2) {
      this(var1);
   }

   private boolean a() {
      return this.a;
   }

   // $FF: synthetic method
   static boolean a(aw$a var0) {
      return var0.a();
   }

   public void close() {
      try {
         super.close();
      } catch (IOException var2) {
         this.a = true;
         throw var2;
      }
   }

   public void flush() {
      try {
         super.flush();
      } catch (IOException var2) {
         this.a = true;
         throw var2;
      }
   }

   public void write(int var1) {
      try {
         super.write(var1);
      } catch (IOException var3) {
         this.a = true;
         throw var3;
      }
   }

   public void write(byte[] var1) {
      try {
         super.write(var1);
      } catch (IOException var2) {
         this.a = true;
         throw var2;
      }
   }

   public void write(byte[] var1, int var2, int var3) {
      try {
         super.write(var1, var2, var3);
      } catch (IOException var4) {
         this.a = true;
         throw var4;
      }
   }
}
