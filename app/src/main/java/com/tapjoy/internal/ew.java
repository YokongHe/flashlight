package com.tapjoy.internal;

import android.os.StatFs;
import com.tapjoy.internal.fh;
import java.lang.reflect.Method;

class ew extends fh {
   private static final Method a = a(StatFs.class, "getBlockSize", new Class[0]);
   private static final Method b = a(StatFs.class, "getBlockSizeLong", new Class[0]);
   private static final Method c = a(StatFs.class, "getAvailableBlocks", new Class[0]);
   private static final Method d = a(StatFs.class, "getAvailableBlocksLong", new Class[0]);
   private static final Method e = a(StatFs.class, "getBlockCount", new Class[0]);
   private static final Method f = a(StatFs.class, "getBlockCountLong", new Class[0]);
   private static final String g = ew.class.getName();
   private final StatFs h;

   public ew(String var1) {
      this.h = new StatFs(var1);
   }

   public final long a() {
      if(f != null) {
         Long var1 = (Long)a(this.h, f, new Object[0]);
         if(var1 != null) {
            return var1.longValue();
         }
      }

      if(e != null) {
         Integer var2 = (Integer)a(this.h, e, new Object[0]);
         if(var2 != null) {
            return (long)var2.intValue();
         }
      }

      return 0L;
   }

   public final long b() {
      if(b != null) {
         Long var1 = (Long)a(this.h, b, new Object[0]);
         if(var1 != null) {
            return var1.longValue();
         }
      }

      if(a != null) {
         Integer var2 = (Integer)a(this.h, a, new Object[0]);
         if(var2 != null) {
            return (long)var2.intValue();
         }
      }

      return 0L;
   }

   public final long c() {
      if(d != null) {
         Long var1 = (Long)a(this.h, d, new Object[0]);
         if(var1 != null) {
            return var1.longValue();
         }
      }

      if(c != null) {
         Integer var2 = (Integer)a(this.h, c, new Object[0]);
         if(var2 != null) {
            return (long)var2.intValue();
         }
      }

      return 0L;
   }
}
