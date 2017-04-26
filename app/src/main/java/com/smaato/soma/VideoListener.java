package com.smaato.soma;

import com.smaato.soma.VideoInterface;

public interface VideoListener {
   void onVideoFinished(VideoInterface var1);

   void onVideoPrepared(VideoInterface var1);
}
