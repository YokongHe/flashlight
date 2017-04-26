package com.flurry.sdk;

import com.flurry.sdk.dh;
import com.flurry.sdk.eo;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class dk {
   private static final String a = dk.class.getSimpleName();
   private boolean b;
   private List c;
   private long d = -1L;

   private static String a(String var0) {
      String var2 = var0;
      if(var0 != null) {
         var2 = var0;
         if(var0.length() > 4) {
            StringBuilder var3 = new StringBuilder();

            for(int var1 = 0; var1 < var0.length() - 4; ++var1) {
               var3.append('*');
            }

            var3.append(var0.substring(var0.length() - 4));
            var2 = var3.toString();
         }
      }

      return var2;
   }

   private boolean a(String var1, DataInputStream var2) {
      int var3 = var2.readUnsignedShort();
      eo.a(3, a, "File version: " + var3);
      if(var3 > 2) {
         eo.a(6, a, "Unknown agent file version: " + var3);
         throw new IOException("Unknown agent file version: " + var3);
      } else if(var3 < 2) {
         eo.a(5, a, "Deleting old file version: " + var3);
         return false;
      } else {
         String var8 = var2.readUTF();
         eo.a(3, a, "Loading API key: " + a(var1));
         if(!var8.equals(var1)) {
            eo.a(3, a, "Api keys do not match, old: " + a(var1) + ", new: " + a(var8));
            return false;
         } else {
            ArrayList var10 = new ArrayList();
            var2.readUTF();
            boolean var5 = var2.readBoolean();
            long var6 = var2.readLong();
            eo.a(3, a, "Loading session reports");
            var3 = 0;

            while(true) {
               int var4 = var2.readUnsignedShort();
               if(var4 == 0) {
                  eo.a(3, a, "Persistent file loaded");
                  this.a(var5);
                  this.a(var6);
                  this.a((List)var10);
                  return true;
               }

               byte[] var11 = new byte[var4];
               var2.readFully(var11);
               var10.add(0, new dh(var11));
               var8 = a;
               StringBuilder var9 = new StringBuilder("Session report added: ");
               ++var3;
               eo.a(3, var8, var9.append(var3).toString());
            }
         }
      }
   }

   public void a(long var1) {
      this.d = var1;
   }

   public void a(DataOutputStream param1, String param2, String param3) {
      // $FF: Couldn't be decompiled
   }

   public void a(List var1) {
      this.c = var1;
   }

   public void a(boolean var1) {
      this.b = var1;
   }

   public boolean a() {
      return this.b;
   }

   public boolean a(DataInputStream param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   public List b() {
      return this.c;
   }

   public long c() {
      return this.d;
   }
}
