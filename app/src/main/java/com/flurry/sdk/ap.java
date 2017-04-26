package com.flurry.sdk;

import android.text.TextUtils;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.sdk.ao$a;
import com.flurry.sdk.ap$a;
import com.flurry.sdk.ap$b;
import com.flurry.sdk.ap$c;
import com.flurry.sdk.dt;
import com.flurry.sdk.eo;
import com.flurry.sdk.fd;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ap implements ao$a {
   private static final String b = com.flurry.sdk.ap.class.getSimpleName();
   private static final String[] c = new String[0];
   private static com.flurry.sdk.ap d;
   com.flurry.sdk.ao a;
   private long e;
   private long f;
   private boolean g;
   private boolean h;
   private final dt i = new dt();

   private ap$a a(ap$a var1, com.flurry.sdk.ar var2) {
      ap$a var3;
      if(var1 == null) {
         var3 = ap$a.a;
      } else {
         var3 = var1;
         if(var2 != null) {
            if(com.flurry.sdk.ar.g.equals(var2)) {
               return ap$a.f;
            }

            if(com.flurry.sdk.ar.f.equals(var2)) {
               var3 = var1;
               if(!var1.equals(ap$a.f)) {
                  return ap$a.e;
               }
            } else if(!com.flurry.sdk.ar.a.equals(var2) && !com.flurry.sdk.ar.e.equals(var2)) {
               if(!com.flurry.sdk.ar.b.equals(var2) && !com.flurry.sdk.ar.c.equals(var2)) {
                  var3 = var1;
                  if(com.flurry.sdk.ar.d.equals(var2)) {
                     var3 = var1;
                     if(ap$a.a.equals(var1)) {
                        return ap$a.d;
                     }
                  }
               } else {
                  if(!ap$a.a.equals(var1)) {
                     var3 = var1;
                     if(!ap$a.d.equals(var1)) {
                        return var3;
                     }
                  }

                  return ap$a.b;
               }
            } else {
               var3 = var1;
               if(!var1.equals(ap$a.f)) {
                  var3 = var1;
                  if(!var1.equals(ap$a.e)) {
                     return ap$a.c;
                  }
               }
            }
         }
      }

      return var3;
   }

   public static com.flurry.sdk.ap a() {
      synchronized(com.flurry.sdk.ap.class){}

      com.flurry.sdk.ap var0;
      try {
         if(d == null) {
            d = new com.flurry.sdk.ap();
         }

         var0 = d;
      } finally {
         ;
      }

      return var0;
   }

   private String a(AdFrame var1, String var2) {
      if(var1 != null && !TextUtils.isEmpty(var2) && var1.d() != null) {
         String var3 = this.a(var1.d().toString(), var2);
         if(!TextUtils.isEmpty(var3)) {
            return var3;
         }
      }

      return null;
   }

   private String a(String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean a(AdFrame var1) {
      if(var1 != null) {
         if(FlurryAdModule.getInstance().b(var1.g().toString()) != null) {
            return true;
         }

         if(var1.b().intValue() == 3) {
            return true;
         }
      }

      return false;
   }

   private boolean a(String var1, long var2) {
      if(TextUtils.isEmpty(var1)) {
         return false;
      } else {
         com.flurry.sdk.ay var5 = com.flurry.sdk.ay.a;
         String var6 = URLConnection.guessContentTypeFromName(var1);
         com.flurry.sdk.ay var4 = var5;
         if(var6 != null) {
            if(var6.startsWith("video")) {
               eo.a(3, b, "Precaching: asset is a video: " + var1);
               var4 = com.flurry.sdk.ay.b;
            } else if(var6.startsWith("image")) {
               eo.a(3, b, "Precaching: asset is an image: " + var1);
               var4 = com.flurry.sdk.ay.c;
            } else if(var6.startsWith("text")) {
               eo.a(3, b, "Precaching: asset is text: " + var1);
               var4 = com.flurry.sdk.ay.d;
            } else {
               eo.a(5, b, "Precaching: could not identify media type for asset: " + var1);
               var4 = var5;
            }
         }

         return this.a.a(var1, var4, var2);
      }
   }

   private boolean a(List var1, String var2) {
      if(var1 == null) {
         return false;
      } else if(TextUtils.isEmpty(var2)) {
         return false;
      } else {
         Iterator var3 = var1.iterator();

         do {
            if(!var3.hasNext()) {
               return false;
            }
         } while(!var2.equals(((CharSequence)var3.next()).toString()));

         return true;
      }
   }

   private String b(AdFrame var1) {
      com.flurry.sdk.ci var2 = FlurryAdModule.getInstance().b(var1.g().toString());
      return var2 != null?var2.f():null;
   }

   private String c(AdFrame var1) {
      return var1 != null && var1.c() != null && var1.b().intValue() == 3?var1.c().toString():null;
   }

   private boolean c(String var1) {
      if(this.h && !TextUtils.isEmpty(var1)) {
         eo.a(3, b, "Precaching: Saving local asset for adUnit.");
         if(com.flurry.sdk.ar.d.equals(this.a.b(var1))) {
            return this.e(var1);
         }
      }

      return false;
   }

   private void d(String var1) {
      if(!TextUtils.isEmpty(var1)) {
         this.a.b(var1);
      }
   }

   private boolean e(String param1) {
      // $FF: Couldn't be decompiled
   }

   private String f(String var1) {
      return com.flurry.sdk.ce.c(var1);
   }

   private boolean g(AdUnit var1) {
      if(var1 == null) {
         return false;
      } else {
         Iterator var2 = var1.d().iterator();

         do {
            if(!var2.hasNext()) {
               return false;
            }
         } while(!this.a((AdFrame)var2.next()));

         return true;
      }
   }

   private void h(AdUnit var1) {
      if(this.h && var1 != null) {
         Iterator var8 = var1.d().iterator();

         while(true) {
            while(true) {
               AdFrame var4;
               ap$c var5;
               do {
                  do {
                     if(!var8.hasNext()) {
                        return;
                     }

                     var4 = (AdFrame)var8.next();
                     var5 = ap$c.a(var4.h().intValue());
                  } while(ap$c.a.equals(var5));
               } while(!this.a(var4));

               List var6 = var4.j();
               List var10 = var4.k();
               if(var6 != null && var6.size() > 0) {
                  Iterator var9 = var6.iterator();

                  while(var9.hasNext()) {
                     this.d(((CharSequence)var9.next()).toString());
                  }
               } else {
                  String var11 = this.b(var4);
                  if(!TextUtils.isEmpty(var11) && !this.a(var10, var11)) {
                     this.d(var11);
                  }

                  var11 = this.c(var4);
                  if(!TextUtils.isEmpty(var11) && !this.a(var10, var11)) {
                     this.d(var11);
                  }

                  String[] var12 = c;
                  int var3 = var12.length;

                  for(int var2 = 0; var2 < var3; ++var2) {
                     String var7 = this.a(var4, var12[var2]);
                     if(!TextUtils.isEmpty(var7) && !this.a(var10, var7)) {
                        this.d(var7);
                     }
                  }
               }
            }
         }
      }
   }

   private List i() {
      dt var1 = this.i;
      synchronized(var1) {
         List var2 = this.i.a();
         return var2;
      }
   }

   private void j() {
      try {
         File var1 = com.flurry.sdk.ce.b("fileStreamCacheDownloaderTmp");
         eo.a(3, b, "Precaching: Cleaning temp asset directory: " + var1);
         fd.b(var1);
      } catch (Exception var2) {
         eo.a(6, b, "Precaching: Error cleaning temp asset directory: " + var2.getMessage(), var2);
      }
   }

   public File a(String var1) {
      if(this.h && !TextUtils.isEmpty(var1)) {
         File var2 = new File(com.flurry.sdk.ce.b("fileStreamCacheDownloaderTmp"), this.f(var1));
         if(var2.exists()) {
            return var2;
         }
      }

      return null;
   }

   public void a(long param1, long param3) {
      // $FF: Couldn't be decompiled
   }

   public void a(ap$b var1) {
      dt var2 = this.i;
      synchronized(var2) {
         this.i.a(var1);
      }
   }

   public void a(InputStream var1) {
      if(this.g) {
         this.a.a(var1);
      }
   }

   public void a(OutputStream var1) {
      if(this.g) {
         this.a.a(var1);
      }
   }

   public void a(String param1, com.flurry.sdk.ar param2) {
      // $FF: Couldn't be decompiled
   }

   public void a(String var1, List var2) {
      if(this.h && var2 != null) {
         eo.a(3, b, "Handling ad response");
         if(!TextUtils.isEmpty(var1)) {
            this.b(var1, var2);
            return;
         }

         int var3;
         if(this.f == 0L) {
            var3 = 5;
         } else {
            var3 = (int)(this.e / this.f);
         }

         Iterator var5 = var2.iterator();
         int var4 = 0;

         while(var5.hasNext()) {
            var4 += this.e((AdUnit)var5.next());
            if(var4 >= var3) {
               break;
            }
         }
      }

   }

   public boolean a(AdUnit var1) {
      if(!this.h) {
         return false;
      } else if(var1 == null) {
         return false;
      } else if(!this.g(var1)) {
         return false;
      } else {
         Iterator var3 = var1.d().iterator();

         ap$c var2;
         do {
            if(!var3.hasNext()) {
               return false;
            }

            var2 = ap$c.a(((AdFrame)var3.next()).h().intValue());
         } while(!ap$c.b.equals(var2) && !ap$c.c.equals(var2));

         return true;
      }
   }

   public void b(String var1) {
      if(this.h) {
         this.a.a(var1);
      }
   }

   public void b(String var1, List var2) {
      if(this.h && var2 != null && !TextUtils.isEmpty(var1)) {
         int var3;
         for(var3 = var2.size() - 1; var3 >= 0; --var3) {
            this.h((AdUnit)var2.get(var3));
         }

         Iterator var5 = var2.iterator();
         var3 = 0;

         while(var5.hasNext()) {
            byte var4;
            if(this.e((AdUnit)var5.next()) > 0) {
               var4 = 1;
            } else {
               var4 = 0;
            }

            var3 += var4;
            if(var3 >= 2) {
               break;
            }
         }
      }

   }

   public boolean b() {
      return this.g;
   }

   public boolean b(AdUnit var1) {
      if(!this.h) {
         return false;
      } else if(var1 == null) {
         return false;
      } else if(!this.g(var1)) {
         return false;
      } else {
         Iterator var2 = var1.d().iterator();

         ap$c var3;
         do {
            if(!var2.hasNext()) {
               return false;
            }

            var3 = ap$c.a(((AdFrame)var2.next()).h().intValue());
         } while(!this.g(var1) || !ap$c.b.equals(var3));

         return true;
      }
   }

   public boolean b(ap$b var1) {
      dt var3 = this.i;
      synchronized(var3) {
         boolean var2 = this.i.b(var1);
         return var2;
      }
   }

   public ap$a c(AdUnit var1) {
      ap$a var4;
      if(!this.h) {
         var4 = ap$a.f;
         return var4;
      } else if(var1 == null) {
         return ap$a.d;
      } else if(!this.g(var1)) {
         return ap$a.d;
      } else {
         var4 = ap$a.a;
         Iterator var5 = var1.d().iterator();
         ap$a var9 = var4;

         while(true) {
            AdFrame var6;
            do {
               var4 = var9;
               if(!var5.hasNext()) {
                  return var4;
               }

               var6 = (AdFrame)var5.next();
            } while(!this.a(var6));

            String var7 = this.b(var6);
            var4 = var9;
            if(!TextUtils.isEmpty(var7)) {
               var4 = this.a(var9, this.a.b(var7));
            }

            var7 = this.c(var6);
            var9 = var4;
            if(!TextUtils.isEmpty(var7)) {
               var9 = this.a(var4, this.a.b(var7));
            }

            String[] var10 = c;
            int var3 = var10.length;
            int var2 = 0;
            var4 = var9;

            while(true) {
               var9 = var4;
               if(var2 >= var3) {
                  break;
               }

               String var8 = this.a(var6, var10[var2]);
               var9 = var4;
               if(!TextUtils.isEmpty(var8)) {
                  var9 = this.a(var4, this.a.b(var8));
               }

               ++var2;
               var4 = var9;
            }
         }
      }
   }

   public void c() {
      // $FF: Couldn't be decompiled
   }

   public void d() {
      // $FF: Couldn't be decompiled
   }

   public boolean d(AdUnit var1) {
      if(!this.h) {
         return false;
      } else if(var1 == null) {
         return false;
      } else {
         eo.a(3, b, "Precaching: Saving local assets for adUnit.");
         this.j();
         Iterator var7 = var1.d().iterator();

         while(true) {
            AdFrame var4;
            do {
               if(!var7.hasNext()) {
                  return true;
               }

               var4 = (AdFrame)var7.next();
            } while(!this.a(var4));

            String var5 = this.b(var4);
            if(!TextUtils.isEmpty(var5) && !this.c(var5)) {
               return false;
            }

            var5 = this.c(var4);
            if(!TextUtils.isEmpty(var5) && !this.c(var5)) {
               return false;
            }

            String[] var8 = c;
            int var3 = var8.length;

            for(int var2 = 0; var2 < var3; ++var2) {
               String var6 = this.a(var4, var8[var2]);
               if(!TextUtils.isEmpty(var6) && !this.c(var6)) {
                  return false;
               }
            }
         }
      }
   }

   public int e(AdUnit var1) {
      if(this.h && var1 != null) {
         Iterator var12 = var1.d().iterator();
         int var2 = 0;

         while(true) {
            while(true) {
               AdFrame var8;
               ap$c var9;
               do {
                  do {
                     if(!var12.hasNext()) {
                        return var2;
                     }

                     var8 = (AdFrame)var12.next();
                     var9 = ap$c.a(var8.h().intValue());
                  } while(ap$c.a.equals(var9));
               } while(!this.a(var8));

               List var10 = var8.j();
               List var14 = var8.k();
               long var6 = var8.i().longValue();
               int var3;
               if(var10 != null && var10.size() > 0) {
                  Iterator var13 = var10.iterator();
                  var3 = var2;

                  while(true) {
                     var2 = var3;
                     if(!var13.hasNext()) {
                        break;
                     }

                     if(this.a(((CharSequence)var13.next()).toString(), var6)) {
                        ++var3;
                     }
                  }
               } else {
                  String var15 = this.b(var8);
                  int var4 = var2;
                  if(!TextUtils.isEmpty(var15)) {
                     var4 = var2;
                     if(!this.a(var14, var15)) {
                        var4 = var2;
                        if(this.a(var15, var6)) {
                           var4 = var2 + 1;
                        }
                     }
                  }

                  var15 = this.c(var8);
                  var3 = var4;
                  if(!TextUtils.isEmpty(var15)) {
                     var3 = var4;
                     if(!this.a(var14, var15)) {
                        var3 = var4;
                        if(this.a(var15, var6)) {
                           var3 = var4 + 1;
                        }
                     }
                  }

                  String[] var16 = c;
                  int var5 = var16.length;
                  var4 = 0;

                  while(true) {
                     var2 = var3;
                     if(var4 >= var5) {
                        break;
                     }

                     String var11 = this.a(var8, var16[var4]);
                     var2 = var3;
                     if(!TextUtils.isEmpty(var11)) {
                        var2 = var3;
                        if(!this.a(var14, var11)) {
                           var2 = var3;
                           if(this.a(var11, var6)) {
                              var2 = var3 + 1;
                           }
                        }
                     }

                     ++var4;
                     var3 = var2;
                  }
               }
            }
         }
      } else {
         return 0;
      }
   }

   public void e() {
      // $FF: Couldn't be decompiled
   }

   public void f() {
      // $FF: Couldn't be decompiled
   }

   public void f(AdUnit var1) {
      if(this.h && var1 != null) {
         Iterator var8 = var1.d().iterator();

         while(true) {
            while(true) {
               AdFrame var4;
               ap$c var5;
               do {
                  do {
                     if(!var8.hasNext()) {
                        return;
                     }

                     var4 = (AdFrame)var8.next();
                     var5 = ap$c.a(var4.h().intValue());
                  } while(ap$c.a.equals(var5));
               } while(!this.a(var4));

               List var6 = var4.j();
               List var10 = var4.k();
               var4.i().longValue();
               if(var6 != null && var6.size() > 0) {
                  Iterator var9 = var6.iterator();

                  while(var9.hasNext()) {
                     this.b(((CharSequence)var9.next()).toString());
                  }
               } else {
                  String var11 = this.b(var4);
                  if(!TextUtils.isEmpty(var11) && !this.a(var10, var11)) {
                     this.b(var11.toString());
                  }

                  var11 = this.c(var4);
                  if(!TextUtils.isEmpty(var11) && !this.a(var10, var11)) {
                     this.b(var11.toString());
                  }

                  String[] var12 = c;
                  int var3 = var12.length;

                  for(int var2 = 0; var2 < var3; ++var2) {
                     String var7 = this.a(var4, var12[var2]);
                     if(!TextUtils.isEmpty(var7) && !this.a(var10, var7)) {
                        this.b(var7.toString());
                     }
                  }
               }
            }
         }
      }
   }

   public void g() {
      if(this.h) {
         this.a.e();
      }
   }

   public List h() {
      return !this.h?Collections.emptyList():this.a.h();
   }
}
