package com.millennialmedia.android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.millennialmedia.android.MMBaseActivity;

class BridgeMMMedia$PickerActivity extends MMBaseActivity {
   private Uri fileUri;
   boolean hasRequestedPic = false;

   protected void onActivityResult(int param1, int param2, Intent param3) {
      // $FF: Couldn't be decompiled
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if(this.getLastNonConfigurationInstance() != null) {
         this.hasRequestedPic = ((Bundle)this.getLastNonConfigurationInstance()).getBoolean("hasRequestedPic");
      }

      if(!this.hasRequestedPic) {
         Intent var2;
         if(!this.getIntent().getStringExtra("type").equalsIgnoreCase("Camera")) {
            var2 = new Intent();
            var2.setType("image/*");
            var2.setAction("android.intent.action.GET_CONTENT");
            this.hasRequestedPic = true;
            this.startActivityForResult(var2, 0);
            return;
         }

         var2 = new Intent("android.media.action.IMAGE_CAPTURE");
         this.fileUri = this.getIntent().getData();
         var2.putExtra("return-data", true);
         this.hasRequestedPic = true;
         this.startActivityForResult(var2, 0);
      }

   }

   public Object onRetainNonConfigurationInstance() {
      super.onRetainNonConfigurationInstance();
      Bundle var1 = new Bundle();
      var1.putBoolean("hasRequestedPic", this.hasRequestedPic);
      return var1;
   }
}
