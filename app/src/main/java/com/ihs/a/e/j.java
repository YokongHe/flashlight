package com.ihs.a.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class j {
   private static com.ihs.a.e.j b;
   private SharedPreferences a;

   private j(SharedPreferences var1) {
      this.a = var1;
   }

   public static com.ihs.a.e.j a(Context var0) {
      if(b == null) {
         synchronized(com.ihs.a.e.j.class) {
            if(b == null) {
               b = new com.ihs.a.e.j(PreferenceManager.getDefaultSharedPreferences(var0));
            }

         }
      }

      return b;
   }

   public static com.ihs.a.e.j a(Context var0, String var1) {
      return new com.ihs.a.e.j(var0.getSharedPreferences(var1, 0));
   }

   public static void b(Context param0, String param1) {
      // $FF: Couldn't be decompiled
   }

   public final float a(String var1, float var2) {
      return this.a == null?0.0F:this.a.getFloat(var1, 0.0F);
   }

   public final int a(String var1, int var2) {
      return this.a == null?var2:this.a.getInt(var1, var2);
   }

   public final long a(String var1, long var2) {
      return this.a == null?var2:this.a.getLong(var1, var2);
   }

   public final String a(String var1, String var2) {
      return this.a == null?var2:this.a.getString(var1, var2);
   }

   public final boolean a(String var1, boolean var2) {
      return this.a == null?false:this.a.getBoolean(var1, false);
   }

   public final void b(String var1, float var2) {
      if(this.a != null) {
         this.a.edit().putFloat(var1, var2).commit();
      }
   }

   public final void b(String var1, int var2) {
      if(this.a != null) {
         this.a.edit().putInt(var1, var2).commit();
      }
   }

   public final void b(String var1, long var2) {
      if(this.a != null) {
         this.a.edit().putLong(var1, var2).commit();
      }
   }

   public final void b(String var1, String var2) {
      if(this.a != null) {
         this.a.edit().putString(var1, var2).commit();
      }
   }

   public final void b(String var1, boolean var2) {
      if(this.a != null) {
         this.a.edit().putBoolean(var1, var2).commit();
      }
   }
}
