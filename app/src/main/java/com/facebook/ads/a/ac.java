package com.facebook.ads.a;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.ImpressionListener;
import com.facebook.ads.NativeAd$Image;
import com.facebook.ads.NativeAd$Rating;
import com.facebook.ads.a.ac$a;
import com.facebook.ads.a.ac$b;
import com.facebook.ads.a.ac$c;
import com.facebook.ads.a.j$b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.WeakHashMap;

public class ac implements Ad {
   private static final String CLICK = "com.facebook.ads.native.click";
   private static final String IMPRESSION = "com.facebook.ads.native.impression";
   private static final String SEPARATOR = ":";
   private static final String TAG = com.facebook.ads.a.ac.class.getSimpleName();
   private static WeakHashMap viewMapping = new WeakHashMap();
   private com.facebook.ads.a.aa adDataModel;
   private AdListener adListener;
   private com.facebook.ads.a.k adRequestController;
   private View adView;
   private ac$b broadcastReceiver;
   private List clickListeners;
   private final Context context;
   private ac$a eventHandler;
   private com.facebook.ads.a.ab handler;
   private ImpressionListener impListener;
   private OnTouchListener touchListener;
   private final String uniqueId;
   private int viewabilityThreshold;

   public ac(Context var1, String var2, AdSize var3, com.facebook.ads.a.n var4, boolean var5) {
      this.context = var1;
      this.clickListeners = new ArrayList();
      this.uniqueId = UUID.randomUUID().toString();
      this.adRequestController = new com.facebook.ads.a.k(this.context, var2, var3, var4, var5, com.facebook.ads.a.o.b, 1, new j$b() {
         public void a(AdError var1) {
            if(ac.this.adListener != null) {
               ac.this.adListener.onError(ac.this, var1);
            }

         }

         public void a(com.facebook.ads.a.l var1) {
            if(var1.d() != null && !(var1.d() instanceof com.facebook.ads.a.aa)) {
               if(ac.this.adListener != null) {
                  ac.this.adListener.onError(ac.this, AdError.INTERNAL_ERROR);
               }

               if(ac.this.adRequestController != null) {
                  ac.this.adRequestController.a("on internal error");
               }
            } else {
               com.facebook.ads.a.aa var2 = (com.facebook.ads.a.aa)var1.d();
               if(var2 != null) {
                  ac.this.adDataModel = var2;
                  ac.this.registerManualLogReceiver();
                  if(ac.this.adListener != null) {
                     ac.this.adListener.onAdLoaded(ac.this);
                  }

                  ac.this.viewabilityThreshold = var1.c();
                  return;
               }

               if(ac.this.adListener != null) {
                  AdListener var5 = ac.this.adListener;
                  com.facebook.ads.a.ac var3 = ac.this;
                  AdError var4;
                  if(var1.e() != null) {
                     var4 = var1.e();
                  } else {
                     var4 = AdError.INTERNAL_ERROR;
                  }

                  var5.onError(var3, var4);
               }

               if(ac.this.adRequestController != null) {
                  ac.this.adRequestController.a("on no fill");
                  return;
               }
            }

         }
      });
   }

   // $FF: synthetic method
   static OnTouchListener access$1000(com.facebook.ads.a.ac var0) {
      return var0.touchListener;
   }

   // $FF: synthetic method
   static com.facebook.ads.a.ab access$1100(com.facebook.ads.a.ac var0) {
      return var0.handler;
   }

   // $FF: synthetic method
   static String access$1200(com.facebook.ads.a.ac var0) {
      return var0.uniqueId;
   }

   // $FF: synthetic method
   static boolean access$1300(com.facebook.ads.a.ac var0) {
      return var0.isViewOnScreen();
   }

   // $FF: synthetic method
   static ImpressionListener access$1400(com.facebook.ads.a.ac var0) {
      return var0.impListener;
   }

   // $FF: synthetic method
   static com.facebook.ads.a.aa access$200(com.facebook.ads.a.ac var0) {
      return var0.adDataModel;
   }

   // $FF: synthetic method
   static Context access$800(com.facebook.ads.a.ac var0) {
      return var0.context;
   }

   // $FF: synthetic method
   static View access$900(com.facebook.ads.a.ac var0) {
      return var0.adView;
   }

   private void addListener(View var1) {
      this.clickListeners.add(var1);
      var1.setOnClickListener(this.eventHandler);
      var1.setOnTouchListener(this.eventHandler);
   }

   private void collectAllSubviews(List var1, View var2) {
      var1.add(var2);
      if(var2 instanceof ViewGroup) {
         ViewGroup var4 = (ViewGroup)var2;

         for(int var3 = 0; var3 < var4.getChildCount(); ++var3) {
            this.collectAllSubviews(var1, var4.getChildAt(var3));
         }
      }

   }

   private void detachListeners() {
      Iterator var1 = this.clickListeners.iterator();

      while(var1.hasNext()) {
         View var2 = (View)var1.next();
         var2.setOnClickListener((OnClickListener)null);
         var2.setOnTouchListener((OnTouchListener)null);
      }

      this.clickListeners.clear();
   }

   private void ensureAdRequestController() {
      if(this.adRequestController == null) {
         RuntimeException var1 = new RuntimeException("No request controller available, has the NativeAd been destroyed?");
         com.facebook.ads.a.c.a(com.facebook.ads.a.b.a(var1));
         throw var1;
      }
   }

   private boolean isViewOnScreen() {
      return this.isAdLoaded() && com.facebook.ads.a.p.a(this.context, this.adView, this.adView.getWidth(), this.adView.getHeight(), this.viewabilityThreshold);
   }

   private void registerManualLogReceiver() {
      if(this.adDataModel != null && this.adDataModel.j()) {
         this.broadcastReceiver = new ac$b(this, null);
         this.broadcastReceiver.a();
         this.handler = new com.facebook.ads.a.ab(new ac$c(this, null) {
            public boolean a() {
               return true;
            }

            public boolean d() {
               return true;
            }
         }, 1000L, this.adDataModel, this.context);
      }

   }

   public void destroy() {
      if(this.adRequestController != null) {
         this.adRequestController.c();
         this.adRequestController = null;
      }

      this.detachListeners();
      if(this.handler != null) {
         this.handler.c();
         this.handler = null;
      }

      if(this.adView != null) {
         viewMapping.remove(this.adView);
         this.adView = null;
      }

      if(this.broadcastReceiver != null) {
         this.broadcastReceiver.b();
         this.broadcastReceiver = null;
      }

   }

   void disableAutoRefresh() {
      this.adRequestController.a();
   }

   public String getAdBody() {
      return !this.isAdLoaded()?null:this.adDataModel.f();
   }

   public String getAdCallToAction() {
      return !this.isAdLoaded()?null:this.adDataModel.g();
   }

   NativeAd$Image getAdChoicesIcon() {
      return !this.isAdLoaded()?null:this.adDataModel.k();
   }

   String getAdChoicesLinkUrl() {
      return !this.isAdLoaded()?null:this.adDataModel.l();
   }

   public NativeAd$Image getAdCoverImage() {
      return !this.isAdLoaded()?null:this.adDataModel.d();
   }

   public NativeAd$Image getAdIcon() {
      return !this.isAdLoaded()?null:this.adDataModel.c();
   }

   public String getAdSocialContext() {
      return !this.isAdLoaded()?null:this.adDataModel.h();
   }

   public NativeAd$Rating getAdStarRating() {
      return !this.isAdLoaded()?null:this.adDataModel.i();
   }

   public String getAdTitle() {
      return !this.isAdLoaded()?null:this.adDataModel.e();
   }

   public String getId() {
      return this.uniqueId;
   }

   public boolean isAdLoaded() {
      return this.adDataModel != null;
   }

   public void loadAd() {
      this.ensureAdRequestController();
      this.adRequestController.b();
   }

   protected void onWindowVisibilityChanged(int var1) {
      if(this.adRequestController != null) {
         this.adRequestController.a(var1);
      }

      if(this.handler != null) {
         if(var1 != 0) {
            this.handler.c();
            return;
         }

         this.handler.b();
      }

   }

   public void registerViewForInteraction(View var1) {
      ArrayList var2 = new ArrayList();
      this.collectAllSubviews(var2, var1);
      this.registerViewForInteraction(var1, var2);
   }

   public void registerViewForInteraction(View var1, List var2) {
      IllegalArgumentException var3;
      if(var1 == null) {
         var3 = new IllegalArgumentException("Must provide a View");
         com.facebook.ads.a.c.a(com.facebook.ads.a.b.a(var3));
         throw var3;
      } else if(var2 != null && var2.size() != 0) {
         if(!this.isAdLoaded()) {
            Log.e(TAG, "Ad not loaded");
         } else {
            if(this.adView != null) {
               Log.w(TAG, "Native Ad was already registered with a View. Auto unregistering and proceeding.");
               this.unregisterView();
            }

            if(viewMapping.containsKey(var1)) {
               Log.w(TAG, "View already registered with a NativeAd. Auto unregistering and proceeding.");
               ((com.facebook.ads.a.ac)((WeakReference)viewMapping.get(var1)).get()).unregisterView();
            }

            this.eventHandler = new ac$a(this, null);
            this.adView = var1;
            Iterator var4 = var2.iterator();

            while(var4.hasNext()) {
               this.addListener((View)var4.next());
            }

            this.handler = new com.facebook.ads.a.ab(new ac$c(this, null), 1000L, this.adDataModel, this.context);
            this.handler.d();
            viewMapping.put(var1, new WeakReference(this));
         }
      } else {
         var3 = new IllegalArgumentException("Invalid set of clickable views");
         com.facebook.ads.a.c.a(com.facebook.ads.a.b.a(var3));
         throw var3;
      }
   }

   public void setAdListener(AdListener var1) {
      this.adListener = var1;
   }

   public void setImpressionListener(ImpressionListener var1) {
      this.impListener = var1;
   }

   public void setOnTouchListener(OnTouchListener var1) {
      this.touchListener = var1;
   }

   public void unregisterView() {
      if(this.adView != null) {
         if(viewMapping.containsKey(this.adView) && ((WeakReference)viewMapping.get(this.adView)).get() == this) {
            viewMapping.remove(this.adView);
            this.detachListeners();
            this.handler.c();
            this.handler = null;
            this.adView = null;
         } else {
            IllegalStateException var1 = new IllegalStateException("View not registered with this NativeAd");
            com.facebook.ads.a.c.a(com.facebook.ads.a.b.a(var1));
            throw var1;
         }
      }
   }
}
