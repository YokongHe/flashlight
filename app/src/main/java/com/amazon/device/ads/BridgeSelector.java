package com.amazon.device.ads;

import com.amazon.device.ads.AAXCreative;
import com.amazon.device.ads.AdSDKBridgeFactory;
import com.amazon.device.ads.AmazonAdSDKBridgeFactory;
import com.amazon.device.ads.MraidAdSDKBridgeFactory;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;

class BridgeSelector {
   private static BridgeSelector instance = new BridgeSelector();
   private HashMap bridgesForCT;
   private HashMap bridgesForPattern;
   private HashMap bridgesForResourcePattern;
   private HashMap patterns;

   BridgeSelector() {
      this.initialize();
   }

   public static BridgeSelector getInstance() {
      return instance;
   }

   private Pattern getPattern(String var1) {
      Pattern var3 = (Pattern)this.patterns.get(var1);
      Pattern var2 = var3;
      if(var3 == null) {
         var2 = Pattern.compile(var1);
         this.patterns.put(var1, var2);
      }

      return var2;
   }

   public void addBridgeFactory(AAXCreative var1, AdSDKBridgeFactory var2) {
      HashSet var4 = (HashSet)this.bridgesForCT.get(var1);
      HashSet var3 = var4;
      if(var4 == null) {
         var3 = new HashSet();
         this.bridgesForCT.put(var1, var3);
      }

      var3.add(var2);
   }

   public void addBridgeFactoryForHtmlScriptTag(String var1, AdSDKBridgeFactory var2) {
      String var4 = String.format("<[Ss][Cc][Rr][Ii][Pp][Tt](\\s[^>]*\\s|\\s)[Ss][Rr][Cc]\\s*=\\s*[\"\']%s[\"\']", new Object[]{var1});
      HashSet var3 = (HashSet)this.bridgesForPattern.get(var4);
      HashSet var5 = var3;
      if(var3 == null) {
         var5 = new HashSet();
         this.bridgesForPattern.put(var4, var5);
      }

      var5.add(var2);
   }

   public void addBridgeFactoryForResourceLoad(String var1, AdSDKBridgeFactory var2) {
      String var4 = String.format(".*\\W%s$|^%s$", new Object[]{var1, var1});
      HashSet var3 = (HashSet)this.bridgesForResourcePattern.get(var4);
      HashSet var5 = var3;
      if(var3 == null) {
         var5 = new HashSet();
         this.bridgesForResourcePattern.put(var4, var5);
      }

      var5.add(var2);
   }

   public void addBridgeFactoryForScript(String var1, AdSDKBridgeFactory var2) {
      this.addBridgeFactoryForHtmlScriptTag(var1, var2);
      this.addBridgeFactoryForResourceLoad(var1, var2);
   }

   public Set getBridgeFactories(AAXCreative var1) {
      return (Set)this.bridgesForCT.get(var1);
   }

   public Set getBridgeFactories(String var1) {
      HashSet var2 = new HashSet();
      Iterator var3 = this.bridgesForPattern.keySet().iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         if(this.getPattern(var4).matcher(var1).find()) {
            var2.addAll((Collection)this.bridgesForPattern.get(var4));
         }
      }

      return var2;
   }

   public Set getBridgeFactoriesForResourceLoad(String var1) {
      HashSet var2 = new HashSet();
      Iterator var3 = this.bridgesForResourcePattern.keySet().iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         if(this.getPattern(var4).matcher(var1).find()) {
            var2.addAll((Collection)this.bridgesForResourcePattern.get(var4));
         }
      }

      return var2;
   }

   void initialize() {
      this.bridgesForCT = new HashMap();
      this.bridgesForPattern = new HashMap();
      this.patterns = new HashMap();
      this.bridgesForResourcePattern = new HashMap();
      this.addBridgeFactoryForScript("amazon.js", new AmazonAdSDKBridgeFactory());
      MraidAdSDKBridgeFactory var1 = new MraidAdSDKBridgeFactory();
      this.addBridgeFactory(AAXCreative.MRAID1, var1);
      this.addBridgeFactory(AAXCreative.MRAID2, var1);
      this.addBridgeFactory(AAXCreative.INTERSTITIAL, var1);
      this.addBridgeFactoryForScript("mraid.js", var1);
   }
}
