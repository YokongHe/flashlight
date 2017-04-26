package android.support.v4.content;

import android.content.Intent;
import java.util.ArrayList;

class LocalBroadcastManager$BroadcastRecord {
   final Intent intent;
   final ArrayList receivers;

   LocalBroadcastManager$BroadcastRecord(Intent var1, ArrayList var2) {
      this.intent = var1;
      this.receivers = var2;
   }
}
