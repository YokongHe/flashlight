package com.amazon.device.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.amazon.device.ads.AndroidTargetUtils;
import com.amazon.device.ads.Log;
import com.amazon.device.ads.Settings$SettingsListener;
import com.amazon.device.ads.Settings$TransientValue;
import com.amazon.device.ads.Settings$Value;
import com.amazon.device.ads.ThreadUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

class Settings {
   private static final String LOG_TAG = Settings.class.getSimpleName();
   private static final String PREFS_NAME = "AmazonMobileAds";
   public static final String SETTING_ENABLE_WEBVIEW_PAUSE_LOGIC = "shouldPauseWebViewTimersInWebViewRelatedActivities";
   protected static final String SETTING_TESTING_ENABLED = "testingEnabled";
   protected static final String SETTING_TLS_ENABLED = "tlsEnabled";
   private static Settings instance = new Settings();
   private final ConcurrentHashMap cache = new ConcurrentHashMap();
   private ArrayList listeners = new ArrayList();
   private final ReentrantLock listenersLock = new ReentrantLock();
   private final CountDownLatch settingsLoadedLatch = new CountDownLatch(1);
   private SharedPreferences sharedPreferences;
   private final ReentrantLock writeToSharedPreferencesLock = new ReentrantLock();

   private void commit(Editor var1) {
      if(ThreadUtils.isOnMainThread()) {
         Log.e(LOG_TAG, "Committing settings must be executed on a background thread.");
      }

      if(AndroidTargetUtils.isAtLeastAndroidAPI(9)) {
         AndroidTargetUtils.editorApply(var1);
      } else {
         var1.commit();
      }
   }

   public static Settings getInstance() {
      return instance;
   }

   private void putSetting(String var1, Settings$Value var2) {
      if(var2.value == null) {
         Log.w(LOG_TAG, "Could not set null value for setting: %s", new Object[]{var1});
      } else {
         this.putSettingWithNoFlush(var1, var2);
         if(!var2.isTransientData && this.isSettingsLoaded()) {
            this.flush();
            return;
         }
      }

   }

   private void putSettingWithNoFlush(String var1, Settings$Value var2) {
      if(var2.value == null) {
         Log.w(LOG_TAG, "Could not set null value for setting: %s", new Object[]{var1});
      } else {
         this.cache.put(var1, var2);
      }
   }

   private void writeCacheToSharedPreferences() {
      this.writeCacheToSharedPreferences(this.sharedPreferences);
   }

   void beginFetch(final Context var1) {
      ThreadUtils.executeRunnable(new Runnable() {
         public void run() {
            Settings.this.fetchSharedPreferences(var1);
         }
      });
   }

   void cacheAdditionalEntries(Map var1) {
      Iterator var4 = var1.entrySet().iterator();

      while(var4.hasNext()) {
         Entry var3 = (Entry)var4.next();
         String var2 = (String)var3.getKey();
         if(var2 != null && !this.cache.containsKey(var2)) {
            Object var5 = var3.getValue();
            if(var5 != null) {
               this.cache.put(var2, new Settings$Value(this, var5.getClass(), var5));
            } else {
               Log.w(LOG_TAG, "Could not cache null value for SharedPreferences setting: %s", new Object[]{var2});
            }
         }
      }

   }

   public boolean containsKey(String var1) {
      return this.cache.containsKey(var1);
   }

   void contextReceived(Context var1) {
      if(var1 != null) {
         this.beginFetch(var1);
      }
   }

   void fetchSharedPreferences(Context var1) {
      if(!this.isSettingsLoaded()) {
         SharedPreferences var2 = this.getSharedPreferencesFromContext(var1);
         this.readSharedPreferencesIntoCache(var2);
         this.sharedPreferences = var2;
         this.writeCacheToSharedPreferences(var2);
      }

      this.settingsLoadedLatch.countDown();
      this.notifySettingsListeners();
   }

   void flush() {
      this.writeCacheToSharedPreferences();
   }

   public Boolean getBoolean(String var1, Boolean var2) {
      Settings$Value var3 = (Settings$Value)this.cache.get(var1);
      return var3 == null?var2:(Boolean)var3.value;
   }

   public boolean getBoolean(String var1, boolean var2) {
      Boolean var3 = this.getBoolean(var1, (Boolean)null);
      return var3 == null?var2:var3.booleanValue();
   }

   ConcurrentHashMap getCache() {
      return this.cache;
   }

   public int getInt(String var1, int var2) {
      Settings$Value var3 = (Settings$Value)this.cache.get(var1);
      return var3 == null?var2:((Integer)var3.value).intValue();
   }

   public long getLong(String var1, long var2) {
      Settings$Value var4 = (Settings$Value)this.cache.get(var1);
      return var4 == null?var2:((Long)var4.value).longValue();
   }

   SharedPreferences getSharedPreferences() {
      return this.sharedPreferences;
   }

   SharedPreferences getSharedPreferencesFromContext(Context var1) {
      return var1.getSharedPreferences("AmazonMobileAds", 0);
   }

   public String getString(String var1, String var2) {
      Settings$Value var3 = (Settings$Value)this.cache.get(var1);
      return var3 == null?var2:(String)var3.value;
   }

   public boolean isSettingsLoaded() {
      return this.sharedPreferences != null;
   }

   public void listenForSettings(Settings$SettingsListener var1) {
      this.listenersLock.lock();
      if(this.isSettingsLoaded()) {
         var1.settingsLoaded();
      } else {
         this.listeners.add(var1);
      }

      this.listenersLock.unlock();
   }

   void notifySettingsListeners() {
      this.listenersLock.lock();
      Iterator var1 = this.listeners.iterator();

      while(var1.hasNext()) {
         ((Settings$SettingsListener)var1.next()).settingsLoaded();
      }

      this.listeners.clear();
      this.listeners = null;
      this.listenersLock.unlock();
   }

   void putBoolean(String var1, boolean var2) {
      this.putSetting(var1, new Settings$Value(this, Boolean.class, Boolean.valueOf(var2)));
   }

   void putBooleanWithNoFlush(String var1, boolean var2) {
      this.putSettingWithNoFlush(var1, new Settings$Value(this, Boolean.class, Boolean.valueOf(var2)));
   }

   void putInt(String var1, int var2) {
      this.putSetting(var1, new Settings$Value(this, Integer.class, Integer.valueOf(var2)));
   }

   void putIntWithNoFlush(String var1, int var2) {
      this.putSettingWithNoFlush(var1, new Settings$Value(this, Integer.class, Integer.valueOf(var2)));
   }

   void putLong(String var1, long var2) {
      this.putSetting(var1, new Settings$Value(this, Long.class, Long.valueOf(var2)));
   }

   void putLongWithNoFlush(String var1, long var2) {
      this.putSettingWithNoFlush(var1, new Settings$Value(this, Long.class, Long.valueOf(var2)));
   }

   void putString(String var1, String var2) {
      this.putSetting(var1, new Settings$Value(this, String.class, var2));
   }

   void putStringWithNoFlush(String var1, String var2) {
      this.putSettingWithNoFlush(var1, new Settings$Value(this, String.class, var2));
   }

   void putTransientBoolean(String var1, boolean var2) {
      this.putSettingWithNoFlush(var1, new Settings$TransientValue(this, Boolean.class, Boolean.valueOf(var2)));
   }

   void putTransientInt(String var1, int var2) {
      this.putSettingWithNoFlush(var1, new Settings$TransientValue(this, Integer.class, Integer.valueOf(var2)));
   }

   void putTransientLong(String var1, long var2) {
      this.putSettingWithNoFlush(var1, new Settings$TransientValue(this, Long.class, Long.valueOf(var2)));
   }

   void putTransientString(String var1, String var2) {
      this.putSettingWithNoFlush(var1, new Settings$TransientValue(this, String.class, var2));
   }

   void readSharedPreferencesIntoCache(SharedPreferences var1) {
      this.cacheAdditionalEntries(var1.getAll());
   }

   void remove(String var1) {
      Settings$Value var2 = (Settings$Value)this.cache.remove(var1);
      if(var2 != null && !var2.isTransientData && this.isSettingsLoaded()) {
         this.flush();
      }

   }

   void removeWithNoFlush(String var1) {
      this.cache.remove(var1);
   }

   void writeCacheToSharedPreferences(final SharedPreferences var1) {
      ThreadUtils.executeRunnable(new Runnable() {
         public void run() {
            Settings.this.writeToSharedPreferencesLock.lock();
            Editor var1x = var1.edit();
            var1x.clear();
            Iterator var2 = Settings.this.cache.entrySet().iterator();

            while(var2.hasNext()) {
               Entry var3 = (Entry)var2.next();
               Settings$Value var4 = (Settings$Value)var3.getValue();
               if(!var4.isTransientData) {
                  if(var4.clazz == String.class) {
                     var1x.putString((String)var3.getKey(), (String)var4.value);
                  } else if(var4.clazz == Long.class) {
                     var1x.putLong((String)var3.getKey(), ((Long)var4.value).longValue());
                  } else if(var4.clazz == Integer.class) {
                     var1x.putInt((String)var3.getKey(), ((Integer)var4.value).intValue());
                  } else if(var4.clazz == Boolean.class) {
                     var1x.putBoolean((String)var3.getKey(), ((Boolean)var4.value).booleanValue());
                  }
               }
            }

            Settings.this.commit(var1x);
            Settings.this.writeToSharedPreferencesLock.unlock();
         }
      });
   }
}
