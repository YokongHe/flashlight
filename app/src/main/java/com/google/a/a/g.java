package com.google.a.a;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

@Deprecated
public abstract class g {
   protected void a() {
   }

   public void load(Map var1) {
      HashMap var4 = new HashMap();
      Field[] var5 = this.getClass().getFields();
      int var3 = var5.length;

      Field var6;
      for(int var2 = 0; var2 < var3; ++var2) {
         var6 = var5[var2];
         com.google.a.a.i var7 = (com.google.a.a.i)var6.getAnnotation(com.google.a.a.i.class);
         if(var7 != null) {
            var4.put(var7.a(), var6);
         }
      }

      if(var4.isEmpty()) {
         com.google.android.gms.internal.bJ.e("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
      }

      Iterator var10 = var1.entrySet().iterator();

      while(var10.hasNext()) {
         Entry var13 = (Entry)var10.next();
         var6 = (Field)var4.remove(var13.getKey());
         if(var6 != null) {
            try {
               var6.set(this, var13.getValue());
            } catch (IllegalAccessException var8) {
               com.google.android.gms.internal.bJ.e("Server option \"" + (String)var13.getKey() + "\" could not be set: Illegal Access");
            } catch (IllegalArgumentException var9) {
               com.google.android.gms.internal.bJ.e("Server option \"" + (String)var13.getKey() + "\" could not be set: Bad Type");
            }
         } else {
            com.google.android.gms.internal.bJ.a("Unexpected server option: " + (String)var13.getKey() + " = \"" + (String)var13.getValue() + "\"");
         }
      }

      StringBuilder var11 = new StringBuilder();
      Iterator var12 = var4.values().iterator();

      while(var12.hasNext()) {
         Field var14 = (Field)var12.next();
         if(((com.google.a.a.i)var14.getAnnotation(com.google.a.a.i.class)).b()) {
            com.google.android.gms.internal.bJ.e("Required server option missing: " + ((com.google.a.a.i)var14.getAnnotation(com.google.a.a.i.class)).a());
            if(var11.length() > 0) {
               var11.append(", ");
            }

            var11.append(((com.google.a.a.i)var14.getAnnotation(com.google.a.a.i.class)).a());
         }
      }

      if(var11.length() > 0) {
         throw new com.google.a.a.h("Required server option(s) missing: " + var11.toString());
      } else {
         this.a();
      }
   }
}
