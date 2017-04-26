package com.inmobi.commons.metric;

import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.metric.Logger$MetricsCallback;
import com.inmobi.commons.metric.MetricConfigParams;
import com.inmobi.commons.metric.Queuer;
import com.inmobi.commons.metric.Storage$PreProcessor;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class Storage {
   MetricConfigParams a;
   private String b;
   private String c;
   private String d;
   private int e;
   private Storage$PreProcessor f;
   private Queuer g;
   private long h;
   private long i;
   private AtomicBoolean j;
   private AtomicBoolean k;
   private Logger$MetricsCallback l;

   public Storage(int var1, String var2, Queuer var3, MetricConfigParams var4) {
      this.b = "inmobi.cache.data";
      this.c = "inmobi.cache.data.events.number";
      this.d = "inmobi.cache.data.events.timestamp";
      this.e = 0;
      this.f = null;
      this.g = null;
      this.a = null;
      this.h = -1L;
      this.i = -1L;
      this.j = new AtomicBoolean(false);
      this.k = new AtomicBoolean(false);
      this.l = null;
      this.a = var4;
      this.g = var3;
      this.e = var1;
      this.b = this.b + "." + var2;
      this.c = this.c + "." + var2;
      this.d = this.d + "." + var2;
   }

   public Storage(int var1, String var2, Queuer var3, MetricConfigParams var4, Storage$PreProcessor var5) {
      this(var1, var2, var3, var4);
      this.f = var5;
   }

   private void a() {
      try {
         FileOperations.writeStringToFile(InternalSDKUtil.getContext(), this.c, "" + this.h, false);
         FileOperations.writeStringToFile(InternalSDKUtil.getContext(), this.d, "" + this.i, false);
      } catch (Exception var2) {
         this.h = 0L;
      }
   }

   public long getEvents() {
      return this.h;
   }

   public long getTimestamp() {
      return this.i;
   }

   public String readLocalCache() {
      try {
         String var1 = FileOperations.readFileAsString(InternalSDKUtil.getContext(), this.b);
         return var1;
      } catch (Exception var2) {
         Log.internal("[InMobi]-[AdTracker]-4.5.2", "Unable to read metric info.");
         return "null,";
      }
   }

   public void readNumberOfEventsAndTimeStampFromPersistent() {
      if(this.h == -1L) {
         try {
            this.h = Long.parseLong(FileOperations.readFileAsString(InternalSDKUtil.getContext(), this.c));
            this.i = Long.parseLong(FileOperations.readFileAsString(InternalSDKUtil.getContext(), this.d));
         } catch (Exception var2) {
            this.h = 0L;
         }

         if(this.i == -1L) {
            this.i = System.currentTimeMillis() / 1000L;
            this.a();
            return;
         }
      }

   }

   public void resetFile() {
      try {
         FileOperations.writeStringToFile(InternalSDKUtil.getContext(), this.b, "", false);
         this.h = 0L;
         this.i = System.currentTimeMillis() / 1000L;
         this.a();
      } catch (IOException var2) {
         Log.internal("[InMobi]-[AdTracker]-4.5.2", "Someting went wrong while saving metrics log to persistent storage", var2);
      }
   }

   public void saveLocalCache() {
      // $FF: Couldn't be decompiled
   }

   public void saveToLatest() {
      this.saveLocalCache();
   }

   public void sendFile() {
      // $FF: Couldn't be decompiled
   }

   public void setCallback(Logger$MetricsCallback var1) {
      this.l = var1;
   }

   public void setPreprocessor(Storage$PreProcessor var1) {
      this.f = var1;
   }
}
