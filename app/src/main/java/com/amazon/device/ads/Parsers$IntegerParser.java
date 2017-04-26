package com.amazon.device.ads;

import com.amazon.device.ads.Log;
import com.amazon.device.ads.StringUtils;

public class Parsers$IntegerParser {
   private int defaultValue;
   private String parseErrorLogMessage;
   private String parseErrorLogTag;

   public int parse(String var1) {
      int var3 = this.defaultValue;
      int var2 = var3;
      if(!StringUtils.isNullOrWhiteSpace(var1)) {
         try {
            var2 = Integer.parseInt(var1);
         } catch (NumberFormatException var4) {
            var2 = var3;
            if(this.parseErrorLogTag != null) {
               var2 = var3;
               if(this.parseErrorLogMessage != null) {
                  Log.w(this.parseErrorLogTag, this.parseErrorLogMessage);
                  return var3;
               }
            }
         }
      }

      return var2;
   }

   public Parsers$IntegerParser setDefaultValue(int var1) {
      this.defaultValue = var1;
      return this;
   }

   public Parsers$IntegerParser setParseErrorLogMessage(String var1) {
      this.parseErrorLogMessage = var1;
      return this;
   }

   public Parsers$IntegerParser setParseErrorLogTag(String var1) {
      this.parseErrorLogTag = var1;
      return this;
   }
}
