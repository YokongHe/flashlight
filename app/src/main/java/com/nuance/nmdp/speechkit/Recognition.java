package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.Recognition$Result;
import java.util.List;

public interface Recognition {
   List getDetailedResults();

   Recognition$Result getResult(int var1);

   int getResultCount();

   String getSuggestion();
}
