package com.flurry.sdk;

import com.flurry.sdk.qq;
import com.flurry.sdk.sh;

public final class qp extends qq {
   protected final sh[] a;
   protected final String[] b;

   protected qp(Class var1) {
      this(var1, (String[])null, (sh[])null, (Object)null, (Object)null);
   }

   protected qp(Class var1, String[] var2, sh[] var3, Object var4, Object var5) {
      super(var1, 0, var4, var5);
      if(var2 != null && var2.length != 0) {
         this.b = var2;
         this.a = var3;
      } else {
         this.b = null;
         this.a = null;
      }
   }

   public static qp d(Class var0) {
      return new qp(var0, (String[])null, (sh[])null, (Object)null, (Object)null);
   }

   public final qp a(Object var1) {
      return new qp(this.d, this.b, this.a, this.f, var1);
   }

   protected final sh a(Class var1) {
      return new qp(var1, this.b, this.a, this.f, this.g);
   }

   protected final String a() {
      StringBuilder var4 = new StringBuilder();
      var4.append(this.d.getName());
      if(this.a != null && this.a.length > 0) {
         var4.append('<');
         boolean var2 = true;
         sh[] var5 = this.a;
         int var3 = var5.length;

         for(int var1 = 0; var1 < var3; ++var1) {
            sh var6 = var5[var1];
            if(var2) {
               var2 = false;
            } else {
               var4.append(',');
            }

            var4.append(var6.m());
         }

         var4.append('>');
      }

      return var4.toString();
   }

   public final String a(int var1) {
      return var1 >= 0 && this.b != null && var1 < this.b.length?this.b[var1]:null;
   }

   public final qp b(Object var1) {
      return var1 == this.f?this:new qp(this.d, this.b, this.a, var1, this.g);
   }

   public final sh b(int var1) {
      return var1 >= 0 && this.a != null && var1 < this.a.length?this.a[var1]:null;
   }

   public final sh b(Class var1) {
      throw new IllegalArgumentException("Internal error: SimpleType.narrowContentsBy() should never be called");
   }

   public final sh c(Class var1) {
      throw new IllegalArgumentException("Internal error: SimpleType.widenContentsBy() should never be called");
   }

   // $FF: synthetic method
   public final sh d(Object var1) {
      return this.b(var1);
   }

   public final sh e(Object var1) {
      throw new IllegalArgumentException("Simple types have no content types; can not call withContenTypeHandler()");
   }

   public final boolean equals(Object var1) {
      if(var1 != this) {
         if(var1 == null) {
            return false;
         }

         if(var1.getClass() != this.getClass()) {
            return false;
         }

         qp var4 = (qp)var1;
         if(var4.d != this.d) {
            return false;
         }

         sh[] var5 = this.a;
         sh[] var6 = var4.a;
         if(var5 == null) {
            if(var6 != null && var6.length != 0) {
               return false;
            }
         } else {
            if(var6 == null) {
               return false;
            }

            if(var5.length != var6.length) {
               return false;
            }

            int var3 = var5.length;

            for(int var2 = 0; var2 < var3; ++var2) {
               if(!var5[var2].equals(var6[var2])) {
                  return false;
               }
            }
         }
      }

      return true;
   }

   // $FF: synthetic method
   public final sh f(Object var1) {
      return this.a(var1);
   }

   public final boolean f() {
      return false;
   }

   public final int h() {
      return this.a == null?0:this.a.length;
   }

   public final String toString() {
      StringBuilder var1 = new StringBuilder(40);
      var1.append("[simple type, class ").append(this.a()).append(']');
      return var1.toString();
   }
}
