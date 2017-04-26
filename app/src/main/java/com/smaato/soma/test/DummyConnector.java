package com.smaato.soma.test;

import android.content.Context;
import android.util.Log;
import com.smaato.soma.AdType;
import com.smaato.soma.ErrorCode;
import com.smaato.soma.ReceivedBannerInterface;
import com.smaato.soma.bannerutilities.constant.BannerStatus;
import com.smaato.soma.internal.ReceivedBanner;
import com.smaato.soma.internal.requests.HttpConnectorInterface;
import com.smaato.soma.internal.utilities.ConnectionListenerInterface;
import com.smaato.soma.test.DummyConnector$DownloadTask;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DummyConnector implements HttpConnectorInterface {
   public static String TAG = "SOMA_DummyConnector";
   private static DummyConnector instance;
   private int currentBanner = 0;
   private List mBannerList = new ArrayList();
   private ConnectionListenerInterface mConnectionListener = null;
   private ReceivedBanner mNextBanner = null;

   private DummyConnector(String var1) {
   }

   // $FF: synthetic method
   static ReceivedBanner access$0(DummyConnector var0) {
      return var0.mNextBanner;
   }

   // $FF: synthetic method
   static ConnectionListenerInterface access$1(DummyConnector var0) {
      return var0.mConnectionListener;
   }

   public static DummyConnector getInstance() {
      if(instance == null) {
         instance = new DummyConnector("");
      }

      return instance;
   }

   public void asyncLoadBeacons() {
   }

   public boolean asyncLoadNewBanner(URL var1) {
      Log.d(TAG, "Create new DownloadTask");
      (new DummyConnector$DownloadTask(this, (DummyConnector$DownloadTask)null)).execute(new String[]{var1.toString()});
      return true;
   }

   public ReceivedBanner createImageBanner() {
      ReceivedBanner var1 = new ReceivedBanner();
      var1.setStatus(BannerStatus.SUCCESS);
      var1.setAdType(AdType.IMAGE);
      var1.setImageUrl("http://i.xx.openx.com/ef3/ef31c13c898edcdfc73feb3c0193b64bcfa70082/754/7544eb4e2c8cb99b125559b8846ce948_2.jpeg");
      var1.setClickUrl("http://www.smaato.com");
      return var1;
   }

   public ReceivedBanner createNoAvailable() {
      ReceivedBanner var1 = new ReceivedBanner();
      var1.setStatus(BannerStatus.ERROR);
      var1.setErrorCode(ErrorCode.NO_AD_AVAILABLE);
      var1.setErrorMessage("Currently no ad available.");
      return var1;
   }

   public ReceivedBanner createRichMediaBanner() {
      ReceivedBanner var1 = new ReceivedBanner();
      var1.setStatus(BannerStatus.SUCCESS);
      var1.setAdType(AdType.RICHMEDIA);
      var1.setAdText("<div class=\"tma-ad\" tma-zone-id=\"si-d6771f58-a5b2-45d7-4abf-3f35ecfaa50b\" tma-format=\"320x50\"></div>\n<script type=\"text/javascript\" src=\"http://relay.mobile.toboads.com/\"></script>");
      return var1;
   }

   public ReceivedBanner createRichMediaBanner2() {
      ReceivedBanner var1 = new ReceivedBanner();
      var1.setStatus(BannerStatus.SUCCESS);
      var1.setAdType(AdType.RICHMEDIA);
      var1.setAdText("<script language=\'javascript\' type=\'text/javascript\'>__CrispApiUrl=\'http://api.crispwireless.com/\';__CrispAdRequestUrl=\'http://cdn1.crispadvertising.com/afw/2.1/framework/client/adrequest.js\';__CrispExternalViewURL=\'%VIEWURL%\';__CrispExternalClickURL=\'%CLICKURL%\';var _cacinit=function(){var src=__CrispAdRequestUrl;var props={zid:\'1418\',partnerkey:\'afa1a1efc4977cc8bc83a8fe6a952a39\',sitekey:\'DEFAULT\',publisherid:\'374\',divid:\'\',cb:Math.floor(Math.random()*99999999999)};var scripts=document.getElementsByTagName(\'script\');var index=scripts.length-1;var me=scripts[index];var js=document.createElement(\'script\');js.setAttribute(\'language\',\'javascript\');js.setAttribute(\'type\',\'text/javascript\');js.setAttribute(\'src\',src);js.setAttribute(\'id\',\'loader\'+Math.random()*99999999999);js.setAttribute(\'defer\',\'defer\');js.onload=function(){js.onloadDone=true;crisploader.loader(props,this);};js.onreadystatechange=function(){if(\'loaded\'===js.readyState){if(!js.onloadDone){js.onloadDone=true;crisploader.loader(props,this);}}};if(me.parentNode) me.parentNode.appendChild(js);};_cacinit();</script><noscript>Advertisement<img src=\'http://api.crispwireless.com/adRequest/control/noscript.gif?sitekey=DEFAULT&amp;partnerkey=afa1a1efc4977cc8bc83a8fe6a952a39&amp;zid=1418&amp;publisherid=374\' style=\'display:none;\' width=\'5\' height=\'5\'/></noscript><img src=\'http://api.crispwireless.com/adRequest/control/ad.gif?sitekey=DEFAULT&amp;partnerkey=afa1a1efc4977cc8bc83a8fe6a952a39&amp;zid=1418&amp;publisherid=374\' style=\'display:none;\' width=\'5\' height=\'5\'/><div id=\'beacon_8a7475eb48\' style=\'position: absolute; left: 0px; top: 0px; visibility: hidden;\'><img src=\'http://adelh.smaato.com/lg.php?bannerid=60196&amp;campaignid=3692&amp;zoneid=0&amp;loc=1&amp;referer=http%3A%2F%2Fadelh.smaato.com%2Faxmlrpc.php%3Fsize%3Dxlarge%26img%3Dtrue%26carrier%3DT-Mobile%2B%2528WiFi%252FWLAN%2529&amp;cb=8a7475eb48&amp;r_id=c161faf29bc4cd1b964223995850ece4&amp;r_ts=ln8y6l\' width=\'0\' height=\'0\' alt=\'\' style=\'width: 0px; height: 0px;\' /></div>");
      return var1;
   }

   public ReceivedBanner createRichMediaBanner3() {
      ReceivedBanner var1 = new ReceivedBanner();
      var1.setStatus(BannerStatus.SUCCESS);
      var1.setAdType(AdType.RICHMEDIA);
      var1.setAdText("<script language=\'javascript\' type=\'text/javascript\'>__CrispApiUrl=\'http://api.crispwireless.com/\';__CrispAdRequestUrl=\'http://cdn1.crispadvertising.com/afw/2.1/framework/client/adrequest.js\';__CrispExternalViewURL=\'%VIEWURL%\';__CrispExternalClickURL=\'%CLICKURL%\';var _cacinit=function(){var src=__CrispAdRequestUrl;var props={partnerkey:\'afa1a1efc4977cc8bc83a8fe6a952a39\',sitekey:\'DEFAULT\',bannerid:\'4155\',divid:\'\',cb:Math.floor(Math.random()*99999999999)};var scripts=document.getElementsByTagName(\'script\');var index=scripts.length-1;var me=scripts[index];var js=document.createElement(\'script\');js.setAttribute(\'language\',\'javascript\');js.setAttribute(\'type\',\'text/javascript\');js.setAttribute(\'src\',src);js.setAttribute(\'id\',\'loader\'+Math.random()*99999999999);js.setAttribute(\'defer\',\'defer\');js.onload=function(){js.onloadDone=true;crisploader.loader(props,this);};js.onreadystatechange=function(){if(\'loaded\'===js.readyState && !js.onloadDone){js.onloadDone=true;crisploader.loader(props,this);}};if(me.parentNode) me.parentNode.appendChild(js);};_cacinit();</script><noscript>Advertisement</noscript><div id=\'beacon_6af462c795\' style=\'position: absolute; left: 0px; top: 0px; visibility: hidden;\'><img src=\'http://adelh.smaato.com/lg.php?bannerid=57708&amp;campaignid=3692&amp;zoneid=0&amp;loc=1&amp;referer=http%3A%2F%2Fadelh.smaato.com%2Faxmlrpc.php%3Fsize%3Dxlarge%26img%3Dtrue%26carrier%3DT-Mobile%2B%2528WiFi%252FWLAN%2529&amp;cb=6af462c795&amp;r_id=20b1af536e51079d611b279e5e2e5a7e&amp;r_ts=ln8ydk\' width=\'0\' height=\'0\' alt=\'\' style=\'width: 0px; height: 0px;\' /></div>");
      return var1;
   }

   public ReceivedBanner createTextBanner() {
      ReceivedBanner var1 = new ReceivedBanner();
      var1.setStatus(BannerStatus.SUCCESS);
      var1.setAdType(AdType.TEXT);
      var1.setAdText("Visit SMAATO");
      var1.setClickUrl("http://www.smaato.com");
      return var1;
   }

   public ReceivedBanner getNextBanner() {
      return this.mNextBanner;
   }

   public void init() {
      this.mNextBanner = null;
   }

   public ReceivedBannerInterface loadNewBanner(URL var1) {
      if(this.mNextBanner != null) {
         Log.d(TAG, "Returning " + this.mNextBanner.getRichMediaData());
      } else {
         Log.d(TAG, "mNextBanner not set!");
      }

      return this.mNextBanner;
   }

   public void sendSomaTrackingPing(Context var1) {
   }

   public void setConnectionListener(ConnectionListenerInterface var1) {
      this.mConnectionListener = var1;
   }

   public void setNextBanner(ReceivedBanner var1) {
      Log.d(TAG, "Setting banner to " + var1.getRichMediaData());
      this.mNextBanner = var1;
   }
}
