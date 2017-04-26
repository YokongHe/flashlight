package com.smaato.soma;

import com.smaato.soma.VideoInterface$VideoState;

public interface VideoInterface {
   VideoInterface$VideoState getState();

   void pause();

   void start();

   void stop();
}
