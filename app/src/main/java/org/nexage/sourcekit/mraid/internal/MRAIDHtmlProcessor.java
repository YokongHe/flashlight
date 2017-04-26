package org.nexage.sourcekit.mraid.internal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MRAIDHtmlProcessor {
   public static String processRawHtml(String var0) {
      boolean var3 = true;
      byte var4 = 0;
      StringBuffer var5 = new StringBuffer(var0);
      Matcher var6 = Pattern.compile("<script\\s+[^>]*\\bsrc\\s*=\\s*([\\\"\\\'])mraid\\.js\\1[^>]*>\\s*</script>\\n*", 2).matcher(var5);
      if(var6.find()) {
         var5.delete(var6.start(), var6.end());
      }

      boolean var1;
      if(var0.indexOf("<html") != -1) {
         var1 = true;
      } else {
         var1 = false;
      }

      boolean var2;
      if(var0.indexOf("<head") != -1) {
         var2 = true;
      } else {
         var2 = false;
      }

      if(var0.indexOf("<body") == -1) {
         var3 = false;
      }

      if(!var1 && (var2 || var3) || var1 && !var3) {
         return null;
      } else {
         var0 = System.getProperty("line.separator");
         int var8;
         if(!var1) {
            var5.insert(0, "<html>" + var0 + "<head>" + var0 + "</head>" + var0 + "<body><div align=\'center\'>" + var0);
            var5.append("</div></body>" + var0 + "</html>");
         } else if(!var2) {
            var6 = Pattern.compile("<html[^>]*>", 2).matcher(var5);

            for(var8 = 0; var6.find(var8); var8 = var6.end()) {
               var5.insert(var6.end(), var0 + "<head>" + var0 + "</head>");
            }
         }

         String var9 = "<style>" + var0 + "body { margin:0; padding:0;}" + var0 + "*:not(input) { -webkit-touch-callout:none; -webkit-user-select:none; -webkit-text-size-adjust:none; }" + var0 + "</style>";
         Matcher var7 = Pattern.compile("<head[^>]*>", 2).matcher(var5);

         for(var8 = var4; var7.find(var8); var8 = var7.end()) {
            var5.insert(var7.end(), var0 + "<meta name=\'viewport\' content=\'width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no\' />" + var0 + var9);
         }

         return var5.toString();
      }
   }
}
