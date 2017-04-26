package com.adsdk.sdk.video;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root(
   name = "CustomClick"
)
public class VAST$Ad$Creative$Linear$CustomClick {
   @Text
   String url;
}
