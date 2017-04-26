package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.GenericRecognition;
import com.nuance.nmdp.speechkit.NluRecognizer;
import com.nuance.nmdp.speechkit.SpeechError;

public interface NluRecognizer$Listener {
   void onError(NluRecognizer var1, SpeechError var2);

   void onRecordingBegin(NluRecognizer var1);

   void onRecordingDone(NluRecognizer var1);

   void onResults(NluRecognizer var1, GenericRecognition var2);
}
