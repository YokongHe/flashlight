package android.support.v4.app;

import android.app.Notification;
import android.support.v4.app.NotificationCompat$Builder;
import android.support.v4.app.NotificationCompat$NotificationCompatImpl;
import android.support.v4.app.NotificationCompatHoneycomb;

class NotificationCompat$NotificationCompatImplHoneycomb implements NotificationCompat$NotificationCompatImpl {
   public Notification build(NotificationCompat$Builder var1) {
      return NotificationCompatHoneycomb.add(var1.mContext, var1.mNotification, var1.mContentTitle, var1.mContentText, var1.mContentInfo, var1.mTickerView, var1.mNumber, var1.mContentIntent, var1.mFullScreenIntent, var1.mLargeIcon);
   }
}
