package com.mopub.volley.toolbox;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader;
import com.mopub.volley.toolbox.ImageLoader$ImageContainer;
import com.mopub.volley.toolbox.ImageLoader$ImageListener;

public class NetworkImageView extends ImageView {
   private int mDefaultImageId;
   private int mErrorImageId;
   private ImageLoader$ImageContainer mImageContainer;
   private ImageLoader mImageLoader;
   private String mUrl;

   public NetworkImageView(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public NetworkImageView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public NetworkImageView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
   }

   private void setDefaultImageOrNull() {
      if(this.mDefaultImageId != 0) {
         this.setImageResource(this.mDefaultImageId);
      } else {
         this.setImageBitmap((Bitmap)null);
      }
   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      this.invalidate();
   }

   void loadImageIfNecessary(final boolean var1) {
      boolean var4 = true;
      byte var5 = 0;
      int var7 = this.getWidth();
      int var6 = this.getHeight();
      boolean var2;
      boolean var3;
      if(this.getLayoutParams() != null) {
         if(this.getLayoutParams().width == -2) {
            var3 = true;
         } else {
            var3 = false;
         }

         if(this.getLayoutParams().height == -2) {
            var2 = true;
         } else {
            var2 = false;
         }
      } else {
         var2 = false;
         var3 = false;
      }

      if(!var3 || !var2) {
         var4 = false;
      }

      label70: {
         if(var7 != 0 || var6 != 0 || var4) {
            if(TextUtils.isEmpty(this.mUrl)) {
               if(this.mImageContainer != null) {
                  this.mImageContainer.cancelRequest();
                  this.mImageContainer = null;
               }

               this.setDefaultImageOrNull();
               return;
            }

            if(this.mImageContainer == null || this.mImageContainer.getRequestUrl() == null) {
               break label70;
            }

            if(!this.mImageContainer.getRequestUrl().equals(this.mUrl)) {
               this.mImageContainer.cancelRequest();
               this.setDefaultImageOrNull();
               break label70;
            }
         }

         return;
      }

      int var9;
      if(var3) {
         var9 = 0;
      } else {
         var9 = var7;
      }

      int var8;
      if(var2) {
         var8 = var5;
      } else {
         var8 = var6;
      }

      this.mImageContainer = this.mImageLoader.get(this.mUrl, new ImageLoader$ImageListener() {
         public void onErrorResponse(VolleyError var1x) {
            if(NetworkImageView.this.mErrorImageId != 0) {
               NetworkImageView.this.setImageResource(NetworkImageView.this.mErrorImageId);
            }

         }

         public void onResponse(final ImageLoader$ImageContainer var1x, boolean var2) {
            if(var2 && var1) {
               NetworkImageView.this.post(new Runnable() {
                  public void run() {
                     onResponse(var1x, false);
                  }
               });
            } else {
               if(var1x.getBitmap() != null) {
                  NetworkImageView.this.setImageBitmap(var1x.getBitmap());
                  return;
               }

               if(NetworkImageView.this.mDefaultImageId != 0) {
                  NetworkImageView.this.setImageResource(NetworkImageView.this.mDefaultImageId);
                  return;
               }
            }

         }
      }, var9, var8);
   }

   protected void onDetachedFromWindow() {
      if(this.mImageContainer != null) {
         this.mImageContainer.cancelRequest();
         this.setImageBitmap((Bitmap)null);
         this.mImageContainer = null;
      }

      super.onDetachedFromWindow();
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      super.onLayout(var1, var2, var3, var4, var5);
      this.loadImageIfNecessary(true);
   }

   public void setDefaultImageResId(int var1) {
      this.mDefaultImageId = var1;
   }

   public void setErrorImageResId(int var1) {
      this.mErrorImageId = var1;
   }

   public void setImageUrl(String var1, ImageLoader var2) {
      this.mUrl = var1;
      this.mImageLoader = var2;
      this.loadImageIfNecessary(false);
   }
}
