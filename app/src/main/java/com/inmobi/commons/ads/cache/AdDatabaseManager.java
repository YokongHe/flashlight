package com.inmobi.commons.ads.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.inmobi.commons.ads.cache.AdData;
import com.inmobi.commons.ads.cache.AdDatabaseHelper;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;

public class AdDatabaseManager {
   private static AdDatabaseManager c;
   private AdDatabaseHelper a;
   private SQLiteDatabase b;
   private int d = 1000;

   public static AdDatabaseManager getInstance() {
      synchronized(AdDatabaseManager.class){}

      AdDatabaseManager var0;
      try {
         if(c == null) {
            var0 = new AdDatabaseManager();
            c = var0;
            var0.a = new AdDatabaseHelper(InternalSDKUtil.getContext());
         }

         var0 = c;
      } finally {
         ;
      }

      return var0;
   }

   protected void close() {
      try {
         this.b.close();
      } catch (Exception var2) {
         Log.internal("[InMobi]-4.5.2", "Failed to close ads db", var2);
      }
   }

   public AdData getAd(String var1) {
      synchronized(this){}
      boolean var5 = false;

      AdData var8;
      try {
         var5 = true;
         this.open();
         Cursor var2 = this.b.rawQuery("SELECT * FROM ad WHERE appid = ? Order by timestamp Limit 1;", new String[]{var1});
         var2.moveToFirst();
         var8 = new AdData();
         var8.setAdId(var2.getLong(0));
         var8.setTimestamp(var2.getLong(1));
         var8.setAppId(var2.getString(2));
         var8.setContent(var2.getString(3));
         var2.close();
         this.b.delete("ad", "adid = " + var8.getAdId(), (String[])null);
         this.close();
         var5 = false;
         return var8;
      } catch (Exception var6) {
         Log.internal("[InMobi]-4.5.2", "Failed to get native ads from db", var6);
         var5 = false;
      } finally {
         if(var5) {
            ;
         }
      }

      var8 = null;
      return var8;
   }

   protected int getDBSize() {
      try {
         this.open();
         int var1 = this.b.rawQuery("SELECT * FROM ad; ", (String[])null).getCount();
         this.close();
         return var1;
      } catch (Exception var3) {
         Log.internal("[InMobi]-4.5.2", "Failed to get native ads from db", var3);
         return 0;
      }
   }

   public int getNoOfAds(String var1) {
      synchronized(this){}
      boolean var5 = false;

      int var2;
      try {
         var5 = true;
         this.open();
         var2 = this.b.rawQuery("SELECT * FROM ad WHERE appid = ?; ", new String[]{var1}).getCount();
         this.close();
         var5 = false;
         return var2;
      } catch (Exception var6) {
         Log.internal("[InMobi]-4.5.2", "Failed to get native ads from db", var6);
         var5 = false;
      } finally {
         if(var5) {
            ;
         }
      }

      var2 = 0;
      return var2;
   }

   public void insertAd(AdData var1) {
      synchronized(this){}

      try {
         ContentValues var4 = new ContentValues();
         var4.put("timestamp", Long.valueOf(var1.getTimestamp()));
         var4.put("appid", var1.getAppId());
         var4.put("content", var1.getContent());
         var4.put("adtype", var1.getAdType());
         if(this.getDBSize() >= this.d) {
            this.open();
            Cursor var9 = this.b.rawQuery("SELECT adid FROM ad WHERE timestamp= (SELECT MIN(timestamp) FROM ad Limit 1);", (String[])null);
            var9.moveToFirst();
            long var2 = var9.getLong(0);
            var9.close();
            this.b.delete("ad", "adid = " + var2, (String[])null);
            this.close();
         }

         this.open();
         this.b.insert("ad", (String)null, var4);
         this.close();
      } catch (Exception var7) {
         Log.internal("[InMobi]-4.5.2", "Failed to insert native ads to db", var7);
      } finally {
         ;
      }

   }

   protected void open() {
      try {
         this.b = this.a.getWritableDatabase();
      } catch (Exception var2) {
         Log.internal("[InMobi]-4.5.2", "Failed to open ads db", var2);
      }
   }

   public void removeExpiredAds(long var1, String var3) {
      try {
         this.open();
         long var5 = System.currentTimeMillis();
         int var4 = this.b.delete("ad", "timestamp<? AND adtype=?", new String[]{Long.toString(var5 - 1000L * var1), var3});
         this.close();
         Log.internal("[InMobi]-4.5.2", "Deleted " + var4 + " expired ads from cache.");
      } catch (Exception var7) {
         Log.internal("[InMobi]-4.5.2", "Failed to remove expired ads from cache", var7);
      }
   }

   public void setDBLimit(int var1) {
      if(var1 > 0) {
         this.d = var1;
      }

   }
}
