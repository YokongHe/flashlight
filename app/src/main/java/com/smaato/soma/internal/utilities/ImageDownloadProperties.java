package com.smaato.soma.internal.utilities;

import android.content.Context;

public class ImageDownloadProperties {
   Context context;
   String url;

   public ImageDownloadProperties(String var1, Context var2) {
      this.url = var1;
      this.context = var2;
   }

   public final Context getContext() {
      return this.context;
   }

   public final String getUrl() {
      return this.url;
   }

   public final void setContext(Context var1) {
      this.context = var1;
   }

   public final void setUrl(String var1) {
      this.url = var1;
   }
}
