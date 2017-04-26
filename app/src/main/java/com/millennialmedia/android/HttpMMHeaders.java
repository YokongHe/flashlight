package com.millennialmedia.android;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.millennialmedia.android.MMLog;
import java.io.Serializable;
import java.util.Map;
import org.apache.http.Header;

class HttpMMHeaders implements Parcelable, Serializable {
   public static final Creator CREATOR = new Creator() {
      public final HttpMMHeaders createFromParcel(Parcel var1) {
         return new HttpMMHeaders(var1);
      }

      public final HttpMMHeaders[] newArray(int var1) {
         return new HttpMMHeaders[var1];
      }
   };
   private static final String HEADER_MM_ACID = "X-MM-ACID";
   private static final String HEADER_MM_CUSTOM_CLOSE = "X-MM-USE-CUSTOM-CLOSE";
   private static final String HEADER_MM_ENABLE_HARDWARE_ACCEL = "X-MM-ENABLE-HARDWARE-ACCELERATION";
   private static final String HEADER_MM_TRANSITION = "X-MM-TRANSITION";
   private static final String HEADER_MM_TRANSITION_DURATION = "X-MM-TRANSITION-DURATION";
   private static final String HEADER_MM_TRANSPARENT = "X-MM-TRANSPARENT";
   private static final String TAG = HttpMMHeaders.class.getName();
   static final long serialVersionUID = 3168621112125974L;
   String acid;
   boolean enableHardwareAccel;
   boolean isTransparent;
   String transition;
   long transitionTimeInMillis;
   boolean useCustomClose;

   public HttpMMHeaders(Parcel var1) {
      try {
         boolean[] var2 = new boolean[3];
         var1.readBooleanArray(var2);
         this.isTransparent = var2[0];
         this.useCustomClose = var2[1];
         this.enableHardwareAccel = var2[2];
         this.transition = var1.readString();
         this.acid = var1.readString();
         this.transitionTimeInMillis = var1.readLong();
      } catch (Exception var3) {
         MMLog.e(TAG, "Header serializing failed", var3);
      }
   }

   public HttpMMHeaders(Header[] var1) {
      int var3 = var1.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         Header var4 = var1[var2];
         this.checkTransparent(var4);
         this.checkTransition(var4);
         this.checkTransitionDuration(var4);
         this.checkUseCustomClose(var4);
         this.checkEnableHardwareAccel(var4);
         this.checkAcid(var4);
      }

   }

   private void checkAcid(Header var1) {
      if("X-MM-ACID".equalsIgnoreCase(var1.getName())) {
         this.acid = var1.getValue();
      }

   }

   private void checkEnableHardwareAccel(Header var1) {
      if("X-MM-ENABLE-HARDWARE-ACCELERATION".equalsIgnoreCase(var1.getName())) {
         this.enableHardwareAccel = Boolean.parseBoolean(var1.getValue());
      }

   }

   private void checkTransition(Header var1) {
      if("X-MM-TRANSITION".equalsIgnoreCase(var1.getName())) {
         this.transition = var1.getValue();
      }

   }

   private void checkTransitionDuration(Header var1) {
      if("X-MM-TRANSITION-DURATION".equalsIgnoreCase(var1.getName())) {
         String var2 = var1.getValue();
         if(var2 != null) {
            this.transitionTimeInMillis = (long)(Float.parseFloat(var2) * 1000.0F);
         }
      }

   }

   private void checkTransparent(Header var1) {
      if("X-MM-TRANSPARENT".equalsIgnoreCase(var1.getName())) {
         String var2 = var1.getValue();
         if(var2 != null) {
            this.isTransparent = Boolean.parseBoolean(var2);
         }
      }

   }

   private void checkUseCustomClose(Header var1) {
      if("X-MM-USE-CUSTOM-CLOSE".equalsIgnoreCase(var1.getName())) {
         this.useCustomClose = Boolean.parseBoolean(var1.getValue());
      }

   }

   public int describeContents() {
      return 0;
   }

   void updateArgumentsWithSettings(Map var1) {
      var1.put("transparent", String.valueOf(this.isTransparent));
      var1.put("transition", String.valueOf(this.transition));
      var1.put("acid", String.valueOf(this.acid));
      var1.put("transitionDuration", String.valueOf(this.transitionTimeInMillis));
      var1.put("useCustomClose", String.valueOf(this.useCustomClose));
      var1.put("enableHardwareAccel", String.valueOf(this.enableHardwareAccel));
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeBooleanArray(new boolean[]{this.isTransparent, this.useCustomClose, this.enableHardwareAccel});
      var1.writeString(this.transition);
      var1.writeString(this.acid);
      var1.writeLong(this.transitionTimeInMillis);
   }
}
