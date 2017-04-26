package org.nexage.sourcekit.vast.model;

public enum VAST_DOC_ELEMENTS {
   vastAdTagURI("VASTAdTagURI"),
   vastVersion("2.0"),
   vastVersionAttribute("version"),
   vasts("VASTS");

   private String value;

   private VAST_DOC_ELEMENTS(String var3) {
      this.value = var3;
   }

   public final String getValue() {
      return this.value;
   }
}
