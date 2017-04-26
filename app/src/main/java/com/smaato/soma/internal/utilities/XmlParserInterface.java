package com.smaato.soma.internal.utilities;

import com.smaato.soma.ReceivedBannerInterface;
import java.io.InputStream;

public interface XmlParserInterface {
   ReceivedBannerInterface doParsing(InputStream var1);

   ReceivedBannerInterface doParsing(String var1);
}
