package com.adsdk.sdk.video;

import com.adsdk.sdk.video.VAST$Ad$Creative$Linear$VideoClicks;
import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(
   name = "Linear"
)
public class VAST$Ad$Creative$Linear {
   @Element(
      name = "Duration"
   )
   String duration;
   @ElementList(
      name = "MediaFiles"
   )
   List mediaFiles;
   @Attribute(
      name = "skipoffset",
      required = false
   )
   String skipoffset;
   @ElementList(
      name = "TrackingEvents",
      required = false
   )
   List trackingEvents;
   @Element(
      name = "VideoClicks",
      required = false
   )
   VAST$Ad$Creative$Linear$VideoClicks videoClicks;
}
