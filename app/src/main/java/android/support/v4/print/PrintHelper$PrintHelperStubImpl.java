package android.support.v4.print;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.print.PrintHelper$PrintHelperVersionImpl;

final class PrintHelper$PrintHelperStubImpl implements PrintHelper$PrintHelperVersionImpl {
   int mColorMode;
   int mOrientation;
   int mScaleMode;

   private PrintHelper$PrintHelperStubImpl() {
      this.mScaleMode = 2;
      this.mColorMode = 2;
      this.mOrientation = 1;
   }

   // $FF: synthetic method
   PrintHelper$PrintHelperStubImpl(Object var1) {
      this();
   }

   public final int getColorMode() {
      return this.mColorMode;
   }

   public final int getOrientation() {
      return this.mOrientation;
   }

   public final int getScaleMode() {
      return this.mScaleMode;
   }

   public final void printBitmap(String var1, Bitmap var2) {
   }

   public final void printBitmap(String var1, Uri var2) {
   }

   public final void setColorMode(int var1) {
      this.mColorMode = var1;
   }

   public final void setOrientation(int var1) {
      this.mOrientation = var1;
   }

   public final void setScaleMode(int var1) {
      this.mScaleMode = var1;
   }
}
