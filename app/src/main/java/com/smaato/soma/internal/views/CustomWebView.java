package com.smaato.soma.internal.views;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import android.os.Message;
import android.provider.MediaStore.Images.Media;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.smaato.soma.AdType;
import com.smaato.soma.BaseView;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.ReceivedBannerInterface;
import com.smaato.soma.debug.DebugCategory;
import com.smaato.soma.debug.Debugger;
import com.smaato.soma.debug.LogMessage;
import com.smaato.soma.internal.ReceivedBanner;
import com.smaato.soma.internal.utilities.Controller;
import com.smaato.soma.internal.utilities.Converter;
import com.smaato.soma.internal.views.CustomWebView$AdReportImageView;
import com.smaato.soma.internal.views.CustomWebView$OnSwipeTouchListener;
import com.smaato.soma.interstitial.InterstitialBannerView;
import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

public class CustomWebView extends WebView {
   private static boolean isButtonAttached = false;
   private static String lastKnownImageUrl = "";
   private static int swipeNumber = 0;
   private ReceivedBannerInterface banner;
   private BaseView baseView;
   private GestureDetector gestureDetector;
   private boolean isSwiping = false;
   private long lastSwipe = 0L;
   private CustomWebView$AdReportImageView reportAdImageView;
   private boolean userClicked = false;

   public CustomWebView(final Context var1, ReceivedBannerInterface var2, final BaseView var3) {
      super(var1);
      this.baseView = var3;
      this.banner = var2;
      this.setId(670);
      if(isButtonAttached) {
         this.addImageView();
      }

      this.setOnTouchListener(new CustomWebView$OnSwipeTouchListener(this, var1) {
         private void checkSwipes() {
            (new CrashReportTemplate() {
               public Void process() {
                  if(CustomWebView.swipeNumber >= 10 && !CustomWebView.isButtonAttached) {
                     CustomWebView.this.addImageView();
                     CustomWebView.this.isSwiping = false;
                  } else if(CustomWebView.swipeNumber <= 0 && CustomWebView.isButtonAttached) {
                     CustomWebView.isButtonAttached = false;
                     ((ViewGroup)CustomWebView.this.reportAdImageView.getParent()).removeView(CustomWebView.this.reportAdImageView);
                     CustomWebView.this.isSwiping = false;
                  }

                  CustomWebView.this.lastSwipe = System.currentTimeMillis();
                  return null;
               }
            }).execute();
         }

         public void onSwipeLeft() {
            if(CustomWebView.isButtonAttached) {
               CustomWebView.swipeNumber = CustomWebView.swipeNumber - 1;
            } else {
               CustomWebView.swipeNumber = CustomWebView.swipeNumber + 1;
            }

            this.checkSwipes();
         }

         public void onSwipeRight() {
            if(CustomWebView.isButtonAttached) {
               CustomWebView.swipeNumber = CustomWebView.swipeNumber - 1;
            } else {
               CustomWebView.swipeNumber = CustomWebView.swipeNumber + 1;
            }

            this.checkSwipes();
         }

         public boolean onTouch(final View var1, final MotionEvent var2) {
            CustomWebView.this.gestureDetector.onTouchEvent(var2);
            return ((Boolean)(new CrashReportTemplate() {
               private boolean wasSwiping() {
                  return CustomWebView.this.lastSwipe != 0L && System.currentTimeMillis() - CustomWebView.this.lastSwipe <= 2000L;
               }

               public Boolean process() {
                  if(var2.getAction() == 1 && !this.wasSwiping()) {
                     if(Controller.getInstance().isClickInsideView(var1, var2.getX(), var2.getY())) {
                        ((CustomWebView)var1).setUserClicked(true);
                        Message var1x = var3.getBannerAnimatorHandler().obtainMessage(101);
                        var3.getBannerAnimatorHandler().sendMessage(var1x);
                     } else {
                        Debugger.showLog(new LogMessage("SOMA", "Click was outside the banner view, skipping expand ...", 1, DebugCategory.WARNING));
                     }
                  }

                  return var2.getAction() == 2?Boolean.valueOf(true):Boolean.valueOf(false);
               }
            }).execute()).booleanValue();
         }
      });
   }

   // $FF: synthetic method
   static void access$1(CustomWebView var0, GestureDetector var1) {
      var0.gestureDetector = var1;
   }

   private void addImageView() {
      (new CrashReportTemplate() {
         public Void process() {
            Context var2 = CustomWebView.this.getContext();
            int var1 = Converter.getInstance().pixelToDp(var2, 20);
            if(CustomWebView.this.reportAdImageView == null) {
               CustomWebView.this.reportAdImageView = new CustomWebView$AdReportImageView(CustomWebView.this, var2);
            }

            CustomWebView.this.reportAdImageView.setId(689);
            RelativeLayout var4 = new RelativeLayout(var2);
            LayoutParams var3 = new LayoutParams(var1, var1);
            var3.addRule(12);
            var3.addRule(11);
            var4.addView(CustomWebView.this.reportAdImageView, var3);
            CustomWebView.this.reportAdImageView.setOnClickListener(new OnClickListener() {
               public void onClick(View var1) {
                  CustomWebView.this.showConfirmationDialog(var1.getContext(), CustomWebView.this.banner);
               }
            });
            CustomWebView.this.addView(var4);
            CustomWebView.isButtonAttached = true;
            return null;
         }
      }).execute();
   }

   public static String getLastKnownImageUrl() {
      return lastKnownImageUrl;
   }

   public static boolean isButtonAttached() {
      return isButtonAttached;
   }

   public static void setButtonAttached(boolean var0) {
      isButtonAttached = var0;
   }

   public static void setLastKnownImageUrl(String var0) {
      lastKnownImageUrl = var0;
   }

   protected Uri getScreenShotUri() {
      return (Uri)(new CrashReportTemplate() {
         public Uri process() {
            int var1 = (int)(CustomWebView.this.getScale() * (float)CustomWebView.this.getContentHeight());
            Bitmap var2 = Bitmap.createBitmap(CustomWebView.this.getWidth(), var1, Config.ARGB_8888);
            Canvas var3 = new Canvas(var2);
            CustomWebView.this.draw(var3);
            return Uri.parse(Media.insertImage(CustomWebView.this.getContext().getContentResolver(), var2, "screenshot" + System.currentTimeMillis(), (String)null));
         }
      }).execute();
   }

   public boolean isUserClicked() {
      return this.userClicked;
   }

   public void setUserClicked(boolean var1) {
      this.userClicked = var1;
   }

   protected void showCauseDialog(final Context var1, final ReceivedBannerInterface var2, final String var3) {
      (new CrashReportTemplate() {
         // $FF: synthetic field
         private static int[] $SWITCH_TABLE$com$smaato$soma$AdType;

         // $FF: synthetic method
         static int[] $SWITCH_TABLE$com$smaato$soma$AdType() {
            int[] var0 = $SWITCH_TABLE$com$smaato$soma$AdType;
            if(var0 != null) {
               return var0;
            } else {
               var0 = new int[AdType.values().length];

               try {
                  var0[AdType.ALL.ordinal()] = 1;
               } catch (NoSuchFieldError var6) {
                  ;
               }

               try {
                  var0[AdType.IMAGE.ordinal()] = 2;
               } catch (NoSuchFieldError var5) {
                  ;
               }

               try {
                  var0[AdType.RICHMEDIA.ordinal()] = 5;
               } catch (NoSuchFieldError var4) {
                  ;
               }

               try {
                  var0[AdType.TEXT.ordinal()] = 3;
               } catch (NoSuchFieldError var3x) {
                  ;
               }

               try {
                  var0[AdType.VIDEO.ordinal()] = 4;
               } catch (NoSuchFieldError var2x) {
                  ;
               }

               $SWITCH_TABLE$com$smaato$soma$AdType = var0;
               return var0;
            }
         }

         public Void process() {
            Intent var2x = new Intent("android.intent.action.SEND");
            var2x.setFlags(268435456);
            var2x.putExtra("android.intent.extra.EMAIL", new String[]{"adqualitysupport@smaato.com"});
            var2x.putExtra("android.intent.extra.SUBJECT", "Ad Report");
            DateFormat var1x = DateFormat.getTimeInstance();
            var1x.setTimeZone(TimeZone.getTimeZone("gmt"));
            String var3x = var1x.format(new Date());
            var3x = "Publisher Id : " + CustomWebView.this.baseView.getAdSettings().getPublisherId() + "\nAdSpace Id : " + CustomWebView.this.baseView.getAdSettings().getAdspaceId() + "\nSession Id : " + ((ReceivedBanner)var2).getSessionId() + "\nTime : " + var3x + "\n" + "I\'m reporting this ad for the following reason: @REASON. Thanks for taking care. \nPlease find all info below : \n".replace("@REASON", var3);
            switch($SWITCH_TABLE$com$smaato$soma$AdType()[var2.getAdType().ordinal()]) {
            case 2:
               if(CustomWebView.lastKnownImageUrl != null && CustomWebView.lastKnownImageUrl.length() > 0) {
                  var3x = var3x + "Image URL : " + CustomWebView.lastKnownImageUrl;
                  CustomWebView.lastKnownImageUrl = "";
               } else {
                  var3x = var3x + "Image URL : " + var2.getImageUrl();
               }
               break;
            case 3:
            case 4:
            default:
               var3x = var3x + "Text Ad Click Url : " + var2.getClickUrl();
               break;
            case 5:
               var3x = var3x + "Rich Media Tag : " + var2.getRichMediaData();
            }

            var2x.putExtra("android.intent.extra.TEXT", var3x);
            var2x.putExtra("android.intent.extra.STREAM", CustomWebView.this.getScreenShotUri());
            var2x.setType("plain/text");
            var1.startActivity(var2x);
            return null;
         }
      }).execute();
   }

   protected void showConfirmationDialog(final Context var1, final ReceivedBannerInterface var2) {
      (new CrashReportTemplate() {
         public Void process() {
            Builder var1x;
            if(CustomWebView.this.baseView instanceof InterstitialBannerView) {
               var1x = new Builder(((InterstitialBannerView)CustomWebView.this.baseView).getActivityContext());
            } else {
               var1x = new Builder(var1);
            }

            var1x.setMessage("Do you want to inform Smaato about this ad ?\nAfter clicking on yes, and choosing the cause of the issue, an email will be automatically generated. The content of the email can be modified before sending it to the ad quality team.");
            var1x.setCancelable(true);
            var1x.setPositiveButton("Yes", new android.content.DialogInterface.OnClickListener() {
               public void onClick(DialogInterface var1x, int var2x) {
                  (new CrashReportTemplate() {
                     public Void process() {
                        Builder var1x;
                        if(CustomWebView.this.baseView instanceof InterstitialBannerView) {
                           var1x = new Builder(((InterstitialBannerView)CustomWebView.this.baseView).getActivityContext());
                        } else {
                           var1x = new Builder(var1);
                        }

                        var1x.setTitle("Reason");
                        RadioGroup var2x = new RadioGroup(var1);
                        final RadioButton var3 = new RadioButton(var1);
                        var3.setText("Contains provocative or suggestive imagery");
                        final RadioButton var4 = new RadioButton(var1);
                        var4.setText("Is misleading (e.g. simulates a dialog or app component)");
                        final RadioButton var5 = new RadioButton(var1);
                        var5.setText("Is shaky, flashing or flickering");
                        final RadioButton var6 = new RadioButton(var1);
                        var6.setText("Contains inappropriate content");
                        final RadioButton var7 = new RadioButton(var1);
                        var7.setText("Automatically triggers unwanted behavior (redirects/downloads)");
                        final RadioButton var8 = new RadioButton(var1);
                        var8.setText("Automatically plays audio or video");
                        var2x.addView(var3);
                        var2x.addView(var4);
                        var2x.addView(var5);
                        var2x.addView(var6);
                        var2x.addView(var7);
                        var2x.addView(var8);
                        var1x.setView(var2x);
                        var1x.setPositiveButton("Ok", new android.content.DialogInterface.OnClickListener() {
                           public void onClick(DialogInterface var1x, int var2x) {
                              (new CrashReportTemplate() {
                                 public Void process() {
                                    String var1x;
                                    if(var3.isChecked()) {
                                       var1x = "Contains provocative or suggestive imagery";
                                    } else if(var4.isChecked()) {
                                       var1x = "Is misleading (e.g. simulates a dialog or app component)";
                                    } else if(var5.isChecked()) {
                                       var1x = "Is shaky, flashing or flickering";
                                    } else if(var6.isChecked()) {
                                       var1x = "Contains inappropriate content";
                                    } else if(var7.isChecked()) {
                                       var1x = "Automatically triggers unwanted behavior (redirects/downloads)";
                                    } else if(var8.isChecked()) {
                                       var1x = "Automatically plays audio or video";
                                    } else {
                                       var1x = "Not specified";
                                    }

                                    CustomWebView.this.showCauseDialog(var1, var2, var1x);
                                    return null;
                                 }
                              }).execute();
                           }
                        });
                        var1x.setNegativeButton("Cancel", new android.content.DialogInterface.OnClickListener() {
                           public void onClick(DialogInterface var1x, int var2x) {
                           }
                        });
                        var1x.show();
                        return null;
                     }
                  }).execute();
               }
            });
            var1x.setNegativeButton("No", new android.content.DialogInterface.OnClickListener() {
               public void onClick(DialogInterface var1x, int var2x) {
               }
            });
            var1x.create().show();
            return null;
         }
      }).execute();
   }
}
