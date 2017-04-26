package com.adsdk.sdk.video;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root(
   name = "StaticResource"
)
public class VAST$Ad$Creative$StaticResource {
   @Attribute(
      name = "creativeType",
      required = false
   )
   String type;
   @Text
   String url;
}
