package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.GenericRecognition;
import com.nuance.nmdp.speechkit.SpeechError;
import com.nuance.nmdp.speechkit.TextRecognizer;

public interface TextRecognizer$Listener {
   void onError(TextRecognizer var1, SpeechError var2);

   void onResults(TextRecognizer var1, GenericRecognition var2);
}
