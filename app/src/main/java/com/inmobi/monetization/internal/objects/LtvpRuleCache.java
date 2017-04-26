package com.inmobi.monetization.internal.objects;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.inmobi.monetization.internal.LtvpRulesObject;
import java.util.HashMap;

public class LtvpRuleCache {
   static LtvpRuleCache a;
   private static String c = "IMAdMLtvpRuleCache";
   private static String d = "IMAdMLtvpRuleId";
   private static String e = "IMAdMLtvpHardExpiry";
   private static String f = "IMAdMLtvpSoftExpiry";
   private SharedPreferences b = null;

   private LtvpRuleCache(Context var1) {
      this.b = var1.getSharedPreferences(c, 0);
   }

   private void a(long var1) {
      Editor var3 = this.b.edit();
      var3.putLong(e, var1);
      var3.commit();
   }

   private void a(String var1) {
      Editor var2 = this.b.edit();
      var2.putString(d, var1);
      var2.commit();
   }

   private void a(HashMap param1) {
      // $FF: Couldn't be decompiled
   }

   private void b(long var1) {
      Editor var3 = this.b.edit();
      var3.putLong(f, var1);
      var3.commit();
   }

   public static LtvpRuleCache getInstance(Context var0) {
      if(a == null) {
         synchronized(LtvpRuleCache.class) {
            if(a == null) {
               a = new LtvpRuleCache(var0);
            }

         }
      }

      return a;
   }

   public void clearLtvpRuleCache() {
      Editor var1 = this.b.edit();
      var1.clear();
      var1.commit();
   }

   public long getHardExpiryForLtvpRule() {
      return this.b.getLong(e, 0L);
   }

   public int getLtvpRule(long var1) {
      return this.b.getInt(String.valueOf(var1), 0);
   }

   public String getLtvpRuleId() {
      return this.b.getString(d, "");
   }

   public long getSoftExpiryForLtvpRule() {
      return this.b.getLong(f, 0L);
   }

   public void setLtvpRuleConfig(LtvpRulesObject var1) {
      this.a(var1.getRuleId());
      this.a(var1.getHardExpiry() + var1.getTimeStamp());
      this.b(var1.getSoftExpiry() + var1.getTimeStamp());
      this.a(var1.getRules());
   }
}
