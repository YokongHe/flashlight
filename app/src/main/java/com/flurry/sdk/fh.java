package com.flurry.sdk;

import com.flurry.sdk.fh$a;
import com.flurry.sdk.fh$b;
import com.flurry.sdk.fh$c;
import com.flurry.sdk.fj;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class fh implements Closeable {
   static final Pattern a = Pattern.compile("[a-z0-9_-]{1,64}");
   private static final OutputStream p = new OutputStream() {
      public final void write(int var1) {
      }
   };
   final ThreadPoolExecutor b;
   private final File c;
   private final File d;
   private final File e;
   private final File f;
   private final int g;
   private long h;
   private final int i;
   private long j = 0L;
   private Writer k;
   private final LinkedHashMap l = new LinkedHashMap(0, 0.75F, true);
   private int m;
   private long n = 0L;
   private final Callable o;

   private fh(File var1, int var2, int var3, long var4) {
      this.b = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
      this.o = new Callable() {
         public Void a() {
            fh var1 = fh.this;
            synchronized(var1) {
               if(fh.this.k == null) {
                  return null;
               } else {
                  fh.this.h();
                  if(fh.this.f()) {
                     fh.this.e();
                     fh.this.m = 0;
                  }

                  return null;
               }
            }
         }

         // $FF: synthetic method
         public Object call() {
            return this.a();
         }
      };
      this.c = var1;
      this.g = var2;
      this.d = new File(var1, "journal");
      this.e = new File(var1, "journal.tmp");
      this.f = new File(var1, "journal.bkp");
      this.i = var3;
      this.h = var4;
   }

   private fh$a a(String param1, long param2) {
      // $FF: Couldn't be decompiled
   }

   public static fh a(File var0, int var1, int var2, long var3) {
      if(var3 <= 0L) {
         throw new IllegalArgumentException("maxSize <= 0");
      } else if(var2 <= 0) {
         throw new IllegalArgumentException("valueCount <= 0");
      } else {
         File var5 = new File(var0, "journal.bkp");
         if(var5.exists()) {
            File var6 = new File(var0, "journal");
            if(var6.exists()) {
               var5.delete();
            } else {
               a(var5, var6, false);
            }
         }

         fh var9 = new fh(var0, var1, var2, var3);
         if(var9.d.exists()) {
            try {
               var9.c();
               var9.d();
               var9.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(var9.d, true), fj.a));
               return var9;
            } catch (IOException var7) {
               System.out.println("DiskLruCache " + var0 + " is corrupt: " + var7.getMessage() + ", removing");
               var9.a();
            }
         }

         var0.mkdirs();
         fh var8 = new fh(var0, var1, var2, var3);
         var8.e();
         return var8;
      }
   }

   private void a(fh$a param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static void a(fh var0, fh$a var1, boolean var2) {
      var0.a(var1, var2);
   }

   private static void a(File var0) {
      if(var0.exists() && !var0.delete()) {
         throw new IOException();
      }
   }

   private static void a(File var0, File var1, boolean var2) {
      if(var2) {
         a(var1);
      }

      if(!var0.renameTo(var1)) {
         throw new IOException();
      }
   }

   // $FF: synthetic method
   static OutputStream b() {
      return p;
   }

   private void c() {
      // $FF: Couldn't be decompiled
   }

   private void d() {
      a(this.e);
      Iterator var2 = this.l.values().iterator();

      while(true) {
         while(var2.hasNext()) {
            fh$b var3 = (fh$b)var2.next();
            int var1;
            if(fh$b.a(var3) == null) {
               for(var1 = 0; var1 < this.i; ++var1) {
                  this.j += fh$b.b(var3)[var1];
               }
            } else {
               fh$b.a(var3, (fh$a)null);

               for(var1 = 0; var1 < this.i; ++var1) {
                  a(var3.a(var1));
                  a(var3.b(var1));
               }

               var2.remove();
            }
         }

         return;
      }
   }

   private void d(String var1) {
      int var2 = var1.indexOf(32);
      if(var2 == -1) {
         throw new IOException("unexpected journal line: " + var1);
      } else {
         int var3 = var2 + 1;
         int var4 = var1.indexOf(32, var3);
         String var5;
         if(var4 == -1) {
            var5 = var1.substring(var3);
            if(var2 == 6 && var1.startsWith("REMOVE")) {
               this.l.remove(var5);
               return;
            }
         } else {
            var5 = var1.substring(var3, var4);
         }

         fh$b var7 = (fh$b)this.l.get(var5);
         fh$b var6 = var7;
         if(var7 == null) {
            var6 = new fh$b(this, var5, null);
            this.l.put(var5, var6);
         }

         if(var4 != -1 && var2 == 5 && var1.startsWith("CLEAN")) {
            String[] var8 = var1.substring(var4 + 1).split(" ");
            fh$b.a(var6, true);
            fh$b.a(var6, (fh$a)null);
            fh$b.a(var6, var8);
         } else if(var4 == -1 && var2 == 5 && var1.startsWith("DIRTY")) {
            fh$b.a(var6, new fh$a(this, var6, null));
         } else if(var4 != -1 || var2 != 4 || !var1.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + var1);
         }
      }
   }

   // $FF: synthetic method
   static int e(fh var0) {
      return var0.i;
   }

   private void e() {
      // $FF: Couldn't be decompiled
   }

   private void e(String var1) {
      if(!a.matcher(var1).matches()) {
         throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + var1 + "\"");
      }
   }

   // $FF: synthetic method
   static File f(fh var0) {
      return var0.c;
   }

   private boolean f() {
      return this.m >= 2000 && this.m >= this.l.size();
   }

   private void g() {
      if(this.k == null) {
         throw new IllegalStateException("cache is closed");
      }
   }

   private void h() {
      while(this.j > this.h) {
         this.c((String)((Entry)this.l.entrySet().iterator().next()).getKey());
      }

   }

   public final fh$c a(String param1) {
      // $FF: Couldn't be decompiled
   }

   public final void a() {
      this.close();
      fj.a(this.c);
   }

   public final fh$a b(String var1) {
      return this.a(var1, -1L);
   }

   public final boolean c(String param1) {
      // $FF: Couldn't be decompiled
   }

   public final void close() {
      // $FF: Couldn't be decompiled
   }
}
