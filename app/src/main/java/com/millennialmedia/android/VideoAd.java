package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.millennialmedia.android.AdCache;
import com.millennialmedia.android.CachedAd;
import com.millennialmedia.android.DTOCachedVideo;
import com.millennialmedia.android.HandShake;
import com.millennialmedia.android.HttpGetRequest;
import com.millennialmedia.android.HttpRedirection$RedirectionListenerImpl;
import com.millennialmedia.android.MMAdImpl;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.MMSDK$Event;
import com.millennialmedia.android.Utils$IntentUtils;
import com.millennialmedia.android.VideoAd$VideoFilenameFilter;
import com.millennialmedia.android.VideoAd$VideoIterator;
import com.millennialmedia.android.VideoImage;
import com.millennialmedia.android.VideoLogEvent;
import java.io.Externalizable;
import java.io.File;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class VideoAd extends CachedAd implements Parcelable, Externalizable {
   public static final Creator CREATOR = new Creator() {
      public final VideoAd createFromParcel(Parcel var1) {
         return new VideoAd(var1);
      }

      public final VideoAd[] newArray(int var1) {
         return new VideoAd[var1];
      }
   };
   private static final String TAG = "VideoAd";
   static final String VIDEO_FILE_ID = "video.dat";
   static final long serialVersionUID = 2679125946930815832L;
   ArrayList activities = new ArrayList();
   ArrayList buttons = new ArrayList();
   String[] cacheComplete;
   String[] cacheFailed;
   String cacheMissURL;
   DTOCachedVideo cachedVideoDto;
   long closeDelayMillis;
   long contentLength;
   long duration;
   String[] endActivity;
   String endOverlayURL;
   String onCompletionUrl;
   boolean reloadNonEndOverlayOnRestart;
   boolean showControls;
   boolean showCountdown;
   String[] startActivity;
   boolean stayInPlayer;
   boolean usingInternalStorage;
   String[] videoError;
   private String videoFileId;
   String webOverlayURL;

   public VideoAd() {
   }

   VideoAd(Parcel var1) {
      super(var1);

      try {
         this.startActivity = new String[var1.readInt()];
         var1.readStringArray(this.startActivity);
         this.endActivity = new String[var1.readInt()];
         var1.readStringArray(this.endActivity);
         boolean[] var2 = new boolean[5];
         var1.readBooleanArray(var2);
         this.showControls = var2[0];
         this.stayInPlayer = var2[1];
         this.showCountdown = var2[2];
         this.reloadNonEndOverlayOnRestart = var2[3];
         this.usingInternalStorage = var2[4];
         this.onCompletionUrl = var1.readString();
         this.webOverlayURL = var1.readString();
         this.endOverlayURL = var1.readString();
         this.cacheMissURL = var1.readString();
         this.videoFileId = var1.readString();
         this.duration = var1.readLong();
         this.contentLength = var1.readLong();
         this.closeDelayMillis = var1.readLong();
         this.buttons = var1.readArrayList(VideoImage.class.getClassLoader());
         this.activities = var1.readArrayList(VideoLogEvent.class.getClassLoader());
         this.cacheComplete = new String[var1.readInt()];
         var1.readStringArray(this.cacheComplete);
         this.cacheFailed = new String[var1.readInt()];
         var1.readStringArray(this.cacheFailed);
         this.videoError = new String[var1.readInt()];
         var1.readStringArray(this.videoError);
      } catch (Exception var3) {
         MMLog.e("VideoAd", "Exception with videoad parcel creation: ", var3);
      }
   }

   VideoAd(String var1) {
      if(var1 != null) {
         JSONObject var3;
         try {
            var3 = new JSONObject(var1);
         } catch (JSONException var2) {
            MMLog.e("VideoAd", "VideoAd json exception: ", var2);
            var3 = null;
         }

         if(var3 != null) {
            var3 = var3.optJSONObject("video");
            if(var3 != null) {
               this.deserializeFromObj(var3);
            }
         }
      }

   }

   // $FF: synthetic method
   static String access$000(VideoAd var0) {
      return var0.videoFileId;
   }

   static boolean downloadVideoFile(Context var0, String var1, String var2) {
      boolean var3 = AdCache.downloadComponentExternalStorage(var1, var2 + "video.dat", var0);
      MMLog.v("VideoAd", String.format("Caching completed successfully (" + var2 + "video.dat)? %b", new Object[]{Boolean.valueOf(var3)}));
      return var3;
   }

   static Uri getVideoUri(Context var0, String var1) {
      return Uri.fromFile(AdCache.getDownloadFile(var0, var1 + "video.dat"));
   }

   private void handleSharedVideoFile(Context var1) {
      AdCache.iterateCachedAds(var1, 2, new VideoAd$VideoIterator(var1, this));
   }

   static boolean hasVideoFile(Context var0, String var1) {
      return AdCache.hasDownloadFile(var0, var1 + "video.dat");
   }

   static void playAd(Context var0, String var1, HttpRedirection$RedirectionListenerImpl var2) {
      if(var1 != null) {
         VideoAd var3 = (VideoAd)AdCache.load(var0, var1);
         if(var3 == null || !var3.canShow(var0, (MMAdImpl)null, false)) {
            MMLog.w("VideoAd", String.format("mmvideo: Ad %s cannot be shown at this time.", new Object[]{var1}));
            return;
         }

         var2.updateLastVideoViewedTime();
         MMLog.v("VideoAd", String.format("mmvideo: attempting to play video %s", new Object[]{var1}));
         var3.show(var0, var2.creatorAdImplInternalId);
         var2.startingVideo();
      }

   }

   boolean canShow(Context var1, MMAdImpl var2, boolean var3) {
      if(var3) {
         if(this.isExpired() || !this.isOnDisk(var1) || !HandShake.sharedHandShake(var1).canDisplayCachedAd(var2.adType, this.deferredViewStart)) {
            return false;
         }
      } else if(this.isExpired() || !this.isOnDisk(var1)) {
         return false;
      }

      return true;
   }

   void delete(Context var1) {
      super.delete(var1);
      this.handleSharedVideoFile(var1);
      AdCache.cachedVideoWasRemoved(var1, this.acid);
      MMLog.v("VideoAd", String.format("Ad %s was deleted.", new Object[]{this.getId()}));
   }

   public int describeContents() {
      return 0;
   }

   protected void deserializeFromObj(JSONObject var1) {
      byte var3 = 0;
      super.deserializeFromObj(var1);
      JSONArray var4 = var1.optJSONArray("startActivity");
      this.webOverlayURL = var1.optString("overlayURL", (String)null);
      this.endOverlayURL = var1.optString("endURL", (String)null);
      this.cacheMissURL = var1.optString("cacheMissURL", (String)null);
      this.videoFileId = var1.optString("videoFileId", (String)null);
      int var2;
      if(var4 != null) {
         this.startActivity = new String[var4.length()];

         for(var2 = 0; var2 < var4.length(); ++var2) {
            this.startActivity[var2] = var4.optString(var2);
         }
      } else {
         this.startActivity = new String[0];
      }

      var4 = var1.optJSONArray("endActivity");
      if(var4 != null) {
         this.endActivity = new String[var4.length()];

         for(var2 = 0; var2 < var4.length(); ++var2) {
            this.endActivity[var2] = var4.optString(var2);
         }
      } else {
         this.endActivity = new String[0];
      }

      var4 = var1.optJSONArray("cacheComplete");
      if(var4 != null) {
         this.cacheComplete = new String[var4.length()];

         for(var2 = 0; var2 < var4.length(); ++var2) {
            this.cacheComplete[var2] = var4.optString(var2);
         }
      } else {
         this.cacheComplete = new String[0];
      }

      var4 = var1.optJSONArray("cacheFailed");
      if(var4 != null) {
         this.cacheFailed = new String[var4.length()];

         for(var2 = 0; var2 < var4.length(); ++var2) {
            this.cacheFailed[var2] = var4.optString(var2);
         }
      } else {
         this.cacheFailed = new String[0];
      }

      var4 = var1.optJSONArray("videoError");
      if(var4 != null) {
         this.videoError = new String[var4.length()];

         for(var2 = 0; var2 < var4.length(); ++var2) {
            this.videoError[var2] = var4.optString(var2);
         }
      } else {
         this.videoError = new String[0];
      }

      this.showControls = var1.optBoolean("showVideoPlayerControls");
      this.showCountdown = var1.optBoolean("showCountdownHUD");
      this.reloadNonEndOverlayOnRestart = var1.optBoolean("reloadOverlayOnRestart");
      JSONObject var8 = var1.optJSONObject("onCompletion");
      if(var8 != null) {
         this.onCompletionUrl = var8.optString("url", (String)null);
         this.stayInPlayer = var8.optBoolean("stayInPlayer");
      }

      this.duration = (long)(var1.optDouble("duration", 0.0D) * 1000.0D);
      this.contentLength = var1.optLong("contentLength");
      this.closeDelayMillis = var1.optLong("closeAfterDelay");
      var4 = var1.optJSONArray("buttons");
      if(var4 != null) {
         for(var2 = 0; var2 < var4.length(); ++var2) {
            JSONObject var5 = var4.optJSONObject(var2);
            if(var5 != null) {
               VideoImage var7 = new VideoImage(var5);
               this.buttons.add(var7);
            }
         }
      }

      JSONArray var6 = var1.optJSONArray("log");
      if(var6 != null) {
         for(var2 = var3; var2 < var6.length(); ++var2) {
            var8 = var6.optJSONObject(var2);
            if(var8 != null) {
               VideoLogEvent var9 = new VideoLogEvent(var8);
               this.activities.add(var9);
            }
         }
      }

   }

   boolean download(Context var1) {
      boolean var4 = AdCache.downloadComponentExternalStorage(this.contentUrl, this.videoFileId + "video.dat", var1);
      boolean var3 = var4;
      if(var4) {
         int var2 = 0;

         for(var3 = var4; var2 < this.buttons.size(); ++var2) {
            VideoImage var5 = (VideoImage)this.buttons.get(var2);
            var3 = AdCache.downloadComponentInternalCache(var5.imageUrl, this.getId() + var5.getImageName(), var1);
            if(!var3) {
               break;
            }
         }
      }

      if(!var3) {
         if(this.downloadAllOrNothing) {
            this.delete(var1);
         }

         HttpGetRequest.log(this.cacheFailed);
      } else if(var3) {
         if(this.acid != null && this.acid.length() > 0) {
            AdCache.cachedVideoWasAdded(var1, this.acid);
         }

         HttpGetRequest.log(this.cacheComplete);
      }

      MMLog.v("VideoAd", String.format("Caching completed successfully? %b", new Object[]{Boolean.valueOf(var3)}));
      return var3;
   }

   int getType() {
      return 1;
   }

   String getTypeString() {
      return "Video";
   }

   Intent getVideoExtrasIntent(Context var1, long var2) {
      Intent var4 = new Intent();
      var4.putExtra("videoId", this.getId());
      if(var2 != -4L) {
         var4.putExtra("internalId", var2);
      }

      var4.setData(Uri.parse(AdCache.getExternalCacheDirectory(var1, Boolean.valueOf(false)).getAbsolutePath() + File.separator + this.videoFileId + "video.dat"));
      return var4;
   }

   boolean hasEndCard() {
      Iterator var1 = this.buttons.iterator();

      do {
         if(!var1.hasNext()) {
            return false;
         }
      } while(!((VideoImage)var1.next()).isLeaveBehind);

      return true;
   }

   boolean isOnDisk(Context var1) {
      int var2 = this.buttons.size();
      File var4 = AdCache.getInternalCacheDirectory(var1);
      File var6 = AdCache.getExternalCacheDirectory(var1, Boolean.valueOf(false));
      if(var4 != null && var6 != null) {
         String[] var5 = var4.list(new VideoAd$VideoFilenameFilter(this));
         boolean var3;
         if(var5 != null && var5.length >= var2 + 1) {
            var3 = true;
         } else {
            var3 = false;
         }

         if(var3 && var6 != null) {
            if(!(new File(var6, this.videoFileId + "video.dat")).exists()) {
               return false;
            }

            Iterator var7 = this.buttons.iterator();

            while(var7.hasNext()) {
               VideoImage var8 = (VideoImage)var7.next();
               if(!(new File(var4, this.getId() + var8.getImageName())).exists()) {
                  return false;
               }
            }
         }

         return var3;
      } else {
         return false;
      }
   }

   void logBeginEvent() {
      if(this.startActivity != null) {
         MMLog.d("VideoAd", "Cached video begin event logged");

         for(int var1 = 0; var1 < this.startActivity.length; ++var1) {
            MMSDK$Event.logEvent(this.startActivity[var1]);
         }
      }

   }

   void logEndEvent() {
      if(this.endActivity != null) {
         MMLog.d("VideoAd", "Cached video end event logged");

         for(int var1 = 0; var1 < this.endActivity.length; ++var1) {
            MMSDK$Event.logEvent(this.endActivity[var1]);
         }
      }

   }

   public void readExternal(ObjectInput var1) {
      byte var3 = 0;
      super.readExternal(var1);
      this.showControls = var1.readBoolean();
      this.onCompletionUrl = (String)var1.readObject();
      this.webOverlayURL = (String)var1.readObject();
      this.endOverlayURL = (String)var1.readObject();
      this.cacheMissURL = (String)var1.readObject();
      this.videoFileId = (String)var1.readObject();
      this.stayInPlayer = var1.readBoolean();
      this.showCountdown = var1.readBoolean();
      this.reloadNonEndOverlayOnRestart = var1.readBoolean();
      int var4 = var1.readInt();
      this.startActivity = new String[var4];

      int var2;
      for(var2 = 0; var2 < var4; ++var2) {
         this.startActivity[var2] = (String)var1.readObject();
      }

      var4 = var1.readInt();
      this.endActivity = new String[var4];

      for(var2 = 0; var2 < var4; ++var2) {
         this.endActivity[var2] = (String)var1.readObject();
      }

      this.duration = var1.readLong();
      this.usingInternalStorage = var1.readBoolean();
      this.contentLength = var1.readLong();
      this.closeDelayMillis = var1.readLong();
      var4 = var1.readInt();
      this.cacheComplete = new String[var4];

      for(var2 = 0; var2 < var4; ++var2) {
         this.cacheComplete[var2] = (String)var1.readObject();
      }

      var4 = var1.readInt();
      this.cacheFailed = new String[var4];

      for(var2 = 0; var2 < var4; ++var2) {
         this.cacheFailed[var2] = (String)var1.readObject();
      }

      var4 = var1.readInt();
      this.videoError = new String[var4];

      for(var2 = 0; var2 < var4; ++var2) {
         this.videoError[var2] = (String)var1.readObject();
      }

      this.buttons.clear();
      var4 = var1.readInt();

      for(var2 = 0; var2 < var4; ++var2) {
         VideoImage var5 = (VideoImage)var1.readObject();
         this.buttons.add(var5);
      }

      this.activities.clear();
      var4 = var1.readInt();

      for(var2 = var3; var2 < var4; ++var2) {
         VideoLogEvent var6 = (VideoLogEvent)var1.readObject();
         this.activities.add(var6);
      }

   }

   boolean saveAssets(Context var1) {
      return true;
   }

   void setDtoCachedVideo(DTOCachedVideo var1) {
      this.cachedVideoDto = var1;
   }

   void show(Context var1, long var2) {
      Utils$IntentUtils.startCachedVideoPlayerActivity(var1, this.getVideoExtrasIntent(var1, var2));
   }

   public void writeExternal(ObjectOutput var1) {
      byte var3 = 0;
      super.writeExternal(var1);
      var1.writeBoolean(this.showControls);
      var1.writeObject(this.onCompletionUrl);
      var1.writeObject(this.webOverlayURL);
      var1.writeObject(this.endOverlayURL);
      var1.writeObject(this.cacheMissURL);
      var1.writeObject(this.videoFileId);
      var1.writeBoolean(this.stayInPlayer);
      var1.writeBoolean(this.showCountdown);
      var1.writeBoolean(this.reloadNonEndOverlayOnRestart);
      var1.writeInt(this.startActivity.length);
      String[] var5 = this.startActivity;
      int var4 = var5.length;

      int var2;
      for(var2 = 0; var2 < var4; ++var2) {
         var1.writeObject(var5[var2]);
      }

      var1.writeInt(this.endActivity.length);
      var5 = this.endActivity;
      var4 = var5.length;

      for(var2 = 0; var2 < var4; ++var2) {
         var1.writeObject(var5[var2]);
      }

      var1.writeLong(this.duration);
      var1.writeBoolean(this.usingInternalStorage);
      var1.writeLong(this.contentLength);
      var1.writeLong(this.closeDelayMillis);
      var1.writeInt(this.cacheComplete.length);
      var5 = this.cacheComplete;
      var4 = var5.length;

      for(var2 = 0; var2 < var4; ++var2) {
         var1.writeObject(var5[var2]);
      }

      var1.writeInt(this.cacheFailed.length);
      var5 = this.cacheFailed;
      var4 = var5.length;

      for(var2 = 0; var2 < var4; ++var2) {
         var1.writeObject(var5[var2]);
      }

      var1.writeInt(this.videoError.length);
      var5 = this.videoError;
      var4 = var5.length;

      for(var2 = var3; var2 < var4; ++var2) {
         var1.writeObject(var5[var2]);
      }

      var1.writeInt(this.buttons.size());
      Iterator var6 = this.buttons.iterator();

      while(var6.hasNext()) {
         var1.writeObject((VideoImage)var6.next());
      }

      var1.writeInt(this.activities.size());
      var6 = this.activities.iterator();

      while(var6.hasNext()) {
         var1.writeObject((VideoLogEvent)var6.next());
      }

   }

   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      var1.writeInt(this.startActivity.length);
      var1.writeStringArray(this.startActivity);
      var1.writeInt(this.endActivity.length);
      var1.writeStringArray(this.endActivity);
      var1.writeBooleanArray(new boolean[]{this.showControls, this.stayInPlayer, this.showCountdown, this.reloadNonEndOverlayOnRestart, this.usingInternalStorage});
      var1.writeString(this.onCompletionUrl);
      var1.writeString(this.endOverlayURL);
      var1.writeString(this.webOverlayURL);
      var1.writeString(this.cacheMissURL);
      var1.writeString(this.videoFileId);
      var1.writeLong(this.duration);
      var1.writeLong(this.contentLength);
      var1.writeLong(this.closeDelayMillis);
      var1.writeList(this.buttons);
      var1.writeList(this.activities);
      var1.writeInt(this.cacheComplete.length);
      var1.writeStringArray(this.cacheComplete);
      var1.writeInt(this.cacheFailed.length);
      var1.writeStringArray(this.cacheFailed);
      var1.writeInt(this.videoError.length);
      var1.writeStringArray(this.videoError);
   }
}
