import android.os.Build;
import android.os.Build.VERSION;
import com.nuance.nmdp.speechkit.SpeechKit$CmdSetType;
import java.util.Calendar;
import java.util.Locale;

public final class cM {
   private static String[][] t;
   private static int u;
   private static int v;
   private static int w;
   private final String a;
   private final String b;
   private final byte[] c;
   private final String d;
   private final int e;
   private final boolean f;
   private final Object g;
   private final String h;
   private final com.nuance.nmdp.speechkit.recognitionresult.b i;
   private String j;
   private boolean k;
   private String l;
   private String m;
   private String n;
   private String o;
   private String p;
   private String q;
   private String r;
   private SpeechKit$CmdSetType s;

   static {
      String[] var0 = new String[]{"DRAGON_NLU_ASR_CMD", "DRAGON_NLU_DATA_UPLOAD_CMD", "DRAGON_NLU_LOG_REVISION_CMD", "DRAGON_NLU_RESET_USER_PROFILE_CMD", "DRAGON_NLU_APPSERVER_CMD", "ACADIA_GET_DICTATION_LANGUAGE_V2", "DRAGON_NLU_TTS_CMD"};
      t = new String[][]{{"NVC_ASR_CMD", "NVC_DATA_UPLOAD_CMD", "NVC_LOG_REVISION_CMD", "NVC_RESET_USER_PROFILE_CMD", "NVC_APPSERVER_CMD", "NVC_GET_DICTATION_LANGUAGE", "NVC_TTS_CMD"}, var0};
      u = 420611619;
      v = 418947094;
      w = 1434515842;
   }

   public cM(Object var1, String var2, String var3, int var4, String var5, boolean var6, String var7, byte[] var8, SpeechKit$CmdSetType var9) {
      this.a = var7;
      this.b = var2;
      this.c = var8;
      this.d = var3;
      this.e = var4;
      this.f = var6;
      this.g = var1;
      this.j = null;
      this.k = false;
      this.i = new com.nuance.nmdp.speechkit.recognitionresult.b(var1);
      this.h = this.i.c();
      this.l = var5;
      this.s = var9;
      this.b(this.s);
   }

   private void b(SpeechKit$CmdSetType var1) {
      this.m = t[var1.getIndex()][0];
      this.n = t[var1.getIndex()][1];
      this.o = t[var1.getIndex()][2];
      this.p = t[var1.getIndex()][3];
      this.q = t[var1.getIndex()][4];
      String[][] var2 = t;
      var1.getIndex();
      this.r = t[var1.getIndex()][6];
   }

   public static String n() {
      return x.b();
   }

   public static String q() {
      return x.a();
   }

   public final SpeechKit$CmdSetType A() {
      return this.s;
   }

   public final Object a() {
      return this.g;
   }

   public final void a(SpeechKit$CmdSetType var1) {
      this.s = var1;
      this.b(this.s);
   }

   public final byte[] a(byte[] var1) {
      int[] var11 = new int[]{26, 233, 231, 106, 177, 47, 122, 185, 154, 158, 116, 173, 122, 152, 94, 156, 182, 175, 122, 187, 114, 37, 234, 222, 155, 36, 165, 106, 215, 171, 41, 93};
      byte[] var12 = new byte[96];
      com.nuance.nmdp.speechkit.recognitionresult.b var9 = this.i;
      int var2 = Calendar.getInstance().get(13);
      var9 = this.i;
      int var4 = var2 + Calendar.getInstance().get(14) + 1793583386;
      byte[] var13 = this.i.f();
      byte[] var14 = this.i.g();
      int[] var15 = new int[var13.length];
      int[] var10 = new int[var14.length];

      for(var2 = 0; var2 < var15.length; ++var2) {
         var15[var2] = var13[var2];
         if(var15[var2] < 0) {
            var15[var2] += 256;
         }
      }

      for(var2 = 0; var2 < var10.length; ++var2) {
         var10[var2] = var14[var2];
         if(var10[var2] < 0) {
            var10[var2] += 256;
         }
      }

      var2 = var4;
      long var5 = 0L;

      int var3;
      for(var3 = 0; var3 < 32; ++var3) {
         var2 = var2 * (u - v) + w - u;
         if(var15 != null) {
            if(var3 >= var15.length) {
               var15 = null;
            } else {
               var5 = (var5 >> 8) + (long)(var11[var3] + var15[var3] + (var2 & 255));
            }
         } else {
            var5 = (long)var2;
         }

         var12[var3] = (byte)((int)var5);
      }

      var5 = 0L;
      var3 = var2;
      var2 = 0;

      for(var15 = var10; var2 < 64; ++var2) {
         var3 = var3 * (u - v) + w - u;
         if(var15 != null) {
            if(var2 < var15.length && var2 < var11.length) {
               var5 = (var5 >> 8) + (long)(var11[var2] + var15[var2] + (var3 & 255));
            } else {
               var15 = null;
            }
         } else {
            var5 = (long)var3;
         }

         var12[var2 + 32] = (byte)((int)var5);
      }

      var5 = (long)((u - v) * var3 + w - u);
      if(var5 == 0L) {
         var5 = 1L;
      } else {
         var5 &= 127L;
      }

      var2 = 0;

      while(var2 < var12.length) {
         while(true) {
            long var7 = ((var5 >> 6 ^ var5 >> 1 ^ var5 ^ var5 >> 3) & 1L) << 6 | var5 >> 1;
            var5 = var7;
            if(var7 <= (long)var12.length) {
               var5 = var7;
               if(var7 >= 0L) {
                  if(var7 > 26L) {
                     var1[(int)var7 + 3] = var12[var2];
                  } else {
                     var1[(int)var7 - 1] = var12[var2];
                  }

                  ++var2;
                  var5 = var7;
                  break;
               }
            }
         }
      }

      var1[26] = (byte)(var4 & 255);
      var1[27] = (byte)(var4 >> 8 & 255);
      var1[28] = (byte)(var4 >> 16 & 255);
      var1[29] = (byte)(var4 >> 24 & 255);
      return var1;
   }

   public final String b() {
      return this.a;
   }

   public final byte[] c() {
      return this.c;
   }

   public final String d() {
      return this.d;
   }

   public final String e() {
      return this.b;
   }

   public final int f() {
      return this.e;
   }

   public final String g() {
      return this.l;
   }

   public final boolean h() {
      return this.f;
   }

   public final String i() {
      String var2 = this.i.a();
      String var1 = var2;
      if(var2 == null) {
         var1 = "unknown";
      }

      return var1;
   }

   public final String j() {
      String var4;
      label17: {
         com.nuance.nmdp.speechkit.recognitionresult.b var1 = this.i;
         Locale var3 = Locale.getDefault();
         if(var3 != null) {
            var4 = var3.toString();
            if(var4 != null && var4.length() > 0) {
               break label17;
            }
         }

         var4 = null;
      }

      String var2 = var4;
      if(var4 == null) {
         var2 = "unknown";
      }

      return var2;
   }

   public final String k() {
      com.nuance.nmdp.speechkit.recognitionresult.b var1 = this.i;
      String var2 = Build.MODEL;
      String var3 = var2;
      if(var2 == null) {
         var3 = "unknown";
      }

      return var3;
   }

   public final String l() {
      com.nuance.nmdp.speechkit.recognitionresult.b var1 = this.i;
      String var2 = VERSION.RELEASE;
      String var3 = var2;
      if(var2 == null) {
         var3 = "unknown";
      }

      return var3;
   }

   public final String m() {
      String var4;
      label17: {
         com.nuance.nmdp.speechkit.recognitionresult.b var1 = this.i;
         Locale var3 = Locale.getDefault();
         if(var3 != null) {
            var4 = var3.getCountry();
            if(var4 != null && var4.length() > 0) {
               break label17;
            }
         }

         var4 = null;
      }

      String var2 = var4;
      if(var4 == null) {
         var2 = "unknown";
      }

      return var2;
   }

   public final String o() {
      String var2 = this.i.b();
      String var1 = var2;
      if(var2 == null) {
         var1 = "unknown";
      }

      return var1;
   }

   public final String p() {
      return this.h == null?"unknown":this.h;
   }

   public final M r() {
      return this.i.e();
   }

   public final M s() {
      return this.i.d();
   }

   public final String t() {
      if(!this.k) {
         this.k = true;

         try {
            String var4 = this.d;
            int var1 = this.e;
            this.j = be.g();
         } catch (RuntimeException var3) {
            com.nuance.nmdp.speechkit.recognitionresult.b var2 = this.i;
            this.j = null;
         }
      }

      return this.j;
   }

   public final String u() {
      return this.m;
   }

   public final String v() {
      return this.n;
   }

   public final String w() {
      return this.o;
   }

   public final String x() {
      return this.p;
   }

   public final String y() {
      return this.q;
   }

   public final String z() {
      return this.r;
   }
}
