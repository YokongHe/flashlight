package com.mopub.nativeads;

import android.location.Location;
import android.text.TextUtils;
import com.mopub.nativeads.RequestParameters$Builder;
import java.util.EnumSet;

public class RequestParameters {
   private final EnumSet mDesiredAssets;
   private final String mKeywords;
   private final Location mLocation;

   private RequestParameters(RequestParameters$Builder var1) {
      this.mKeywords = RequestParameters$Builder.access$0(var1);
      this.mLocation = RequestParameters$Builder.access$1(var1);
      this.mDesiredAssets = RequestParameters$Builder.access$2(var1);
   }

   // $FF: synthetic method
   RequestParameters(RequestParameters$Builder var1, RequestParameters var2) {
      this(var1);
   }

   public final String getDesiredAssets() {
      String var1 = "";
      if(this.mDesiredAssets != null) {
         var1 = TextUtils.join(",", this.mDesiredAssets.toArray());
      }

      return var1;
   }

   public final String getKeywords() {
      return this.mKeywords;
   }

   public final Location getLocation() {
      return this.mLocation;
   }
}
