package com.adsdk.sdk.video;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class VideoData implements Serializable {
   public static final int DELIVERY_PROGRESSIVE = 0;
   public static final int DELIVERY_STREAMING = 1;
   public static final int DISPLAY_FULLSCREEN = 0;
   public static final int DISPLAY_NORMAL = 1;
   public static final int OVERLAY_MARKUP = 1;
   public static final int OVERLAY_URL = 0;
   private static final long serialVersionUID = 3402649540160829602L;
   int bitrate;
   Vector completeEvents = new Vector();
   int delivery;
   int display;
   int duration;
   int height;
   String htmlOverlayMarkup;
   int htmlOverlayType;
   String htmlOverlayUrl;
   Vector icons = new Vector();
   Vector impressionEvents = new Vector();
   Vector muteEvents = new Vector();
   int orientation;
   String overlayClickThrough;
   String overlayClickTracking;
   int overlayHeight;
   int overlayWidth;
   Vector pauseEvents = new Vector();
   Vector replayEvents = new Vector();
   Vector resumeEvents = new Vector();
   private int sequence;
   boolean showHtmlOverlay = false;
   int showHtmlOverlayAfter;
   boolean showSkipButton;
   int showSkipButtonAfter;
   String skipButtonImage;
   Vector skipEvents = new Vector();
   Vector startEvents = new Vector();
   HashMap timeTrackingEvents = new HashMap();
   String type;
   Vector unmuteEvents = new Vector();
   String videoClickThrough;
   List videoClickTracking;
   String videoUrl;
   int width;

   public Vector getCompleteEvents() {
      return this.completeEvents;
   }

   public int getSequence() {
      return this.sequence;
   }

   public Vector getStartEvents() {
      return this.startEvents;
   }

   public void setCompleteEvents(Vector var1) {
      this.completeEvents = var1;
   }

   public void setSequence(int var1) {
      this.sequence = var1;
   }

   public void setStartEvents(Vector var1) {
      this.startEvents = var1;
   }

   public String toString() {
      return "VideoData \n[\norientation=" + this.orientation + ",\ndisplay=" + this.display + ",\ndelivery=" + this.delivery + ",\ntype=" + this.type + ",\nbitrate=" + this.bitrate + ",\nwidth=" + this.width + ",\nheight=" + this.height + ",\nvideoUrl=" + this.videoUrl + ",\nduration=" + this.duration + ",\nshowSkipButton=" + this.showSkipButton + ",\nshowSkipButtonAfter=" + this.showSkipButtonAfter + ",\nskipButtonImage=" + this.skipButtonImage + this.timeTrackingEvents + ",\nstartEvents=" + this.getStartEvents() + ",\ncompleteEvents=" + this.getCompleteEvents() + ",\nmuteEvents=" + this.muteEvents + ",\nunmuteEvents=" + this.unmuteEvents + ",\npauseEvents=" + this.pauseEvents + ",\nunpauseEvents=" + this.resumeEvents + ",\nskipEvents=" + this.skipEvents + ",\nreplayEvents=" + this.replayEvents + ",\nshowHtmlOverlay=" + this.showHtmlOverlay + ",\nshowHtmlOverlayAfter=" + this.showHtmlOverlayAfter + ",\nhtmlOverlayType=" + this.htmlOverlayType + ",\nhtmlOverlayUrl=" + this.htmlOverlayUrl + ",\nhtmlOverlayMarkup=" + this.htmlOverlayMarkup + "\n]";
   }
}
