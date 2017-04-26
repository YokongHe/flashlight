package com.inmobi.monetization.internal.imai.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.inmobi.commons.db.ColumnData;
import com.inmobi.commons.db.ColumnData$ColumnType;
import com.inmobi.commons.db.DatabaseHandler;
import com.inmobi.commons.db.TableData;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.imai.IMAIClickEventList;
import com.inmobi.monetization.internal.imai.db.ClickData;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ClickDatabaseManager extends DatabaseHandler {
   public static final String COLUMN_CLICK_ID = "clickid";
   public static final String COLUMN_CLICK_URL = "clickurl";
   public static final String COLUMN_FOLLOW_REDIRECT = "followredirect";
   public static final String COLUMN_PINGWV = "pingwv";
   public static final String COLUMN_RETRY_COUNT = "retrycount";
   public static final String COLUMN_TIMESTAMP = "timestamp";
   public static final String TABLE_CLICK = "clickevent";
   private static ClickDatabaseManager a;
   private int b = 1000;

   protected ClickDatabaseManager(Context var1, ArrayList var2) {
      super(var1, var2);
   }

   private static TableData a() {
      TableData var0 = new TableData();
      LinkedHashMap var1 = new LinkedHashMap();
      ColumnData var2 = new ColumnData();
      var2.setPrimaryKey(true);
      var2.setDataType(ColumnData$ColumnType.INTEGER);
      var2.setMandatory(true);
      var1.put("clickid", var2);
      var2 = new ColumnData();
      var2.setDataType(ColumnData$ColumnType.VARCHAR);
      var2.setMandatory(true);
      var1.put("clickurl", var2);
      var2 = new ColumnData();
      var2.setDataType(ColumnData$ColumnType.INTEGER);
      var2.setMandatory(true);
      var1.put("pingwv", var2);
      var2 = new ColumnData();
      var2.setDataType(ColumnData$ColumnType.INTEGER);
      var2.setMandatory(true);
      var1.put("followredirect", var2);
      var2 = new ColumnData();
      var2.setDataType(ColumnData$ColumnType.INTEGER);
      var2.setMandatory(true);
      var1.put("retrycount", var2);
      var2 = new ColumnData();
      var2.setDataType(ColumnData$ColumnType.INTEGER);
      var2.setMandatory(true);
      var1.put("timestamp", var2);
      var0.setmColumns(var1);
      var0.setmTableName("clickevent");
      return var0;
   }

   public static ClickDatabaseManager getInstance() {
      synchronized(ClickDatabaseManager.class){}
      boolean var3 = false;

      ClickDatabaseManager var6;
      label49: {
         try {
            var3 = true;
            if(a == null) {
               ArrayList var0 = new ArrayList();
               var0.add(a());
               a = new ClickDatabaseManager(InternalSDKUtil.getContext(), var0);
            }

            var6 = a;
            var3 = false;
            break label49;
         } catch (Exception var4) {
            Log.internal("[InMobi]-[Monetization]", "Exception getting DB Manager Instance", var4);
            var3 = false;
         } finally {
            if(var3) {
               ;
            }
         }

         var6 = null;
      }

      return var6;
   }

   public boolean deleteClickEvents(ArrayList param1) {
      // $FF: Couldn't be decompiled
   }

   public IMAIClickEventList getClickEvents(int param1) {
      // $FF: Couldn't be decompiled
   }

   public int getNoOfEvents() {
      try {
         this.open();
         int var1 = getInstance().getNoOfRows("clickevent", (String)null, (String[])null);
         this.close();
         return var1;
      } catch (Exception var3) {
         Log.internal("[InMobi]-[Monetization]", "Exception getting no of click events", var3);
         return 0;
      }
   }

   public void insertClick(ClickData var1) {
      synchronized(this){}

      try {
         this.open();
         ContentValues var4 = new ContentValues();
         var4.put("timestamp", Long.valueOf(var1.getTimestamp()));
         var4.put("clickurl", var1.getClickUrl());
         var4.put("pingwv", Boolean.valueOf(var1.isPingWv()));
         var4.put("retrycount", Integer.valueOf(var1.getRetryCount()));
         var4.put("followredirect", Boolean.valueOf(var1.isFollowRedirects()));
         if(this.getTableSize("clickevent") >= this.b) {
            Cursor var9 = this.executeQuery("SELECT clickid FROM clickevent WHERE timestamp= (SELECT MIN(timestamp) FROM clickevent Limit 1);", (String[])null);
            var9.moveToFirst();
            long var2 = var9.getLong(0);
            var9.close();
            this.delete("clickevent", "clickid = " + var2, (String[])null);
         }

         this.insert("clickevent", var4);
         this.close();
      } catch (Exception var7) {
         Log.internal("[InMobi]-[Monetization]", "Failed to insert click event to db", var7);
      } finally {
         ;
      }

   }

   public void setDBLimit(int var1) {
      if(var1 > 0) {
         this.b = var1;
      }

   }

   public boolean updateRetryCount(ArrayList param1) {
      // $FF: Couldn't be decompiled
   }
}
