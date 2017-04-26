package com.millennialmedia.android;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.json.JSONArray;
import org.json.JSONObject;

class VideoImage implements Parcelable, Externalizable {
   public static final Creator CREATOR = new Creator() {
      public final VideoImage createFromParcel(Parcel var1) {
         return new VideoImage(var1);
      }

      public final VideoImage[] newArray(int var1) {
         return new VideoImage[var1];
      }
   };
   private static final String TAG = VideoImage.class.getName();
   static final long serialVersionUID = 808334584720834205L;
   int anchor;
   int anchor2;
   long appearanceDelay;
   ImageButton button;
   long contentLength;
   String[] eventLoggingUrls;
   long fadeDuration = 1000L;
   float fromAlpha = 1.0F;
   String imageUrl;
   long inactivityTimeout;
   boolean isLeaveBehind;
   LayoutParams layoutParams;
   String linkUrl;
   String overlayOrientation;
   int paddingBottom = 0;
   int paddingLeft = 0;
   int paddingRight = 0;
   int paddingTop = 0;
   int position;
   int position2;
   float toAlpha = 1.0F;

   public VideoImage() {
   }

   VideoImage(Parcel param1) {
      // $FF: Couldn't be decompiled
   }

   VideoImage(JSONObject var1) {
      this.deserializeFromObj(var1);
   }

   private void deserializeFromObj(JSONObject var1) {
      int var2 = 0;
      if(var1 != null) {
         this.imageUrl = var1.optString("image", (String)null);
         this.contentLength = var1.optLong("contentLength");
         JSONArray var3 = var1.optJSONArray("activity");
         if(var3 != null) {
            for(this.eventLoggingUrls = new String[var3.length()]; var2 < var3.length(); ++var2) {
               this.eventLoggingUrls[var2] = var3.optString(var2);
            }
         } else {
            this.eventLoggingUrls = new String[0];
         }

         this.linkUrl = var1.optString("url", (String)null);
         this.overlayOrientation = var1.optString("overlayOrientation", (String)null);
         this.position = var1.optInt("android-layout");
         this.anchor = var1.optInt("android-layoutAnchor");
         this.position2 = var1.optInt("android-layout2");
         this.anchor2 = var1.optInt("android-layoutAnchor2");
         this.paddingTop = var1.optInt("android-paddingTop");
         this.paddingLeft = var1.optInt("android-paddingLeft");
         this.paddingRight = var1.optInt("android-paddingRight");
         this.paddingBottom = var1.optInt("android-paddingBottom");
         this.appearanceDelay = (long)(var1.optDouble("appearanceDelay", 0.0D) * 1000.0D);
         this.inactivityTimeout = (long)(var1.optDouble("inactivityTimeout", 0.0D) * 1000.0D);
         JSONObject var4 = var1.optJSONObject("opacity");
         if(var4 != null) {
            this.fromAlpha = (float)var4.optDouble("start", 1.0D);
            this.toAlpha = (float)var4.optDouble("end", 1.0D);
            this.fadeDuration = (long)(var4.optDouble("fadeDuration", 1.0D) * 1000.0D);
         }

         this.isLeaveBehind = var1.optBoolean("is_leavebehind");
      }
   }

   public int describeContents() {
      return 0;
   }

   String getImageName() {
      if(this.imageUrl != null) {
         Uri var1 = Uri.parse(this.imageUrl);
         if(var1 != null && var1.getLastPathSegment() != null) {
            return var1.getLastPathSegment().replaceFirst("\\.[^\\.]*$", ".dat");
         }
      }

      return null;
   }

   public void readExternal(ObjectInput var1) {
      this.imageUrl = (String)var1.readObject();
      this.contentLength = var1.readLong();
      int var3 = var1.readInt();
      this.eventLoggingUrls = new String[var3];

      for(int var2 = 0; var2 < var3; ++var2) {
         this.eventLoggingUrls[var2] = (String)var1.readObject();
      }

      this.linkUrl = (String)var1.readObject();
      this.overlayOrientation = (String)var1.readObject();
      this.paddingTop = var1.readInt();
      this.paddingBottom = var1.readInt();
      this.paddingLeft = var1.readInt();
      this.paddingRight = var1.readInt();
      this.position = var1.readInt();
      this.anchor = var1.readInt();
      this.position2 = var1.readInt();
      this.anchor2 = var1.readInt();
      this.appearanceDelay = var1.readLong();
      this.inactivityTimeout = var1.readLong();
      this.fromAlpha = var1.readFloat();
      this.toAlpha = var1.readFloat();
      this.fadeDuration = var1.readLong();
      this.isLeaveBehind = var1.readBoolean();
   }

   public void writeExternal(ObjectOutput var1) {
      var1.writeObject(this.imageUrl);
      var1.writeLong(this.contentLength);
      var1.writeInt(this.eventLoggingUrls.length);
      String[] var4 = this.eventLoggingUrls;
      int var3 = var4.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         var1.writeObject(var4[var2]);
      }

      var1.writeObject(this.linkUrl);
      var1.writeObject(this.overlayOrientation);
      var1.writeInt(this.paddingTop);
      var1.writeInt(this.paddingBottom);
      var1.writeInt(this.paddingLeft);
      var1.writeInt(this.paddingRight);
      var1.writeInt(this.position);
      var1.writeInt(this.anchor);
      var1.writeInt(this.position2);
      var1.writeInt(this.anchor2);
      var1.writeLong(this.appearanceDelay);
      var1.writeLong(this.inactivityTimeout);
      var1.writeFloat(this.fromAlpha);
      var1.writeFloat(this.toAlpha);
      var1.writeLong(this.fadeDuration);
      var1.writeBoolean(this.isLeaveBehind);
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.imageUrl);
      var1.writeLong(this.contentLength);
      var1.writeInt(this.eventLoggingUrls.length);
      var1.writeStringArray(this.eventLoggingUrls);
      var1.writeString(this.linkUrl);
      var1.writeString(this.overlayOrientation);
      var1.writeInt(this.paddingTop);
      var1.writeInt(this.paddingBottom);
      var1.writeInt(this.paddingLeft);
      var1.writeInt(this.paddingRight);
      var1.writeInt(this.position);
      var1.writeInt(this.anchor);
      var1.writeInt(this.position2);
      var1.writeInt(this.anchor2);
      var1.writeLong(this.appearanceDelay);
      var1.writeLong(this.inactivityTimeout);
      var1.writeFloat(this.fromAlpha);
      var1.writeFloat(this.toAlpha);
      var1.writeLong(this.fadeDuration);
      byte var3;
      if(this.isLeaveBehind) {
         var3 = 1;
      } else {
         var3 = 0;
      }

      var1.writeInt(var3);
   }
}
