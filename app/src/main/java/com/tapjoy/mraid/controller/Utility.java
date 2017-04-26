package com.tapjoy.mraid.controller;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import com.tapjoy.TapjoyLog;
import com.tapjoy.mraid.controller.Abstract;
import com.tapjoy.mraid.controller.Assets;
import com.tapjoy.mraid.controller.Display;
import com.tapjoy.mraid.controller.MraidLocation;
import com.tapjoy.mraid.controller.MraidSensor;
import com.tapjoy.mraid.controller.Network;
import com.tapjoy.mraid.view.MraidView;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@TargetApi(14)
public class Utility extends Abstract {
   private Assets c;
   private Display d;
   private MraidLocation e;
   private Network f;
   private MraidSensor g;

   public Utility(MraidView var1, Context var2) {
      super(var1, var2);
      this.c = new Assets(var1, var2);
      this.d = new Display(var1, var2);
      this.e = new MraidLocation(var1, var2);
      this.f = new Network(var1, var2);
      this.g = new MraidSensor(var1, var2);
      var1.addJavascriptInterface(this.c, "MRAIDAssetsControllerBridge");
      var1.addJavascriptInterface(this.d, "MRAIDDisplayControllerBridge");
      var1.addJavascriptInterface(this.e, "MRAIDLocationControllerBridge");
      var1.addJavascriptInterface(this.f, "MRAIDNetworkControllerBridge");
      var1.addJavascriptInterface(this.g, "MRAIDSensorControllerBridge");
   }

   private void a(int var1, String var2, String var3, String var4) {
      ContentResolver var7 = this.b.getContentResolver();
      long var5 = Long.parseLong(var2);
      ContentValues var8 = new ContentValues();
      var8.put("calendar_id", Integer.valueOf(var1));
      var8.put("title", var3);
      var8.put("description", var4);
      var8.put("dtstart", Long.valueOf(var5));
      var8.put("hasAlarm", Integer.valueOf(1));
      var8.put("dtend", Long.valueOf(3600000L + var5));
      Uri var9;
      if(Integer.parseInt(VERSION.SDK) == 8) {
         var9 = var7.insert(Uri.parse("content://com.android.calendar/events"), var8);
      } else {
         var9 = var7.insert(Uri.parse("content://calendar/events"), var8);
      }

      if(var9 != null) {
         var5 = Long.parseLong(var9.getLastPathSegment());
         var8 = new ContentValues();
         var8.put("event_id", Long.valueOf(var5));
         var8.put("method", Integer.valueOf(1));
         var8.put("minutes", Integer.valueOf(15));
         if(Integer.parseInt(VERSION.SDK) == 8) {
            var7.insert(Uri.parse("content://com.android.calendar/reminders"), var8);
         } else {
            var7.insert(Uri.parse("content://calendar/reminders"), var8);
         }
      }

      Toast.makeText(this.b, "Event added to calendar", 0).show();
   }

   @JavascriptInterface
   public void activate(String var1) {
      TapjoyLog.d("MRAID Utility", "activate: " + var1);
      if(var1.equalsIgnoreCase("networkChange")) {
         this.f.startNetworkListener();
      } else {
         if(this.e.allowLocationServices() && var1.equalsIgnoreCase("locationChange")) {
            this.e.startLocationListener();
            return;
         }

         if(var1.equalsIgnoreCase("shake")) {
            this.g.startShakeListener();
            return;
         }

         if(var1.equalsIgnoreCase("tiltChange")) {
            this.g.startTiltListener();
            return;
         }

         if(var1.equalsIgnoreCase("headingChange")) {
            this.g.startHeadingListener();
            return;
         }

         if(var1.equalsIgnoreCase("orientationChange")) {
            this.d.startConfigurationListener();
            return;
         }
      }

   }

   public String copyTextFromJarIntoAssetDir(String var1, String var2) {
      return this.c.copyTextFromJarIntoAssetDir(var1, var2);
   }

   @JavascriptInterface
   public void createEvent(final String var1, final String var2, final String var3) {
      TapjoyLog.d("MRAID Utility", "createEvent: date: " + var1 + " title: " + var2 + " body: " + var3);
      ContentResolver var5 = this.b.getContentResolver();
      String[] var6 = new String[]{"_id", "displayName", "_sync_account"};
      Cursor var8;
      if(Integer.parseInt(VERSION.SDK) == 8) {
         var8 = var5.query(Uri.parse("content://com.android.calendar/calendars"), var6, (String)null, (String[])null, (String)null);
      } else {
         var8 = var5.query(Uri.parse("content://calendar/calendars"), var6, (String)null, (String[])null, (String)null);
      }

      if(var8 != null && (var8 == null || var8.moveToFirst())) {
         if(var8.getCount() == 1) {
            this.a(var8.getInt(0), var1, var2, var3);
         } else {
            final ArrayList var9 = new ArrayList();

            for(int var4 = 0; var4 < var8.getCount(); ++var4) {
               HashMap var7 = new HashMap();
               var7.put("ID", var8.getString(0));
               var7.put("NAME", var8.getString(1));
               var7.put("EMAILID", var8.getString(2));
               var9.add(var7);
               var8.moveToNext();
            }

            Builder var10 = new Builder(this.b);
            var10.setTitle("Choose Calendar to save event to");
            var10.setSingleChoiceItems(new SimpleAdapter(this.b, var9, 17367053, new String[]{"NAME", "EMAILID"}, new int[]{16908308, 16908309}), -1, new OnClickListener() {
               public final void onClick(DialogInterface var1x, int var2x) {
                  Map var3x = (Map)var9.get(var2x);
                  Utility.this.a(Integer.parseInt((String)var3x.get("ID")), var1, var2, var3);
                  var1x.cancel();
               }
            });
            var10.create().show();
         }

         var8.close();
      } else {
         Toast.makeText(this.b, "No calendar account found", 1).show();
         if(var8 != null) {
            var8.close();
         }

      }
   }

   @JavascriptInterface
   public void deactivate(String var1) {
      TapjoyLog.d("MRAID Utility", "deactivate: " + var1);
      if(var1.equalsIgnoreCase("networkChange")) {
         this.f.stopNetworkListener();
      } else {
         if(var1.equalsIgnoreCase("locationChange")) {
            this.e.stopAllListeners();
            return;
         }

         if(var1.equalsIgnoreCase("shake")) {
            this.g.stopShakeListener();
            return;
         }

         if(var1.equalsIgnoreCase("tiltChange")) {
            this.g.stopTiltListener();
            return;
         }

         if(var1.equalsIgnoreCase("headingChange")) {
            this.g.stopHeadingListener();
            return;
         }

         if(var1.equalsIgnoreCase("orientationChange")) {
            this.d.stopConfigurationListener();
            return;
         }
      }

   }

   public void deleteOldAds() {
      this.c.deleteOldAds();
   }

   public void fireReadyEvent() {
      this.a.injectMraidJavaScript("mraid.signalReady();");
   }

   public void fireViewableChange(boolean var1) {
      this.a.injectMraidJavaScript("window.mraidview.fireChangeEvent({viewable:" + var1 + "});");
   }

   public void init(float var1) {
      boolean var3 = false;
      StringBuilder var6 = (new StringBuilder("window.mraidview.fireChangeEvent({ state: \'default\', network: \'")).append(this.f.getNetwork()).append("\', size: ").append(this.d.getSize()).append(", placement: \'").append(this.a.getPlacementType()).append("\', maxSize: ").append(this.d.getMaxSize()).append(",expandProperties: ").append(this.d.getMaxSize()).append(", screenSize: ").append(this.d.getScreenSize()).append(", defaultPosition: { x:").append((int)((float)this.a.getLeft() / var1)).append(", y: ").append((int)((float)this.a.getTop() / var1)).append(", width: ").append((int)((float)this.a.getWidth() / var1)).append(", height: ").append((int)((float)this.a.getHeight() / var1)).append(" }, orientation:").append(this.d.getOrientation()).append(",");
      String var5 = "supports: [ \'level-1\', \'level-2\', \'screen\', \'orientation\', \'network\'";
      boolean var2;
      if(!this.e.allowLocationServices() || this.b.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0 && this.b.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
         var2 = false;
      } else {
         var2 = true;
      }

      if(var2) {
         var5 = "supports: [ \'level-1\', \'level-2\', \'screen\', \'orientation\', \'network\'" + ", \'location\'";
      }

      if(this.b.checkCallingOrSelfPermission("android.permission.SEND_SMS") == 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      String var4 = var5;
      if(var2) {
         var4 = var5 + ", \'sms\'";
      }

      if(this.b.checkCallingOrSelfPermission("android.permission.CALL_PHONE") == 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      var5 = var4;
      if(var2) {
         var5 = var4 + ", \'phone\'";
      }

      var2 = var3;
      if(this.b.checkCallingOrSelfPermission("android.permission.WRITE_CALENDAR") == 0) {
         var2 = var3;
         if(this.b.checkCallingOrSelfPermission("android.permission.READ_CALENDAR") == 0) {
            var2 = var3;
            if(VERSION.SDK_INT >= 14) {
               var2 = true;
            }
         }
      }

      var4 = var5;
      if(var2) {
         var4 = var5 + ", \'calendar\'";
      }

      var4 = var4 + ", \'video\'";
      var4 = var4 + ", \'audio\'";
      var4 = var4 + ", \'map\'";
      var4 = var4 + ", \'email\' ]";
      TapjoyLog.d("MRAID Utility", "getSupports: " + var4);
      var4 = var6.append(var4).append(",viewable:true });").toString();
      Log.d("MRAID Utility", "init: injection: " + var4);
      this.a.injectMraidJavaScript(var4);
      this.fireReadyEvent();
      this.fireViewableChange(true);
   }

   @JavascriptInterface
   public void makeCall(String var1) {
      TapjoyLog.d("MRAID Utility", "makeCall: number: " + var1);
      if(TextUtils.isEmpty(var1)) {
         var1 = null;
      } else {
         StringBuilder var2 = new StringBuilder("tel:");
         var2.append(var1);
         var1 = var2.toString();
      }

      if(var1 == null) {
         this.a.raiseError("Bad Phone Number", "makeCall");
      } else {
         Intent var3 = new Intent("android.intent.action.CALL", Uri.parse(var1.toString()));
         var3.addFlags(268435456);
         this.b.startActivity(var3);
      }
   }

   @JavascriptInterface
   public void mraidCreateEvent(String param1) {
      // $FF: Couldn't be decompiled
   }

   @JavascriptInterface
   public void sendMail(String var1, String var2, String var3) {
      TapjoyLog.d("MRAID Utility", "sendMail: recipient: " + var1 + " subject: " + var2 + " body: " + var3);
      Intent var4 = new Intent("android.intent.action.SEND");
      var4.setType("plain/text");
      var4.putExtra("android.intent.extra.EMAIL", new String[]{var1});
      var4.putExtra("android.intent.extra.SUBJECT", var2);
      var4.putExtra("android.intent.extra.TEXT", var3);
      var4.addFlags(268435456);
      this.b.startActivity(var4);
   }

   @JavascriptInterface
   public void sendSMS(String var1, String var2) {
      TapjoyLog.d("MRAID Utility", "sendSMS: recipient: " + var1 + " body: " + var2);
      Intent var3 = new Intent("android.intent.action.VIEW");
      var3.putExtra("address", var1);
      var3.putExtra("sms_body", var2);
      var3.setType("vnd.android-dir/mms-sms");
      var3.addFlags(268435456);
      this.b.startActivity(var3);
   }

   public void setMaxSize(int var1, int var2) {
      this.d.setMaxSize(var1, var2);
   }

   @JavascriptInterface
   public void showAlert(String var1) {
      TapjoyLog.e("MRAID Utility", var1);
   }

   public void stopAllListeners() {
      try {
         this.c.stopAllListeners();
         this.d.stopAllListeners();
         this.e.stopAllListeners();
         this.f.stopAllListeners();
         this.g.stopAllListeners();
      } catch (Exception var2) {
         ;
      }
   }

   public String writeToDiskWrap(InputStream var1, String var2, boolean var3, String var4, String var5) {
      return this.c.writeToDiskWrap(var1, var2, var3, var4, var5);
   }
}
