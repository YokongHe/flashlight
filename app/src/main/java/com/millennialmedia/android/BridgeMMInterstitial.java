package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.millennialmedia.android.AdViewOverlayActivity;
import com.millennialmedia.android.AdViewOverlayView;
import com.millennialmedia.android.MMJSObject;
import com.millennialmedia.android.MMJSResponse;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.MMSDK$Event;
import com.millennialmedia.android.MMWebView;
import com.millennialmedia.android.OverlaySettings;
import com.millennialmedia.android.Utils$IntentUtils;
import java.util.Map;

class BridgeMMInterstitial extends MMJSObject {
   private static final String CLOSE = "close";
   private static final String EXPAND_TO_EXTERNAL_BROWSER = "expandToExternalBrowser";
   private static final String EXPAND_WITH_PROPERTIES = "expandWithProperties";
   private static final String OPEN = "open";
   private static final String SET_ORIENTATION = "setOrientation";
   private static final String TAG = BridgeMMInterstitial.class.getName();
   private static final String USE_CUSTOM_CLOSE = "useCustomClose";

   private Intent getExpandExtrasIntent(String var1, OverlaySettings var2) {
      Intent var3 = new Intent();
      if(var1 != null) {
         var3.setData(Uri.parse(var1));
      }

      var3.putExtra("settings", var2);
      var3.putExtra("internalId", var2.creatorAdImplId);
      return var3;
   }

   private boolean isForcingOrientation(MMJSResponse var1) {
      if(var1.result == 1 && var1.response instanceof String) {
         String var2 = (String)var1.response;
         return var2.contains("portrait") || var2.contains("landscape");
      } else {
         return false;
      }
   }

   private MMJSResponse setAllowOrientationChange(Map var1) {
      String var3 = (String)var1.get("allowOrientationChange");
      if(var3 != null) {
         AdViewOverlayActivity var2 = this.getBaseActivity();
         if(var2 != null) {
            var2.setAllowOrientationChange(Boolean.parseBoolean(var3));
            return MMJSResponse.responseWithSuccess();
         }
      }

      return null;
   }

   private MMJSResponse setForceOrientation(Map var1) {
      String var3 = (String)var1.get("forceOrientation");
      AdViewOverlayActivity var2 = this.getBaseActivity();
      if(var2 != null) {
         if(!"none".equals(var3)) {
            if("portrait".equals(var3)) {
               var2.setRequestedOrientationPortrait();
               return MMJSResponse.responseWithSuccess("portrait");
            }

            if("landscape".equals(var3)) {
               var2.setRequestedOrientationLandscape();
               return MMJSResponse.responseWithSuccess("landscape");
            }
         } else if("none".equals(var3)) {
            var2.setAllowOrientationChange(true);
            return MMJSResponse.responseWithSuccess("none");
         }
      }

      return null;
   }

   public MMJSResponse close(Map var1) {
      MMWebView var2 = (MMWebView)this.mmWebViewRef.get();
      if(var2 != null) {
         var2.getMMLayout().closeAreaTouched();
         return MMJSResponse.responseWithSuccess();
      } else {
         return null;
      }
   }

   MMJSResponse executeCommand(String var1, Map var2) {
      MMJSResponse var3 = null;
      if("close".equals(var1)) {
         var3 = this.close(var2);
      } else {
         if("expandToExternalBrowser".equals(var1)) {
            return this.expandToExternalBrowser(var2);
         }

         if("expandWithProperties".equals(var1)) {
            return this.expandWithProperties(var2);
         }

         if("open".equals(var1)) {
            return this.open(var2);
         }

         if("setOrientation".equals(var1)) {
            return this.setOrientation(var2);
         }

         if("useCustomClose".equals(var1)) {
            return this.useCustomClose(var2);
         }
      }

      return var3;
   }

   public MMJSResponse expandToExternalBrowser(Map var1) {
      return this.open(var1);
   }

   public MMJSResponse expandWithProperties(Map var1) {
      String var2 = (String)var1.get("PROPERTY_BANNER_TYPE");
      if(var2 != null && !Boolean.parseBoolean(var2)) {
         return MMJSResponse.responseWithError("Cannot expand a non banner ad");
      } else {
         String var3 = (String)var1.get("url");
         String var10 = (String)var1.get("transparent");
         String var11 = (String)var1.get("useCustomClose");
         String var12 = (String)var1.get("transition");
         var2 = (String)var1.get("orientation");
         String var6 = (String)var1.get("transitionDuration");
         String var7 = (String)var1.get("height");
         String var8 = (String)var1.get("width");
         String var9 = (String)var1.get("modal");
         String var13 = (String)var1.get("PROPERTY_EXPANDING");
         String var14 = (String)var1.get("allowOrientationChange");
         Context var4 = (Context)this.contextRef.get();
         if(var4 != null) {
            OverlaySettings var5 = new OverlaySettings();
            if(var3 != null) {
               var5.urlToLoad = var3;
            }

            if(var13 != null) {
               var5.creatorAdImplId = (long)((int)Float.parseFloat(var13));
            }

            if(var10 != null) {
               var5.setIsTransparent(Boolean.parseBoolean(var10));
            }

            if(var11 != null) {
               var5.setUseCustomClose(Boolean.parseBoolean(var11));
            }

            if(var12 != null) {
               var5.setTransition(var12);
            }

            if(var14 != null) {
               var5.allowOrientationChange = Boolean.parseBoolean(var14);
            }

            if(var2 == null) {
               var2 = (String)var1.get("forceOrientation");
            }

            if(var2 != null) {
               var5.orientation = var2;
            }

            if(var7 != null) {
               var5.height = (int)Float.parseFloat(var7);
            }

            if(var8 != null) {
               var5.width = (int)Float.parseFloat(var8);
            }

            if(var9 != null) {
               var5.modal = Boolean.parseBoolean(var9);
            }

            if(var6 != null) {
               try {
                  var5.setTransitionDurationInMillis(Long.parseLong(var6) * 1000L);
               } catch (Exception var15) {
                  MMLog.e(TAG, "Problem converting transitionDuration", var15);
               }
            }

            Utils$IntentUtils.startAdViewOverlayActivity(var4, this.getExpandExtrasIntent(var3, var5));
            MMSDK$Event.overlayOpenedBroadCast(var4, this.getAdImplId((String)var1.get("PROPERTY_EXPANDING")));
            return MMJSResponse.responseWithSuccess();
         } else {
            return null;
         }
      }
   }

   public MMJSResponse open(Map var1) {
      String var3 = (String)var1.get("url");
      Context var2 = (Context)this.contextRef.get();
      if(var3 != null && var2 != null) {
         Intent var4 = new Intent("android.intent.action.VIEW", Uri.parse(var3));
         MMSDK$Event.intentStarted(var2, "browser", this.getAdImplId((String)var1.get("PROPERTY_EXPANDING")));
         Utils$IntentUtils.startActivity(var2, var4);
         return MMJSResponse.responseWithSuccess();
      } else {
         return null;
      }
   }

   public MMJSResponse setOrientation(Map var1) {
      MMJSResponse var3 = this.setForceOrientation(var1);
      MMJSResponse var2;
      if(var3 != null) {
         var2 = var3;
         if(this.isForcingOrientation(var3)) {
            return var2;
         }
      }

      var2 = this.setAllowOrientationChange(var1);
      return var2;
   }

   public MMJSResponse useCustomClose(Map var1) {
      MMWebView var2 = (MMWebView)this.mmWebViewRef.get();
      String var3 = (String)var1.get("useCustomClose");
      if(var3 != null && var2 != null) {
         AdViewOverlayView var4 = var2.getAdViewOverlayView();
         if(var4 != null) {
            var4.setUseCustomClose(Boolean.parseBoolean(var3));
            return MMJSResponse.responseWithSuccess();
         }
      }

      return null;
   }
}
