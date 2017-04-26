package com.inmobi.monetization.internal;

public enum LtvpRuleProcessor$ActionsRule {
   ACTIONS_ONLY(3),
   ACTIONS_TO_MEDIATION(2),
   MEDIATION(0),
   NO_ADS(1);

   int a;

   private LtvpRuleProcessor$ActionsRule(int var3) {
      this.a = var3;
   }

   static LtvpRuleProcessor$ActionsRule a(int var0) {
      switch(var0) {
      case 1:
         return NO_ADS;
      case 2:
         return ACTIONS_TO_MEDIATION;
      case 3:
         return ACTIONS_ONLY;
      default:
         return MEDIATION;
      }
   }

   public final int getValue() {
      return this.a;
   }
}
