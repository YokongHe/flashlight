package com.nuance.nmdp.speechkit;

public interface SpeechError {
   int getErrorCode();

   String getErrorDetail();

   String getSuggestion();
}
