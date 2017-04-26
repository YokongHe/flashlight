package com.nuance.nmdp.speechkit.recognitionresult;

import java.util.List;

public interface AlternativeChoice {
   List getTokens();

   String toString();
}
