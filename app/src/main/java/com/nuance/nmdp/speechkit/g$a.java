package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.DataUploadResult$DataResult;

final class g$a implements DataUploadResult$DataResult {
   private String a;
   private String b;
   private String c;
   private String d;
   private int e;
   private int f;

   final boolean a(.bb var1) {
      if(var1.a("id")) {
         this.a = var1.f("id");
      }

      if(var1.a("type")) {
         this.b = var1.f("type");
      }

      if(var1.a("status")) {
         this.c = var1.f("status");
      }

      if(var1.a("checksum")) {
         this.d = var1.f("checksum");
      }

      if(var1.a("force_upload")) {
         this.f = var1.d("force_upload");
      }

      if(var1.a("final_count")) {
         this.e = var1.d("final_count");
      }

      return true;
   }

   public final int getChecksum() {
      try {
         int var1 = Integer.parseInt(this.d);
         return var1;
      } catch (Exception var3) {
         return 0;
      }
   }

   public final int getDataCount() {
      return this.e;
   }

   public final int getForceUpload() {
      return this.f;
   }

   public final String getId() {
      return this.a;
   }

   public final String getStatus() {
      return this.c;
   }

   public final String getType() {
      return this.b;
   }
}
