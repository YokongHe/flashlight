package com.smaato.soma.bannerutilities;

import com.smaato.soma.ReceivedBannerInterface;
import com.smaato.soma.bannerutilities.AbstractBannerPackage;
import com.smaato.soma.debug.Debugger;
import com.smaato.soma.exception.UnableToGenerateTextBanner;

public class TextBanner extends AbstractBannerPackage {
   private final String CLOSE_BODY = "         }\n";
   private final String LINE_END = "\n";
   private final String MARGIN = "margin: 0px;\n";
   private final String PADDING = "             padding: 0px;\n";
   private final String SCRIPT_OPEN = "     <script>\n";
   private final String WHITE_SPACE = "             white-space: nowrap;\n";

   protected StringBuffer createPage(ReceivedBannerInterface var1, int var2, int var3, boolean var4) {
      StringBuffer var5 = new StringBuffer();

      try {
         Debugger.methodStart(new Object() {
         });
         var5.append("<html>\n");
         var5.append("    <head>\n");
         var5.append("        <style type=\"text/css\">\n");
         var5.append("         body {\n");
         var5.append("             height:100%;");
         var5.append("             background: #f2f5f0; /* Old browsers */\n");
         var5.append("             background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#f2f5f0), color-stop(18%,#e9ece7), color-stop(71%,#bdc1bb), color-stop(94%,#aeb2ab), color-stop(100%,#acb0a9)); /* Chrome,Safari4+ */\n");
         var5.append("             background: -webkit-linear-gradient(top, #f2f5f0 0%,#e9ece7 18%,#bdc1bb 71%,#aeb2ab 94%,#acb0a9 100%); /* Chrome10+,Safari5.1+ */\n");
         var5.append("             background: linear-gradient(top, #f2f5f0 0%,#e9ece7 18%,#bdc1bb 71%,#aeb2ab 94%,#acb0a9 100%); /* W3C */\n");
         var5.append("         }\n");
         var5.append("        </style>\n");
         var5.append("     <script>\n");
         var5.append("            function openLink() {\n");
         var5.append("                document.body.style.height = \"auto\"\n");
         var5.append("                smaato_bridge.legacyExpand();\n");
         var5.append("                document.location=\'" + var1.getClickUrl() + "\';\n");
         var5.append("            }\n");
         var5.append("     </script>\n");
         var5.append("     <script>\n");
         var5.append("                         var clicked=false;");
         var5.append("                         function isClicked(){if(!clicked){clicked = true; return false;}return clicked;}");
         var5.append("     </script>\n");
         var5.append("    </head>\n");
         var5.append("    <body align=\"center\" onclick=\"if(!isClicked()){openLink(); } else{}\">\n");
         var5.append("        <table align=\"center\" border=\"0\" height=\"100%\" width=\"100%\"> <tr>\n");
         var5.append(var1.getAdText());
         var5.append("       </tr> </table>\n");
         var5.append("    </body>\n");
         var5.append("</html>\n");
         return var5;
      } catch (RuntimeException var6) {
         throw var6;
      } catch (Exception var7) {
         throw new UnableToGenerateTextBanner(var7);
      }
   }
}
