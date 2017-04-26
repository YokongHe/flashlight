package android.support.v4.text;

import android.support.v4.text.TextDirectionHeuristicsCompat;
import android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionAlgorithm;

class TextDirectionHeuristicsCompat$AnyStrong implements TextDirectionHeuristicsCompat$TextDirectionAlgorithm {
   public static final TextDirectionHeuristicsCompat$AnyStrong INSTANCE_LTR = new TextDirectionHeuristicsCompat$AnyStrong(false);
   public static final TextDirectionHeuristicsCompat$AnyStrong INSTANCE_RTL = new TextDirectionHeuristicsCompat$AnyStrong(true);
   private final boolean mLookForRtl;

   private TextDirectionHeuristicsCompat$AnyStrong(boolean var1) {
      this.mLookForRtl = var1;
   }

   public int checkRtl(CharSequence var1, int var2, int var3) {
      byte var6 = 1;
      boolean var5 = false;
      int var4 = var2;

      while(true) {
         int var7 = var4;
         byte var8;
         if(var4 >= var2 + var3) {
            if(!var5) {
               return 2;
            }

            var8 = var6;
            if(!this.mLookForRtl) {
               return 0;
            }

            return var8;
         }

         boolean var9;
         switch(TextDirectionHeuristicsCompat.access$200(Character.getDirectionality(var1.charAt(var4)))) {
         case 0:
            if(this.mLookForRtl) {
               var8 = 0;
               return var8;
            }

            var9 = true;
            break;
         case 1:
            var8 = var6;
            if(!this.mLookForRtl) {
               return var8;
            }

            var9 = true;
            break;
         default:
            var9 = var5;
         }

         ++var7;
         var5 = var9;
         var4 = var7;
      }
   }
}
