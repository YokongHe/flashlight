package com.nuance.nmdp.speechkit.util.dataupload;

import com.nuance.nmdp.speechkit.util.dataupload.Action;
import com.nuance.nmdp.speechkit.util.dataupload.Data$DataType;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Dictionary;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Sequence;
import java.util.Vector;

public class Data {
   private String a;
   private int b;
   private Data$DataType c;
   private Vector d;

   public Data(String var1, Data$DataType var2) {
      this.a = var1;
      this.b = 0;
      if(var2 != Data$DataType.CONTACTS && var2 != Data$DataType.CUSTOMWORDS && var2 != Data$DataType.HISTORY) {
         this.c = Data$DataType.CONTACTS;
      } else {
         this.c = var2;
      }

      this.d = new Vector();
   }

   final PdxValue$Dictionary a() {
      PdxValue$Dictionary var2;
      label35: {
         var2 = new PdxValue$Dictionary();
         var2.put("id", this.a);
         if(this.c != null) {
            switch(null.a[this.c.ordinal()]) {
            case 1:
               var2.put("type", "contacts");
               break label35;
            case 2:
               var2.put("type", "custom_words");
               break label35;
            case 3:
               var2.put("type", "history");
               break label35;
            }
         }

         var2.put("type", "contacts");
      }

      if(!this.d.isEmpty()) {
         PdxValue$Sequence var3 = new PdxValue$Sequence();

         for(int var1 = 0; var1 < this.d.size(); ++var1) {
            Action var4 = (Action)this.d.elementAt(var1);
            if(var4 != null) {
               PdxValue$Dictionary var5 = var4.a();
               if(var5 != null) {
                  var3.add((PdxValue)var5);
               }
            }
         }

         var2.put("actions", var3);
      }

      return var2;
   }

   public void addAction(Action var1) {
      if(var1 != null) {
         this.d.add(var1);
      }

   }

   public void clearActions() {
      this.d.removeAllElements();
   }

   public void clearData() {
      this.a = null;
      this.b = 0;
      this.c = null;
      this.d.removeAllElements();
   }

   public int getChecksum() {
      int var2 = 0;

      int var1;
      for(var1 = 0; var2 < this.d.size(); ++var2) {
         Action var3 = (Action)this.d.elementAt(var2);
         if(var3 != null) {
            var1 += var3.getChecksum();
         }
      }

      this.b = var1;
      return var1;
   }

   public String getId() {
      return this.a;
   }

   public String getTypeStr() {
      if(this.c == null) {
         return "contacts";
      } else {
         switch(null.a[this.c.ordinal()]) {
         case 1:
            return "contacts";
         case 2:
            return "custom_words";
         case 3:
            return "history";
         default:
            return "contacts";
         }
      }
   }

   public void removeAction(Action var1) {
      if(var1 != null) {
         this.d.remove(var1);
      }

   }

   public void setType(Data$DataType var1) {
      if(var1 != Data$DataType.CONTACTS && var1 != Data$DataType.CUSTOMWORDS && var1 != Data$DataType.HISTORY) {
         this.c = Data$DataType.CONTACTS;
      } else {
         this.c = var1;
      }
   }

   public String toString() {
      StringBuffer var3 = new StringBuffer();
      var3.append("id:" + this.a + "\n");
      var3.append("checksum:" + this.b + "\n");
      var3.append("type:" + this.c + "\n");
      if(!this.d.isEmpty()) {
         int var2 = this.d.size();
         var3.append("action list: " + var2 + "\n");

         for(int var1 = 0; var1 < var2; ++var1) {
            Action var4 = (Action)this.d.elementAt(var1);
            if(var4 != null) {
               var3.append("action: " + var1 + "\n");
               var3.append(var4.toString());
            }
         }
      }

      return var3.toString();
   }
}
