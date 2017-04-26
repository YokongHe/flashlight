package com.inmobi.commons.internal;

public class CommonsException extends Exception {
   public static final int APPLICATION_NOT_SET = 1;
   public static final int PRODUCT_NOT_FOUND = 2;
   private static final long serialVersionUID = 3805362231723549913L;
   private int a;

   public CommonsException(int var1) {
      this.a = var1;
   }

   public int getCode() {
      return this.a;
   }

   public String toString() {
      switch(this.a) {
      case 1:
         return "Application not set/initialize not called.";
      case 2:
         return "Product not found.";
      default:
         return "Unknown.";
      }
   }
}
