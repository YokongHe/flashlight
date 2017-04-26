package com.flurry.sdk;

import android.content.Context;
import android.os.Environment;
import android.os.Build.VERSION;
import com.flurry.sdk.do;
import com.flurry.sdk.eo;
import java.io.File;

public final class fd {
   private static String a = fd.class.getSimpleName();

   public static File a(boolean var0) {
      File var2 = null;
      Context var3 = do.a().b();
      File var1 = var2;
      if(var0) {
         var1 = var2;
         if("mounted".equals(Environment.getExternalStorageState())) {
            label17: {
               if(VERSION.SDK_INT < 19) {
                  var1 = var2;
                  if(var3.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                     break label17;
                  }
               }

               var1 = var3.getExternalFilesDir((String)null);
            }
         }
      }

      var2 = var1;
      if(var1 == null) {
         var2 = var3.getFilesDir();
      }

      return var2;
   }

   @Deprecated
   public static void a(File param0, String param1) {
      // $FF: Couldn't be decompiled
   }

   public static boolean a(File var0) {
      if(var0 != null && var0.getAbsoluteFile() != null) {
         var0 = var0.getParentFile();
         if(var0 == null) {
            return true;
         } else if(!var0.mkdirs() && !var0.isDirectory()) {
            eo.a(6, a, "Unable to create persistent dir: " + var0);
            return false;
         } else {
            return true;
         }
      } else {
         return false;
      }
   }

   public static File b(boolean var0) {
      Context var3 = do.a().b();
      File var2 = null;
      File var1 = var2;
      if(var0) {
         var1 = var2;
         if("mounted".equals(Environment.getExternalStorageState())) {
            label17: {
               if(VERSION.SDK_INT < 19) {
                  var1 = var2;
                  if(var3.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                     break label17;
                  }
               }

               var1 = var3.getExternalCacheDir();
            }
         }
      }

      var2 = var1;
      if(var1 == null) {
         var2 = var3.getCacheDir();
      }

      return var2;
   }

   public static boolean b(File var0) {
      if(var0 != null && var0.isDirectory()) {
         String[] var2 = var0.list();

         for(int var1 = 0; var1 < var2.length; ++var1) {
            if(!b(new File(var0, var2[var1]))) {
               return false;
            }
         }
      }

      return var0.delete();
   }

   @Deprecated
   public static String c(File param0) {
      // $FF: Couldn't be decompiled
   }
}
