package com.tapjoy.internal;

import com.tapjoy.internal.dq;
import java.io.IOException;

public final class dn extends IOException {
   private dq a = null;

   public dn(String var1) {
      super(var1);
   }

   static dn a() {
      return new dn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
   }

   static dn b() {
      return new dn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
   }

   static dn c() {
      return new dn("CodedInputStream encountered a malformed varint.");
   }

   static dn d() {
      return new dn("Protocol message contained an invalid tag (zero).");
   }

   static dn e() {
      return new dn("Protocol message end-group tag did not match expected tag.");
   }

   static dn f() {
      return new dn("Protocol message tag had invalid wire type.");
   }

   static dn g() {
      return new dn("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
   }

   static dn h() {
      return new dn("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
   }

   public final dn a(dq var1) {
      this.a = var1;
      return this;
   }
}
