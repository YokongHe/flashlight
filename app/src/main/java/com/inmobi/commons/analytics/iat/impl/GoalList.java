package com.inmobi.commons.analytics.iat.impl;

import com.inmobi.commons.analytics.iat.impl.AdTrackerUtils;
import com.inmobi.commons.analytics.iat.impl.Goal;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerEventType;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerInitializer;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.util.Iterator;
import java.util.Vector;

public class GoalList extends Vector {
   public static GoalList getLoggedGoals() {
      GoalList var0 = null;
      if(FileOperations.isFileExist(InternalSDKUtil.getContext(), "eventlog")) {
         var0 = (GoalList)FileOperations.readFromFile(InternalSDKUtil.getContext(), "eventlog");
      }

      GoalList var1 = var0;
      if(var0 == null) {
         var1 = new GoalList();
      }

      return var1;
   }

   public boolean addGoal(String param1, int param2, long param3, int param5, boolean param6) {
      // $FF: Couldn't be decompiled
   }

   public Goal getGoal(String param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean increaseRetryTime(String var1, int var2, boolean var3) {
      if(var1 != null && !"".equals(var1.trim())) {
         Goal var10 = this.getGoal(var1);
         if(var10 != null) {
            int var4;
            int var5;
            long var6;
            label20: {
               var4 = AdTrackerInitializer.getConfigParams().getRetryParams().getMaxWaitTime();
               var2 = AdTrackerInitializer.getConfigParams().getRetryParams().getMaxRetry();
               var6 = var10.retryTime;
               var5 = var10.retryCount;
               if(var6 < (long)var4) {
                  long var8 = var6 * 2L + 30000L;
                  var6 = var8;
                  if(var8 <= (long)var4) {
                     break label20;
                  }
               }

               var6 = (long)var4;
            }

            var4 = var5 + 1;
            var10.retryTime = var6;
            var10.retryCount = var4;
            if(var4 >= var2) {
               AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_DUMPED, var10, 0, 0L, 0, (String)null);
            }

            return true;
         }
      } else {
         Log.internal("[InMobi]-[AdTracker]-4.5.2", "GoalName cannot be null");
      }

      return false;
   }

   public boolean removeGoal(String var1, int var2) {
      if(var1 != null && !"".equals(var1.trim())) {
         if(var2 <= 0) {
            Log.internal("[InMobi]-[AdTracker]-4.5.2", "GoalCount cannot be 0 or negative");
            return false;
         } else {
            Iterator var3 = this.iterator();

            while(var3.hasNext()) {
               Goal var4 = (Goal)var3.next();
               if(var4.name.equals(var1)) {
                  var2 = var4.count - var2;
                  if(var1.equals("download")) {
                     this.remove(var4);
                  } else if(var2 <= 0) {
                     this.remove(var4);
                  } else {
                     var4.count = var2;
                  }
                  break;
               }
            }

            return true;
         }
      } else {
         Log.debug("[InMobi]-[AdTracker]-4.5.2", "GoalName is null");
         return false;
      }
   }

   public void saveGoals() {
      FileOperations.saveToFile(InternalSDKUtil.getContext(), "eventlog", this);
   }
}
