package com.inmobi.monetization.internal.imai;

import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.imai.RequestResponseManager;
import com.inmobi.monetization.internal.imai.db.ClickData;
import com.inmobi.monetization.internal.imai.db.ClickDatabaseManager;
import java.util.ArrayList;
import java.util.Iterator;

public class IMAIClickEventList extends ArrayList {
   private static final long serialVersionUID = -211778664111073467L;

   public static IMAIClickEventList getLoggedClickEvents() {
      // $FF: Couldn't be decompiled
   }

   public ClickData getClickEvent(long param1) {
      // $FF: Couldn't be decompiled
   }

   public void reduceRetryCount(int param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean removeClickEvent(long var1) {
      boolean var3 = false;
      synchronized(this){}
      boolean var7 = false;

      try {
         var7 = true;
         RequestResponseManager.isSynced.set(false);
         this.remove(this.getClickEvent(var1));
         var7 = false;
      } catch (Exception var8) {
         Log.internal("[InMobi]-[Monetization]", "Cant remove click event", var8);
         var7 = false;
         return var3;
      } finally {
         if(var7) {
            ;
         }
      }

      var3 = true;
      return var3;
   }

   public void saveClickEvents() {
      Log.internal("[InMobi]-[Monetization]", "Save ping events");
      if(RequestResponseManager.mDBWriterQueue != null && !RequestResponseManager.mDBWriterQueue.isEmpty()) {
         Iterator var1 = RequestResponseManager.mDBWriterQueue.iterator();

         while(var1.hasNext()) {
            ClickData var2 = (ClickData)var1.next();
            ClickDatabaseManager.getInstance().insertClick(var2);
         }
      }

   }
}
