package com.millennialmedia.android;

import com.millennialmedia.android.NVASpeechKit;

public class NVASpeechKit$Result {
   public final int resultScore;
   public final String resultString;
   // $FF: synthetic field
   final NVASpeechKit this$0;

   public NVASpeechKit$Result(NVASpeechKit var1, String var2, double var3) {
      this.this$0 = var1;
      this.resultString = var2;
      this.resultScore = (int)var3;
   }

   public int getResultScore() {
      return this.resultScore;
   }

   public String getResultString() {
      return this.resultString;
   }
}
