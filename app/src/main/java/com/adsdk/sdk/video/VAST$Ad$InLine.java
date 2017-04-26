package com.adsdk.sdk.video;

import com.adsdk.sdk.video.VAST$Ad$AdSystem;
import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(
   name = "InLine"
)
public class VAST$Ad$InLine {
   @Element(
      name = "AdSystem"
   )
   VAST$Ad$AdSystem adSystem;
   @Element(
      name = "AdTitle"
   )
   String adTitle;
   @Element(
      name = "Advertiser",
      required = false
   )
   String advertiser;
   @ElementList(
      name = "Creatives"
   )
   List creatives;
   @Element(
      name = "Description",
      required = false
   )
   String description;
   @Element(
      name = "Error",
      required = false
   )
   String error;
   @ElementList(
      inline = true
   )
   List impressions;
}
