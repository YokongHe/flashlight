package com.smaato.soma.internal.statemachine;

import com.smaato.soma.debug.DebugCategory;
import com.smaato.soma.debug.Debugger;
import com.smaato.soma.debug.LogMessage;
import com.smaato.soma.exception.BannerStateLoggingFailedException;
import com.smaato.soma.exception.ChangingBannerStateFailedException;
import com.smaato.soma.exception.TransitionCloseNoOrmmaFailedException;
import com.smaato.soma.exception.TransitionClosingOrmmaFailedException;
import com.smaato.soma.exception.TransitionDisplayingBannerFailedException;
import com.smaato.soma.exception.TransitionExpandingBannerFailedException;
import com.smaato.soma.internal.statemachine.BannerState$State;
import com.smaato.soma.internal.statemachine.BannerState$Transition;
import com.smaato.soma.internal.statemachine.BannerStateDelegate;

public class BannerState {
   // $FF: synthetic field
   private static int[] $SWITCH_TABLE$com$smaato$soma$internal$statemachine$BannerState$State;
   // $FF: synthetic field
   private static int[] $SWITCH_TABLE$com$smaato$soma$internal$statemachine$BannerState$Transition;
   private BannerState$State mCurrentState;
   private boolean mLoggingEnabled;
   private BannerStateDelegate mStatesDelegate = null;

   // $FF: synthetic method
   static int[] $SWITCH_TABLE$com$smaato$soma$internal$statemachine$BannerState$State() {
      int[] var0 = $SWITCH_TABLE$com$smaato$soma$internal$statemachine$BannerState$State;
      if(var0 != null) {
         return var0;
      } else {
         var0 = new int[BannerState$State.values().length];

         try {
            var0[BannerState$State.STATE_BANNERDISPLAYED.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            var0[BannerState$State.STATE_BANNEREXPANDED.ordinal()] = 3;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            var0[BannerState$State.STATE_EMPTY.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
            ;
         }

         $SWITCH_TABLE$com$smaato$soma$internal$statemachine$BannerState$State = var0;
         return var0;
      }
   }

   // $FF: synthetic method
   static int[] $SWITCH_TABLE$com$smaato$soma$internal$statemachine$BannerState$Transition() {
      int[] var0 = $SWITCH_TABLE$com$smaato$soma$internal$statemachine$BannerState$Transition;
      if(var0 != null) {
         return var0;
      } else {
         var0 = new int[BannerState$Transition.values().length];

         try {
            var0[BannerState$Transition.TRANSITION_CLOSENOORMMA.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            var0[BannerState$Transition.TRANSITION_CLOSEORMMA.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            var0[BannerState$Transition.TRANSITION_DISPLAYBANNER.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            var0[BannerState$Transition.TRANSITION_EXPANDBANNER.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
            ;
         }

         $SWITCH_TABLE$com$smaato$soma$internal$statemachine$BannerState$Transition = var0;
         return var0;
      }
   }

   public BannerState() {
      this.mCurrentState = BannerState$State.STATE_EMPTY;
      this.mLoggingEnabled = false;
   }

   private void callEnterState(BannerState$State param1) {
      // $FF: Couldn't be decompiled
   }

   private void callExitState(BannerState$State param1) {
      // $FF: Couldn't be decompiled
   }

   private void callTransitionTriggered(BannerState$Transition param1) {
      // $FF: Couldn't be decompiled
   }

   private void logMessage(String var1) {
      try {
         if(this.mLoggingEnabled) {
            Debugger.showLog(new LogMessage("BannerState", var1, 1, DebugCategory.DEBUG));
         }

      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new BannerStateLoggingFailedException(var3);
      }
   }

   private void setStateTo(BannerState$Transition var1, BannerState$State var2) {
      try {
         this.callExitState(this.mCurrentState);
         this.callTransitionTriggered(var1);
         this.mCurrentState = var2;
         this.callEnterState(var2);
      } catch (RuntimeException var3) {
         throw var3;
      } catch (Exception var4) {
         throw new ChangingBannerStateFailedException(var4);
      }
   }

   public BannerState$State getCurrentState() {
      return this.mCurrentState;
   }

   public boolean isLoggingEnabled() {
      return this.mLoggingEnabled;
   }

   public void setLoggingEnabled(boolean var1) {
      this.mLoggingEnabled = var1;
   }

   public void setStatesDelegate(BannerStateDelegate var1) {
      this.mStatesDelegate = var1;
   }

   public boolean transitionCloseNoOrmma() {
      try {
         if(this.mCurrentState == BannerState$State.STATE_BANNEREXPANDED) {
            this.setStateTo(BannerState$Transition.TRANSITION_CLOSENOORMMA, BannerState$State.STATE_EMPTY);
            return true;
         } else {
            return false;
         }
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new TransitionCloseNoOrmmaFailedException(var3);
      }
   }

   public boolean transitionCloseOrmma() {
      try {
         if(this.mCurrentState == BannerState$State.STATE_BANNEREXPANDED) {
            this.setStateTo(BannerState$Transition.TRANSITION_CLOSEORMMA, BannerState$State.STATE_BANNERDISPLAYED);
            return true;
         } else {
            return false;
         }
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new TransitionClosingOrmmaFailedException(var3);
      }
   }

   public boolean transitionDisplayBanner() {
      try {
         if(this.mCurrentState != BannerState$State.STATE_EMPTY && this.mCurrentState != BannerState$State.STATE_BANNERDISPLAYED) {
            return false;
         } else {
            this.setStateTo(BannerState$Transition.TRANSITION_DISPLAYBANNER, BannerState$State.STATE_BANNERDISPLAYED);
            return true;
         }
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new TransitionDisplayingBannerFailedException(var3);
      }
   }

   public boolean transitionExpandBanner() {
      try {
         if(this.mCurrentState == BannerState$State.STATE_BANNERDISPLAYED) {
            this.setStateTo(BannerState$Transition.TRANSITION_EXPANDBANNER, BannerState$State.STATE_BANNEREXPANDED);
            return true;
         } else {
            return false;
         }
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new TransitionExpandingBannerFailedException(var3);
      }
   }
}
