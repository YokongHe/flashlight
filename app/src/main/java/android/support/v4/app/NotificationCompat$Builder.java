package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat$Action;
import android.support.v4.app.NotificationCompat$Style;
import android.widget.RemoteViews;
import java.util.ArrayList;

public class NotificationCompat$Builder {
   ArrayList mActions = new ArrayList();
   CharSequence mContentInfo;
   PendingIntent mContentIntent;
   CharSequence mContentText;
   CharSequence mContentTitle;
   Context mContext;
   PendingIntent mFullScreenIntent;
   Bitmap mLargeIcon;
   Notification mNotification = new Notification();
   int mNumber;
   int mPriority;
   int mProgress;
   boolean mProgressIndeterminate;
   int mProgressMax;
   NotificationCompat$Style mStyle;
   CharSequence mSubText;
   RemoteViews mTickerView;
   boolean mUseChronometer;

   public NotificationCompat$Builder(Context var1) {
      this.mContext = var1;
      this.mNotification.when = System.currentTimeMillis();
      this.mNotification.audioStreamType = -1;
      this.mPriority = 0;
   }

   private void setFlag(int var1, boolean var2) {
      Notification var3;
      if(var2) {
         var3 = this.mNotification;
         var3.flags |= var1;
      } else {
         var3 = this.mNotification;
         var3.flags &= ~var1;
      }
   }

   public NotificationCompat$Builder addAction(int var1, CharSequence var2, PendingIntent var3) {
      this.mActions.add(new NotificationCompat$Action(var1, var2, var3));
      return this;
   }

   public Notification build() {
      return NotificationCompat.access$000().build(this);
   }

   @Deprecated
   public Notification getNotification() {
      return NotificationCompat.access$000().build(this);
   }

   public NotificationCompat$Builder setAutoCancel(boolean var1) {
      this.setFlag(16, var1);
      return this;
   }

   public NotificationCompat$Builder setContent(RemoteViews var1) {
      this.mNotification.contentView = var1;
      return this;
   }

   public NotificationCompat$Builder setContentInfo(CharSequence var1) {
      this.mContentInfo = var1;
      return this;
   }

   public NotificationCompat$Builder setContentIntent(PendingIntent var1) {
      this.mContentIntent = var1;
      return this;
   }

   public NotificationCompat$Builder setContentText(CharSequence var1) {
      this.mContentText = var1;
      return this;
   }

   public NotificationCompat$Builder setContentTitle(CharSequence var1) {
      this.mContentTitle = var1;
      return this;
   }

   public NotificationCompat$Builder setDefaults(int var1) {
      this.mNotification.defaults = var1;
      if((var1 & 4) != 0) {
         Notification var2 = this.mNotification;
         var2.flags |= 1;
      }

      return this;
   }

   public NotificationCompat$Builder setDeleteIntent(PendingIntent var1) {
      this.mNotification.deleteIntent = var1;
      return this;
   }

   public NotificationCompat$Builder setFullScreenIntent(PendingIntent var1, boolean var2) {
      this.mFullScreenIntent = var1;
      this.setFlag(128, var2);
      return this;
   }

   public NotificationCompat$Builder setLargeIcon(Bitmap var1) {
      this.mLargeIcon = var1;
      return this;
   }

   public NotificationCompat$Builder setLights(int var1, int var2, int var3) {
      byte var4 = 1;
      this.mNotification.ledARGB = var1;
      this.mNotification.ledOnMS = var2;
      this.mNotification.ledOffMS = var3;
      boolean var6;
      if(this.mNotification.ledOnMS != 0 && this.mNotification.ledOffMS != 0) {
         var6 = true;
      } else {
         var6 = false;
      }

      Notification var5 = this.mNotification;
      var2 = this.mNotification.flags;
      byte var7;
      if(var6) {
         var7 = var4;
      } else {
         var7 = 0;
      }

      var5.flags = var2 & -2 | var7;
      return this;
   }

   public NotificationCompat$Builder setNumber(int var1) {
      this.mNumber = var1;
      return this;
   }

   public NotificationCompat$Builder setOngoing(boolean var1) {
      this.setFlag(2, var1);
      return this;
   }

   public NotificationCompat$Builder setOnlyAlertOnce(boolean var1) {
      this.setFlag(8, var1);
      return this;
   }

   public NotificationCompat$Builder setPriority(int var1) {
      this.mPriority = var1;
      return this;
   }

   public NotificationCompat$Builder setProgress(int var1, int var2, boolean var3) {
      this.mProgressMax = var1;
      this.mProgress = var2;
      this.mProgressIndeterminate = var3;
      return this;
   }

   public NotificationCompat$Builder setSmallIcon(int var1) {
      this.mNotification.icon = var1;
      return this;
   }

   public NotificationCompat$Builder setSmallIcon(int var1, int var2) {
      this.mNotification.icon = var1;
      this.mNotification.iconLevel = var2;
      return this;
   }

   public NotificationCompat$Builder setSound(Uri var1) {
      this.mNotification.sound = var1;
      this.mNotification.audioStreamType = -1;
      return this;
   }

   public NotificationCompat$Builder setSound(Uri var1, int var2) {
      this.mNotification.sound = var1;
      this.mNotification.audioStreamType = var2;
      return this;
   }

   public NotificationCompat$Builder setStyle(NotificationCompat$Style var1) {
      if(this.mStyle != var1) {
         this.mStyle = var1;
         if(this.mStyle != null) {
            this.mStyle.setBuilder(this);
         }
      }

      return this;
   }

   public NotificationCompat$Builder setSubText(CharSequence var1) {
      this.mSubText = var1;
      return this;
   }

   public NotificationCompat$Builder setTicker(CharSequence var1) {
      this.mNotification.tickerText = var1;
      return this;
   }

   public NotificationCompat$Builder setTicker(CharSequence var1, RemoteViews var2) {
      this.mNotification.tickerText = var1;
      this.mTickerView = var2;
      return this;
   }

   public NotificationCompat$Builder setUsesChronometer(boolean var1) {
      this.mUseChronometer = var1;
      return this;
   }

   public NotificationCompat$Builder setVibrate(long[] var1) {
      this.mNotification.vibrate = var1;
      return this;
   }

   public NotificationCompat$Builder setWhen(long var1) {
      this.mNotification.when = var1;
      return this;
   }
}
