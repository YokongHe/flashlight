package com.inmobi.commons.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.inmobi.commons.internal.Base64;
import com.inmobi.commons.internal.EncryptionUtils$a;
import com.inmobi.commons.internal.EncryptionUtils$b;
import com.inmobi.commons.internal.EncryptionUtils$c;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;

public class EncryptionUtils {
   private static byte[] a = new byte[16];
   private static String b = "SHA1PRNG";
   private static String c = "Crypto";
   private static String d = "HmacSHA1";
   private static String e = "RSA";
   private static String f = "RSA/ECB/nopadding";
   private static String g = "aeskeygenerate";
   private static String h = "last_key_generate";
   private static String i = "AES/CBC/PKCS7Padding";
   private static String j = "AES";

   public static byte[] DeAe(byte[] var0, byte[] var1, byte[] var2) {
      return b(var0, var1, var2);
   }

   public static String SeMeGe(String var0, byte[] var1, byte[] var2, byte[] var3, String var4, String var5) {
      return a(var0, var1, var2, var3, var4, var5);
   }

   private static String a(String var0, byte[] var1, byte[] var2, byte[] var3, String var4, String var5) {
      try {
         byte[] var8 = a(var0.getBytes("UTF-8"), var1, var2);
         byte[] var6 = a(var8, var3);
         var8 = a(var8);
         var6 = a(var6);
         var2 = a(var2);
         var0 = new String(Base64.encode(b(a(a(b(b(a(var1), a(var3)), var2), var5, var4)), b(var8, var6)), 8));
         return var0;
      } catch (Exception var7) {
         var7.printStackTrace();
         return null;
      }
   }

   private static byte[] a() {
      try {
         SecureRandom.getInstance(b, c).nextBytes(a);
      } catch (NoSuchAlgorithmException var1) {
         Log.internal("[InMobi]-4.5.2", "NoSuchAlgorithmException");
      } catch (NoSuchProviderException var2) {
         Log.internal("[InMobi]-4.5.2", "NoSuchProviderException");
      }

      return a;
   }

   private static byte[] a(byte[] var0) {
      long var1 = (long)var0.length;
      ByteBuffer var3 = ByteBuffer.allocate(8);
      var3.order(ByteOrder.LITTLE_ENDIAN);
      var3.putLong(var1);
      byte[] var5 = var3.array();
      byte[] var4 = new byte[var5.length + var0.length];
      System.arraycopy(var5, 0, var4, 0, var5.length);
      System.arraycopy(var0, 0, var4, var5.length, var0.length);
      return var4;
   }

   private static byte[] a(byte[] var0, String var1, String var2) {
      BigInteger var11 = new BigInteger(var2, 16);
      BigInteger var9 = new BigInteger(var1, 16);

      try {
         RSAPublicKey var10 = (RSAPublicKey)KeyFactory.getInstance(e).generatePublic(new EncryptionUtils$b(var11, var9));
         Cipher var12 = Cipher.getInstance(f);
         var12.init(1, var10);
         var0 = var12.doFinal(var0);
         return var0;
      } catch (NoSuchAlgorithmException var3) {
         Log.internal("[InMobi]-4.5.2", "NoSuchAlgorithmException");
         return null;
      } catch (InvalidKeySpecException var4) {
         Log.internal("[InMobi]-4.5.2", "InvalidKeySpecException");
         return null;
      } catch (NoSuchPaddingException var5) {
         Log.internal("[InMobi]-4.5.2", "NoSuchPaddingException");
         return null;
      } catch (InvalidKeyException var6) {
         Log.internal("[InMobi]-4.5.2", "InvalidKeyException");
         return null;
      } catch (IllegalBlockSizeException var7) {
         Log.internal("[InMobi]-4.5.2", "IllegalBlockSizeException");
         return null;
      } catch (BadPaddingException var8) {
         Log.internal("[InMobi]-4.5.2", "BadPaddingException");
         return null;
      }
   }

   private static byte[] a(byte[] var0, byte[] var1) {
      EncryptionUtils$c var5 = new EncryptionUtils$c(var1, 0, var1.length, d);

      try {
         Mac var2 = Mac.getInstance(d);
         var2.init(var5);
         var0 = var2.doFinal(var0);
         return var0;
      } catch (NoSuchAlgorithmException var3) {
         Log.internal("[InMobi]-4.5.2", "NoSuchAlgorithmException");
         return null;
      } catch (InvalidKeyException var4) {
         Log.internal("[InMobi]-4.5.2", "InvalidKeyException");
         return null;
      }
   }

   private static byte[] a(byte[] var0, byte[] var1, byte[] var2) {
      EncryptionUtils$c var10 = new EncryptionUtils$c(var1, j);
      EncryptionUtils$a var11 = new EncryptionUtils$a(var2);

      try {
         Cipher var3 = Cipher.getInstance(i);
         var3.init(1, var10, var11);
         var0 = var3.doFinal(var0);
         return var0;
      } catch (NoSuchAlgorithmException var4) {
         Log.internal("[InMobi]-4.5.2", "NoSuchAlgorithmException");
         return null;
      } catch (NoSuchPaddingException var5) {
         Log.internal("[InMobi]-4.5.2", "NoSuchPaddingException");
         return null;
      } catch (InvalidKeyException var6) {
         Log.internal("[InMobi]-4.5.2", "InvalidKeyException");
         return null;
      } catch (IllegalBlockSizeException var7) {
         Log.internal("[InMobi]-4.5.2", "IllegalBlockSizeException");
         return null;
      } catch (BadPaddingException var8) {
         Log.internal("[InMobi]-4.5.2", "BadPaddingException");
         return null;
      } catch (InvalidAlgorithmParameterException var9) {
         Log.internal("[InMobi]-4.5.2", "InvalidAlgorithmParameterException");
         return null;
      }
   }

   private static byte[] b() {
      SharedPreferences var2 = InternalSDKUtil.getContext().getSharedPreferences(g, 0);
      long var0 = var2.getLong(h, 0L);
      Editor var3;
      if(0L == var0) {
         Log.internal("[InMobi]-4.5.2", "Generating for first time");
         var3 = var2.edit();
         var3.putLong(h, System.currentTimeMillis());
         var3.commit();
         return a();
      } else if(var0 + 86400000L - System.currentTimeMillis() <= 0L) {
         Log.internal("[InMobi]-4.5.2", "generated again");
         var3 = var2.edit();
         var3.putLong(h, System.currentTimeMillis());
         var3.commit();
         return a();
      } else {
         Log.internal("[InMobi]-4.5.2", "already generated");
         return a;
      }
   }

   private static byte[] b(byte[] var0, byte[] var1) {
      byte[] var2 = new byte[var0.length + var1.length];
      System.arraycopy(var0, 0, var2, 0, var0.length);
      System.arraycopy(var1, 0, var2, var0.length, var1.length);
      return var2;
   }

   private static byte[] b(byte[] var0, byte[] var1, byte[] var2) {
      EncryptionUtils$c var10 = new EncryptionUtils$c(var1, j);

      try {
         Cipher var3 = Cipher.getInstance(i);
         var3.init(2, var10, new EncryptionUtils$a(var2));
         var0 = var3.doFinal(var0);
         return var0;
      } catch (NoSuchAlgorithmException var4) {
         Log.internal("[InMobi]-4.5.2", "NoSuchAlgorithmException");
         return null;
      } catch (NoSuchPaddingException var5) {
         Log.internal("[InMobi]-4.5.2", "NoSuchPaddingException");
         return null;
      } catch (InvalidKeyException var6) {
         Log.internal("[InMobi]-4.5.2", "InvalidKeyException");
         return null;
      } catch (IllegalBlockSizeException var7) {
         Log.internal("[InMobi]-4.5.2", "IllegalBlockSizeException");
         return null;
      } catch (BadPaddingException var8) {
         Log.internal("[InMobi]-4.5.2", "BadPaddingException");
         return null;
      } catch (InvalidAlgorithmParameterException var9) {
         Log.internal("[InMobi]-4.5.2", "InvalidAlgorithmParameterException");
         return null;
      }
   }

   public static byte[] generateKey(int var0) {
      try {
         byte[] var1 = new byte[var0];
         (new SecureRandom()).nextBytes(var1);
         return var1;
      } catch (Exception var2) {
         var2.printStackTrace();
         return null;
      }
   }

   public static byte[] keag() {
      return b();
   }
}
