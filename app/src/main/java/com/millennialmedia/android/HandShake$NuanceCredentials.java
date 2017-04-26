package com.millennialmedia.android;

class HandShake$NuanceCredentials {
   String appID;
   String appKey;
   int port;
   String server;
   String sessionID;

   public String toString() {
      return "Credentials: appid=" + this.appID + " server=" + this.server + " port=" + this.port + " appKey=" + this.appKey + "sessionID=" + this.sessionID;
   }
}
