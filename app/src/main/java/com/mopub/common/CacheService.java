package com.mopub.common;

import android.content.Context;
import com.mopub.common.CacheService$DiskLruCacheGetListener;
import com.mopub.common.CacheService$DiskLruCacheGetTask;
import com.mopub.common.CacheService$DiskLruCachePutTask;
import com.mopub.common.DiskLruCache;
import com.mopub.common.DiskLruCache$Snapshot;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Utils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class CacheService {
   private static final int APP_VERSION = 1;
   private static final int DISK_CACHE_INDEX = 0;
   static final String UNIQUE_CACHE_NAME = "mopub-cache";
   private static final int VALUE_COUNT = 1;
   private static DiskLruCache sDiskLruCache;

   @Deprecated
   @VisibleForTesting
   public static void clearAndNullCaches() {
      if(sDiskLruCache != null) {
         try {
            sDiskLruCache.delete();
            sDiskLruCache = null;
         } catch (IOException var1) {
            sDiskLruCache = null;
            return;
         }
      }

   }

   public static boolean containsKeyDiskCache(String var0) {
      if(sDiskLruCache != null) {
         DiskLruCache$Snapshot var2;
         try {
            var2 = sDiskLruCache.get(createValidDiskCacheKey(var0));
         } catch (Exception var1) {
            return false;
         }

         if(var2 != null) {
            return true;
         }
      }

      return false;
   }

   public static String createValidDiskCacheKey(String var0) {
      return Utils.sha1(var0);
   }

   public static File getDiskCacheDirectory(Context var0) {
      return new File(var0.getCacheDir().getPath() + File.separator + "mopub-cache");
   }

   @Deprecated
   @VisibleForTesting
   public static DiskLruCache getDiskLruCache() {
      return sDiskLruCache;
   }

   public static String getFilePathDiskCache(String var0) {
      return sDiskLruCache == null?null:sDiskLruCache.getDirectory() + File.separator + createValidDiskCacheKey(var0) + ".0";
   }

   public static byte[] getFromDiskCache(String param0) {
      // $FF: Couldn't be decompiled
   }

   public static void getFromDiskCacheAsync(String var0, CacheService$DiskLruCacheGetListener var1) {
      (new CacheService$DiskLruCacheGetTask(var0, var1)).execute(new Void[0]);
   }

   public static void initialize(Context var0) {
      initializeDiskCache(var0);
   }

   public static boolean initializeDiskCache(Context var0) {
      boolean var1 = true;
      if(var0 == null) {
         var1 = false;
      } else if(sDiskLruCache == null) {
         File var5 = getDiskCacheDirectory(var0);
         long var2 = DeviceUtils.diskCacheSizeBytes(var5);

         try {
            sDiskLruCache = DiskLruCache.open(var5, 1, 1, var2);
            return true;
         } catch (IOException var4) {
            MoPubLog.d("Unable to create DiskLruCache", var4);
            return true;
         }
      }

      return var1;
   }

   public static boolean putToDiskCache(String param0, InputStream param1) {
      // $FF: Couldn't be decompiled
   }

   public static boolean putToDiskCache(String var0, byte[] var1) {
      return putToDiskCache(var0, (InputStream)(new ByteArrayInputStream(var1)));
   }

   public static void putToDiskCacheAsync(String var0, byte[] var1) {
      (new CacheService$DiskLruCachePutTask(var0, var1)).execute(new Void[0]);
   }
}
