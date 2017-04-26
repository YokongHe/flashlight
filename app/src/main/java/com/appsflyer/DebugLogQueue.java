package com.appsflyer;

import com.appsflyer.DebugLogQueue$Item;
import java.util.ArrayList;
import java.util.List;

public class DebugLogQueue {
   private static DebugLogQueue ourInstance = new DebugLogQueue();
   List queue = new ArrayList();

   public static DebugLogQueue getInstance() {
      return ourInstance;
   }

   public DebugLogQueue$Item pop() {
      if(this.queue.size() == 0) {
         return null;
      } else {
         DebugLogQueue$Item var1 = (DebugLogQueue$Item)this.queue.get(0);
         this.queue.remove(0);
         return var1;
      }
   }

   public void push(String var1) {
      this.queue.add(new DebugLogQueue$Item(var1));
   }
}
