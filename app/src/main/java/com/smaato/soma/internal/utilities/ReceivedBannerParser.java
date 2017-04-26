package com.smaato.soma.internal.utilities;

import com.smaato.soma.ReceivedBannerInterface;
import com.smaato.soma.exception.ReceivedBannerParsingFailed;
import com.smaato.soma.internal.utilities.XmlParserInterface;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ReceivedBannerParser implements XmlParserInterface {
   private static final String ERROR_MESSAGE = "Error during the XML parsing. Can\'t find the response tag.";
   public static final String TAG = "SOMA_PARSER";

   public ReceivedBannerInterface doParsing(InputStream param1) {
      // $FF: Couldn't be decompiled
   }

   public ReceivedBannerInterface doParsing(String var1) {
      try {
         ReceivedBannerInterface var4 = this.doParsing((InputStream)(new ByteArrayInputStream(var1.getBytes("UTF-8"))));
         return var4;
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new ReceivedBannerParsingFailed(var3);
      }
   }
}
