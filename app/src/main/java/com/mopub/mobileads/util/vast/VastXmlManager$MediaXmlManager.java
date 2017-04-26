package com.mopub.mobileads.util.vast;

import com.mopub.mobileads.util.vast.VastXmlManager;
import com.mopub.mobileads.util.vast.XmlUtils;
import org.w3c.dom.Node;

class VastXmlManager$MediaXmlManager {
   private static final String DELIVERY = "delivery";
   private static final String VIDEO_TYPE = "type";
   private final Node mMediaNode;
   // $FF: synthetic field
   final VastXmlManager this$0;

   VastXmlManager$MediaXmlManager(VastXmlManager var1, Node var2) {
      this.this$0 = var1;
      if(var2 == null) {
         throw new IllegalArgumentException("Media node cannot be null");
      } else {
         this.mMediaNode = var2;
      }
   }

   String getDelivery() {
      return XmlUtils.getAttributeValue(this.mMediaNode, "delivery");
   }

   Integer getHeight() {
      return XmlUtils.getAttributeValueAsInt(this.mMediaNode, "height");
   }

   String getMediaUrl() {
      return XmlUtils.getNodeValue(this.mMediaNode);
   }

   String getType() {
      return XmlUtils.getAttributeValue(this.mMediaNode, "type");
   }

   Integer getWidth() {
      return XmlUtils.getAttributeValueAsInt(this.mMediaNode, "width");
   }
}
