package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public final class AdActivity extends Activity {
   private com.google.android.gms.internal.aF a;

   private void a() {
      if(this.a != null) {
         try {
            this.a.j();
         } catch (RemoteException var2) {
            com.google.android.gms.internal.bJ.b("Could not forward setContentViewSet to ad overlay:", var2);
            return;
         }
      }

   }

   protected final void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.a = com.google.android.gms.internal.aD.a((Activity)this);
      if(this.a == null) {
         com.google.android.gms.internal.bJ.e("Could not create ad overlay.");
         this.finish();
      } else {
         try {
            this.a.a(var1);
         } catch (RemoteException var2) {
            com.google.android.gms.internal.bJ.b("Could not forward onCreate to ad overlay:", var2);
            this.finish();
         }
      }
   }

   protected final void onDestroy() {
      try {
         if(this.a != null) {
            this.a.i();
         }
      } catch (RemoteException var2) {
         com.google.android.gms.internal.bJ.b("Could not forward onDestroy to ad overlay:", var2);
      }

      super.onDestroy();
   }

   protected final void onPause() {
      try {
         if(this.a != null) {
            this.a.g();
         }
      } catch (RemoteException var2) {
         com.google.android.gms.internal.bJ.b("Could not forward onPause to ad overlay:", var2);
         this.finish();
      }

      super.onPause();
   }

   protected final void onRestart() {
      super.onRestart();

      try {
         if(this.a != null) {
            this.a.d();
         }

      } catch (RemoteException var2) {
         com.google.android.gms.internal.bJ.b("Could not forward onRestart to ad overlay:", var2);
         this.finish();
      }
   }

   protected final void onResume() {
      super.onResume();

      try {
         if(this.a != null) {
            this.a.f();
         }

      } catch (RemoteException var2) {
         com.google.android.gms.internal.bJ.b("Could not forward onResume to ad overlay:", var2);
         this.finish();
      }
   }

   protected final void onSaveInstanceState(Bundle var1) {
      try {
         if(this.a != null) {
            this.a.b(var1);
         }
      } catch (RemoteException var3) {
         com.google.android.gms.internal.bJ.b("Could not forward onSaveInstanceState to ad overlay:", var3);
         this.finish();
      }

      super.onSaveInstanceState(var1);
   }

   protected final void onStart() {
      super.onStart();

      try {
         if(this.a != null) {
            this.a.e();
         }

      } catch (RemoteException var2) {
         com.google.android.gms.internal.bJ.b("Could not forward onStart to ad overlay:", var2);
         this.finish();
      }
   }

   protected final void onStop() {
      try {
         if(this.a != null) {
            this.a.h();
         }
      } catch (RemoteException var2) {
         com.google.android.gms.internal.bJ.b("Could not forward onStop to ad overlay:", var2);
         this.finish();
      }

      super.onStop();
   }

   public final void setContentView(int var1) {
      super.setContentView(var1);
      this.a();
   }

   public final void setContentView(View var1) {
      super.setContentView(var1);
      this.a();
   }

   public final void setContentView(View var1, LayoutParams var2) {
      super.setContentView(var1, var2);
      this.a();
   }
}
