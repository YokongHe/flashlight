package com.mopub.mraid;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.Intents;
import com.mopub.common.util.Utils;
import com.mopub.common.util.VersionCode;
import com.mopub.mraid.MraidCommandException;
import com.mopub.mraid.MraidNativeCommandHandler$DownloadImageAsyncTask;
import com.mopub.mraid.MraidNativeCommandHandler$DownloadImageAsyncTask$DownloadImageAsyncTaskListener;
import com.mopub.mraid.MraidNativeCommandHandler$MraidCommandFailureListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MraidNativeCommandHandler {
   public static final String ANDROID_CALENDAR_CONTENT_TYPE = "vnd.android.cursor.item/event";
   private static final String[] DATE_FORMATS = new String[]{"yyyy-MM-dd\'T\'HH:mm:ssZZZZZ", "yyyy-MM-dd\'T\'HH:mmZZZZZ"};
   private static final int MAX_NUMBER_DAYS_IN_MONTH = 31;
   @VisibleForTesting
   static final String MIME_TYPE_HEADER = "Content-Type";

   private String dayNumberToDayOfMonthString(int var1) {
      if(var1 != 0 && var1 >= -31 && var1 <= 31) {
         return "" + var1;
      } else {
         throw new IllegalArgumentException("invalid day of month " + var1);
      }
   }

   private String dayNumberToDayOfWeekString(int var1) {
      switch(var1) {
      case 0:
         return "SU";
      case 1:
         return "MO";
      case 2:
         return "TU";
      case 3:
         return "WE";
      case 4:
         return "TH";
      case 5:
         return "FR";
      case 6:
         return "SA";
      default:
         throw new IllegalArgumentException("invalid day of week " + var1);
      }
   }

   static boolean isCalendarAvailable(Context var0) {
      Intent var1 = (new Intent("android.intent.action.INSERT")).setType("vnd.android.cursor.item/event");
      return VersionCode.currentApiLevel().isAtLeast(VersionCode.ICE_CREAM_SANDWICH) && Intents.deviceCanHandleIntent(var0, var1);
   }

   public static boolean isStorePictureSupported(Context var0) {
      return "mounted".equals(Environment.getExternalStorageState()) && var0.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
   }

   private Date parseDate(String var1) {
      String[] var6 = DATE_FORMATS;
      int var3 = var6.length;
      Date var4 = null;
      int var2 = 0;

      Date var8;
      while(true) {
         if(var2 >= var3) {
            var8 = var4;
            break;
         }

         String var5 = var6[var2];

         label19: {
            try {
               var8 = (new SimpleDateFormat(var5, Locale.US)).parse(var1);
            } catch (ParseException var7) {
               break label19;
            }

            var4 = var8;
            var8 = var8;
            if(var4 != null) {
               break;
            }
         }

         ++var2;
      }

      return var8;
   }

   private String parseRecurrenceRule(Map var1) {
      StringBuilder var3 = new StringBuilder();
      if(var1.containsKey("frequency")) {
         String var4 = (String)var1.get("frequency");
         int var2;
         if(var1.containsKey("interval")) {
            var2 = Integer.parseInt((String)var1.get("interval"));
         } else {
            var2 = -1;
         }

         if("daily".equals(var4)) {
            var3.append("FREQ=DAILY;");
            if(var2 != -1) {
               var3.append("INTERVAL=" + var2 + ";");
            }
         } else {
            String var5;
            if("weekly".equals(var4)) {
               var3.append("FREQ=WEEKLY;");
               if(var2 != -1) {
                  var3.append("INTERVAL=" + var2 + ";");
               }

               if(var1.containsKey("daysInWeek")) {
                  var5 = this.translateWeekIntegersToDays((String)var1.get("daysInWeek"));
                  if(var5 == null) {
                     throw new IllegalArgumentException("invalid ");
                  }

                  var3.append("BYDAY=" + var5 + ";");
               }
            } else {
               if(!"monthly".equals(var4)) {
                  throw new IllegalArgumentException("frequency is only supported for daily, weekly, and monthly.");
               }

               var3.append("FREQ=MONTHLY;");
               if(var2 != -1) {
                  var3.append("INTERVAL=" + var2 + ";");
               }

               if(var1.containsKey("daysInMonth")) {
                  var5 = this.translateMonthIntegersToDays((String)var1.get("daysInMonth"));
                  if(var5 == null) {
                     throw new IllegalArgumentException();
                  }

                  var3.append("BYMONTHDAY=" + var5 + ";");
               }
            }
         }
      }

      return var3.toString();
   }

   private void showUserDialog(final Context var1, final String var2, final MraidNativeCommandHandler$MraidCommandFailureListener var3) {
      (new Builder(var1)).setTitle("Save Image").setMessage("Download image to Picture gallery?").setNegativeButton("Cancel", (OnClickListener)null).setPositiveButton("Okay", new OnClickListener() {
         public void onClick(DialogInterface var1x, int var2x) {
            MraidNativeCommandHandler.this.downloadImage(var1, var2, var3);
         }
      }).setCancelable(true).show();
   }

   @TargetApi(14)
   private Map translateJSParamsToAndroidCalendarEventMapping(Map var1) {
      HashMap var3 = new HashMap();
      if(var1.containsKey("description") && var1.containsKey("start")) {
         var3.put("title", var1.get("description"));
         if(var1.containsKey("start") && var1.get("start") != null) {
            Date var4 = this.parseDate((String)var1.get("start"));
            if(var4 != null) {
               var3.put("beginTime", Long.valueOf(var4.getTime()));
               if(var1.containsKey("end") && var1.get("end") != null) {
                  var4 = this.parseDate((String)var1.get("end"));
                  if(var4 == null) {
                     throw new IllegalArgumentException("Invalid calendar event: end time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
                  }

                  var3.put("endTime", Long.valueOf(var4.getTime()));
               }

               if(var1.containsKey("location")) {
                  var3.put("eventLocation", var1.get("location"));
               }

               if(var1.containsKey("summary")) {
                  var3.put("description", var1.get("summary"));
               }

               if(var1.containsKey("transparency")) {
                  byte var2;
                  if(((String)var1.get("transparency")).equals("transparent")) {
                     var2 = 1;
                  } else {
                     var2 = 0;
                  }

                  var3.put("availability", Integer.valueOf(var2));
               }

               var3.put("rrule", this.parseRecurrenceRule(var1));
               return var3;
            } else {
               throw new IllegalArgumentException("Invalid calendar event: start time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
            }
         } else {
            throw new IllegalArgumentException("Invalid calendar event: start is null.");
         }
      } else {
         throw new IllegalArgumentException("Missing start and description fields");
      }
   }

   private String translateMonthIntegersToDays(String var1) {
      StringBuilder var5 = new StringBuilder();
      boolean[] var6 = new boolean[63];
      String[] var7 = var1.split(",");
      int var3 = var7.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         int var4 = Integer.parseInt(var7[var2]);
         if(!var6[var4 + 31]) {
            var5.append(this.dayNumberToDayOfMonthString(var4) + ",");
            var6[var4 + 31] = true;
         }
      }

      if(var7.length == 0) {
         throw new IllegalArgumentException("must have at least 1 day of the month if specifying repeating weekly");
      } else {
         var5.deleteCharAt(var5.length() - 1);
         return var5.toString();
      }
   }

   private String translateWeekIntegersToDays(String var1) {
      StringBuilder var6 = new StringBuilder();
      boolean[] var7 = new boolean[7];
      String[] var8 = var1.split(",");
      int var5 = var8.length;

      for(int var2 = 0; var2 < var5; ++var2) {
         int var4 = Integer.parseInt(var8[var2]);
         int var3 = var4;
         if(var4 == 7) {
            var3 = 0;
         }

         if(!var7[var3]) {
            var6.append(this.dayNumberToDayOfWeekString(var3) + ",");
            var7[var3] = true;
         }
      }

      if(var8.length == 0) {
         throw new IllegalArgumentException("must have at least 1 day of the week if specifying repeating weekly");
      } else {
         var6.deleteCharAt(var6.length() - 1);
         return var6.toString();
      }
   }

   void createCalendarEvent(Context param1, Map param2) {
      // $FF: Couldn't be decompiled
   }

   void downloadImage(final Context var1, String var2, final MraidNativeCommandHandler$MraidCommandFailureListener var3) {
      AsyncTasks.safeExecuteOnExecutor(new MraidNativeCommandHandler$DownloadImageAsyncTask(var1, new MraidNativeCommandHandler$DownloadImageAsyncTask$DownloadImageAsyncTaskListener() {
         public void onFailure() {
            Toast.makeText(var1, "Image failed to download.", 0).show();
            MoPubLog.d("Error downloading and saving image file.");
            var3.onFailure(new MraidCommandException("Error downloading and saving image file."));
         }

         public void onSuccess() {
            MoPubLog.d("Image successfully saved.");
         }
      }), new String[]{var2});
   }

   @TargetApi(11)
   boolean isInlineVideoAvailable(Activity var1, View var2) {
      if(VersionCode.currentApiLevel().isBelow(VersionCode.HONEYCOMB_MR1)) {
         return false;
      } else {
         while(var2.isHardwareAccelerated() && !Utils.bitMaskContainsFlag(var2.getLayerType(), 1)) {
            if(!(var2.getParent() instanceof View)) {
               Window var3 = var1.getWindow();
               if(var3 != null && Utils.bitMaskContainsFlag(var3.getAttributes().flags, 16777216)) {
                  return true;
               }

               return false;
            }

            var2 = (View)var2.getParent();
         }

         return false;
      }
   }

   boolean isSmsAvailable(Context var1) {
      Intent var2 = new Intent("android.intent.action.VIEW");
      var2.setData(Uri.parse("sms:"));
      return Intents.deviceCanHandleIntent(var1, var2);
   }

   boolean isTelAvailable(Context var1) {
      Intent var2 = new Intent("android.intent.action.DIAL");
      var2.setData(Uri.parse("tel:"));
      return Intents.deviceCanHandleIntent(var1, var2);
   }

   void storePicture(Context var1, String var2, MraidNativeCommandHandler$MraidCommandFailureListener var3) {
      if(!isStorePictureSupported(var1)) {
         MoPubLog.d("Error downloading file - the device does not have an SD card mounted, or the Android permission is not granted.");
         throw new MraidCommandException("Error downloading file  - the device does not have an SD card mounted, or the Android permission is not granted.");
      } else if(var1 instanceof Activity) {
         this.showUserDialog(var1, var2, var3);
      } else {
         Toast.makeText(var1, "Downloading image to Picture gallery...", 0).show();
         this.downloadImage(var1, var2, var3);
      }
   }
}
