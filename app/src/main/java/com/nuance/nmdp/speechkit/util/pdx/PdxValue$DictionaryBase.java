package com.nuance.nmdp.speechkit.util.pdx;

import com.nuance.nmdp.speechkit.util.pdx.PdxValue;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Bytes;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Integer;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue$String;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public abstract class PdxValue$DictionaryBase extends PdxValue {
   private final Map a = new HashMap();

   PdxValue$DictionaryBase(Map var1, int var2) {
      super(var2);
      if(var1 != null) {
         this.a.putAll(var1);
      }

   }

   private boolean a(String var1, Object var2) {
      if(var1 != null && var2 != null) {
         return true;
      } else {
         com.nuance.nmdp.speechkit.recognitionresult.b.b(this, "ignore this put action since either the key or the value is null: key[" + var1 + "] value[" + var2 + "]");
         return false;
      }
   }

   public PdxValue get(String var1) {
      return (PdxValue)this.a.get(var1);
   }

   public Set getEntries() {
      return this.a.entrySet();
   }

   public void put(String var1, int var2) {
      if(this.a(var1, new PdxValue$Integer(var2))) {
         this.a.put(var1, new PdxValue$Integer(var2));
      }

   }

   public void put(String var1, PdxValue var2) {
      if(this.a(var1, var2)) {
         this.a.put(var1, var2);
      }

   }

   public void put(String var1, String var2) {
      if(this.a(var1, var2)) {
         this.a.put(var1, new PdxValue$String(var2));
      }

   }

   public void put(String var1, byte[] var2) {
      if(this.a(var1, var2)) {
         this.a.put(var1, new PdxValue$Bytes(var2));
      }

   }

   public String toString(String var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("{\n");
      String var3 = var1 + "  ";
      Iterator var4 = this.a.entrySet().iterator();

      while(var4.hasNext()) {
         Entry var5 = (Entry)var4.next();
         var2.append(var3);
         var2.append((String)var5.getKey());
         var2.append(" : ");
         var2.append(((PdxValue)var5.getValue()).toString(var3 + "  "));
         var2.append(",\n");
      }

      var2.append(var1);
      var2.append("}");
      return var2.toString();
   }
}
