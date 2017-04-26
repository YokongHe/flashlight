package com.mopub.common.util;

import com.mopub.common.util.Reflection;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Reflection$MethodBuilder {
   private Class mClass;
   private final Object mInstance;
   private boolean mIsAccessible;
   private boolean mIsStatic;
   private final String mMethodName;
   private List mParameterClasses;
   private List mParameters;

   public Reflection$MethodBuilder(Object var1, String var2) {
      this.mInstance = var1;
      this.mMethodName = var2;
      this.mParameterClasses = new ArrayList();
      this.mParameters = new ArrayList();
      Class var3;
      if(var1 != null) {
         var3 = var1.getClass();
      } else {
         var3 = null;
      }

      this.mClass = var3;
   }

   public Reflection$MethodBuilder addParam(Class var1, Object var2) {
      this.mParameterClasses.add(var1);
      this.mParameters.add(var2);
      return this;
   }

   public Object execute() {
      Class[] var1 = new Class[this.mParameterClasses.size()];
      var1 = (Class[])this.mParameterClasses.toArray(var1);
      Method var3 = Reflection.getDeclaredMethodWithTraversal(this.mClass, this.mMethodName, var1);
      if(this.mIsAccessible) {
         var3.setAccessible(true);
      }

      Object[] var2 = this.mParameters.toArray();
      return this.mIsStatic?var3.invoke((Object)null, var2):var3.invoke(this.mInstance, var2);
   }

   public Reflection$MethodBuilder setAccessible() {
      this.mIsAccessible = true;
      return this;
   }

   public Reflection$MethodBuilder setStatic(Class var1) {
      this.mIsStatic = true;
      this.mClass = var1;
      return this;
   }
}
