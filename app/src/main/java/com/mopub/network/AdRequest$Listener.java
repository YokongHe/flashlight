package com.mopub.network;

import com.mopub.network.AdResponse;
import com.mopub.volley.Response$ErrorListener;

public interface AdRequest$Listener extends Response$ErrorListener {
   void onSuccess(AdResponse var1);
}
