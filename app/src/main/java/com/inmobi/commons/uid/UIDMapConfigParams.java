package com.inmobi.commons.uid;

import com.inmobi.commons.internal.InternalSDKUtil;
import java.util.Map;

public class UIDMapConfigParams {
   private Map a;
   private boolean b = true;
   private boolean c = true;
   private boolean d = false;
   private boolean e = true;
   private boolean f = true;
   private boolean g = true;
   private boolean h = true;
   private boolean i = true;
   private boolean j = true;

   public boolean getAIDL() {
      return this.j;
   }

   public boolean getFacebookID() {
      return this.d;
   }

   public boolean getGPID() {
      return this.h;
   }

   public boolean getIMID() {
      return this.i;
   }

   public boolean getLTVID() {
      return this.g;
   }

   public boolean getLoginID() {
      return this.b;
   }

   public Map getMap() {
      return this.a;
   }

   public boolean getODIN1() {
      return this.e;
   }

   public boolean getSessionID() {
      return this.c;
   }

   public boolean getUM5() {
      return this.f;
   }

   public void setAIDL(boolean var1) {
      this.j = var1;
   }

   public void setFacebookID(boolean var1) {
      this.d = var1;
   }

   public void setGPID(boolean var1) {
      this.h = var1;
   }

   public void setIMID(boolean var1) {
      this.i = var1;
   }

   public void setLTVID(boolean var1) {
      this.g = var1;
   }

   public void setLoginID(boolean var1) {
      this.b = var1;
   }

   public void setMap(Object var1) {
      Map var2 = (Map)var1;
      this.b = InternalSDKUtil.getBooleanFromMap(var2, "LID");
      this.c = InternalSDKUtil.getBooleanFromMap(var2, "SID");
      this.d = InternalSDKUtil.getBooleanFromMap(var2, "FBA");
      this.e = InternalSDKUtil.getBooleanFromMap(var2, "O1");
      this.f = InternalSDKUtil.getBooleanFromMap(var2, "UM5");
      this.g = InternalSDKUtil.getBooleanFromMap(var2, "LTVID");
      this.h = InternalSDKUtil.getBooleanFromMap(var2, "GPID");
      this.i = InternalSDKUtil.getBooleanFromMap(var2, "IMID");
      this.j = InternalSDKUtil.getBooleanFromMap(var2, "AIDL");
      this.a = (Map)var1;
   }

   public void setODIN1(boolean var1) {
      this.e = var1;
   }

   public void setSessionID(boolean var1) {
      this.c = var1;
   }

   public void setUM5(boolean var1) {
      this.f = var1;
   }
}
