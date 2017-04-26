package com.mopub.mobileads.util.vast;

import com.mopub.mobileads.util.vast.VastXmlManager$ImageCompanionAdXmlManager;
import com.mopub.mobileads.util.vast.VastXmlManager$MediaXmlManager;
import com.mopub.mobileads.util.vast.XmlUtils;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

class VastXmlManager {
   private static final String CLICK_THROUGH = "ClickThrough";
   private static final String CLICK_TRACKER = "ClickTracking";
   private static final String COMPANION = "Companion";
   private static final String COMPLETE = "complete";
   private static final String EVENT = "event";
   private static final String FIRST_QUARTILE = "firstQuartile";
   private static final String HEIGHT = "height";
   private static final String IMPRESSION_TRACKER = "Impression";
   private static final String MEDIA_FILE = "MediaFile";
   private static final String MIDPOINT = "midpoint";
   private static final String MP_IMPRESSION_TRACKER = "MP_TRACKING_URL";
   private static final String ROOT_TAG = "MPMoVideoXMLDocRoot";
   private static final String ROOT_TAG_CLOSE = "</MPMoVideoXMLDocRoot>";
   private static final String ROOT_TAG_OPEN = "<MPMoVideoXMLDocRoot>";
   private static final String START = "start";
   private static final String THIRD_QUARTILE = "thirdQuartile";
   private static final String VAST_AD_TAG = "VASTAdTagURI";
   private static final String VIDEO_TRACKER = "Tracking";
   private static final String WIDTH = "width";
   private Document mVastDoc;

   private List getVideoTrackerByAttribute(String var1) {
      return XmlUtils.getStringDataAsList(this.mVastDoc, "Tracking", "event", var1);
   }

   String getClickThroughUrl() {
      List var1 = XmlUtils.getStringDataAsList(this.mVastDoc, "ClickThrough");
      return var1.size() > 0?(String)var1.get(0):null;
   }

   List getClickTrackers() {
      return XmlUtils.getStringDataAsList(this.mVastDoc, "ClickTracking");
   }

   List getCompanionAdXmlManagers() {
      NodeList var2 = this.mVastDoc.getElementsByTagName("Companion");
      ArrayList var3 = new ArrayList(var2.getLength());

      for(int var1 = 0; var1 < var2.getLength(); ++var1) {
         var3.add(new VastXmlManager$ImageCompanionAdXmlManager(this, var2.item(var1)));
      }

      return var3;
   }

   List getImpressionTrackers() {
      List var1 = XmlUtils.getStringDataAsList(this.mVastDoc, "Impression");
      var1.addAll(XmlUtils.getStringDataAsList(this.mVastDoc, "MP_TRACKING_URL"));
      return var1;
   }

   String getMediaFileUrl() {
      List var1 = XmlUtils.getStringDataAsList(this.mVastDoc, "MediaFile");
      return var1.size() > 0?(String)var1.get(0):null;
   }

   List getMediaXmlManagers() {
      NodeList var2 = this.mVastDoc.getElementsByTagName("MediaFile");
      ArrayList var3 = new ArrayList(var2.getLength());

      for(int var1 = 0; var1 < var2.getLength(); ++var1) {
         var3.add(new VastXmlManager$MediaXmlManager(this, var2.item(var1)));
      }

      return var3;
   }

   String getVastAdTagURI() {
      List var1 = XmlUtils.getStringDataAsList(this.mVastDoc, "VASTAdTagURI");
      return var1.size() > 0?(String)var1.get(0):null;
   }

   List getVideoCompleteTrackers() {
      return this.getVideoTrackerByAttribute("complete");
   }

   List getVideoFirstQuartileTrackers() {
      return this.getVideoTrackerByAttribute("firstQuartile");
   }

   List getVideoMidpointTrackers() {
      return this.getVideoTrackerByAttribute("midpoint");
   }

   List getVideoStartTrackers() {
      return this.getVideoTrackerByAttribute("start");
   }

   List getVideoThirdQuartileTrackers() {
      return this.getVideoTrackerByAttribute("thirdQuartile");
   }

   void parseVastXml(String var1) {
      var1 = var1.replaceFirst("<\\?.*\\?>", "");
      var1 = "<MPMoVideoXMLDocRoot>" + var1 + "</MPMoVideoXMLDocRoot>";
      DocumentBuilderFactory var2 = DocumentBuilderFactory.newInstance();
      var2.setCoalescing(true);
      this.mVastDoc = var2.newDocumentBuilder().parse(new InputSource(new StringReader(var1)));
   }
}
