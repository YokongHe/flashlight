package com.tapjoy;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.tapjoy.TapjoyCachedAssetData;
import com.tapjoy.TapjoyUtil;
import java.io.File;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class TapjoyCacheMap extends ConcurrentHashMap {
   private Context a;
   private int b = -1;

   public TapjoyCacheMap(Context var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public void clear() {
      throw new UnsupportedOperationException();
   }

   public TapjoyCachedAssetData put(String var1, TapjoyCachedAssetData var2) {
      if(var2 != null && var2.getTimeOfDeathInSeconds() > System.currentTimeMillis() / 1000L) {
         if(this.size() == this.b) {
            long var3 = -1L;
            String var7 = "";
            Iterator var8 = this.entrySet().iterator();

            label25:
            while(true) {
               long var5;
               Entry var9;
               do {
                  if(!var8.hasNext()) {
                     this.remove(var7);
                     break label25;
                  }

                  var9 = (Entry)var8.next();
                  var5 = ((TapjoyCachedAssetData)var9.getValue()).getTimestampInSeconds();
               } while(var3 != 0L && var5 >= var3);

               var7 = (String)var9.getKey();
               var3 = var5;
            }
         }

         Editor var10 = this.a.getSharedPreferences("tapjoyCacheData", 0).edit();
         var10.putString(var2.getLocalFilePath(), var2.toRawJSONString());
         var10.commit();
         return (TapjoyCachedAssetData)super.put(var1, var2);
      } else {
         return null;
      }
   }

   public TapjoyCachedAssetData remove(Object var1) {
      if(this.containsKey(var1)) {
         Editor var2 = this.a.getSharedPreferences("tapjoyCacheData", 0).edit();
         var2.remove(((TapjoyCachedAssetData)this.get(var1)).getLocalFilePath());
         var2.commit();
         String var3 = ((TapjoyCachedAssetData)this.get(var1)).getLocalFilePath();
         if(var3 != null && var3.length() > 0) {
            TapjoyUtil.deleteFileOrDirectory(new File(var3));
         }

         return (TapjoyCachedAssetData)super.remove(var1);
      } else {
         return null;
      }
   }

   public TapjoyCachedAssetData replace(String var1, TapjoyCachedAssetData var2) {
      throw new UnsupportedOperationException();
   }

   public boolean replace(String var1, TapjoyCachedAssetData var2, TapjoyCachedAssetData var3) {
      throw new UnsupportedOperationException();
   }
}
