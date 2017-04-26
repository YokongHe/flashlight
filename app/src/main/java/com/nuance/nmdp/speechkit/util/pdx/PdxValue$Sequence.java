package com.nuance.nmdp.speechkit.util.pdx;

import com.nuance.nmdp.speechkit.util.pdx.PdxValue;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Bytes;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Integer;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue$String;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class PdxValue$Sequence extends PdxValue {
   private final List a;

   public PdxValue$Sequence() {
      this((List)null);
   }

   public PdxValue$Sequence(List var1) {
      super(3);
      this.a = new ArrayList();
      if(var1 != null) {
         this.a.addAll(var1);
      }

   }

   private boolean a(Object var1) {
      if(var1 == null) {
         com.nuance.nmdp.speechkit.recognitionresult.b.b(this, "ignore this add action since the value is null: value[" + var1 + "]");
         return false;
      } else {
         return true;
      }
   }

   public final void add(int var1) {
      this.a.add(new PdxValue$Integer(var1));
   }

   public final void add(PdxValue var1) {
      if(this.a(var1)) {
         this.a.add(var1);
      }

   }

   public final void add(String var1) {
      if(this.a(var1)) {
         this.a.add(new PdxValue$String(var1));
      }

   }

   public final void add(byte[] var1) {
      if(this.a(var1)) {
         this.a.add(new PdxValue$Bytes(var1));
      }

   }

   public final PdxValue get(int var1) {
      return (PdxValue)this.a.get(var1);
   }

   public final List getValues() {
      return this.a;
   }

   public final int size() {
      return this.a.size();
   }

   public final String toString(String var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("[\n");
      String var3 = var1 + "  ";
      Iterator var4 = this.a.iterator();

      while(var4.hasNext()) {
         PdxValue var5 = (PdxValue)var4.next();
         var2.append(var3);
         var2.append(var5.toString(var3));
         var2.append(",\n");
      }

      var2.append(var1);
      var2.append("]");
      return var2.toString();
   }
}
