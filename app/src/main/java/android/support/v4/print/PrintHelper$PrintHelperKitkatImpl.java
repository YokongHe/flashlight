package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.print.PrintHelper$PrintHelperVersionImpl;
import android.support.v4.print.PrintHelperKitkat;

final class PrintHelper$PrintHelperKitkatImpl implements PrintHelper$PrintHelperVersionImpl {
   private final PrintHelperKitkat mPrintHelper;

   PrintHelper$PrintHelperKitkatImpl(Context var1) {
      this.mPrintHelper = new PrintHelperKitkat(var1);
   }

   public final int getColorMode() {
      return this.mPrintHelper.getColorMode();
   }

   public final int getOrientation() {
      return this.mPrintHelper.getOrientation();
   }

   public final int getScaleMode() {
      return this.mPrintHelper.getScaleMode();
   }

   public final void printBitmap(String var1, Bitmap var2) {
      this.mPrintHelper.printBitmap(var1, var2);
   }

   public final void printBitmap(String var1, Uri var2) {
      this.mPrintHelper.printBitmap(var1, var2);
   }

   public final void setColorMode(int var1) {
      this.mPrintHelper.setColorMode(var1);
   }

   public final void setOrientation(int var1) {
      this.mPrintHelper.setOrientation(var1);
   }

   public final void setScaleMode(int var1) {
      this.mPrintHelper.setScaleMode(var1);
   }
}
