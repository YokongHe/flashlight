package com.flurry.sdk;

import com.flurry.sdk.ca$a;
import com.flurry.sdk.ex;
import com.flurry.sdk.hq;
import com.flurry.sdk.jp;
import com.flurry.sdk.jq;
import com.flurry.sdk.ju$a;
import com.flurry.sdk.oc;
import java.io.InputStream;
import java.io.OutputStream;

public class ca implements ex {
   private Class a;

   public ca(Class var1) {
      this.a = var1;
   }

   public Object a(InputStream var1) {
      if(var1 == null) {
         return null;
      } else {
         jq var2 = new jq();
         oc var3 = new oc("AvroJsonObjectSerializerModule", new hq(1, 0, 0, (String)null));
         var3.a(CharSequence.class, new ca$a(null));
         var2.a((jp)var3);
         return var2.a(var1, this.a);
      }
   }

   public void a(OutputStream var1, Object var2) {
      if(var1 != null && var2 != null) {
         jq var3 = new jq();
         var3.a(ju$a.m, false);
         var3.a(ju$a.b, false);
         var3.a(ju$a.c, false);
         var3.a(var1, var2);
      }
   }
}
