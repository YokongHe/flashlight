package android.support.v4.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.app.ActionBarDrawerToggle$ActionBarDrawerToggleImpl;
import android.support.v4.app.ActionBarDrawerToggle$ActionBarDrawerToggleImplBase;
import android.support.v4.app.ActionBarDrawerToggle$ActionBarDrawerToggleImplHC;
import android.support.v4.app.ActionBarDrawerToggle$ActionBarDrawerToggleImplJellybeanMR2;
import android.support.v4.app.ActionBarDrawerToggle$Delegate;
import android.support.v4.app.ActionBarDrawerToggle$DelegateProvider;
import android.support.v4.app.ActionBarDrawerToggle$SlideDrawable;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout$DrawerListener;
import android.view.MenuItem;
import android.view.View;

public class ActionBarDrawerToggle implements DrawerLayout$DrawerListener {
   private static final int ID_HOME = 16908332;
   private static final ActionBarDrawerToggle$ActionBarDrawerToggleImpl IMPL;
   private static final float TOGGLE_DRAWABLE_OFFSET = 0.33333334F;
   private final Activity mActivity;
   private final ActionBarDrawerToggle$Delegate mActivityImpl;
   private final int mCloseDrawerContentDescRes;
   private Drawable mDrawerImage;
   private final int mDrawerImageResource;
   private boolean mDrawerIndicatorEnabled = true;
   private final DrawerLayout mDrawerLayout;
   private final int mOpenDrawerContentDescRes;
   private Object mSetIndicatorInfo;
   private ActionBarDrawerToggle$SlideDrawable mSlider;
   private Drawable mThemeImage;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 18) {
         IMPL = new ActionBarDrawerToggle$ActionBarDrawerToggleImplJellybeanMR2(null);
      } else if(var0 >= 11) {
         IMPL = new ActionBarDrawerToggle$ActionBarDrawerToggleImplHC(null);
      } else {
         IMPL = new ActionBarDrawerToggle$ActionBarDrawerToggleImplBase(null);
      }
   }

   public ActionBarDrawerToggle(Activity var1, DrawerLayout var2, int var3, int var4, int var5) {
      this.mActivity = var1;
      if(var1 instanceof ActionBarDrawerToggle$DelegateProvider) {
         this.mActivityImpl = ((ActionBarDrawerToggle$DelegateProvider)var1).getDrawerToggleDelegate();
      } else {
         this.mActivityImpl = null;
      }

      this.mDrawerLayout = var2;
      this.mDrawerImageResource = var3;
      this.mOpenDrawerContentDescRes = var4;
      this.mCloseDrawerContentDescRes = var5;
      this.mThemeImage = this.getThemeUpIndicator();
      this.mDrawerImage = var1.getResources().getDrawable(var3);
      this.mSlider = new ActionBarDrawerToggle$SlideDrawable(this, this.mDrawerImage, null);
      this.mSlider.setOffset(0.33333334F);
   }

   // $FF: synthetic method
   static Activity access$400(ActionBarDrawerToggle var0) {
      return var0.mActivity;
   }

   Drawable getThemeUpIndicator() {
      return this.mActivityImpl != null?this.mActivityImpl.getThemeUpIndicator():IMPL.getThemeUpIndicator(this.mActivity);
   }

   public boolean isDrawerIndicatorEnabled() {
      return this.mDrawerIndicatorEnabled;
   }

   public void onConfigurationChanged(Configuration var1) {
      this.mThemeImage = this.getThemeUpIndicator();
      this.mDrawerImage = this.mActivity.getResources().getDrawable(this.mDrawerImageResource);
      this.syncState();
   }

   public void onDrawerClosed(View var1) {
      this.mSlider.setPosition(0.0F);
      if(this.mDrawerIndicatorEnabled) {
         this.setActionBarDescription(this.mOpenDrawerContentDescRes);
      }

   }

   public void onDrawerOpened(View var1) {
      this.mSlider.setPosition(1.0F);
      if(this.mDrawerIndicatorEnabled) {
         this.setActionBarDescription(this.mCloseDrawerContentDescRes);
      }

   }

   public void onDrawerSlide(View var1, float var2) {
      float var3 = this.mSlider.getPosition();
      if(var2 > 0.5F) {
         var2 = Math.max(var3, Math.max(0.0F, var2 - 0.5F) * 2.0F);
      } else {
         var2 = Math.min(var3, var2 * 2.0F);
      }

      this.mSlider.setPosition(var2);
   }

   public void onDrawerStateChanged(int var1) {
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      if(var1 != null && var1.getItemId() == 16908332 && this.mDrawerIndicatorEnabled) {
         if(this.mDrawerLayout.isDrawerVisible(8388611)) {
            this.mDrawerLayout.closeDrawer(8388611);
         } else {
            this.mDrawerLayout.openDrawer(8388611);
         }

         return true;
      } else {
         return false;
      }
   }

   void setActionBarDescription(int var1) {
      if(this.mActivityImpl != null) {
         this.mActivityImpl.setActionBarDescription(var1);
      } else {
         this.mSetIndicatorInfo = IMPL.setActionBarDescription(this.mSetIndicatorInfo, this.mActivity, var1);
      }
   }

   void setActionBarUpIndicator(Drawable var1, int var2) {
      if(this.mActivityImpl != null) {
         this.mActivityImpl.setActionBarUpIndicator(var1, var2);
      } else {
         this.mSetIndicatorInfo = IMPL.setActionBarUpIndicator(this.mSetIndicatorInfo, this.mActivity, var1, var2);
      }
   }

   public void setDrawerIndicatorEnabled(boolean var1) {
      if(var1 != this.mDrawerIndicatorEnabled) {
         if(var1) {
            ActionBarDrawerToggle$SlideDrawable var3 = this.mSlider;
            int var2;
            if(this.mDrawerLayout.isDrawerOpen(8388611)) {
               var2 = this.mCloseDrawerContentDescRes;
            } else {
               var2 = this.mOpenDrawerContentDescRes;
            }

            this.setActionBarUpIndicator(var3, var2);
         } else {
            this.setActionBarUpIndicator(this.mThemeImage, 0);
         }

         this.mDrawerIndicatorEnabled = var1;
      }

   }

   public void syncState() {
      if(this.mDrawerLayout.isDrawerOpen(8388611)) {
         this.mSlider.setPosition(1.0F);
      } else {
         this.mSlider.setPosition(0.0F);
      }

      if(this.mDrawerIndicatorEnabled) {
         ActionBarDrawerToggle$SlideDrawable var2 = this.mSlider;
         int var1;
         if(this.mDrawerLayout.isDrawerOpen(8388611)) {
            var1 = this.mCloseDrawerContentDescRes;
         } else {
            var1 = this.mOpenDrawerContentDescRes;
         }

         this.setActionBarUpIndicator(var2, var1);
      }

   }
}
