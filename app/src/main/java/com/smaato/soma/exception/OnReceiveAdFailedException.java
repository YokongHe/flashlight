package com.smaato.soma.exception;

import com.smaato.soma.exception.AdReceiveFailed;

public class OnReceiveAdFailedException extends AdReceiveFailed {
   private static final long serialVersionUID = 1L;

   public OnReceiveAdFailedException() {
   }

   public OnReceiveAdFailedException(String var1) {
      super(var1);
   }

   public OnReceiveAdFailedException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public OnReceiveAdFailedException(Throwable var1) {
      super(var1);
   }
}
