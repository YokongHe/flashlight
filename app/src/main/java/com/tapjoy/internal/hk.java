package com.tapjoy.internal;

public final class hk {
   public static hk a = new hk((String)null);
   private String b;
   private Throwable c;
   private Object[] d;

   public hk(String var1) {
      this(var1, (Object[])null, (Throwable)null);
   }

   public hk(String var1, Object[] var2, Throwable var3) {
      this.b = var1;
      this.c = var3;
      if(var3 == null) {
         this.d = var2;
      } else if(var2 != null && var2.length != 0) {
         int var4 = var2.length - 1;
         Object[] var5 = new Object[var4];
         System.arraycopy(var2, 0, var5, 0, var4);
         this.d = var5;
      } else {
         throw new IllegalStateException("non-sensical empty or null argument array");
      }
   }

   public final String a() {
      return this.b;
   }

   public final Throwable b() {
      return this.c;
   }
}
