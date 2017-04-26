package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.is;
import com.flurry.sdk.jk;
import com.flurry.sdk.jt;
import com.flurry.sdk.jw;
import com.flurry.sdk.jz;
import com.flurry.sdk.kb;
import com.flurry.sdk.ov;
import com.flurry.sdk.ov$d;
import com.flurry.sdk.pf;
import com.flurry.sdk.py$a;
import com.flurry.sdk.sh;

@kb
public class pr extends py$a implements jt {
   protected final boolean a;
   protected final sh b;
   protected jk c;
   protected ov d;

   public pr(sh var1, boolean var2, jz var3, is var4, jk var5) {
      super(Object[].class, var3, var4);
      this.b = var1;
      this.a = var2;
      this.d = ov.a();
      this.c = var5;
   }

   protected final jk a(ov var1, sh var2, jw var3) {
      ov$d var4 = var1.a(var2, var3, this.f);
      if(var1 != var4.b) {
         this.d = var4.b;
      }

      return var4.a;
   }

   protected final jk a(ov var1, Class var2, jw var3) {
      ov$d var4 = var1.a(var2, var3, this.f);
      if(var1 != var4.b) {
         this.d = var4.b;
      }

      return var4.a;
   }

   public pf a(jz var1) {
      return new pr(this.b, this.a, var1, this.f, this.c);
   }

   public void a(jw var1) {
      if(this.a && this.c == null) {
         this.c = var1.a(this.b, this.f);
      }

   }

   public void a(Object[] param1, hf param2, jw param3) {
      // $FF: Couldn't be decompiled
   }

   public void a(Object[] param1, hf param2, jw param3, jk param4) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   public void b(Object var1, hf var2, jw var3) {
      this.a((Object[])var1, var2, var3);
   }

   public void b(Object[] param1, hf param2, jw param3) {
      // $FF: Couldn't be decompiled
   }
}
