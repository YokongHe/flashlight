package com.flurry.sdk;

import com.flurry.sdk.jh;
import com.flurry.sdk.kt;
import com.flurry.sdk.mu;
import com.flurry.sdk.sh;

public abstract class kx {
   public Object a(double var1) {
      throw new jh("Can not instantiate value of type " + this.a() + " from JSON floating-point number");
   }

   public Object a(int var1) {
      throw new jh("Can not instantiate value of type " + this.a() + " from JSON int number");
   }

   public Object a(long var1) {
      throw new jh("Can not instantiate value of type " + this.a() + " from JSON long number");
   }

   public Object a(Object var1) {
      throw new jh("Can not instantiate value of type " + this.a() + " using delegate");
   }

   public Object a(String var1) {
      throw new jh("Can not instantiate value of type " + this.a() + " from JSON String");
   }

   public Object a(boolean var1) {
      throw new jh("Can not instantiate value of type " + this.a() + " from JSON boolean value");
   }

   public Object a(Object[] var1) {
      throw new jh("Can not instantiate value of type " + this.a() + " with arguments");
   }

   public abstract String a();

   public boolean b() {
      return this.h() || this.i() || this.j() || this.c() || this.d() || this.e() || this.f() || this.g();
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public boolean e() {
      return false;
   }

   public boolean f() {
      return false;
   }

   public boolean g() {
      return false;
   }

   public boolean h() {
      return this.n() != null;
   }

   public boolean i() {
      return this.l() != null;
   }

   public boolean j() {
      return false;
   }

   public kt[] k() {
      return null;
   }

   public sh l() {
      return null;
   }

   public Object m() {
      throw new jh("Can not instantiate value of type " + this.a() + "; no default creator found");
   }

   public mu n() {
      return null;
   }

   public mu o() {
      return null;
   }
}
