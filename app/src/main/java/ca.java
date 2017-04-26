import android.bluetooth.BluetoothDevice;
import android.content.Context;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class ca {
   public static final String a;
   public static final String b;
   public static final int c;
   private static final Constructor d;
   private static final Method e;
   private static final Method f;
   private static final Method g;
   private static final Method h;
   private static final Class i;
   private Object j;
   private cb k;

   static {
      new cd();
      Class var0 = cd.a("android.bluetooth.BluetoothHeadset");
      Class var1 = cd.a("android.bluetooth.BluetoothHeadset$ServiceListener");
      d = cd.a(var0, new Class[]{Context.class, var1});
      if(cd.b(var0, "getState", new Class[0]) == null) {
         cd.a(var0, "getState", new Class[]{BluetoothDevice.class});
      }

      g = cd.a(var0, "getCurrentHeadset", new Class[0]);
      cd.a(var0, "connectHeadset", new Class[]{BluetoothDevice.class});
      if(cd.b(var0, "disconnectHeadset", new Class[0]) == null) {
         cd.a(var0, "disconnectHeadset", new Class[]{BluetoothDevice.class});
      }

      e = cd.a(var0, "startVoiceRecognition", new Class[0]);
      f = cd.a(var0, "stopVoiceRecognition", new Class[0]);
      h = cd.a(var0, "close", new Class[0]);
      cd.a(var0, "getPriority", new Class[]{BluetoothDevice.class});
      cd.a(var0, "setPriority", new Class[]{BluetoothDevice.class, Integer.TYPE});
      i = var1;
      cd.a(var0, "ACTION_STATE_CHANGED");
      a = (String)cd.a(var0, "ACTION_AUDIO_STATE_CHANGED");
      cd.a(var0, "EXTRA_STATE");
      b = (String)cd.a(var0, "EXTRA_AUDIO_STATE");
      cd.a(var0, "STATE_ERROR");
      cd.a(var0, "STATE_DISCONNECTED");
      cd.a(var0, "STATE_CONNECTING");
      cd.a(var0, "STATE_CONNECTED");
      cd.a(var0, "AUDIO_STATE_DISCONNECTED");
      c = ((Integer)cd.a(var0, "AUDIO_STATE_CONNECTED")).intValue();
      cd.a(var0, "PRIORITY_OFF");
      cd.a(var0, "PRIORITY_UNDEFINED", (Object)Integer.valueOf(-1));
   }

   public ca(Context var1, cb var2) {
      this.k = var2;
      ClassLoader var6 = this.getClass().getClassLoader();
      Class var3 = i;
      InvocationHandler var4 = new InvocationHandler() {
         // $FF: synthetic field
         private ca a = ca.this;

         public final Object invoke(Object var1, Method var2, Object[] var3) {
            if(var2.getName().equals("onServiceConnected")) {
               if(this.a.k != null) {
                  this.a.k.a();
               }
            } else if(var2.getName().equals("onServiceDisconnected") && this.a.k != null) {
               this.a.k.b();
            }

            return null;
         }
      };
      Object var7 = Proxy.newProxyInstance(var6, new Class[]{var3}, var4);

      try {
         this.j = d.newInstance(new Object[]{var1, var7});
      } catch (Exception var5) {
         var5.printStackTrace();
      }
   }

   public final BluetoothDevice a() {
      try {
         if(g != null) {
            BluetoothDevice var1 = (BluetoothDevice)g.invoke(this.j, new Object[0]);
            return var1;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
      }

      return null;
   }

   public final boolean b() {
      try {
         boolean var1 = ((Boolean)e.invoke(this.j, new Object[0])).booleanValue();
         return var1;
      } catch (Exception var3) {
         var3.printStackTrace();
         return false;
      }
   }

   public final boolean c() {
      try {
         boolean var1 = ((Boolean)f.invoke(this.j, new Object[0])).booleanValue();
         return var1;
      } catch (Exception var3) {
         var3.printStackTrace();
         return false;
      }
   }

   public final void d() {
      try {
         h.invoke(this.j, new Object[0]);
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }
}
