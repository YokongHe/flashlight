package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import java.util.List;

interface AccessibilityNodeInfoCompat$AccessibilityNodeInfoImpl {
   void addAction(Object var1, int var2);

   void addChild(Object var1, View var2);

   void addChild(Object var1, View var2, int var3);

   List findAccessibilityNodeInfosByText(Object var1, String var2);

   Object findFocus(Object var1, int var2);

   Object focusSearch(Object var1, int var2);

   int getActions(Object var1);

   void getBoundsInParent(Object var1, Rect var2);

   void getBoundsInScreen(Object var1, Rect var2);

   Object getChild(Object var1, int var2);

   int getChildCount(Object var1);

   CharSequence getClassName(Object var1);

   CharSequence getContentDescription(Object var1);

   int getLiveRegion(Object var1);

   int getMovementGranularities(Object var1);

   CharSequence getPackageName(Object var1);

   Object getParent(Object var1);

   CharSequence getText(Object var1);

   String getViewIdResourceName(Object var1);

   int getWindowId(Object var1);

   boolean isAccessibilityFocused(Object var1);

   boolean isCheckable(Object var1);

   boolean isChecked(Object var1);

   boolean isClickable(Object var1);

   boolean isEnabled(Object var1);

   boolean isFocusable(Object var1);

   boolean isFocused(Object var1);

   boolean isLongClickable(Object var1);

   boolean isPassword(Object var1);

   boolean isScrollable(Object var1);

   boolean isSelected(Object var1);

   boolean isVisibleToUser(Object var1);

   Object obtain();

   Object obtain(View var1);

   Object obtain(View var1, int var2);

   Object obtain(Object var1);

   boolean performAction(Object var1, int var2);

   boolean performAction(Object var1, int var2, Bundle var3);

   void recycle(Object var1);

   void setAccessibilityFocused(Object var1, boolean var2);

   void setBoundsInParent(Object var1, Rect var2);

   void setBoundsInScreen(Object var1, Rect var2);

   void setCheckable(Object var1, boolean var2);

   void setChecked(Object var1, boolean var2);

   void setClassName(Object var1, CharSequence var2);

   void setClickable(Object var1, boolean var2);

   void setContentDescription(Object var1, CharSequence var2);

   void setEnabled(Object var1, boolean var2);

   void setFocusable(Object var1, boolean var2);

   void setFocused(Object var1, boolean var2);

   void setLiveRegion(Object var1, int var2);

   void setLongClickable(Object var1, boolean var2);

   void setMovementGranularities(Object var1, int var2);

   void setPackageName(Object var1, CharSequence var2);

   void setParent(Object var1, View var2);

   void setParent(Object var1, View var2, int var3);

   void setPassword(Object var1, boolean var2);

   void setScrollable(Object var1, boolean var2);

   void setSelected(Object var1, boolean var2);

   void setSource(Object var1, View var2);

   void setSource(Object var1, View var2, int var3);

   void setText(Object var1, CharSequence var2);

   void setViewIdResourceName(Object var1, String var2);

   void setVisibleToUser(Object var1, boolean var2);
}
