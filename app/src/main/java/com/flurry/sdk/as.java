package com.flurry.sdk;

import com.flurry.sdk.as$a;
import com.flurry.sdk.aw$c;
import com.flurry.sdk.do;
import com.flurry.sdk.el;
import com.flurry.sdk.el$a;
import com.flurry.sdk.em;
import com.flurry.sdk.en;
import com.flurry.sdk.en$a;
import com.flurry.sdk.en$b;
import com.flurry.sdk.en$c;
import com.flurry.sdk.eo;
import com.flurry.sdk.fe;
import com.flurry.sdk.ff;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;

public abstract class as {
   private static final String a = com.flurry.sdk.as.class.getSimpleName();
   private as$a b;
   private String c;
   private long d = Long.MAX_VALUE;
   private int e = Integer.MAX_VALUE;
   private com.flurry.sdk.aw f;
   private long g;
   private boolean h;
   private int i;
   private long j = 102400L;
   private int k;
   private boolean l;
   private boolean m;

   private long a(en var1) {
      List var5 = var1.b("Content-Length");
      if(var5 != null && !var5.isEmpty()) {
         try {
            long var2 = Long.parseLong((String)var5.get(0));
            return var2;
         } catch (NumberFormatException var4) {
            eo.a(3, a, "Downloader: could not determine content length for url: " + this.c);
         }
      }

      return -1L;
   }

   private String a(int var1) {
      return String.format(Locale.US, "%s__%03d", new Object[]{this.c, Integer.valueOf(var1)});
   }

   private String b(int var1) {
      return String.format("%s=%d-%d", new Object[]{"bytes", Long.valueOf((long)var1 * this.j), Long.valueOf(Math.min(this.g, (long)(var1 + 1) * this.j) - 1L)});
   }

   private void j() {
      if(!this.b()) {
         eo.a(3, a, "Downloader: Requesting file from url: " + this.c);
         en var1 = new en();
         var1.a(this.c);
         var1.a(en$a.b);
         var1.a(this.e);
         var1.a((en$c)(new en$b() {
            public void a(en var1) {
               if(!as.this.b()) {
                  int var2 = var1.e();
                  eo.a(3, com.flurry.sdk.as.a, "Downloader: Download status code is:" + var2 + " for url: " + as.this.c);
                  as.this.l = var1.c();
                  do.a().c(new ff() {
                     public void a() {
                        if(!as.this.l) {
                           as.this.h();
                        }

                        as.this.o();
                     }
                  });
               }
            }

            public void a(en var1, InputStream var2) {
               if(as.this.b()) {
                  throw new IOException("Downloader: request cancelled");
               } else {
                  as.this.g = as.this.a(var1);
                  if(as.this.g > as.this.d) {
                     throw new IOException("Downloader: content length: " + as.this.g + " exceeds size limit: " + as.this.d);
                  } else {
                     com.flurry.sdk.az var9;
                     try {
                        var9 = new com.flurry.sdk.az(var2, as.this.d);
                     } finally {
                        ;
                     }

                     try {
                        fe.a(var9, as.this.f());
                     } finally {
                        as.this.g();
                        fe.a((Closeable)var9);
                        throw var1;
                     }

                  }
               }
            }
         }));
         em.a().a(this, var1);
      }
   }

   private void k() {
      if(!this.b()) {
         el var1 = new el();
         var1.a((String)this.c);
         var1.a((en$a)en$a.f);
         var1.a(new el$a() {
            public void a(el var1, Void var2) {
               if(!as.this.b()) {
                  int var3 = var1.e();
                  eo.a(3, com.flurry.sdk.as.a, "Downloader: HTTP HEAD status code is:" + var3 + " for url: " + as.this.c);
                  if(!var1.c()) {
                     do.a().c(new ff() {
                        public void a() {
                           as.this.o();
                        }
                     });
                  } else {
                     as.this.g = as.this.a((en)var1);
                     List var6 = var1.b((String)"Accept-Ranges");
                     if(as.this.g > 0L && var6 != null && !var6.isEmpty()) {
                        as.this.h = "bytes".equals(((String)var6.get(0)).trim());
                        com.flurry.sdk.as var7 = as.this;
                        long var4 = as.this.g / as.this.j;
                        byte var8;
                        if(as.this.g % as.this.j > 0L) {
                           var8 = 1;
                        } else {
                           var8 = 0;
                        }

                        var7.i = (int)((long)var8 + var4);
                     } else {
                        as.this.i = 1;
                     }

                     if(as.this.d > 0L && as.this.g > as.this.d) {
                        eo.a(3, com.flurry.sdk.as.a, "Downloader: Size limit exceeded -- limit: " + as.this.d + ", content-length: " + as.this.g + " bytes!");
                        do.a().c(new ff() {
                           public void a() {
                              as.this.o();
                           }
                        });
                     } else {
                        do.a().c(new ff() {
                           public void a() {
                              as.this.l();
                           }
                        });
                     }
                  }
               }
            }
         });
         eo.a(3, a, "Downloader: requesting HTTP HEAD for url: " + this.c);
         em.a().a(this, var1);
      }
   }

   private void l() {
      if(!this.b()) {
         if(!this.q()) {
            this.j();
         } else {
            for(int var1 = 0; var1 < this.i; ++var1) {
               this.f.d(this.a(var1));
            }

            this.m();
         }
      }
   }

   // $FF: synthetic method
   static int m(com.flurry.sdk.as var0) {
      int var1 = var0.k;
      var0.k = var1 + 1;
      return var1;
   }

   private void m() {
      while(true) {
         if(this.k < this.i) {
            if(this.b()) {
               return;
            }

            final String var1 = this.a(this.k);
            final String var2 = this.b(this.k);
            if(this.f.d(var1)) {
               eo.a(3, a, "Downloader: Skipping chunk with range:" + var2 + " for url: " + this.c + " chunk: " + this.k);
               ++this.k;
               continue;
            }

            eo.a(3, a, "Downloader: Requesting chunk with range:" + var2 + " for url: " + this.c + " chunk: " + this.k);
            en var3 = new en();
            var3.a(this.c);
            var3.a(en$a.b);
            var3.a(this.e);
            var3.a("Range", var2);
            var3.a((en$c)(new en$b() {
               public void a(en var1x) {
                  if(!as.this.b()) {
                     int var2x = var1x.e();
                     eo.a(3, com.flurry.sdk.as.a, "Downloader: Download status code is:" + var2x + " for url: " + as.this.c + " chunk: " + as.this.k);
                     Object var4 = null;
                     List var5 = var1x.b("Content-Range");
                     String var3 = (String)var4;
                     if(var5 != null) {
                        var3 = (String)var4;
                        if(!var5.isEmpty()) {
                           var3 = (String)var5.get(0);
                           eo.a(3, com.flurry.sdk.as.a, "Downloader: Content range is:" + var3 + " for url: " + as.this.c + " chunk: " + as.this.k);
                        }
                     }

                     if(var1x.c() && var2x == 206 && var3 != null && var3.startsWith(var2.replaceAll("=", " "))) {
                        com.flurry.sdk.as.m(as.this);
                        do.a().c(new ff() {
                           public void a() {
                              as.this.m();
                           }
                        });
                     } else {
                        do.a().c(new ff() {
                           public void a() {
                              as.this.o();
                           }
                        });
                     }
                  }
               }

               public void a(en var1x, InputStream var2x) {
                  Object var3 = null;
                  Object var4 = null;
                  if(as.this.b()) {
                     throw new IOException("Downloader: request cancelled");
                  } else {
                     aw$c var5 = as.this.f.b(var1);
                     IOException var18 = (IOException)var4;
                     if(var5 != null) {
                        label130: {
                           label129: {
                              label128: {
                                 com.flurry.sdk.az var19;
                                 label127: {
                                    try {
                                       var19 = new com.flurry.sdk.az(var2x, as.this.d);
                                       break label127;
                                    } catch (IOException var16) {
                                       var18 = var16;
                                    } finally {
                                       ;
                                    }

                                    var2x = null;
                                    break label128;
                                 }

                                 try {
                                    fe.a(var19, var5.a());
                                    break label129;
                                 } catch (IOException var14) {
                                    var18 = var14;
                                 } finally {
                                    fe.a((Closeable)var5);
                                    fe.a((Closeable)var19);
                                    throw var18;
                                 }
                              }

                              fe.a((Closeable)var5);
                              fe.a((Closeable)var2x);
                              break label130;
                           }

                        }
                     }

                     if(var18 != null) {
                        as.this.f.c(var1);
                        throw var18;
                     }
                  }
               }
            }));
            em.a().a(this, var3);
            return;
         }

         this.n();
         return;
      }
   }

   private void n() {
      // $FF: Couldn't be decompiled
   }

   private void o() {
      if(!this.b() && this.b != null) {
         eo.a(3, a, "Downloader: finished -- success: " + this.l + " for url: " + this.c);
         this.b.a(this);
      }
   }

   private boolean p() {
      return this.f != null;
   }

   private boolean q() {
      return this.f != null && this.h && this.i > 1;
   }

   public void a(as$a var1) {
      this.b = var1;
   }

   public void a(com.flurry.sdk.aw var1) {
      this.f = var1;
   }

   public void a(String var1) {
      this.c = var1;
   }

   public boolean a() {
      return this.l;
   }

   public boolean b() {
      return this.m;
   }

   public long c() {
      return this.g;
   }

   public void d() {
      do.a().c(new ff() {
         public void a() {
            if(as.this.p()) {
               as.this.k();
            } else {
               as.this.j();
            }
         }
      });
   }

   public void e() {
      this.m = true;
      em.a().a(this);
   }

   protected abstract OutputStream f();

   protected abstract void g();

   protected abstract void h();
}
