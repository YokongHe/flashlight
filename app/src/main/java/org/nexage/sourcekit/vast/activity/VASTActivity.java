package org.nexage.sourcekit.vast.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.SurfaceHolder.Callback;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.nexage.sourcekit.util.Assets;
import org.nexage.sourcekit.util.HttpTools;
import org.nexage.sourcekit.util.VASTLog;
import org.nexage.sourcekit.vast.VASTPlayer;
import org.nexage.sourcekit.vast.model.TRACKING_EVENTS_TYPE;
import org.nexage.sourcekit.vast.model.VASTModel;

public class VASTActivity extends Activity implements OnCompletionListener, OnErrorListener, OnPreparedListener, OnVideoSizeChangedListener, Callback {
   private static final long QUARTILE_TIMER_INTERVAL = 250L;
   private static final double SKIP_INFO_PADDING_SCALE = 0.1D;
   private static final double SKIP_INFO_SCALE = 0.15D;
   private static String TAG = "VASTActivity";
   private static final long TOOLBAR_HIDE_DELAY = 3000L;
   private static final long VIDEO_PROGRESS_TIMER_INTERVAL = 250L;
   private RelativeLayout mButtonPanel;
   private ImageButton mCloseButton;
   private int mCurrentVideoPosition;
   private Handler mHandler;
   private ImageButton mInfoButton;
   private boolean mIsCompleted = false;
   private boolean mIsPlayBackError = false;
   private boolean mIsProcessedImpressions = false;
   private boolean mIsVideoPaused = false;
   private final int mMaxProgressTrackingPoints = 20;
   private MediaPlayer mMediaPlayer;
   private RelativeLayout mOverlay;
   private Drawable mPauseDrawable;
   private Drawable mPlayDrawable;
   private ImageButton mPlayPauseButton;
   private ProgressBar mProgressBar;
   private int mQuartile = 0;
   private RelativeLayout mRootLayout;
   private int mScreenHeight;
   private int mScreenWidth;
   private Timer mStartVideoProgressTimer;
   private SurfaceHolder mSurfaceHolder;
   private SurfaceView mSurfaceView;
   private Timer mToolBarTimer;
   private HashMap mTrackingEventMap;
   private Timer mTrackingEventTimer;
   private VASTModel mVastModel = null;
   private int mVideoHeight;
   private LinkedList mVideoProgressTracker = null;
   private int mVideoWidth;

   // $FF: synthetic method
   static void access$10(VASTActivity var0) {
      var0.stopQuartileTimer();
   }

   // $FF: synthetic method
   static void access$11(VASTActivity var0, int var1) {
      var0.mQuartile = var1;
   }

   // $FF: synthetic method
   static int access$8(VASTActivity var0) {
      return var0.mQuartile;
   }

   // $FF: synthetic method
   static void access$9(VASTActivity var0, TRACKING_EVENTS_TYPE var1) {
      var0.processEvent(var1);
   }

   private void activateButtons(boolean var1) {
      VASTLog.d(TAG, "entered activateButtons:");
      if(var1) {
         this.mButtonPanel.setVisibility(0);
      } else {
         this.mButtonPanel.setVisibility(8);
      }
   }

   private void calculateAspectRatio() {
      VASTLog.d(TAG, "entered calculateAspectRatio");
      if(this.mVideoWidth != 0 && this.mVideoHeight != 0) {
         VASTLog.d(TAG, "calculating aspect ratio");
         double var1 = (double)this.mScreenWidth * 1.0D / (double)this.mVideoWidth;
         double var3 = (double)this.mScreenHeight * 1.0D / (double)this.mVideoHeight;
         double var5 = Math.min(var1, var3);
         int var7 = (int)((double)this.mVideoWidth * var5);
         int var8 = (int)(var5 * (double)this.mVideoHeight);
         LayoutParams var9 = new LayoutParams(var7, var8);
         var9.addRule(13);
         this.mSurfaceView.setLayoutParams(var9);
         this.mSurfaceHolder.setFixedSize(var7, var8);
         VASTLog.d(TAG, " screen size: " + this.mScreenWidth + "x" + this.mScreenHeight);
         VASTLog.d(TAG, " video size:  " + this.mVideoWidth + "x" + this.mVideoHeight);
         VASTLog.d(TAG, " widthRatio:   " + var1);
         VASTLog.d(TAG, " heightRatio:   " + var3);
         VASTLog.d(TAG, "surface size: " + var7 + "x" + var8);
      } else {
         VASTLog.w(TAG, "mVideoWidth or mVideoHeight is 0, skipping calculateAspectRatio");
      }
   }

   private void cleanActivityUp() {
      this.cleanUpMediaPlayer();
      this.stopQuartileTimer();
      this.stopVideoProgressTimer();
      this.stopToolBarTimer();
   }

   private void cleanUpMediaPlayer() {
      VASTLog.d(TAG, "entered cleanUpMediaPlayer ");
      if(this.mMediaPlayer != null) {
         if(this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.stop();
         }

         this.mMediaPlayer.setOnCompletionListener((OnCompletionListener)null);
         this.mMediaPlayer.setOnErrorListener((OnErrorListener)null);
         this.mMediaPlayer.setOnPreparedListener((OnPreparedListener)null);
         this.mMediaPlayer.setOnVideoSizeChangedListener((OnVideoSizeChangedListener)null);
         this.mMediaPlayer.release();
         this.mMediaPlayer = null;
      }

   }

   private void closeClicked() {
      VASTLog.d(TAG, "entered closeClicked()");
      this.cleanActivityUp();
      if(!this.mIsPlayBackError) {
         this.processEvent(TRACKING_EVENTS_TYPE.close);
      }

      this.finishVAST();
      VASTLog.d(TAG, "leaving closeClicked()");
   }

   private void createButtonPanel(int var1, int var2) {
      LayoutParams var3 = new LayoutParams(-1, -2);
      var3.addRule(12);
      this.mButtonPanel = new RelativeLayout(this);
      this.mButtonPanel.setLayoutParams(var3);
      var1 = (int)((double)Math.min(var1, var2) * 0.1D);
      this.mButtonPanel.setPadding(var1, 0, var1, 0);
      this.mButtonPanel.setBackgroundColor(-16777216);
      this.mButtonPanel.setVisibility(8);
      this.mOverlay.addView(this.mButtonPanel);
   }

   private void createCloseButton(int var1) {
      LayoutParams var2 = new LayoutParams(var1, var1);
      var2.addRule(11);
      this.mCloseButton = new ImageButton(this);
      this.mCloseButton.setId(22);
      Drawable var3 = Assets.getDrawableFromBase64(this.getResources(), "iVBORw0KGgoAAAANSUhEUgAAAC0AAAAtCAYAAAA6GuKaAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJ bWFnZVJlYWR5ccllPAAAA2hpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdp bj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6 eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0 NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJo dHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlw dGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEu MC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVz b3VyY2VSZWYjIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtcE1N Ok9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDpGRUU5MjA4OTBDMjA2ODExODA4M0YyQ0E4QjA4 M0I1MCIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDo2MzBFQTlFQTYxMjAxMUUzQjhCRkRDNTJC NjI0NTY5OCIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDo2MzBFQTlFOTYxMjAxMUUzQjhCRkRD NTJCNjI0NTY5OCIgeG1wOkNyZWF0b3JUb29sPSJBZG9iZSBQaG90b3Nob3AgQ1M2IChNYWNpbnRv c2gpIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6QTlBRDI1 MTgxMDIwNjgxMTgwODNGMkNBOEIwODNCNTAiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6RkVF OTIwODkwQzIwNjgxMTgwODNGMkNBOEIwODNCNTAiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRm OlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz6uekVTAAADwElEQVR42uyZXUgV QRTHvX5lGZVCWkpUWlhU+HD9qAcRNIoyQaV6sYfoQYKw8qUgK4LqWmJU9JhW0AfkQ4UFERFCL2Jh BqVkIopkaqIWpVh+bP+h/4Xltrt3Zu/erLgDP+S6Z878d3b2zDmzLk3Twv615gqJDokOiTZsySAL ZIMNYAmIBZNgFHSCFtAMWsHMbIl2gW2gDGwHUfz/CBgE4yASxIMkEMHr7eAmuAU+2BpZiLZBPmjS frUf4C7YA9aAuSCCdmJSokEi2Ao8oJP9PoNjtFcaX1VsDKjhoBPgDFiu6EPcRBF4QT+tIDNYouPB Ew70EKy2+ZT04g+B75yAYqdFLwYvKfgEH3uYQ2SBbvoudUq0WBJP6fSAg2L1rADvwBTY7IToCxR8 MkiCvaSBIdAPkgMRnUvBj4Is2Esxx7ttV7QIW81gjI/PzE6ErF2SorLBRj82Nyg8147oAnY+bWET Be7QrsqPmAw+/mGKt1rfE4xUyqIbwDhIMrm+gI9R36osBPfr7AZBjsXYdbRbryI6ifGz3sLxbs24 eXzsMn0Ee1sjiDTxnUObShXRJRJxM5ozayXcDT4aXG9jtDDzPYc3+lxF9Dk6T5N4ucyE1+o2DX1r BykSfu+BL2CRrGixnkcVkhmPJtfa/UQiPWfZZ52s6BYOEK4QY8UgMxaC34CVCv72s99vL2y4ScYq EvgxxWS9Elw3uTYECkG3gr+v/Bvje8FMtMak3qUwiBvkmFxbCPYqpvreomJGtggQb20vNw+ZRyni cJ/EmvYoLI8j7JMlu6avMeNKkHDuNonDwybCqyRFXwWTRkWGWYdyDpAnMcNGgt+CVeBUADP+CnQZ bUBWYjSWU2Y2m8Ank40jRSIc1uhqSV/E7E5zO5feXMTddbAIjbIQPSK5cRhtQBctQupB2hSoJkxH 2bHQT6o5ILlx6Ge82k960MFAME9VdCLL/BY/UUQE/8cgVWKdiiVxyY/NPt5Yhd3K5TgdlP+hymUp X+wupr62RM8Hr5mUZwRZsKjwH3CSigItbN0suXoUkh07VFPwZafOPXbS4XujrMsBztP/fb6Ijp0w lep2uhIH13A9/YqlERuMs7wtuh2wNoCjMXEAVMZaUWNEkc1zbJ2aLtNV4NPMU/IoxKpfOLf2Cp4m aYwSyk8tkPPpfHAY7ODvftAE2sAA82FxJp0AUnngnk7bHnAF1IEvs/ElIJ3CxcH6WhBnYDMFekEj aADPWGT8Fd9c4vgpI44VhxD7jTPfF+hni9CHopDo/1X0TwEGAMn4kfWfS4oUAAAAAElFTkSuQmCC");
      this.mCloseButton.setImageDrawable(var3);
      this.mCloseButton.setLayoutParams(var2);
      this.mCloseButton.setScaleType(ScaleType.CENTER_CROP);
      this.mCloseButton.setPadding(0, 0, 0, 0);
      this.mCloseButton.setBackgroundColor(0);
      this.mCloseButton.setVisibility(0);
      this.mCloseButton.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            VASTActivity.this.closeClicked();
         }
      });
      this.mButtonPanel.addView(this.mCloseButton);
   }

   private void createInfoButton(int var1) {
      String var2 = this.mVastModel.getVideoClicks().getClickThrough();
      if(var2 != null && var2.length() > 0) {
         LayoutParams var4 = new LayoutParams(var1, var1);
         var4.addRule(0, 22);
         this.mInfoButton = new ImageButton(this);
         Drawable var3 = Assets.getDrawableFromBase64(this.getResources(), "iVBORw0KGgoAAAANSUhEUgAAAC0AAAAtCAYAAAA6GuKaAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJ bWFnZVJlYWR5ccllPAAAA2hpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdp bj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6 eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0 NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJo dHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlw dGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEu MC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVz b3VyY2VSZWYjIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtcE1N Ok9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDpGQkU5MjA4OTBDMjA2ODExODA4M0YyQ0E4QjA4 M0I1MCIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDpDNDMxMTM3QjYxMjAxMUUzQjhCRkRDNTJC NjI0NTY5OCIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDpDNDMxMTM3QTYxMjAxMUUzQjhCRkRD NTJCNjI0NTY5OCIgeG1wOkNyZWF0b3JUb29sPSJBZG9iZSBQaG90b3Nob3AgQ1M2IChNYWNpbnRv c2gpIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6MDY4MDEx NzQwNzIwNjgxMTgwODNBRjJCNzQzNDlDQ0IiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6RkJF OTIwODkwQzIwNjgxMTgwODNGMkNBOEIwODNCNTAiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRm OlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz5stwd/AAADTUlEQVR42uyZXUgU URTHnU1NzI9Wi1y31jCiNfMjwhL6sqSHSOwhInoq+vA1qtdAeq8ee4p6KKynCvIhsEwLEgrKfFA3 MzMrWc20D63NaPvf+g8syyYz584oxV74McvOnHv+c++dueecMaLRaMq/1oyk6KRod0Xng7WgAqwB PrAAfAOjoAd0kqG5Fl0DjoA6kEuRA2Ccv9P5fyDmfBu4CG6CabFqJdomW0Fb9E97Dc6CWrAYpMVd 6wF5YD04Bbpo1w32CXz/xs7F88E5Ou0B+0GGTYcGb7CV/dwAPrdEF4IHdNQIMqWjFMMB8AUMgWqn RQdAL5gAOxwQG0uQS+Yr2OyUaC87fQ/KHBZssgg85qCUOSH6OpgGG1wSbFIABkAILNQRfZhr+KDL gk2q6O+8VLSasjFwS1PEaps2pym8SiK6kcarhIJLaT8O8m3YZYM3oNmu6CwwApo0RtnPDaSV/dmx Pc4bLrEjuo5GWxxYp4bwoYxwqVgWfQEMC3a7WHL4xkkX2t8BT/523hMXiswDG0EHAxxpqwftjAAl rQWUgyWJTnoShJl+8FQzelwO3oIPQvtnHMCVVkR7QTZ4oSm6BIRBRGj/jkefFdEZPE5oii4C/Rr2 n3nMsiI6GneUNHXjheC5Rh8z+o8XbU5nrobDHE5rSKMPc4QnrYj+xAuLNRwuA2ngpUYf5loOWxE9 yoegUsOhuuEpMKbRh0qQf4I+K6J/gEegmompVLSarWEN0bWgN+YtMqPoFGbKAY3RDlKwdHPKA9tA s9UHUbW7XNtHhU5V/WNQY5T3gExwzW4J4Qz4zvzQboDUwIxbEnOojL8PtEviaRVaToIrs5S1xIel NdJ06yQ72D1LgoOc3SadHDEV3AMf2aGbglXG0smQuEA3G18KBkG/YH1bRRV+bjPr3+RUsaaUI/AK rHNYsC+mRFbvdFksyCpThG8HwwHBO5nEqtLYLrcKkCqrvspRuQ+2C8WW82FTrYMz6VrV1GQvM+0o 87gToILv2ETXq/LvCnAItNAuDI4lKA1bQlpUT+XO1cAt12BEFmLQNcW42suUqYh26mvAJXCZxfc5 +3xRzGS4ktGZn9uwis1HQDdzvoegK/mhKCk6Kfo/Ef1LgAEA1OTZevb7RacAAAAASUVORK5CYII=");
         this.mInfoButton.setImageDrawable(var3);
         this.mInfoButton.setLayoutParams(var4);
         this.mInfoButton.setScaleType(ScaleType.CENTER_CROP);
         this.mInfoButton.setPadding(0, 0, 0, 0);
         this.mInfoButton.setBackgroundColor(0);
         this.mInfoButton.setEnabled(true);
         this.mInfoButton.setVisibility(0);
         this.mInfoButton.setOnClickListener(new OnClickListener() {
            public void onClick(View var1) {
               VASTActivity.this.infoClicked();
            }
         });
         this.mButtonPanel.addView(this.mInfoButton);
      }

   }

   private void createMediaPlayer() {
      this.mMediaPlayer = new MediaPlayer();
      this.mMediaPlayer.setOnCompletionListener(this);
      this.mMediaPlayer.setOnErrorListener(this);
      this.mMediaPlayer.setOnPreparedListener(this);
      this.mMediaPlayer.setOnVideoSizeChangedListener(this);
      this.mMediaPlayer.setAudioStreamType(3);
   }

   private void createOverlay(LayoutParams var1) {
      this.mOverlay = new RelativeLayout(this);
      this.mOverlay.setLayoutParams(var1);
      this.mOverlay.setPadding(0, 0, 0, 0);
      this.mOverlay.setBackgroundColor(0);
      this.mOverlay.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            VASTActivity.this.startToolBarTimer();
         }
      });
      this.mRootLayout.addView(this.mOverlay);
   }

   private void createPlayPauseButton(int var1) {
      LayoutParams var2 = new LayoutParams(var1, var1);
      var2.addRule(9);
      this.mPauseDrawable = Assets.getDrawableFromBase64(this.getResources(), "iVBORw0KGgoAAAANSUhEUgAAAC0AAAAtCAYAAAA6GuKaAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJ bWFnZVJlYWR5ccllPAAAA2hpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdp bj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6 eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0 NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJo dHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlw dGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEu MC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVz b3VyY2VSZWYjIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtcE1N Ok9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDpGOUU5MjA4OTBDMjA2ODExODA4M0YyQ0E4QjA4 M0I1MCIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDpDNDMxMTM3NzYxMjAxMUUzQjhCRkRDNTJC NjI0NTY5OCIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDpDNDMxMTM3NjYxMjAxMUUzQjhCRkRD NTJCNjI0NTY5OCIgeG1wOkNyZWF0b3JUb29sPSJBZG9iZSBQaG90b3Nob3AgQ1M2IChNYWNpbnRv c2gpIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6MDM4MDEx NzQwNzIwNjgxMTgwODNBRjJCNzQzNDlDQ0IiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6RjlF OTIwODkwQzIwNjgxMTgwODNGMkNBOEIwODNCNTAiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRm OlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz7tuMs8AAADCElEQVR42uzZW0gU URzHcddVu4hlFwvTsKToZhZRPlVQgdFDQReyQui1XgLBSirwQXqLwvC1EKIgrMgKgkIfoqALimFa CEWGLRSoWG5Cptt36Le0iO7OdQdhD3wY0XHmNztzzpzz30AkEkmbbi09bRq2VOhU6Dgtw6XjrMdW bMFq5CETP9GHdrzGc/Q7PVnAwegxG8dwEhvwB53owSBGkY18lGIpwmhGA17aTm2EtqECHzGGuziA BXH2z0QJatAT+dduocjO+a3+Qw4addLbWGfjpFk4jq8YxEEvQ+fjDYZwyOYdijUP1/UBVHsReiG6 0Is1LgSOVaPgZ90MbTyPrQhhmcuBo04r+BG3QtfpgGUeBY66hhEUOw1dauHWGRdVjuWTdLxd+ltu gk7+GQ+dhn6gISrLROh2XWDthN/nRf637QmOsd/MfvFe42uxF3X4bWLI/6XtxH2Nt9ewfh5LcIxm vaDO2J17VOrNdi+J04px1GM3Cu2ENj7l+3r1JrM9Vvhyq6GXYCVafJjEhfBBEzBLoVcZkyl0+zT7 bEOJ1dCLFTrkU+hezQrTrYTOVuiwT6GNeXgOglZCj2sb9Cl0MN7wOFXoIY2vc30KPR8DWliYDt2n bZFPoY2B4JM+ONOh32MEm3x6NDZrXWnp8TA6wiu9YJLdSjRytNp5I97BTh8ekaNasT+zGzqs1Xay Wi5OoDHecBsvtNF7r6BKtytRm6Ft5sQyBWaZLA5Va9+rTipMl3WrGkyEfoeOmJEn2kbVPzrUV6Zq Rm3kPC7ii9O6xx5NzKs8XGrNQTfazCw4zB70goJXehA4Gy3oxwq36x71Cn7KxcAFeIEfVhbOVk9S q+A3VbxxEnifyhLGYnajl2Wx6OLzGwZwzkb4bXiki2/CIq9rebEr7EsIq0zWpOe9VOWuoPabiULs UL94q7CdKlraOn/A4RdFBajAYZRpJT6i2VlEQ2qW5ufGIvkpbuDJVDM4r+vTk60rjbG2WFPLDI3L 39GluvWwGycKpL6SS4VOhU6FttX+CjAAgpoINtDHo/4AAAAASUVORK5CYII=");
      this.mPlayDrawable = Assets.getDrawableFromBase64(this.getResources(), "iVBORw0KGgoAAAANSUhEUgAAAC0AAAAtCAYAAAA6GuKaAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJ bWFnZVJlYWR5ccllPAAAA2hpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdp bj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6 eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0 NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJo dHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlw dGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEu MC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVz b3VyY2VSZWYjIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtcE1N Ok9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDpGNEU5MjA4OTBDMjA2ODExODA4M0YyQ0E4QjA4 M0I1MCIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDo2MzBFQTlFNjYxMjAxMUUzQjhCRkRDNTJC NjI0NTY5OCIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDo2MzBFQTlFNTYxMjAxMUUzQjhCRkRD NTJCNjI0NTY5OCIgeG1wOkNyZWF0b3JUb29sPSJBZG9iZSBQaG90b3Nob3AgQ1M2IChNYWNpbnRv c2gpIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6MDI4MDEx NzQwNzIwNjgxMTgwODNBRjJCNzQzNDlDQ0IiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6RjRF OTIwODkwQzIwNjgxMTgwODNGMkNBOEIwODNCNTAiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRm OlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz77Lxw7AAADm0lEQVR42uyZXUgU URiG1dW1H0szrazwF9O0ItmEDBOW8qKopC66qKiIgiDKLkKCfgiJIArSLuyiQsoMIugiMAgqCylE CAMtgpJAS/JvLY2ldpXtPfQOLTK7e2bmjCj4wcOiO3O+d2bOfud7z0QHAoGo6RYxUdMwZkRPVsQq HCsOpIMlIIH/84I+0A1+TxXR88EWsAuUgWTgnHCMHwyDVvAINIFBK0mjTVaPRHAMVIJF4At4AdrB J+ABYuAFIBusBW6QD0ZAHajhUzAeQrRBtoOuwL94ANwgVuI8B9gA6nnud7DXRH5DosVTucyELaDY TEKyEjRxrFsg3g7RTtDAJBck76wMxznmE5CgWvRtDn5IkdhgdoBx3nmnKtGnKfiIDYI1KpjjugrR JRzsqo2CNU4xV0WkY8OVPFHD21h3i1hv9WI2mMVabDWaQRZYDUbNlLx9vHJ3hCvPB+/BfgU/0FXM WWVmeoia2gmaJRLlBP7HM1BmUXgja/gco6LXU8ROSdH+IOF+VpsVJkWXRJrboU68AjyStXOiaC0G wHmQZFC0gyvufaOixdR4KJkklGgtOjnfYwwIrwF9IE7ve71+OhVksHKoiEJwBzxlJygTbWzEsmVN wHIwF3xU3LtvZid4E+RFOLaLn5myopNEywp6bTAdDnAYtIBzbF31QmtZU2RFxwe5DrtCTMFq8BYU 63zvDVq4pJyL3wYrphfCLFwDn0NYNxFjsqK1q0y2SewQuAFqw9iuRDqfEdnp0Q98IEex2HHQAEo5 n8P5xAz+rr7J3ukeerw1CgW/BBfBcwNl0scpJCXaR+fsViBWzNdLoJHjykY5TbLHSJd3gKtZockV cQhUgxQTvcdS4ANnjC7jqcDLHkRG9BjFCtt0FxRY6PJOcqxcM86lDvziBYQ7Lo9JRBtbbrEtFe1o N3hs1m5l8jHVRki0jIbXqcByVfEGuKx4xLMcZOMkeMQCTq86Kx4xit6vmXWzOFTdVBCi33nDFsIF fljdFssC/eAdWGzDHZ5Hm/YHrFO5WSPs1yjosGCj9EgDrzgtttqxlyf27nrBT7BHgeBt4CvH22TX BqQgPWjjUHyWmhDr4m6riNeSC5gl0RoHQQ8Tt4JKJk8MMWfFlDrKWq6tmCcM+kbp6hFpY303nYiL rmSQDdcI/xa2LY2vNER0gHpwDwxM9puAiZFL4UX0fwvZWg6zU2unS/mgIpkq0TOv5GZET5X4K8AA /T7sDkDoeaAAAAAASUVORK5CYII=");
      this.mPlayPauseButton = new ImageButton(this);
      this.mPlayPauseButton.setImageDrawable(this.mPauseDrawable);
      this.mPlayPauseButton.setLayoutParams(var2);
      this.mPlayPauseButton.setScaleType(ScaleType.CENTER_CROP);
      this.mPlayPauseButton.setPadding(0, 0, 0, 0);
      this.mPlayPauseButton.setBackgroundColor(0);
      this.mPlayPauseButton.setEnabled(true);
      this.mPlayPauseButton.setVisibility(0);
      this.mPlayPauseButton.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            VASTActivity.this.playPauseButtonClicked();
         }
      });
      this.mButtonPanel.addView(this.mPlayPauseButton);
   }

   private void createProgressBar() {
      LayoutParams var1 = new LayoutParams(-1, -2);
      var1.addRule(13);
      this.mProgressBar = new ProgressBar(this);
      this.mProgressBar.setLayoutParams(var1);
      this.mRootLayout.addView(this.mProgressBar);
      this.mProgressBar.setVisibility(8);
   }

   private void createRootLayout(LayoutParams var1) {
      this.mRootLayout = new RelativeLayout(this);
      this.mRootLayout.setLayoutParams(var1);
      this.mRootLayout.setPadding(0, 0, 0, 0);
      this.mRootLayout.setBackgroundColor(-16777216);
   }

   private void createSurface(LayoutParams var1) {
      this.mSurfaceView = new SurfaceView(this);
      this.mSurfaceView.setLayoutParams(var1);
      this.mSurfaceHolder = this.mSurfaceView.getHolder();
      this.mSurfaceHolder.addCallback(this);
      this.mSurfaceHolder.setType(3);
      this.mRootLayout.addView(this.mSurfaceView);
   }

   private void createUIComponents() {
      LayoutParams var2 = new LayoutParams(-1, -1);
      this.createRootLayout(var2);
      this.createSurface(var2);
      this.createMediaPlayer();
      this.createOverlay(var2);
      this.createButtonPanel(this.mScreenWidth, this.mScreenHeight);
      int var1 = (int)((double)Math.min(this.mScreenWidth, this.mScreenHeight) * 0.15D);
      this.createPlayPauseButton(var1);
      this.createCloseButton(var1);
      this.createInfoButton(var1);
      this.setContentView(this.mRootLayout);
      this.createProgressBar();
   }

   private void finishVAST() {
      VASTPlayer.listener.vastDismiss();
      this.finish();
   }

   private void fireUrls(List var1) {
      VASTLog.d(TAG, "entered fireUrls");
      if(var1 == null) {
         VASTLog.d(TAG, "\turl list is null");
      } else {
         Iterator var3 = var1.iterator();

         while(var3.hasNext()) {
            String var2 = (String)var3.next();
            VASTLog.v(TAG, "\tfiring url:" + var2);
            HttpTools.httpGetURL(var2);
         }

      }
   }

   private void hideProgressBar() {
      this.mProgressBar.setVisibility(8);
   }

   private void hideTitleStatusBars() {
      this.requestWindowFeature(1);
      this.getWindow().setFlags(1024, 1024);
   }

   private void infoClicked() {
      VASTLog.d(TAG, "entered infoClicked:");
      this.activateButtons(false);
      if(this.mMediaPlayer.isPlaying()) {
         this.mMediaPlayer.pause();
         this.mCurrentVideoPosition = this.mMediaPlayer.getCurrentPosition();
      }

      this.processClickThroughEvent();
   }

   private void overlayClicked() {
      this.startToolBarTimer();
   }

   private void playPauseButtonClicked() {
      VASTLog.d(TAG, "entered playPauseClicked");
      if(this.mMediaPlayer == null) {
         VASTLog.e(TAG, "mMediaPlayer is null when playPauseButton was clicked");
      } else {
         boolean var1 = this.mMediaPlayer.isPlaying();
         VASTLog.d(TAG, "isPlaying:" + var1);
         if(var1) {
            this.processPauseSteps();
            return;
         }

         if(!this.mIsVideoPaused) {
            this.processPlaySteps();
            this.mQuartile = 0;
            this.startQuartileTimer();
            return;
         }

         this.processPlaySteps();
         if(!this.mIsCompleted) {
            this.processEvent(TRACKING_EVENTS_TYPE.resume);
            return;
         }
      }

   }

   private void processClickThroughEvent() {
      VASTLog.d(TAG, "entered processClickThroughEvent:");
      if(VASTPlayer.listener != null) {
         VASTPlayer.listener.vastClick();
      }

      String var1 = this.mVastModel.getVideoClicks().getClickThrough();
      VASTLog.d(TAG, "clickThrough url: " + var1);
      this.fireUrls(this.mVastModel.getVideoClicks().getClickTracking());

      try {
         Intent var3 = new Intent("android.intent.action.VIEW", Uri.parse(var1));
         if(this.getPackageManager().resolveActivity(var3, 32) == null) {
            VASTLog.e(TAG, "Clickthrough error occured, uri unresolvable");
            if((double)this.mCurrentVideoPosition >= (double)this.mMediaPlayer.getCurrentPosition() * 0.99D) {
               this.mMediaPlayer.start();
            }

            this.activateButtons(true);
         } else {
            this.startActivity(var3);
         }
      } catch (NullPointerException var2) {
         VASTLog.e(TAG, var2.getMessage(), var2);
      }
   }

   private void processErrorEvent() {
      VASTLog.d(TAG, "entered processErrorEvent");
      this.fireUrls(this.mVastModel.getErrorUrl());
   }

   private void processEvent(TRACKING_EVENTS_TYPE var1) {
      VASTLog.i(TAG, "entered Processing Event: " + var1);
      this.fireUrls((List)this.mTrackingEventMap.get(var1));
   }

   private void processImpressions() {
      VASTLog.d(TAG, "entered processImpressions");
      this.mIsProcessedImpressions = true;
      this.fireUrls(this.mVastModel.getImpressions());
   }

   private void processPauseSteps() {
      this.mIsVideoPaused = true;
      this.mMediaPlayer.pause();
      this.stopVideoProgressTimer();
      this.stopToolBarTimer();
      this.mPlayPauseButton.setImageDrawable(this.mPlayDrawable);
      if(!this.mIsCompleted) {
         this.processEvent(TRACKING_EVENTS_TYPE.pause);
      }

   }

   private void processPlaySteps() {
      this.mIsVideoPaused = false;
      this.mMediaPlayer.start();
      this.mPlayPauseButton.setImageDrawable(this.mPauseDrawable);
      this.startToolBarTimer();
      this.startVideoProgressTimer();
   }

   private void showProgressBar() {
      this.mProgressBar.setVisibility(0);
   }

   private void startQuartileTimer() {
      VASTLog.d(TAG, "entered startQuartileTimer");
      this.stopQuartileTimer();
      if(this.mIsCompleted) {
         VASTLog.d(TAG, "ending quartileTimer becuase the video has been replayed");
      } else {
         final int var1 = this.mMediaPlayer.getDuration();
         this.mTrackingEventTimer = new Timer();
         this.mTrackingEventTimer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
               // $FF: Couldn't be decompiled
            }
         }, 0L, 250L);
      }
   }

   private void startToolBarTimer() {
      VASTLog.d(TAG, "entered startToolBarTimer");
      if(this.mQuartile != 4) {
         if(this.mMediaPlayer != null && this.mMediaPlayer.isPlaying()) {
            this.stopToolBarTimer();
            this.mToolBarTimer = new Timer();
            this.mToolBarTimer.schedule(new TimerTask() {
               public void run() {
                  VASTActivity.this.mHandler.post(new Runnable() {
                     public void run() {
                        VASTLog.d(VASTActivity.TAG, "hiding buttons");
                        VASTActivity.this.mButtonPanel.setVisibility(8);
                     }
                  });
               }
            }, 3000L);
            this.mButtonPanel.setVisibility(0);
         }

         if(this.mIsVideoPaused) {
            this.activateButtons(true);
            return;
         }
      }

   }

   private void startVideoProgressTimer() {
      VASTLog.d(TAG, "entered startVideoProgressTimer");
      this.mStartVideoProgressTimer = new Timer();
      this.mVideoProgressTracker = new LinkedList();
      this.mStartVideoProgressTimer.schedule(new TimerTask() {
         int maxAmountInList = 19;

         public void run() {
            if(VASTActivity.this.mMediaPlayer != null) {
               int var1;
               if(VASTActivity.this.mVideoProgressTracker.size() == this.maxAmountInList) {
                  var1 = ((Integer)VASTActivity.this.mVideoProgressTracker.getFirst()).intValue();
                  int var2 = ((Integer)VASTActivity.this.mVideoProgressTracker.getLast()).intValue();
                  if(var2 > var1) {
                     VASTLog.v(VASTActivity.TAG, "video progressing (position:" + var2 + ")");
                     VASTActivity.this.mVideoProgressTracker.removeFirst();
                  } else {
                     VASTLog.e(VASTActivity.TAG, "detected video hang");
                     VASTActivity.this.mIsPlayBackError = true;
                     VASTActivity.this.stopVideoProgressTimer();
                     VASTActivity.this.processErrorEvent();
                     VASTActivity.this.closeClicked();
                     VASTActivity.this.finishVAST();
                  }
               }

               try {
                  var1 = VASTActivity.this.mMediaPlayer.getCurrentPosition();
                  VASTActivity.this.mVideoProgressTracker.addLast(Integer.valueOf(var1));
               } catch (Exception var4) {
                  ;
               }
            }
         }
      }, 0L, 250L);
   }

   private void stopQuartileTimer() {
      if(this.mTrackingEventTimer != null) {
         this.mTrackingEventTimer.cancel();
         this.mTrackingEventTimer = null;
      }

   }

   private void stopToolBarTimer() {
      VASTLog.d(TAG, "entered stopToolBarTimer");
      if(this.mToolBarTimer != null) {
         this.mToolBarTimer.cancel();
         this.mToolBarTimer = null;
      }

   }

   private void stopVideoProgressTimer() {
      VASTLog.d(TAG, "entered stopVideoProgressTimer");
      if(this.mStartVideoProgressTimer != null) {
         this.mStartVideoProgressTimer.cancel();
      }

   }

   public void onBackPressed() {
      VASTLog.d(TAG, "entered onBackPressed");
      this.closeClicked();
   }

   public void onCompletion(MediaPlayer var1) {
      VASTLog.d(TAG, "entered onCOMPLETION -- (MediaPlayer callback)");
      this.stopVideoProgressTimer();
      this.stopToolBarTimer();
      this.mButtonPanel.setVisibility(0);
      this.mPlayPauseButton.setImageDrawable(this.mPlayDrawable);
      if(!this.mIsPlayBackError && !this.mIsCompleted) {
         this.mIsCompleted = true;
         this.processEvent(TRACKING_EVENTS_TYPE.complete);
         if(VASTPlayer.listener != null) {
            VASTPlayer.listener.vastComplete();
         }
      }

   }

   protected void onCreate(Bundle var1) {
      VASTLog.d(TAG, "in onCreate");
      super.onCreate(var1);
      int var2 = this.getResources().getConfiguration().orientation;
      VASTLog.d(TAG, "currentOrientation:" + var2);
      if(var2 != 2) {
         VASTLog.d(TAG, "Orientation is not landscape.....forcing landscape");
         this.setRequestedOrientation(0);
      } else {
         VASTLog.d(TAG, "orientation is landscape");
         this.mVastModel = (VASTModel)this.getIntent().getSerializableExtra("com.nexage.android.vast.player.vastModel");
         if(this.mVastModel == null) {
            VASTLog.e(TAG, "vastModel is null. Stopping activity.");
            this.finishVAST();
         } else {
            this.hideTitleStatusBars();
            this.mHandler = new Handler();
            DisplayMetrics var3 = this.getResources().getDisplayMetrics();
            this.mScreenWidth = var3.widthPixels;
            this.mScreenHeight = var3.heightPixels;
            this.mTrackingEventMap = this.mVastModel.getTrackingUrls();
            this.createUIComponents();
         }
      }
   }

   protected void onDestroy() {
      VASTLog.d(TAG, "entered on onDestroy --(life cycle event)");
      super.onDestroy();
   }

   public boolean onError(MediaPlayer var1, int var2, int var3) {
      VASTLog.e(TAG, "entered onError -- (MediaPlayer callback)");
      this.mIsPlayBackError = true;
      VASTLog.e(TAG, "Shutting down Activity due to Media Player errors: WHAT:" + var2 + ": EXTRA:" + var3 + ":");
      this.processErrorEvent();
      this.closeClicked();
      return true;
   }

   protected void onPause() {
      VASTLog.d(TAG, "entered on onPause --(life cycle event)");
      super.onPause();
      if(this.mMediaPlayer != null) {
         this.mCurrentVideoPosition = this.mMediaPlayer.getCurrentPosition();
      }

      this.cleanActivityUp();
   }

   public void onPrepared(MediaPlayer var1) {
      VASTLog.d(TAG, "entered onPrepared called --(MediaPlayer callback) ....about to play");
      this.calculateAspectRatio();
      this.mMediaPlayer.start();
      this.hideProgressBar();
      if(this.mIsVideoPaused) {
         VASTLog.d(TAG, "pausing video");
         this.mMediaPlayer.pause();
      } else {
         this.startVideoProgressTimer();
      }

      VASTLog.d(TAG, "current location in video:" + this.mCurrentVideoPosition);
      if(this.mCurrentVideoPosition > 0) {
         VASTLog.d(TAG, "seeking to location:" + this.mCurrentVideoPosition);
         this.mMediaPlayer.seekTo(this.mCurrentVideoPosition);
      }

      if(!this.mIsProcessedImpressions) {
         this.processImpressions();
      }

      this.startQuartileTimer();
      this.startToolBarTimer();
      if(!this.mMediaPlayer.isPlaying() && !this.mIsVideoPaused) {
         this.mMediaPlayer.start();
      }

   }

   protected void onRestart() {
      VASTLog.d(TAG, "entered on onRestart --(life cycle event)");
      super.onRestart();
      this.createMediaPlayer();
   }

   public void onRestoreInstanceState(Bundle var1) {
      VASTLog.d(TAG, "in onRestoreInstanceState");
      super.onRestoreInstanceState(var1);
   }

   protected void onResume() {
      VASTLog.d(TAG, "entered on onResume --(life cycle event)");
      super.onResume();
   }

   public void onSaveInstanceState(Bundle var1) {
      VASTLog.d(TAG, "entered onSaveInstanceState ");
      super.onSaveInstanceState(var1);
   }

   protected void onStart() {
      VASTLog.d(TAG, "entered onStart --(life cycle event)");
      super.onStart();
   }

   protected void onStop() {
      VASTLog.d(TAG, "entered on onStop --(life cycle event)");
      super.onStop();
   }

   public void onVideoSizeChanged(MediaPlayer var1, int var2, int var3) {
      VASTLog.d(TAG, "entered onVideoSizeChanged -- (MediaPlayer callback)");
      this.mVideoWidth = var2;
      this.mVideoHeight = var3;
      VASTLog.d(TAG, "video size: " + this.mVideoWidth + "x" + this.mVideoHeight);
   }

   public void surfaceChanged(SurfaceHolder var1, int var2, int var3, int var4) {
      VASTLog.d(TAG, "entered surfaceChanged -- (SurfaceHolder callback)");
   }

   public void surfaceCreated(SurfaceHolder var1) {
      VASTLog.d(TAG, "surfaceCreated -- (SurfaceHolder callback)");

      try {
         if(this.mMediaPlayer == null) {
            this.createMediaPlayer();
         }

         this.showProgressBar();
         this.mMediaPlayer.setDisplay(this.mSurfaceHolder);
         String var3 = this.mVastModel.getPickedMediaFileURL();
         VASTLog.d(TAG, "URL for media file:" + var3);
         this.mMediaPlayer.setDataSource(var3);
         this.mMediaPlayer.prepareAsync();
      } catch (Exception var2) {
         VASTLog.e(TAG, var2.getMessage(), var2);
      }
   }

   public void surfaceDestroyed(SurfaceHolder var1) {
      VASTLog.d(TAG, "entered surfaceDestroyed -- (SurfaceHolder callback)");
      this.cleanUpMediaPlayer();
   }
}
