package com.inmobi.commons.uid;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.inmobi.commons.IMIDType;
import com.inmobi.commons.data.DemogInfo;
import com.inmobi.commons.data.DeviceInfo;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.AdvertisingId;
import java.util.Date;
import java.util.UUID;

class a {
   private static final Uri a = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
   private static AdvertisingId b = null;

   static String a() {
      return "1";
   }

   static String a(String var0) {
      return InternalSDKUtil.getDigested(var0, "SHA-1");
   }

   protected static void a(Context var0) {
      String var4 = FileOperations.getPreferences(var0, "impref", "IMID");
      long var1 = FileOperations.getLongPreferences(var0, "impref", "timestamp");
      String var3 = var4;
      if(var4 == null) {
         var3 = UUID.randomUUID().toString();
         FileOperations.setPreferences(var0, "impref", "IMID", var3);
         FileOperations.setPreferences(var0, "impref", "AID", DeviceInfo.getAid());
         FileOperations.setPreferences(var0, "impref", "AIDL", DeviceInfo.getAid());
      }

      if(var1 == 0L) {
         FileOperations.setPreferences(var0, "impref", "timestamp", (new Date()).getTime());
      }

      Intent var5 = new Intent();
      var5.setAction("com.inmobi.share.id");
      var5.putExtra("IMID", var3);
      var5.putExtra("AIDL", FileOperations.getPreferences(var0, "impref", "AIDL"));
      var5.putExtra("timestamp", FileOperations.getLongPreferences(var0, "impref", "timestamp"));
      var5.putExtra("AID", DeviceInfo.getAid());
      var0.sendBroadcast(var5);
   }

   static String b() {
      return DemogInfo.getIDType(IMIDType.ID_SESSION);
   }

   static String b(Context var0) {
      return FileOperations.getPreferences(var0, "impref", "IMID");
   }

   static String b(String var0) {
      return InternalSDKUtil.getDigested(var0, "MD5");
   }

   static String c() {
      return DemogInfo.getIDType(IMIDType.ID_LOGIN);
   }

   static String c(Context param0) {
      // $FF: Couldn't be decompiled
   }

   static String d() {
      // $FF: Couldn't be decompiled
   }

   static String e() {
      try {
         String var0 = (String)Class.forName("com.inmobi.commons.uid.PlatformId").getDeclaredMethod("getAndroidId", new Class[]{Context.class}).invoke((Object)null, new Object[]{InternalSDKUtil.getContext()});
         return var0;
      } catch (Exception var1) {
         return null;
      }
   }

   static AdvertisingId f() {
      return b;
   }

   static void g() {
      AdvertisingId var0 = new AdvertisingId();
      b = var0;
      var0.a(FileOperations.getPreferences(InternalSDKUtil.getContext(), "impref", "gpid"));
      b.a(FileOperations.getBooleanPreferences(InternalSDKUtil.getContext(), "impref", "limitadtrck"));
      (new Thread(new Runnable() {
         public final void run() {
            try {
               Class var2 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
               Class var1 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
               Object var6 = var2.getDeclaredMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke((Object)null, new Object[]{InternalSDKUtil.getContext()});
               String var3 = (String)var1.getDeclaredMethod("getId", (Class[])null).invoke(var6, (Object[])null);
               com.inmobi.commons.uid.a.b.a(var3);
               FileOperations.setPreferences(InternalSDKUtil.getContext(), "impref", "gpid", var3);
               Boolean var5 = (Boolean)var1.getDeclaredMethod("isLimitAdTrackingEnabled", (Class[])null).invoke(var6, (Object[])null);
               com.inmobi.commons.uid.a.b.a(var5.booleanValue());
               FileOperations.setPreferences(InternalSDKUtil.getContext(), "impref", "limitadtrck", var5.booleanValue());
            } catch (Exception var4) {
               Log.internal("[InMobi]-4.5.2", "Exception getting advertiser id", var4);
            }
         }
      })).start();
   }

   static boolean h() {
      boolean var1 = false;

      int var0;
      try {
         var0 = com.google.android.gms.common.g.a(InternalSDKUtil.getContext());
      } catch (NoClassDefFoundError var3) {
         return false;
      }

      if(var0 == 0) {
         var1 = true;
      }

      return var1;
   }

   static boolean i() {
      AdvertisingId var0 = f();
      return var0 != null?var0.isLimitAdTracking():false;
   }
}
