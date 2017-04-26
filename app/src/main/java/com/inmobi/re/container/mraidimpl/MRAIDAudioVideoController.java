package com.inmobi.re.container.mraidimpl;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.FrameLayout.LayoutParams;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.controller.JSController$Dimensions;
import com.inmobi.re.controller.JSController$PlayerProperties;
import com.inmobi.re.controller.util.AVPlayer;
import com.inmobi.re.controller.util.AVPlayer$playerState;
import com.inmobi.re.controller.util.AVPlayerListener;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;

public class MRAIDAudioVideoController {
   private IMWebView a;
   public Hashtable audioPlayerList = new Hashtable();
   public AVPlayer audioplayer;
   public AVPlayer videoPlayer;
   public Hashtable videoPlayerList = new Hashtable();
   public int videoValidateWidth;

   public MRAIDAudioVideoController(IMWebView var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   static IMWebView a(MRAIDAudioVideoController var0) {
      return var0.a;
   }

   private AVPlayer a(String var1) {
      return !this.videoPlayerList.isEmpty()?(AVPlayer)this.videoPlayerList.get(var1):null;
   }

   private void a(AVPlayer var1, JSController$Dimensions var2) {
      int var3 = (int)(-99999.0F * this.a.getDensity());
      if(var1.isInlineVideo()) {
         LayoutParams var4 = new LayoutParams(var2.width, var2.height);
         LayoutParams var5 = (LayoutParams)var1.getLayoutParams();
         if(var2.x == var3 && var2.y == var3) {
            var4.leftMargin = var5.leftMargin;
            var4.topMargin = var5.topMargin;
         } else {
            var4.leftMargin = var2.x;
            var4.topMargin = var2.y;
         }

         var4.gravity = 3;
         var1.setLayoutParams(var4);
      }

   }

   private boolean a(String var1, String var2, Activity var3) {
      if(!this.audioPlayerList.isEmpty()) {
         this.audioplayer = (AVPlayer)this.audioPlayerList.get(var1);
         if(this.audioplayer == null) {
            if(this.audioPlayerList.size() > 4) {
               this.a.raiseError("Too many audio players", "playAudio");
               return false;
            }

            this.audioplayer = new AVPlayer(var3, this.a);
         } else if(!this.audioplayer.getMediaURL().equals(var2) && var2.length() != 0) {
            this.audioplayer.releasePlayer(false);
            this.audioPlayerList.remove(var1);
            this.audioplayer = new AVPlayer(var3, this.a);
         } else {
            if(this.audioplayer.getState() == AVPlayer$playerState.PLAYING) {
               return false;
            }

            if(this.audioplayer.getState() == AVPlayer$playerState.INIT) {
               if(this.audioplayer.isPrepared()) {
                  this.audioplayer.start();
               } else {
                  this.audioplayer.setAutoPlay(true);
               }

               return false;
            }

            if(this.audioplayer.getState() == AVPlayer$playerState.PAUSED) {
               this.audioplayer.start();
               return false;
            }

            JSController$PlayerProperties var5 = this.audioplayer.getProperties();
            String var4 = this.audioplayer.getMediaURL();
            this.audioplayer.releasePlayer(false);
            this.audioPlayerList.remove(var1);
            this.audioplayer = new AVPlayer(var3, this.a);
            this.audioplayer.setPlayData(var5, var4);
         }
      } else {
         this.audioplayer = new AVPlayer(var3, this.a);
      }

      return true;
   }

   private boolean a(String var1, String var2, Activity var3, JSController$Dimensions var4) {
      if(this.videoPlayer != null && var1.equalsIgnoreCase(this.videoPlayer.getPropertyID())) {
         AVPlayer$playerState var5 = this.videoPlayer.getState();
         if(var1.equalsIgnoreCase(this.videoPlayer.getPropertyID())) {
            var1 = this.videoPlayer.getMediaURL();
            if(var2.length() == 0 || var2.equalsIgnoreCase(var1)) {
               switch(null.a[var5.ordinal()]) {
               case 1:
                  this.videoPlayer.start();
                  break;
               case 2:
                  this.a(this.videoPlayer, var4);
                  return false;
               case 3:
                  if(!this.videoPlayer.getProperties().doLoop()) {
                     this.videoPlayer.start();
                  }

                  this.a(this.videoPlayer, var4);
                  return false;
               case 4:
                  if(this.videoPlayer.isPrepared()) {
                     this.videoPlayer.start();
                  } else {
                     this.videoPlayer.setAutoPlay(true);
                  }
                  break;
               default:
                  return false;
               }

               this.a(this.videoPlayer, var4);
               return false;
            }

            if(!URLUtil.isValidUrl(var2)) {
               this.a.raiseError("Request must specify a valid URL", "playVideo");
               return false;
            }

            this.videoPlayer.releasePlayer(false);
            this.videoPlayer = new AVPlayer(var3, this.a);
         }

         return true;
      } else {
         return this.b(var1, var2, var3);
      }
   }

   private boolean a(Hashtable var1, AVPlayer var2) {
      Iterator var4 = var1.entrySet().iterator();

      String var5;
      while(true) {
         if(var4.hasNext()) {
            Entry var3 = (Entry)var4.next();
            if(var3.getValue() != var2) {
               continue;
            }

            var5 = (String)var3.getKey();
            break;
         }

         var5 = null;
         break;
      }

      if(var5 != null) {
         this.audioPlayerList.remove(var5);
         return true;
      } else {
         return false;
      }
   }

   private boolean b(String var1, String var2, Activity var3) {
      if((var2.length() == 0 || URLUtil.isValidUrl(var2)) && (var2.length() != 0 || this.videoPlayerList.containsKey(var1))) {
         if(this.videoPlayer != null) {
            this.videoPlayer.hide();
            this.videoPlayerList.put(this.videoPlayer.getPropertyID(), this.videoPlayer);
         }

         AVPlayer var4 = this.a(var1);
         if(var4 == null) {
            this.videoPlayer = new AVPlayer(var3, this.a);
         } else {
            this.videoPlayer = var4;
         }

         if(var2.length() == 0) {
            this.videoPlayer.setPlayData(var4.getProperties(), var4.getMediaURL());
            this.videoPlayer.setPlayDimensions(var4.getPlayDimensions());
         }

         this.videoPlayerList.remove(var1);
         return true;
      } else {
         this.a.raiseError("Request must specify a valid URL", "playVideo");
         return false;
      }
   }

   public AVPlayer getCurrentAudioPlayer(String param1) {
      // $FF: Couldn't be decompiled
   }

   public AVPlayer getVideoPlayer(String param1) {
      // $FF: Couldn't be decompiled
   }

   public void hidePlayers() {
      Log.debug("[InMobi]-[RE]-4.5.2", "MRAIDAudioVideoController: hiding all players");
      if(this.videoPlayer != null && this.videoPlayer.getState() != AVPlayer$playerState.RELEASED) {
         this.videoPlayerList.put(this.videoPlayer.getPropertyID(), this.videoPlayer);
         this.videoPlayer.hide();
      }

      Iterator var1 = this.audioPlayerList.entrySet().iterator();

      while(var1.hasNext()) {
         Entry var2 = (Entry)var1.next();
         AVPlayer var3 = (AVPlayer)var2.getValue();
         switch(null.a[var3.getState().ordinal()]) {
         case 2:
            var3.pause();
         case 3:
         default:
            break;
         case 4:
            var3.releasePlayer(false);
            this.audioPlayerList.remove(var2.getKey());
         }
      }

   }

   public void mediaPlayerReleased(AVPlayer var1) {
      if(var1 == this.audioplayer) {
         this.audioplayer = null;
      }

      if(var1 == this.videoPlayer) {
         this.videoPlayer = null;
      }

      if(!this.a(this.audioPlayerList, var1)) {
         this.a(this.videoPlayerList, var1);
      }
   }

   public void playAudioImpl(Bundle var1, Activity var2) {
      final JSController$PlayerProperties var4 = (JSController$PlayerProperties)var1.getParcelable("player_properties");
      String var3 = var1.getString("expand_url");
      String var5 = var3;
      if(var3 == null) {
         var5 = "";
      }

      if(this.a(var4.id, var5, var2)) {
         if(var5.length() != 0 && !URLUtil.isValidUrl(var5) || var5.length() == 0 && !this.audioPlayerList.containsKey(var4.id)) {
            this.a.raiseError("Request must specify a valid URL", "playAudio");
            return;
         }

         if(this.audioplayer != null) {
            if(var5.length() != 0) {
               this.audioplayer.setPlayData(var4, var5);
            }

            this.audioPlayerList.put(var4.id, this.audioplayer);
            FrameLayout var6 = (FrameLayout)var2.findViewById(16908290);
            if(var4.isFullScreen()) {
               android.widget.RelativeLayout.LayoutParams var8 = new android.widget.RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
               var8.addRule(13);
               this.audioplayer.setLayoutParams(var8);
               RelativeLayout var7 = new RelativeLayout(var2);
               var7.setOnTouchListener(new OnTouchListener() {
                  public boolean onTouch(View var1, MotionEvent var2) {
                     return true;
                  }
               });
               var7.setBackgroundColor(-16777216);
               var6.addView(var7, new android.widget.RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent()));
               var7.addView(this.audioplayer);
               this.audioplayer.setBackGroundLayout(var7);
               this.audioplayer.requestFocus();
               this.audioplayer.setOnKeyListener(new OnKeyListener() {
                  public boolean onKey(View var1, int var2, KeyEvent var3) {
                     if(4 == var3.getKeyCode() && var3.getAction() == 0) {
                        Log.debug("[InMobi]-[RE]-4.5.2", "Back button pressed while fullscreen audio was playing");
                        MRAIDAudioVideoController.this.audioplayer.releasePlayer(true);
                     }

                     return false;
                  }
               });
            } else {
               this.audioplayer.setLayoutParams(new android.view.ViewGroup.LayoutParams(1, 1));
               var6.addView(this.audioplayer);
            }

            this.audioplayer.setListener(new AVPlayerListener() {
               public void onComplete(AVPlayer param1) {
                  // $FF: Couldn't be decompiled
               }

               public void onError(AVPlayer var1) {
                  this.onComplete(var1);
               }

               public void onPrepared(AVPlayer var1) {
               }
            });
            this.audioplayer.play();
            return;
         }
      }

   }

   public void playVideoImpl(Bundle var1, Activity var2) {
      JSController$PlayerProperties var3 = (JSController$PlayerProperties)var1.getParcelable("player_properties");
      JSController$Dimensions var4 = (JSController$Dimensions)var1.getParcelable("expand_dimensions");
      Log.debug("[InMobi]-[RE]-4.5.2", "Final dimensions: " + var4);
      String var5 = var1.getString("expand_url");
      if(this.a(var3.id, var5, var2, var4)) {
         this.a.setBusy(true);
         JSController$Dimensions var6;
         if(var5.length() == 0) {
            var3 = this.videoPlayer.getProperties();
            var6 = this.videoPlayer.getPlayDimensions();
            this.videoPlayer.getMediaURL();
         } else {
            this.videoPlayer.setPlayData(var3, var5);
            this.videoPlayer.setPlayDimensions(var4);
            var6 = var4;
         }

         if(this.videoPlayer.getState() == AVPlayer$playerState.HIDDEN) {
            this.videoPlayer.pseudoPause = true;
            this.videoPlayer.show();
         } else {
            FrameLayout var11 = (FrameLayout)var2.findViewById(16908290);
            if(var3.isFullScreen()) {
               android.widget.RelativeLayout.LayoutParams var8 = new android.widget.RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
               var8.addRule(13);
               this.videoPlayer.setLayoutParams(var8);
               RelativeLayout var9 = new RelativeLayout(var2);
               var9.setOnTouchListener(new OnTouchListener() {
                  public boolean onTouch(View var1, MotionEvent var2) {
                     return true;
                  }
               });
               var9.setBackgroundColor(-16777216);
               var11.addView(var9, new LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent()));
               var9.addView(this.videoPlayer);
               this.videoPlayer.setBackGroundLayout(var9);
               this.videoPlayer.requestFocus();
               this.videoPlayer.setOnKeyListener(new OnKeyListener() {
                  public boolean onKey(View var1, int var2, KeyEvent var3) {
                     if(4 == var3.getKeyCode() && var3.getAction() == 0) {
                        Log.debug("[InMobi]-[RE]-4.5.2", "Back pressed while fullscreen video is playing");
                        MRAIDAudioVideoController.this.videoPlayer.releasePlayer(true);
                        return true;
                     } else {
                        return false;
                     }
                  }
               });
            } else {
               LayoutParams var10 = new LayoutParams(var6.width, var6.height);
               FrameLayout var7 = new FrameLayout(var2);
               if(this.a.mExpandController.expandProperties == null) {
                  var10.leftMargin = var6.x;
                  var10.topMargin = var6.y;
               } else {
                  var10.leftMargin = var6.x + this.a.mExpandController.expandProperties.currentX;
                  var10.topMargin = var6.y + this.a.mExpandController.expandProperties.currentY;
               }

               var10.gravity = 3;
               this.videoPlayer.setLayoutParams(var10);
               var11.addView(var7, new LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent()));
               this.videoPlayer.setBackGroundLayout(var7);
               var7.addView(this.videoPlayer);
            }

            this.videoPlayer.setListener(new AVPlayerListener() {
               public void onComplete(AVPlayer param1) {
                  // $FF: Couldn't be decompiled
               }

               public void onError(AVPlayer var1) {
                  this.onComplete(var1);
               }

               public void onPrepared(AVPlayer var1) {
               }
            });
            this.videoPlayer.play();
         }
      }
   }

   public void releaseAllPlayers() {
      // $FF: Couldn't be decompiled
   }

   public void validateVideoDimensions(JSController$Dimensions var1) {
      var1.width = (int)((float)var1.width * this.a.getDensity());
      var1.height = (int)((float)var1.height * this.a.getDensity());
      var1.x = (int)((float)var1.x * this.a.getDensity());
      var1.y = (int)((float)var1.y * this.a.getDensity());
   }
}
