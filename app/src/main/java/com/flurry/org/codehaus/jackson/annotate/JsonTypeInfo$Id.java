package com.flurry.org.codehaus.jackson.annotate;

public enum JsonTypeInfo$Id {
   CLASS("@class"),
   CUSTOM((String)null),
   MINIMAL_CLASS("@c"),
   NAME("@type"),
   NONE((String)null);

   private final String _defaultPropertyName;

   private JsonTypeInfo$Id(String var3) {
      this._defaultPropertyName = var3;
   }

   public final String getDefaultPropertyName() {
      return this._defaultPropertyName;
   }
}
