package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.NluRecognizer$Listener;
import com.nuance.nmdp.speechkit.Prompt;

public interface NluRecognizer extends com.nuance.nmdp.speechkit.j {
   void cancel();

   float getAudioLevel();

   void setListener(NluRecognizer$Listener var1);

   void setPrompt(int var1, Prompt var2);

   void start();

   void stopRecording();
}
