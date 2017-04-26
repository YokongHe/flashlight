package com.mopub.mobileads.util.vast;

import com.mopub.mobileads.util.vast.VastXmlManager;
import com.mopub.mobileads.util.vast.XmlUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.Node;

class VastXmlManager$ImageCompanionAdXmlManager {
   private static final String COMPANION_CLICK_THROUGH = "CompanionClickThrough";
   private static final String COMPANION_STATIC_RESOURCE = "StaticResource";
   private static final String CREATIVE_TYPE = "creativeType";
   private static final String CREATIVE_VIEW = "creativeView";
   private static final String TRACKING_EVENTS = "TrackingEvents";
   private final Node mCompanionNode;
   // $FF: synthetic field
   final VastXmlManager this$0;

   VastXmlManager$ImageCompanionAdXmlManager(VastXmlManager var1, Node var2) {
      this.this$0 = var1;
      if(var2 == null) {
         throw new IllegalArgumentException("Companion node cannot be null");
      } else {
         this.mCompanionNode = var2;
      }
   }

   String getClickThroughUrl() {
      return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.mCompanionNode, "CompanionClickThrough"));
   }

   List getClickTrackers() {
      ArrayList var1 = new ArrayList();
      Node var2 = XmlUtils.getFirstMatchingChildNode(this.mCompanionNode, "TrackingEvents");
      if(var2 == null) {
         return var1;
      } else {
         Iterator var4 = XmlUtils.getMatchingChildNodes(var2, "Tracking", "event", Arrays.asList(new String[]{"creativeView"})).iterator();

         while(var4.hasNext()) {
            Node var3 = (Node)var4.next();
            if(var3.getFirstChild() != null) {
               var1.add(var3.getFirstChild().getNodeValue().trim());
            }
         }

         return var1;
      }
   }

   Integer getHeight() {
      return XmlUtils.getAttributeValueAsInt(this.mCompanionNode, "height");
   }

   String getImageUrl() {
      return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.mCompanionNode, "StaticResource"));
   }

   String getType() {
      return XmlUtils.getAttributeValue(XmlUtils.getFirstMatchingChildNode(this.mCompanionNode, "StaticResource"), "creativeType");
   }

   Integer getWidth() {
      return XmlUtils.getAttributeValueAsInt(this.mCompanionNode, "width");
   }
}
