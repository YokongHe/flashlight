package com.mopub.mraid;

import java.util.Locale;

public enum ViewState {
   DEFAULT,
   EXPANDED,
   HIDDEN,
   LOADING,
   RESIZED;

   public final String toJavascriptString() {
      return this.toString().toLowerCase(Locale.US);
   }
}
