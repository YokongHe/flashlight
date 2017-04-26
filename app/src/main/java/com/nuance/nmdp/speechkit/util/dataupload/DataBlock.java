package com.nuance.nmdp.speechkit.util.dataupload;

import com.nuance.nmdp.speechkit.util.dataupload.Data;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Dictionary;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Sequence;
import java.util.Vector;

public class DataBlock {
   private int a = 0;
   private String b = null;
   private Vector c = new Vector();

   public void addData(Data var1) {
      if(var1 != null) {
         this.c.add(var1);
      }

   }

   public void clearDataBlock() {
      this.c.removeAllElements();
   }

   public int getChecksum() {
      int var2 = 0;

      int var1;
      for(var1 = 0; var2 < this.c.size(); ++var2) {
         Data var3 = (Data)this.c.elementAt(var2);
         if(var3 != null) {
            var1 += var3.getChecksum();
         }
      }

      return var1;
   }

   public PdxValue$Dictionary getDataBlockDictionary() {
      PdxValue$Dictionary var2 = new PdxValue$Dictionary();
      var2.put("delete_all", this.a);
      if(this.b != null) {
         var2.put("common_user_id", this.b);
      }

      if(!this.c.isEmpty()) {
         PdxValue$Sequence var3 = new PdxValue$Sequence();

         for(int var1 = 0; var1 < this.c.size(); ++var1) {
            Data var4 = (Data)this.c.elementAt(var1);
            if(var4 != null) {
               PdxValue$Dictionary var5 = var4.a();
               if(var5 != null) {
                  var3.add((PdxValue)var5);
               }
            }
         }

         var2.put("data_list", var3);
      }

      return var2;
   }

   public Vector getDataList() {
      return this.c;
   }

   public void removeData(Data var1) {
      if(var1 != null) {
         this.c.remove(var1);
      }

   }

   public void setDeleteAll(boolean var1) {
      byte var2;
      if(var1) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      this.a = var2;
   }

   public void setUserId(String var1) {
      this.b = var1;
   }

   public String toString() {
      StringBuffer var3 = new StringBuffer();
      var3.append("delete_all:" + this.a + "\n");
      var3.append("checksum:" + this.getChecksum() + "\n");
      if(!this.c.isEmpty()) {
         int var2 = this.c.size();
         var3.append("data_list: elements " + var2 + "\n");

         for(int var1 = 0; var1 < var2; ++var1) {
            Data var4 = (Data)this.c.elementAt(var1);
            if(var4 != null) {
               var3.append("data: " + var1 + "\n");
               var3.append(var4.toString());
            }
         }
      }

      return var3.toString();
   }
}
