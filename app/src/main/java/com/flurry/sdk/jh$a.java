package com.flurry.sdk;

import java.io.Serializable;

public class jh$a implements Serializable {
   protected Object a;
   protected String b;
   protected int c = -1;

   protected jh$a() {
   }

   public jh$a(Object var1, int var2) {
      this.a = var1;
      this.c = var2;
   }

   public jh$a(Object var1, String var2) {
      this.a = var1;
      if(var2 == null) {
         throw new NullPointerException("Can not pass null fieldName");
      } else {
         this.b = var2;
      }
   }

   public String toString() {
      StringBuilder var2 = new StringBuilder();
      Class var1;
      if(this.a instanceof Class) {
         var1 = (Class)this.a;
      } else {
         var1 = this.a.getClass();
      }

      Package var3 = var1.getPackage();
      if(var3 != null) {
         var2.append(var3.getName());
         var2.append('.');
      }

      var2.append(var1.getSimpleName());
      var2.append('[');
      if(this.b != null) {
         var2.append('\"');
         var2.append(this.b);
         var2.append('\"');
      } else if(this.c >= 0) {
         var2.append(this.c);
      } else {
         var2.append('?');
      }

      var2.append(']');
      return var2.toString();
   }
}
