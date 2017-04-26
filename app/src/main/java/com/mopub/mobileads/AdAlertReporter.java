package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.view.View;
import com.mopub.common.AdReport;
import com.mopub.common.util.DateAndTime;
import com.mopub.mobileads.util.Base64;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class AdAlertReporter {
   private static final String BODY_SEPARATOR = "\n=================\n";
   private static final String DATE_FORMAT_PATTERN = "M/d/yy hh:mm:ss a z";
   private static final String EMAIL_RECIPIENT = "creative-review@mopub.com";
   private static final String EMAIL_SCHEME = "mailto:";
   private static final int IMAGE_QUALITY = 25;
   private static final String MARKUP_FILENAME = "mp_adalert_markup.html";
   private static final String PARAMETERS_FILENAME = "mp_adalert_parameters.txt";
   private static final String SCREEN_SHOT_FILENAME = "mp_adalert_screenshot.png";
   private final Context mContext;
   private final String mDateString;
   private ArrayList mEmailAttachments;
   private Intent mEmailIntent;
   private String mParameters;
   private String mResponse;
   private final View mView;

   public AdAlertReporter(Context var1, View var2, AdReport var3) {
      this.mView = var2;
      this.mContext = var1;
      this.mEmailAttachments = new ArrayList();
      this.mDateString = (new SimpleDateFormat("M/d/yy hh:mm:ss a z", Locale.US)).format(DateAndTime.now());
      this.initEmailIntent();
      Bitmap var4 = this.takeScreenShot();
      String var5 = this.convertBitmapInWEBPToBase64EncodedString(var4);
      this.mParameters = "";
      this.mResponse = "";
      if(var3 != null) {
         this.mParameters = var3.toString();
         this.mResponse = var3.getResponseString();
      }

      this.addEmailSubject();
      this.addEmailBody(new String[]{this.mParameters, this.mResponse, var5});
      this.addTextAttachment("mp_adalert_parameters.txt", this.mParameters);
      this.addTextAttachment("mp_adalert_markup.html", this.mResponse);
      this.addImageAttachment("mp_adalert_screenshot.png", var4);
   }

   private void addEmailBody(String... var1) {
      StringBuilder var3 = new StringBuilder();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         var3.append(var1[var2]);
         if(var2 != var1.length - 1) {
            var3.append("\n=================\n");
         }
      }

      this.mEmailIntent.putExtra("android.intent.extra.TEXT", var3.toString());
   }

   private void addEmailSubject() {
      this.mEmailIntent.putExtra("android.intent.extra.SUBJECT", "New creative violation report - " + this.mDateString);
   }

   private void addImageAttachment(String param1, Bitmap param2) {
      // $FF: Couldn't be decompiled
   }

   private void addTextAttachment(String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   private String convertBitmapInWEBPToBase64EncodedString(Bitmap var1) {
      String var2 = null;
      if(var1 != null) {
         try {
            ByteArrayOutputStream var4 = new ByteArrayOutputStream();
            var1.compress(CompressFormat.JPEG, 25, var4);
            var2 = Base64.encodeToString(var4.toByteArray(), 0);
         } catch (Exception var3) {
            return null;
         }
      }

      return var2;
   }

   private void initEmailIntent() {
      this.mEmailIntent = new Intent("android.intent.action.SEND_MULTIPLE", Uri.parse("mailto:"));
      this.mEmailIntent.setType("plain/text");
      this.mEmailIntent.putExtra("android.intent.extra.EMAIL", new String[]{"creative-review@mopub.com"});
   }

   private Bitmap takeScreenShot() {
      if(this.mView != null && this.mView.getRootView() != null) {
         View var2 = this.mView.getRootView();
         boolean var1 = var2.isDrawingCacheEnabled();
         var2.setDrawingCacheEnabled(true);
         Bitmap var3 = var2.getDrawingCache();
         if(var3 != null) {
            var3 = Bitmap.createBitmap(var3);
            var2.setDrawingCacheEnabled(var1);
            return var3;
         }
      }

      return null;
   }

   @Deprecated
   ArrayList getEmailAttachments() {
      return this.mEmailAttachments;
   }

   @Deprecated
   Intent getEmailIntent() {
      return this.mEmailIntent;
   }

   @Deprecated
   String getParameters() {
      return this.mParameters;
   }

   @Deprecated
   String getResponse() {
      return this.mResponse;
   }

   public void send() {
      this.mEmailIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.mEmailAttachments);
      Intent var1 = Intent.createChooser(this.mEmailIntent, "Send Email...");
      var1.addFlags(268435456);
      this.mContext.startActivity(var1);
   }
}
