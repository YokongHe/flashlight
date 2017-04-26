package com.adsdk.sdk.video;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root(
   name = "ClickTracking"
)
public class VAST$Ad$Creative$Linear$ClickTracking {
   @Text
   String url;
}
