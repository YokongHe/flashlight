package android.support.v4.net;

import android.net.TrafficStats;
import java.net.Socket;

class TrafficStatsCompatIcs {
   public static void clearThreadStatsTag() {
      TrafficStats.clearThreadStatsTag();
   }

   public static int getThreadStatsTag() {
      return TrafficStats.getThreadStatsTag();
   }

   public static void incrementOperationCount(int var0) {
      TrafficStats.incrementOperationCount(var0);
   }

   public static void incrementOperationCount(int var0, int var1) {
      TrafficStats.incrementOperationCount(var0, var1);
   }

   public static void setThreadStatsTag(int var0) {
      TrafficStats.setThreadStatsTag(var0);
   }

   public static void tagSocket(Socket var0) {
      TrafficStats.tagSocket(var0);
   }

   public static void untagSocket(Socket var0) {
      TrafficStats.untagSocket(var0);
   }
}
