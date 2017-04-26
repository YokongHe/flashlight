package com.mopub.mobileads.util.vast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class XmlUtils {
   static String getAttributeValue(Node var0, String var1) {
      if(var0 != null && var1 != null) {
         var0 = var0.getAttributes().getNamedItem(var1);
         if(var0 != null) {
            return var0.getNodeValue();
         }
      }

      return null;
   }

   static Integer getAttributeValueAsInt(Node var0, String var1) {
      if(var0 != null && var1 != null) {
         int var2;
         try {
            var2 = Integer.parseInt(getAttributeValue(var0, var1));
         } catch (NumberFormatException var3) {
            return null;
         }

         return Integer.valueOf(var2);
      } else {
         return null;
      }
   }

   static Node getFirstMatchingChildNode(Node var0, String var1) {
      return getFirstMatchingChildNode(var0, var1, (String)null, (List)null);
   }

   static Node getFirstMatchingChildNode(Node var0, String var1, String var2, List var3) {
      if(var0 != null && var1 != null) {
         List var4 = getMatchingChildNodes(var0, var1, var2, var3);
         if(var4 != null && !var4.isEmpty()) {
            return (Node)var4.get(0);
         }
      }

      return null;
   }

   static List getMatchingChildNodes(Node var0, String var1, String var2, List var3) {
      if(var0 != null && var1 != null) {
         ArrayList var5 = new ArrayList();
         NodeList var7 = var0.getChildNodes();

         for(int var4 = 0; var4 < var7.getLength(); ++var4) {
            Node var6 = var7.item(var4);
            if(var6.getNodeName().equals(var1) && nodeMatchesAttributeFilter(var6, var2, var3)) {
               var5.add(var6);
            }
         }

         return var5;
      } else {
         return null;
      }
   }

   static String getNodeValue(Node var0) {
      return var0 != null && var0.getFirstChild() != null && var0.getFirstChild().getNodeValue() != null?var0.getFirstChild().getNodeValue().trim():null;
   }

   static List getStringDataAsList(Document var0, String var1) {
      return getStringDataAsList(var0, var1, (String)null, (String)null);
   }

   static List getStringDataAsList(Document var0, String var1, String var2, String var3) {
      ArrayList var5 = new ArrayList();
      if(var0 == null) {
         return var5;
      } else {
         NodeList var6 = var0.getElementsByTagName(var1);
         if(var6 == null) {
            return var5;
         } else {
            for(int var4 = 0; var4 < var6.getLength(); ++var4) {
               Node var7 = var6.item(var4);
               if(var7 != null && nodeMatchesAttributeFilter(var7, var2, Arrays.asList(new String[]{var3}))) {
                  var1 = getNodeValue(var7);
                  if(var1 != null) {
                     var5.add(var1);
                  }
               }
            }

            return var5;
         }
      }
   }

   static boolean nodeMatchesAttributeFilter(Node var0, String var1, List var2) {
      if(var1 != null && var2 != null) {
         NamedNodeMap var3 = var0.getAttributes();
         if(var3 != null) {
            var0 = var3.getNamedItem(var1);
            if(var0 != null && var2.contains(var0.getNodeValue())) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }
}
