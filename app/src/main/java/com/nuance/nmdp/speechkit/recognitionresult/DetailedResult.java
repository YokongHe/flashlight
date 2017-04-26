package com.nuance.nmdp.speechkit.recognitionresult;

import com.nuance.nmdp.speechkit.recognitionresult.Token;
import java.util.List;

public interface DetailedResult {
   List getAlternatives(int var1, int var2);

   double getConfidenceScore();

   Token getTokenAtCursorPosition(int var1);

   List getTokens();

   String toString();
}
