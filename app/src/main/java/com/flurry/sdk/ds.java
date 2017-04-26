package com.flurry.sdk;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map.Entry;

public class ds {
   private final Map a = new HashMap();
   private int b;

   private List a(Object var1, boolean var2) {
      List var4 = (List)this.a.get(var1);
      Object var3 = var4;
      if(var2) {
         var3 = var4;
         if(var4 == null) {
            if(this.b > 0) {
               var3 = new ArrayList(this.b);
            } else {
               var3 = new ArrayList();
            }

            this.a.put(var1, var3);
         }
      }

      return (List)var3;
   }

   public List a(Object var1) {
      List var3;
      if(var1 == null) {
         var3 = Collections.emptyList();
      } else {
         List var2 = this.a(var1, false);
         var3 = var2;
         if(var2 == null) {
            return Collections.emptyList();
         }
      }

      return var3;
   }

   public void a() {
      this.a.clear();
   }

   public void a(ds var1) {
      if(var1 != null) {
         Iterator var3 = var1.a.entrySet().iterator();

         while(var3.hasNext()) {
            Entry var2 = (Entry)var3.next();
            this.a.put(var2.getKey(), var2.getValue());
         }
      }

   }

   public void a(Object var1, Object var2) {
      if(var1 != null) {
         this.a(var1, true).add(var2);
      }
   }

   public Collection b() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.a.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         Iterator var4 = ((List)var3.getValue()).iterator();

         while(var4.hasNext()) {
            Object var5 = var4.next();
            var1.add(new SimpleImmutableEntry(var3.getKey(), var5));
         }
      }

      return var1;
   }

   public boolean b(Object var1) {
      return var1 == null?false:(List)this.a.remove(var1) != null;
   }

   public boolean b(Object var1, Object var2) {
      boolean var3 = false;
      if(var1 != null) {
         List var5 = this.a(var1, false);
         if(var5 != null) {
            boolean var4 = var5.remove(var2);
            var3 = var4;
            if(var5.size() == 0) {
               this.a.remove(var1);
               return var4;
            }
         }
      }

      return var3;
   }

   public Set c() {
      return this.a.keySet();
   }
}
