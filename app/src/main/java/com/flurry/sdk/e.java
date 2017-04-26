package com.flurry.sdk;

import android.text.TextUtils;
import java.io.DataInput;
import java.io.DataOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class e {
   private static int a = 1;
   private final int b;
   private final long c;
   private final String d;
   private List e;

   public e(long var1, String var3, long var4) {
      int var6 = a;
      a = var6 + 1;
      this.b = var6;
      this.c = var1;
      this.d = var3;
      this.e = new ArrayList();
   }

   public e(DataInput var1) {
      this.b = var1.readInt();
      this.c = var1.readLong();
      String var5 = var1.readUTF();
      String var4 = var5;
      if(var5.equals("")) {
         var4 = null;
      }

      this.d = var4;
      this.e = new ArrayList();
      short var3 = var1.readShort();

      for(short var2 = 0; var2 < var3; ++var2) {
         this.e.add(new com.flurry.sdk.c(var1));
      }

   }

   public int a() {
      return this.b;
   }

   public void a(com.flurry.sdk.c var1) {
      this.e.add(var1);
   }

   public void a(DataOutput var1) {
      var1.writeInt(this.b);
      var1.writeLong(this.c);
      String var2;
      if(this.d == null) {
         var2 = "";
      } else {
         var2 = this.d;
      }

      var1.writeUTF(var2);
      var1.writeShort(this.e.size());
      Iterator var3 = this.e.iterator();

      while(var3.hasNext()) {
         ((com.flurry.sdk.c)var3.next()).a(var1);
      }

   }

   public String b() {
      return this.d;
   }

   public long c() {
      return this.c;
   }

   public List d() {
      return this.e;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof com.flurry.sdk.e)) {
            return false;
         }

         com.flurry.sdk.e var2 = (com.flurry.sdk.e)var1;
         if(this.b != var2.b || this.c != var2.c || !TextUtils.equals(this.d, var2.d) || this.e != var2.e && (this.e == null || !this.e.equals(var2.e))) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      int var2 = (int)((long)(this.b | 17) | this.c);
      int var1 = var2;
      if(this.d != null) {
         var1 = var2 | this.d.hashCode();
      }

      var2 = var1;
      if(this.e != null) {
         var2 = var1 | this.e.hashCode();
      }

      return var2;
   }
}
