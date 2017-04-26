package com.adsdk.sdk.nativeads;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NativeViewBinder {
   private int adLayoutId;
   private Map imageAssetsBidings;
   private Map textAssetsBidings;

   public NativeViewBinder(int var1) {
      this.adLayoutId = var1;
      this.textAssetsBidings = new HashMap();
      this.imageAssetsBidings = new HashMap();
   }

   public void bindImageAsset(String var1, int var2) {
      this.imageAssetsBidings.put(var1, Integer.valueOf(var2));
   }

   public void bindTextAsset(String var1, int var2) {
      this.textAssetsBidings.put(var1, Integer.valueOf(var2));
   }

   public int getAdLayoutId() {
      return this.adLayoutId;
   }

   public int getIdForImageAsset(String var1) {
      Integer var2 = (Integer)this.imageAssetsBidings.get(var1);
      return var2 != null?var2.intValue():0;
   }

   public int getIdForTextAsset(String var1) {
      Integer var2 = (Integer)this.textAssetsBidings.get(var1);
      return var2 != null?var2.intValue():0;
   }

   public Set getImageAssetsBindingsKeySet() {
      return this.imageAssetsBidings.keySet();
   }

   public Set getTextAssetsBindingsKeySet() {
      return this.textAssetsBidings.keySet();
   }
}
