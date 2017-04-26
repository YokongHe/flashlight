package org.nexage.sourcekit.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.nexage.sourcekit.util.DefaultMediaPicker$AreaComparator;
import org.nexage.sourcekit.util.VASTLog;
import org.nexage.sourcekit.vast.model.VASTMediaFile;
import org.nexage.sourcekit.vast.processor.VASTMediaPicker;

public class DefaultMediaPicker implements VASTMediaPicker {
   private static final String TAG = "DefaultMediaPicker";
   private static final int maxPixels = 5000;
   String SUPPORTED_VIDEO_TYPE_REGEX = "video/.*(?i)(mp4|3gpp|mp2t|webm|matroska)";
   private Context context;
   private int deviceArea;
   private int deviceHeight;
   private int deviceWidth;

   public DefaultMediaPicker(int var1, int var2) {
      this.setDeviceWidthHeight(var1, var2);
   }

   public DefaultMediaPicker(Context var1) {
      this.context = var1;
      this.setDeviceWidthHeight();
   }

   // $FF: synthetic method
   static int access$0(DefaultMediaPicker var0) {
      return var0.deviceArea;
   }

   private VASTMediaFile getBestMatch(List var1) {
      VASTLog.d("DefaultMediaPicker", "getBestMatch");
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         VASTMediaFile var2 = (VASTMediaFile)var3.next();
         if(this.isMediaFileCompatible(var2)) {
            return var2;
         }
      }

      return null;
   }

   private boolean isMediaFileCompatible(VASTMediaFile var1) {
      return var1.getType().matches(this.SUPPORTED_VIDEO_TYPE_REGEX);
   }

   private int prefilterMediaFiles(List var1) {
      Iterator var3 = var1.iterator();

      while(true) {
         while(var3.hasNext()) {
            VASTMediaFile var4 = (VASTMediaFile)var3.next();
            if(TextUtils.isEmpty(var4.getType())) {
               VASTLog.d("DefaultMediaPicker", "Validator error: mediaFile type empty");
               var3.remove();
            } else {
               BigInteger var5 = var4.getHeight();
               if(var5 == null) {
                  VASTLog.d("DefaultMediaPicker", "Validator error: mediaFile height null");
                  var3.remove();
               } else {
                  int var2 = var5.intValue();
                  if(var2 > 0 && var2 < 5000) {
                     var5 = var4.getWidth();
                     if(var5 == null) {
                        VASTLog.d("DefaultMediaPicker", "Validator error: mediaFile width null");
                        var3.remove();
                     } else {
                        var2 = var5.intValue();
                        if(var2 > 0 && var2 < 5000) {
                           if(TextUtils.isEmpty(var4.getValue())) {
                              VASTLog.d("DefaultMediaPicker", "Validator error: mediaFile url empty");
                              var3.remove();
                           }
                        } else {
                           VASTLog.d("DefaultMediaPicker", "Validator error: mediaFile width invalid: " + var2);
                           var3.remove();
                        }
                     }
                  } else {
                     VASTLog.d("DefaultMediaPicker", "Validator error: mediaFile height invalid: " + var2);
                     var3.remove();
                  }
               }
            }
         }

         return var1.size();
      }
   }

   private void setDeviceWidthHeight() {
      DisplayMetrics var1 = this.context.getResources().getDisplayMetrics();
      this.deviceWidth = var1.widthPixels;
      this.deviceHeight = var1.heightPixels;
      this.deviceArea = this.deviceWidth * this.deviceHeight;
   }

   private void setDeviceWidthHeight(int var1, int var2) {
      this.deviceWidth = var1;
      this.deviceHeight = var2;
      this.deviceArea = this.deviceWidth * this.deviceHeight;
   }

   public VASTMediaFile pickVideo(List var1) {
      if(var1 != null && this.prefilterMediaFiles(var1) != 0) {
         Collections.sort(var1, new DefaultMediaPicker$AreaComparator(this, (DefaultMediaPicker$AreaComparator)null));
         return this.getBestMatch(var1);
      } else {
         return null;
      }
   }
}
