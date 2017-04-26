package com.adsdk.sdk.video;

import com.adsdk.sdk.video.VAST$Ad$InLine;
import com.adsdk.sdk.video.VAST$Ad$Wrapper;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(
   name = "Ad"
)
public class VAST$Ad {
   @Attribute(
      name = "id",
      required = false
   )
   String id;
   @Element(
      name = "InLine",
      required = false
   )
   VAST$Ad$InLine inLine;
   @Attribute(
      name = "sequence",
      required = false
   )
   int sequence;
   @Element(
      name = "Wrapper",
      required = false
   )
   VAST$Ad$Wrapper wrapper;
}
