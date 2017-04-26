package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;

public interface LoaderManager$LoaderCallbacks {
   Loader onCreateLoader(int var1, Bundle var2);

   void onLoadFinished(Loader var1, Object var2);

   void onLoaderReset(Loader var1);
}
