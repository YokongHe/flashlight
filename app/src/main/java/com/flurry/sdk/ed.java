package com.flurry.sdk;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.zip.CRC32;

public class ed extends MessageDigest {
   private CRC32 a = new CRC32();

   public ed() {
      super("CRC");
   }

   public byte[] a() {
      return this.engineDigest();
   }

   public int b() {
      return ByteBuffer.wrap(this.engineDigest()).getInt();
   }

   protected byte[] engineDigest() {
      long var1 = this.a.getValue();
      return new byte[]{(byte)((int)((-16777216L & var1) >> 24)), (byte)((int)((16711680L & var1) >> 16)), (byte)((int)((65280L & var1) >> 8)), (byte)((int)((var1 & 255L) >> 0))};
   }

   protected void engineReset() {
      this.a.reset();
   }

   protected void engineUpdate(byte var1) {
      this.a.update(var1);
   }

   protected void engineUpdate(byte[] var1, int var2, int var3) {
      this.a.update(var1, var2, var3);
   }
}
