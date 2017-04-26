package com.inneractive.api.ads.sdk;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Rect;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.RelativeLayout.LayoutParams;
import com.inneractive.api.ads.sdk.IAbaseWebView;
import com.inneractive.api.ads.sdk.IAbaseWebView$IAviewState;
import com.inneractive.api.ads.sdk.IAdefines$IAbannerDefaultHeight;
import com.inneractive.api.ads.sdk.IAmraidActionFactory$MraidJavascriptCommand;
import com.inneractive.api.ads.sdk.IAmraidWebView;
import com.inneractive.api.ads.sdk.IAmraidWebView$ExpandMode;
import com.inneractive.api.ads.sdk.IAmraidWebView$MraidPlacementType;
import com.inneractive.api.ads.sdk.IAmraidWebView$NativeCloseButtonMode;
import com.inneractive.api.ads.sdk.IAmraidWebViewController$ForceOrientationType;
import com.inneractive.api.ads.sdk.IAmraidWebViewController$a;
import com.inneractive.api.ads.sdk.IAmraidWebViewController$b;
import com.inneractive.api.ads.sdk.InneractiveAdView$Log;
import com.inneractive.api.ads.sdk.InneractiveRichMediaVideoPlayerActivity;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

final class IAmraidWebViewController {
   private static final int CLOSE_BUTTON_SIZE_DP = 50;
   private static final String[] DATE_FORMATS = new String[]{"yyyy-MM-dd\'T\'HH:mm:ssZZZZZ", "yyyy-MM-dd\'T\'HH:mmZZZZZ"};
   private static final int MAX_NUMBER_DAYS_IN_MONTH = 31;
   protected IAmraidWebViewController$ForceOrientationType forceOrientation;
   private FrameLayout mAdContainerLayout;
   protected int mAdHeight;
   private boolean mAdWantsCustomCloseButton;
   protected int mAdWidth;
   private r mCloseButton;
   protected float mDensity;
   private RelativeLayout mExpandLayout;
   private final IAmraidWebView$ExpandMode mExpandMode;
   private Handler mHandler;
   protected int mMaxHeight;
   protected int mMaxWidth;
   IAmraidWebView mMraidView;
   private final IAmraidWebView$NativeCloseButtonMode mNativeCloseButtonMode;
   private IAmraidWebViewController$b mOrientationBroadcastReceiver;
   private final int mOriginalRequestedOrientation;
   private FrameLayout mPlaceholderView;
   private FrameLayout mRootView;
   protected int mScreenHeight;
   protected int mScreenWidth;
   private IAmraidWebView mSecondExpandView;
   private int mViewIndexInParent;
   private IAbaseWebView$IAviewState mViewState;
   View resizedContentView;

   IAmraidWebViewController(IAmraidWebView var1, IAmraidWebView$ExpandMode var2, IAmraidWebView$NativeCloseButtonMode var3) {
      this.mViewState = IAbaseWebView$IAviewState.e;
      this.mHandler = new Handler();
      this.mOrientationBroadcastReceiver = new IAmraidWebViewController$b(this);
      this.mScreenWidth = -1;
      this.mScreenHeight = -1;
      this.mMaxWidth = -1;
      this.mMaxHeight = -1;
      this.mAdWidth = -1;
      this.mAdHeight = -1;
      this.forceOrientation = IAmraidWebViewController$ForceOrientationType.NONE;
      this.mMraidView = var1;
      this.mExpandMode = var2;
      this.mNativeCloseButtonMode = var3;
      Context var5 = this.getContext();
      int var4;
      if(var5 instanceof Activity) {
         var4 = ((Activity)var5).getRequestedOrientation();
      } else {
         var4 = -1;
      }

      this.mOriginalRequestedOrientation = var4;
      this.mAdContainerLayout = this.generateAdContainerLayout();
      this.mExpandLayout = this.generateExpandLayout();
      this.mPlaceholderView = this.generatePlaceholderView();
      this.initialize();
      this.mMraidView.setOnKeyListener(new OnKeyListener() {
         public final boolean onKey(View var1, int var2, KeyEvent var3) {
            if(var2 == 4 && IAmraidWebViewController.this.isExpanded()) {
               InneractiveAdView$Log.d("back button pressed while ad is expanded, ad will be collapsed.");
               IAmraidWebViewController.this.close();
               return true;
            } else {
               return false;
            }
         }
      });
   }

   // $FF: synthetic method
   static void access$700(IAmraidWebViewController var0, int var1) {
      var0.onOrientationChanged(var1);
   }

   private String dayNumberToDayOfMonthString(int var1) {
      if(var1 != 0 && var1 >= -31 && var1 <= 31) {
         return "" + var1;
      } else {
         throw new IllegalArgumentException("invalid day of month " + var1);
      }
   }

   private String dayNumberToDayOfWeekString(int var1) {
      switch(var1) {
      case 0:
         return "SU";
      case 1:
         return "MO";
      case 2:
         return "TU";
      case 3:
         return "WE";
      case 4:
         return "TH";
      case 5:
         return "FR";
      case 6:
         return "SA";
      default:
         throw new IllegalArgumentException("invalid day of week " + var1);
      }
   }

   private void displayDialog(final String var1) {
      (new Builder(this.getContext())).setTitle("Save Image").setMessage("Download image to Picture gallery?").setNegativeButton("Cancel", (OnClickListener)null).setPositiveButton("Okay", new OnClickListener() {
         public final void onClick(DialogInterface var1x, int var2) {
            IAmraidWebViewController.this.downloadImage(var1);
         }
      }).setCancelable(true).show();
   }

   private void displayToast(final String var1) {
      this.mHandler.post(new Runnable() {
         public final void run() {
            Toast.makeText(IAmraidWebViewController.this.getContext(), var1, 0).show();
         }
      });
   }

   private void downloadImage(final String var1) {
      final File var2 = this.getPictureStoragePath();
      var2.mkdirs();
      (new Thread(new Runnable() {
         private MediaScannerConnection mediaScannerConnection;
         private InputStream pictureInputStream;
         private OutputStream pictureOutputStream;
         private URI uri;

         private void loadPictureIntoGalleryApp(String var1x) {
            IAmraidWebViewController$a var2x = new IAmraidWebViewController$a(IAmraidWebViewController.this, var1x, (String)null, null);
            this.mediaScannerConnection = new MediaScannerConnection(IAmraidWebViewController.this.getContext().getApplicationContext(), var2x);
            IAmraidWebViewController$a.access$500(var2x, this.mediaScannerConnection);
            this.mediaScannerConnection.connect();
         }

         public final void run() {
            try {
               this.uri = URI.create(var1);
               HttpResponse var1x = com.inneractive.api.ads.sdk.y.a().execute(new HttpGet(this.uri));
               this.pictureInputStream = var1x.getEntity().getContent();
               String var7 = IAmraidWebViewController.this.getFileNameForUriAndHttpResponse(this.uri, var1x);
               File var8 = new File(var2, var7);
               String var2x = var8.toString();
               this.pictureOutputStream = new FileOutputStream(var8);
               an.a(this.pictureInputStream, this.pictureOutputStream);
               this.loadPictureIntoGalleryApp(var2x);
               return;
            } catch (Exception var5) {
               IAmraidWebViewController.this.mHandler.post(new Runnable() {
                  public final void run() {
                     IAmraidWebViewController.this.displayToast("Image failed to download.");
                     IAmraidWebViewController.this.getView().fireErrorEvent(IAmraidActionFactory$MraidJavascriptCommand.j, "Error downloading and saving image file.");
                     InneractiveAdView$Log.a("failed to download and save the image file.");
                  }
               });
            } finally {
               an.a((Closeable)this.pictureInputStream);
               an.a((Closeable)this.pictureOutputStream);
            }

         }
      })).start();
   }

   private void expandLayouts(View var1, int var2, int var3) {
      int var4 = (int)(50.0F * this.mDensity + 0.5F);
      int var5 = var2;
      if(var2 < var4) {
         var5 = var4;
      }

      var2 = var3;
      if(var3 < var4) {
         var2 = var4;
      }

      View var6 = new View(this.getContext());
      var6.setBackgroundColor(0);
      var6.setOnTouchListener(new OnTouchListener() {
         public final boolean onTouch(View var1, MotionEvent var2) {
            return true;
         }
      });
      this.mExpandLayout.addView(var6, new LayoutParams(-1, -1));
      an.a(var1);
      this.mAdContainerLayout.addView(var1, new LayoutParams(-1, -1));
      an.a((View)this.mAdContainerLayout);
      LayoutParams var7 = new LayoutParams(var5, var2);
      var7.addRule(13);
      this.mExpandLayout.addView(this.mAdContainerLayout, var7);
   }

   private Context getContext() {
      return this.getView().getContext();
   }

   private String getFileNameForUriAndHttpResponse(URI var1, HttpResponse var2) {
      String var6 = var1.getPath();
      if(var6 == null) {
         var6 = null;
      } else {
         String var5 = (new File(var6)).getName();
         Header var7 = var2.getFirstHeader("text/html");
         var6 = var5;
         if(var7 != null) {
            String[] var8 = var7.getValue().split(";");
            int var4 = var8.length;
            int var3 = 0;

            while(true) {
               var6 = var5;
               if(var3 >= var4) {
                  break;
               }

               var6 = var8[var3];
               if(var6.contains("image/")) {
                  String var9 = "." + var6.split("/")[1];
                  var6 = var5;
                  if(!var5.endsWith(var9)) {
                     return var5 + var9;
                  }
                  break;
               }

               ++var3;
            }
         }
      }

      return var6;
   }

   private File getPictureStoragePath() {
      return new File(Environment.getExternalStorageDirectory(), "Pictures");
   }

   private void initialize() {
      this.mViewState = IAbaseWebView$IAviewState.a;
      this.initializeScreenMetrics();
      this.mOrientationBroadcastReceiver.register(this.getContext());
   }

   private void initializeScreenMetrics() {
      int var2 = 0;
      Context var6 = this.getContext();
      DisplayMetrics var5 = new DisplayMetrics();
      ((WindowManager)var6.getSystemService("window")).getDefaultDisplay().getMetrics(var5);
      this.mDensity = var5.density;
      int var1;
      if(var6 instanceof Activity) {
         Window var8 = ((Activity)var6).getWindow();
         Rect var7 = new Rect();
         var8.getDecorView().getWindowVisibleDisplayFrame(var7);
         var2 = var7.top;
         var1 = var8.findViewById(16908290).getTop() - var2;
      } else {
         var1 = 0;
      }

      int var3 = var5.widthPixels;
      int var4 = var5.heightPixels;
      this.mScreenWidth = (int)((double)var3 * (160.0D / (double)var5.densityDpi));
      this.mScreenHeight = (int)((double)var4 * (160.0D / (double)var5.densityDpi));
      var4 = var5.heightPixels;
      this.mMaxWidth = (int)((double)var3 * (160.0D / (double)var5.densityDpi));
      this.mMaxHeight = (int)((double)(var4 - var2 - var1) * (160.0D / (double)var5.densityDpi));
   }

   private void onOrientationChanged(int var1) {
      this.initializeScreenMetrics();
      this.getView().fireChangeEventForAsset(com.inneractive.api.ads.sdk.U.a(this.mScreenWidth, this.mScreenHeight));
      this.getView().fireChangeEventForAsset(com.inneractive.api.ads.sdk.S.a(this.mMaxWidth, this.mMaxHeight));
      if(this.mAdWidth != -1 && this.mAdHeight != -1) {
         this.getView().fireChangeEventForAsset(Q.a(this.mAdWidth, this.mAdHeight));
      }

   }

   private Date parseDate(String var1) {
      Date var3 = null;
      int var2 = 0;

      Date var4;
      while(true) {
         var4 = var3;
         if(var2 >= DATE_FORMATS.length) {
            break;
         }

         label19: {
            try {
               var4 = (new SimpleDateFormat(DATE_FORMATS[var2])).parse(var1);
            } catch (ParseException var5) {
               var4 = var3;
               break label19;
            }

            var3 = var4;
            var4 = var4;
            if(var3 != null) {
               var4 = var3;
               break;
            }
         }

         ++var2;
         var3 = var4;
      }

      return var4;
   }

   private String parseRecurrenceRule(Map var1) {
      StringBuilder var3 = new StringBuilder();
      if(var1.containsKey("frequency")) {
         String var4 = (String)var1.get("frequency");
         int var2;
         if(var1.containsKey("interval")) {
            var2 = Integer.parseInt((String)var1.get("interval"));
         } else {
            var2 = -1;
         }

         if("daily".equals(var4)) {
            var3.append("FREQ=DAILY;");
            if(var2 != -1) {
               var3.append("INTERVAL=" + var2 + ";");
            }
         } else {
            String var5;
            if("weekly".equals(var4)) {
               var3.append("FREQ=WEEKLY;");
               if(var2 != -1) {
                  var3.append("INTERVAL=" + var2 + ";");
               }

               if(var1.containsKey("daysInWeek")) {
                  var5 = this.translateWeekIntegersToDays((String)var1.get("daysInWeek"));
                  if(var5 == null) {
                     throw new IllegalArgumentException("invalid ");
                  }

                  var3.append("BYDAY=" + var5 + ";");
               }
            } else {
               if(!"monthly".equals(var4)) {
                  throw new IllegalArgumentException("frequency is only supported for daily, weekly, and monthly.");
               }

               var3.append("FREQ=MONTHLY;");
               if(var2 != -1) {
                  var3.append("INTERVAL=" + var2 + ";");
               }

               if(var1.containsKey("daysInMonth")) {
                  var5 = this.translateMonthIntegersToDays((String)var1.get("daysInMonth"));
                  if(var5 == null) {
                     throw new IllegalArgumentException();
                  }

                  var3.append("BYMONTHDAY=" + var5 + ";");
               }
            }
         }
      }

      return var3.toString();
   }

   private void resetToDefaultState() {
      this.setNativeCloseButtonEnabled(false);
      this.mAdContainerLayout.removeAllViewsInLayout();
      this.mExpandLayout.removeAllViewsInLayout();
      if(this.mRootView != null) {
         this.mRootView.removeView(this.mExpandLayout);
      }

      if(this.resizedContentView != null) {
         Context var2 = this.getContext();
         if(com.inneractive.api.ads.sdk.a.l(var2)) {
            an.a((float)IAdefines$IAbannerDefaultHeight.d.e, var2);
         } else if(com.inneractive.api.ads.sdk.a.m(var2)) {
            float var1;
            if(com.inneractive.api.ads.sdk.a.n(var2) == 1) {
               var1 = (float)IAdefines$IAbannerDefaultHeight.b.e;
            } else {
               var1 = (float)IAdefines$IAbannerDefaultHeight.c.e;
            }

            an.a(var1, var2);
         } else {
            an.a((float)IAdefines$IAbannerDefaultHeight.a.e, var2);
         }

         this.resizedContentView.setLayoutParams(this.getView().getAdConfig().a((View)this.getView(), (Context)this.getContext()));
      }

      this.getView().requestLayout();
      ViewGroup var3 = (ViewGroup)this.mPlaceholderView.getParent();
      if(var3 != null) {
         var3.addView(this.getView(), this.mViewIndexInParent, this.getView().getAdConfig().a((View)this.getView(), (Context)this.getContext()));
         var3.removeView(this.mPlaceholderView);
         var3.invalidate();
      }

   }

   private void setOrientationLock(IAmraidWebViewController$ForceOrientationType var1) {
      IAbaseWebView$IAviewState var2 = this.mViewState;
      var2 = IAbaseWebView$IAviewState.c;
   }

   private void setOrientationLockEnabled(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   private void swapViewWithPlaceholderView() {
      ViewGroup var3 = (ViewGroup)this.getView().getParent();
      if(var3 != null) {
         int var2 = var3.getChildCount();

         int var1;
         for(var1 = 0; var1 < var2 && var3.getChildAt(var1) != this.getView(); ++var1) {
            ;
         }

         this.mViewIndexInParent = var1;
         an.a((View)this.mPlaceholderView);
         var3.addView(this.mPlaceholderView, var1, new ViewGroup.LayoutParams(this.getView().getWidth(), this.getView().getHeight()));
         var3.removeView(this.getView());
      }
   }

   private Map translateJSParamsToAndroidCalendarEventMapping(Map var1) {
      HashMap var3 = new HashMap();
      if(var1.containsKey("description") && var1.containsKey("start")) {
         var3.put("title", var1.get("description"));
         if(var1.containsKey("start") && var1.get("start") != null) {
            Date var4 = this.parseDate((String)var1.get("start"));
            if(var4 != null) {
               var3.put("beginTime", Long.valueOf(var4.getTime()));
               if(var1.containsKey("end") && var1.get("end") != null) {
                  var4 = this.parseDate((String)var1.get("end"));
                  if(var4 == null) {
                     throw new IllegalArgumentException("Invalid calendar event: end time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
                  }

                  var3.put("endTime", Long.valueOf(var4.getTime()));
               }

               if(var1.containsKey("location")) {
                  var3.put("eventLocation", var1.get("location"));
               }

               if(var1.containsKey("summary")) {
                  var3.put("description", var1.get("summary"));
               }

               if(var1.containsKey("transparency")) {
                  byte var2;
                  if("transparent".equals(var1.get("transparency"))) {
                     var2 = 1;
                  } else {
                     var2 = 0;
                  }

                  var3.put("availability", Integer.valueOf(var2));
               }

               var3.put("rrule", this.parseRecurrenceRule(var1));
               return var3;
            } else {
               throw new IllegalArgumentException("Invalid calendar event: start time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
            }
         } else {
            throw new IllegalArgumentException("Invalid calendar event: start is null.");
         }
      } else {
         throw new IllegalArgumentException("Missing start and description fields");
      }
   }

   private String translateMonthIntegersToDays(String var1) {
      StringBuilder var4 = new StringBuilder();
      boolean[] var5 = new boolean[63];
      String[] var6 = var1.split(",");

      for(int var2 = 0; var2 < var6.length; ++var2) {
         int var3 = Integer.parseInt(var6[var2]);
         if(!var5[var3 + 31]) {
            var4.append(this.dayNumberToDayOfMonthString(var3) + ",");
            var5[var3 + 31] = true;
         }
      }

      if(var6.length == 0) {
         throw new IllegalArgumentException("must have at least 1 day of the month if specifying repeating weekly");
      } else {
         var4.deleteCharAt(var4.length() - 1);
         return var4.toString();
      }
   }

   private String translateWeekIntegersToDays(String var1) {
      StringBuilder var5 = new StringBuilder();
      boolean[] var6 = new boolean[7];
      String[] var7 = var1.split(",");

      for(int var2 = 0; var2 < var7.length; ++var2) {
         int var4 = Integer.parseInt(var7[var2]);
         int var3 = var4;
         if(var4 == 7) {
            var3 = 0;
         }

         if(!var6[var3]) {
            var5.append(this.dayNumberToDayOfWeekString(var3) + ",");
            var6[var3] = true;
         }
      }

      if(var7.length == 0) {
         throw new IllegalArgumentException("must have at least 1 day of the week if specifying repeating weekly");
      } else {
         var5.deleteCharAt(var5.length() - 1);
         return var5.toString();
      }
   }

   protected final void close() {
      if(this.mViewState != IAbaseWebView$IAviewState.c && this.mViewState != IAbaseWebView$IAviewState.d) {
         if(this.mViewState == IAbaseWebView$IAviewState.b) {
            this.getView().setVisibility(4);
            this.mViewState = IAbaseWebView$IAviewState.e;
            this.getView().fireChangeEventForAsset(com.inneractive.api.ads.sdk.V.a(this.mViewState));
         }
      } else {
         this.resetToDefaultState();
         this.setOrientationLockEnabled(false);
         this.mViewState = IAbaseWebView$IAviewState.b;
         this.getView().fireChangeEventForAsset(com.inneractive.api.ads.sdk.V.a(this.mViewState));
      }

      if(this.getView().getListener() != null) {
         this.getView().getListener().onClose(this.getView(), this.mViewState);
      }

   }

   protected final void createCalendarEvent(Map param1) {
      // $FF: Couldn't be decompiled
   }

   public final void destroy() {
      try {
         this.mOrientationBroadcastReceiver.unregister();
      } catch (IllegalArgumentException var2) {
         if(!var2.getMessage().contains("Receiver not registered")) {
            throw var2;
         }
      }

   }

   protected final void displayDownloadImageAlert(String var1) {
      Context var2 = this.getContext();
      if(!com.inneractive.api.ads.sdk.a.j(var2)) {
         this.getView().fireErrorEvent(IAmraidActionFactory$MraidJavascriptCommand.j, "Error downloading file - the device does not have an SD card mounted, or the Android permission is not granted.");
         InneractiveAdView$Log.a("Error downloading file. Please check if the Android permission is not granted, or maybe the device does not have an SD card mounted? ");
      } else if(var2 instanceof Activity) {
         this.displayDialog(var1);
      } else {
         this.displayToast("Downloading image to Picture gallery...");
         this.downloadImage(var1);
      }
   }

   protected final void displayVideo(String var1) {
      InneractiveRichMediaVideoPlayerActivity.a(this.getContext(), var1);
   }

   protected final void expand(String var1, int var2, int var3, boolean var4, boolean var5) {
      if(this.mExpandMode != IAmraidWebView$ExpandMode.DISABLED && this.mViewState == IAbaseWebView$IAviewState.b) {
         if(var1 != null && !URLUtil.isValidUrl(var1)) {
            this.getView().fireErrorEvent(IAmraidActionFactory$MraidJavascriptCommand.b, "URL passed to expand() was invalid.");
            return;
         }

         this.mRootView = (FrameLayout)this.getView().getRootView().findViewById(16908290);
         this.useCustomClose(var4);
         this.setOrientationLockEnabled(var5);
         this.swapViewWithPlaceholderView();
         this.mAdHeight = var3;
         this.mAdWidth = var2;
         IAmraidWebView var6 = this.getView();
         if(var1 != null) {
            this.mSecondExpandView = Y.createInstance(this.getContext(), this.getView().getAdConfig(), IAmraidWebView$ExpandMode.DISABLED, IAmraidWebView$NativeCloseButtonMode.AD_CONTROLLED, IAmraidWebView$MraidPlacementType.INLINE);
            this.mSecondExpandView.setListener(new at() {
               public final void onClose(IAbaseWebView var1, IAbaseWebView$IAviewState var2) {
                  IAmraidWebViewController.this.close();
               }
            });
            this.mSecondExpandView.loadUrl(var1);
            var6 = this.mSecondExpandView;
         }

         this.expandLayouts(var6, (int)((float)var2 * this.mDensity), (int)((float)var3 * this.mDensity));
         an.a((View)this.mExpandLayout);
         this.mRootView.addView(this.mExpandLayout, new LayoutParams(-2, -2));
         if(var6 != null && !var6.hasFocus()) {
            var6.requestFocus();
         }

         if(this.mNativeCloseButtonMode == IAmraidWebView$NativeCloseButtonMode.ALWAYS_VISIBLE || !this.mAdWantsCustomCloseButton && this.mNativeCloseButtonMode != IAmraidWebView$NativeCloseButtonMode.ALWAYS_HIDDEN) {
            this.setNativeCloseButtonEnabled(true);
         }

         this.mViewState = IAbaseWebView$IAviewState.c;
         this.getView().fireChangeEventForAsset(com.inneractive.api.ads.sdk.V.a(this.mViewState));
         if(this.mAdWidth != -1 && this.mAdHeight != -1) {
            this.getView().fireChangeEventForAsset(Q.a(this.mAdWidth, this.mAdHeight));
         }

         if(this.getView().getListener() != null) {
            this.getView().getListener().onExpand(this.getView());
            return;
         }
      }

   }

   final FrameLayout generateAdContainerLayout() {
      return new FrameLayout(this.getContext());
   }

   final RelativeLayout generateExpandLayout() {
      return new RelativeLayout(this.getContext());
   }

   final FrameLayout generatePlaceholderView() {
      return new FrameLayout(this.getContext());
   }

   protected final void getCurrentPosition() {
      this.getView().fireErrorEvent(IAmraidActionFactory$MraidJavascriptCommand.k, "Unsupported action getCurrentPosition");
   }

   protected final void getDefaultPosition() {
      this.getView().fireErrorEvent(IAmraidActionFactory$MraidJavascriptCommand.l, "Unsupported action getDefaultPosition");
   }

   protected final void getMaxSize() {
      this.getView().fireChangeEventForAsset(com.inneractive.api.ads.sdk.S.a(this.mMaxWidth, this.mMaxHeight));
   }

   protected final void getResizeProperties() {
   }

   protected final void getScreenSize() {
      this.getView().fireChangeEventForAsset(com.inneractive.api.ads.sdk.U.a(this.mScreenWidth, this.mScreenHeight));
   }

   public final IAmraidWebView getView() {
      return this.mMraidView;
   }

   protected final void initializeJavaScriptState() {
      ArrayList var1 = new ArrayList();
      var1.add(com.inneractive.api.ads.sdk.U.a(this.mScreenWidth, this.mScreenHeight));
      var1.add(com.inneractive.api.ads.sdk.S.a(this.mMaxWidth, this.mMaxHeight));
      this.getView().fireChangeEventForAssets(var1);
      this.mViewState = IAbaseWebView$IAviewState.b;
      this.getView().fireChangeEventForAsset(com.inneractive.api.ads.sdk.V.a(this.mViewState));
      this.initializeSupportedFunctionsAssets();
   }

   protected final void initializeSupportedFunctionsAssets() {
      Context var1 = this.getContext();
      IAmraidWebView var2 = this.getView();
      W var3 = new W();
      Intent var4 = new Intent("android.intent.action.DIAL");
      var4.setData(Uri.parse("tel:"));
      var3 = var3.b(com.inneractive.api.ads.sdk.a.a(var1, var4));
      var4 = new Intent("android.intent.action.VIEW");
      var4.setData(Uri.parse("sms:"));
      var2.fireChangeEventForAsset(var3.a(com.inneractive.api.ads.sdk.a.a(var1, var4)).c(com.inneractive.api.ads.sdk.a.k(var1)).e(com.inneractive.api.ads.sdk.a.a(var1, new Intent(var1, InneractiveRichMediaVideoPlayerActivity.class))).d(com.inneractive.api.ads.sdk.a.j(var1)));
   }

   protected final boolean isExpanded() {
      return this.mViewState == IAbaseWebView$IAviewState.c;
   }

   protected final void resize(int var1, int var2, int var3, int var4, boolean var5, String var6) {
      byte var8 = 0;
      this.mRootView = (FrameLayout)this.getView().getRootView().findViewById(16908290);
      if(this.mExpandMode != IAmraidWebView$ExpandMode.DISABLED) {
         if(this.mViewState != IAbaseWebView$IAviewState.b && this.mViewState != IAbaseWebView$IAviewState.d) {
            this.getView().fireErrorEvent(IAmraidActionFactory$MraidJavascriptCommand.e, "Ad can be resized only if it\'s state is default or resized.");
            return;
         }

         if(var1 < 0 && var2 < 0) {
            this.getView().fireErrorEvent(IAmraidActionFactory$MraidJavascriptCommand.e, "Creative size passed to resize() was invalid.");
            return;
         }

         this.useCustomClose(false);
         if(this.mNativeCloseButtonMode == IAmraidWebView$NativeCloseButtonMode.ALWAYS_VISIBLE || !this.mAdWantsCustomCloseButton && this.mNativeCloseButtonMode != IAmraidWebView$NativeCloseButtonMode.ALWAYS_HIDDEN) {
            this.setNativeCloseButtonEnabled(true);
         }

         this.setOrientationLockEnabled(false);
         this.mAdHeight = var2;
         this.mAdWidth = var1;
         this.resizedContentView = this.getView();
         if(!var5) {
            int var7 = var3 + var1 - this.mScreenWidth;
            if(var7 > 0) {
               var7 = var3 - var7;
            } else {
               var7 = var3;
            }

            var3 = var7;
            if(var7 < 0) {
               var3 = 0;
            }

            int var9 = var4 + var2 - this.mScreenHeight;
            var7 = var4;
            if(var9 > 0) {
               var7 = var4 - var9;
            }

            if(var7 < 0) {
               var4 = var8;
            } else {
               var4 = var7;
            }
         }

         FrameLayout.LayoutParams var10 = new FrameLayout.LayoutParams(an.b(this.getContext(), var1), an.b(this.getContext(), var2));
         var10.leftMargin = var3;
         var10.topMargin = var4;
         if(var3 == 0 && var4 == 0) {
            var10.gravity = 17;
         }

         this.resizedContentView.setLayoutParams(var10);
         if(this.mViewState != IAbaseWebView$IAviewState.d) {
            this.mViewState = IAbaseWebView$IAviewState.d;
            this.getView().fireChangeEventForAsset(com.inneractive.api.ads.sdk.V.a(this.mViewState));
            if(this.mAdWidth != -1 && this.mAdHeight != -1) {
               this.getView().fireChangeEventForAsset(Q.a(this.mAdWidth, this.mAdHeight));
            }
         }

         if(this.getView().getListener() != null) {
            this.getView().getListener().onResize(this.getView());
            return;
         }
      }

   }

   protected final void setNativeCloseButtonEnabled(boolean var1) {
      if(this.mRootView != null) {
         if(var1) {
            int var2 = an.b(this.getContext(), 35);
            FrameLayout.LayoutParams var3 = new FrameLayout.LayoutParams(var2, var2, 5);
            var3.rightMargin = an.b(this.getContext(), 10);
            var3.topMargin = an.b(this.getContext(), 10);
            if(this.mCloseButton == null) {
               this.mCloseButton = new r(this.getContext(), var2, true);
               this.mCloseButton.setOnClickListener(new View.OnClickListener() {
                  public final void onClick(View var1) {
                     IAmraidWebViewController.this.close();
                  }
               });
            }

            an.a((View)this.mCloseButton);
            this.mAdContainerLayout.addView(this.mCloseButton, var3);
         } else {
            this.mAdContainerLayout.removeView(this.mCloseButton);
         }

         IAmraidWebView var4 = this.getView();
         if(var4.getOnCloseButtonStateChangeListener() != null) {
            var4.getOnCloseButtonStateChangeListener().onCloseButtonStateChange(var4, var1);
            return;
         }
      }

   }

   protected final void setOrientationProperties(boolean var1, String var2) {
      this.setOrientationLockEnabled(var1);
      if("protrait".equals(var2)) {
         this.forceOrientation = IAmraidWebViewController$ForceOrientationType.PORTRAIT;
      } else if("landscape".equals(var2)) {
         this.forceOrientation = IAmraidWebViewController$ForceOrientationType.LANDSCAPE;
      } else {
         this.forceOrientation = IAmraidWebViewController$ForceOrientationType.NONE;
      }

      this.setOrientationLock(this.forceOrientation);
   }

   protected final void setResizeProperties() {
   }

   protected final void useCustomClose(boolean var1) {
      this.mAdWantsCustomCloseButton = var1;
      IAmraidWebView var2 = this.getView();
      if(!var1) {
         var1 = true;
      } else {
         var1 = false;
      }

      if(var2.getOnCloseButtonStateChangeListener() != null) {
         var2.getOnCloseButtonStateChangeListener().onCloseButtonStateChange(var2, var1);
      }

   }
}
