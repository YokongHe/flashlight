package android.support.v4.app;

import android.app.Notification;
import android.support.v4.app.NotificationCompat$Builder;
import android.support.v4.app.NotificationCompat$NotificationCompatImpl;

class NotificationCompat$NotificationCompatImplBase implements NotificationCompat$NotificationCompatImpl {
   public Notification build(NotificationCompat$Builder var1) {
      Notification var2 = var1.mNotification;
      var2.setLatestEventInfo(var1.mContext, var1.mContentTitle, var1.mContentText, var1.mContentIntent);
      if(var1.mPriority > 0) {
         var2.flags |= 128;
      }

      return var2;
   }
}