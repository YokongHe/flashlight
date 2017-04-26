package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public final class c {
   public static int a(Parcel var0) {
      return b(var0, 20293);
   }

   public static void a(Parcel var0, int var1) {
      c(var0, var1);
   }

   public static void a(Parcel var0, int var1, byte var2) {
      b(var0, var1, 4);
      var0.writeInt(var2);
   }

   public static void a(Parcel var0, int var1, double var2) {
      b(var0, var1, 8);
      var0.writeDouble(var2);
   }

   public static void a(Parcel var0, int var1, float var2) {
      b(var0, var1, 4);
      var0.writeFloat(var2);
   }

   public static void a(Parcel var0, int var1, int var2) {
      b(var0, var1, 4);
      var0.writeInt(var2);
   }

   public static void a(Parcel var0, int var1, long var2) {
      b(var0, var1, 8);
      var0.writeLong(var2);
   }

   public static void a(Parcel var0, int var1, Bundle var2, boolean var3) {
      if(var2 != null) {
         var1 = b(var0, var1);
         var0.writeBundle(var2);
         c(var0, var1);
      }
   }

   public static void a(Parcel var0, int var1, IBinder var2, boolean var3) {
      if(var2 != null) {
         var1 = b(var0, var1);
         var0.writeStrongBinder(var2);
         c(var0, var1);
      }
   }

   public static void a(Parcel var0, int var1, Parcelable var2, int var3, boolean var4) {
      if(var2 != null) {
         var1 = b(var0, var1);
         var2.writeToParcel(var0, var3);
         c(var0, var1);
      }
   }

   public static void a(Parcel var0, int var1, Integer var2, boolean var3) {
      if(var2 != null) {
         b(var0, 5, 4);
         var0.writeInt(var2.intValue());
      }
   }

   public static void a(Parcel var0, int var1, String var2, boolean var3) {
      if(var2 != null) {
         var1 = b(var0, var1);
         var0.writeString(var2);
         c(var0, var1);
      }
   }

   public static void a(Parcel var0, int var1, List var2, boolean var3) {
      if(var2 != null) {
         var1 = b(var0, var1);
         var0.writeStringList(var2);
         c(var0, var1);
      }
   }

   public static void a(Parcel var0, int var1, boolean var2) {
      b(var0, var1, 4);
      byte var3;
      if(var2) {
         var3 = 1;
      } else {
         var3 = 0;
      }

      var0.writeInt(var3);
   }

   public static void a(Parcel var0, int var1, Parcelable[] var2, int var3, boolean var4) {
      if(var2 != null) {
         int var5 = b(var0, 8);
         int var6 = var2.length;
         var0.writeInt(var6);

         for(var1 = 0; var1 < var6; ++var1) {
            Parcelable var7 = var2[var1];
            if(var7 == null) {
               var0.writeInt(0);
            } else {
               a(var0, var7, var3);
            }
         }

         c(var0, var5);
      }
   }

   private static void a(Parcel var0, Parcelable var1, int var2) {
      int var3 = var0.dataPosition();
      var0.writeInt(1);
      int var4 = var0.dataPosition();
      var1.writeToParcel(var0, var2);
      var2 = var0.dataPosition();
      var0.setDataPosition(var3);
      var0.writeInt(var2 - var4);
      var0.setDataPosition(var2);
   }

   private static int b(Parcel var0, int var1) {
      var0.writeInt(-65536 | var1);
      var0.writeInt(0);
      return var0.dataPosition();
   }

   private static void b(Parcel var0, int var1, int var2) {
      if(var2 >= '\uffff') {
         var0.writeInt(-65536 | var1);
         var0.writeInt(var2);
      } else {
         var0.writeInt(var2 << 16 | var1);
      }
   }

   public static void b(Parcel var0, int var1, List var2, boolean var3) {
      if(var2 != null) {
         int var4 = b(var0, 1);
         int var5 = var2.size();
         var0.writeInt(var5);

         for(var1 = 0; var1 < var5; ++var1) {
            Parcelable var6 = (Parcelable)var2.get(var1);
            if(var6 == null) {
               var0.writeInt(0);
            } else {
               a(var0, var6, 0);
            }
         }

         c(var0, var4);
      }
   }

   private static void c(Parcel var0, int var1) {
      int var2 = var0.dataPosition();
      var0.setDataPosition(var1 - 4);
      var0.writeInt(var2 - var1);
      var0.setDataPosition(var2);
   }
}
