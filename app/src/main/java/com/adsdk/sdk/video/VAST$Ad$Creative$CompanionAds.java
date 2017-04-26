package com.adsdk.sdk.video;

import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(
   name = "CompanionAds"
)
public class VAST$Ad$Creative$CompanionAds {
   @ElementList(
      inline = true,
      required = false
   )
   List companions;
   @Attribute(
      name = "required",
      required = false
   )
   String required;
}
