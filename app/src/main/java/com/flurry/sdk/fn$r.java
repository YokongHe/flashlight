package com.flurry.sdk;

import com.flurry.sdk.fk;
import com.flurry.sdk.hf;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Map.Entry;

final class fn$r extends LinkedHashMap {
   private Set a;

   public fn$r(Set var1) {
      super(1);
      this.a = var1;
   }

   public final void a(hf var1) {
      Iterator var2 = this.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.a((String)var3.getKey(), (String)var3.getValue());
      }

   }

   public final void a(String var1, String var2) {
      if(this.a.contains(var1)) {
         throw new fk("Can\'t set reserved property: " + var1);
      } else if(var2 == null) {
         throw new fk("Can\'t set a property to null: " + var1);
      } else {
         String var3 = (String)this.get(var1);
         if(var3 == null) {
            this.put(var1, var2);
         } else if(!var3.equals(var2)) {
            throw new fk("Can\'t overwrite property: " + var1);
         }

      }
   }
}
