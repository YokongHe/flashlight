package com.adsdk.sdk.video;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Text;

public class VAST$Ad$Creative$Tracking {
   @Attribute(
      name = "event"
   )
   String event;
   @Text
   String url;
}
