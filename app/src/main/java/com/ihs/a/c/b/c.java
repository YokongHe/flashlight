package com.ihs.a.c.b;

import android.os.Build.VERSION;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public final class c {
   private static final String[] b = new String[0];
   public com.ihs.a.c.b.k a = null;
   private final URL c;
   private final com.ihs.a.c.b.g d;
   private com.ihs.a.c.b.j e;
   private boolean f;
   private boolean g = true;
   private boolean h = false;
   private int i = 8192;
   private long j = -1L;
   private long k = 0L;
   private String l;
   private int m;
   private com.ihs.a.c.b.i n;

   public c(CharSequence var1, com.ihs.a.c.b.g var2) {
      this.n = com.ihs.a.c.b.i.a;

      try {
         this.c = new URL(var1.toString());
      } catch (MalformedURLException var3) {
         throw new com.ihs.a.c.b.f(var3);
      }

      this.d = var2;
      this.a(com.ihs.a.c.b.e.a);
   }

   // $FF: synthetic method
   static long a(com.ihs.a.c.b.c var0, long var1) {
      var1 += var0.k;
      var0.k = var1;
      return var1;
   }

   private com.ihs.a.c.b.c a(final InputStream var1, final OutputStream var2) {
      return (com.ihs.a.c.b.c)(new com.ihs.a.c.b.d(var1, this.g) {
         // $FF: synthetic method
         public final Object a() {
            byte[] var2x = new byte[c.this.i];

            while(true) {
               int var1x = var1.read(var2x);
               if(var1x == -1) {
                  return c.this;
               }

               var2.write(var2x, 0, var1x);
               com.ihs.a.c.b.c.a(c.this, (long)var1x);
               com.ihs.a.c.b.i var3 = c.this.n;
               c.this.k;
               c.this.j;
               var3.a();
            }
         }
      }).call();
   }

   public static com.ihs.a.c.b.c a(CharSequence var0) {
      return new com.ihs.a.c.b.c(var0, com.ihs.a.c.b.g.a);
   }

   private com.ihs.a.c.b.c a(String var1, String var2, String var3) {
      StringBuilder var4 = new StringBuilder();
      var4.append("form-data; name=\"").append(var1);
      if(var2 != null) {
         var4.append("\"; filename=\"").append(var2);
      }

      var4.append('\"');
      this.c("Content-Disposition", var4.toString());
      if(var3 != null) {
         this.c("Content-Type", var3);
      }

      return this.b((CharSequence)"\r\n");
   }

   private com.ihs.a.c.b.c a(String var1, String var2, String var3, String var4) {
      try {
         this.l();
         this.a(var1, var2, (String)null);
         this.e.a(var4);
         return this;
      } catch (IOException var5) {
         throw new com.ihs.a.c.b.f(var5);
      }
   }

   // $FF: synthetic method
   static String a(String var0) {
      return var0 != null && var0.length() > 0?var0:"UTF-8";
   }

   private com.ihs.a.c.b.c b(CharSequence var1) {
      try {
         this.g();
         this.e.a(var1.toString());
         return this;
      } catch (IOException var2) {
         throw new com.ihs.a.c.b.f(var2);
      }
   }

   private com.ihs.a.c.b.c c(String var1, String var2) {
      return this.b((CharSequence)var1).b((CharSequence)": ").b((CharSequence)var2).b((CharSequence)"\r\n");
   }

   private int i() {
      this.k();
      return this.a.a("Content-Length", -1);
   }

   private com.ihs.a.c.b.c j() {
      if(this.e == null) {
         return this;
      } else {
         if(this.f) {
            this.e.a("\r\n--00content0boundary00--\r\n");
         }

         if(this.g) {
            try {
               this.e.close();
            } catch (IOException var2) {
               ;
            }
         } else {
            this.e.close();
         }

         this.e = null;
         return this;
      }
   }

   private com.ihs.a.c.b.c k() {
      try {
         com.ihs.a.c.b.c var1 = this.j();
         return var1;
      } catch (IOException var2) {
         throw new com.ihs.a.c.b.f(var2);
      }
   }

   private com.ihs.a.c.b.c l() {
      if(!this.f) {
         this.f = true;
         this.a("Content-Type", "multipart/form-data; boundary=00content0boundary00").g();
         this.e.a("--00content0boundary00\r\n");
         return this;
      } else {
         this.e.a("\r\n--00content0boundary00\r\n");
         return this;
      }
   }

   public final int a() {
      try {
         this.j();
         int var1 = this.a.b();
         return var1;
      } catch (IOException var3) {
         throw new com.ihs.a.c.b.f(var3);
      }
   }

   public final com.ihs.a.c.b.c a(int var1) {
      this.a.b(var1);
      return this;
   }

   public final com.ihs.a.c.b.c a(com.ihs.a.c.b.e var1) {
      com.ihs.a.c.b.e var2 = var1;
      if(var1 == com.ihs.a.c.b.e.a) {
         if(VERSION.SDK_INT >= 9) {
            var2 = com.ihs.a.c.b.e.b;
         } else {
            var2 = com.ihs.a.c.b.e.c;
         }
      }

      if(var2 == com.ihs.a.c.b.e.c) {
         this.a = new com.ihs.a.c.b.b();
      } else {
         this.a = new com.ihs.a.c.b.a();
      }

      try {
         if(this.l != null) {
            this.a.a(this.c.toString(), this.d, this.l, this.m);
            return this;
         } else {
            this.a.a(this.c.toString(), this.d);
            return this;
         }
      } catch (IOException var3) {
         throw new com.ihs.a.c.b.f(var3);
      }
   }

   public final com.ihs.a.c.b.c a(File var1) {
      this.j = (long)this.i();

      final BufferedOutputStream var3;
      try {
         var3 = new BufferedOutputStream(new FileOutputStream(var1), this.i);
      } catch (FileNotFoundException var2) {
         throw new com.ihs.a.c.b.f(var2);
      }

      return (com.ihs.a.c.b.c)(new com.ihs.a.c.b.d(var3, this.g) {
      }).call();
   }

   public final com.ihs.a.c.b.c a(OutputStream var1) {
      this.j = (long)this.i();

      try {
         com.ihs.a.c.b.c var3 = this.a((InputStream)(new BufferedInputStream(this.e(), this.i)), (OutputStream)var1);
         return var3;
      } catch (IOException var2) {
         throw new com.ihs.a.c.b.f(var2);
      }
   }

   public final com.ihs.a.c.b.c a(String var1, String var2) {
      this.a.a(var1, var2);
      return this;
   }

   public final com.ihs.a.c.b.c a(String var1, String var2, String var3, InputStream var4) {
      try {
         this.l();
         this.a(var1, var2, var3);
         this.a((InputStream)var4, (OutputStream)this.e);
         return this;
      } catch (IOException var5) {
         throw new com.ihs.a.c.b.f(var5);
      }
   }

   public final com.ihs.a.c.b.c a(boolean var1) {
      this.a.a(var1);
      return this;
   }

   public final com.ihs.a.c.b.c b(int var1) {
      this.a.a(var1);
      return this;
   }

   public final com.ihs.a.c.b.c b(String var1, String var2) {
      return this.a(var1, (String)null, (String)null, (String)var2);
   }

   public final com.ihs.a.c.b.c b(boolean var1) {
      this.a.c(var1);
      return this;
   }

   public final boolean b() {
      return 200 == this.a();
   }

   public final String c() {
      try {
         this.j();
         String var1 = this.a.c();
         return var1;
      } catch (IOException var2) {
         throw new com.ihs.a.c.b.f(var2);
      }
   }

   public final com.ihs.a.c.b.c d() {
      this.n = com.ihs.a.c.b.i.a;
      this.a.g();
      return this;
   }

   public final InputStream e() {
      Object var1;
      if(this.a() < 400) {
         try {
            var1 = this.a.d();
         } catch (IOException var4) {
            throw new com.ihs.a.c.b.f(var4);
         }
      } else {
         InputStream var2 = this.a.e();
         var1 = var2;
         if(var2 == null) {
            try {
               var1 = this.a.d();
            } catch (IOException var5) {
               if(this.i() > 0) {
                  throw new com.ihs.a.c.b.f(var5);
               }

               var1 = new ByteArrayInputStream(new byte[0]);
            }
         }
      }

      if(this.h) {
         this.k();
         if("gzip".equals(this.a.b("Content-Encoding"))) {
            try {
               GZIPInputStream var6 = new GZIPInputStream((InputStream)var1);
               return var6;
            } catch (IOException var3) {
               throw new com.ihs.a.c.b.f(var3);
            }
         }
      }

      return (InputStream)var1;
   }

   public final Map f() {
      this.k();
      return this.a.a();
   }

   public final com.ihs.a.c.b.c g() {
      if(this.e != null) {
         return this;
      } else {
         this.a.b(true);
         String var5 = this.a.a("Content-Type");
         if(var5 != null && var5.length() != 0) {
            int var3 = var5.length();
            int var1 = var5.indexOf(59) + 1;
            if(var1 != 0 && var1 != var3) {
               int var2 = var5.indexOf(59, var1);
               if(var2 == -1) {
                  var2 = var3;
               }

               while(true) {
                  if(var1 >= var2) {
                     var5 = null;
                     break;
                  }

                  int var4 = var5.indexOf(61, var1);
                  if(var4 != -1 && var4 < var2 && "charset".equals(var5.substring(var1, var4).trim())) {
                     String var6 = var5.substring(var4 + 1, var2).trim();
                     var1 = var6.length();
                     if(var1 != 0) {
                        var5 = var6;
                        if(var1 > 2) {
                           var5 = var6;
                           if(34 == var6.charAt(0)) {
                              var5 = var6;
                              if(34 == var6.charAt(var1 - 1)) {
                                 var5 = var6.substring(1, var1 - 1);
                              }
                           }
                        }
                        break;
                     }
                  }

                  ++var2;
                  var4 = var5.indexOf(59, var2);
                  var1 = var4;
                  if(var4 == -1) {
                     var1 = var3;
                  }

                  var4 = var1;
                  var1 = var2;
                  var2 = var4;
               }
            } else {
               var5 = null;
            }
         } else {
            var5 = null;
         }

         this.e = new com.ihs.a.c.b.j(this.a.f(), var5, this.i);
         return this;
      }
   }

   public final com.ihs.a.c.b.j h() {
      return this.e;
   }

   public final String toString() {
      return this.d.toString() + ' ' + this.c;
   }
}
