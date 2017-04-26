package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.GenericRecognition;
import java.util.LinkedList;

final class h implements .J {
   private LinkedList a = new LinkedList();
   private boolean b = false;

   private boolean a(.bb param1) {
      // $FF: Couldn't be decompiled
   }

   public final boolean a() {
      return this.b;
   }

   // $FF: synthetic method
   public final Object b() {
      return !this.a.isEmpty()?(GenericRecognition)this.a.remove():null;
   }
}
