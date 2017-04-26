package android.support.v4.app;

import android.app.PendingIntent;

public class NotificationCompat$Action {
   public PendingIntent actionIntent;
   public int icon;
   public CharSequence title;

   public NotificationCompat$Action(int var1, CharSequence var2, PendingIntent var3) {
      this.icon = var1;
      this.title = var2;
      this.actionIntent = var3;
   }
}
