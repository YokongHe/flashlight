package com.mopub.nativeads;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import com.mopub.common.Preconditions$NoThrow;
import com.mopub.common.VisibleForTesting;
import com.mopub.nativeads.MoPubAdRenderer;
import com.mopub.nativeads.MoPubNativeAdLoadedListener;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import com.mopub.nativeads.MoPubNativeAdPositioning$MoPubClientPositioning;
import com.mopub.nativeads.MoPubNativeAdPositioning$MoPubServerPositioning;
import com.mopub.nativeads.MoPubStreamAdPlacer;
import com.mopub.nativeads.RequestParameters;
import com.mopub.nativeads.VisibilityTracker;
import com.mopub.nativeads.VisibilityTracker$VisibilityTrackerListener;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

public class MoPubAdAdapter extends BaseAdapter {
   private MoPubNativeAdLoadedListener mAdLoadedListener;
   private final Adapter mOriginalAdapter;
   private final MoPubStreamAdPlacer mStreamAdPlacer;
   private final WeakHashMap mViewPositionMap;
   private final VisibilityTracker mVisibilityTracker;

   public MoPubAdAdapter(Context var1, Adapter var2) {
      this(var1, var2, MoPubNativeAdPositioning.serverPositioning());
   }

   public MoPubAdAdapter(Context var1, Adapter var2, MoPubNativeAdPositioning$MoPubClientPositioning var3) {
      this(new MoPubStreamAdPlacer(var1, var3), var2, new VisibilityTracker(var1));
   }

   public MoPubAdAdapter(Context var1, Adapter var2, MoPubNativeAdPositioning$MoPubServerPositioning var3) {
      this(new MoPubStreamAdPlacer(var1, var3), var2, new VisibilityTracker(var1));
   }

   @VisibleForTesting
   MoPubAdAdapter(MoPubStreamAdPlacer var1, Adapter var2, VisibilityTracker var3) {
      this.mOriginalAdapter = var2;
      this.mStreamAdPlacer = var1;
      this.mViewPositionMap = new WeakHashMap();
      this.mVisibilityTracker = var3;
      this.mVisibilityTracker.setVisibilityTrackerListener(new VisibilityTracker$VisibilityTrackerListener() {
         public void onVisibilityChanged(List var1, List var2) {
            MoPubAdAdapter.this.handleVisibilityChange(var1);
         }
      });
      this.mOriginalAdapter.registerDataSetObserver(new DataSetObserver() {
         public void onChanged() {
            MoPubAdAdapter.this.mStreamAdPlacer.setItemCount(MoPubAdAdapter.this.mOriginalAdapter.getCount());
            MoPubAdAdapter.this.notifyDataSetChanged();
         }

         public void onInvalidated() {
            MoPubAdAdapter.this.notifyDataSetInvalidated();
         }
      });
      this.mStreamAdPlacer.setAdLoadedListener(new MoPubNativeAdLoadedListener() {
         public void onAdLoaded(int var1) {
            MoPubAdAdapter.this.handleAdLoaded(var1);
         }

         public void onAdRemoved(int var1) {
            MoPubAdAdapter.this.handleAdRemoved(var1);
         }
      });
      this.mStreamAdPlacer.setItemCount(this.mOriginalAdapter.getCount());
   }

   private void handleVisibilityChange(List var1) {
      Iterator var5 = var1.iterator();
      int var3 = Integer.MAX_VALUE;
      int var2 = 0;

      while(var5.hasNext()) {
         View var4 = (View)var5.next();
         Integer var6 = (Integer)this.mViewPositionMap.get(var4);
         if(var6 != null) {
            var3 = Math.min(var6.intValue(), var3);
            var2 = Math.max(var6.intValue(), var2);
         }
      }

      this.mStreamAdPlacer.placeAdsInRange(var3, var2 + 1);
   }

   public boolean areAllItemsEnabled() {
      return this.mOriginalAdapter instanceof ListAdapter && ((ListAdapter)this.mOriginalAdapter).areAllItemsEnabled();
   }

   public void clearAds() {
      this.mStreamAdPlacer.clearAds();
   }

   public void destroy() {
      this.mStreamAdPlacer.destroy();
      this.mVisibilityTracker.destroy();
   }

   public int getAdjustedPosition(int var1) {
      return this.mStreamAdPlacer.getAdjustedPosition(var1);
   }

   public int getCount() {
      return this.mStreamAdPlacer.getAdjustedCount(this.mOriginalAdapter.getCount());
   }

   public Object getItem(int var1) {
      Object var2 = this.mStreamAdPlacer.getAdData(var1);
      return var2 != null?var2:this.mOriginalAdapter.getItem(this.mStreamAdPlacer.getOriginalPosition(var1));
   }

   public long getItemId(int var1) {
      Object var2 = this.mStreamAdPlacer.getAdData(var1);
      return var2 != null?(long)(~System.identityHashCode(var2) + 1):this.mOriginalAdapter.getItemId(this.mStreamAdPlacer.getOriginalPosition(var1));
   }

   public int getItemViewType(int var1) {
      int var2 = this.mStreamAdPlacer.getAdViewType(var1);
      return var2 != 0?var2 + this.mOriginalAdapter.getViewTypeCount() - 1:this.mOriginalAdapter.getItemViewType(this.mStreamAdPlacer.getOriginalPosition(var1));
   }

   public int getOriginalPosition(int var1) {
      return this.mStreamAdPlacer.getOriginalPosition(var1);
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      View var4 = this.mStreamAdPlacer.getAdView(var1, var2, var3);
      if(var4 != null) {
         var2 = var4;
      } else {
         var2 = this.mOriginalAdapter.getView(this.mStreamAdPlacer.getOriginalPosition(var1), var2, var3);
      }

      this.mViewPositionMap.put(var2, Integer.valueOf(var1));
      this.mVisibilityTracker.addView(var2, 0);
      return var2;
   }

   public int getViewTypeCount() {
      return this.mOriginalAdapter.getViewTypeCount() + this.mStreamAdPlacer.getAdViewTypeCount();
   }

   @VisibleForTesting
   void handleAdLoaded(int var1) {
      if(this.mAdLoadedListener != null) {
         this.mAdLoadedListener.onAdLoaded(var1);
      }

      this.notifyDataSetChanged();
   }

   @VisibleForTesting
   void handleAdRemoved(int var1) {
      if(this.mAdLoadedListener != null) {
         this.mAdLoadedListener.onAdRemoved(var1);
      }

      this.notifyDataSetChanged();
   }

   public boolean hasStableIds() {
      return this.mOriginalAdapter.hasStableIds();
   }

   public void insertItem(int var1) {
      this.mStreamAdPlacer.insertItem(var1);
   }

   public boolean isAd(int var1) {
      return this.mStreamAdPlacer.isAd(var1);
   }

   public boolean isEmpty() {
      boolean var2 = false;
      boolean var1 = var2;
      if(this.mOriginalAdapter.isEmpty()) {
         var1 = var2;
         if(this.mStreamAdPlacer.getAdjustedCount(0) == 0) {
            var1 = true;
         }
      }

      return var1;
   }

   public boolean isEnabled(int var1) {
      return this.isAd(var1) || this.mOriginalAdapter instanceof ListAdapter && ((ListAdapter)this.mOriginalAdapter).isEnabled(this.mStreamAdPlacer.getOriginalPosition(var1));
   }

   public void loadAds(String var1) {
      this.mStreamAdPlacer.loadAds(var1);
   }

   public void loadAds(String var1, RequestParameters var2) {
      this.mStreamAdPlacer.loadAds(var1, var2);
   }

   public void refreshAds(ListView var1, String var2) {
      this.refreshAds(var1, var2, (RequestParameters)null);
   }

   public void refreshAds(ListView var1, String var2, RequestParameters var3) {
      if(Preconditions$NoThrow.checkNotNull(var1, "You called MoPubAdAdapter.refreshAds with a null ListView")) {
         View var9 = var1.getChildAt(0);
         int var4;
         if(var9 == null) {
            var4 = 0;
         } else {
            var4 = var9.getTop();
         }

         int var7 = var1.getFirstVisiblePosition();

         int var5;
         for(var5 = Math.max(var7 - 1, 0); this.mStreamAdPlacer.isAd(var5) && var5 > 0; --var5) {
            ;
         }

         int var6;
         for(var6 = var1.getLastVisiblePosition(); this.mStreamAdPlacer.isAd(var6) && var6 < this.getCount() - 1; ++var6) {
            ;
         }

         var5 = this.mStreamAdPlacer.getOriginalPosition(var5);
         var6 = this.mStreamAdPlacer.getOriginalCount(var6 + 1);
         int var8 = this.mStreamAdPlacer.getOriginalCount(this.getCount());
         this.mStreamAdPlacer.removeAdsInRange(var6, var8);
         var5 = this.mStreamAdPlacer.removeAdsInRange(0, var5);
         if(var5 > 0) {
            var1.setSelectionFromTop(var7 - var5, var4);
         }

         this.loadAds(var2, var3);
      }
   }

   public final void registerAdRenderer(MoPubAdRenderer var1) {
      if(Preconditions$NoThrow.checkNotNull(var1, "Tried to set a null ad renderer on the placer.")) {
         this.mStreamAdPlacer.registerAdRenderer(var1);
      }
   }

   public void removeItem(int var1) {
      this.mStreamAdPlacer.removeItem(var1);
   }

   public final void setAdLoadedListener(MoPubNativeAdLoadedListener var1) {
      this.mAdLoadedListener = var1;
   }

   public void setOnClickListener(ListView var1, final OnItemClickListener var2) {
      if(Preconditions$NoThrow.checkNotNull(var1, "You called MoPubAdAdapter.setOnClickListener with a null ListView")) {
         if(var2 == null) {
            var1.setOnItemClickListener((OnItemClickListener)null);
         } else {
            var1.setOnItemClickListener(new OnItemClickListener() {
               public void onItemClick(AdapterView var1, View var2x, int var3, long var4) {
                  if(!MoPubAdAdapter.this.mStreamAdPlacer.isAd(var3)) {
                     var2.onItemClick(var1, var2x, MoPubAdAdapter.this.mStreamAdPlacer.getOriginalPosition(var3), var4);
                  }

               }
            });
         }
      }
   }

   public void setOnItemLongClickListener(ListView var1, final OnItemLongClickListener var2) {
      if(Preconditions$NoThrow.checkNotNull(var1, "You called MoPubAdAdapter.setOnItemLongClickListener with a null ListView")) {
         if(var2 == null) {
            var1.setOnItemLongClickListener((OnItemLongClickListener)null);
         } else {
            var1.setOnItemLongClickListener(new OnItemLongClickListener() {
               public boolean onItemLongClick(AdapterView var1, View var2x, int var3, long var4) {
                  return MoPubAdAdapter.this.isAd(var3) || var2.onItemLongClick(var1, var2x, MoPubAdAdapter.this.mStreamAdPlacer.getOriginalPosition(var3), var4);
               }
            });
         }
      }
   }

   public void setOnItemSelectedListener(ListView var1, final OnItemSelectedListener var2) {
      if(Preconditions$NoThrow.checkNotNull(var1, "You called MoPubAdAdapter.setOnItemSelectedListener with a null ListView")) {
         if(var2 == null) {
            var1.setOnItemSelectedListener((OnItemSelectedListener)null);
         } else {
            var1.setOnItemSelectedListener(new OnItemSelectedListener() {
               public void onItemSelected(AdapterView var1, View var2x, int var3, long var4) {
                  if(!MoPubAdAdapter.this.isAd(var3)) {
                     var2.onItemSelected(var1, var2x, MoPubAdAdapter.this.mStreamAdPlacer.getOriginalPosition(var3), var4);
                  }

               }

               public void onNothingSelected(AdapterView var1) {
                  var2.onNothingSelected(var1);
               }
            });
         }
      }
   }

   public void setSelection(ListView var1, int var2) {
      if(Preconditions$NoThrow.checkNotNull(var1, "You called MoPubAdAdapter.setSelection with a null ListView")) {
         var1.setSelection(this.mStreamAdPlacer.getAdjustedPosition(var2));
      }
   }

   public void smoothScrollToPosition(ListView var1, int var2) {
      if(Preconditions$NoThrow.checkNotNull(var1, "You called MoPubAdAdapter.smoothScrollToPosition with a null ListView")) {
         var1.smoothScrollToPosition(this.mStreamAdPlacer.getAdjustedPosition(var2));
      }
   }
}
