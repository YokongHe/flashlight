package com.inmobi.commons.analytics.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.inmobi.commons.analytics.db.AnalyticsEvent;
import com.inmobi.commons.analytics.db.AnalyticsEvent$TRANSACTION_ITEM_TYPE;
import com.inmobi.commons.analytics.db.AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE;
import com.inmobi.commons.analytics.db.AnalyticsSQLiteHelper;
import com.inmobi.commons.analytics.net.AnalyticsNetworkManager;
import com.inmobi.commons.analytics.util.AnalyticsUtils;
import com.inmobi.commons.analytics.util.SessionInfo;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class AnalyticsDatabaseManager {
   private static AnalyticsDatabaseManager c;
   private static final String[] d = new String[]{"_id", "eventid", "type", "sid", "ts", "ssts", "am"};
   private static final String[] e = new String[]{"_id", "levelid", "levelname"};
   private static final String[] f = new String[]{"_id", "levelid", "levelname", "levelstatus", "timetaken", "attemptcount", "attempttime"};
   private static final String[] g = new String[]{"_id", "eventname"};
   private static final String[] h = new String[]{"_id", "attributename", "attributevalue"};
   private static final String[] i = new String[]{"_id", "levelid", "begintime", "totalcount", "totaltime"};
   private static final String[] j = new String[]{"_id", "itemName", "itemType", "itemCount", "itemDescription", "itemPrice", "currencyCode", "productId", "transactionId", "transactionStatus"};
   private AnalyticsSQLiteHelper a;
   private SQLiteDatabase b;

   private AnalyticsEvent a(Cursor var1) {
      Object var4 = null;
      AnalyticsEvent var5 = new AnalyticsEvent(var1.getString(2));
      var5.setEventSessionId(var1.getString(3));
      var5.setEventId(var1.getLong(0));
      var5.setEventTimeStamp(var1.getLong(4));
      var5.setEventSessionTimeStamp(var1.getLong(5));
      var5.setEventAttributeMap(var1.getString(6));
      long var2 = var1.getLong(1);
      String var6 = Long.toString(var2);
      Log.debug("[InMobi]-[Analytics]-4.5.2", "IMAppDatabaseManager->" + var5.getEventType() + "-" + var2);
      if(var2 > -1L) {
         if(var5.getEventType().equals("lb")) {
            var1 = this.b.query("levelbegin", e, "_id = ?", new String[]{var6}, (String)null, (String)null, (String)null);
            var1.moveToFirst();
            var5.setEventLevelId(var1.getString(1));
            var5.setEventLevelName(var1.getString(2));
         } else if(var5.getEventType().equals("le")) {
            var1 = this.b.query("levelend", f, "_id = ?", new String[]{var6}, (String)null, (String)null, (String)null);
            var1.moveToFirst();
            var5.setEventLevelId(var1.getString(1));
            var5.setEventLevelName(var1.getString(2));
            var5.setEventLevelStatus(var1.getString(3));
            var5.setEventTimeTaken(var1.getString(4));
            var5.setEventAttemptCount(var1.getString(5));
            var5.setEventAttemptTime(var1.getString(6));
         } else if(var5.getEventType().equals("ce")) {
            var1 = this.b.query("customevent", g, "_id = ?", new String[]{var6}, (String)null, (String)null, (String)null);
            var1.moveToFirst();
            var5.setEventCustomName(var1.getString(1));
         } else if(var5.getEventType().equals("ae")) {
            var1 = this.b.query("attribute", h, "_id = ?", new String[]{var6}, (String)null, (String)null, (String)null);
            var1.moveToFirst();
            var5.setUserAttribute(var1.getString(1), var1.getString(2));
         } else {
            var1 = (Cursor)var4;
            if(var5.getEventType().equals("pi")) {
               var1 = this.b.query("transactiondetail", j, "_id = ?", new String[]{var6}, (String)null, (String)null, (String)null);
               var1.moveToFirst();
               var5.setTransactionItemName(var1.getString(1));
               var5.setTransactionItemType(var1.getInt(2));
               var5.setTransactionItemCount(var1.getInt(3));
               var5.setTransactionItemDescription(var1.getString(4));
               var5.setTransactionItemPrice(var1.getDouble(5));
               var5.setTransactionCurrencyCode(var1.getString(6));
               var5.setTransactionProductId(var1.getString(7));
               var5.setTransactionId(var1.getString(8));
               var5.setTransactionStatus(var1.getInt(9));
            }
         }

         if(var1 != null) {
            var1.close();
         }
      }

      return var5;
   }

   private void a() {
      this.b = this.a.getWritableDatabase();
   }

   private void a(AnalyticsEvent var1, long var2) {
      Log.debug("[InMobi]-[Analytics]-4.5.2", "IMAppDatabaseManager->insertEvents-" + var1.getEventType());
      if(var2 < AnalyticsUtils.getMaxdbcount()) {
         ContentValues var10 = new ContentValues();
         var2 = -1L;
         long var5 = var1.getEventTimeStamp();
         ContentValues var7;
         if(var1.getEventType().equals("lb")) {
            var7 = new ContentValues();
            var7.put("begintime", Long.valueOf(var5));
            if(this.b.update("attemptdata", var7, "levelid = ?", new String[]{var1.getEventLevelId()}) <= 0) {
               var7.put("levelid", var1.getEventLevelId());
               var7.put("totalcount", Integer.toString(0));
               var7.put("totaltime", Integer.toString(0));
               this.b.insert("attemptdata", (String)null, var7);
            }

            var10.put("levelid", var1.getEventLevelId());
            var10.put("levelname", var1.getEventLevelName());
            var2 = this.b.insert("levelbegin", (String)null, var10);
         } else if(var1.getEventType().equals("le")) {
            Cursor var11 = this.b.query("attemptdata", i, "levelid = ?", new String[]{var1.getEventLevelId()}, (String)null, (String)null, (String)null, "1");
            String var8;
            String var9;
            String var13;
            if(var11.getCount() > 0) {
               var11.moveToFirst();
               var2 = var5 - Long.parseLong(var11.getString(2));
               var9 = Long.toString(var2);
               var13 = Long.toString(var2 + Long.parseLong(var11.getString(4)));
               var8 = Integer.toString(Integer.parseInt(var11.getString(3)) + 1);
               ContentValues var12 = new ContentValues();
               var12.put("totalcount", var8);
               var12.put("totaltime", var13);
               this.b.update("attemptdata", var12, "levelid = ?", new String[]{var1.getEventLevelId()});
            } else {
               var13 = "0";
               var8 = "0";
               var9 = "0";
            }

            var11.close();
            var10.put("levelid", var1.getEventLevelId());
            var10.put("levelstatus", var1.getEventLevelStatus());
            var10.put("levelname", var1.getEventLevelName());
            var10.put("timetaken", var9);
            var10.put("attemptcount", var8);
            var10.put("attempttime", var13);
            var2 = this.b.insert("levelend", (String)null, var10);
         } else if(var1.getEventType().equals("pi")) {
            var10.put("itemName", var1.getTransactionItemName());
            int var4 = var1.getTransactionItemType();
            if(AnalyticsEvent$TRANSACTION_ITEM_TYPE.INVALID.getValue() != var4) {
               var10.put("itemType", Integer.valueOf(var4));
            }

            var4 = var1.getTransactionItemCount();
            if(var4 > 0) {
               var10.put("itemCount", Integer.valueOf(var4));
            }

            var10.put("itemDescription", var1.getTransactionItemDescription());
            var10.put("itemPrice", Double.valueOf(var1.getTransactionItemPrice()));
            var10.put("currencyCode", var1.getTransactionCurrencyCode());
            var10.put("productId", var1.getTransactionProductId());
            var10.put("transactionId", var1.getTransactionId());
            var4 = var1.getTransactionStatus();
            if(AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE.INVALID.getValue() != var4) {
               var10.put("transactionStatus", Integer.valueOf(var4));
            }

            var2 = this.b.insert("transactiondetail", (String)null, var10);
         } else if(var1.getEventType().equals("ce")) {
            var10.put("eventname", var1.getEventCustomName());
            var2 = this.b.insert("customevent", (String)null, var10);
         } else if(var1.getEventType().equals("ae")) {
            var10.put("attributename", var1.getAttributeName());
            var10.put("attributevalue", var1.getAttributeValue());
            var2 = this.b.insert("attribute", (String)null, var10);
         }

         var7 = new ContentValues();
         var7.put("eventid", Long.valueOf(var2));
         var7.put("type", var1.getEventType());
         var7.put("sid", var1.getEventSessionId());
         var7.put("ts", Long.valueOf(var1.getEventTimeStamp()));
         var7.put("ssts", Long.valueOf(var1.getEventSessionTimeStamp()));
         var7.put("am", var1.getEventAttributeMap());
         this.b.insert("eventlist", (String)null, var7);
      } else {
         Log.debug("[InMobi]-[Analytics]-4.5.2", "Database full");
      }

      if(!AnalyticsUtils.getStartHandle() && AnalyticsNetworkManager.getHandler() != null) {
         AnalyticsUtils.setStartHandle(true);
         AnalyticsNetworkManager.getHandler().sendEmptyMessageDelayed(1001, AnalyticsUtils.getTimeinterval());
      }

   }

   private void a(List var1) {
      Log.debug("[InMobi]-[Analytics]-4.5.2", "IMAppDatabaseManager->deleteEvents");
      Iterator var7 = var1.iterator();

      while(var7.hasNext()) {
         String var2 = ((Long)var7.next()).toString();
         Cursor var3 = this.b.query("eventlist", d, "_id=?", new String[]{var2}, (String)null, (String)null, (String)null, "1");
         var3.moveToFirst();
         Long var4 = Long.valueOf(var3.getLong(1));
         String var5 = var4.toString();
         String var6 = var3.getString(2);
         if(var4.longValue() > -1L) {
            if(var6.equals("lb")) {
               this.b.delete("levelbegin", "_id = ?", new String[]{var5});
            } else if(var6.equals("le")) {
               this.b.delete("levelend", "_id = ?", new String[]{var5});
            } else if(var6.equals("ce")) {
               this.b.delete("customevent", "_id = ?", new String[]{var5});
            } else if(var6.equals("ae")) {
               this.b.delete("attribute", "_id = ?", new String[]{var5});
            } else if(var6.equals("pi")) {
               this.b.delete("transactiondetail", "_id = ?", new String[]{var5});
            }
         }

         var3.close();
         this.b.delete("eventlist", "_id = ?", new String[]{var2});
      }

   }

   private void b() {
      this.a.close();
   }

   private List c() {
      Log.debug("[InMobi]-[Analytics]-4.5.2", "IMAppDatabaseManager->getEvents");
      ArrayList var1 = new ArrayList();
      if(!this.b.isOpen()) {
         android.util.Log.v("[InMobi]-[Analytics]-4.5.2", "IMAppDatabaseManager->getEvents()-database is not open");
         return var1;
      } else {
         Cursor var2 = this.b.query("eventlist", d, (String)null, (String[])null, (String)null, (String)null, (String)null, AnalyticsUtils.getMaxevents());
         var2.moveToFirst();

         while(!var2.isAfterLast()) {
            AnalyticsEvent var3 = this.a(var2);
            var3.setEventTableId(var2.getLong(0));
            var1.add(var3);
            var2.moveToNext();
         }

         var2.close();
         return var1;
      }
   }

   public static AnalyticsDatabaseManager getInstance() {
      synchronized(AnalyticsDatabaseManager.class){}

      AnalyticsDatabaseManager var3;
      try {
         if(c == null) {
            c = new AnalyticsDatabaseManager();
            File var0 = InternalSDKUtil.getContext().getDatabasePath("appengage.db");
            if(var0.isFile()) {
               var0.renameTo(InternalSDKUtil.getContext().getDatabasePath("ltvp.db"));
               SessionInfo.updatedFromOldSDK(InternalSDKUtil.getContext());
            }

            c.a = new AnalyticsSQLiteHelper(InternalSDKUtil.getContext());
         }

         var3 = c;
      } finally {
         ;
      }

      return var3;
   }

   public final void deleteEvents(List var1) {
      synchronized(this){}

      try {
         this.a();
         this.a(var1);
         this.a.close();
      } catch (Exception var4) {
         Log.internal("[InMobi]-[Analytics]-4.5.2", "Error deleting from DB.");
      } finally {
         ;
      }

   }

   public final List getEvents() {
      synchronized(this){}

      Object var1;
      try {
         this.a();
         var1 = this.c();
         this.a.close();
      } catch (Exception var4) {
         Log.internal("[InMobi]-[Analytics]-4.5.2", "Error reading events from DB.");
         var1 = new ArrayList();
      } finally {
         ;
      }

      return (List)var1;
   }

   public final void insertEvents(AnalyticsEvent var1) {
      synchronized(this){}

      try {
         this.a();
         this.a(var1, this.b.compileStatement("SELECT COUNT(*) FROM eventlist").simpleQueryForLong());
         this.a.close();
      } catch (Exception var4) {
         Log.internal("[InMobi]-[Analytics]-4.5.2", "Error in inserting into DB.", var4);
         var4.printStackTrace();
      } finally {
         ;
      }

   }
}
