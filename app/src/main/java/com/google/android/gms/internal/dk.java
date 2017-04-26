package com.google.android.gms.internal;

import com.google.android.gms.internal.di;
import com.google.android.gms.internal.dl;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class dk {
   private final di a;
   private final SecureRandom b;

   public dk(di var1, SecureRandom var2) {
      this.a = var1;
      this.b = null;
   }

   public final byte[] a(String param1) {
      // $FF: Couldn't be decompiled
   }

   public final byte[] a(byte[] var1, String var2) {
      if(var1.length != 16) {
         throw new dl(this);
      } else {
         try {
            byte[] var3 = this.a.a(var2, false);
            if(var3.length <= 16) {
               throw new dl(this);
            } else {
               ByteBuffer var4 = ByteBuffer.allocate(var3.length);
               var4.put(var3);
               var4.flip();
               byte[] var13 = new byte[16];
               var3 = new byte[var3.length - 16];
               var4.get(var13);
               var4.get(var3);
               SecretKeySpec var12 = new SecretKeySpec(var1, "AES");
               Cipher var14 = Cipher.getInstance("AES/CBC/PKCS5Padding");
               var14.init(2, var12, new IvParameterSpec(var13));
               var1 = var14.doFinal(var3);
               return var1;
            }
         } catch (NoSuchAlgorithmException var5) {
            throw new dl(this, var5);
         } catch (InvalidKeyException var6) {
            throw new dl(this, var6);
         } catch (IllegalBlockSizeException var7) {
            throw new dl(this, var7);
         } catch (NoSuchPaddingException var8) {
            throw new dl(this, var8);
         } catch (BadPaddingException var9) {
            throw new dl(this, var9);
         } catch (InvalidAlgorithmParameterException var10) {
            throw new dl(this, var10);
         } catch (IllegalArgumentException var11) {
            throw new dl(this, var11);
         }
      }
   }
}
