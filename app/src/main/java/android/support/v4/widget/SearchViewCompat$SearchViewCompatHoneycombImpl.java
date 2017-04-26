package android.support.v4.widget;

import android.content.ComponentName;
import android.content.Context;
import android.support.v4.widget.SearchViewCompat$OnCloseListenerCompat;
import android.support.v4.widget.SearchViewCompat$OnQueryTextListenerCompat;
import android.support.v4.widget.SearchViewCompat$SearchViewCompatStubImpl;
import android.support.v4.widget.SearchViewCompatHoneycomb;
import android.support.v4.widget.SearchViewCompatHoneycomb$OnCloseListenerCompatBridge;
import android.support.v4.widget.SearchViewCompatHoneycomb$OnQueryTextListenerCompatBridge;
import android.view.View;

class SearchViewCompat$SearchViewCompatHoneycombImpl extends SearchViewCompat$SearchViewCompatStubImpl {
   public CharSequence getQuery(View var1) {
      return SearchViewCompatHoneycomb.getQuery(var1);
   }

   public boolean isIconified(View var1) {
      return SearchViewCompatHoneycomb.isIconified(var1);
   }

   public boolean isQueryRefinementEnabled(View var1) {
      return SearchViewCompatHoneycomb.isQueryRefinementEnabled(var1);
   }

   public boolean isSubmitButtonEnabled(View var1) {
      return SearchViewCompatHoneycomb.isSubmitButtonEnabled(var1);
   }

   public Object newOnCloseListener(final SearchViewCompat$OnCloseListenerCompat var1) {
      return SearchViewCompatHoneycomb.newOnCloseListener(new SearchViewCompatHoneycomb$OnCloseListenerCompatBridge() {
         public boolean onClose() {
            return var1.onClose();
         }
      });
   }

   public Object newOnQueryTextListener(final SearchViewCompat$OnQueryTextListenerCompat var1) {
      return SearchViewCompatHoneycomb.newOnQueryTextListener(new SearchViewCompatHoneycomb$OnQueryTextListenerCompatBridge() {
         public boolean onQueryTextChange(String var1x) {
            return var1.onQueryTextChange(var1x);
         }

         public boolean onQueryTextSubmit(String var1x) {
            return var1.onQueryTextSubmit(var1x);
         }
      });
   }

   public View newSearchView(Context var1) {
      return SearchViewCompatHoneycomb.newSearchView(var1);
   }

   public void setIconified(View var1, boolean var2) {
      SearchViewCompatHoneycomb.setIconified(var1, var2);
   }

   public void setMaxWidth(View var1, int var2) {
      SearchViewCompatHoneycomb.setMaxWidth(var1, var2);
   }

   public void setOnCloseListener(Object var1, Object var2) {
      SearchViewCompatHoneycomb.setOnCloseListener(var1, var2);
   }

   public void setOnQueryTextListener(Object var1, Object var2) {
      SearchViewCompatHoneycomb.setOnQueryTextListener(var1, var2);
   }

   public void setQuery(View var1, CharSequence var2, boolean var3) {
      SearchViewCompatHoneycomb.setQuery(var1, var2, var3);
   }

   public void setQueryHint(View var1, CharSequence var2) {
      SearchViewCompatHoneycomb.setQueryHint(var1, var2);
   }

   public void setQueryRefinementEnabled(View var1, boolean var2) {
      SearchViewCompatHoneycomb.setQueryRefinementEnabled(var1, var2);
   }

   public void setSearchableInfo(View var1, ComponentName var2) {
      SearchViewCompatHoneycomb.setSearchableInfo(var1, var2);
   }

   public void setSubmitButtonEnabled(View var1, boolean var2) {
      SearchViewCompatHoneycomb.setSubmitButtonEnabled(var1, var2);
   }
}
