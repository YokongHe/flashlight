package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.GenericCommand;
import com.nuance.nmdp.speechkit.GenericResult;
import com.nuance.nmdp.speechkit.SpeechError;

public interface GenericCommand$Listener {
   void onComplete(GenericCommand var1, GenericResult var2, SpeechError var3);
}
