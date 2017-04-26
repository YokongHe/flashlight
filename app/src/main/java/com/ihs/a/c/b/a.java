package com.ihs.a.c.b;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Map;

final class a implements com.ihs.a.c.b.k {
   private HttpURLConnection a;

   public final int a(String var1, int var2) {
      return this.a.getHeaderFieldInt(var1, var2);
   }

   public final String a(String var1) {
      return this.a.getRequestProperty(var1);
   }

   public final Map a() {
      return this.a.getHeaderFields();
   }

   public final void a(int var1) {
      this.a.setConnectTimeout(var1);
   }

   public final void a(String var1, com.ihs.a.c.b.g var2) {
      this.a(var1, var2, "", 0);
   }

   public final void a(String param1, com.ihs.a.c.b.g param2, String param3, int param4) {
      // $FF: Couldn't be decompiled
   }

   public final void a(String var1, String var2) {
      this.a.setRequestProperty(var1, var2);
   }

   public final void a(boolean var1) {
      this.a.setUseCaches(var1);
   }

   public final int b() {
      return this.a.getResponseCode();
   }

   public final String b(String var1) {
      return this.a.getHeaderField(var1);
   }

   public final void b(int var1) {
      this.a.setReadTimeout(var1);
   }

   public final void b(boolean var1) {
      this.a.setDoOutput(true);
   }

   public final String c() {
      return this.a.getResponseMessage();
   }

   public final void c(boolean var1) {
      this.a.setInstanceFollowRedirects(var1);
   }

   public final InputStream d() {
      return this.a.getInputStream();
   }

   public final InputStream e() {
      return this.a.getErrorStream();
   }

   public final OutputStream f() {
      return this.a.getOutputStream();
   }

   public final void g() {
      this.a.disconnect();
   }
}
