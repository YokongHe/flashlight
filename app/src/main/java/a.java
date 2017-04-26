import android.os.Handler;

public abstract class a {
   protected final Object a;
   private final Handler b;

   public a(Object var1) {
      this.b = (Handler)var1;
      this.a = new Object();
   }

   protected final void a(Runnable var1) {
      if(this.b == null) {
         try {
            var1.run();
         } catch (Throwable var3) {
            com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Exception in application callback", var3);
            return;
         }
      } else {
         try {
            if(!this.b.post(var1)) {
               com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Unable to post callback to handler");
               return;
            }
         } catch (Throwable var2) {
            com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Exception posting callback to handler", var2);
            return;
         }
      }

   }
}
