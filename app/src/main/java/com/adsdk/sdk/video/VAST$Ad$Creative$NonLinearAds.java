package com.adsdk.sdk.video;

import java.util.List;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(
   name = "NonLinearAds"
)
public class VAST$Ad$Creative$NonLinearAds {
   @ElementList(
      inline = true,
      required = false
   )
   List nonLinears;
   @ElementList(
      name = "TrackingEvents",
      required = false
   )
   List trackingEvents;
}
