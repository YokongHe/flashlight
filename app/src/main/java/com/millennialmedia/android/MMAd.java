package com.millennialmedia.android;

import com.millennialmedia.android.MMRequest;
import com.millennialmedia.android.RequestListener;

public interface MMAd {
   String getApid();

   boolean getIgnoresDensityScaling();

   RequestListener getListener();

   MMRequest getMMRequest();

   void setApid(String var1);

   void setIgnoresDensityScaling(boolean var1);

   void setListener(RequestListener var1);

   void setMMRequest(MMRequest var1);
}
