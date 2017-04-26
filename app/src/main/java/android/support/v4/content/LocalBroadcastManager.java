package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;

public class LocalBroadcastManager {
   private static final boolean DEBUG = false;
   static final int MSG_EXEC_PENDING_BROADCASTS = 1;
   private static final String TAG = "LocalBroadcastManager";
   private static LocalBroadcastManager mInstance;
   private static final Object mLock = new Object();
   private final HashMap mActions = new HashMap();
   private final Context mAppContext;
   private final Handler mHandler;
   private final ArrayList mPendingBroadcasts = new ArrayList();
   private final HashMap mReceivers = new HashMap();

   private LocalBroadcastManager(Context var1) {
      this.mAppContext = var1;
      this.mHandler = new Handler(var1.getMainLooper()) {
         public void handleMessage(Message var1) {
            switch(var1.what) {
            case 1:
               LocalBroadcastManager.this.executePendingBroadcasts();
               return;
            default:
               super.handleMessage(var1);
            }
         }
      };
   }

   private void executePendingBroadcasts() {
      // $FF: Couldn't be decompiled
   }

   public static LocalBroadcastManager getInstance(Context var0) {
      Object var1 = mLock;
      synchronized(var1) {
         if(mInstance == null) {
            mInstance = new LocalBroadcastManager(var0.getApplicationContext());
         }

         LocalBroadcastManager var3 = mInstance;
         return var3;
      }
   }

   public void registerReceiver(BroadcastReceiver param1, IntentFilter param2) {
      // $FF: Couldn't be decompiled
   }

   public boolean sendBroadcast(Intent param1) {
      // $FF: Couldn't be decompiled
   }

   public void sendBroadcastSync(Intent var1) {
      if(this.sendBroadcast(var1)) {
         this.executePendingBroadcasts();
      }

   }

   public void unregisterReceiver(BroadcastReceiver param1) {
      // $FF: Couldn't be decompiled
   }
}
