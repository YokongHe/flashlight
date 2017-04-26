package com.millennialmedia.android;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.millennialmedia.android.AdCache;
import com.millennialmedia.android.BridgeMMMedia$Audio;
import com.millennialmedia.android.BridgeMMMedia$Audio$PeriodicListener;
import com.millennialmedia.android.BridgeMMSpeechkit$SingletonHolder;
import com.millennialmedia.android.BridgeMMSpeechkit$SpeechKitHolder;
import com.millennialmedia.android.HandShake;
import com.millennialmedia.android.HandShake$NuanceCredentials;
import com.millennialmedia.android.MMJSObject;
import com.millennialmedia.android.MMJSResponse;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.MMWebView;
import com.millennialmedia.android.NVASpeechKit;
import com.millennialmedia.android.NVASpeechKit$CustomWordsOp;
import java.io.File;
import java.util.Map;

public class BridgeMMSpeechkit extends MMJSObject implements OnCompletionListener, BridgeMMMedia$Audio$PeriodicListener {
   private static final String TAG = "BridgeMMSpeechkit";
   private String ADD_CUSTOM_VOICE_WORDS = "addCustomVoiceWords";
   private String CACHE_AUDIO = "cacheAudio";
   private String DELETE_CUSTOM_VOICE_WORDS = "deleteCustomVoiceWords";
   private String END_RECORDING = "endRecording";
   private String GET_SESSION_ID = "getSessionId";
   private String PLAY_AUDIO = "playAudio";
   private String RELEASE_VOICE = "releaseVoice";
   private String SAMPLE_BACKGROUND_AUDIO_LEVEL = "sampleBackgroundAudioLevel";
   private String START_RECORDING = "startRecording";
   private String STOP_AUDIO = "stopAudio";
   private String TEXT_TO_SPEECH = "textToSpeech";

   private NVASpeechKit getCreateSpeechKit() {
      MMWebView var2 = (MMWebView)this.mmWebViewRef.get();
      if(var2 != null && var2.allowSpeechCreationCommands()) {
         if(getSpeechKitInternal() != null) {
            return getSpeechKitInternal();
         }

         Context var1 = var2.getContext();
         if(var1 != null) {
            NVASpeechKit var4 = new NVASpeechKit(var2);
            setSpeechKit(var4);
            HandShake$NuanceCredentials var3 = HandShake.sharedHandShake(var1).nuanceCredentials;
            if(var3 != null) {
               var4.initialize(var3, var1.getApplicationContext());
            }

            return var4;
         }
      }

      return null;
   }

   static BridgeMMSpeechkit$SpeechKitHolder getInstance() {
      return BridgeMMSpeechkit$SingletonHolder.INSTANCE;
   }

   private NVASpeechKit getSpeechKit() {
      MMWebView var1 = (MMWebView)this.mmWebViewRef.get();
      return var1 != null && var1.allowRecordingCommands()?getSpeechKitInternal():null;
   }

   static NVASpeechKit getSpeechKitInternal() {
      return getInstance().getSpeechKit();
   }

   private NVASpeechKit getSpeechKitRelease() {
      return getSpeechKitInternal();
   }

   private MMJSResponse playAudioInternal(Map var1) {
      Context var3 = (Context)this.contextRef.get();
      String var4 = (String)var1.get("path");
      if(var3 != null && var4 != null) {
         BridgeMMMedia$Audio var2 = BridgeMMMedia$Audio.sharedAudio(var3);
         if(var2 == null) {
            return null;
         }

         if(var2.isPlaying()) {
            return MMJSResponse.responseWithError("Audio already playing.");
         }

         if(var4.startsWith("http")) {
            return var2.playAudio(Uri.parse(var4), Boolean.parseBoolean((String)var1.get("repeat")));
         }

         File var5 = AdCache.getDownloadFile(var3, var4);
         if(var5.exists()) {
            return var2.playAudio(Uri.fromFile(var5), Boolean.parseBoolean((String)var1.get("repeat")));
         }
      }

      return null;
   }

   static boolean releaseSpeechKit() {
      return getInstance().release();
   }

   static void setSpeechKit(NVASpeechKit var0) {
      getInstance().release();
      getInstance().setSpeechKit(var0);
   }

   public MMJSResponse addCustomVoiceWords(Map var1) {
      NVASpeechKit var2 = this.getCreateSpeechKit();
      if(var2 == null) {
         return MMJSResponse.responseWithError("Unable to create speech kit");
      } else {
         String var4 = (String)var1.get("words");
         if(!TextUtils.isEmpty(var4)) {
            String[] var3 = var4.split(",");
            var2.updateCustomWords(NVASpeechKit$CustomWordsOp.Add, var3);
            this.injectJavascript("javascript:MMJS.sdk.customVoiceWordsAdded()");
            return MMJSResponse.responseWithSuccess("Added " + var4);
         } else {
            return null;
         }
      }
   }

   public MMJSResponse cacheAudio(Map var1) {
      String var3 = (String)var1.get("url");
      if(!URLUtil.isValidUrl(var3)) {
         return MMJSResponse.responseWithError("Invalid url");
      } else {
         if(this.contextRef != null) {
            Context var2 = (Context)this.contextRef.get();
            if(var2 != null && AdCache.downloadComponentExternalStorage(var3, var3.substring(var3.lastIndexOf("/") + 1), var2)) {
               this.injectJavascript("javascript:MMJS.sdk.audioCached()");
               return MMJSResponse.responseWithSuccess("Successfully cached audio at " + var3);
            }
         }

         return MMJSResponse.responseWithError("Failed to cache audio at" + var3);
      }
   }

   public MMJSResponse deleteCustomVoiceWords(Map var1) {
      NVASpeechKit var2 = this.getCreateSpeechKit();
      if(var2 == null) {
         return MMJSResponse.responseWithError("Unable to create speech kit");
      } else {
         String var4 = (String)var1.get("words");
         if(!TextUtils.isEmpty(var4)) {
            String[] var3 = var4.split(",");
            var2.updateCustomWords(NVASpeechKit$CustomWordsOp.Remove, var3);
            this.injectJavascript("javascript:MMJS.sdk.customVoiceWordsDeleted()");
            return MMJSResponse.responseWithSuccess("Deleted " + var4);
         } else {
            return null;
         }
      }
   }

   public MMJSResponse endRecording(Map var1) {
      NVASpeechKit var4 = this.getSpeechKit();
      if(var4 == null) {
         return MMJSResponse.responseWithError("Unable to get speech kit");
      } else {
         synchronized(var4) {
            if(var4.endRecording()) {
               MMJSResponse var2 = MMJSResponse.responseWithSuccess();
               return var2;
            }
         }

         return MMJSResponse.responseWithError("Failed in speechKit");
      }
   }

   MMJSResponse executeCommand(String var1, Map var2) {
      MMJSResponse var3 = null;
      if(this.START_RECORDING.equals(var1)) {
         var3 = this.startRecording(var2);
      } else {
         if(this.END_RECORDING.equals(var1)) {
            return this.endRecording(var2);
         }

         if(this.CACHE_AUDIO.equals(var1)) {
            return this.cacheAudio(var2);
         }

         if(this.GET_SESSION_ID.equals(var1)) {
            return this.getSessionId(var2);
         }

         if(this.PLAY_AUDIO.equals(var1)) {
            return this.playAudio(var2);
         }

         if(this.TEXT_TO_SPEECH.equals(var1)) {
            return this.textToSpeech(var2);
         }

         if(this.STOP_AUDIO.equals(var1)) {
            return this.stopAudio(var2);
         }

         if(this.SAMPLE_BACKGROUND_AUDIO_LEVEL.equals(var1)) {
            return this.sampleBackgroundAudioLevel(var2);
         }

         if(this.RELEASE_VOICE.equals(var1)) {
            return this.releaseVoice(var2);
         }

         if(this.ADD_CUSTOM_VOICE_WORDS.equals(var1)) {
            return this.addCustomVoiceWords(var2);
         }

         if(this.DELETE_CUSTOM_VOICE_WORDS.equals(var1)) {
            return this.deleteCustomVoiceWords(var2);
         }
      }

      return var3;
   }

   public MMJSResponse getSessionId(Map var1) {
      NVASpeechKit var2 = this.getSpeechKit();
      if(var2 == null) {
         return MMJSResponse.responseWithError("No SpeechKit session open.");
      } else {
         String var3 = var2.getSessionId();
         return !TextUtils.isEmpty(var3)?MMJSResponse.responseWithSuccess(var3):MMJSResponse.responseWithError("No SpeechKit session open.");
      }
   }

   void injectJavascript(String var1) {
      MMWebView var2 = (MMWebView)this.mmWebViewRef.get();
      if(var2 != null) {
         var2.loadUrl(var1);
      }

   }

   public void onCompletion(MediaPlayer var1) {
      this.injectJavascript("javascript:MMJS.sdk.audioCompleted()");
      Context var2 = (Context)this.contextRef.get();
      if(var2 != null) {
         BridgeMMMedia$Audio var3 = BridgeMMMedia$Audio.sharedAudio(var2);
         if(var3 != null) {
            var3.removeCompletionListener(this);
            var3.removePeriodicListener(this);
         }
      }

   }

   public void onUpdate(int var1) {
      this.injectJavascript("javascript:MMJS.sdk.audioPositionChange(" + var1 + ")");
   }

   public MMJSResponse playAudio(Map var1) {
      MMJSResponse var4;
      if(this.getCreateSpeechKit() == null) {
         var4 = MMJSResponse.responseWithError("Unable to create speech kit");
         return var4;
      } else if(!URLUtil.isValidUrl((String)var1.get("url"))) {
         return MMJSResponse.responseWithError("Invalid url");
      } else {
         String var2 = (String)var1.get("url");
         if(!TextUtils.isEmpty(var2)) {
            Context var3 = (Context)this.contextRef.get();
            if(var3 != null) {
               BridgeMMMedia$Audio var6 = BridgeMMMedia$Audio.sharedAudio(var3);
               if(var6 != null) {
                  var6.addCompletionListener(this);
                  var6.addPeriodicListener(this);
               }

               var1.put("path", var2);
               MMJSResponse var5 = this.playAudioInternal(var1);
               var4 = var5;
               if(var5 != null) {
                  var4 = var5;
                  if(var5.result == 1) {
                     this.injectJavascript("javascript:MMJS.sdk.audioStarted()");
                     return var5;
                  }
               }

               return var4;
            }
         }

         return null;
      }
   }

   public MMJSResponse releaseVoice(Map var1) {
      return releaseSpeechKit()?MMJSResponse.responseWithError("Unable to get speech kit"):MMJSResponse.responseWithSuccess("released speechkit");
   }

   public MMJSResponse sampleBackgroundAudioLevel(Map var1) {
      NVASpeechKit var2 = this.getCreateSpeechKit();
      if(var2 == null) {
         return MMJSResponse.responseWithError("Unable to create speech kit");
      } else {
         var2.startSampleRecording();
         return null;
      }
   }

   public MMJSResponse startRecording(Map var1) {
      NVASpeechKit var3 = this.getCreateSpeechKit();
      if(var3 == null) {
         return MMJSResponse.responseWithError("Unable to create speech kit");
      } else {
         String var2 = (String)var1.get("language");
         String var4 = var2;
         if(TextUtils.isEmpty(var2)) {
            var4 = "en_GB";
         }

         return var3.startRecording(var4)?MMJSResponse.responseWithSuccess():MMJSResponse.responseWithError("Failed in speechKit");
      }
   }

   public MMJSResponse stopAudio(Map var1) {
      NVASpeechKit var2 = this.getSpeechKit();
      if(var2 == null) {
         return MMJSResponse.responseWithError("Unable to get speech kit");
      } else {
         var2.stopActions();
         if(this.contextRef != null) {
            BridgeMMMedia$Audio var3 = BridgeMMMedia$Audio.sharedAudio((Context)this.contextRef.get());
            if(var3 != null) {
               return var3.stop();
            }
         }

         return MMJSResponse.responseWithSuccess();
      }
   }

   public MMJSResponse textToSpeech(Map var1) {
      MMLog.d("BridgeMMSpeechkit", "@@-Calling textToSpeech");
      NVASpeechKit var3 = this.getCreateSpeechKit();
      if(var3 == null) {
         return MMJSResponse.responseWithError("Unable to create speech kit");
      } else {
         String var2 = (String)var1.get("language");
         String var4 = (String)var1.get("text");
         String var5 = var2;
         if(TextUtils.isEmpty(var2)) {
            var5 = "en_GB";
         }

         var3.stopActions();
         return var3.textToSpeech(var4, var5)?MMJSResponse.responseWithSuccess():MMJSResponse.responseWithError("Failed in speechKit");
      }
   }
}
