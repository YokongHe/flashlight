package com.smaato.soma.internal;

import android.content.Context;
import com.smaato.soma.AdDownloaderInterface;
import com.smaato.soma.AdType;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.bannerutilities.AbstractBannerPackage;
import com.smaato.soma.exception.HttpConnectorFactoryInstantiationException;
import com.smaato.soma.exception.XmlParserFactoryInstantiationException;
import com.smaato.soma.internal.requests.AdDownloader;
import com.smaato.soma.internal.requests.HttpConnector;
import com.smaato.soma.internal.requests.HttpConnectorInterface;
import com.smaato.soma.internal.utilities.ReceivedBannerParser;
import com.smaato.soma.internal.utilities.XmlParserInterface;

public class DefaultFactory {
   // $FF: synthetic field
   private static int[] $SWITCH_TABLE$com$smaato$soma$AdType;
   private static DefaultFactory mDefaultFactory = null;

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
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            var0[AdType.VIDEO.ordinal()] = 4;
         } catch (NoSuchFieldError var2) {
            ;
         }

         $SWITCH_TABLE$com$smaato$soma$AdType = var0;
         return var0;
      }
   }

   public static DefaultFactory getDefaultFactory() {
      if(mDefaultFactory == null) {
         mDefaultFactory = new DefaultFactory();
      }

      return mDefaultFactory;
   }

   public static void setDefaultFactory(DefaultFactory var0) {
      mDefaultFactory = var0;
   }

   public AdDownloaderInterface createAdDownloader(final Context var1) {
      return (AdDownloaderInterface)(new CrashReportTemplate() {
         public AdDownloader process() {
            return new AdDownloader(var1);
         }
      }).execute();
   }

   public final AbstractBannerPackage createBannerPackage(AdType param1) {
      // $FF: Couldn't be decompiled
   }

   public HttpConnectorInterface createHttpConnector() {
      try {
         HttpConnector var1 = new HttpConnector();
         return var1;
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new HttpConnectorFactoryInstantiationException(var3);
      }
   }

   public XmlParserInterface createXmlParser() {
      try {
         ReceivedBannerParser var1 = new ReceivedBannerParser();
         return var1;
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new XmlParserFactoryInstantiationException(var3);
      }
   }
}
