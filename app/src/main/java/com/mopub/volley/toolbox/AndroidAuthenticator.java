package com.mopub.volley.toolbox;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.mopub.volley.AuthFailureError;
import com.mopub.volley.toolbox.Authenticator;

public class AndroidAuthenticator implements Authenticator {
   private final Account mAccount;
   private final String mAuthTokenType;
   private final Context mContext;
   private final boolean mNotifyAuthFailure;

   public AndroidAuthenticator(Context var1, Account var2, String var3) {
      this(var1, var2, var3, false);
   }

   public AndroidAuthenticator(Context var1, Account var2, String var3, boolean var4) {
      this.mContext = var1;
      this.mAccount = var2;
      this.mAuthTokenType = var3;
      this.mNotifyAuthFailure = var4;
   }

   public Account getAccount() {
      return this.mAccount;
   }

   public String getAuthToken() {
      Object var2 = null;
      AccountManagerFuture var3 = AccountManager.get(this.mContext).getAuthToken(this.mAccount, this.mAuthTokenType, this.mNotifyAuthFailure, (AccountManagerCallback)null, (Handler)null);

      Bundle var4;
      try {
         var4 = (Bundle)var3.getResult();
      } catch (Exception var5) {
         throw new AuthFailureError("Error while retrieving auth token", var5);
      }

      String var1 = (String)var2;
      if(var3.isDone()) {
         var1 = (String)var2;
         if(!var3.isCancelled()) {
            if(var4.containsKey("intent")) {
               throw new AuthFailureError((Intent)var4.getParcelable("intent"));
            }

            var1 = var4.getString("authtoken");
         }
      }

      if(var1 == null) {
         throw new AuthFailureError("Got null auth token for type: " + this.mAuthTokenType);
      } else {
         return var1;
      }
   }

   public void invalidateAuthToken(String var1) {
      AccountManager.get(this.mContext).invalidateAuthToken(this.mAccount.type, var1);
   }
}
