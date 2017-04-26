package com.smaato.soma.exception;

import com.smaato.soma.ErrorCode;

public class ParserException extends Exception {
   private static final long serialVersionUID = 3661578789132233012L;
   public ErrorCode code;
   public String message = "";

   public ParserException(String var1, ErrorCode var2) {
      this.code = ErrorCode.NO_ERROR;
      this.message = var1;
      this.code = var2;
   }
}
