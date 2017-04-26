package android.support.v4.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder$SupportParentable;
import android.support.v4.app.TaskStackBuilder$TaskStackBuilderImpl;
import android.support.v4.app.TaskStackBuilder$TaskStackBuilderImplBase;
import android.support.v4.app.TaskStackBuilder$TaskStackBuilderImplHoneycomb;
import android.support.v4.content.ContextCompat;
import java.util.ArrayList;
import java.util.Iterator;

public class TaskStackBuilder implements Iterable {
   private static final TaskStackBuilder$TaskStackBuilderImpl IMPL;
   private static final String TAG = "TaskStackBuilder";
   private final ArrayList mIntents = new ArrayList();
   private final Context mSourceContext;

   static {
      if(VERSION.SDK_INT >= 11) {
         IMPL = new TaskStackBuilder$TaskStackBuilderImplHoneycomb();
      } else {
         IMPL = new TaskStackBuilder$TaskStackBuilderImplBase();
      }
   }

   private TaskStackBuilder(Context var1) {
      this.mSourceContext = var1;
   }

   public static TaskStackBuilder create(Context var0) {
      return new TaskStackBuilder(var0);
   }

   public static TaskStackBuilder from(Context var0) {
      return create(var0);
   }

   public TaskStackBuilder addNextIntent(Intent var1) {
      this.mIntents.add(var1);
      return this;
   }

   public TaskStackBuilder addNextIntentWithParentStack(Intent var1) {
      ComponentName var3 = var1.getComponent();
      ComponentName var2 = var3;
      if(var3 == null) {
         var2 = var1.resolveActivity(this.mSourceContext.getPackageManager());
      }

      if(var2 != null) {
         this.addParentStack(var2);
      }

      this.addNextIntent(var1);
      return this;
   }

   public TaskStackBuilder addParentStack(Activity var1) {
      Intent var2 = null;
      if(var1 instanceof TaskStackBuilder$SupportParentable) {
         var2 = ((TaskStackBuilder$SupportParentable)var1).getSupportParentActivityIntent();
      }

      Intent var4;
      if(var2 == null) {
         var4 = NavUtils.getParentActivityIntent(var1);
      } else {
         var4 = var2;
      }

      if(var4 != null) {
         ComponentName var3 = var4.getComponent();
         ComponentName var5 = var3;
         if(var3 == null) {
            var5 = var4.resolveActivity(this.mSourceContext.getPackageManager());
         }

         this.addParentStack(var5);
         this.addNextIntent(var4);
      }

      return this;
   }

   public TaskStackBuilder addParentStack(ComponentName param1) {
      // $FF: Couldn't be decompiled
   }

   public TaskStackBuilder addParentStack(Class var1) {
      return this.addParentStack(new ComponentName(this.mSourceContext, var1));
   }

   public Intent editIntentAt(int var1) {
      return (Intent)this.mIntents.get(var1);
   }

   public Intent getIntent(int var1) {
      return this.editIntentAt(var1);
   }

   public int getIntentCount() {
      return this.mIntents.size();
   }

   public Intent[] getIntents() {
      Intent[] var2 = new Intent[this.mIntents.size()];
      if(var2.length == 0) {
         return var2;
      } else {
         var2[0] = (new Intent((Intent)this.mIntents.get(0))).addFlags(268484608);

         for(int var1 = 1; var1 < var2.length; ++var1) {
            var2[var1] = new Intent((Intent)this.mIntents.get(var1));
         }

         return var2;
      }
   }

   public PendingIntent getPendingIntent(int var1, int var2) {
      return this.getPendingIntent(var1, var2, (Bundle)null);
   }

   public PendingIntent getPendingIntent(int var1, int var2, Bundle var3) {
      if(this.mIntents.isEmpty()) {
         throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
      } else {
         Intent[] var4 = (Intent[])this.mIntents.toArray(new Intent[this.mIntents.size()]);
         var4[0] = (new Intent(var4[0])).addFlags(268484608);
         return IMPL.getPendingIntent(this.mSourceContext, var4, var1, var2, var3);
      }
   }

   public Iterator iterator() {
      return this.mIntents.iterator();
   }

   public void startActivities() {
      this.startActivities((Bundle)null);
   }

   public void startActivities(Bundle var1) {
      if(this.mIntents.isEmpty()) {
         throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
      } else {
         Intent[] var2 = (Intent[])this.mIntents.toArray(new Intent[this.mIntents.size()]);
         var2[0] = (new Intent(var2[0])).addFlags(268484608);
         if(!ContextCompat.startActivities(this.mSourceContext, var2, var1)) {
            Intent var3 = new Intent(var2[var2.length - 1]);
            var3.addFlags(268435456);
            this.mSourceContext.startActivity(var3);
         }

      }
   }
}
