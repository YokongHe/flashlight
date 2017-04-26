import java.io.ByteArrayOutputStream;

public class by extends bD implements ah, bd {
   private static final ae a = bh.a(by.class);
   private int b;
   private bu c;
   private boolean d = false;
   private af e;

   public by(String var1, bu var2, af var3) {
      super(var1, (byte)1);
      this.c = var2;
      this.e = var3;
      this.b = var2.c();
      ag var4 = new ag((byte)1, (Object)null);
      Thread var5 = Thread.currentThread();
      var3.a();
      var3.a(var4, this, var5);
   }

   protected final int a() {
      return this.b;
   }

   public final void a(Object var1, Object var2) {
      ag var4 = (ag)var1;
      switch(var4.a) {
      case 1:
         this.c.a(this.b);
         return;
      case 2:
         Object[] var6 = (Object[])var4.b;
         byte[] var5 = (byte[])var6[0];
         boolean var3 = ((Boolean)var6[1]).booleanValue();
         if(var5 != null) {
            if(ax.b(this.c.i())) {
               ByteArrayOutputStream var7 = new ByteArrayOutputStream();
               if(var5.length < 128) {
                  var7.write(var5.length & 127);
               } else if(var5.length < 16384) {
                  var7.write(var5.length >> 7 & 127 | 128);
                  var7.write(var5.length & 127);
               } else if(var5.length < 2097152) {
                  var7.write(var5.length >> 14 & 127 | 128);
                  var7.write(var5.length >> 7 & 127 | 128);
                  var7.write(var5.length & 127);
               } else {
                  if(var5.length >= 268435456) {
                     a.e("buffer size is too big!");
                     return;
                  }

                  var7.write(var5.length >> 21 & 127 | 128);
                  var7.write(var5.length >> 14 & 127 | 128);
                  var7.write(var5.length >> 7 & 127 | 128);
                  var7.write(var5.length & 127);
               }

               var7.write(var5, 0, var5.length);
               this.c.a(var7.toByteArray(), this.b);
            } else {
               this.c.a(var5, this.b);
            }
         }

         if(var3) {
            this.c.b(this.b);
            return;
         }
      default:
      }
   }

   public final void a(byte[] var1, int var2, int var3, boolean var4) {
      if(var1 == null && !var4) {
         a.e("PDXAudioParam.addAudioBuf() in (NMSPAudioSink)PDXAudioParam.addAudioBuf(), the param \"buffer\" is null.");
         throw new NullPointerException("in (NMSPAudioSink)PDXAudioParam.addAudioBuf(), the param \"buffer\" is null.");
      } else if(var1 != null && var2 < 0) {
         a.e("PDXAudioParam.addAudioBuf() the offset of the \"buffer\" is less than 0");
         throw new IllegalArgumentException("the offset of the \"buffer\" is less than 0");
      } else if(var1 != null && var3 <= 0) {
         a.e("PDXAudioParam.addAudioBuf() the indicated length of the \"buffer\" is less than 1 byte");
         throw new IllegalArgumentException("the indicated length of the \"buffer\" is less than 1 byte");
      } else if(this.d) {
         a.e("PDXAudioParam.addAudioBuf() last audio buffer already added!");
         throw new bk("last audio buffer already added!");
      } else {
         if(var4) {
            this.d = true;
         }

         byte[] var5 = null;
         if(var1 != null) {
            var5 = new byte[var3];
            System.arraycopy(var1, var2, var5, 0, var3);
         }

         Boolean var6 = new Boolean(var4);
         af var7 = this.e;
         ag var8 = new ag((byte)2, new Object[]{var5, var6});
         Thread var9 = Thread.currentThread();
         this.e.a();
         var7.a(var8, this, var9);
      }
   }
}
