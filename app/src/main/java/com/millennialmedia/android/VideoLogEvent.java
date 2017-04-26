package com.millennialmedia.android;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.millennialmedia.android.MMLog;
import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.json.JSONArray;
import org.json.JSONObject;

class VideoLogEvent implements Parcelable, Externalizable {
   public static final Creator CREATOR = new Creator() {
      public final VideoLogEvent createFromParcel(Parcel var1) {
         return new VideoLogEvent(var1);
      }

      public final VideoLogEvent[] newArray(int var1) {
         return new VideoLogEvent[var1];
      }
   };
   private static final String TAG = VideoLogEvent.class.getName();
   static final long serialVersionUID = 795553873017368584L;
   String[] activities;
   long position;

   public VideoLogEvent() {
   }

   VideoLogEvent(Parcel var1) {
      try {
         this.position = var1.readLong();
         this.activities = new String[var1.readInt()];
         var1.readStringArray(this.activities);
      } catch (Exception var2) {
         MMLog.e(TAG, "VideoLogEvent parcel creation exception: ", var2);
      }
   }

   VideoLogEvent(JSONObject var1) {
      this.deserializeFromObj(var1);
   }

   private void deserializeFromObj(JSONObject var1) {
      int var2 = 0;
      if(var1 != null) {
         this.position = (long)(var1.optInt("time") * 1000);
         JSONArray var3 = var1.optJSONArray("urls");
         if(var3 == null) {
            this.activities = new String[0];
            return;
         }

         for(this.activities = new String[var3.length()]; var2 < var3.length(); ++var2) {
            this.activities[var2] = var3.optString(var2);
         }
      }

   }

   public int describeContents() {
      return 0;
   }

   public void readExternal(ObjectInput var1) {
      this.position = var1.readLong();
      int var3 = var1.readInt();
      this.activities = new String[var3];

      for(int var2 = 0; var2 < var3; ++var2) {
         this.activities[var2] = (String)var1.readObject();
      }

   }

   public void writeExternal(ObjectOutput var1) {
      var1.writeLong(this.position);
      var1.writeInt(this.activities.length);
      String[] var4 = this.activities;
      int var3 = var4.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         var1.writeObject(var4[var2]);
      }

   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeLong(this.position);
      var1.writeInt(this.activities.length);
      var1.writeStringArray(this.activities);
   }
}
