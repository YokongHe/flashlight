package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.Recognition;
import com.nuance.nmdp.speechkit.Recognizer;
import com.nuance.nmdp.speechkit.SpeechError;

public interface Recognizer$Listener {
   void onError(Recognizer var1, SpeechError var2);

   void onRecordingBegin(Recognizer var1);

   void onRecordingDone(Recognizer var1);

   void onResults(Recognizer var1, Recognition var2);
}
