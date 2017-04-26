package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.view.MotionEventCompat$BaseMotionEventVersionImpl;
import android.support.v4.view.MotionEventCompat$EclairMotionEventVersionImpl;
import android.support.v4.view.MotionEventCompat$MotionEventVersionImpl;
import android.view.MotionEvent;

public class MotionEventCompat {
   public static final int ACTION_HOVER_ENTER = 9;
   public static final int ACTION_HOVER_EXIT = 10;
   public static final int ACTION_HOVER_MOVE = 7;
   public static final int ACTION_MASK = 255;
   public static final int ACTION_POINTER_DOWN = 5;
   public static final int ACTION_POINTER_INDEX_MASK = 65280;
   public static final int ACTION_POINTER_INDEX_SHIFT = 8;
   public static final int ACTION_POINTER_UP = 6;
   public static final int ACTION_SCROLL = 8;
   static final MotionEventCompat$MotionEventVersionImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 5) {
         IMPL = new MotionEventCompat$EclairMotionEventVersionImpl();
      } else {
         IMPL = new MotionEventCompat$BaseMotionEventVersionImpl();
      }
   }

   public static int findPointerIndex(MotionEvent var0, int var1) {
      return IMPL.findPointerIndex(var0, var1);
   }

   public static int getActionIndex(MotionEvent var0) {
      return (var0.getAction() & '\uff00') >> 8;
   }

   public static int getActionMasked(MotionEvent var0) {
      return var0.getAction() & 255;
   }

   public static int getPointerCount(MotionEvent var0) {
      return IMPL.getPointerCount(var0);
   }

   public static int getPointerId(MotionEvent var0, int var1) {
      return IMPL.getPointerId(var0, var1);
   }

   public static float getX(MotionEvent var0, int var1) {
      return IMPL.getX(var0, var1);
   }

   public static float getY(MotionEvent var0, int var1) {
      return IMPL.getY(var0, var1);
   }
}
