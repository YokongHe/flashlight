package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.DataUploadResult$DataResult;

public interface DataUploadResult {
   DataUploadResult$DataResult getDataResult(int var1);

   int getDataResultCount();

   boolean isVocRegenerated();
}
