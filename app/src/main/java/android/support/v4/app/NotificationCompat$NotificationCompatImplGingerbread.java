package android.support.v4.app;

import android.app.Notification;
import android.support.v4.app.NotificationCompat$Builder;
import android.support.v4.app.NotificationCompat$NotificationCompatImplBase;
import android.support.v4.app.NotificationCompatGingerbread;

class NotificationCompat$NotificationCompatImplGingerbread extends NotificationCompat$NotificationCompatImplBase {
   public Notification build(NotificationCompat$Builder var1) {
      Notification var2 = var1.mNotification;
      var2.setLatestEventInfo(var1.mContext, var1.mContentTitle, var1.mContentText, var1.mContentIntent);
      var2 = NotificationCompatGingerbread.add(var2, var1.mContext, var1.mContentTitle, var1.mContentText, var1.mContentIntent, var1.mFullScreenIntent);
      if(var1.mPriority > 0) {
         var2.flags |= 128;
      }

      return var2;
   }
}
