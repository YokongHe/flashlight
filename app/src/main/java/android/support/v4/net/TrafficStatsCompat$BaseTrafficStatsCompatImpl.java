package android.support.v4.net;

import android.support.v4.net.TrafficStatsCompat$BaseTrafficStatsCompatImpl$SocketTags;
import android.support.v4.net.TrafficStatsCompat$TrafficStatsCompatImpl;
import java.net.Socket;

class TrafficStatsCompat$BaseTrafficStatsCompatImpl implements TrafficStatsCompat$TrafficStatsCompatImpl {
   private ThreadLocal mThreadSocketTags = new ThreadLocal() {
      protected TrafficStatsCompat$BaseTrafficStatsCompatImpl$SocketTags initialValue() {
         return new TrafficStatsCompat$BaseTrafficStatsCompatImpl$SocketTags(null);
      }
   };

   public void clearThreadStatsTag() {
      ((TrafficStatsCompat$BaseTrafficStatsCompatImpl$SocketTags)this.mThreadSocketTags.get()).statsTag = -1;
   }

   public int getThreadStatsTag() {
      return ((TrafficStatsCompat$BaseTrafficStatsCompatImpl$SocketTags)this.mThreadSocketTags.get()).statsTag;
   }

   public void incrementOperationCount(int var1) {
   }

   public void incrementOperationCount(int var1, int var2) {
   }

   public void setThreadStatsTag(int var1) {
      ((TrafficStatsCompat$BaseTrafficStatsCompatImpl$SocketTags)this.mThreadSocketTags.get()).statsTag = var1;
   }

   public void tagSocket(Socket var1) {
   }

   public void untagSocket(Socket var1) {
   }
}
