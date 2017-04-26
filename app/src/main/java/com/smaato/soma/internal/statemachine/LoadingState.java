package com.smaato.soma.internal.statemachine;

import com.smaato.soma.debug.DebugCategory;
import com.smaato.soma.debug.Debugger;
import com.smaato.soma.debug.LogMessage;
import com.smaato.soma.exception.BlockingLoadingStateFailedException;
import com.smaato.soma.exception.CallingLoadingStateEnteredFailedException;
import com.smaato.soma.exception.CallingLoadingStateExitFailedException;
import com.smaato.soma.exception.ErrorBannerLoadingFailedException;
import com.smaato.soma.exception.LoadingBannerStateFailedException;
import com.smaato.soma.exception.LoadingStateLoggingFailedException;
import com.smaato.soma.exception.ModifyingLoadingStateFailedException;
import com.smaato.soma.exception.StateFinishedLoadingFailedException;
import com.smaato.soma.exception.TransitionLoadingXmlFailedException;
import com.smaato.soma.exception.UnblockingLoadingStateFailedException;
import com.smaato.soma.internal.statemachine.LoadingState$State;
import com.smaato.soma.internal.statemachine.LoadingState$Transition;
import com.smaato.soma.internal.statemachine.LoadingStateDelegate;
import com.smaato.soma.internal.utilities.Controller;

public class LoadingState {
   // $FF: synthetic field
   private static int[] $SWITCH_TABLE$com$smaato$soma$internal$statemachine$LoadingState$Transition;
   private LoadingState$State mCurrentState;
   private boolean mLoggingEnabled;
   private LoadingStateDelegate mStatesDelegate = null;

   // $FF: synthetic method
   static int[] $SWITCH_TABLE$com$smaato$soma$internal$statemachine$LoadingState$Transition() {
      int[] var0 = $SWITCH_TABLE$com$smaato$soma$internal$statemachine$LoadingState$Transition;
      if(var0 != null) {
         return var0;
      } else {
         var0 = new int[LoadingState$Transition.values().length];

         try {
            var0[LoadingState$Transition.TRANSITION_BLOCKLOADING.ordinal()] = 3;
         } catch (NoSuchFieldError var7) {
            ;
         }

         try {
            var0[LoadingState$Transition.TRANSITION_ERRORLOADING.ordinal()] = 6;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            var0[LoadingState$Transition.TRANSITION_FINISHLOADING.ordinal()] = 5;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            var0[LoadingState$Transition.TRANSITION_LOADBANNER.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            var0[LoadingState$Transition.TRANSITION_LOADXML.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            var0[LoadingState$Transition.TRANSITION_UNBLOCKLOADING.ordinal()] = 4;
         } catch (NoSuchFieldError var2) {
            ;
         }

         $SWITCH_TABLE$com$smaato$soma$internal$statemachine$LoadingState$Transition = var0;
         return var0;
      }
   }

   public LoadingState() {
      this.mCurrentState = LoadingState$State.STATE_IDLE;
      this.mLoggingEnabled = false;
   }

   private void callEnterState(LoadingState$State var1) {
      try {
         if(var1 == LoadingState$State.STATE_IDLE) {
            this.mStatesDelegate.stateIdleEntered();
            this.logMessage("Enter state Idle");
         } else if(var1 == LoadingState$State.STATE_XMLLOADING) {
            this.logMessage("Enter state XmlLoading");
            this.mStatesDelegate.stateXmlLoadingEntered();
         } else if(var1 == LoadingState$State.STATE_BLOCKED) {
            this.logMessage("Enter state Blocked");
            this.mStatesDelegate.stateBlockedEntered();
         } else {
            if(var1 == LoadingState$State.STATE_BANNERLOADING) {
               this.logMessage("Enter state BannerLoading");
               this.mStatesDelegate.stateBannerLoadingEntered();
            }

         }
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new CallingLoadingStateEnteredFailedException(var3);
      }
   }

   private void callExitState(LoadingState$State var1) {
      try {
         if(var1 == LoadingState$State.STATE_IDLE) {
            this.logMessage("Exit state Idle");
            this.mStatesDelegate.stateIdleExit();
         } else if(var1 == LoadingState$State.STATE_XMLLOADING) {
            this.logMessage("Exit state XmlLoading");
            this.mStatesDelegate.stateXmlLoadingExit();
         } else if(var1 == LoadingState$State.STATE_BLOCKED) {
            this.logMessage("Exit state Blocked");
            this.mStatesDelegate.stateBlockedExit();
         } else {
            if(var1 == LoadingState$State.STATE_BANNERLOADING) {
               this.logMessage("Exit state BannerLoading");
               this.mStatesDelegate.stateBannerLoadingExit();
            }

         }
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new CallingLoadingStateExitFailedException(var3);
      }
   }

   private void callTransitionTriggered(LoadingState$Transition param1) {
      // $FF: Couldn't be decompiled
   }

   private void logMessage(String var1) {
      try {
         if(this.mLoggingEnabled) {
            Debugger.showLog(new LogMessage("LoadingState", var1, 1, DebugCategory.DEBUG));
         }

      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new LoadingStateLoggingFailedException(var3);
      }
   }

   private void setStateTo(LoadingState$Transition var1, LoadingState$State var2) {
      try {
         this.callExitState(this.mCurrentState);
         this.callTransitionTriggered(var1);
         this.mCurrentState = var2;
         this.callEnterState(var2);
      } catch (RuntimeException var3) {
         throw var3;
      } catch (Exception var4) {
         throw new ModifyingLoadingStateFailedException(var4);
      }
   }

   public LoadingState$State getCurrentState() {
      return this.mCurrentState;
   }

   public boolean isLoggingEnabled() {
      return this.mLoggingEnabled;
   }

   public void setLoggingEnabled(boolean var1) {
      this.mLoggingEnabled = var1;
   }

   public void setStatesDelegate(LoadingStateDelegate var1) {
      this.mStatesDelegate = var1;
   }

   public boolean transitionBlockLoading() {
      try {
         if(this.mCurrentState != LoadingState$State.STATE_XMLLOADING && this.mCurrentState != LoadingState$State.STATE_IDLE && this.mCurrentState != LoadingState$State.STATE_BANNERLOADING) {
            this.logMessage("Unable to trigger BlockLoading");
            Controller.getInstance().registerProblem();
            return false;
         } else {
            this.setStateTo(LoadingState$Transition.TRANSITION_BLOCKLOADING, LoadingState$State.STATE_BLOCKED);
            return true;
         }
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new BlockingLoadingStateFailedException(var3);
      }
   }

   public boolean transitionErrorLoading() {
      try {
         if(this.mCurrentState == LoadingState$State.STATE_XMLLOADING) {
            this.setStateTo(LoadingState$Transition.TRANSITION_ERRORLOADING, LoadingState$State.STATE_IDLE);
            return true;
         } else {
            this.logMessage("Unable to trigger ErrorLoading");
            Controller.getInstance().registerProblem();
            return false;
         }
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new ErrorBannerLoadingFailedException(var3);
      }
   }

   public boolean transitionFinishLoading() {
      try {
         if(this.mCurrentState == LoadingState$State.STATE_BANNERLOADING) {
            this.setStateTo(LoadingState$Transition.TRANSITION_FINISHLOADING, LoadingState$State.STATE_IDLE);
            return true;
         } else {
            this.logMessage("Unable to trigger FinishLoading");
            Controller.getInstance().registerProblem();
            return false;
         }
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new StateFinishedLoadingFailedException(var3);
      }
   }

   public boolean transitionLoadBanner() {
      try {
         if(this.mCurrentState == LoadingState$State.STATE_XMLLOADING) {
            this.setStateTo(LoadingState$Transition.TRANSITION_LOADBANNER, LoadingState$State.STATE_BANNERLOADING);
            return true;
         } else {
            this.logMessage("Unable to trigger LoadBanner");
            return false;
         }
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new LoadingBannerStateFailedException(var3);
      }
   }

   public boolean transitionLoadXml() {
      try {
         if(this.mCurrentState == LoadingState$State.STATE_IDLE) {
            this.setStateTo(LoadingState$Transition.TRANSITION_LOADXML, LoadingState$State.STATE_XMLLOADING);
            return true;
         } else {
            this.logMessage("Unable to trigger LoadXml");
            Controller.getInstance().registerProblem();
            return false;
         }
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new TransitionLoadingXmlFailedException(var3);
      }
   }

   public boolean transitionUnblockLoading() {
      try {
         if(this.mCurrentState == LoadingState$State.STATE_BLOCKED) {
            this.setStateTo(LoadingState$Transition.TRANSITION_UNBLOCKLOADING, LoadingState$State.STATE_IDLE);
            return true;
         } else {
            this.logMessage("Unable to trigger UnblockLoading");
            Controller.getInstance().registerProblem();
            return false;
         }
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new UnblockingLoadingStateFailedException(var3);
      }
   }
}
