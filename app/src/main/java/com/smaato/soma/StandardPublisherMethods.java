package com.smaato.soma;

import com.smaato.soma.AdListenerInterface;
import com.smaato.soma.BaseInterface;

interface StandardPublisherMethods extends BaseInterface {
   void addAdListener(AdListenerInterface var1);

   boolean removeAdListener(AdListenerInterface var1);
}
