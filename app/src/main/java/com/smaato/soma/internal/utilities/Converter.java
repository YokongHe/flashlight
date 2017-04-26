package com.smaato.soma.internal.utilities;

import android.content.Context;
import android.util.TypedValue;
import com.smaato.soma.debug.DebugCategory;
import com.smaato.soma.debug.Debugger;
import com.smaato.soma.debug.LogMessage;
import com.smaato.soma.exception.PixelToDpFailed;
import com.smaato.soma.exception.UnableToCalculateMinimalHeight;
import java.security.MessageDigest;

public class Converter {
   private static final String CHAR_SET = "iso-8859-1";
   private static final String SHA1_ALGORITHM = "SHA-1";
   private static final String TAG = "SOMA Converter";
   private static Converter instance;

   private String convertToHex(byte[] param1) {
      // $FF: Couldn't be decompiled
   }

   public static Converter getInstance() {
      if(instance == null) {
         instance = new Converter();
      }

      return instance;
   }

   public String SHA1(String var1) {
      try {
         MessageDigest var2 = MessageDigest.getInstance("SHA-1");
         var2.update(var1.getBytes("iso-8859-1"), 0, var1.length());
         var1 = this.convertToHex(var2.digest());
         return var1;
      } catch (Throwable var3) {
         Debugger.showLog(new LogMessage("SOMA Converter", "Error generating generating SHA-1: ", 1, DebugCategory.EXCEPTION, var3));
         return null;
      }
   }

   public int getMinimalHeight(Context var1) {
      float var2;
      try {
         var2 = TypedValue.applyDimension(1, 50.0F, var1.getResources().getDisplayMetrics());
      } catch (RuntimeException var3) {
         throw var3;
      } catch (Exception var4) {
         throw new UnableToCalculateMinimalHeight(var4);
      }

      return (int)var2;
   }

   public int pixelToDp(Context var1, int var2) {
      float var3 = (float)var2;

      try {
         var3 = TypedValue.applyDimension(1, var3, var1.getResources().getDisplayMetrics());
      } catch (RuntimeException var4) {
         throw var4;
      } catch (Exception var5) {
         throw new PixelToDpFailed(var5);
      }

      return (int)var3;
   }
}
