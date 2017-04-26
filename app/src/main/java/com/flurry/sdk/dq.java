package com.flurry.sdk;

import com.flurry.sdk.dq$a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class dq {
   private Map a = new HashMap();
   private Map b = new HashMap();

   private boolean a(Object var1, Object var2) {
      return var1 == var2 || var1 != null && var1.equals(var2);
   }

   private void b(String var1, Object var2) {
      if(this.b.get(var1) != null) {
         Iterator var3 = ((List)this.b.get(var1)).iterator();

         while(var3.hasNext()) {
            ((dq$a)var3.next()).a(var1, var2);
         }
      }

   }

   public Object a(String var1) {
      synchronized(this){}

      Object var4;
      try {
         var4 = this.a.get(var1);
      } finally {
         ;
      }

      return var4;
   }

   public void a(String param1, dq$a param2) {
      // $FF: Couldn't be decompiled
   }

   public void a(String param1, Object param2) {
      // $FF: Couldn't be decompiled
   }

   public boolean b(String param1, dq$a param2) {
      // $FF: Couldn't be decompiled
   }
}
