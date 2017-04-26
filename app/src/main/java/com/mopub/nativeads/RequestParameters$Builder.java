package com.mopub.nativeads;

import android.location.Location;
import com.mopub.nativeads.RequestParameters;
import java.util.EnumSet;

public final class RequestParameters$Builder {
   private EnumSet desiredAssets;
   private String keywords;
   private Location location;

   // $FF: synthetic method
   static String access$0(RequestParameters$Builder var0) {
      return var0.keywords;
   }

   // $FF: synthetic method
   static Location access$1(RequestParameters$Builder var0) {
      return var0.location;
   }

   // $FF: synthetic method
   static EnumSet access$2(RequestParameters$Builder var0) {
      return var0.desiredAssets;
   }

   public final RequestParameters build() {
      return new RequestParameters(this, (RequestParameters)null);
   }

   public final RequestParameters$Builder desiredAssets(EnumSet var1) {
      this.desiredAssets = EnumSet.copyOf(var1);
      return this;
   }

   public final RequestParameters$Builder keywords(String var1) {
      this.keywords = var1;
      return this;
   }

   public final RequestParameters$Builder location(Location var1) {
      this.location = var1;
      return this;
   }
}
