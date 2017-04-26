package com.amazon.device.ads;

interface ILog {
   void d(String var1, String var2);

   void d(String var1, String var2, Object... var3);

   void e(String var1, String var2);

   void e(String var1, String var2, Object... var3);

   void i(String var1, String var2);

   void i(String var1, String var2, Object... var3);

   void v(String var1, String var2);

   void v(String var1, String var2, Object... var3);

   void w(String var1, String var2);

   void w(String var1, String var2, Object... var3);
}
