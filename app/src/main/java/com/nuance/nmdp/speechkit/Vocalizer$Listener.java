package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.SpeechError;
import com.nuance.nmdp.speechkit.Vocalizer;

public interface Vocalizer$Listener {
   void onSpeakingBegin(Vocalizer var1, String var2, Object var3);

   void onSpeakingDone(Vocalizer var1, String var2, SpeechError var3, Object var4);
}
