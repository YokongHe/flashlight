package com.amazon.device.ads;

import android.graphics.Bitmap;
import com.amazon.device.ads.ImageUtils;
import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.Log;
import com.amazon.device.ads.StringUtils;
import java.io.InputStream;
import org.json.JSONObject;

class ResponseReader {
   private static final String LOGTAG = ResponseReader.class.getSimpleName();
   private boolean enableLog = false;
   private String logTag;
   private final InputStream stream;

   ResponseReader(InputStream var1) {
      this.logTag = LOGTAG;
      this.stream = var1;
   }

   public void enableLog(boolean var1) {
      this.enableLog = var1;
   }

   public Bitmap readAsBitmap() {
      return ImageUtils.createBitmapImage(this.stream);
   }

   public JSONObject readAsJSON() {
      return JSONUtils.getJSONObjectFromString(this.readAsString());
   }

   public String readAsString() {
      String var1 = StringUtils.readStringFromInputStream(this.stream);
      if(this.enableLog) {
         Log.d(this.logTag, "Response Body: %s", new Object[]{var1});
      }

      return var1;
   }

   public void setExternalLogTag(String var1) {
      if(var1 == null) {
         this.logTag = LOGTAG;
      } else {
         this.logTag = LOGTAG + " " + var1;
      }
   }
}
