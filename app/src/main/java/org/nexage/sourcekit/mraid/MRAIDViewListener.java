package org.nexage.sourcekit.mraid;

import org.nexage.sourcekit.mraid.MRAIDView;

public interface MRAIDViewListener {
   void mraidViewClose(MRAIDView var1);

   void mraidViewExpand(MRAIDView var1);

   void mraidViewLoaded(MRAIDView var1);

   boolean mraidViewResize(MRAIDView var1, int var2, int var3, int var4, int var5);
}
