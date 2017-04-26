package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.Vocalizer$Listener;

public interface Vocalizer {
   void cancel();

   void setLanguage(String var1);

   void setListener(Vocalizer$Listener var1);

   void setVoice(String var1);

   void speakMarkupString(String var1, Object var2);

   void speakString(String var1, Object var2);
}
