package com.inmobi.commons.thinICE.cellular;

import android.content.Context;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.inmobi.commons.thinICE.cellular.CellOperatorInfo;
import com.inmobi.commons.thinICE.cellular.CellTowerInfo;
import com.inmobi.commons.thinICE.cellular.CellUtil$a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class CellUtil {
   private static final String[] a = new String[]{"android.permission.ACCESS_COARSE_LOCATION"};
   private static final String[] b = new String[]{"android.permission.ACCESS_FINE_LOCATION"};
   private static final String[] c = new String[]{"android.permission.ACCESS_COARSE_LOCATION"};

   private static int[] a(String var0) {
      int[] var3 = new int[]{-1, -1};
      if(var0 != null && !var0.equals("")) {
         int var1;
         int var2;
         try {
            var1 = Integer.parseInt(var0.substring(0, 3));
            var2 = Integer.parseInt(var0.substring(3));
         } catch (IndexOutOfBoundsException var4) {
            return var3;
         } catch (NumberFormatException var5) {
            return var3;
         }

         var3[0] = var1;
         var3[1] = var2;
         return var3;
      } else {
         return var3;
      }
   }

   public static CellOperatorInfo getCellNetworkInfo(Context var0) {
      CellOperatorInfo var1 = new CellOperatorInfo();
      TelephonyManager var3 = (TelephonyManager)var0.getSystemService("phone");
      int[] var2 = a(var3.getNetworkOperator());
      var1.currentMcc = var2[0];
      var1.currentMnc = var2[1];
      int[] var4 = a(var3.getSimOperator());
      var1.simMcc = var4[0];
      var1.simMnc = var4[1];
      return var1;
   }

   public static CellTowerInfo getCurrentCellTower(Context var0) {
      TelephonyManager var4 = (TelephonyManager)var0.getSystemService("phone");
      int[] var6 = a(var4.getNetworkOperator());
      CellLocation var7 = var4.getCellLocation();
      if(var7 != null && var6[0] != -1) {
         CellTowerInfo var10 = new CellTowerInfo();
         String var5 = String.valueOf(var6[0]);
         String var11 = String.valueOf(var6[1]);
         int var1;
         int var2;
         String var9;
         String var13;
         if(var7 instanceof CdmaCellLocation) {
            CdmaCellLocation var12 = (CdmaCellLocation)var7;
            var1 = var12.getNetworkId();
            var2 = var12.getBaseStationId();
            int var3 = var12.getSystemId();
            var10.signalStrength = CellUtil$a.a(var0);
            if(var1 != -1 && var2 != -1 && var3 != -1) {
               var9 = Integer.toHexString(var1);
               var13 = Integer.toHexString(var2);
               String var8 = Integer.toHexString(var3);
               var10.id = var5 + "-" + var11 + "-" + var9 + "-" + var13 + "-" + var8;
            }
         } else {
            GsmCellLocation var14 = (GsmCellLocation)var7;
            var1 = var14.getCid();
            var2 = var14.getLac();
            var10.signalStrength = CellUtil$a.a(var0);
            if(var1 != -1 && var2 != -1) {
               var9 = Integer.toHexString(var2);
               var13 = Integer.toHexString(var1);
               var10.id = var5 + "-" + var11 + "-" + var9 + "-" + var13;
            }
         }

         return var10;
      } else {
         return null;
      }
   }

   public static List getVisibleCellTower(Context var0) {
      List var1 = ((TelephonyManager)var0.getSystemService("phone")).getNeighboringCellInfo();
      if(var1 != null) {
         List var2 = var1;
         if(var1.size() == 0) {
            var2 = null;
         }

         return var2;
      } else {
         return null;
      }
   }

   public static List getVisibleCellTowerIds(Context var0) {
      List var1 = getVisibleCellTower(var0);
      if(var1 != null && var1.size() != 0) {
         ArrayList var2 = new ArrayList();
         Iterator var3 = var1.iterator();

         while(var3.hasNext()) {
            var2.add(Integer.valueOf(((NeighboringCellInfo)var3.next()).getCid()));
         }

         return var2;
      } else {
         return null;
      }
   }

   public static boolean hasGetCurrentServingCellPermission(Context var0) {
      String[] var5 = a;
      int var3 = var5.length;
      int var2 = 0;

      boolean var1;
      for(var1 = true; var2 < var3; ++var2) {
         if(var0.checkCallingOrSelfPermission(var5[var2]) != 0) {
            var1 = false;
         }
      }

      var5 = b;
      int var4 = var5.length;
      var2 = 0;

      boolean var6;
      for(var6 = true; var2 < var4; ++var2) {
         if(var0.checkCallingOrSelfPermission(var5[var2]) != 0) {
            var6 = false;
         }
      }

      if(!var1 && !var6) {
         return false;
      } else {
         return true;
      }
   }

   public static boolean hasGetVisibleCellTowerPermission(Context var0) {
      String[] var3 = c;
      int var2 = var3.length;

      for(int var1 = 0; var1 < var2; ++var1) {
         if(var0.checkCallingOrSelfPermission(var3[var1]) != 0) {
            return false;
         }
      }

      return true;
   }
}
