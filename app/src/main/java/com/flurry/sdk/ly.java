package com.flurry.sdk;

import com.flurry.sdk.jg;
import com.flurry.sdk.ly$b;
import com.flurry.sdk.ly$c;
import com.flurry.sdk.ly$d;
import com.flurry.sdk.ly$e;
import com.flurry.sdk.ly$f;
import com.flurry.sdk.ly$g;
import com.flurry.sdk.ly$h;
import com.flurry.sdk.ly$i;
import com.flurry.sdk.ly$j;
import com.flurry.sdk.qs;
import java.lang.reflect.Type;
import java.util.HashMap;

public class ly {
   static final ly b = new ly();
   HashMap a = new HashMap();

   protected ly() {
      this.a(Boolean.TYPE, new ly$b());
      this.a(Byte.TYPE, new ly$c());
      this.a(Short.TYPE, new ly$i());
      this.a(Integer.TYPE, new ly$g());
      this.a(Long.TYPE, new ly$h());
      this.a(Float.TYPE, new ly$f());
      this.a(Double.TYPE, new ly$e());
      this.a(String.class, new ly$j());
      this.a(Character.TYPE, new ly$d());
   }

   public static HashMap a() {
      return b.a;
   }

   private void a(Class var1, jg var2) {
      this.a.put(qs.a().a((Type)var1), var2);
   }
}
