package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.print.PrintHelper$PrintHelperKitkatImpl;
import android.support.v4.print.PrintHelper$PrintHelperStubImpl;
import android.support.v4.print.PrintHelper$PrintHelperVersionImpl;

public final class PrintHelper {
   public static final int COLOR_MODE_COLOR = 2;
   public static final int COLOR_MODE_MONOCHROME = 1;
   public static final int ORIENTATION_LANDSCAPE = 1;
   public static final int ORIENTATION_PORTRAIT = 2;
   public static final int SCALE_MODE_FILL = 2;
   public static final int SCALE_MODE_FIT = 1;
   PrintHelper$PrintHelperVersionImpl mImpl;

   public PrintHelper(Context var1) {
      if(systemSupportsPrint()) {
         this.mImpl = new PrintHelper$PrintHelperKitkatImpl(var1);
      } else {
         this.mImpl = new PrintHelper$PrintHelperStubImpl(null);
      }
   }

   public static boolean systemSupportsPrint() {
      return VERSION.SDK_INT >= 19;
   }

   public final int getColorMode() {
      return this.mImpl.getColorMode();
   }

   public final int getOrientation() {
      return this.mImpl.getOrientation();
   }

   public final int getScaleMode() {
      return this.mImpl.getScaleMode();
   }

   public final void printBitmap(String var1, Bitmap var2) {
      this.mImpl.printBitmap(var1, var2);
   }

   public final void printBitmap(String var1, Uri var2) {
      this.mImpl.printBitmap(var1, var2);
   }

   public final void setColorMode(int var1) {
      this.mImpl.setColorMode(var1);
   }

   public final void setOrientation(int var1) {
      this.mImpl.setOrientation(var1);
   }

   public final void setScaleMode(int var1) {
      this.mImpl.setScaleMode(var1);
   }
}
