package com.google.android.gms.tagmanager;

final class O extends Number implements Comparable {
   private double a;
   private long b;
   private boolean c;

   private O(long var1) {
      this.b = var1;
      this.c = true;
   }

   private int a(com.google.android.gms.tagmanager.O var1) {
      return this.c && var1.c?(new Long(this.b)).compareTo(Long.valueOf(var1.b)):Double.compare(this.doubleValue(), var1.doubleValue());
   }

   public static com.google.android.gms.tagmanager.O a(long var0) {
      return new com.google.android.gms.tagmanager.O(0L);
   }

   public final boolean a() {
      return !this.c;
   }

   public final boolean b() {
      return this.c;
   }

   public final byte byteValue() {
      return (byte)((int)this.longValue());
   }

   // $FF: synthetic method
   public final int compareTo(Object var1) {
      return this.a((com.google.android.gms.tagmanager.O)var1);
   }

   public final double doubleValue() {
      return this.c?(double)this.b:this.a;
   }

   public final boolean equals(Object var1) {
      return var1 instanceof com.google.android.gms.tagmanager.O && this.a((com.google.android.gms.tagmanager.O)var1) == 0;
   }

   public final float floatValue() {
      return (float)this.doubleValue();
   }

   public final int hashCode() {
      return (new Long(this.longValue())).hashCode();
   }

   public final int intValue() {
      return (int)this.longValue();
   }

   public final long longValue() {
      return this.c?this.b:(long)this.a;
   }

   public final short shortValue() {
      return (short)((int)this.longValue());
   }

   public final String toString() {
      return this.c?Long.toString(this.b):Double.toString(this.a);
   }
}
