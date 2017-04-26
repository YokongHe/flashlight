package com.mopub.nativeads;

import com.mopub.common.Preconditions;
import com.mopub.nativeads.TaskManager$TaskManagerListener;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

abstract class TaskManager {
   protected final AtomicInteger mCompletedCount;
   protected final AtomicBoolean mFailed;
   protected final TaskManager$TaskManagerListener mImageTaskManagerListener;
   protected final Map mResults;
   protected final int mSize;

   TaskManager(List var1, TaskManager$TaskManagerListener var2) {
      Preconditions.checkNotNull(var1, "Urls list cannot be null");
      Preconditions.checkNotNull(var2, "ImageTaskManagerListener cannot be null");
      boolean var3;
      if(var1.contains((Object)null)) {
         var3 = false;
      } else {
         var3 = true;
      }

      Preconditions.checkState(var3, "Urls list cannot contain null");
      this.mSize = var1.size();
      this.mImageTaskManagerListener = var2;
      this.mCompletedCount = new AtomicInteger(0);
      this.mFailed = new AtomicBoolean(false);
      this.mResults = Collections.synchronizedMap(new HashMap(this.mSize));
   }

   abstract void execute();
}
