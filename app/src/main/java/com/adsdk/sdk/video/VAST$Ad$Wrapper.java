package com.adsdk.sdk.video;

import com.adsdk.sdk.video.VAST$Ad$AdSystem;
import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(
   name = "Wrapper"
)
public class VAST$Ad$Wrapper {
   @Element(
      name = "VASTAdTagURI"
   )
   String VASTAdTagUri;
   @Element(
      name = "AdSystem"
   )
   VAST$Ad$AdSystem adSystem;
   @ElementList(
      name = "Creatives",
      required = false
   )
   List creatives;
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
