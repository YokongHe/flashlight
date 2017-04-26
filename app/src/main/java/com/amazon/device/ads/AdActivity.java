package com.amazon.device.ads;

import android.app.Activity;
import android.os.Bundle;
import com.amazon.device.ads.AdActivity$IAdActivityAdapter;
import com.amazon.device.ads.InternalAdRegistration;
import com.amazon.device.ads.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AdActivity extends Activity {
   static final String ADAPTER_KEY = "adapter";
   private static final String LOG_TAG = "AdAdapter";
   private AdActivity$IAdActivityAdapter adapter;

   AdActivity$IAdActivityAdapter createAdapter() {
      String var1 = this.getIntent().getStringExtra("adapter");
      if(var1 == null) {
         Log.e("AdAdapter", "Unable to launch the AdActivity due to an internal error.");
         return null;
      } else {
         Class var9;
         try {
            var9 = Class.forName(var1);
         } catch (ClassNotFoundException var8) {
            Log.e("AdAdapter", "Unable to get the adapter class.");
            return null;
         }

         Constructor var10;
         try {
            var10 = var9.getDeclaredConstructor(new Class[0]);
         } catch (SecurityException var6) {
            Log.e("AdAdapter", "Security exception when trying to get the default constructor.");
            return null;
         } catch (NoSuchMethodException var7) {
            Log.e("AdAdapter", "No default constructor exists for the adapter.");
            return null;
         }

         try {
            AdActivity$IAdActivityAdapter var11 = (AdActivity$IAdActivityAdapter)var10.newInstance(new Object[0]);
            return var11;
         } catch (IllegalArgumentException var2) {
            Log.e("AdAdapter", "Illegal arguments given to the default constructor.");
            return null;
         } catch (InstantiationException var3) {
            Log.e("AdAdapter", "Instantiation exception when instantiating the adapter.");
            return null;
         } catch (IllegalAccessException var4) {
            Log.e("AdAdapter", "Illegal access exception when instantiating the adapter.");
            return null;
         } catch (InvocationTargetException var5) {
            Log.e("AdAdapter", "Invocation target exception when instantiating the adapter.");
            return null;
         }
      }
   }

   public void onBackPressed() {
      if(!this.adapter.onBackPressed()) {
         super.onBackPressed();
      }

   }

   public void onConfigurationChanged(android.content.res.Configuration var1) {
      super.onConfigurationChanged(var1);
      this.adapter.onConfigurationChanged(var1);
   }

   public void onCreate(Bundle var1) {
      InternalAdRegistration.getInstance().contextReceived(this.getApplicationContext());
      this.adapter = this.createAdapter();
      if(this.adapter == null) {
         this.finish();
      } else {
         this.adapter.setActivity(this);
         this.adapter.preOnCreate();
         super.onCreate(var1);
         this.adapter.onCreate();
      }
   }

   public void onPause() {
      super.onPause();
      this.adapter.onPause();
   }

   public void onResume() {
      super.onResume();
      this.adapter.onResume();
   }

   public void onStop() {
      this.adapter.onStop();
      super.onStop();
   }
}
