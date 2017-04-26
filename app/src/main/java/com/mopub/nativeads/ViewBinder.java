package com.mopub.nativeads;

import com.mopub.nativeads.ViewBinder$Builder;
import java.util.Map;

public class ViewBinder {
   final int callToActionId;
   final Map extras;
   final int iconImageId;
   final int layoutId;
   final int mainImageId;
   final int textId;
   final int titleId;

   private ViewBinder(ViewBinder$Builder var1) {
      this.layoutId = ViewBinder$Builder.access$0(var1);
      this.titleId = ViewBinder$Builder.access$1(var1);
      this.textId = ViewBinder$Builder.access$2(var1);
      this.callToActionId = ViewBinder$Builder.access$3(var1);
      this.mainImageId = ViewBinder$Builder.access$4(var1);
      this.iconImageId = ViewBinder$Builder.access$5(var1);
      this.extras = ViewBinder$Builder.access$6(var1);
   }

   // $FF: synthetic method
   ViewBinder(ViewBinder$Builder var1, ViewBinder var2) {
      this(var1);
   }
}
