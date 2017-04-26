package com.tapjoy.internal;

import com.tapjoy.internal.dh$a;
import com.tapjoy.internal.dh$b;
import com.tapjoy.internal.dm;
import com.tapjoy.internal.dp;
import com.tapjoy.internal.du;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public abstract class dh implements Iterable {
   public static final dh a;
   // $FF: synthetic field
   static final boolean b;

   static {
      boolean var0;
      if(!dh.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      b = var0;
      a = new dp(new byte[0]);
   }

   public static dh a(Iterable var0) {
      Object var3;
      if(!(var0 instanceof Collection)) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = var0.iterator();

         while(var2.hasNext()) {
            var1.add((dh)var2.next());
         }

         var3 = var1;
      } else {
         var3 = (Collection)var0;
      }

      return ((Collection)var3).isEmpty()?a:a(((Collection)var3).iterator(), ((Collection)var3).size());
   }

   public static dh a(String var0) {
      try {
         dp var2 = new dp(var0.getBytes("UTF-8"));
         return var2;
      } catch (UnsupportedEncodingException var1) {
         throw new RuntimeException("UTF-8 not supported?", var1);
      }
   }

   private static dh a(Iterator var0, int var1) {
      if(!b && var1 <= 0) {
         throw new AssertionError();
      } else if(var1 == 1) {
         return (dh)var0.next();
      } else {
         int var2 = var1 >>> 1;
         return a(var0, var2).a(a(var0, var1 - var2));
      }
   }

   public static dh a(byte[] var0, int var1, int var2) {
      byte[] var3 = new byte[var2];
      System.arraycopy(var0, var1, var3, 0, var2);
      return new dp(var3);
   }

   public static dh$b h() {
      return new dh$b();
   }

   public abstract int a();

   protected abstract int a(int var1, int var2, int var3);

   public final dh a(dh var1) {
      int var2 = this.a();
      int var3 = var1.a();
      if((long)var2 + (long)var3 >= 2147483647L) {
         throw new IllegalArgumentException((new StringBuilder(53)).append("ByteString would be too long: ").append(var2).append("+").append(var3).toString());
      } else {
         return du.a(this, var1);
      }
   }

   final void a(OutputStream var1, int var2, int var3) {
      if(var2 < 0) {
         throw new IndexOutOfBoundsException((new StringBuilder(30)).append("Source offset < 0: ").append(var2).toString());
      } else if(var3 < 0) {
         throw new IndexOutOfBoundsException((new StringBuilder(23)).append("Length < 0: ").append(var3).toString());
      } else if(var2 + var3 > this.a()) {
         throw new IndexOutOfBoundsException((new StringBuilder(39)).append("Source end offset exceeded: ").append(var2 + var3).toString());
      } else {
         if(var3 > 0) {
            this.b(var1, var2, var3);
         }

      }
   }

   protected abstract void a(byte[] var1, int var2, int var3, int var4);

   protected abstract int b(int var1, int var2, int var3);

   public abstract String b(String var1);

   abstract void b(OutputStream var1, int var2, int var3);

   public final void b(byte[] var1, int var2, int var3, int var4) {
      if(var2 < 0) {
         throw new IndexOutOfBoundsException((new StringBuilder(30)).append("Source offset < 0: ").append(var2).toString());
      } else if(var3 < 0) {
         throw new IndexOutOfBoundsException((new StringBuilder(30)).append("Target offset < 0: ").append(var3).toString());
      } else if(var4 < 0) {
         throw new IndexOutOfBoundsException((new StringBuilder(23)).append("Length < 0: ").append(var4).toString());
      } else if(var2 + var4 > this.a()) {
         throw new IndexOutOfBoundsException((new StringBuilder(34)).append("Source end offset < 0: ").append(var2 + var4).toString());
      } else if(var3 + var4 > var1.length) {
         throw new IndexOutOfBoundsException((new StringBuilder(34)).append("Target end offset < 0: ").append(var3 + var4).toString());
      } else {
         if(var4 > 0) {
            this.a(var1, var2, var3, var4);
         }

      }
   }

   public abstract dh$a c();

   public final boolean d() {
      return this.a() == 0;
   }

   public final byte[] e() {
      int var1 = this.a();
      if(var1 == 0) {
         return dm.a;
      } else {
         byte[] var2 = new byte[var1];
         this.a(var2, 0, 0, var1);
         return var2;
      }
   }

   public final String f() {
      try {
         String var1 = this.b("UTF-8");
         return var1;
      } catch (UnsupportedEncodingException var2) {
         throw new RuntimeException("UTF-8 not supported?", var2);
      }
   }

   public abstract boolean g();

   public abstract int hashCode();

   protected abstract int i();

   // $FF: synthetic method
   public Iterator iterator() {
      return this.c();
   }

   protected abstract boolean j();

   protected abstract int k();

   public String toString() {
      return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(this.a())});
   }
}
