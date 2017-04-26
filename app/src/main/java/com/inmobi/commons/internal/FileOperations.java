package com.inmobi.commons.internal;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.inmobi.commons.internal.Log;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

public class FileOperations {
   public static boolean getBooleanPreferences(Context var0, String var1, String var2) {
      if(var0 != null && var1 != null && var2 != null && !"".equals(var1.trim()) && !"".equals(var2.trim())) {
         return var0.getSharedPreferences(var1, 0).getBoolean(var2, false);
      } else {
         Log.debug("[InMobi]-4.5.2", "Failed to get preferences..App context NULL");
         return false;
      }
   }

   public static int getIntPreferences(Context var0, String var1, String var2) {
      if(var0 != null && var1 != null && var2 != null && !"".equals(var1.trim()) && !"".equals(var2.trim())) {
         return var0.getSharedPreferences(var1, 0).getInt(var2, 0);
      } else {
         Log.debug("[InMobi]-4.5.2", "Failed to get preferences..App context NULL");
         return 0;
      }
   }

   public static long getLongPreferences(Context var0, String var1, String var2) {
      if(var0 != null && var1 != null && var2 != null && !"".equals(var1.trim()) && !"".equals(var2.trim())) {
         return var0.getSharedPreferences(var1, 0).getLong(var2, 0L);
      } else {
         Log.debug("[InMobi]-4.5.2", "Failed to get preferences..App context NULL");
         return 0L;
      }
   }

   public static String getPreferences(Context var0, String var1, String var2) {
      if(var0 != null && var1 != null && var2 != null && !"".equals(var1.trim()) && !"".equals(var2.trim())) {
         return var0.getSharedPreferences(var1, 0).getString(var2, (String)null);
      } else {
         Log.debug("[InMobi]-4.5.2", "Failed to get preferences..App context NULL");
         return null;
      }
   }

   public static boolean isFileExist(Context var0, String var1) {
      boolean var2 = false;
      if((new File(var0.getDir("data", 0), var1)).exists()) {
         var2 = true;
      }

      return var2;
   }

   public static String readFileAsString(Context var0, String var1) {
      File var3 = new File(var0.getCacheDir().getAbsolutePath() + File.separator + var1);
      var3.createNewFile();
      BufferedReader var4 = new BufferedReader(new FileReader(var3));
      StringBuffer var5 = new StringBuffer();

      while(true) {
         String var2 = var4.readLine();
         if(var2 == null) {
            var4.close();
            return var5.length() > 0?var5.substring(1).toString():"";
         }

         var5.append("\n").append(var2);
      }
   }

   public static Object readFromFile(Context var0, String var1) {
      Object var2 = null;
      Object var3 = null;
      if(var0 != null && var1 != null && !"".equals(var1.trim())) {
         File var15 = new File(var0.getDir("data", 0), var1);

         ObjectInputStream var16;
         Object var21;
         label59: {
            FileNotFoundException var20;
            label58: {
               StreamCorruptedException var19;
               label57: {
                  IOException var18;
                  label56: {
                     ClassNotFoundException var17;
                     label55: {
                        label54: {
                           try {
                              var16 = new ObjectInputStream(new FileInputStream(var15));
                           } catch (EOFException var10) {
                              var16 = null;
                              break label54;
                           } catch (FileNotFoundException var11) {
                              var20 = var11;
                              var16 = null;
                              break label58;
                           } catch (StreamCorruptedException var12) {
                              var19 = var12;
                              var16 = null;
                              break label57;
                           } catch (IOException var13) {
                              var18 = var13;
                              var16 = null;
                              break label56;
                           } catch (ClassNotFoundException var14) {
                              var17 = var14;
                              var16 = null;
                              break label55;
                           }

                           try {
                              var21 = var16.readObject();
                              break label59;
                           } catch (EOFException var5) {
                              ;
                           } catch (FileNotFoundException var6) {
                              var20 = var6;
                              break label58;
                           } catch (StreamCorruptedException var7) {
                              var19 = var7;
                              break label57;
                           } catch (IOException var8) {
                              var18 = var8;
                              break label56;
                           } catch (ClassNotFoundException var9) {
                              var17 = var9;
                              break label55;
                           }
                        }

                        Log.internal("[InMobi]-4.5.2", "End of File reached");
                        var21 = var2;
                        break label59;
                     }

                     Log.internal("[InMobi]-4.5.2", "Error: class not found", var17);
                     var21 = var2;
                     break label59;
                  }

                  Log.internal("[InMobi]-4.5.2", "Event log File IO Exception", var18);
                  var21 = var2;
                  break label59;
               }

               Log.internal("[InMobi]-4.5.2", "Event log File corrupted", var19);
               var21 = var2;
               break label59;
            }

            Log.internal("[InMobi]-4.5.2", "Event log File doesnot exist", var20);
            var21 = var2;
         }

         var2 = var21;
         if(var16 != null) {
            try {
               var16.close();
               return var21;
            } catch (IOException var4) {
               Log.internal("[InMobi]-4.5.2", "Log File Close Exception");
               return Boolean.valueOf(false);
            }
         }
      } else {
         Log.internal("[InMobi]-4.5.2", "Cannot read map application context or Filename NULL");
         var2 = var3;
      }

      return var2;
   }

   public static boolean saveToFile(Context var0, String var1, Object var2) {
      if(var0 != null && var1 != null && !"".equals(var1.trim()) && var2 != null) {
         File var6 = new File(var0.getDir("data", 0), var1);

         ObjectOutputStream var7;
         try {
            var7 = new ObjectOutputStream(new FileOutputStream(var6, false));
            var7.writeObject(var2);
            var7.flush();
         } catch (FileNotFoundException var4) {
            Log.internal("[InMobi]-4.5.2", "Log File Not found", var4);
            return false;
         } catch (IOException var5) {
            Log.internal("[InMobi]-4.5.2", "Log File IO Exception", var5);
            return false;
         }

         try {
            var7.close();
            return true;
         } catch (IOException var3) {
            Log.internal("[InMobi]-4.5.2", "Log File Close Exception");
            return false;
         }
      } else {
         Log.internal("[InMobi]-4.5.2", "Cannot read map application context of Filename NULL");
         return false;
      }
   }

   public static void setPreferences(Context var0, String var1, String var2, float var3) {
      if(var0 != null && var1 != null && var2 != null && !"".equals(var1.trim()) && !"".equals(var2.trim())) {
         Editor var4 = var0.getSharedPreferences(var1, 0).edit();
         var4.putFloat(var2, var3);
         var4.commit();
      } else {
         Log.debug("[InMobi]-4.5.2", "Failed to set preferences..App context NULL");
      }
   }

   public static void setPreferences(Context var0, String var1, String var2, int var3) {
      if(var0 != null && var1 != null && var2 != null && !"".equals(var1.trim()) && !"".equals(var2.trim())) {
         Editor var4 = var0.getSharedPreferences(var1, 0).edit();
         var4.putInt(var2, var3);
         var4.commit();
      } else {
         Log.debug("[InMobi]-4.5.2", "Failed to set preferences..App context NULL");
      }
   }

   public static void setPreferences(Context var0, String var1, String var2, long var3) {
      if(var0 != null && var1 != null && var2 != null && !"".equals(var1.trim()) && !"".equals(var2.trim())) {
         Editor var5 = var0.getSharedPreferences(var1, 0).edit();
         var5.putLong(var2, var3);
         var5.commit();
      } else {
         Log.debug("[InMobi]-4.5.2", "Failed to set preferences..App context NULL");
      }
   }

   public static void setPreferences(Context var0, String var1, String var2, boolean var3) {
      if(var0 != null && var1 != null && var2 != null && !"".equals(var1.trim()) && !"".equals(var2.trim())) {
         Editor var4 = var0.getSharedPreferences(var1, 0).edit();
         var4.putBoolean(var2, var3);
         var4.commit();
      } else {
         Log.debug("[InMobi]-4.5.2", "Failed to set preferences..App context NULL");
      }
   }

   public static boolean setPreferences(Context var0, String var1, String var2, String var3) {
      if(var0 != null && var1 != null && var2 != null && !"".equals(var1.trim()) && !"".equals(var2.trim())) {
         Editor var4 = var0.getSharedPreferences(var1, 0).edit();
         var4.putString(var2, var3);
         var4.commit();
         return true;
      } else {
         Log.internal("[InMobi]-4.5.2", "Failed to set preferences..App context NULL");
         return false;
      }
   }

   public static void writeStringToFile(Context var0, String var1, String var2, boolean var3) {
      File var4 = new File(var0.getCacheDir().getAbsolutePath() + File.separator + var1);
      var4.createNewFile();
      BufferedWriter var5 = new BufferedWriter(new FileWriter(var4, var3));
      var5.write(var2);
      var5.close();
   }
}
