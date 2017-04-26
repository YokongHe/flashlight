package android.support.v4.app;

import android.app.Notification;
import android.support.v4.app.NotificationCompat$Builder;
import android.support.v4.app.NotificationCompat$NotificationCompatImpl;
import android.support.v4.app.NotificationCompatIceCreamSandwich;

class NotificationCompat$NotificationCompatImplIceCreamSandwich implements NotificationCompat$NotificationCompatImpl {
   public Notification build(NotificationCompat$Builder var1) {
      return NotificationCompatIceCreamSandwich.add(var1.mContext, var1.mNotification, var1.mContentTitle, var1.mContentText, var1.mContentInfo, var1.mTickerView, var1.mNumber, var1.mContentIntent, var1.mFullScreenIntent, var1.mLargeIcon, var1.mProgressMax, var1.mProgress, var1.mProgressIndeterminate);
   }
}
