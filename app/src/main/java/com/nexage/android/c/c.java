package com.nexage.android.c;

import org.json.JSONObject;

public final class c {
   static int d = 0;
   com.nexage.android.g.a a;
   int b;
   int c = -1;
   String e;

   public c(com.nexage.android.g.a var1) {
      this.a = var1;
      this.b = (int)var1.g;
   }

   final JSONObject a() {
      JSONObject var1 = new JSONObject();
      var1.put("a", this.e);
      var1.put("status", this.a.a);
      var1.put("tag", this.a.d.b);
      var1.put("resp", this.b);
      return var1;
   }
}
