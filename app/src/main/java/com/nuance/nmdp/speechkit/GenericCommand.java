package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Dictionary;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue$String;

public interface GenericCommand {
   void addParam(String var1, PdxValue$Dictionary var2);

   void addParam(String var1, PdxValue$String var2);

   void cancel();

   void start();
}
