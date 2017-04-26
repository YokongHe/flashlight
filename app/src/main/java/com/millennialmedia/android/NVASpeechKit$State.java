package com.millennialmedia.android;

public enum NVASpeechKit$State {
   ERROR("error"),
   PROCESSING("processing"),
   READY("ready"),
   RECORDING("recording"),
   VOCALIZING("vocalizing");

   private String name;

   private NVASpeechKit$State(String var3) {
      this.name = var3;
   }

   public final String toString() {
      return this.name;
   }
}
