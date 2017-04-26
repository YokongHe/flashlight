package com.adsdk.sdk.video;

import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(
   name = "VAST"
)
public class VAST {
   @ElementList(
      inline = true
   )
   public List ads;
   @Element(
      name = "Error",
      required = false
   )
   public String error;
   @Attribute(
      name = "version"
   )
   public String version;
}
