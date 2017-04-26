package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.Prompt;
import com.nuance.nmdp.speechkit.TextRecognizer$Listener;

public interface TextRecognizer {
   void cancel();

   void setListener(TextRecognizer$Listener var1);

   void setPrompt(int var1, Prompt var2);

   void start();
}
