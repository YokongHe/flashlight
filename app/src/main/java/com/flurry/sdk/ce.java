package com.flurry.sdk;

import android.text.TextUtils;
import com.flurry.sdk.fd;
import com.flurry.sdk.fe;
import java.io.File;

public class ce {
   public static File a(String var0) {
      return new File(fd.b(true).getPath() + File.separator + ".fcaches" + File.separator + var0);
   }

   public static File b(String var0) {
      return new File(fd.a(true).getPath() + File.separator + ".fcaches" + File.separator + var0);
   }

   public static String c(String var0) {
      return TextUtils.isEmpty(var0)?null:String.format("%016x", new Object[]{Long.valueOf(fe.g(var0))}).trim();
   }
}
