package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.DataUploadCommand;
import com.nuance.nmdp.speechkit.DataUploadResult;
import com.nuance.nmdp.speechkit.SpeechError;

public interface DataUploadCommand$Listener {
   void onError(DataUploadCommand var1, SpeechError var2);

   void onResults(DataUploadCommand var1, DataUploadResult var2);
}
