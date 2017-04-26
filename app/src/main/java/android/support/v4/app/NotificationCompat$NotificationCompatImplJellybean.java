package android.support.v4.app;

import android.app.Notification;
import android.support.v4.app.NotificationCompat$Action;
import android.support.v4.app.NotificationCompat$BigPictureStyle;
import android.support.v4.app.NotificationCompat$BigTextStyle;
import android.support.v4.app.NotificationCompat$Builder;
import android.support.v4.app.NotificationCompat$InboxStyle;
import android.support.v4.app.NotificationCompat$NotificationCompatImpl;
import android.support.v4.app.NotificationCompatJellybean;
import java.util.Iterator;

class NotificationCompat$NotificationCompatImplJellybean implements NotificationCompat$NotificationCompatImpl {
   public Notification build(NotificationCompat$Builder var1) {
      NotificationCompatJellybean var2 = new NotificationCompatJellybean(var1.mContext, var1.mNotification, var1.mContentTitle, var1.mContentText, var1.mContentInfo, var1.mTickerView, var1.mNumber, var1.mContentIntent, var1.mFullScreenIntent, var1.mLargeIcon, var1.mProgressMax, var1.mProgress, var1.mProgressIndeterminate, var1.mUseChronometer, var1.mPriority, var1.mSubText);
      Iterator var3 = var1.mActions.iterator();

      while(var3.hasNext()) {
         NotificationCompat$Action var4 = (NotificationCompat$Action)var3.next();
         var2.addAction(var4.icon, var4.title, var4.actionIntent);
      }

      if(var1.mStyle != null) {
         if(var1.mStyle instanceof NotificationCompat$BigTextStyle) {
            NotificationCompat$BigTextStyle var5 = (NotificationCompat$BigTextStyle)var1.mStyle;
            var2.addBigTextStyle(var5.mBigContentTitle, var5.mSummaryTextSet, var5.mSummaryText, var5.mBigText);
         } else if(var1.mStyle instanceof NotificationCompat$InboxStyle) {
            NotificationCompat$InboxStyle var6 = (NotificationCompat$InboxStyle)var1.mStyle;
            var2.addInboxStyle(var6.mBigContentTitle, var6.mSummaryTextSet, var6.mSummaryText, var6.mTexts);
         } else if(var1.mStyle instanceof NotificationCompat$BigPictureStyle) {
            NotificationCompat$BigPictureStyle var7 = (NotificationCompat$BigPictureStyle)var1.mStyle;
            var2.addBigPictureStyle(var7.mBigContentTitle, var7.mSummaryTextSet, var7.mSummaryText, var7.mPicture, var7.mBigLargeIcon, var7.mBigLargeIconSet);
         }
      }

      return var2.build();
   }
}
