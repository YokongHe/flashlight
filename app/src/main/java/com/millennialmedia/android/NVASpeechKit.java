package com.millennialmedia.android;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.millennialmedia.android.HandShake$NuanceCredentials;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.MMWebView;
import com.millennialmedia.android.NVASpeechKit$AudioLevelTracker;
import com.millennialmedia.android.NVASpeechKit$CustomWordsOp;
import com.millennialmedia.android.NVASpeechKit$Listener;
import com.millennialmedia.android.NVASpeechKit$Result;
import com.millennialmedia.android.NVASpeechKit$State;
import com.nuance.nmdp.speechkit.DataUploadCommand;
import com.nuance.nmdp.speechkit.DataUploadCommand$Listener;
import com.nuance.nmdp.speechkit.DataUploadResult;
import com.nuance.nmdp.speechkit.GenericCommand;
import com.nuance.nmdp.speechkit.GenericCommand$Listener;
import com.nuance.nmdp.speechkit.GenericResult;
import com.nuance.nmdp.speechkit.Recognition;
import com.nuance.nmdp.speechkit.Recognizer;
import com.nuance.nmdp.speechkit.Recognizer$Listener;
import com.nuance.nmdp.speechkit.SpeechError;
import com.nuance.nmdp.speechkit.SpeechKit;
import com.nuance.nmdp.speechkit.SpeechKit$CmdSetType;
import com.nuance.nmdp.speechkit.Vocalizer;
import com.nuance.nmdp.speechkit.Vocalizer$Listener;
import com.nuance.nmdp.speechkit.recognitionresult.DetailedResult;
import com.nuance.nmdp.speechkit.util.dataupload.Action;
import com.nuance.nmdp.speechkit.util.dataupload.Action$ActionType;
import com.nuance.nmdp.speechkit.util.dataupload.Data;
import com.nuance.nmdp.speechkit.util.dataupload.Data$DataType;
import com.nuance.nmdp.speechkit.util.dataupload.DataBlock;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Dictionary;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NVASpeechKit {
   static final float AUDIO_LEVEL_CHANGE_INTERVAL = 0.25F;
   static final float AUDIO_LEVEL_MAX = 90.0F;
   private static final int AUDIO_LEVEL_UPDATE_FREQUENCY = 50;
   private static final int AUDIO_SAMPLE_PERIOD = 2000;
   static final float SAMPLING_BG_INTERVAL = 0.1F;
   private static final String TAG = "NVASpeechKit";
   private static String nuanceIdCache = null;
   HandShake$NuanceCredentials _credentials;
   public NVASpeechKit$Result[] _results = null;
   private Runnable audioLevelCallback = new Runnable() {
      public void run() {
         if(NVASpeechKit.this.skCurrentRecognizer != null) {
            double var1 = NVASpeechKit$AudioLevelTracker.access$100((double)NVASpeechKit.this.skCurrentRecognizer.getAudioLevel());
            MMLog.d("NVASpeechKit", "audiolevel changed: level=" + var1);
            if(NVASpeechKit.this.audioLevelTracker.update(var1) && NVASpeechKit.this.speechKitListener != null) {
               NVASpeechKit.this.speechKitListener.onAudioLevelUpdate(var1);
            }

            if(NVASpeechKit.this.state == NVASpeechKit$State.RECORDING || NVASpeechKit.this.audioLevelTracker.isTrackingAudioSample) {
               NVASpeechKit.this.speeckKitHandler.postDelayed(NVASpeechKit.this.audioLevelCallback, 50L);
            }
         }

      }
   };
   private NVASpeechKit$AudioLevelTracker audioLevelTracker = new NVASpeechKit$AudioLevelTracker();
   private Runnable audioSampleCallback = new Runnable() {
      public void run() {
         NVASpeechKit.this.endRecording();
      }
   };
   private GenericCommand$Listener commandListener = new GenericCommand$Listener() {
      public void onComplete(GenericCommand var1, GenericResult var2, SpeechError var3) {
         if(var3 != null) {
            MMLog.e("NVASpeechKit", "GenericCommand listener. Error: " + var3.getErrorDetail());
         } else {
            MMLog.d("NVASpeechKit", "GenericCommand listener. Success: " + var2.getQueryResult());
         }

         NVASpeechKit.this.notifySpeechResults();
      }
   };
   private DataUploadCommand$Listener dataUploadListener = new DataUploadCommand$Listener() {
      private void notifyListener(DataUploadCommand var1) {
         if(NVASpeechKit.this.speechKitListener != null && NVASpeechKit.this.pendingDataUploadCommand == var1) {
            if(NVASpeechKit.this.pendingDataUploadCommandType == NVASpeechKit$CustomWordsOp.Add) {
               NVASpeechKit.this.speechKitListener.onCustomWordsAdded();
            } else {
               NVASpeechKit.this.speechKitListener.onCustomWordsDeleted();
            }
         }

         NVASpeechKit.this.pendingDataUploadCommand = null;
      }

      public void onError(DataUploadCommand var1, SpeechError var2) {
         MMLog.e("NVASpeechKit", "DataUploadCommand listener error. command:" + var1.toString() + " Error:" + var2.getErrorDetail());
         this.notifyListener(var1);
      }

      public void onResults(DataUploadCommand var1, DataUploadResult var2) {
         MMLog.d("NVASpeechKit", "DataUploadCommand listener successful command:" + var1.toString() + " isVocRegenerated:" + var2.isVocRegenerated() + " results:" + var2.toString());
         this.notifyListener(var1);
      }
   };
   private String nuance_transaction_session_id;
   private String packageName;
   private DataUploadCommand pendingDataUploadCommand;
   private NVASpeechKit$CustomWordsOp pendingDataUploadCommandType;
   private SpeechKit sk;
   private Recognizer skCurrentRecognizer;
   private Vocalizer skCurrentVocalizer;
   private Recognizer$Listener skRecogListener;
   private Vocalizer$Listener skVocalListener;
   private NVASpeechKit$Listener speechKitListener = new NVASpeechKit$Listener() {
      public void onAudioLevelUpdate(double var1) {
         NVASpeechKit.this.audioLevelChange(var1);
      }

      public void onAudioSampleUpdate(double var1) {
         NVASpeechKit.this.backgroundAudioLevel(var1);
      }

      public void onCustomWordsAdded() {
      }

      public void onCustomWordsDeleted() {
      }

      public void onError() {
      }

      public void onResults() {
         JSONArray var1 = NVASpeechKit.this.resultsToJSON(NVASpeechKit.this.getResults());
         NVASpeechKit.this.recognitionResult(var1.toString());
      }

      public void onStateChange(NVASpeechKit$State var1) {
         switch(null.$SwitchMap$com$millennialmedia$android$NVASpeechKit$State[var1.ordinal()]) {
         case 1:
            NVASpeechKit.this.voiceStateChangeError();
            return;
         case 2:
            NVASpeechKit.this.voiceStateChangeProcessing();
            return;
         case 3:
            NVASpeechKit.this.voiceStateChangeReady();
            return;
         case 4:
            NVASpeechKit.this.voiceStateChangeRecording();
            return;
         case 5:
            NVASpeechKit.this.voiceStateChangeVocalizing();
            return;
         default:
         }
      }
   };
   private Handler speeckKitHandler;
   private NVASpeechKit$State state;
   private WeakReference webViewRef;

   public NVASpeechKit(MMWebView var1) {
      if(var1 != null) {
         this.webViewRef = new WeakReference(var1);
         this.initInternalData(var1.getContext().getApplicationContext());
      }

      this.state = NVASpeechKit$State.READY;
   }

   private String byte2Str(byte[] var1) {
      if(var1 == null) {
         return null;
      } else {
         StringBuffer var4 = new StringBuffer();

         for(int var2 = 0; var2 < var1.length; ++var2) {
            int var3 = var1[var2] & 255;
            String var5 = Integer.toHexString(var3);
            if(var3 < 16) {
               var4.append('0');
            }

            var4.append(var5);
         }

         return var4.toString();
      }
   }

   private void cancelAudioLevelCallbacks() {
      if(this.speeckKitHandler != null) {
         this.speeckKitHandler.removeCallbacks(this.audioSampleCallback);
         this.speeckKitHandler.removeCallbacks(this.audioLevelCallback);
      }

   }

   private Recognizer$Listener createRecognizerListener() {
      return new Recognizer$Listener() {
         public void onError(Recognizer var1, SpeechError var2) {
            MMLog.d("NVASpeechKit", "Speech Kit Error code:" + var2.getErrorCode() + " detail:" + var2.getErrorDetail() + " suggestions:" + var2.getSuggestion());
            NVASpeechKit.this.cancelAudioLevelCallbacks();
            NVASpeechKit.this.handleSpeechError(var2);
            NVASpeechKit.this.skCurrentRecognizer = null;
            if(NVASpeechKit.this.sk != null) {
               MMLog.d("NVASpeechKit", "Recognizer.Listener.onError: session id [" + NVASpeechKit.this.sk.getSessionId() + "]");
            }

         }

         public void onRecordingBegin(Recognizer var1) {
            MMLog.d("NVASpeechKit", "recording begins");
            NVASpeechKit.this._results = null;
            if(!NVASpeechKit.this.audioLevelTracker.isTrackingAudioSample()) {
               NVASpeechKit.this.setState(NVASpeechKit$State.RECORDING);
            }

            NVASpeechKit.this.startProgress(var1);
            if(NVASpeechKit.this.audioLevelTracker.isTrackingAudioSample()) {
               NVASpeechKit.this.speeckKitHandler.removeCallbacks(NVASpeechKit.this.audioSampleCallback);
               NVASpeechKit.this.speeckKitHandler.postDelayed(NVASpeechKit.this.audioSampleCallback, 2000L);
            }

         }

         public void onRecordingDone(Recognizer var1) {
            MMLog.d("NVASpeechKit", "recording has ended");
            NVASpeechKit.this.cancelAudioLevelCallbacks();
            if(!NVASpeechKit.this.audioLevelTracker.isTrackingAudioSample()) {
               NVASpeechKit.this.setState(NVASpeechKit$State.PROCESSING);
            }

            if(NVASpeechKit.this.sk != null) {
               NVASpeechKit.this.nuance_transaction_session_id = NVASpeechKit.this.sk.getSessionId();
            }

         }

         public void onResults(Recognizer var1, Recognition var2) {
            MMLog.d("NVASpeechKit", "recording results returned.");
            NVASpeechKit.this.cancelAudioLevelCallbacks();
            if(!NVASpeechKit.this.audioLevelTracker.isTrackingAudioSample) {
               NVASpeechKit.this.processResults(var2.getDetailedResults());
               if(NVASpeechKit.this.nuance_transaction_session_id != null) {
                  MMLog.d("NVASpeechKit", "Recognizer.Listener.onResults: session id [" + NVASpeechKit.this.nuance_transaction_session_id + "]");
               }

               NVASpeechKit.this.logEvent();
            } else {
               NVASpeechKit.this._results = new NVASpeechKit$Result[0];
               NVASpeechKit.this.notifySpeechResults();
            }
         }
      };
   }

   private Vocalizer$Listener createVocalizerListener() {
      return new Vocalizer$Listener() {
         public void onSpeakingBegin(Vocalizer var1, String var2, Object var3) {
            MMLog.d("NVASpeechKit", "Vocalization begins. text=" + var2);
            NVASpeechKit.this.setState(NVASpeechKit$State.VOCALIZING);
         }

         public void onSpeakingDone(Vocalizer var1, String var2, SpeechError var3, Object var4) {
            MMLog.d("NVASpeechKit", "Vocalization has ended.");
            if(var3 != null) {
               MMLog.e("NVASpeechKit", "Vocalizer error: " + var3.getErrorDetail());
               NVASpeechKit.this.handleSpeechError(var3);
            } else {
               NVASpeechKit.this.setState(NVASpeechKit$State.READY);
            }
         }
      };
   }

   private String getAdId() {
      if(this.webViewRef != null) {
         MMWebView var1 = (MMWebView)this.webViewRef.get();
         if(var1 != null) {
            return var1.getAdId();
         }
      }

      return "DEFAULT_AD_ID";
   }

   private MMWebView getMMWebView() {
      return this.webViewRef != null?(MMWebView)this.webViewRef.get():null;
   }

   private String getSpeechError(SpeechError var1) {
      return var1 == null?"No Error given":"Speech Kit Error code:" + var1.getErrorCode() + " detail:" + var1.getErrorDetail() + " suggestions:" + var1.getSuggestion();
   }

   private void handleSpeechError(SpeechError var1) {
      switch(var1.getErrorCode()) {
      case 2:
         if(!this.audioLevelTracker.isTrackingAudioSample) {
            this.setState(NVASpeechKit$State.PROCESSING);
         }

         this._results = new NVASpeechKit$Result[0];
         this.notifySpeechResults();
         return;
      case 3:
      case 4:
      default:
         if(this.speechKitListener != null) {
            this.speechKitListener.onError();
            this.setState(NVASpeechKit$State.ERROR);
            this.voiceError(this.getSpeechError(var1));
         }

         return;
      case 5:
         this.setState(NVASpeechKit$State.READY);
         this.skCurrentRecognizer = null;
      }
   }

   private void initInternalData(Context var1) {
      if(this.packageName == null) {
         this.packageName = var1.getApplicationContext().getPackageName();
      }

   }

   private void notifySpeechResults() {
      if(this.speechKitListener != null && this._results != null) {
         if(this.audioLevelTracker.isTrackingAudioSample) {
            this.speechKitListener.onAudioSampleUpdate(this.audioLevelTracker.averageLevel);
            this.audioLevelTracker.reset();
         } else {
            this.speechKitListener.onResults();
         }
      }

      this.setState(NVASpeechKit$State.READY);
      this.skCurrentRecognizer = null;
   }

   private void processResults(List var1) {
      MMLog.d("NVASpeechKit", "processResults called.");
      this._results = new NVASpeechKit$Result[var1.size()];
      Iterator var4 = var1.iterator();

      for(int var2 = 0; var4.hasNext(); ++var2) {
         DetailedResult var3 = (DetailedResult)var4.next();
         this._results[var2] = new NVASpeechKit$Result(this, var3.toString(), var3.getConfidenceScore());
      }

   }

   private void releaseWebView() {
      if(this.getMMWebView() != null) {
         this.webViewRef.clear();
      }

   }

   private JSONArray resultsToJSON(NVASpeechKit$Result[] var1) {
      JSONArray var3 = new JSONArray();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         JSONObject var4 = new JSONObject();

         try {
            var4.put("score", "" + var1[var2].getResultScore());
            var4.put("result", var1[var2].getResultString());
            var3.put(var4);
         } catch (JSONException var5) {
            MMLog.e("NVASpeechKit", "JSON creation error.", var5);
            return null;
         }
      }

      return var3;
   }

   private void setState(NVASpeechKit$State var1) {
      synchronized(this){}

      try {
         MMLog.d("NVASpeechKit", "recording results returned. state=" + var1);
         NVASpeechKit$State var2 = this.state;
         this.state = var1;
         if(this.speechKitListener != null && this.state != var2) {
            this.speechKitListener.onStateChange(var1);
         }
      } finally {
         ;
      }

   }

   private void startProgress(Recognizer var1) {
      this.speeckKitHandler.removeCallbacks(this.audioLevelCallback);
      this.speeckKitHandler.postDelayed(this.audioLevelCallback, 50L);
   }

   private byte[] string2Byte(String var1) {
      if(var1 == null) {
         return null;
      } else {
         byte[] var3 = new byte[var1.length() / 2];

         for(int var2 = 0; var2 < var3.length; ++var2) {
            var3[var2] = (byte)Integer.parseInt(var1.substring(var2 * 2, var2 * 2 + 2), 16);
         }

         return var3;
      }
   }

   void audioLevelChange(double var1) {
      MMWebView var3 = this.getMMWebView();
      if(var3 != null) {
         var3.loadUrl("javascript:MMJS.sdk.audioLevelChange(" + var1 + ")");
      }

   }

   void backgroundAudioLevel(double var1) {
      MMWebView var3 = this.getMMWebView();
      if(var3 != null) {
         var3.loadUrl("javascript:MMJS.sdk.backgroundAudioLevel(" + var1 + ")");
      }

   }

   public void cancelRecording() {
      if(this.skCurrentRecognizer != null) {
         MMLog.d("NVASpeechKit", "cancel RECORDING");
         this.skCurrentRecognizer.cancel();
         this.skCurrentRecognizer = null;
         this.setState(NVASpeechKit$State.READY);
      }

   }

   public boolean endRecording() {
      if(this.skCurrentRecognizer != null) {
         MMLog.d("NVASpeechKit", "end RECORDING");
         this.skCurrentRecognizer.stopRecording();
         this.skCurrentRecognizer = null;
         return true;
      } else {
         return false;
      }
   }

   String getNuanceId() {
      // $FF: Couldn't be decompiled
   }

   public NVASpeechKit$Result[] getResults() {
      return this._results;
   }

   String getSessionId() {
      return this.sk != null?this.sk.getSessionId():"";
   }

   public NVASpeechKit$State getState() {
      synchronized(this){}

      NVASpeechKit$State var1;
      try {
         var1 = this.state;
      } finally {
         ;
      }

      return var1;
   }

   public boolean initialize(HandShake$NuanceCredentials var1, Context var2) {
      MMLog.d("NVASpeechKit", "initialize called.");
      if(var1 != null && var2 != null) {
         this._credentials = var1;
         if(this.sk != null) {
            try {
               this.sk.connect();
            } catch (IllegalStateException var4) {
               this.sk = null;
            }
         }

         if(this.sk == null) {
            byte[] var3 = this.string2Byte(var1.appKey);
            MMLog.d("NVASpeechKit", var1.toString());
            this.sk = SpeechKit.initialize(var2, "1.0", var1.appID, var1.server, var1.port, false, var3, SpeechKit$CmdSetType.NVC);
            this.skVocalListener = this.createVocalizerListener();
            this.skRecogListener = this.createRecognizerListener();
            this.speeckKitHandler = new Handler(Looper.getMainLooper());
            this.sk.connect();
            this.setState(NVASpeechKit$State.READY);
            return true;
         } else {
            MMLog.d("NVASpeechKit", "Already initialized. Skipping.");
            return false;
         }
      } else {
         return false;
      }
   }

   public void logEvent() {
      if(this.sk != null) {
         PdxValue$Dictionary var3 = new PdxValue$Dictionary();
         var3.put("nva_ad_network_id", "MillenialMedia");
         var3.put("nva_device_id", this.getNuanceId());
         var3.put("nva_ad_publisher_id", this.packageName);
         String var2 = "";
         String var1 = var2;
         if(this._credentials != null) {
            var1 = var2;
            if(!TextUtils.isEmpty(this._credentials.sessionID)) {
               var1 = this._credentials.sessionID;
               var3.put("nva_ad_session_id", this._credentials.sessionID);
            }
         }

         var2 = this.getAdId();
         if(!TextUtils.isEmpty(var2)) {
            var3.put("nva_ad_id", var2);
         }

         if(this.nuance_transaction_session_id != null) {
            var3.put("nva_nvc_session_id", this.nuance_transaction_session_id);
            String var4 = this.nuance_transaction_session_id;
            this.nuance_transaction_session_id = null;
         } else {
            this.sk.getSessionId();
         }

         MMLog.d("NVASpeechKit", "Sending log revision command to server. sessionId[" + this.sk.getSessionId() + "] deviceId[" + this.getNuanceId() + "] adId[" + var2 + "] mmSessionId[" + var1 + "]");
         this.sk.createLogRevisionCmd("NVA_LOG_EVENT", var3, this.sk.getSessionId(), this.commandListener, this.speeckKitHandler).start();
      }
   }

   void recognitionResult(String var1) {
      MMWebView var2 = this.getMMWebView();
      if(var2 != null) {
         var2.loadUrl("javascript:MMJS.sdk.recognitionResult(" + var1 + ")");
      }

   }

   public void release() {
      MMLog.d("NVASpeechKit", "release called.");
      this.stopActions();
      this.cancelAudioLevelCallbacks();
      if(this.sk != null) {
         this.sk.release();
         this.setState(NVASpeechKit$State.READY);
         this.sk = null;
      }

      this.pendingDataUploadCommand = null;
      this.releaseWebView();
   }

   public void setSpeechKitListener(NVASpeechKit$Listener var1) {
      this.speechKitListener = var1;
   }

   public boolean startRecording(String var1) {
      MMLog.d("NVASpeechKit", "RECORDING INVOKED.");
      if(this.state == NVASpeechKit$State.READY && this.sk != null) {
         this.nuance_transaction_session_id = null;
         this.skCurrentRecognizer = this.sk.createRecognizer("dictation", 1, var1, this.skRecogListener, this.speeckKitHandler);
         MMLog.d("NVASpeechKit", "START RECORDING");
         this.skCurrentRecognizer.start();
         return true;
      } else {
         return false;
      }
   }

   public void startSampleRecording() {
      this.audioLevelTracker.startTrackingAudioSample();
      this.startRecording("en_US");
   }

   public void stopActions() {
      if(this.sk != null) {
         try {
            this.sk.cancelCurrent();
         } catch (Exception var2) {
            MMLog.e("NVASpeechKit", "No speech kit to disconnect.", var2);
            return;
         }
      }

   }

   public boolean textToSpeech(String var1, String var2) {
      MMLog.d("NVASpeechKit", "TTS INVOKED.");
      if(this.state == NVASpeechKit$State.READY && this.sk != null) {
         this.skCurrentVocalizer = this.sk.createVocalizerWithLanguage(var2, this.skVocalListener, this.speeckKitHandler);
         this.skCurrentVocalizer.speakString(var1, this);
         return true;
      } else {
         return false;
      }
   }

   public void updateCustomWords(NVASpeechKit$CustomWordsOp var1, String[] var2) {
      if(this.sk != null) {
         DataBlock var6 = new DataBlock();
         StringBuilder var7 = new StringBuilder("Creating dataupload command and ");
         String var5;
         if(var1 == NVASpeechKit$CustomWordsOp.Add) {
            var5 = "adding";
         } else {
            var5 = "deleting";
         }

         MMLog.d("NVASpeechKit", var7.append(var5).append(" words.").toString());
         Data var11 = new Data("nva_custom_word_uploads", Data$DataType.CUSTOMWORDS);
         Action$ActionType var9;
         if(var1 == NVASpeechKit$CustomWordsOp.Add) {
            var9 = Action$ActionType.ADD;
         } else {
            var9 = Action$ActionType.REMOVE;
         }

         Action var10 = new Action(var9);
         int var4 = var2.length;

         int var3;
         for(var3 = 0; var3 < var4; ++var3) {
            String var8 = var2[var3];
            var10.addWord(var8);
            MMLog.d("NVASpeechKit", "\tword: \'" + var8 + "\'");
         }

         var11.addAction(var10);
         var6.addData(var11);
         var3 = var6.getChecksum();
         this.pendingDataUploadCommandType = var1;
         this.pendingDataUploadCommand = this.sk.createDataUploadCmd(var6, var3, var3, this.dataUploadListener, this.speeckKitHandler);
         this.pendingDataUploadCommand.start();
      }
   }

   void voiceError(String var1) {
      MMWebView var2 = this.getMMWebView();
      if(var2 != null) {
         var2.loadUrl("javascript:MMJS.sdk.voiceError(\'" + var1 + "\')");
      }

   }

   void voiceStateChangeError() {
      MMWebView var1 = this.getMMWebView();
      if(var1 != null) {
         var1.loadUrl("javascript:MMJS.sdk.voiceStateChange(\'error\')");
      }

   }

   void voiceStateChangeProcessing() {
      MMWebView var1 = this.getMMWebView();
      if(var1 != null) {
         var1.loadUrl("javascript:MMJS.sdk.voiceStateChange(\'processing\')");
      }

   }

   void voiceStateChangeReady() {
      MMWebView var1 = this.getMMWebView();
      if(var1 != null) {
         var1.loadUrl("javascript:MMJS.sdk.voiceStateChange(\'ready\')");
      }

   }

   void voiceStateChangeRecording() {
      MMWebView var1 = this.getMMWebView();
      if(var1 != null) {
         var1.loadUrl("javascript:MMJS.sdk.voiceStateChange(\'recording\')");
      }

   }

   void voiceStateChangeVocalizing() {
      MMWebView var1 = this.getMMWebView();
      if(var1 != null) {
         var1.loadUrl("javascript:MMJS.sdk.voiceStateChange(\'vocalizing\')");
      }

   }
}
