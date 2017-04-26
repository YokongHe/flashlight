package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.millennialmedia.android.CachedAd;
import com.millennialmedia.android.HandShake;
import com.millennialmedia.android.HttpMMHeaders;
import com.millennialmedia.android.MMAdImpl;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.OverlaySettings;
import com.millennialmedia.android.Utils$IntentUtils;
import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;

class InterstitialAd extends CachedAd implements Parcelable, Externalizable {
   public static final Creator CREATOR = new Creator() {
      public final InterstitialAd createFromParcel(Parcel var1) {
         return new InterstitialAd(var1);
      }

      public final InterstitialAd[] newArray(int var1) {
         return new InterstitialAd[var1];
      }
   };
   static final String EXTRA_AD_URL = "EXTRA_AD_URL";
   static final String EXTRA_CONTENT = "EXTRA_CONTENT";
   private static final String TAG = InterstitialAd.class.getName();
   static final long serialVersionUID = 5158660334173309853L;
   String adUrl;
   String content;
   HttpMMHeaders mmHeaders;

   public InterstitialAd() {
   }

   InterstitialAd(Parcel var1) {
      super(var1);

      try {
         this.content = var1.readString();
         this.adUrl = var1.readString();
         this.mmHeaders = (HttpMMHeaders)var1.readParcelable(HttpMMHeaders.class.getClassLoader());
      } catch (Exception var2) {
         MMLog.e(TAG, "Interstitial problem reading parcel: ", var2);
      }
   }

   private Intent getExpandExtrasIntent(Context var1, long var2) {
      Intent var5 = new Intent();
      OverlaySettings var4 = new OverlaySettings();
      var4.creatorAdImplId = var2;
      var4.content = this.content;
      var4.adUrl = this.adUrl;
      var4.setWebMMHeaders(this.mmHeaders);
      var4.isFromInterstitial = true;
      var5.putExtra("settings", var4);
      var5.putExtra("internalId", var2);
      return var5;
   }

   boolean canShow(Context var1, MMAdImpl var2, boolean var3) {
      if(var3) {
         if(this.content == null || this.content.length() <= 0 || this.adUrl == null || this.adUrl.length() <= 0 || !HandShake.sharedHandShake(var1).canDisplayCachedAd(var2.adType, this.deferredViewStart)) {
            return false;
         }
      } else if(this.content == null || this.content.length() <= 0 || this.adUrl == null || this.adUrl.length() <= 0) {
         return false;
      }

      return true;
   }

   public int describeContents() {
      return 0;
   }

   boolean download(Context var1) {
      return true;
   }

   int getType() {
      return 2;
   }

   String getTypeString() {
      return "Interstitial";
   }

   boolean isOnDisk(Context var1) {
      return true;
   }

   public void readExternal(ObjectInput var1) {
      super.readExternal(var1);
      this.content = (String)var1.readObject();
      this.adUrl = (String)var1.readObject();
      this.mmHeaders = (HttpMMHeaders)var1.readObject();
   }

   boolean saveAssets(Context var1) {
      return true;
   }

   void show(Context var1, long var2) {
      Utils$IntentUtils.startAdViewOverlayActivity(var1, this.getExpandExtrasIntent(var1, var2));
   }

   public void writeExternal(ObjectOutput var1) {
      super.writeExternal(var1);
      var1.writeObject(this.content);
      var1.writeObject(this.adUrl);
      var1.writeObject(this.mmHeaders);
   }

   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      var1.writeString(this.content);
      var1.writeString(this.adUrl);
      var1.writeParcelable(this.mmHeaders, var2);
   }
}
