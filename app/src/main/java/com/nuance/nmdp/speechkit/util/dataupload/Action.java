package com.nuance.nmdp.speechkit.util.dataupload;

import com.nuance.nmdp.speechkit.util.dataupload.Action$ActionType;
import com.nuance.nmdp.speechkit.util.dataupload.Contact;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Dictionary;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Sequence;
import java.util.Vector;

public class Action {
   private Action$ActionType a;
   private Vector b;
   private Vector c;

   public Action(Action$ActionType var1) {
      if(var1 != Action$ActionType.ADD && var1 != Action$ActionType.REMOVE && var1 != Action$ActionType.CLEARALL) {
         this.a = Action$ActionType.ADD;
      } else {
         this.a = var1;
      }

      this.b = new Vector();
      this.c = new Vector();
   }

   final PdxValue$Dictionary a() {
      PdxValue$Dictionary var2;
      PdxValue$Dictionary var3;
      label51: {
         var2 = new PdxValue$Dictionary();
         var3 = new PdxValue$Dictionary();
         if(this.a != null) {
            switch(null.a[this.a.ordinal()]) {
            case 1:
               var2.put("action", "add");
               break label51;
            case 2:
               var2.put("action", "remove");
               break label51;
            case 3:
               var2.put("action", "clear_all");
               break label51;
            }
         }

         var2.put("action", "add");
      }

      int var1;
      PdxValue$Sequence var4;
      if(!this.b.isEmpty()) {
         var4 = new PdxValue$Sequence();

         for(var1 = 0; var1 < this.b.size(); ++var1) {
            Contact var5 = (Contact)this.b.elementAt(var1);
            if(var5 != null) {
               PdxValue$Dictionary var6 = var5.a();
               if(var6 != null) {
                  var4.add((PdxValue)var6);
               }
            }
         }

         var3.put("list", var4);
      } else if(!this.c.isEmpty()) {
         var4 = new PdxValue$Sequence();

         for(var1 = 0; var1 < this.c.size(); ++var1) {
            String var7 = (String)this.c.elementAt(var1);
            if(var7 != null) {
               var4.add(var7);
            }
         }

         var3.put("list", var4);
      }

      var2.put("content", var3);
      return var2;
   }

   public void addContact(Contact var1) {
      this.b.add(var1);
   }

   public void addWord(String var1) {
      this.c.add(var1);
   }

   public void cleanData() {
      this.a = null;
      this.b.removeAllElements();
      this.c.removeAllElements();
   }

   public void clearContacts() {
      this.b.removeAllElements();
   }

   public void clearWords() {
      this.c.removeAllElements();
   }

   public int getChecksum() {
      byte var5 = 0;
      int var3 = 0;
      int var1 = 0;

      while(true) {
         int var2 = var1;
         int var4 = var5;
         if(var3 >= this.b.size()) {
            while(var4 < this.c.size()) {
               String var7 = (String)this.c.elementAt(var4);
               if(var7 != null) {
                  var1 = var7.hashCode() + var2;
               } else {
                  var1 = var2;
               }

               ++var4;
               var2 = var1;
            }

            return var2;
         }

         Contact var6 = (Contact)this.b.elementAt(var3);
         if(var6 != null) {
            var1 += var6.getCheckSum();
         }

         ++var3;
      }
   }

   public void removeContact(Contact var1) {
      this.b.remove(var1);
   }

   public void removeWord(String var1) {
      this.c.remove(var1);
   }

   public void setType(Action$ActionType var1) {
      if(var1 != Action$ActionType.ADD && var1 != Action$ActionType.REMOVE && var1 != Action$ActionType.CLEARALL) {
         this.a = Action$ActionType.ADD;
      } else {
         this.a = var1;
      }
   }

   public String toString() {
      byte var2 = 0;
      StringBuffer var4 = new StringBuffer();
      var4.append("action:" + this.a + "\n");
      int var1;
      int var3;
      if(!this.b.isEmpty()) {
         var3 = this.b.size();
         var4.append("contact list: " + var3 + "\n");

         for(var1 = 0; var1 < var3; ++var1) {
            Contact var5 = (Contact)this.b.elementAt(var1);
            if(var5 != null) {
               var4.append("contact: " + var1 + "\n");
               var4.append(var5.toString());
            }
         }
      }

      if(!this.c.isEmpty()) {
         var3 = this.c.size();
         var4.append("word list: " + var3 + "\n");

         for(var1 = var2; var1 < var3; ++var1) {
            String var6 = (String)this.c.elementAt(var1);
            if(var6 != null) {
               var4.append("word: " + var1 + " " + var6 + "\n");
            }
         }
      }

      return var4.toString();
   }
}
