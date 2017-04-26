package com.ihs.a.c.b;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public final class j extends BufferedOutputStream {
   private final CharsetEncoder a;

   public j(OutputStream var1, String var2, int var3) {
      super(var1, var3);
      this.a = Charset.forName(com.ihs.a.c.b.c.a(var2)).newEncoder();
   }

   public final com.ihs.a.c.b.j a(String var1) {
      ByteBuffer var2 = this.a.encode(CharBuffer.wrap(var1));
      super.write(var2.array(), 0, var2.limit());
      return this;
   }
}
