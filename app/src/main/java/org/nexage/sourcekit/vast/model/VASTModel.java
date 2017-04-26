package org.nexage.sourcekit.vast.model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import org.nexage.sourcekit.util.VASTLog;
import org.nexage.sourcekit.util.XmlTools;
import org.nexage.sourcekit.vast.model.VideoClicks;
import org.w3c.dom.Document;

public class VASTModel implements Serializable {
   private static String TAG = "VASTModel";
   private static final String combinedTrackingXPATH = "/VASTS/VAST/Ad/InLine/Creatives/Creative/Linear/TrackingEvents/Tracking|/VASTS/VAST/Ad/InLine/Creatives/Creative/NonLinearAds/TrackingEvents/Tracking|/VASTS/VAST/Ad/Wrapper/Creatives/Creative/Linear/TrackingEvents/Tracking|/VASTS/VAST/Ad/Wrapper/Creatives/Creative/NonLinearAds/TrackingEvents/Tracking";
   private static final String durationXPATH = "//Duration";
   private static final String errorUrlXPATH = "//Error";
   private static final String impressionXPATH = "//Impression";
   private static final String inlineLinearTrackingXPATH = "/VASTS/VAST/Ad/InLine/Creatives/Creative/Linear/TrackingEvents/Tracking";
   private static final String inlineNonLinearTrackingXPATH = "/VASTS/VAST/Ad/InLine/Creatives/Creative/NonLinearAds/TrackingEvents/Tracking";
   private static final String mediaFileXPATH = "//MediaFile";
   private static final long serialVersionUID = 4318368258447283733L;
   private static final String videoClicksXPATH = "//VideoClicks";
   private static final String wrapperLinearTrackingXPATH = "/VASTS/VAST/Ad/Wrapper/Creatives/Creative/Linear/TrackingEvents/Tracking";
   private static final String wrapperNonLinearTrackingXPATH = "/VASTS/VAST/Ad/Wrapper/Creatives/Creative/NonLinearAds/TrackingEvents/Tracking";
   private String pickedMediaFileURL = null;
   private transient Document vastsDocument;

   public VASTModel(Document var1) {
      this.vastsDocument = var1;
   }

   private List getListFromXPath(String param1) {
      // $FF: Couldn't be decompiled
   }

   private void readObject(ObjectInputStream var1) {
      VASTLog.d(TAG, "readObject: about to read");
      var1.defaultReadObject();
      String var2 = (String)var1.readObject();
      VASTLog.d(TAG, "vastString data is:\n" + var2 + "\n");
      this.vastsDocument = XmlTools.stringToDocument(var2);
      VASTLog.d(TAG, "done reading");
   }

   private void writeObject(ObjectOutputStream var1) {
      VASTLog.d(TAG, "writeObject: about to write");
      var1.defaultWriteObject();
      var1.writeObject(XmlTools.xmlDocumentToString(this.vastsDocument));
      VASTLog.d(TAG, "done writing");
   }

   public String getDuration() {
      // $FF: Couldn't be decompiled
   }

   public List getErrorUrl() {
      VASTLog.d(TAG, "getErrorUrl");
      return this.getListFromXPath("//Error");
   }

   public List getImpressions() {
      VASTLog.d(TAG, "getImpressions");
      return this.getListFromXPath("//Impression");
   }

   public List getMediaFiles() {
      // $FF: Couldn't be decompiled
   }

   public String getPickedMediaFileURL() {
      return this.pickedMediaFileURL;
   }

   public HashMap getTrackingUrls() {
      // $FF: Couldn't be decompiled
   }

   public Document getVastsDocument() {
      return this.vastsDocument;
   }

   public VideoClicks getVideoClicks() {
      // $FF: Couldn't be decompiled
   }

   public void setPickedMediaFileURL(String var1) {
      this.pickedMediaFileURL = var1;
   }
}
