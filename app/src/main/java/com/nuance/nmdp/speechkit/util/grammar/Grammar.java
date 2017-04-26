package com.nuance.nmdp.speechkit.util.grammar;

import com.nuance.nmdp.speechkit.util.grammar.Grammar$GrammarType;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Dictionary;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Sequence;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Grammar {
   private Grammar$GrammarType a;
   private String b;
   private int c;
   private boolean d;
   private boolean e = false;
   private int f;
   private boolean g = false;
   private String h;
   private String i;
   private String j;
   private String k;
   private Vector l;

   public Grammar(Grammar$GrammarType var1, String var2) {
      this.b = var2;
      if(var1 != Grammar$GrammarType.CONTACTS && var1 != Grammar$GrammarType.CUSTOMWORDS && var1 != Grammar$GrammarType.HISTORY && var1 != Grammar$GrammarType.URI && var1 != Grammar$GrammarType.PREDEFINED_STATIC_GRAMMARS && var1 != Grammar$GrammarType.INSTANT_ITEM_LIST) {
         this.a = Grammar$GrammarType.CONTACTS;
      } else {
         this.a = var1;
      }

      if(this.a == Grammar$GrammarType.INSTANT_ITEM_LIST) {
         this.l = new Vector();
      }

   }

   public Grammar(Grammar$GrammarType var1, String var2, int var3) {
      this.b = var2;
      if(var1 != Grammar$GrammarType.CONTACTS && var1 != Grammar$GrammarType.CUSTOMWORDS && var1 != Grammar$GrammarType.HISTORY) {
         this.a = Grammar$GrammarType.CONTACTS;
      } else {
         this.a = var1;
      }

      this.c = var3;
   }

   public Grammar(String var1, String var2) {
      this.a = Grammar$GrammarType.URI;
      this.b = var1;
      this.k = var2;
      this.c = 0;
   }

   public Grammar(String var1, List var2) {
      this.a = Grammar$GrammarType.INSTANT_ITEM_LIST;
      this.b = var1;
      this.l = new Vector();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         if(var4 != null) {
            this.l.add(var4);
         }
      }

   }

   public PdxValue$Dictionary getGrammarDictionary() {
      byte var2 = 0;
      PdxValue$Dictionary var3 = new PdxValue$Dictionary();
      var3.put("id", this.b);
      var3.put("type", this.getTypeStr());
      if(this.a == Grammar$GrammarType.PREDEFINED_STATIC_GRAMMARS) {
         return var3;
      } else {
         if(this.a != Grammar$GrammarType.CONTACTS && this.a != Grammar$GrammarType.CUSTOMWORDS && this.a != Grammar$GrammarType.HISTORY) {
            if(this.a == Grammar$GrammarType.URI) {
               var3.put("uri", this.k);
            } else if(this.a == Grammar$GrammarType.INSTANT_ITEM_LIST) {
               PdxValue$Sequence var4 = new PdxValue$Sequence();
               if(!this.l.isEmpty()) {
                  for(int var1 = 0; var1 < this.l.size(); ++var1) {
                     String var5 = (String)this.l.elementAt(var1);
                     if(var5 != null) {
                        var4.add(var5);
                     }
                  }
               }

               var3.put("item_list", var4);
            }
         } else {
            var3.put("checksum", Integer.toString(this.c));
            if(this.j != null) {
               var3.put("common_user_id", this.j);
            }
         }

         if(this.e) {
            byte var6 = var2;
            if(this.d) {
               var6 = 1;
            }

            var3.put("load_as_lmh", var6);
         }

         if(this.g) {
            var3.put("topic_weight", this.f);
         }

         if(this.h != null) {
            var3.put("slot_tag", this.h);
         }

         if(this.i != null) {
            var3.put("interpretation_uri", this.i);
         }

         return var3;
      }
   }

   public String getTypeStr() {
      if(this.a == null) {
         return "contacts";
      } else {
         switch(null.a[this.a.ordinal()]) {
         case 1:
            return "contacts";
         case 2:
            return "custom_words";
         case 3:
            return "history";
         case 4:
            return "uri";
         case 5:
            return "predefined_static_grammars";
         case 6:
            return "instant_item_list";
         default:
            return "contacts";
         }
      }
   }

   public void setInterUri(String var1) {
      this.i = var1;
   }

   public void setLoadAsLmh(boolean var1) {
      this.e = true;
      this.d = var1;
   }

   public void setSlotTag(String var1) {
      this.h = var1;
   }

   public void setTopicWeight(int var1) {
      this.g = true;
      this.f = var1;
   }

   public void setUri(String var1) {
      this.k = var1;
   }

   public void setUserId(String var1) {
      this.j = var1;
   }
}
