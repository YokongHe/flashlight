package android.support.v4.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.app.ActionBarDrawerToggleHoneycomb$SetIndicatorInfo;
import android.util.Log;

class ActionBarDrawerToggleHoneycomb {
   private static final String TAG = "ActionBarDrawerToggleHoneycomb";
   private static final int[] THEME_ATTRS = new int[]{16843531};

   public static Drawable getThemeUpIndicator(Activity var0) {
      TypedArray var2 = var0.obtainStyledAttributes(THEME_ATTRS);
      Drawable var1 = var2.getDrawable(0);
      var2.recycle();
      return var1;
   }

   public static Object setActionBarDescription(Object var0, Activity var1, int var2) {
      if(var0 == null) {
         var0 = new ActionBarDrawerToggleHoneycomb$SetIndicatorInfo(var1);
      }

      ActionBarDrawerToggleHoneycomb$SetIndicatorInfo var3 = (ActionBarDrawerToggleHoneycomb$SetIndicatorInfo)var0;
      if(var3.setHomeAsUpIndicator != null) {
         try {
            ActionBar var5 = var1.getActionBar();
            var3.setHomeActionContentDescription.invoke(var5, new Object[]{Integer.valueOf(var2)});
            if(VERSION.SDK_INT <= 19) {
               var5.setSubtitle(var5.getSubtitle());
            }
         } catch (Exception var4) {
            Log.w("ActionBarDrawerToggleHoneycomb", "Couldn\'t set content description via JB-MR2 API", var4);
            return var0;
         }
      }

      return var0;
   }

   public static Object setActionBarUpIndicator(Object var0, Activity var1, Drawable var2, int var3) {
      if(var0 == null) {
         var0 = new ActionBarDrawerToggleHoneycomb$SetIndicatorInfo(var1);
      }

      ActionBarDrawerToggleHoneycomb$SetIndicatorInfo var4 = (ActionBarDrawerToggleHoneycomb$SetIndicatorInfo)var0;
      if(var4.setHomeAsUpIndicator != null) {
         try {
            ActionBar var6 = var1.getActionBar();
            var4.setHomeAsUpIndicator.invoke(var6, new Object[]{var2});
            var4.setHomeActionContentDescription.invoke(var6, new Object[]{Integer.valueOf(var3)});
            return var0;
         } catch (Exception var5) {
            Log.w("ActionBarDrawerToggleHoneycomb", "Couldn\'t set home-as-up indicator via JB-MR2 API", var5);
            return var0;
         }
      } else if(var4.upIndicatorView != null) {
         var4.upIndicatorView.setImageDrawable(var2);
         return var0;
      } else {
         Log.w("ActionBarDrawerToggleHoneycomb", "Couldn\'t set home-as-up indicator");
         return var0;
      }
   }
}
