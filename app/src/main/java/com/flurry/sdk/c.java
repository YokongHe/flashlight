package com.flurry.sdk;

import android.text.TextUtils;
import com.flurry.sdk.eo;
import java.io.DataInput;
import java.io.DataOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class c {
   static final List a = Arrays.asList(new String[]{"requested", "filled", "unfilled", "rendered", "clicked", "prepared", "adunitMerged", "sendUrlStatusResult", "videoStart", "videoFirstQuartile", "videoMidpoint", "videoThirdQuartile", "videoCompleted", "videoProgressed", "sentToUrl", "adClosed", "adWillClose", "renderFailed", "requestAdComponents", "urlVerified", "capExhausted", "capNotExhausted"});
   private static final String b = com.flurry.sdk.c.class.getSimpleName();
   private final String c;
   private final boolean d;
   private final long e;
   private final Map f;

   public c(DataInput var1) {
      this.c = var1.readUTF();
      this.d = var1.readBoolean();
      this.e = var1.readLong();
      this.f = new HashMap();
      short var3 = var1.readShort();

      for(short var2 = 0; var2 < var3; ++var2) {
         this.f.put(var1.readUTF(), var1.readUTF());
      }

   }

   public c(String var1, boolean var2, long var3, Map var5) {
      if(!a.contains(var1)) {
         eo.a(b, "AdEvent initialized with unrecognized type: " + var1);
      }

      this.c = var1;
      this.d = var2;
      this.e = var3;
      if(var5 == null) {
         this.f = new HashMap();
      } else {
         this.f = var5;
      }
   }

   public final String a() {
      return this.c;
   }

   public final void a(DataOutput var1) {
      var1.writeUTF(this.c);
      var1.writeBoolean(this.d);
      var1.writeLong(this.e);
      var1.writeShort(this.f.size());
      Iterator var2 = this.f.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.writeUTF((String)var3.getKey());
         var1.writeUTF((String)var3.getValue());
      }

   }

   public final boolean b() {
      return this.d;
   }

   public final long c() {
      return this.e;
   }

   public final Map d() {
      return this.f;
   }

   public final boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof com.flurry.sdk.c)) {
            return false;
         }

         com.flurry.sdk.c var2 = (com.flurry.sdk.c)var1;
         if(!TextUtils.equals(this.c, var2.c) || this.d != var2.d || this.e != var2.e || this.f != var2.f && (this.f == null || !this.f.equals(var2.f))) {
            return false;
         }
      }

      return true;
   }

   public final int hashCode() {
      int var1 = 17;
      if(this.c != null) {
         var1 = this.c.hashCode() | 17;
      }

      int var2 = var1;
      if(this.d) {
         var2 = var1 | 1;
      }

      var2 = (int)((long)var2 | this.e);
      var1 = var2;
      if(this.f != null) {
         var1 = var2 | this.f.hashCode();
      }

      return var1;
   }
}
