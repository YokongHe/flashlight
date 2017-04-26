package com.mopub.mobileads;

public class TaskTracker {
   private long mCurrentTaskId = -1L;
   private long mLastCompletedTaskId;

   public long getCurrentTaskId() {
      return this.mCurrentTaskId;
   }

   public boolean isMostCurrentTask(long var1) {
      return var1 >= this.mLastCompletedTaskId;
   }

   public void markTaskCompleted(long var1) {
      if(var1 > this.mLastCompletedTaskId) {
         this.mLastCompletedTaskId = var1;
      }

   }

   public void newTaskStarted() {
      ++this.mCurrentTaskId;
   }
}
