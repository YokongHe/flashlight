package com.amazon.device.ads;

import java.util.HashMap;

class ParameterMap {
   private final HashMap parameters = new HashMap();

   public Boolean getBooleanParameter(String var1) {
      return (Boolean)this.parameters.get(var1);
   }

   public Double getDoubleParameter(String var1) {
      return (Double)this.parameters.get(var1);
   }

   public Integer getIntParameter(String var1) {
      return (Integer)this.parameters.get(var1);
   }

   public Long getLongParameter(String var1) {
      return (Long)this.parameters.get(var1);
   }

   public Object getParameter(String var1) {
      return this.parameters.get(var1);
   }

   public String getStringParameter(String var1) {
      return (String)this.parameters.get(var1);
   }

   public void setParameter(String var1, Object var2) {
      this.parameters.put(var1, var2);
   }
}
