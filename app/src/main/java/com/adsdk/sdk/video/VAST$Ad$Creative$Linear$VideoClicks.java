package com.adsdk.sdk.video;

import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(
   name = "VideoClicks"
)
public class VAST$Ad$Creative$Linear$VideoClicks {
   @Element(
      name = "ClickThrough",
      required = false
   )
   String clickThrough;
   @ElementList(
      inline = true,
      required = false
   )
   List clickTracking;
   @ElementList(
      inline = true,
      required = false
   )
   List customClicks;
}
