package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.internal.di;
import com.google.android.gms.internal.dj;
import com.google.android.gms.internal.dk;
import com.google.android.gms.internal.dl;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public abstract class cU extends com.google.android.gms.internal.cT {
   static boolean d = false;
   private static Method e;
   private static Method f;
   private static Method g;
   private static Method h;
   private static Method i;
   private static Method j;
   private static String k;
   private static long l = 0L;
   private static dk m;

   protected cU(Context var1, di var2, dj var3) {
      super(var1, var2, var3);
   }

   private static String a() {
      if(k == null) {
         throw new com.google.android.gms.internal.cV();
      } else {
         return k;
      }
   }

   private static String a(Context param0, di param1) {
      // $FF: Couldn't be decompiled
   }

   private static String a(byte[] var0, String var1) {
      try {
         String var4 = new String(m.a(var0, var1), "UTF-8");
         return var4;
      } catch (dl var2) {
         throw new com.google.android.gms.internal.cV(var2);
      } catch (UnsupportedEncodingException var3) {
         throw new com.google.android.gms.internal.cV(var3);
      }
   }

   private static ArrayList a(MotionEvent var0, DisplayMetrics var1) {
      if(h != null && var0 != null) {
         try {
            ArrayList var4 = (ArrayList)h.invoke((Object)null, new Object[]{var0, var1});
            return var4;
         } catch (IllegalAccessException var2) {
            throw new com.google.android.gms.internal.cV(var2);
         } catch (InvocationTargetException var3) {
            throw new com.google.android.gms.internal.cV(var3);
         }
      } else {
         throw new com.google.android.gms.internal.cV();
      }
   }

   protected static void a(String param0, Context param1, di param2) {
      // $FF: Couldn't be decompiled
   }

   private static Long b() {
      if(e == null) {
         throw new com.google.android.gms.internal.cV();
      } else {
         try {
            Long var0 = (Long)e.invoke((Object)null, new Object[0]);
            return var0;
         } catch (IllegalAccessException var1) {
            throw new com.google.android.gms.internal.cV(var1);
         } catch (InvocationTargetException var2) {
            throw new com.google.android.gms.internal.cV(var2);
         }
      }
   }

   private static String b(Context param0, di param1) {
      // $FF: Couldn't be decompiled
   }

   private static String c() {
      if(f == null) {
         throw new com.google.android.gms.internal.cV();
      } else {
         try {
            String var0 = (String)f.invoke((Object)null, new Object[0]);
            return var0;
         } catch (IllegalAccessException var1) {
            throw new com.google.android.gms.internal.cV(var1);
         } catch (InvocationTargetException var2) {
            throw new com.google.android.gms.internal.cV(var2);
         }
      }
   }

   private static String d(Context param0) {
      // $FF: Couldn't be decompiled
   }

   protected void b(Context var1) {
      try {
         try {
            this.a(1, c());
         } catch (com.google.android.gms.internal.cV var6) {
            ;
         }

         try {
            this.a(2, a());
         } catch (com.google.android.gms.internal.cV var5) {
            ;
         }

         try {
            this.a(25, b().longValue());
         } catch (com.google.android.gms.internal.cV var4) {
            ;
         }

         try {
            this.a(24, d(var1));
         } catch (com.google.android.gms.internal.cV var3) {
            ;
         }
      } catch (IOException var7) {
         ;
      }
   }

   protected final void c(Context var1) {
      try {
         try {
            this.a(2, a());
         } catch (com.google.android.gms.internal.cV var10) {
            ;
         }

         try {
            this.a(1, c());
         } catch (com.google.android.gms.internal.cV var9) {
            ;
         }

         try {
            long var2 = b().longValue();
            this.a(25, var2);
            if(l != 0L) {
               this.a(17, var2 - l);
               this.a(23, l);
            }
         } catch (com.google.android.gms.internal.cV var8) {
            ;
         }

         try {
            ArrayList var4 = a(this.a, this.b);
            this.a(14, ((Long)var4.get(0)).longValue());
            this.a(15, ((Long)var4.get(1)).longValue());
            if(var4.size() >= 3) {
               this.a(16, ((Long)var4.get(2)).longValue());
            }
         } catch (com.google.android.gms.internal.cV var7) {
            ;
         }

         try {
            this.a(27, a(var1, this.c));
         } catch (com.google.android.gms.internal.cV var6) {
            ;
         }

         try {
            this.a(29, b(var1, this.c));
         } catch (com.google.android.gms.internal.cV var5) {
            ;
         }
      } catch (IOException var11) {
         ;
      }
   }
}
