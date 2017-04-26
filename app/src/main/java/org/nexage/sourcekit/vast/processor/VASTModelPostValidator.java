package org.nexage.sourcekit.vast.processor;

import android.text.TextUtils;
import java.util.List;
import org.nexage.sourcekit.util.VASTLog;
import org.nexage.sourcekit.vast.model.VASTMediaFile;
import org.nexage.sourcekit.vast.model.VASTModel;
import org.nexage.sourcekit.vast.processor.VASTMediaPicker;

public class VASTModelPostValidator {
   private static final String TAG = "VASTModelPostValidator";

   public static boolean validate(VASTModel var0, VASTMediaPicker var1) {
      boolean var3 = false;
      VASTLog.d("VASTModelPostValidator", "validate");
      if(!validateModel(var0)) {
         VASTLog.d("VASTModelPostValidator", "Validator returns: not valid (invalid model)");
         return false;
      } else {
         boolean var2;
         if(var1 != null) {
            VASTMediaFile var5 = var1.pickVideo(var0.getMediaFiles());
            var2 = var3;
            if(var5 != null) {
               String var6 = var5.getValue();
               var2 = var3;
               if(!TextUtils.isEmpty(var6)) {
                  var2 = true;
                  var0.setPickedMediaFileURL(var6);
                  VASTLog.d("VASTModelPostValidator", "mediaPicker selected mediaFile with URL " + var6);
               }
            }
         } else {
            VASTLog.w("VASTModelPostValidator", "mediaPicker: We don\'t have a compatible media file to play.");
            var2 = var3;
         }

         StringBuilder var7 = new StringBuilder("Validator returns: ");
         String var4;
         if(var2) {
            var4 = "valid";
         } else {
            var4 = "not valid (no media file)";
         }

         VASTLog.d("VASTModelPostValidator", var7.append(var4).toString());
         return var2;
      }
   }

   private static boolean validateModel(VASTModel var0) {
      VASTLog.d("VASTModelPostValidator", "validateModel");
      boolean var1 = true;
      List var2 = var0.getImpressions();
      if(var2 == null || var2.size() == 0) {
         var1 = false;
      }

      List var3 = var0.getMediaFiles();
      if(var3 == null || var3.size() == 0) {
         VASTLog.d("VASTModelPostValidator", "Validator error: mediaFile list invalid");
         var1 = false;
      }

      return var1;
   }
}
