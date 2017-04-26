package org.nexage.sourcekit.util;

import java.util.Comparator;
import org.nexage.sourcekit.util.DefaultMediaPicker;
import org.nexage.sourcekit.util.VASTLog;
import org.nexage.sourcekit.vast.model.VASTMediaFile;

class DefaultMediaPicker$AreaComparator implements Comparator {
   // $FF: synthetic field
   final DefaultMediaPicker this$0;

   private DefaultMediaPicker$AreaComparator(DefaultMediaPicker var1) {
      this.this$0 = var1;
   }

   // $FF: synthetic method
   DefaultMediaPicker$AreaComparator(DefaultMediaPicker var1, DefaultMediaPicker$AreaComparator var2) {
      this(var1);
   }

   public int compare(VASTMediaFile var1, VASTMediaFile var2) {
      int var5 = var1.getWidth().intValue();
      int var6 = var1.getHeight().intValue();
      int var3 = var2.getWidth().intValue();
      int var4 = var2.getHeight().intValue();
      var5 = Math.abs(var5 * var6 - DefaultMediaPicker.access$0(this.this$0));
      var3 = Math.abs(var3 * var4 - DefaultMediaPicker.access$0(this.this$0));
      VASTLog.v("DefaultMediaPicker", "AreaComparator: obj1:" + var5 + " obj2:" + var3);
      return var5 < var3?-1:(var5 > var3?1:0);
   }
}
