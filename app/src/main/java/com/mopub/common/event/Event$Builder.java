package com.mopub.common.event;

import com.mopub.common.event.BaseEvent$Builder;
import com.mopub.common.event.Event;

public class Event$Builder extends BaseEvent$Builder {
   public Event$Builder(String var1, String var2) {
      super(var1, var2);
   }

   public Event build() {
      return new Event(this, (Event)null);
   }
}
