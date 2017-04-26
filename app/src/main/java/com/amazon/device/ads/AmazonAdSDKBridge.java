package com.amazon.device.ads;

import com.amazon.device.ads.AdControlAccessor;
import com.amazon.device.ads.AdSDKBridge;
import com.amazon.device.ads.AmazonAdSDKBridge$AmazonAdSDKEventListener;
import com.amazon.device.ads.AmazonAdSDKBridge$EnableCloseButtonJSIF;
import com.amazon.device.ads.AmazonAdSDKBridge$OverrideBackButtonJSIF;
import com.amazon.device.ads.JavascriptInteractor;
import com.amazon.device.ads.JavascriptInteractor$Executor;
import com.amazon.device.ads.SDKEventListener;

class AmazonAdSDKBridge implements AdSDKBridge {
   private static final String BRIDGE_NAME = "amazonObject";
   private static final String JAVASCRIPT = "(function (window, console){\n    var version = \'1.0\',\n    debug = function(msg) {\n        console.log(\"Amazon Javascript log: \" + msg);\n    },\n    is_array = function (obj) {\n        return Object.prototype.toString.call(obj) === \'[object Array]\';\n    },\n    forEach = function (array, fn) {\n        var i;\n        for (i = 0; i < array.length; i++) {\n            if (i in array) {\n                fn.call(null, array[i], i);\n            }\n        }\n    },\n    listeners = [],\n    events = {\n        backButton: \'backButton\'\n    },\n    invokeListeners = function(event, args) {\n        var eventListeners = listeners[event] || [];\n        // fire all the listeners\n        forEach(eventListeners, function(listener){\n            try {\n                listener.apply(null, args);\n            }catch(e){\n                debug(\"Error executing \" + event + \" listener\");\n                debug(e);\n            }\n        });\n    },\n    backButtonEvent = function() {\n        invokeListeners(\"backButton\");\n    };\n    window.amazonBridge = {\n        backButton : backButtonEvent\n    };\n    window.amazon = {\n        // Command Flow\n        addEventListener : function(event, listener){\n            var eventListeners = listeners[event] || [],\n            alreadyRegistered = false;\n            \n            //verify the event is one that will actually occur\n            if (!events.hasOwnProperty(event)){\n                return;\n            }\n            \n            //register first set of listeners for this event\n            if (!is_array(listeners[event])) {\n                listeners[event] = eventListeners;\n            }\n            \n            forEach(eventListeners, function(l){ \n                // Listener already registered, so no need to add it.\n                    if (listener === l){\n                        alreadyRegistered = true;\n                    }\n                }\n            );\n            if (!alreadyRegistered){\n                listeners[event].push(listener);\n            }\n        },\n        removeEventListener : function(event, listener){\n            if (listeners.hasOwnProperty(event)) {\n                var eventListeners = listeners[event];\n                if (eventListeners) {\n                    var idx = eventListeners.indexOf(listener);\n                    if (idx !== -1) {\n                        eventListeners.splice(idx, 1);\n                    }\n                }\n            }\n        },\n        enableCloseButton: function(enable){\n            amazonObject." + JavascriptInteractor.getExecutorMethodName() + "(\"EnableCloseButton\", JSON.stringify({\"enable\": enable}));\n        },\n" + "        overrideBackButton: function(override){\n            amazonObject." + JavascriptInteractor.getExecutorMethodName() + "(\"OverrideBackButton\", JSON.stringify({\"override\": override}));\n        },\n" + "        getVersion: function(){\n            return version;\n" + "        },\n    };\n" + "})(window, console);";
   private final AdControlAccessor adControlAccessor;
   private final JavascriptInteractor javascriptInteractor;
   private final AmazonAdSDKBridge$AmazonAdSDKEventListener listener = new AmazonAdSDKBridge$AmazonAdSDKEventListener(this);

   public AmazonAdSDKBridge(AdControlAccessor var1, JavascriptInteractor var2) {
      this.adControlAccessor = var1;
      this.javascriptInteractor = var2;
      this.javascriptInteractor.addMethodExecutor(new AmazonAdSDKBridge$EnableCloseButtonJSIF(this));
      this.javascriptInteractor.addMethodExecutor(new AmazonAdSDKBridge$OverrideBackButtonJSIF(this));
   }

   // $FF: synthetic method
   static void access$000(AmazonAdSDKBridge var0) {
      var0.onBackButton();
   }

   // $FF: synthetic method
   static void access$100(AmazonAdSDKBridge var0, boolean var1) {
      var0.enableCloseButton(var1);
   }

   // $FF: synthetic method
   static void access$200(AmazonAdSDKBridge var0, boolean var1) {
      var0.overrideBackButton(var1);
   }

   private void enableCloseButton(boolean var1) {
      if(var1) {
         this.adControlAccessor.enableCloseButton(true);
      } else {
         this.adControlAccessor.removeCloseButton();
      }
   }

   private void onBackButton() {
      this.adControlAccessor.injectJavascript("amazonBridge.backButton();");
   }

   private void overrideBackButton(boolean var1) {
      this.adControlAccessor.overrideBackButton(var1);
   }

   public String getJavascript() {
      return JAVASCRIPT;
   }

   public JavascriptInteractor$Executor getJavascriptInteractorExecutor() {
      return this.javascriptInteractor.getExecutor();
   }

   public String getName() {
      return "amazonObject";
   }

   public SDKEventListener getSDKEventListener() {
      return this.listener;
   }

   public boolean hasNativeExecution() {
      return true;
   }
}
