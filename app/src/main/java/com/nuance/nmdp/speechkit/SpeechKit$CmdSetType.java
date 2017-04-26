package com.nuance.nmdp.speechkit;

public enum SpeechKit$CmdSetType {
   DRAGON_NLU(1),
   NVC(0);

   private int a;

   private SpeechKit$CmdSetType(int var3) {
      this.a = var3;
   }

   public final int getIndex() {
      return this.a;
   }
}
