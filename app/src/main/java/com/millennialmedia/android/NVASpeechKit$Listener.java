package com.millennialmedia.android;

import com.millennialmedia.android.NVASpeechKit$State;

public interface NVASpeechKit$Listener {
   void onAudioLevelUpdate(double var1);

   void onAudioSampleUpdate(double var1);

   void onCustomWordsAdded();

   void onCustomWordsDeleted();

   void onError();

   void onResults();

   void onStateChange(NVASpeechKit$State var1);
}
