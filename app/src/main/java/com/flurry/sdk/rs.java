package com.flurry.sdk;

import com.flurry.sdk.rj;
import com.flurry.sdk.rl;
import com.flurry.sdk.rm;
import com.flurry.sdk.rn;
import com.flurry.sdk.rp;
import com.flurry.sdk.rq;
import com.flurry.sdk.rr;
import com.flurry.sdk.rt;
import com.flurry.sdk.ru;
import com.flurry.sdk.rv;
import com.flurry.sdk.rw;
import com.flurry.sdk.rx;
import com.flurry.sdk.ry;
import java.math.BigDecimal;
import java.math.BigInteger;

public class rs {
   public static final rs a = new rs();

   public rm a(byte[] var1) {
      return rm.a(var1);
   }

   public rn a(boolean var1) {
      return var1?rn.s():rn.t();
   }

   public ru a() {
      return ru.s();
   }

   public rv a(double var1) {
      return rq.b(var1);
   }

   public rv a(int var1) {
      return rr.a(var1);
   }

   public rv a(long var1) {
      return rt.a(var1);
   }

   public rv a(BigDecimal var1) {
      return rp.a(var1);
   }

   public rv a(BigInteger var1) {
      return rl.a(var1);
   }

   public rx a(Object var1) {
      return new rx(var1);
   }

   public ry a(String var1) {
      return ry.b(var1);
   }

   public rj b() {
      return new rj(this);
   }

   public rw c() {
      return new rw(this);
   }
}
