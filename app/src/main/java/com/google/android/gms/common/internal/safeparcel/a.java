package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public final class a {
   public static int a(Parcel var0) {
      int var2 = var0.readInt();
      int var3 = a(var0, var2);
      int var1 = var0.dataPosition();
      if(('\uffff' & var2) != 20293) {
         throw new com.google.android.gms.common.internal.safeparcel.b("Expected object header. Got 0x" + Integer.toHexString(var2), var0);
      } else {
         var2 = var1 + var3;
         if(var2 >= var1 && var2 <= var0.dataSize()) {
            return var2;
         } else {
            throw new com.google.android.gms.common.internal.safeparcel.b("Size read is invalid start=" + var1 + " end=" + var2, var0);
         }
      }
   }

   public static int a(Parcel var0, int var1) {
      return (var1 & -65536) != -65536?var1 >> 16 & '\uffff':var0.readInt();
   }

   public static Parcelable a(Parcel var0, int var1, Creator var2) {
      var1 = a(var0, var1);
      int var3 = var0.dataPosition();
      if(var1 == 0) {
         return null;
      } else {
         Parcelable var4 = (Parcelable)var2.createFromParcel(var0);
         var0.setDataPosition(var1 + var3);
         return var4;
      }
   }

   private static void a(Parcel var0, int var1, int var2) {
      var1 = a(var0, var1);
      if(var1 != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.b("Expected size " + var2 + " got " + var1 + " (0x" + Integer.toHexString(var1) + ")", var0);
      }
   }

   public static void b(Parcel var0, int var1) {
      var0.setDataPosition(a(var0, var1) + var0.dataPosition());
   }

   public static boolean c(Parcel var0, int var1) {
      a(var0, var1, 4);
      return var0.readInt() != 0;
   }

   public static byte d(Parcel var0, int var1) {
      a(var0, var1, 4);
      return (byte)var0.readInt();
   }

   public static int e(Parcel var0, int var1) {
      a(var0, var1, 4);
      return var0.readInt();
   }

   public static Integer f(Parcel var0, int var1) {
      var1 = a(var0, var1);
      if(var1 == 0) {
         return null;
      } else if(var1 != 4) {
         throw new com.google.android.gms.common.internal.safeparcel.b("Expected size " + 4 + " got " + var1 + " (0x" + Integer.toHexString(var1) + ")", var0);
      } else {
         return Integer.valueOf(var0.readInt());
      }
   }

   public static long g(Parcel var0, int var1) {
      a(var0, var1, 8);
      return var0.readLong();
   }

   public static float h(Parcel var0, int var1) {
      a(var0, var1, 4);
      return var0.readFloat();
   }

   public static double i(Parcel var0, int var1) {
      a(var0, var1, 8);
      return var0.readDouble();
   }

   public static String j(Parcel var0, int var1) {
      var1 = a(var0, var1);
      int var2 = var0.dataPosition();
      if(var1 == 0) {
         return null;
      } else {
         String var3 = var0.readString();
         var0.setDataPosition(var1 + var2);
         return var3;
      }
   }

   public static IBinder k(Parcel var0, int var1) {
      var1 = a(var0, var1);
      int var2 = var0.dataPosition();
      if(var1 == 0) {
         return null;
      } else {
         IBinder var3 = var0.readStrongBinder();
         var0.setDataPosition(var1 + var2);
         return var3;
      }
   }

   public static Bundle l(Parcel var0, int var1) {
      var1 = a(var0, var1);
      int var2 = var0.dataPosition();
      if(var1 == 0) {
         return null;
      } else {
         Bundle var3 = var0.readBundle();
         var0.setDataPosition(var1 + var2);
         return var3;
      }
   }

   public static ArrayList m(Parcel var0, int var1) {
      var1 = a(var0, var1);
      int var2 = var0.dataPosition();
      if(var1 == 0) {
         return null;
      } else {
         ArrayList var3 = var0.createStringArrayList();
         var0.setDataPosition(var1 + var2);
         return var3;
      }
   }
}
