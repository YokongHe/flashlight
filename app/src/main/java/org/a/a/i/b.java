package org.a.a.i;

import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b {
   static final Pattern a = Pattern.compile("[^\t\n\r -~\u0085 -\ud7ff\ue000-￼]");
   private String b = "<string>";
   private final Reader c;
   private int d = 0;
   private boolean e = true;
   private String f = "";
   private int g = 0;
   private int h = 0;
   private int i = 0;
   private char[] j;

   public b(String var1) {
      Matcher var6 = a.matcher(var1);
      if(var6.find()) {
         int var2 = this.g;
         int var3 = this.f.length();
         int var4 = this.d;
         int var5 = var6.start();
         throw new a(this.b, var2 + var3 - var4 + var5, var6.group().charAt(0), "special characters are not allowed");
      } else {
         this.f = var1 + "\u0000";
         this.c = null;
         this.e = true;
         this.j = null;
      }
   }

   private void g() {
      // $FF: Couldn't be decompiled
   }

   public final org.a.a.c.a a() {
      return new org.a.a.c.a(this.b, this.g, this.h, this.i, this.f, this.d);
   }

   public final void a(int var1) {
      if(this.d + var1 + 1 >= this.f.length()) {
         this.g();
      }

      for(int var3 = 0; var3 < var1; ++var3) {
         char var2 = this.f.charAt(this.d);
         ++this.d;
         ++this.g;
         if(org.a.a.l.a.a.a(var2) || var2 == 13 && this.f.charAt(this.d) != 10) {
            ++this.h;
            this.i = 0;
         } else if(var2 != '\ufeff') {
            ++this.i;
         }
      }

   }

   public final char b(int var1) {
      if(this.d + var1 + 1 > this.f.length()) {
         this.g();
      }

      return this.f.charAt(this.d + var1);
   }

   public final void b() {
      this.a(1);
   }

   public final char c() {
      return this.f.charAt(this.d);
   }

   public final String c(int var1) {
      if(this.d + var1 >= this.f.length()) {
         this.g();
      }

      return this.d + var1 > this.f.length()?this.f.substring(this.d):this.f.substring(this.d, this.d + var1);
   }

   public final int d() {
      return this.i;
   }

   public final String d(int var1) {
      String var2 = this.c(var1);
      this.d += var1;
      this.g += var1;
      this.i += var1;
      return var2;
   }

   public final int e() {
      return this.g;
   }

   public final int f() {
      return this.h;
   }
}
