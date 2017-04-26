package org.nexage.sourcekit.mraid;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import java.util.ArrayList;
import org.nexage.sourcekit.mraid.Assets;

public class MRAIDBrowser extends Activity {
   public static final String MANAGER_EXTRA = "extra_manager";
   private static final String TAG = "MraidBrowser";
   public static final String URL_EXTRA = "extra_url";
   private ImageButton backButton;
   private ImageButton closeButton;
   private ImageButton forwardButton;
   private ImageButton refreshButton;
   private RelativeLayout rootLayout;
   private ArrayList supportedNativeFeatures;
   private WebView webView;

   private void createUi() {
      DisplayMetrics var5 = this.getResources().getDisplayMetrics();
      int var3 = var5.widthPixels;
      int var2 = var5.heightPixels;
      float var1 = var5.density;
      int var4 = var5.densityDpi;
      String var7 = "screen " + var3 + "x" + var2 + ", density=" + var1 + ", densityDpi=" + var1 + " (";
      switch(var4) {
      case 120:
         var7 = var7 + "DENSITY_LOW)";
         break;
      case 160:
         var7 = var7 + "DENSITY_MEDIUM)";
         break;
      case 240:
         var7 = var7 + "DENSITY_HIGH)";
         break;
      case 320:
         var7 = var7 + "DENSITY_XHIGH)";
      }

      Log.d("MraidBrowser", var7);
      this.rootLayout = new RelativeLayout(this);
      LayoutParams var8 = new LayoutParams(-1, -1);
      this.rootLayout.setLayoutParams(var8);
      this.rootLayout.setPadding(0, 0, 0, 0);
      this.rootLayout.setBackgroundColor(-65536);
      LinearLayout var9 = new LinearLayout(this);
      LayoutParams var6 = new LayoutParams(-1, -2);
      var6.addRule(12);
      var9.setLayoutParams(var6);
      var9.setOrientation(0);
      var9.setPadding(0, 0, 0, 0);
      var9.setBackgroundDrawable(Assets.getDrawableFromBase64(this.getResources(), "iVBORw0KGgoAAAANSUhEUgAAAAEAAAAsCAIAAAArRUU2AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAEFJREFUeNpicPP0Zvr3/z/T/3//gDQQg+i//5j+gum/QBqIQXwg+x+YjckH6fkL0/f3NwMPHz8jKxsbAw0AQIABAGYHPKslk98oAAAAAElFTkSuQmCC"));
      var9.setId(1);
      var3 >>>= 2;
      var4 = Math.min(var3 >>> 1, var2 / 10);
      Log.d("MraidBrowser", "button size " + var3 + "x" + var4 + " min(" + var3 / 2 + "," + var2 / 10 + ")");
      var2 = var4 >>> 3;
      Log.d("MraidBrowser", "padding " + var2);
      this.backButton = this.createButton(var3, var4, var2, "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");
      this.forwardButton = this.createButton(var3, var4, var2, "iVBORw0KGgoAAAANSUhEUgAAABEAAAAUCAYAAABroNZJAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAqNJREFUeNqUlEtrE1EUx8+8EjNT27zTaMw0k6RJGpu+VqIi4k7rQtyKIn6FrEraRhTET+AnENxUXLpWcFfRhaCbCpY0Lc3DpE07c+dxPTckojTG5sAfhnvP/fE/99wz3IV4/Fl1Z+eDZVlVAKigmihjwuejcIpoNZsg+AOBlz6//2E4EonWazUGElC2oesWip7xeIZCMAeEUDhcpBw3LkqubDqdvs1xQNqt1iHucygGshBEh0LQQREBY2fHx8F2HLfkcl1OJKaut1vtCiEGy6M9V/YgWBcSDIWKHM+PyYoMLpcbJEkCYpoT/mDg1rloNF+tVrcwV0Q5PZjzZ4l/QdiGIAjAoxiI43jOtKyYOqXeVRRFrmPgGb5Xot2/rxMQnhe6dA4vRhDFLsymjkApzGta8iYhpNnpdAgrsQ9j3wMh/cB1EAURy3QBsSyPMqbcUFX1UrPRqJimyUAOgw2F9GzhOsLQFXNHiBmMRCeXg8FgfG939wtmtLnszMwuJ4gRr98Hoij993E5jgPoAvSjI1A8ngPT0B+JMGIwV263G2RZhulU8lNle/vdyBAWc4XCdijgv7deKr1nFzsSJB6L6ZnMdHFtZeVFbrbgxBMa/Pi+BaeCeL1eZ3529tWT8vr9iwsLdiKVhka9BqZBuvtDIRJ2Y3Fh/jM4dBkBlVQmSxv7NTAMHWzbBkrpcEg+l9ufjIQflFdX32byeRpTVfiJY29Z5u/D/TgBOR+Nkmw287xcKj2eKczZqqZBs97AthKg2N5B48zjvLOnCzJO6LWrV95g330bG6/XtPS0zeo+aLeBoH3nH4CuE5wTktS0r1pSu/O0XP6WzuZop3OIg2Vg3dYJ64OCW1xamvy4ubmXwsOGfgz68TFY+CIdeqq/Y/f3+EuAAQARwzy3ZhCNHQAAAABJRU5ErkJggg==");
      this.refreshButton = this.createButton(var3, var4, var2, "iVBORw0KGgoAAAANSUhEUgAAABMAAAAUCAYAAABvVQZ0AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAA2NJREFUeNqMVF1Ik1EYPm7TpsIca84pGs6VrboYaeRPpFgXKUzBH4S8sLoIMVCpRERCAgfSZXpR2ZVJCEIgaIQm+MdCIkXRTTTnQG0qorCFm21zp+f9+IQ5NHvh4eP7vnOe877Ped5Xyv4dEYAMSK2rq/tkt9tlXq83Cu9BwC8+zyQ4B5wHLgAG4M7IyAgfHR31FhcXv8F7EXAZUADSo43SMCLKQimS0GKDTqfLys7OvlldXZ2Vnp4uy8nJuZGWlmacnp52ejyeANZ4AB/AQ4kigSQgT6/XPzebzd8pk4WFBb6+vs6xkVP4/X6+s7PDx8bGPJWVlWasTxGTOJZRInC3oaHh88zMjLDh4OCA+3w+4RkIBPhRHB4e8u3tbd7f38+rqqpM2CcJ1YhKu4Vsvq2urnKIzN1uN3c4HHxqaso1Pj7+Y3d3VyAicqfTyaHhenNzc1Eo0VF5F2traz+srKwIRFtbW3xoaMjW1tZ2X9Q12WazcZfLxefn53lXV9fbiooKjZjIsVAkJSXdIw1IFyqvt7d3pLy8PCFksXJgYIAPDg5aGxsbs8OzCY2E+vr692tra4LIFovld15eXmrYqbKmpiZzuNAnRXJ3d7eVStjc3OQo7ZXos7OC5ImjZAA1EE0nSbRarUYulzNoxeCfb/gW+A+yGEAvuoC8ZieyoFKpVEulUgYPMVy3Qyzn8IwuiYWNXl5FQB4/9r0gIf+gxG34iEVFRbH8/HwSOPakmwovMTMz81JZWZm+oKDAkJiYGENk3o2NjSVYgsXFxbHc3NxCMXX5KYRkFRU2XzEajQZUxSQSCdvb2/tJZAfLy8uDyI4pFApmMpkKNRpNJr7rxEaWiaS0NhrQAuk1NTVPoDWDiRmS2RweHrYK9aO0FPjMvb+/z3EC7+vr+6VWqx/j321xauhEsa8DJjR9NxIQDI6xxFtbW58emx4tLS0PFhcXhT4kwomJCS/67qNKparH/4fAo4yMDHNHR8c8EdDB1J8w+NRJVors7Ox8t7S0JCwkIH1utVr57Owsn5ub49RudBAdSC2HG7SVlJRoT7ssaXt7e+3k5KSLiIiQJgRFMBgUmpzIqE97enq+lJaWhrbciYwRKE+NW32GIVgcHx9/TSaTMfAxkLsx2ywge40J8zV8bP8VYACAQuluULZPjQAAAABJRU5ErkJggg==");
      this.closeButton = this.createButton(var3, var4, var2, "iVBORw0KGgoAAAANSUhEUgAAAA4AAAAOCAYAAAAfSC3RAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAg9JREFUeNp8kk1rWkEUhodc5aJUEbVqJQRcqCUgERottIKYQhdZSEh1pcWFSFd2HdzFhfobpOJCFLEbddONEUUQEUSDxi4KtWIq+LGQanOLFqdnJAO3peTAe+98PXPmvDMMQkgE0ikUilcajca2WCx+Q58DbUAYJARpQccmk+l8Op1CE/0inycqlcqdTCZvi8XincViCcHYEUgKYkH7oNfhcLhRKpWw1+v9AH0zMhgMh6lU6utkMsGQDddqNQo/Az0lUCQSaQyHQ7xcLnGn08GBQOCSsdlsKtB7nU7HSqVSJJfLhWaz+UWv15uPx2M2Go1eeDye51qtFgkEAgQwgvEv5Kh7wWDwZb1e/wGBt9stJv9Wq8Wl0+mb0WiEN5vNTiRrIpHI3deN/guv12vMcdyDEA3W5XKdtdvtnwTix3w+x/F4/BOsUZAkfEhI3ctms9ckEz+gJmy32/lu7/0FgRENWhM/VqsV320Ko8egE2o5rYkcj2QiEDWMwFar9QLWHxLwIBaLlfkQaWcymVwoFLL/63alUrlzOBxvGTDkyOl0Xur1+t09QRYEL+Sjz+fzQIZvYrG4qlar3TKZjBWJRLvSYPNHTL/fvzUajTOlUnlKLrdareb8fr+XvtVms/mdwDDvhqxst9v9nM/nzxgyWS6XW7DreDAYDOE+391DNHawRCK5ms1mmkKh8AY0/SPAAEsFgVbY4GziAAAAAElFTkSuQmCC");
      var9.addView(this.backButton);
      var9.addView(this.forwardButton);
      var9.addView(this.refreshButton);
      var9.addView(this.closeButton);
      this.rootLayout.addView(var9);
      this.webView = new WebView(this);
      var6 = new LayoutParams(-1, -1);
      var6.addRule(2, var9.getId());
      this.webView.setLayoutParams(var6);
      this.rootLayout.addView(this.webView);
   }

   private void enableCookies() {
      CookieSyncManager.createInstance(this);
      CookieSyncManager.getInstance().startSync();
   }

   @SuppressLint({"SetJavaScriptEnabled"})
   private void initializeWebView(Intent var1) {
      WebSettings var2 = this.webView.getSettings();
      var2.setJavaScriptEnabled(true);
      var2.setSupportZoom(true);
      var2.setBuiltInZoomControls(true);
      var2.setUseWideViewPort(true);
      this.webView.loadUrl(var1.getStringExtra("extra_url"));
      this.webView.setWebViewClient(new WebViewClient() {
         public void onPageFinished(WebView var1, String var2) {
            super.onPageFinished(var1, var2);
            Drawable var4;
            if(!var1.canGoBack()) {
               var4 = Assets.getDrawableFromBase64(MRAIDBrowser.this.getResources(), "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");
            } else {
               var4 = Assets.getDrawableFromBase64(MRAIDBrowser.this.getResources(), "iVBORw0KGgoAAAANSUhEUgAAABEAAAAUCAYAAABroNZJAAADHmlDQ1BJQ0MgUHJvZmlsZQAAeAGFVN9r01AU/tplnbDhizpnEQk+aJFuZFN0Q5y2a1e6zVrqNrchSJumbVyaxiTtfrAH2YtvOsV38Qc++QcM2YNve5INxhRh+KyIIkz2IrOemzRNJ1MDufe73/nuOSfn5F6g+XFa0xQvDxRVU0/FwvzE5BTf8gFeHEMr/GhNi4YWSiZHQA/Tsnnvs/MOHsZsdO5v36v+Y9WalQwR8BwgvpQ1xCLhWaBpXNR0E+DWie+dMTXCzUxzWKcECR9nOG9jgeGMjSOWZjQ1QJoJwgfFQjpLuEA4mGng8w3YzoEU5CcmqZIuizyrRVIv5WRFsgz28B9zg/JfsKiU6Zut5xCNbZoZTtF8it4fOX1wjOYA1cE/Xxi9QbidcFg246M1fkLNJK4RJr3n7nRpmO1lmpdZKRIlHCS8YlSuM2xp5gsDiZrm0+30UJKwnzS/NDNZ8+PtUJUE6zHF9fZLRvS6vdfbkZMH4zU+pynWf0D+vff1corleZLw67QejdX0W5I6Vtvb5M2mI8PEd1E/A0hCgo4cZCjgkUIMYZpjxKr4TBYZIkqk0ml0VHmyONY7KJOW7RxHeMlfDrheFvVbsrj24Pue3SXXjrwVhcW3o9hR7bWB6bqyE5obf3VhpaNu4Te55ZsbbasLCFH+iuWxSF5lyk+CUdd1NuaQU5f8dQvPMpTuJXYSWAy6rPBe+CpsCk+FF8KXv9TIzt6tEcuAcSw+q55TzcbsJdJM0utkuL+K9ULGGPmQMUNanb4kTZyKOfLaUAsnBneC6+biXC/XB567zF3h+rkIrS5yI47CF/VFfCHwvjO+Pl+3b4hhp9u+02TrozFa67vTkbqisXqUj9sn9j2OqhMZsrG+sX5WCCu0omNqSrN0TwADJW1Ol/MFk+8RhAt8iK4tiY+rYleQTysKb5kMXpcMSa9I2S6wO4/tA7ZT1l3maV9zOfMqcOkb/cPrLjdVBl4ZwNFzLhegM3XkCbB8XizrFdsfPJ63gJE722OtPW1huos+VqvbdC5bHgG7D6vVn8+q1d3n5H8LeKP8BqkjCtbCoV8yAAAACXBIWXMAAAsTAAALEwEAmpwYAAABZGlUWHRYTUw6Y29tLmFkb2JlLnhtcAAAAAAAPHg6eG1wbWV0YSB4bWxuczp4PSJhZG9iZTpuczptZXRhLyIgeDp4bXB0az0iWE1QIENvcmUgNC40LjAiPgogICA8cmRmOlJERiB4bWxuczpyZGY9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkvMDIvMjItcmRmLXN5bnRheC1ucyMiPgogICAgICA8cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0iIgogICAgICAgICAgICB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iPgogICAgICAgICA8eG1wOkNyZWF0b3JUb29sPkFkb2JlIEltYWdlUmVhZHk8L3htcDpDcmVhdG9yVG9vbD4KICAgICAgPC9yZGY6RGVzY3JpcHRpb24+CiAgIDwvcmRmOlJERj4KPC94OnhtcG1ldGE+Chvleg4AAAJISURBVDgRnZPPi1JRFMev43M0tfzxNB2tER1/IKaJv0BURPAHiAhqNrOpaF/bFu1btJlNOCv/htqJShBuRZfRIIErRUhIahOoY99rvpeSltOFL/e+d8753HPuPVewWCzIvkOAAV8xpIKMYrFYp9Vqj5h9AKtg6nsLOoJMNpstbbfbH45Go0//hAAgRJAMug0d6/X6QC6XexwOh12DwYA0m83LnRAEHyBIArHQXZlMZk8kEo8KhULc7/cL8U1arRZhGIb8AVmlfohAJWSATKFQ6EGpVMpHIpGbVquVqNVqMplMCHxhJr8hq2AKlUN6yGQ2m2PFYvFJMpk0Op1OotPpiERCk9scy0wAoHVLIQ10rFKp3Nls9mk+n/d5PB5iNBqJXC7nd95EIBMAbuAnvbI72MUWjUbPsHs6GAweWiwWolAoiFBI99g9uPRPvF7vGQ7tNB6Ps7g6otFoiEgk2h25ZmFwVWYc2HksFgu4XC5iMBiWdXOHtua7c8kolcrLVCr1Hunfw1pynWCOelCr1b5lMpmX7XbbPR6P33KG68zL28H7oQ/oM7IodzqdOK7zjVQqde0Lol3JD7Cu0I0f0I33e73e8+l0+oU3/mWxAeH8AJs7HI5KtVp1DIfDC3xPOdu2eVnONgMCaYlfUeKzer1+EQgEzlmWTW/z3QnhnFewj4Blu91uHhm+Rrk2zo55sbWcNQd+Cdjc5/O9K5fL7n6//2J+Nf9OjWjIH4JfWfO+ey2QlaBSqehms9mrRqMh+y8ItxOFodvlPwFBp5S3HqSzbwAAAABJRU5ErkJggg==");
            }

            MRAIDBrowser.this.backButton.setImageDrawable(var4);
            Drawable var3;
            if(!var1.canGoForward()) {
               var3 = Assets.getDrawableFromBase64(MRAIDBrowser.this.getResources(), "iVBORw0KGgoAAAANSUhEUgAAABEAAAAUCAYAAABroNZJAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAqNJREFUeNqUlEtrE1EUx8+8EjNT27zTaMw0k6RJGpu+VqIi4k7rQtyKIn6FrEraRhTET+AnENxUXLpWcFfRhaCbCpY0Lc3DpE07c+dxPTckojTG5sAfhnvP/fE/99wz3IV4/Fl1Z+eDZVlVAKigmihjwuejcIpoNZsg+AOBlz6//2E4EonWazUGElC2oesWip7xeIZCMAeEUDhcpBw3LkqubDqdvs1xQNqt1iHucygGshBEh0LQQREBY2fHx8F2HLfkcl1OJKaut1vtCiEGy6M9V/YgWBcSDIWKHM+PyYoMLpcbJEkCYpoT/mDg1rloNF+tVrcwV0Q5PZjzZ4l/QdiGIAjAoxiI43jOtKyYOqXeVRRFrmPgGb5Xot2/rxMQnhe6dA4vRhDFLsymjkApzGta8iYhpNnpdAgrsQ9j3wMh/cB1EAURy3QBsSyPMqbcUFX1UrPRqJimyUAOgw2F9GzhOsLQFXNHiBmMRCeXg8FgfG939wtmtLnszMwuJ4gRr98Hoij993E5jgPoAvSjI1A8ngPT0B+JMGIwV263G2RZhulU8lNle/vdyBAWc4XCdijgv7deKr1nFzsSJB6L6ZnMdHFtZeVFbrbgxBMa/Pi+BaeCeL1eZ3529tWT8vr9iwsLdiKVhka9BqZBuvtDIRJ2Y3Fh/jM4dBkBlVQmSxv7NTAMHWzbBkrpcEg+l9ufjIQflFdX32byeRpTVfiJY29Z5u/D/TgBOR+Nkmw287xcKj2eKczZqqZBs97AthKg2N5B48zjvLOnCzJO6LWrV95g330bG6/XtPS0zeo+aLeBoH3nH4CuE5wTktS0r1pSu/O0XP6WzuZop3OIg2Vg3dYJ64OCW1xamvy4ubmXwsOGfgz68TFY+CIdeqq/Y/f3+EuAAQARwzy3ZhCNHQAAAABJRU5ErkJggg==");
            } else {
               var3 = Assets.getDrawableFromBase64(MRAIDBrowser.this.getResources(), "iVBORw0KGgoAAAANSUhEUgAAABEAAAAUCAYAAABroNZJAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAq5JREFUeNqUlN9LmmEUx4++/ihKy6yZGEMjlExdEjgqQmm78ioGu41gu7Ftt+5mBF0Go8sIBvsTtggqGgODboK66aIwNi0lJ7p+2TT89b7Pvo/LaKucHTj4+LzP+bzne855XpnVan0ZiUSSoiimiCgBP4UXfD4fozpsbW2NhP7+/vdDQ0MvFLBkMnmBfQEuHhwclOHMbDbXhOAMCQ6HY8Lr9Tr8fv9ji8Xy6PDw8CKTyUh4LoNzUBkg9l/I4OCg2ePxkNPpfOB2u0cbGhoeQuJZsVjkWbHLrMTbYBVIb2/vhMvlMttsNurs7CSj0Si32+0W7D0BRMthOKuAS5cw6brEvyCQQk1NTdTY2EhtbW3U1dWlxr6rp6dnJJVKldLpdBEx8kuJYrVeNyAcwE0QBGpubqb29nbq7u7WDgwMjABs39/fz+RyOV4rVoXx9a0QbjKZjJRKJWm1WjIYDIRRMKJeT/ECQzQazZTLZZ4Vb0D5Tsh1mFqtJp1ORyaTSejr67MixouMFLFY7AeOnCuoTsMYkV6vJ41GwxugR1cnNzY2POvr66/qhlzPChlRS0tLHuuv6F74XpCqYRg/7e7uvh0eHo7wwsrvE5zP53cQPIr6PMcV+T41NVUZvrog6MTPeDz+BoXn1yI0MzMjLS8v09bW1p961QpmjJWOj48/rKysvBsfHz+bm5tji4uLBBBls1nCzaeamUD3F1Tf3dHR8RoFPQ0GgywUCtHe3h5/dgWoQtg/ur+Fw+Fnra2tfoz7zvT0NFtdXaXt7W06Ojri0m68UI7+5/lCkqRfiUQiGAgEnPj9PDs7K3Ldm5ubhP9UKBS4vFuzlqtUqnPo+7i0tGTFpeMfqALXjSEijHdF+13BV/MzNjamWVhYyM7PzzOMcSXw5OSESqUS1ft5/C3AAL39YeI2ufApAAAAAElFTkSuQmCC");
            }

            MRAIDBrowser.this.forwardButton.setImageDrawable(var3);
         }

         public void onPageStarted(WebView var1, String var2, Bitmap var3) {
            super.onPageStarted(var1, var2, var3);
            Drawable var4 = Assets.getDrawableFromBase64(MRAIDBrowser.this.getResources(), "iVBORw0KGgoAAAANSUhEUgAAABEAAAAUCAYAAABroNZJAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAqNJREFUeNqUlEtrE1EUx8+8EjNT27zTaMw0k6RJGpu+VqIi4k7rQtyKIn6FrEraRhTET+AnENxUXLpWcFfRhaCbCpY0Lc3DpE07c+dxPTckojTG5sAfhnvP/fE/99wz3IV4/Fl1Z+eDZVlVAKigmihjwuejcIpoNZsg+AOBlz6//2E4EonWazUGElC2oesWip7xeIZCMAeEUDhcpBw3LkqubDqdvs1xQNqt1iHucygGshBEh0LQQREBY2fHx8F2HLfkcl1OJKaut1vtCiEGy6M9V/YgWBcSDIWKHM+PyYoMLpcbJEkCYpoT/mDg1rloNF+tVrcwV0Q5PZjzZ4l/QdiGIAjAoxiI43jOtKyYOqXeVRRFrmPgGb5Xot2/rxMQnhe6dA4vRhDFLsymjkApzGta8iYhpNnpdAgrsQ9j3wMh/cB1EAURy3QBsSyPMqbcUFX1UrPRqJimyUAOgw2F9GzhOsLQFXNHiBmMRCeXg8FgfG939wtmtLnszMwuJ4gRr98Hoij993E5jgPoAvSjI1A8ngPT0B+JMGIwV263G2RZhulU8lNle/vdyBAWc4XCdijgv7deKr1nFzsSJB6L6ZnMdHFtZeVFbrbgxBMa/Pi+BaeCeL1eZ3529tWT8vr9iwsLdiKVhka9BqZBuvtDIRJ2Y3Fh/jM4dBkBlVQmSxv7NTAMHWzbBkrpcEg+l9ufjIQflFdX32byeRpTVfiJY29Z5u/D/TgBOR+Nkmw287xcKj2eKczZqqZBs97AthKg2N5B48zjvLOnCzJO6LWrV95g330bG6/XtPS0zeo+aLeBoH3nH4CuE5wTktS0r1pSu/O0XP6WzuZop3OIg2Vg3dYJ64OCW1xamvy4ubmXwsOGfgz68TFY+CIdeqq/Y/f3+EuAAQARwzy3ZhCNHQAAAABJRU5ErkJggg==");
            MRAIDBrowser.this.forwardButton.setImageDrawable(var4);
         }

         public void onReceivedError(WebView var1, int var2, String var3, String var4) {
            Toast.makeText((Activity)var1.getContext(), "MRAID error: " + var3, 0).show();
         }

         public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
            if(var2 != null) {
               String var4 = Uri.parse(var2).getHost();
               if(var2.startsWith("market:") || var2.startsWith("tel:") || var2.startsWith("voicemail:") || var2.startsWith("sms:") || var2.startsWith("mailto:") || var2.startsWith("geo:") || var2.startsWith("google.streetview:") || "play.google.com".equals(var4) || "market.android.com".equals(var4)) {
                  try {
                     if(var2.startsWith("tel:")) {
                        if(MRAIDBrowser.this.supportedNativeFeatures.contains("tel")) {
                           MRAIDBrowser.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(var2)));
                        }
                     } else if(var2.startsWith("sms:")) {
                        if(MRAIDBrowser.this.supportedNativeFeatures.contains("sms")) {
                           MRAIDBrowser.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(var2)));
                        }
                     } else {
                        MRAIDBrowser.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(var2)));
                     }
                  } catch (ActivityNotFoundException var3) {
                     Log.w("MoPub", "Unable to start activity for " + var2 + ". Ensure that your phone can handle this intent.");
                  }

                  MRAIDBrowser.this.finish();
                  return true;
               }
            }

            return false;
         }
      });
      this.webView.setWebChromeClient(new WebChromeClient() {
         public void onProgressChanged(WebView var1, int var2) {
            Activity var3 = (Activity)var1.getContext();
            var3.setTitle("Loading...");
            var3.setProgress(var2 * 100);
            if(var2 == 100) {
               var3.setTitle(var1.getUrl());
            }

         }
      });
   }

   private void setButtonListeners() {
      this.backButton.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            if(MRAIDBrowser.this.webView.canGoBack()) {
               MRAIDBrowser.this.webView.goBack();
            }

         }
      });
      this.forwardButton.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            if(MRAIDBrowser.this.webView.canGoForward()) {
               MRAIDBrowser.this.webView.goForward();
            }

         }
      });
      this.refreshButton.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            MRAIDBrowser.this.webView.reload();
         }
      });
      this.closeButton.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            MRAIDBrowser.this.finish();
         }
      });
   }

   ImageButton createButton(int var1, int var2, int var3, String var4) {
      ImageButton var5 = new ImageButton(this);
      var5.setImageDrawable(Assets.getDrawableFromBase64(this.getResources(), var4));
      LinearLayout.LayoutParams var6 = new LinearLayout.LayoutParams(var1, var2);
      var6.gravity = 16;
      var5.setLayoutParams(var6);
      var5.setPadding(0, var3, 0, var3);
      var5.setScaleType(ScaleType.FIT_CENTER);
      var5.setBackgroundColor(0);
      return var5;
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.getWindow().requestFeature(2);
      this.getWindow().setFeatureInt(2, -1);
      if(this.getIntent().getExtras() != null) {
         this.supportedNativeFeatures = (ArrayList)this.getIntent().getExtras().getSerializable("extra_manager");
      }

      this.createUi();
      this.setButtonListeners();
      this.setContentView(this.rootLayout);
      this.initializeWebView(this.getIntent());
      this.enableCookies();
   }

   protected void onPause() {
      super.onPause();
      CookieSyncManager.getInstance().stopSync();
   }

   protected void onResume() {
      super.onResume();
      CookieSyncManager.getInstance().startSync();
   }
}
