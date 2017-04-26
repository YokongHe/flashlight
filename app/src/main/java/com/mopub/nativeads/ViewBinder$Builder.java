package com.mopub.nativeads;

import com.mopub.nativeads.ViewBinder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ViewBinder$Builder {
   private int callToActionId;
   private Map extras = Collections.emptyMap();
   private int iconImageId;
   private final int layoutId;
   private int mainImageId;
   private int textId;
   private int titleId;

   public ViewBinder$Builder(int var1) {
      this.layoutId = var1;
      this.extras = new HashMap();
   }

   // $FF: synthetic method
   static int access$0(ViewBinder$Builder var0) {
      return var0.layoutId;
   }

   // $FF: synthetic method
   static int access$1(ViewBinder$Builder var0) {
      return var0.titleId;
   }

   // $FF: synthetic method
   static int access$2(ViewBinder$Builder var0) {
      return var0.textId;
   }

   // $FF: synthetic method
   static int access$3(ViewBinder$Builder var0) {
      return var0.callToActionId;
   }

   // $FF: synthetic method
   static int access$4(ViewBinder$Builder var0) {
      return var0.mainImageId;
   }

   // $FF: synthetic method
   static int access$5(ViewBinder$Builder var0) {
      return var0.iconImageId;
   }

   // $FF: synthetic method
   static Map access$6(ViewBinder$Builder var0) {
      return var0.extras;
   }

   public final ViewBinder$Builder addExtra(String var1, int var2) {
      this.extras.put(var1, Integer.valueOf(var2));
      return this;
   }

   public final ViewBinder$Builder addExtras(Map var1) {
      this.extras = new HashMap(var1);
      return this;
   }

   public final ViewBinder build() {
      return new ViewBinder(this, (ViewBinder)null);
   }

   public final ViewBinder$Builder callToActionId(int var1) {
      this.callToActionId = var1;
      return this;
   }

   public final ViewBinder$Builder iconImageId(int var1) {
      this.iconImageId = var1;
      return this;
   }

   public final ViewBinder$Builder mainImageId(int var1) {
      this.mainImageId = var1;
      return this;
   }

   public final ViewBinder$Builder textId(int var1) {
      this.textId = var1;
      return this;
   }

   public final ViewBinder$Builder titleId(int var1) {
      this.titleId = var1;
      return this;
   }
}
