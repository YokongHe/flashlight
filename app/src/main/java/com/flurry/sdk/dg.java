package com.flurry.sdk;

import com.flurry.sdk.df;
import com.flurry.sdk.do;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class dg {
   static final Integer a = Integer.valueOf(50);
   private static final String d = dg.class.getSimpleName();
   String b;
   LinkedHashMap c;

   public dg(String var1) {
      this.a(var1);
   }

   private boolean a(File param1) {
      // $FF: Couldn't be decompiled
   }

   private boolean a(String param1, List param2) {
      // $FF: Couldn't be decompiled
   }

   private void c() {
      synchronized(this){}

      try {
         LinkedList var1 = new LinkedList(this.c.keySet());
         this.b();
         if(!var1.isEmpty()) {
            this.a((String)this.b, (List)var1);
         }
      } finally {
         ;
      }

   }

   private List e(String param1) {
      // $FF: Couldn't be decompiled
   }

   public List a() {
      return new ArrayList(this.c.keySet());
   }

   public void a(df param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   void a(String var1) {
      this.c = new LinkedHashMap();
      this.b = var1 + "Main";
      List var4 = this.e(this.b);
      if(var4 != null) {
         Iterator var5 = var4.iterator();

         while(var5.hasNext()) {
            String var2 = (String)var5.next();
            List var3 = this.e(var2);
            if(var3 != null) {
               this.c.put(var2, var3);
            }
         }
      }

   }

   public boolean a(String var1, String var2) {
      List var4 = (List)this.c.get(var2);
      boolean var3 = false;
      if(var4 != null) {
         this.b(var1);
         var3 = var4.remove(var1);
      }

      if(var4 != null && !var4.isEmpty()) {
         this.c.put(var2, var4);
         this.a(var2, var4);
         return var3;
      } else {
         this.d(var2);
         return var3;
      }
   }

   void b() {
      this.a(do.a().b().getFileStreamPath(".FlurrySenderIndex.info." + this.b));
   }

   boolean b(String var1) {
      return (new df(var1)).c();
   }

   public List c(String var1) {
      return (List)this.c.get(var1);
   }

   public boolean d(String param1) {
      // $FF: Couldn't be decompiled
   }
}
