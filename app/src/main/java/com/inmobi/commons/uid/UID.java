package com.inmobi.commons.uid;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.uid.AdvertisingId;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;

public class UID {
   public static final String KEY_AID = "AID";
   public static final String KEY_APPENDED_ID = "AIDL";
   public static final String KEY_FACEBOOK_ID = "FBA";
   public static final String KEY_GPID = "GPID";
   public static final String KEY_IMID = "IMID";
   public static final String KEY_LOGIN_ID = "LID";
   public static final String KEY_LTVID = "LTVID";
   public static final String KEY_ODIN1 = "O1";
   public static final String KEY_SESSION_ID = "SID";
   public static final String KEY_TIMESTAMP = "timestamp";
   public static final String KEY_UM5_ID = "UM5";
   private static UID a;
   private Map b;
   private Map c;
   private Map d = new HashMap();
   private String e;
   private String f = null;

   private UID() {
      this.d.put("FBA", Boolean.valueOf(false));
      this.d.put("GPID", Boolean.valueOf(true));
      this.d.put("LID", Boolean.valueOf(true));
      this.d.put("LTVID", Boolean.valueOf(true));
      this.d.put("O1", Boolean.valueOf(true));
      this.d.put("SID", Boolean.valueOf(true));
      this.d.put("UM5", Boolean.valueOf(true));
      this.d.put("IMID", Boolean.valueOf(true));
      this.d.put("AIDL", Boolean.valueOf(true));
   }

   private String a() {
      return this.e;
   }

   private Map a(int var1) {
      HashMap var2 = new HashMap();
      if((var1 & 4) == 4 || var1 == 0) {
         var2.put("FBA", Boolean.valueOf(false));
      }

      if((var1 & 2) == 2 || var1 == 0) {
         var2.put("O1", Boolean.valueOf(false));
      }

      if((var1 & 8) == 8 || var1 == 0) {
         var2.put("UM5", Boolean.valueOf(false));
      }

      return var2;
   }

   private Map a(Map var1) {
      HashMap var6 = new HashMap(this.d);
      if(var1 == null && this.c == null && this.b == null) {
         return var6;
      } else {
         Object var5 = var1;
         if(var1 == null) {
            var5 = new HashMap();
         }

         if(this.c == null) {
            this.c = new HashMap();
         }

         if(this.b == null) {
            this.b = new HashMap();
         }

         boolean var2;
         boolean var3;
         boolean var4;
         String var7;
         for(Iterator var8 = this.c.keySet().iterator(); var8.hasNext(); var6.put(var7, Boolean.valueOf(Boolean.valueOf(var4).booleanValue() & Boolean.valueOf(var2).booleanValue() & Boolean.valueOf(var3).booleanValue()))) {
            var7 = (String)var8.next();
            if(this.c.get(var7) == null) {
               var2 = true;
            } else {
               var2 = ((Boolean)this.c.get(var7)).booleanValue();
            }

            if(this.b.get(var7) == null) {
               var3 = true;
            } else {
               var3 = ((Boolean)this.b.get(var7)).booleanValue();
            }

            if(((Map)var5).get(var7) == null) {
               var4 = true;
            } else {
               var4 = ((Boolean)((Map)var5).get(var7)).booleanValue();
            }
         }

         return var6;
      }
   }

   public static UID getInstance() {
      if(a == null) {
         a = new UID();
      }

      return a;
   }

   public String getEncodedJSON(Map var1) {
      var1 = this.getUidMap(var1, (String)null, false);
      InternalSDKUtil.getEncodedMap(var1);
      return (new JSONObject(var1)).toString();
   }

   public String getEncryptedJSON(Map var1) {
      return (new JSONObject(InternalSDKUtil.getEncodedMap(this.getMapForEncryption(var1)))).toString();
   }

   public String getJSON(Map var1) {
      return (new JSONObject(this.getRawUidMap(var1))).toString();
   }

   public Map getMapForEncryption(Map var1) {
      String var2 = Integer.toString((new Random()).nextInt());
      String var4 = InternalSDKUtil.encryptRSA((new JSONObject(this.getUidMap(var1, var2, true))).toString());
      HashMap var3 = new HashMap();
      var3.put("u-id-map", var4);
      var3.put("u-id-key", var2);
      var3.put("u-key-ver", com.inmobi.commons.uid.a.a());
      return var3;
   }

   public Map getRawUidMap(Map var1) {
      return this.getUidMap(var1, (String)null, false);
   }

   public Map getUidMap(Map var1, String var2, boolean var3) {
      Map var6 = this.a(var1);
      HashMap var5 = new HashMap();
      if(this.f == null) {
         this.f = com.inmobi.commons.uid.a.e();
      }

      String var4;
      String var7;
      if(((Boolean)var6.get("O1")).booleanValue() && !com.inmobi.commons.uid.a.h()) {
         var4 = com.inmobi.commons.uid.a.a(this.f);
         var7 = var4;
         if(var3) {
            var7 = InternalSDKUtil.xorWithKey(var4, var2);
         }

         var5.put("O1", var7);
      }

      if(((Boolean)var6.get("FBA")).booleanValue()) {
         var4 = com.inmobi.commons.uid.a.d();
         if(var4 != null) {
            var7 = var4;
            if(var3) {
               var7 = InternalSDKUtil.xorWithKey(var4, var2);
            }

            var5.put("FBA", var7);
         }
      }

      if(((Boolean)var6.get("UM5")).booleanValue() && !com.inmobi.commons.uid.a.h()) {
         var4 = com.inmobi.commons.uid.a.b(this.f);
         var7 = var4;
         if(var3) {
            var7 = InternalSDKUtil.xorWithKey(var4, var2);
         }

         var5.put("UM5", var7);
      }

      if(((Boolean)var6.get("LID")).booleanValue()) {
         var4 = com.inmobi.commons.uid.a.c();
         if(var4 != null) {
            var7 = var4;
            if(var3) {
               var7 = InternalSDKUtil.xorWithKey(var4, var2);
            }

            var5.put("LID", var7);
         }
      }

      if(((Boolean)var6.get("SID")).booleanValue()) {
         var4 = com.inmobi.commons.uid.a.b();
         if(var4 != null) {
            var7 = var4;
            if(var3) {
               var7 = InternalSDKUtil.xorWithKey(var4, var2);
            }

            var5.put("SID", var7);
         }
      }

      if(((Boolean)var6.get("LTVID")).booleanValue()) {
         var4 = this.a();
         if(var4 != null) {
            var7 = var4;
            if(var3) {
               var7 = InternalSDKUtil.xorWithKey(var4, var2);
            }

            var5.put("LTVID", var7);
         }
      }

      if(((Boolean)var6.get("GPID")).booleanValue()) {
         AdvertisingId var8 = com.inmobi.commons.uid.a.f();
         if(var8 != null) {
            var4 = var8.getAdId();
            if(var4 != null) {
               var7 = var4;
               if(var3) {
                  var7 = InternalSDKUtil.xorWithKey(var4, var2);
               }

               var5.put("GPID", var7);
            }
         }
      }

      if(((Boolean)var6.get("IMID")).booleanValue()) {
         var4 = com.inmobi.commons.uid.a.b(InternalSDKUtil.getContext());
         if(var4 != null) {
            var7 = var4;
            if(var3) {
               var7 = InternalSDKUtil.xorWithKey(var4, var2);
            }

            var5.put("IMID", var7);
         }
      }

      if(((Boolean)var6.get("AIDL")).booleanValue()) {
         var4 = com.inmobi.commons.uid.a.c(InternalSDKUtil.getContext());
         if(var4 != null) {
            var7 = var4;
            if(var3) {
               var7 = InternalSDKUtil.xorWithKey(var4, var2);
            }

            var5.put("AIDL", var7);
         }
      }

      return var5;
   }

   public void init() {
      com.inmobi.commons.uid.a.g();
      this.printPublisherTestId();
      com.inmobi.commons.uid.a.a(InternalSDKUtil.getContext());
   }

   public boolean isLimitAdTrackingEnabled() {
      return com.inmobi.commons.uid.a.i();
   }

   public void printPublisherTestId() {
      // $FF: Couldn't be decompiled
   }

   public void refresh() {
      com.inmobi.commons.uid.a.g();
   }

   public void setCommonsDeviceIdMaskMap(Map var1) {
      this.c = var1;
   }

   public void setLtvId(String var1) {
      this.e = var1;
   }

   public void setPublisherDeviceIdMaskMap(int var1) {
      this.b = this.a(var1);
   }
}
