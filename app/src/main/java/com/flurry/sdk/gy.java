package com.flurry.sdk;

import com.flurry.sdk.ga;
import java.io.UnsupportedEncodingException;

public class gy implements CharSequence, Comparable {
   private static final byte[] a = new byte[0];
   private byte[] b;
   private int c;
   private String d;

   public gy() {
      this.b = a;
   }

   public gy(gy var1) {
      this.b = a;
      this.c = var1.c;
      this.b = new byte[var1.c];
      System.arraycopy(var1.b, 0, this.b, 0, this.c);
      this.d = var1.d;
   }

   public gy(String var1) {
      this.b = a;
      this.b = a(var1);
      this.c = this.b.length;
      this.d = var1;
   }

   public static final byte[] a(String var0) {
      try {
         byte[] var2 = var0.getBytes("UTF-8");
         return var2;
      } catch (UnsupportedEncodingException var1) {
         var1.printStackTrace();
         return new byte[0];
      }
   }

   public int a(gy var1) {
      return ga.a(this.b, 0, this.c, var1.b, 0, var1.c);
   }

   public gy a(int var1) {
      if(this.c < var1) {
         byte[] var2 = new byte[var1];
         System.arraycopy(this.b, 0, var2, 0, this.c);
         this.b = var2;
      }

      this.c = var1;
      this.d = null;
      return this;
   }

   public byte[] a() {
      return this.b;
   }

   public int b() {
      return this.c;
   }

   public char charAt(int var1) {
      return this.toString().charAt(var1);
   }

   // $FF: synthetic method
   public int compareTo(Object var1) {
      return this.a((gy)var1);
   }

   public boolean equals(Object var1) {
      boolean var4 = false;
      boolean var3;
      if(var1 == this) {
         var3 = true;
      } else {
         var3 = var4;
         if(var1 instanceof gy) {
            gy var5 = (gy)var1;
            var3 = var4;
            if(this.c == var5.c) {
               byte[] var6 = var5.b;
               int var2 = 0;

               while(true) {
                  if(var2 >= this.c) {
                     return true;
                  }

                  var3 = var4;
                  if(this.b[var2] != var6[var2]) {
                     break;
                  }

                  ++var2;
               }
            }
         }
      }

      return var3;
   }

   public int hashCode() {
      int var1 = 0;

      int var2;
      for(var2 = 0; var1 < this.c; ++var1) {
         var2 = var2 * 31 + this.b[var1];
      }

      return var2;
   }

   public int length() {
      return this.toString().length();
   }

   public CharSequence subSequence(int var1, int var2) {
      return this.toString().subSequence(var1, var2);
   }

   public String toString() {
      if(this.d == null) {
         try {
            this.d = new String(this.b, 0, this.c, "UTF-8");
         } catch (UnsupportedEncodingException var2) {
            var2.printStackTrace();
         }
      }

      return this.d;
   }
}
