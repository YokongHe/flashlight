package android.support.v4.app;

import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat$NotificationCompatImpl;
import android.support.v4.app.NotificationCompat$NotificationCompatImplBase;
import android.support.v4.app.NotificationCompat$NotificationCompatImplGingerbread;
import android.support.v4.app.NotificationCompat$NotificationCompatImplHoneycomb;
import android.support.v4.app.NotificationCompat$NotificationCompatImplIceCreamSandwich;
import android.support.v4.app.NotificationCompat$NotificationCompatImplJellybean;

public class NotificationCompat {
   public static final int FLAG_HIGH_PRIORITY = 128;
   private static final NotificationCompat$NotificationCompatImpl IMPL;
   public static final int PRIORITY_DEFAULT = 0;
   public static final int PRIORITY_HIGH = 1;
   public static final int PRIORITY_LOW = -1;
   public static final int PRIORITY_MAX = 2;
   public static final int PRIORITY_MIN = -2;

   static {
      if(VERSION.SDK_INT >= 16) {
         IMPL = new NotificationCompat$NotificationCompatImplJellybean();
      } else if(VERSION.SDK_INT >= 14) {
         IMPL = new NotificationCompat$NotificationCompatImplIceCreamSandwich();
      } else if(VERSION.SDK_INT >= 11) {
         IMPL = new NotificationCompat$NotificationCompatImplHoneycomb();
      } else if(VERSION.SDK_INT >= 9) {
         IMPL = new NotificationCompat$NotificationCompatImplGingerbread();
      } else {
         IMPL = new NotificationCompat$NotificationCompatImplBase();
      }
   }

   // $FF: synthetic method
   static NotificationCompat$NotificationCompatImpl access$000() {
      return IMPL;
   }
}
