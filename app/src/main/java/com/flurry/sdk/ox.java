package com.flurry.sdk;

import com.flurry.sdk.jk;
import com.flurry.sdk.jt;
import com.flurry.sdk.jw;
import com.flurry.sdk.ow;
import com.flurry.sdk.ox$a;
import com.flurry.sdk.sh;
import java.util.HashMap;

public final class ox {
   private HashMap a = new HashMap(64);
   private ow b = null;

   public final jk a(sh var1) {
      synchronized(this) {
         jk var3 = (jk)this.a.get(new ox$a(var1, false));
         return var3;
      }
   }

   public final jk a(Class var1) {
      synchronized(this) {
         jk var3 = (jk)this.a.get(new ox$a(var1, false));
         return var3;
      }
   }

   public final ow a() {
      // $FF: Couldn't be decompiled
   }

   public final void a(sh var1, jk var2) {
      synchronized(this) {
         if(this.a.put(new ox$a(var1, true), var2) == null) {
            this.b = null;
         }

      }
   }

   public final void a(sh var1, jk var2, jw var3) {
      synchronized(this) {
         if(this.a.put(new ox$a(var1, false), var2) == null) {
            this.b = null;
         }

         if(var2 instanceof jt) {
            ((jt)var2).a(var3);
         }

      }
   }

   public final void a(Class var1, jk var2) {
      synchronized(this) {
         if(this.a.put(new ox$a(var1, true), var2) == null) {
            this.b = null;
         }

      }
   }

   public final void a(Class var1, jk var2, jw var3) {
      synchronized(this) {
         if(this.a.put(new ox$a(var1, false), var2) == null) {
            this.b = null;
         }

         if(var2 instanceof jt) {
            ((jt)var2).a(var3);
         }

      }
   }

   public final jk b(sh var1) {
      synchronized(this) {
         jk var3 = (jk)this.a.get(new ox$a(var1, true));
         return var3;
      }
   }

   public final jk b(Class var1) {
      synchronized(this) {
         jk var3 = (jk)this.a.get(new ox$a(var1, true));
         return var3;
      }
   }
}
