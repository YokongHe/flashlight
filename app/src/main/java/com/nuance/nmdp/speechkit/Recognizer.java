package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.Prompt;
import com.nuance.nmdp.speechkit.Recognizer$Listener;

public interface Recognizer extends com.nuance.nmdp.speechkit.j {
   void cancel();

   float getAudioLevel();

   void setListener(Recognizer$Listener var1);

   void setPrompt(int var1, Prompt var2);

   void start();

   void stopRecording();
}
