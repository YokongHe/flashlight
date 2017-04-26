package com.flurry.sdk;

import android.graphics.Point;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class bu {
   private static final List a = a();
   private static final SparseArray b = b();

   public static int a(Point var0) {
      if(var0 == null) {
         return -1;
      } else {
         Iterator var2 = a.iterator();

         int var1;
         while(true) {
            if(var2.hasNext()) {
               Integer var3 = (Integer)var2.next();
               Point var4 = a(var3.intValue());
               if(var4 == null || var0.x < var4.x || var0.y < var4.y) {
                  continue;
               }

               var1 = var3.intValue();
               break;
            }

            var1 = -1;
            break;
         }

         return var1;
      }
   }

   public static Point a(int var0) {
      return (Point)b.get(var0);
   }

   private static List a() {
      ArrayList var0 = new ArrayList();
      var0.add(Integer.valueOf(11));
      var0.add(Integer.valueOf(12));
      var0.add(Integer.valueOf(15));
      var0.add(Integer.valueOf(10));
      var0.add(Integer.valueOf(13));
      return Collections.unmodifiableList(var0);
   }

   private static SparseArray b() {
      SparseArray var0 = new SparseArray();
      var0.put(11, new Point(728, 90));
      var0.put(12, new Point(468, 60));
      var0.put(15, new Point(320, 50));
      var0.put(10, new Point(300, 250));
      var0.put(13, new Point(120, 600));
      return var0;
   }
}
