package com.amazon.device.ads;

import com.amazon.device.ads.AdSDKBridge;
import java.util.HashMap;
import java.util.Iterator;

class AdSDKBridgeList implements Iterable {
   private final HashMap bridgesByName = new HashMap();

   public void addBridge(AdSDKBridge var1) {
      this.bridgesByName.put(var1.getName(), var1);
   }

   public void clear() {
      this.bridgesByName.clear();
   }

   public boolean contains(AdSDKBridge var1) {
      return this.bridgesByName.containsKey(var1.getName());
   }

   public Iterator iterator() {
      return this.bridgesByName.values().iterator();
   }
}
