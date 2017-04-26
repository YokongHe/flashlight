package com.flurry.sdk;

import android.graphics.Point;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class by {
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
      var0.add(Integer.valueOf(4));
      var0.add(Integer.valueOf(3));
      var0.add(Integer.valueOf(1));
      var0.add(Integer.valueOf(2));
      return Collections.unmodifiableList(var0);
   }

   private static SparseArray b() {
      SparseArray var0 = new SparseArray();
      var0.put(4, new Point(728, 90));
      var0.put(3, new Point(480, 60));
      var0.put(1, new Point(320, 50));
      var0.put(2, new Point(300, 250));
      return var0;
   }
}
