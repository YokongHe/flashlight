package com.flurry.sdk;

import com.flurry.sdk.si;
import com.flurry.sdk.sp;
import java.io.Writer;

public final class il extends Writer {
   protected final sp a;

   public il(si var1) {
      this.a = new sp(var1);
   }

   public final String a() {
      String var1 = this.a.f();
      this.a.a();
      return var1;
   }

   public final Writer append(char var1) {
      this.write(var1);
      return this;
   }

   public final Writer append(CharSequence var1) {
      String var2 = var1.toString();
      this.a.a((String)var2, 0, var2.length());
      return this;
   }

   public final Writer append(CharSequence var1, int var2, int var3) {
      String var4 = var1.subSequence(var2, var3).toString();
      this.a.a((String)var4, 0, var4.length());
      return this;
   }

   public final void close() {
   }

   public final void flush() {
   }

   public final void write(int var1) {
      this.a.a((char)var1);
   }

   public final void write(String var1) {
      this.a.a((String)var1, 0, var1.length());
   }

   public final void write(String var1, int var2, int var3) {
      this.a.a((String)var1, 0, var1.length());
   }

   public final void write(char[] var1) {
      this.a.c(var1, 0, var1.length);
   }

   public final void write(char[] var1, int var2, int var3) {
      this.a.c(var1, var2, var3);
   }
}
