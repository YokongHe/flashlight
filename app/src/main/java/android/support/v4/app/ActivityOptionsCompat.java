package android.support.v4.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v4.app.ActivityOptionsCompat$ActivityOptionsImplJB;
import android.support.v4.app.ActivityOptionsCompatJB;
import android.view.View;

public class ActivityOptionsCompat {
   public static ActivityOptionsCompat makeCustomAnimation(Context var0, int var1, int var2) {
      return (ActivityOptionsCompat)(VERSION.SDK_INT >= 16?new ActivityOptionsCompat$ActivityOptionsImplJB(ActivityOptionsCompatJB.makeCustomAnimation(var0, var1, var2)):new ActivityOptionsCompat());
   }

   public static ActivityOptionsCompat makeScaleUpAnimation(View var0, int var1, int var2, int var3, int var4) {
      return (ActivityOptionsCompat)(VERSION.SDK_INT >= 16?new ActivityOptionsCompat$ActivityOptionsImplJB(ActivityOptionsCompatJB.makeScaleUpAnimation(var0, var1, var2, var3, var4)):new ActivityOptionsCompat());
   }

   public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View var0, Bitmap var1, int var2, int var3) {
      return (ActivityOptionsCompat)(VERSION.SDK_INT >= 16?new ActivityOptionsCompat$ActivityOptionsImplJB(ActivityOptionsCompatJB.makeThumbnailScaleUpAnimation(var0, var1, var2, var3)):new ActivityOptionsCompat());
   }

   public Bundle toBundle() {
      return null;
   }

   public void update(ActivityOptionsCompat var1) {
   }
}
