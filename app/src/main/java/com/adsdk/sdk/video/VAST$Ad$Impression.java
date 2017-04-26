package com.adsdk.sdk.video;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root(
   name = "Impression"
)
public class VAST$Ad$Impression {
   @Attribute(
      name = "id",
      required = false
   )
   String id;
   @Text
   String url;
}
