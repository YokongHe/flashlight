package com.flurry.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.flurry.android.FlurryFullscreenTakeoverActivity;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.sdk.do;
import com.flurry.sdk.el;
import com.flurry.sdk.el$a;
import com.flurry.sdk.em;
import com.flurry.sdk.eo;
import com.flurry.sdk.ev;
import com.flurry.sdk.ex;
import com.flurry.sdk.ey;
import com.flurry.sdk.fc;
import com.flurry.sdk.fe;
import com.flurry.sdk.ff;
import com.flurry.sdk.g$a;
import com.flurry.sdk.g$b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SuppressLint({"SetJavaScriptEnabled"})
public class g extends com.flurry.sdk.i implements OnKeyListener, com.flurry.sdk.ad {
   private AlertDialog A;
   private List B;
   private boolean C;
   private Map D;
   private Map E;
   private List F;
   private boolean G = false;
   private boolean H = false;
   private boolean I = true;
   String a = null;
   private final String b = com.flurry.sdk.g.class.getSimpleName();
   private final String c = "mraid.js";
   private ProgressDialog d;
   private com.flurry.sdk.f e;
   private boolean f;
   private WebView g;
   private Button h;
   private int i;
   private boolean j;
   private WebViewClient k;
   private WebChromeClient l;
   private View m;
   private int n;
   private CustomViewCallback o;
   private Dialog p;
   private FrameLayout q;
   private int r;
   private Dialog s;
   private FrameLayout t;
   private boolean u;
   private boolean v;
   private boolean w;
   private boolean x;
   private boolean y;
   private FlurryFullscreenTakeoverActivity z;

   public g(Context var1, FlurryAdModule var2, com.flurry.sdk.e var3, AdUnit var4, int var5) {
      super(var1, var2, var3);
      this.setClickable(true);
      this.setAdUnit(var4);
      this.setAdFrameIndex(var5);
      if(this.getContext() instanceof Activity) {
         this.i = ((Activity)this.getContext()).getRequestedOrientation();
      }

      if(this.getAdUnit() != null) {
         this.B = this.getAdUnit().d();
         this.w = this.getAdUnit().r().booleanValue();
         boolean var6;
         if(this.getAdUnit().e().intValue() == 1) {
            var6 = true;
         } else {
            var6 = false;
         }

         this.C = var6;
         if(this.C) {
            this.E = new HashMap();
            this.D = new HashMap();
            this.E.put(var3.b(), var3);
            this.D.put(((AdFrame)var4.d().get(0)).g().toString(), var4);
         }

         this.F = new LinkedList();
      } else {
         eo.a(3, this.b, "adunit is Null");
      }
   }

   // $FF: synthetic method
   static CustomViewCallback A(com.flurry.sdk.g var0) {
      return var0.o;
   }

   private boolean A() {
      eo.a(3, "viewAttached", "fViewAttachedToActivity =" + this.G);
      return this.G;
   }

   private void B() {
      if(this.d != null && this.d.isShowing()) {
         this.d.dismiss();
         this.d = null;
      }

   }

   // $FF: synthetic method
   static int a(com.flurry.sdk.g var0, int var1) {
      var0.n = var1;
      return var1;
   }

   // $FF: synthetic method
   static Dialog a(com.flurry.sdk.g var0, Dialog var1) {
      var0.p = var1;
      return var1;
   }

   // $FF: synthetic method
   static View a(com.flurry.sdk.g var0, View var1) {
      var0.m = var1;
      return var1;
   }

   // $FF: synthetic method
   static CustomViewCallback a(com.flurry.sdk.g var0, CustomViewCallback var1) {
      var0.o = var1;
      return var1;
   }

   // $FF: synthetic method
   static FrameLayout a(com.flurry.sdk.g var0, FrameLayout var1) {
      var0.q = var1;
      return var1;
   }

   // $FF: synthetic method
   static AdUnit a(com.flurry.sdk.g var0, String var1) {
      return var0.c(var1);
   }

   private String a(List var1, String var2) {
      StringBuilder var3 = new StringBuilder();
      var3.append("\'{\"adComponents\":[");
      var2 = this.g.getUrl();
      String var4 = com.flurry.sdk.cf.b(var2);
      String var5 = com.flurry.sdk.cf.a(var4, var2);
      Iterator var6 = var1.iterator();

      while(var6.hasNext()) {
         var2 = ((AdFrame)((AdUnit)var6.next()).d().get(0)).d().toString();
         String var7 = var2;
         if(!TextUtils.isEmpty(var2)) {
            var7 = var2;
            if(!TextUtils.isEmpty(var5)) {
               var7 = var2;
               if(var5 != var4) {
                  var7 = var2.replace(var4, var5);
               }
            }
         }

         var3.append(fe.e(var7));
         if(var6.hasNext()) {
            var3.append(",");
         }
      }

      var3.append("]}\'");
      return var3.toString();
   }

   private List a(String var1, int var2, int var3) {
      List var6 = this.getPlatformModule().d().a(this.getAdUnit().b().toString(), var2, var3);
      Iterator var4 = var6.iterator();

      while(var4.hasNext()) {
         AdUnit var5 = (AdUnit)var4.next();
         if(var5.d().size() > 0) {
            this.D.put(((AdFrame)var5.d().get(0)).g().toString(), var5);
         }
      }

      return var6;
   }

   private void a(int var1, int var2) {
      if(!(this.getContext() instanceof Activity)) {
         eo.a(3, this.b, "no activity present");
      } else {
         Activity var3 = (Activity)this.getContext();
         if(this.s == null) {
            eo.a(3, this.b, "expand(" + var1 + "," + var2 + ")");
            if(this.g != null && -1 != this.indexOfChild(this.g)) {
               this.removeView(this.g);
            }

            this.r = var3.getRequestedOrientation();
            if(this.t == null) {
               this.t = new FrameLayout(var3);
               this.t.setBackgroundColor(-16777216);
               if(this.g != null && this.g.getParent() == null) {
                  this.t.addView(this.g, new LayoutParams(-1, -1, 17));
               }
            }

            if(this.s == null) {
               this.s = new Dialog(var3, 16973834);
               com.flurry.sdk.ch.a(this.s.getWindow());
               this.s.setContentView(this.t, new android.view.ViewGroup.LayoutParams(-1, -1));
               this.s.setOnDismissListener(new OnDismissListener() {
                  public void onDismiss(DialogInterface var1) {
                     eo.a(3, g.this.b, "extendedWebViewDialog.onDismiss()");
                     if(g.this.g != null) {
                        g.this.g.loadUrl("javascript:if(window.mraid){window.mraid.close();};");
                     }

                  }
               });
               this.s.setCancelable(true);
               this.s.show();
            }

            com.flurry.sdk.cb.a(var3, com.flurry.sdk.cb.a(), true);
            this.getPlatformModule().a((Context)var3, (String)this.getAdUnit().b().toString());
            return;
         }
      }

   }

   private void a(Context var1) {
      if(this.d == null) {
         if(var1 == null) {
            eo.a(3, this.b, "Context is null, cannot create progress dialog.");
            return;
         }

         this.d = new ProgressDialog(var1);
         this.d.setProgressStyle(0);
         this.d.setMessage("Loading...");
         this.d.setCancelable(true);
         this.d.setCanceledOnTouchOutside(false);
         this.d.setOnKeyListener(this);
         this.d.show();
      } else if(!this.d.isShowing()) {
         this.d.show();
         return;
      }

   }

   private void a(com.flurry.sdk.a var1) {
      if(this.F.contains(var1.c.a) && this.g != null) {
         this.g.loadUrl("javascript:flurryadapter.callComplete(\'" + var1.c.a + "\');");
         this.F.remove(var1.c.a);
      }

   }

   private void a(com.flurry.sdk.a var1, int var2) {
      String var3;
      if(!this.C) {
         if(var2 != this.getAdFrameIndex() && var2 < this.B.size()) {
            AdFrame var4 = (AdFrame)this.getAdUnit().d().get(var2);
            com.flurry.sdk.e var5 = this.getPlatformModule().a(var4.g().toString());
            var3 = this.getCurrentFormat();
            String var9 = var4.e().e().toString();
            if(var9.equals(var3)) {
               this.setAdLog(var5);
               this.setAdFrameIndex(var2);
               this.initLayout();
               return;
            }

            if(var9.equals("takeover")) {
               this.getPlatformModule().a(var5);
               this.getPlatformModule().a(this.getAdUnit());
               Intent var6 = new Intent(do.a().b(), FlurryFullscreenTakeoverActivity.class);
               var6.putExtra("frameIndex", var2);
               this.getPlatformModule().a().a(this.getContext(), var6, this.getAdUnit().b().toString());
            }
         }
      } else {
         var3 = (String)var1.c.b.get("guid");
         if(var3 != null) {
            this.setAdUnit(this.c(var3));
            this.B = this.getAdUnit().d();
            AdFrame var7 = (AdFrame)this.getAdUnit().d().get(var2);
            com.flurry.sdk.e var8 = this.getPlatformModule().a(var7.g().toString());
            this.setAdLog(var1.c.d);
            if(this.e()) {
               this.getPlatformModule().a(this.getAdUnit());
               this.getPlatformModule().a(var8);
            }

            this.setAdLog(var8);
            this.setAdFrameIndex(var2);
            this.C = false;
            this.initLayout();
            return;
         }
      }

   }

   private void a(final String var1) {
      el var2 = new el();
      var2.a((String)var1);
      var2.b((ex)(new ey()));
      var2.a(new el$a() {
         public void a(el var1x, final String var2) {
            int var3 = var1x.e();
            eo.a(3, g.this.b, "Prerender: HTTP status code is:" + var3 + " for url: " + var1);
            if(var1x.c()) {
               final String var4 = com.flurry.sdk.cf.c(var1);
               g.this.a("rendered", Collections.emptyMap(), g.this.getAdUnit(), g.this.getAdLog(), g.this.getAdFrameIndex(), 0);
               do.a().a((Runnable)(new ff() {
                  public void a() {
                     if(g.this.g != null) {
                        g.this.g.loadDataWithBaseURL(var4, var2, "text/html", "utf-8", var4);
                     }

                  }
               }));
            } else {
               do.a().a((Runnable)(new ff() {
                  public void a() {
                     HashMap var1x = new HashMap();
                     var1x.put("errorCode", Integer.toString(com.flurry.sdk.b.k.a()));
                     g.this.a("renderFailed", var1x, g.this.getAdUnit(), g.this.getAdLog(), g.this.getAdFrameIndex(), 0);
                  }
               }));
            }
         }
      });
      em.a().a(this, var2);
   }

   private void a(String param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static boolean a(com.flurry.sdk.g var0, boolean var1) {
      var0.v = var1;
      return var1;
   }

   // $FF: synthetic method
   static com.flurry.sdk.e b(com.flurry.sdk.g var0, String var1) {
      return var0.b(var1);
   }

   private com.flurry.sdk.e b(String var1) {
      com.flurry.sdk.e var2;
      if(this.E == null) {
         var2 = null;
      } else {
         com.flurry.sdk.e var3 = (com.flurry.sdk.e)this.E.get(var1);
         var2 = var3;
         if(var3 == null) {
            var2 = this.getPlatformModule().a(var1);
            this.E.put(var1, var2);
            return var2;
         }
      }

      return var2;
   }

   private void b(int var1, int var2) {
      if(!(this.getContext() instanceof Activity)) {
         eo.a(3, this.b, "no activity present");
      } else {
         Activity var3 = (Activity)this.getContext();
         if(this.s != null) {
            eo.a(3, this.b, "collapse(" + var1 + "," + var2 + ")");
            if(this.s != null && this.s.isShowing()) {
               this.s.hide();
               this.s.setOnDismissListener((OnDismissListener)null);
               this.s.dismiss();
            }

            this.s = null;
            com.flurry.sdk.cb.a(var3, this.r);
            if(this.t != null) {
               if(this.g != null && -1 != this.t.indexOfChild(this.g)) {
                  this.t.removeView(this.g);
               }

               this.t = null;
            }

            if(this.g != null && this.g.getParent() == null) {
               this.addView(this.g);
            }

            this.getPlatformModule().b((Context)var3, (String)this.getAdUnit().b().toString());
            return;
         }
      }

   }

   // $FF: synthetic method
   static boolean b(com.flurry.sdk.g var0, boolean var1) {
      var0.u = var1;
      return var1;
   }

   private AdUnit c(String var1) {
      return this.D == null?null:(AdUnit)this.D.get(var1);
   }

   // $FF: synthetic method
   static void c(com.flurry.sdk.g var0) {
      var0.i();
   }

   // $FF: synthetic method
   static boolean c(com.flurry.sdk.g var0, boolean var1) {
      var0.I = var1;
      return var1;
   }

   // $FF: synthetic method
   static boolean d(com.flurry.sdk.g var0) {
      return var0.v;
   }

   // $FF: synthetic method
   static boolean e(com.flurry.sdk.g var0) {
      return var0.w;
   }

   // $FF: synthetic method
   static void f(com.flurry.sdk.g var0) {
      var0.n();
   }

   // $FF: synthetic method
   static boolean g(com.flurry.sdk.g var0) {
      return var0.u;
   }

   // $FF: synthetic method
   static void h(com.flurry.sdk.g var0) {
      var0.q();
   }

   private boolean h() {
      synchronized(this){}

      boolean var1;
      try {
         var1 = this.j;
      } finally {
         ;
      }

      return var1;
   }

   private void i() {
      synchronized(this){}

      try {
         if(!this.h()) {
            this.k();
            this.setFlurryJsEnvInitialized(true);
         }
      } finally {
         ;
      }

   }

   // $FF: synthetic method
   static void i(com.flurry.sdk.g var0) {
      var0.r();
   }

   private void j() {
      synchronized(this){}

      try {
         this.setFlurryJsEnvInitialized(false);
      } finally {
         ;
      }

   }

   // $FF: synthetic method
   static void j(com.flurry.sdk.g var0) {
      var0.w();
   }

   private void k() {
      eo.a(3, this.b, "initializeFlurryJsEnv");
      StringBuilder var1 = new StringBuilder();
      var1.append("javascript:(function() {");
      var1.append("var Hogan={};(function(Hogan,useArrayBuffer){Hogan.Template=function(renderFunc,text,compiler,options){this.r=renderFunc||this.r;this.c=compiler;this.options=options;this.text=text||\"\";this.buf=useArrayBuffer?[]:\"\"};Hogan.Template.prototype={r:function(context,partials,indent){return\"\"},v:hoganEscape,t:coerceToString,render:function render(context,partials,indent){return this.ri([context],partials||{},indent)},ri:function(context,partials,indent){return this.r(context,partials,indent)},rp:function(name,context,partials,indent){var partial=partials[name];if(!partial){return\"\"}if(this.c&&typeof partial==\"string\"){partial=this.c.compile(partial,this.options)}return partial.ri(context,partials,indent)},rs:function(context,partials,section){var tail=context[context.length-1];if(!isArray(tail)){section(context,partials,this);return}for(var i=0;i<tail.length;i++){context.push(tail[i]);section(context,partials,this);context.pop()}},s:function(val,ctx,partials,inverted,start,end,tags){var pass;if(isArray(val)&&val.length===0){return false}if(typeof val==\"function\"){val=this.ls(val,ctx,partials,inverted,start,end,tags)}pass=(val===\"\")||!!val;if(!inverted&&pass&&ctx){ctx.push((typeof val==\"object\")?val:ctx[ctx.length-1])}return pass},d:function(key,ctx,partials,returnFound){var names=key.split(\".\"),val=this.f(names[0],ctx,partials,returnFound),cx=null;if(key===\".\"&&isArray(ctx[ctx.length-2])){return ctx[ctx.length-1]}for(var i=1;i<names.length;i++){if(val&&typeof val==\"object\"&&names[i] in val){cx=val;val=val[names[i]]}else{val=\"\"}}if(returnFound&&!val){return false}if(!returnFound&&typeof val==\"function\"){ctx.push(cx);val=this.lv(val,ctx,partials);ctx.pop()}return val},f:function(key,ctx,partials,returnFound){var val=false,v=null,found=false;for(var i=ctx.length-1;i>=0;i--){v=ctx[i];if(v&&typeof v==\"object\"&&key in v){val=v[key];found=true;break}}if(!found){return(returnFound)?false:\"\"}if(!returnFound&&typeof val==\"function\"){val=this.lv(val,ctx,partials)}return val},ho:function(val,cx,partials,text,tags){var compiler=this.c;var options=this.options;options.delimiters=tags;var text=val.call(cx,text);text=(text==null)?String(text):text.toString();this.b(compiler.compile(text,options).render(cx,partials));return false},b:(useArrayBuffer)?function(s){this.buf.push(s)}:function(s){this.buf+=s},fl:(useArrayBuffer)?function(){var r=this.buf.join(\"\");this.buf=[];return r}:function(){var r=this.buf;this.buf=\"\";return r},ls:function(val,ctx,partials,inverted,start,end,tags){var cx=ctx[ctx.length-1],t=null;if(!inverted&&this.c&&val.length>0){return this.ho(val,cx,partials,this.text.substring(start,end),tags)}t=val.call(cx);if(typeof t==\"function\"){if(inverted){return true}else{if(this.c){return this.ho(t,cx,partials,this.text.substring(start,end),tags)}}}return t},lv:function(val,ctx,partials){var cx=ctx[ctx.length-1];var result=val.call(cx);if(typeof result==\"function\"){result=coerceToString(result.call(cx));if(this.c&&~result.indexOf(\"{\\u007B\")){return this.c.compile(result,this.options).render(cx,partials)}}return coerceToString(result)}};var rAmp=/&/g,rLt=/</g,rGt=/>/g,rApos=/\\\'/g,rQuot=/\\\"/g,hChars=/[&<>\\\"\\\']/;function coerceToString(val){return String((val===null||val===undefined)?\"\":val)}function hoganEscape(str){str=coerceToString(str);return hChars.test(str)?str.replace(rAmp,\"&amp;\").replace(rLt,\"&lt;\").replace(rGt,\"&gt;\").replace(rApos,\"&#39;\").replace(rQuot,\"&quot;\"):str}var isArray=Array.isArray||function(a){return Object.prototype.toString.call(a)===\"[object Array]\"}})(typeof exports!==\"undefined\"?exports:Hogan);(function(Hogan){var rIsWhitespace=/\\S/,rQuot=/\\\"/g,rNewline=/\\n/g,rCr=/\\r/g,rSlash=/\\\\/g,tagTypes={\"#\":1,\"^\":2,\"/\":3,\"!\":4,\">\":5,\"<\":6,\"=\":7,_v:8,\"{\":9,\"&\":10};Hogan.scan=function scan(text,delimiters){var len=text.length,IN_TEXT=0,IN_TAG_TYPE=1,IN_TAG=2,state=IN_TEXT,tagType=null,tag=null,buf=\"\",tokens=[],seenTag=false,i=0,lineStart=0,otag=\"{{\",ctag=\"}}\";function addBuf(){if(buf.length>0){tokens.push(new String(buf));buf=\"\"}}function lineIsWhitespace(){var isAllWhitespace=true;for(var j=lineStart;j<tokens.length;j++){isAllWhitespace=(tokens[j].tag&&tagTypes[tokens[j].tag]<tagTypes._v)||(!tokens[j].tag&&tokens[j].match(rIsWhitespace)===null);if(!isAllWhitespace){return false}}return isAllWhitespace}function filterLine(haveSeenTag,noNewLine){addBuf();if(haveSeenTag&&lineIsWhitespace()){for(var j=lineStart,next;j<tokens.length;j++){if(!tokens[j].tag){if((next=tokens[j+1])&&next.tag==\">\"){next.indent=tokens[j].toString()}tokens.splice(j,1)}}}else{if(!noNewLine){tokens.push({tag:\"\\n\"})}}seenTag=false;lineStart=tokens.length}function changeDelimiters(text,index){var close=\"=\"+ctag,closeIndex=text.indexOf(close,index),delimiters=trim(text.substring(text.indexOf(\"=\",index)+1,closeIndex)).split(\" \");otag=delimiters[0];ctag=delimiters[1];return closeIndex+close.length-1}if(delimiters){delimiters=delimiters.split(\" \");otag=delimiters[0];ctag=delimiters[1]}for(i=0;i<len;i++){if(state==IN_TEXT){if(tagChange(otag,text,i)){--i;addBuf();state=IN_TAG_TYPE}else{if(text.charAt(i)==\"\\n\"){filterLine(seenTag)}else{buf+=text.charAt(i)}}}else{if(state==IN_TAG_TYPE){i+=otag.length-1;tag=tagTypes[text.charAt(i+1)];tagType=tag?text.charAt(i+1):\"_v\";if(tagType==\"=\"){i=changeDelimiters(text,i);state=IN_TEXT}else{if(tag){i++}state=IN_TAG}seenTag=i}else{if(tagChange(ctag,text,i)){tokens.push({tag:tagType,n:trim(buf),otag:otag,ctag:ctag,i:(tagType==\"/\")?seenTag-ctag.length:i+otag.length});buf=\"\";i+=ctag.length-1;state=IN_TEXT;if(tagType==\"{\"){if(ctag==\"}}\"){i++}else{cleanTripleStache(tokens[tokens.length-1])}}}else{buf+=text.charAt(i)}}}}filterLine(seenTag,true);return tokens};function cleanTripleStache(token){if(token.n.substr(token.n.length-1)===\"}\"){token.n=token.n.substring(0,token.n.length-1)}}function trim(s){if(s.trim){return s.trim()}return s.replace(/^\\s*|\\s*$/g,\"\")}function tagChange(tag,text,index){if(text.charAt(index)!=tag.charAt(0)){return false}for(var i=1,l=tag.length;i<l;i++){if(text.charAt(index+i)!=tag.charAt(i)){return false}}return true}function buildTree(tokens,kind,stack,customTags){var instructions=[],opener=null,token=null;while(tokens.length>0){token=tokens.shift();if(token.tag==\"#\"||token.tag==\"^\"||isOpener(token,customTags)){stack.push(token);token.nodes=buildTree(tokens,token.tag,stack,customTags);instructions.push(token)}else{if(token.tag==\"/\"){if(stack.length===0){throw new Error(\"Closing tag without opener: /\"+token.n)}opener=stack.pop();if(token.n!=opener.n&&!isCloser(token.n,opener.n,customTags)){throw new Error(\"Nesting error: \"+opener.n+\" vs. \"+token.n)}opener.end=token.i;return instructions}else{instructions.push(token)}}}if(stack.length>0){throw new Error(\"missing closing tag: \"+stack.pop().n)}return instructions}function isOpener(token,tags){for(var i=0,l=tags.length;i<l;i++){if(tags[i].o==token.n){token.tag=\"#\";return true}}}function isCloser(close,open,tags){for(var i=0,l=tags.length;i<l;i++){if(tags[i].c==close&&tags[i].o==open){return true}}}Hogan.generate=function(tree,text,options){var code=\'var _=this;_.b(i=i||\"\");\'+walk(tree)+\"return _.fl();\";if(options.asString){return\"function(c,p,i){\"+code+\";}\"}return new Hogan.Template(new Function(\"c\",\"p\",\"i\",code),text,Hogan,options)};function esc(s){return s.replace(rSlash,\"\\\\\\\\\").replace(rQuot,\'\\\\\"\').replace(rNewline,\"\\\\n\").replace(rCr,\"\\\\r\")}function chooseMethod(s){return(~s.indexOf(\".\"))?\"d\":\"f\"}function walk(tree){var code=\"\";for(var i=0,l=tree.length;i<l;i++){var tag=tree[i].tag;if(tag==\"#\"){code+=section(tree[i].nodes,tree[i].n,chooseMethod(tree[i].n),tree[i].i,tree[i].end,tree[i].otag+\" \"+tree[i].ctag)}else{if(tag==\"^\"){code+=invertedSection(tree[i].nodes,tree[i].n,chooseMethod(tree[i].n))}else{if(tag==\"<\"||tag==\">\"){code+=partial(tree[i])}else{if(tag==\"{\"||tag==\"&\"){code+=tripleStache(tree[i].n,chooseMethod(tree[i].n))}else{if(tag==\"\\n\"){code+=text(\'\"\\\\n\"\'+(tree.length-1==i?\"\":\" + i\"))}else{if(tag==\"_v\"){code+=variable(tree[i].n,chooseMethod(tree[i].n))}else{if(tag===undefined){code+=text(\'\"\'+esc(tree[i])+\'\"\')}}}}}}}}return code}function section(nodes,id,method,start,end,tags){return\"if(_.s(_.\"+method+\'(\"\'+esc(id)+\'\",c,p,1),c,p,0,\'+start+\",\"+end+\',\"\'+tags+\'\")){_.rs(c,p,function(c,p,_){\'+walk(nodes)+\"});c.pop();}\"}function invertedSection(nodes,id,method){return\"if(!_.s(_.\"+method+\'(\"\'+esc(id)+\'\",c,p,1),c,p,1,0,0,\"\")){\'+walk(nodes)+\"};\"}function partial(tok){return\'_.b(_.rp(\"\'+esc(tok.n)+\'\",c,p,\"\'+(tok.indent||\"\")+\'\"));\'}function tripleStache(id,method){return\"_.b(_.t(_.\"+method+\'(\"\'+esc(id)+\'\",c,p,0)));\'}function variable(id,method){return\"_.b(_.v(_.\"+method+\'(\"\'+esc(id)+\'\",c,p,0)));\'}function text(id){return\"_.b(\"+id+\");\"}Hogan.parse=function(tokens,text,options){options=options||{};return buildTree(tokens,\"\",[],options.sectionTags||[])},Hogan.cache={};Hogan.compile=function(text,options){options=options||{};var key=text+\"||\"+!!options.asString;var t=this.cache[key];if(t){return t}t=this.generate(this.parse(this.scan(text,options.delimiters),text,options),text,options);return this.cache[key]=t}})(typeof exports!==\"undefined\"?exports:Hogan);");
      var1.append("var flurryBridgeCtor=function(w){var flurryadapter={};flurryadapter.flurryCallQueue=[];flurryadapter.flurryCallInProgress=false;flurryadapter.callComplete=function(cmd){if(this.flurryCallQueue.length==0){this.flurryCallInProgress=false;return}var adapterCall=this.flurryCallQueue.splice(0,1)[0];this.executeNativeCall(adapterCall);return\"OK\"};flurryadapter.executeCall=function(command){var adapterCall=\"flurry://flurrycall?event=\"+command;var value;for(var i=1;i<arguments.length;i+=2){value=arguments[i+1];if(value==null)continue;adapterCall+=\"&\"+arguments[i]+\"=\"+escape(value)}if(this.flurryCallInProgress)this.flurryCallQueue.push(adapterCall);else this.executeNativeCall(adapterCall)};flurryadapter.executeNativeCall=function(adapterCall){if(adapterCall.length==0)return;this.flurryCallInProgress=true;w.location=adapterCall};return flurryadapter};");
      var1.append("window.Hogan=Hogan;window.flurryadapter=flurryBridgeCtor(window);");
      var1.append("window.flurryAdapterAvailable=true;if(typeof window.FlurryAdapterReady === \'function\'){window.FlurryAdapterReady();}");
      var1.append("})();");
      if(this.g != null) {
         this.g.loadUrl(var1.toString());
      }

   }

   // $FF: synthetic method
   static void k(com.flurry.sdk.g var0) {
      var0.x();
   }

   private void l() {
      eo.a(3, this.b, "activateFlurryJsEnv");
      String var2 = this.getCurrentContent();
      if(!this.C && var2 != null && var2.length() > 0 && !var2.equals("{}")) {
         String var1 = this.g.getUrl();
         String var3 = com.flurry.sdk.cf.b(var1);
         String var4 = com.flurry.sdk.cf.a(var3, var1);
         var1 = var2;
         if(!TextUtils.isEmpty(var4)) {
            var1 = var2;
            if(var4 != var3) {
               eo.a(3, this.b, "content before {{mustached}} tags replacement = \'" + var2 + "\'");
               var1 = var2.replace(var3, var4);
               eo.a(3, this.b, "content after {{mustached}} tags replacement = \'" + var1 + "\'");
            }
         }

         StringBuilder var5 = new StringBuilder();
         var5.append("javascript:");
         var5.append("(function(){");
         var5.append("if(!window.Hogan){var Hogan={};(function(Hogan,useArrayBuffer){Hogan.Template=function(renderFunc,text,compiler,options){this.r=renderFunc||this.r;this.c=compiler;this.options=options;this.text=text||\"\";this.buf=useArrayBuffer?[]:\"\"};Hogan.Template.prototype={r:function(context,partials,indent){return\"\"},v:hoganEscape,t:coerceToString,render:function render(context,partials,indent){return this.ri([context],partials||{},indent)},ri:function(context,partials,indent){return this.r(context,partials,indent)},rp:function(name,context,partials,indent){var partial=partials[name];if(!partial){return\"\"}if(this.c&&typeof partial==\"string\"){partial=this.c.compile(partial,this.options)}return partial.ri(context,partials,indent)},rs:function(context,partials,section){var tail=context[context.length-1];if(!isArray(tail)){section(context,partials,this);return}for(var i=0;i<tail.length;i++){context.push(tail[i]);section(context,partials,this);context.pop()}},s:function(val,ctx,partials,inverted,start,end,tags){var pass;if(isArray(val)&&val.length===0){return false}if(typeof val==\"function\"){val=this.ls(val,ctx,partials,inverted,start,end,tags)}pass=(val===\"\")||!!val;if(!inverted&&pass&&ctx){ctx.push((typeof val==\"object\")?val:ctx[ctx.length-1])}return pass},d:function(key,ctx,partials,returnFound){var names=key.split(\".\"),val=this.f(names[0],ctx,partials,returnFound),cx=null;if(key===\".\"&&isArray(ctx[ctx.length-2])){return ctx[ctx.length-1]}for(var i=1;i<names.length;i++){if(val&&typeof val==\"object\"&&names[i] in val){cx=val;val=val[names[i]]}else{val=\"\"}}if(returnFound&&!val){return false}if(!returnFound&&typeof val==\"function\"){ctx.push(cx);val=this.lv(val,ctx,partials);ctx.pop()}return val},f:function(key,ctx,partials,returnFound){var val=false,v=null,found=false;for(var i=ctx.length-1;i>=0;i--){v=ctx[i];if(v&&typeof v==\"object\"&&key in v){val=v[key];found=true;break}}if(!found){return(returnFound)?false:\"\"}if(!returnFound&&typeof val==\"function\"){val=this.lv(val,ctx,partials)}return val},ho:function(val,cx,partials,text,tags){var compiler=this.c;var options=this.options;options.delimiters=tags;var text=val.call(cx,text);text=(text==null)?String(text):text.toString();this.b(compiler.compile(text,options).render(cx,partials));return false},b:(useArrayBuffer)?function(s){this.buf.push(s)}:function(s){this.buf+=s},fl:(useArrayBuffer)?function(){var r=this.buf.join(\"\");this.buf=[];return r}:function(){var r=this.buf;this.buf=\"\";return r},ls:function(val,ctx,partials,inverted,start,end,tags){var cx=ctx[ctx.length-1],t=null;if(!inverted&&this.c&&val.length>0){return this.ho(val,cx,partials,this.text.substring(start,end),tags)}t=val.call(cx);if(typeof t==\"function\"){if(inverted){return true}else{if(this.c){return this.ho(t,cx,partials,this.text.substring(start,end),tags)}}}return t},lv:function(val,ctx,partials){var cx=ctx[ctx.length-1];var result=val.call(cx);if(typeof result==\"function\"){result=coerceToString(result.call(cx));if(this.c&&~result.indexOf(\"{\\u007B\")){return this.c.compile(result,this.options).render(cx,partials)}}return coerceToString(result)}};var rAmp=/&/g,rLt=/</g,rGt=/>/g,rApos=/\\\'/g,rQuot=/\\\"/g,hChars=/[&<>\\\"\\\']/;function coerceToString(val){return String((val===null||val===undefined)?\"\":val)}function hoganEscape(str){str=coerceToString(str);return hChars.test(str)?str.replace(rAmp,\"&amp;\").replace(rLt,\"&lt;\").replace(rGt,\"&gt;\").replace(rApos,\"&#39;\").replace(rQuot,\"&quot;\"):str}var isArray=Array.isArray||function(a){return Object.prototype.toString.call(a)===\"[object Array]\"}})(typeof exports!==\"undefined\"?exports:Hogan);(function(Hogan){var rIsWhitespace=/\\S/,rQuot=/\\\"/g,rNewline=/\\n/g,rCr=/\\r/g,rSlash=/\\\\/g,tagTypes={\"#\":1,\"^\":2,\"/\":3,\"!\":4,\">\":5,\"<\":6,\"=\":7,_v:8,\"{\":9,\"&\":10};Hogan.scan=function scan(text,delimiters){var len=text.length,IN_TEXT=0,IN_TAG_TYPE=1,IN_TAG=2,state=IN_TEXT,tagType=null,tag=null,buf=\"\",tokens=[],seenTag=false,i=0,lineStart=0,otag=\"{{\",ctag=\"}}\";function addBuf(){if(buf.length>0){tokens.push(new String(buf));buf=\"\"}}function lineIsWhitespace(){var isAllWhitespace=true;for(var j=lineStart;j<tokens.length;j++){isAllWhitespace=(tokens[j].tag&&tagTypes[tokens[j].tag]<tagTypes._v)||(!tokens[j].tag&&tokens[j].match(rIsWhitespace)===null);if(!isAllWhitespace){return false}}return isAllWhitespace}function filterLine(haveSeenTag,noNewLine){addBuf();if(haveSeenTag&&lineIsWhitespace()){for(var j=lineStart,next;j<tokens.length;j++){if(!tokens[j].tag){if((next=tokens[j+1])&&next.tag==\">\"){next.indent=tokens[j].toString()}tokens.splice(j,1)}}}else{if(!noNewLine){tokens.push({tag:\"\\n\"})}}seenTag=false;lineStart=tokens.length}function changeDelimiters(text,index){var close=\"=\"+ctag,closeIndex=text.indexOf(close,index),delimiters=trim(text.substring(text.indexOf(\"=\",index)+1,closeIndex)).split(\" \");otag=delimiters[0];ctag=delimiters[1];return closeIndex+close.length-1}if(delimiters){delimiters=delimiters.split(\" \");otag=delimiters[0];ctag=delimiters[1]}for(i=0;i<len;i++){if(state==IN_TEXT){if(tagChange(otag,text,i)){--i;addBuf();state=IN_TAG_TYPE}else{if(text.charAt(i)==\"\\n\"){filterLine(seenTag)}else{buf+=text.charAt(i)}}}else{if(state==IN_TAG_TYPE){i+=otag.length-1;tag=tagTypes[text.charAt(i+1)];tagType=tag?text.charAt(i+1):\"_v\";if(tagType==\"=\"){i=changeDelimiters(text,i);state=IN_TEXT}else{if(tag){i++}state=IN_TAG}seenTag=i}else{if(tagChange(ctag,text,i)){tokens.push({tag:tagType,n:trim(buf),otag:otag,ctag:ctag,i:(tagType==\"/\")?seenTag-ctag.length:i+otag.length});buf=\"\";i+=ctag.length-1;state=IN_TEXT;if(tagType==\"{\"){if(ctag==\"}}\"){i++}else{cleanTripleStache(tokens[tokens.length-1])}}}else{buf+=text.charAt(i)}}}}filterLine(seenTag,true);return tokens};function cleanTripleStache(token){if(token.n.substr(token.n.length-1)===\"}\"){token.n=token.n.substring(0,token.n.length-1)}}function trim(s){if(s.trim){return s.trim()}return s.replace(/^\\s*|\\s*$/g,\"\")}function tagChange(tag,text,index){if(text.charAt(index)!=tag.charAt(0)){return false}for(var i=1,l=tag.length;i<l;i++){if(text.charAt(index+i)!=tag.charAt(i)){return false}}return true}function buildTree(tokens,kind,stack,customTags){var instructions=[],opener=null,token=null;while(tokens.length>0){token=tokens.shift();if(token.tag==\"#\"||token.tag==\"^\"||isOpener(token,customTags)){stack.push(token);token.nodes=buildTree(tokens,token.tag,stack,customTags);instructions.push(token)}else{if(token.tag==\"/\"){if(stack.length===0){throw new Error(\"Closing tag without opener: /\"+token.n)}opener=stack.pop();if(token.n!=opener.n&&!isCloser(token.n,opener.n,customTags)){throw new Error(\"Nesting error: \"+opener.n+\" vs. \"+token.n)}opener.end=token.i;return instructions}else{instructions.push(token)}}}if(stack.length>0){throw new Error(\"missing closing tag: \"+stack.pop().n)}return instructions}function isOpener(token,tags){for(var i=0,l=tags.length;i<l;i++){if(tags[i].o==token.n){token.tag=\"#\";return true}}}function isCloser(close,open,tags){for(var i=0,l=tags.length;i<l;i++){if(tags[i].c==close&&tags[i].o==open){return true}}}Hogan.generate=function(tree,text,options){var code=\'var _=this;_.b(i=i||\"\");\'+walk(tree)+\"return _.fl();\";if(options.asString){return\"function(c,p,i){\"+code+\";}\"}return new Hogan.Template(new Function(\"c\",\"p\",\"i\",code),text,Hogan,options)};function esc(s){return s.replace(rSlash,\"\\\\\\\\\").replace(rQuot,\'\\\\\"\').replace(rNewline,\"\\\\n\").replace(rCr,\"\\\\r\")}function chooseMethod(s){return(~s.indexOf(\".\"))?\"d\":\"f\"}function walk(tree){var code=\"\";for(var i=0,l=tree.length;i<l;i++){var tag=tree[i].tag;if(tag==\"#\"){code+=section(tree[i].nodes,tree[i].n,chooseMethod(tree[i].n),tree[i].i,tree[i].end,tree[i].otag+\" \"+tree[i].ctag)}else{if(tag==\"^\"){code+=invertedSection(tree[i].nodes,tree[i].n,chooseMethod(tree[i].n))}else{if(tag==\"<\"||tag==\">\"){code+=partial(tree[i])}else{if(tag==\"{\"||tag==\"&\"){code+=tripleStache(tree[i].n,chooseMethod(tree[i].n))}else{if(tag==\"\\n\"){code+=text(\'\"\\\\n\"\'+(tree.length-1==i?\"\":\" + i\"))}else{if(tag==\"_v\"){code+=variable(tree[i].n,chooseMethod(tree[i].n))}else{if(tag===undefined){code+=text(\'\"\'+esc(tree[i])+\'\"\')}}}}}}}}return code}function section(nodes,id,method,start,end,tags){return\"if(_.s(_.\"+method+\'(\"\'+esc(id)+\'\",c,p,1),c,p,0,\'+start+\",\"+end+\',\"\'+tags+\'\")){_.rs(c,p,function(c,p,_){\'+walk(nodes)+\"});c.pop();}\"}function invertedSection(nodes,id,method){return\"if(!_.s(_.\"+method+\'(\"\'+esc(id)+\'\",c,p,1),c,p,1,0,0,\"\")){\'+walk(nodes)+\"};\"}function partial(tok){return\'_.b(_.rp(\"\'+esc(tok.n)+\'\",c,p,\"\'+(tok.indent||\"\")+\'\"));\'}function tripleStache(id,method){return\"_.b(_.t(_.\"+method+\'(\"\'+esc(id)+\'\",c,p,0)));\'}function variable(id,method){return\"_.b(_.v(_.\"+method+\'(\"\'+esc(id)+\'\",c,p,0)));\'}function text(id){return\"_.b(\"+id+\");\"}Hogan.parse=function(tokens,text,options){options=options||{};return buildTree(tokens,\"\",[],options.sectionTags||[])},Hogan.cache={};Hogan.compile=function(text,options){options=options||{};var key=text+\"||\"+!!options.asString;var t=this.cache[key];if(t){return t}t=this.generate(this.parse(this.scan(text,options.delimiters),text,options),text,options);return this.cache[key]=t}})(typeof exports!==\"undefined\"?exports:Hogan);window.Hogan=Hogan;}");
         var5.append("if(!window.flurryadapter){var flurryBridgeCtor=function(w){var flurryadapter={};flurryadapter.flurryCallQueue=[];flurryadapter.flurryCallInProgress=false;flurryadapter.callComplete=function(cmd){if(this.flurryCallQueue.length==0){this.flurryCallInProgress=false;return}var adapterCall=this.flurryCallQueue.splice(0,1)[0];this.executeNativeCall(adapterCall);return\"OK\"};flurryadapter.executeCall=function(command){var adapterCall=\"flurry://flurrycall?event=\"+command;var value;for(var i=1;i<arguments.length;i+=2){value=arguments[i+1];if(value==null)continue;adapterCall+=\"&\"+arguments[i]+\"=\"+escape(value)}if(this.flurryCallInProgress)this.flurryCallQueue.push(adapterCall);else this.executeNativeCall(adapterCall)};flurryadapter.executeNativeCall=function(adapterCall){if(adapterCall.length==0)return;this.flurryCallInProgress=true;w.location=adapterCall};return flurryadapter};window.flurryadapter=flurryBridgeCtor(window);}");
         var5.append("if(!window.flurryAdapterAvailable){window.flurryAdapterAvailable=true;if(typeof window.FlurryAdapterReady === \'function\'){window.FlurryAdapterReady();} }");
         var1 = fe.e(var1);
         var5.append("var content=\'");
         var5.append(var1);
         var5.append("\';var compiled=window.Hogan.compile(document.body.innerHTML);var rendered=compiled.render(JSON.parse(content));document.body.innerHTML=rendered;");
         var5.append("})();");
         if(this.g != null) {
            this.g.loadUrl(var5.toString());
         }
      }

   }

   // $FF: synthetic method
   static void l(com.flurry.sdk.g var0) {
      var0.y();
   }

   // $FF: synthetic method
   static void m(com.flurry.sdk.g var0) {
      var0.z();
   }

   private boolean m() {
      synchronized(this){}

      boolean var1;
      try {
         var1 = this.y;
      } finally {
         ;
      }

      return var1;
   }

   private void n() {
      synchronized(this){}

      try {
         if(!this.m()) {
            this.p();
            this.setMraidJsEnvInitialized(true);
         }
      } finally {
         ;
      }

   }

   // $FF: synthetic method
   static void n(com.flurry.sdk.g var0) {
      var0.j();
   }

   private void o() {
      synchronized(this){}

      try {
         this.setMraidJsEnvInitialized(false);
      } finally {
         ;
      }

   }

   // $FF: synthetic method
   static void o(com.flurry.sdk.g var0) {
      var0.o();
   }

   private void p() {
      eo.a(3, this.b, "initializeMraid");
      String var1;
      if(this.e()) {
         var1 = "interstitial";
      } else {
         var1 = "inline";
      }

      var1 = "{useCustomClose:" + false + ",isModal:false" + ",width:undefined,height:undefined,placementType:\"" + var1 + "\"}";
      StringBuilder var2 = new StringBuilder();
      var2.append("javascript:(function() {");
      var2.append("var mraidCtor=function(flurryBridge,initState){var mraid={};var STATES=mraid.STATES={LOADING:\"loading\",UNKNOWN:\"unknown\",DEFAULT:\"default\",EXPANDED:\"expanded\",HIDDEN:\"hidden\"};var EVENTS=mraid.EVENTS={ASSETREADY:\"assetReady\",ASSETREMOVED:\"assetRemoved\",ASSETRETIRED:\"assetRetired\",INFO:\"info\",ERROR:\"error\",ORIENTATIONCHANGE:\"orientationChange\",READY:\"ready\",STATECHANGE:\"stateChange\",VIEWABLECHANGE:\"viewableChange\"};var listeners={};var currentState=STATES.LOADING;var expandProperties={width:initState.width,height:initState.height,isModal:initState.isModal,useCustomClose:false};var collapseProperties={};var placementType=initState.placementType;var disable=false;var closeId=\"flurry-mraid-default-close\";var imgUrl=\"http://flurry.cachefly.net/adSpaceStyles/images/bttn-close-bw.png\";var safeClose=function(){try{if(window.mraid)window.mraid.close();else if(window.flurryadapter)flurryadapter.executeCall(\"adWillClose\");else console.log(\"unable to close\")}catch(error){console.log(\"unable to close: \"+error)}};var makeDefaultClose=function(){var img=document.createElement(\"img\");img.src=imgUrl;img.id=closeId;img.style.position=\"absolute\";img.style.top=\"10px\";img.style.right=\"10px\";img.style.width=\"50px\";img.style.height=\"50px\";img.style.zIndex=1E4;return img};var updateDefaultClose=function(){if(!expandProperties.useCustomClose&&(placementType===\"interstitial\"||currentState===STATES.EXPANDED))addDefaultClose();else removeDefaultClose()};var addDefaultClose=function(){var closeButton=document.getElementById(closeId);if(!closeButton){closeButton=makeDefaultClose();document.body.appendChild(closeButton)}};var removeDefaultClose=function(){var closeButton=document.getElementById(closeId);if(closeButton)document.body.removeChild(closeButton)};var setupDefaultCloseHandler=function(){document.body.addEventListener(\"click\",function(e){e=e||window.event;var target=e.target||e.srcElement;if(target.id===closeId)safeClose()})};var contains=function(value,obj){for(var i in obj)if(obj[i]===value)return true;return false};var stringify=function(obj){if(typeof obj==\"object\")if(obj.push){var out=[];for(var p in obj)if(obj.hasOwnProperty(p))out.push(obj[p]);return\"[\"+out.join(\",\")+\"]\"}else{var out=[];for(var p in obj)if(obj.hasOwnProperty(p))out.push(\"\'\"+p+\"\':\"+obj[p]);return\"{\"+out.join(\",\")+\"}\"}else return new String(obj)};var broadcastEvent=function(){var args=new Array(arguments.length);for(var i=0;i<arguments.length;i++)args[i]=arguments[i];var event=args.shift();try{if(listeners[event])for(var j=0;j<listeners[event].length;j++)if(typeof listeners[event][j]===\"function\")listeners[event][j].apply(undefined,args);else if(typeof listeners[event][j]===\"string\"&&typeof window[listeners[event][j]]===\"function\")window[listeners[event][j]].apply(undefined,args)}catch(e){console.log(e)}};mraid.disable=function(){removeDefaultClose();disable=true};mraid.addEventListener=function(event,listener){if(disable)return;if(!event||!listener)broadcastEvent(EVENTS.ERROR,\"Both event and listener are required.\",\"addEventListener\");else if(!contains(event,EVENTS))broadcastEvent(EVENTS.ERROR,\"Unknown event: \"+event,\"addEventListener\");else if(!listeners[event])listeners[event]=[listener];else listeners[event].push(listener);flurryBridge.executeCall(\"eventListenerAdded\")};mraid.stateChange=function(newState){if(disable)return;if(currentState===newState)return;broadcastEvent(EVENTS.INFO,\"setting state to \"+stringify(newState));var oldState=currentState;currentState=newState;if(oldState===STATES.LOADING&&newState===STATES.DEFAULT){setupDefaultCloseHandler();updateDefaultClose();broadcastEvent(EVENTS.READY)}else if(oldState===STATES.HIDDEN||newState===STATES.HIDDEN)broadcastEvent(EVENTS.VIEWABLECHANGE);else if(oldState===STATES.DEFAULT&&newState===STATES.EXPANDED)updateDefaultClose();else if(newState===STATES.DEFAULT&&oldState===STATES.EXPANDED)updateDefaultClose();broadcastEvent(EVENTS.STATECHANGE,currentState)};mraid.close=function(){if(disable)return;var state=mraid.getState();if(state===STATES.DEFAULT){mraid.stateChange(STATES.HIDDEN);flurryBridge.executeCall(\"adWillClose\")}else if(state===STATES.EXPANDED){mraid.stateChange(STATES.DEFAULT);flurryBridge.executeCall(\"collapse\")}else console.log(\"close() called in state \"+state)};mraid.expand=function(url){if(disable)return;var state=mraid.getState();if(state!==STATES.DEFAULT){console.log(\"expand() called in state \"+state);return}if(placementType===\"interstitial\"){console.log(\"expand() called for placement type \"+placementType);return}if(url)flurryBridge.executeCall(\"expand\",\"width\",expandProperties.width,\"height\",expandProperties.height,\"url\",url);else flurryBridge.executeCall(\"expand\",\"width\",expandProperties.width,\"height\",expandProperties.height);mraid.stateChange(STATES.EXPANDED)};mraid.setExpandProperties=function(properties){if(disable)return;if(typeof properties.width===\"number\"&&!isNaN(properties.width))expandProperties.width=properties.width;if(typeof properties.height===\"number\"&&!isNaN(properties.height))expandProperties.height=properties.height;if(typeof properties.useCustomClose===\"boolean\"){expandProperties.useCustomClose=properties.useCustomClose;updateDefaultClose()}};mraid.getExpandProperties=function(properties){if(disable)return;var ret={};ret.width=expandProperties.width;ret.height=expandProperties.height;ret.isModal=expandProperties.isModal;ret.useCustomClose=expandProperties.useCustomClose;return ret};mraid.getPlacementType=function(){return placementType};mraid.getVersion=function(){if(disable)return\"\";return\"1.0\"};mraid.getState=function(){if(disable)return\"\";return currentState};mraid.isViewable=function(){if(disable)return false;if(mraid.getState()===\"hidden\")return false;else return true};mraid.open=function(url){if(disable)return;try{flurryBridge.executeCall(\"open\",\"url\",url)}catch(e){console.log(e)}};mraid.playVideo=function(url){if(disable){return;}try{flurryBridge.executeCall(\"playVideo\",\"url\",url);}catch(e){console.log(e);}};mraid.removeEventListener=function(event,listener){if(disable)return;if(!event)broadcastEvent(\"error\",\"Must specify an event.\",\"removeEventListener\");else if(listener&&listeners[event])for(var i=0;i<listeners[event].length;i++){if(listeners[event][i]===listener)listeners[event].splice(i,1)}else if(listeners[event])listeners[event]=[]};mraid.useCustomClose=function(use){if(disable)return;if(typeof use===\"boolean\"){expandProperties.useCustomClose=use;updateDefaultClose()}};return mraid};");
      var2.append("window.mraid=mraidCtor(window.flurryadapter," + var1 + ");");
      var2.append("})();");
      if(this.g != null) {
         this.g.loadUrl(var2.toString());
      }

   }

   // $FF: synthetic method
   static void p(com.flurry.sdk.g var0) {
      var0.l();
   }

   private void q() {
      eo.a(3, this.b, "activateMraid");
      StringBuilder var1 = new StringBuilder();
      var1.append("javascript:");
      var1.append("if(window.mraid){window.mraid.stateChange(window.mraid.STATES.DEFAULT);}");
      if(this.g != null) {
         this.g.loadUrl(var1.toString());
      }

   }

   // $FF: synthetic method
   static void q(com.flurry.sdk.g var0) {
      var0.B();
   }

   // $FF: synthetic method
   static List r(com.flurry.sdk.g var0) {
      return var0.F;
   }

   private void r() {
      if(!(this.getContext() instanceof Activity)) {
         eo.a(3, this.b, "no activity present");
      } else {
         Activity var1 = (Activity)this.getContext();
         if(this.e()) {
            com.flurry.sdk.cb.a(var1, com.flurry.sdk.cb.a(), true);
            return;
         }
      }

   }

   private void s() {
      if(this.getContext() instanceof Activity) {
         Activity var2 = (Activity)this.getContext();
         if(this.e()) {
            int var1 = com.flurry.sdk.cb.a(var2, this.getAdUnit().u());
            if(-1 != var1) {
               com.flurry.sdk.cb.a(var2, var1, true);
               return;
            }
         }
      }

   }

   // $FF: synthetic method
   static boolean s(com.flurry.sdk.g var0) {
      return var0.I;
   }

   private void setFlurryJsEnvInitialized(boolean var1) {
      synchronized(this){}

      try {
         this.j = var1;
      } finally {
         ;
      }

   }

   private void setMraidJsEnvInitialized(boolean var1) {
      synchronized(this){}

      try {
         this.y = var1;
      } finally {
         ;
      }

   }

   // $FF: synthetic method
   static void t(com.flurry.sdk.g var0) {
      var0.u();
   }

   private boolean t() {
      return this.p != null;
   }

   // $FF: synthetic method
   static View u(com.flurry.sdk.g var0) {
      return var0.m;
   }

   private void u() {
      eo.a(3, this.b, "closing ad");
      if(this.e() || this.f()) {
         if(this.getContext() instanceof Activity) {
            ((Activity)this.getContext()).finish();
            return;
         }

         eo.a(3, this.b, "no activity present");
      }

   }

   // $FF: synthetic method
   static WebChromeClient v(com.flurry.sdk.g var0) {
      return var0.l;
   }

   private boolean v() {
      return this.s != null;
   }

   // $FF: synthetic method
   static FrameLayout w(com.flurry.sdk.g var0) {
      return var0.q;
   }

   private void w() {
      this.g.loadUrl("javascript:(function() { document.getElementById(\'flurry_interstitial_close\').style.display = \'none\'; })()");
   }

   // $FF: synthetic method
   static Dialog x(com.flurry.sdk.g var0) {
      return var0.p;
   }

   private void x() {
      if(this.e() && !this.x) {
         this.x = true;
         this.h = new Button(this.getContext());
         android.widget.RelativeLayout.LayoutParams var3 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
         var3.addRule(10);
         var3.addRule(11);
         float var1 = this.getResources().getDisplayMetrics().density;
         int var2 = (int)(10.0F * var1);
         var3.setMargins(0, var2, var2, 0);
         var2 = (int)(var1 * 50.0F);
         var3.height = var2;
         var3.width = var2;
         this.h.setLayoutParams(var3);
         this.h.setBackgroundColor(0);
         this.h.setOnClickListener(new OnClickListener() {
            public void onClick(View var1) {
               g.this.a();
            }
         });
         this.addView(this.h);
      }

   }

   // $FF: synthetic method
   static Dialog y(com.flurry.sdk.g var0) {
      return var0.s;
   }

   private void y() {
      this.g.loadUrl("javascript:if(window.mraid && typeof window.mraid.disable === \'function\'){window.mraid.disable();}");
   }

   // $FF: synthetic method
   static int z(com.flurry.sdk.g var0) {
      return var0.n;
   }

   private void z() {
      this.g.loadUrl("javascript:var closeButtonDiv =  document.getElementById(\'flurry_interstitial_close\');if (typeof(element) == \'undefined\' || element == null){var newdiv = document.createElement(\'div\');var divIdName = \'flurry_interstitial_close\';newdiv.setAttribute(\'id\',divIdName);newdiv.innerHTML = \'<a href=\"flurry://flurrycall?event=adWillClose\"><div id=\"rtb_close\"><img src=\"http://cdn.flurry.com/adSpaceStyles.dev/images/bttn-close-bw.png\" alt=\"close advertisement\" /></div></a></div>\';document.body.appendChild(newdiv);}");
   }

   public void a() {
      this.a("adWillClose", Collections.emptyMap(), this.getAdUnit(), this.getAdLog(), this.getAdFrameIndex(), 0);
   }

   public void a(com.flurry.sdk.a var1, com.flurry.sdk.ae var2, final int var3) {
      String var7 = var1.a;
      final com.flurry.sdk.q var9 = var1.c;
      Map var8 = var1.b;
      if(var3 > 10) {
         eo.a(5, this.b, "Maximum depth for event/action loop exceeded when performing action:" + var7 + "," + var8 + ",triggered by:" + var9.a);
      } else {
         if(var9.a.equals("clicked")) {
            String var10 = (String)var9.b.get("noop");
            if(var10 != null && var10.equals("true")) {
               eo.a(4, this.b, "\'clicked\' event is a noop");
               return;
            }
         }

         eo.a(3, this.b, "performAction(action=" + var7 + ",params=" + var1.b + ",triggering event=" + var9.a + ")");
         int var4;
         String var14;
         if(!var7.equals("nextFrame")) {
            if(var7.equals("closeAd")) {
               this.u();
            } else if(var7.equals("notifyUser")) {
               if(!this.A()) {
                  eo.a(6, this.b, "View not attached to any window.");
                  return;
               }

               Builder var24 = new Builder(this.getContext());
               String var20;
               if(var8.containsKey("message") && var8.containsKey("confirmDisplay") && var8.containsKey("cancelDisplay")) {
                  var14 = (String)var8.get("message");
                  var7 = (String)var8.get("confirmDisplay");
                  var20 = (String)var8.get("cancelDisplay");
               } else {
                  var14 = "Are you sure?";
                  var7 = "Cancel";
                  var20 = "OK";
               }

               var24.setMessage(var14).setCancelable(false).setPositiveButton(var20, new android.content.DialogInterface.OnClickListener() {
                  public void onClick(DialogInterface var1, int var2) {
                     HashMap var3x = new HashMap();
                     var3x.put("sourceEvent", var9.a);
                     g.this.a("userConfirmed", var3x, g.this.getAdUnit(), g.this.getAdLog(), g.this.getAdFrameIndex(), var3 + 1);
                     var1.dismiss();
                     if(g.this.e != null && g.this.getCurrentBinding() == 3) {
                        g.this.e.start();
                     }

                  }
               }).setNegativeButton(var7, new android.content.DialogInterface.OnClickListener() {
                  public void onClick(DialogInterface var1, int var2) {
                     HashMap var3x = new HashMap();
                     var3x.put("sourceEvent", var9.a);
                     g.this.a("userCanceled", var3x, g.this.getAdUnit(), g.this.getAdLog(), g.this.getAdFrameIndex(), var3 + 1);
                     var1.dismiss();
                     if(g.this.e != null && g.this.getCurrentBinding() == 3) {
                        g.this.e.setCloseConfirmDialogClicked(true);
                        g.this.e.start();
                     }

                  }
               });
               this.A = var24.create();
               if(this.e != null && this.getCurrentBinding() == 3) {
                  this.e.pause();
               }

               this.A.show();
            } else if(var7.equals("loadAdComponents")) {
               byte var5 = 1;
               byte var6 = 3;
               var3 = var6;
               var4 = var5;
               if(var8.containsKey("min")) {
                  var3 = var6;
                  var4 = var5;
                  if(var8.containsKey("max")) {
                     try {
                        var4 = Integer.parseInt((String)var8.get("min"));
                        var3 = Integer.parseInt((String)var8.get("max"));
                     } catch (NumberFormatException var12) {
                        var4 = 1;
                        var3 = 3;
                     }
                  }
               }

               int var19 = var4;
               if(1 < var4) {
                  var19 = var4 - 1;
               }

               var4 = var3;
               if(1 < var3) {
                  var4 = var3 - 1;
               }

               ArrayList var15 = new ArrayList();
               var15.add(this.getAdUnit());
               var15.addAll(this.a(this.getAdUnit().b().toString(), var19, var4));
               if(var15.size() > 0) {
                  var7 = this.a((List)var15, (String)this.getAdUnit().b().toString());
                  if(this.g != null) {
                     this.g.loadUrl("javascript:(function() {var multiadwraps=document.getElementsByClassName(\'multiAdWrap\');if(multiadwraps.length>0){var template=document.getElementsByClassName(\'multiAdWrap\')[0];var compiled=Hogan.compile(template.innerHTML);template.innerHTML=\'\';template.innerHTML=compiled.render(JSON.parse(" + var7 + "));}})();");
                     this.g.loadUrl("javascript:flurryadapter.callComplete();");
                  }

                  Iterator var16 = var15.iterator();

                  while(var16.hasNext()) {
                     AdUnit var21 = (AdUnit)var16.next();
                     HashMap var23 = new HashMap();
                     var23.put("guid", ((AdFrame)var21.d().get(0)).g().toString());
                     this.a("rendered", var23, var21, this.b(((AdFrame)var21.d().get(0)).g().toString()), 0, 0);
                  }

                  if(this.g != null && !this.a((View)this.g)) {
                     this.addView(this.g);
                  }
               } else {
                  HashMap var17 = new HashMap();
                  var8.put("errorCode", Integer.toString(com.flurry.sdk.b.d.a()));
                  this.a("renderFailed", var17, this.getAdUnit(), this.getAdLog(), this.getAdFrameIndex(), 0);
               }
            } else if(var7.equals("doExpand")) {
               var3 = fc.e();
               var4 = fc.f();
               if(var1.c.b.containsKey("width") && var1.c.b.containsKey("height")) {
                  try {
                     var3 = fc.b(Integer.parseInt((String)var1.c.b.get("width")));
                     var4 = fc.b(Integer.parseInt((String)var1.c.b.get("height")));
                  } catch (NumberFormatException var11) {
                     eo.a(6, this.b, var11.getMessage());
                     var3 = fc.e();
                     var4 = fc.f();
                  }
               }

               eo.a(3, this.b, "expand to width = " + var3 + " height = " + var4);
               if(this.getHolder() != null) {
                  this.a("clicked", Collections.emptyMap(), this.getAdUnit(), this.getAdLog(), this.getAdFrameIndex(), 0);
                  this.a(var3, var4);
               }

               if(var1.c.b.containsKey("url")) {
                  this.a = (String)var1.c.b.get("url");
                  Intent var18 = new Intent(do.a().b(), FlurryFullscreenTakeoverActivity.class);
                  var18.putExtra("url", this.a);
                  var18.putExtra("is_mraid_ad", true);
                  this.getPlatformModule().a().a(this.getContext(), var18, this.getAdUnit().b().toString());
               }
            } else if(var7.equals("doCollapse")) {
               var4 = this.getCurrentAdFrame().e().b().intValue();
               var3 = this.getCurrentAdFrame().e().c().intValue();
               var4 = fc.b(var4);
               var3 = fc.b(var3);
               if(this.a != null) {
                  this.a = null;
                  this.initLayout();
               }

               if(this.getHolder() != null) {
                  this.b(var4, var3);
               }
            } else {
               if(var7.equals("directOpen")) {
                  HashMap var22 = new HashMap();
                  var22.put("noop", "true");
                  this.a("clicked", var22, this.getAdUnit(), this.getAdLog(), this.getAdFrameIndex(), 0);
               }

               this.getPlatformModule().a().a(var1, var2, var3);
            }
         } else {
            label138: {
               var4 = this.getAdFrameIndex();
               var14 = (String)var8.get("offset");
               if(var14 != null) {
                  if(var14.equals("next")) {
                     var3 = this.getAdFrameIndex() + 1;
                     break label138;
                  }

                  if(var14.equals("current")) {
                     return;
                  }

                  try {
                     var3 = Integer.parseInt(var14);
                     break label138;
                  } catch (NumberFormatException var13) {
                     eo.a(6, this.b, "caught: " + var13.getMessage());
                  }
               }

               var3 = var4 + 1;
            }

            this.a(var1, var3);
         }

         this.a(var1);
      }
   }

   public void a(String var1, Map var2, AdUnit var3, com.flurry.sdk.e var4, int var5, int var6) {
      eo.a(3, this.b, "fireEvent(event=" + var1 + ",params=" + var2 + ")");
      this.getPlatformModule().a((com.flurry.sdk.q)(new com.flurry.sdk.q(var1, var2, this.getContext(), var3, var4, var5)), (com.flurry.sdk.ad)this, var6);
   }

   boolean a(View var1) {
      ViewParent var2 = var1.getParent();
      return var2 != null && var2 == this;
   }

   @TargetApi(11)
   public void b() {
      if(this.g != null && VERSION.SDK_INT >= 11) {
         this.f = true;
         this.g.onResume();
      }

      if(this.e != null) {
         if(this.A != null && this.H) {
            this.A.show();
            this.H = false;
            eo.a(3, this.b, "Alert dialog in foreground. Do nothing and wait for user input.");
         } else {
            this.f = true;
            this.e.e();
         }
      }

      this.I = true;
   }

   @TargetApi(11)
   public void c() {
      if(this.g != null && VERSION.SDK_INT >= 11) {
         this.g.onPause();
      }

      if(this.e != null) {
         if(this.A != null && this.A.isShowing()) {
            this.A.dismiss();
            this.H = true;
         }

         this.e.pause();
         this.e.d();
      }

      this.f = false;
      this.I = true;
   }

   public boolean d() {
      return this.A != null && this.A.isShowing();
   }

   boolean e() {
      return this.getCurrentFormat().equals("takeover");
   }

   boolean f() {
      return this.getPlatformModule().S() != null;
   }

   boolean g() {
      boolean var1 = ev.a().c();
      if(!var1) {
         eo.a(5, this.b, "There is no network connectivity (ad will not rotate)");
      }

      return !this.v() && !this.t() && var1;
   }

   AdFrame getCurrentAdFrame() {
      return (AdFrame)this.B.get(this.getAdFrameIndex());
   }

   public int getCurrentBinding() {
      return this.getCurrentAdFrame().b().intValue();
   }

   String getCurrentContent() {
      return this.getCurrentAdFrame().d().toString();
   }

   String getCurrentDisplay() {
      return this.getCurrentAdFrame().c().toString();
   }

   String getCurrentFormat() {
      return this.getCurrentAdFrame().e().e().toString();
   }

   public FlurryFullscreenTakeoverActivity getFullScreenTakeover() {
      return this.z;
   }

   com.flurry.sdk.l getHolder() {
      ViewParent var1 = this.getParent();
      return var1 instanceof com.flurry.sdk.l?(com.flurry.sdk.l)var1:null;
   }

   public com.flurry.sdk.f getVideoView() {
      return this.e;
   }

   public void initLayout() {
      boolean var1 = false;
      eo.a(3, this.b, "initLayout: ad creative layout: {width = " + this.getCurrentAdFrame().e().b() + ", height = " + this.getCurrentAdFrame().e().c() + "}");
      Context var2 = this.getContext();
      this.removeAllViews();
      this.setFocusable(true);
      this.setFocusableInTouchMode(true);
      switch(this.getCurrentBinding()) {
      case 1:
         if(this.g == null) {
            this.g = new WebView(var2);
            this.g.getSettings().setJavaScriptEnabled(true);
            this.g.setVerticalScrollBarEnabled(false);
            this.g.setHorizontalScrollBarEnabled(false);
            this.g.setBackgroundColor(0);
            this.g.clearCache(false);
            this.l = new g$a(this, null);
            this.g.setWebChromeClient(this.l);
            this.k = new g$b(this, null);
            this.g.setWebViewClient(this.k);
         }

         if(this.a != null) {
            this.a(this.a);
         } else if(this.getAdFrameIndex() == 0) {
            String var6 = this.getPlatformModule().d().b(this.getAdUnit().b().toString());
            if(var6 == null) {
               this.a(this.getCurrentDisplay());
            } else {
               String var4 = com.flurry.sdk.cf.c(this.getCurrentDisplay());
               this.g.loadDataWithBaseURL(var4, var6, "text/html", "utf-8", var4);
               this.a("rendered", Collections.emptyMap(), this.getAdUnit(), this.getAdLog(), this.getAdFrameIndex(), 0);
            }
         } else {
            this.a(this.getCurrentDisplay());
         }

         this.g.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
         this.B();
         if(this.e()) {
            this.a(var2);
         }

         this.s();
         return;
      case 2:
         com.flurry.sdk.ci var3 = this.getPlatformModule().b(((AdFrame)this.B.get(this.getAdFrameIndex())).g().toString());
         if(var3 != null) {
            if(!TextUtils.isEmpty(com.flurry.sdk.cf.a(var3.a(com.flurry.sdk.cp.b)))) {
               var1 = true;
            }

            this.a(var3.f(), var1);
            return;
         }

         if(this.g == null) {
            this.g = new WebView(var2);
            this.g.getSettings().setJavaScriptEnabled(true);
            this.g.setVerticalScrollBarEnabled(false);
            this.g.setHorizontalScrollBarEnabled(false);
            this.g.setBackgroundColor(0);
            this.g.clearCache(false);
            this.l = new g$a(this, null);
            this.g.setWebChromeClient(this.l);
            this.k = new g$b(this, null);
            this.g.setWebViewClient(this.k);
         }

         this.g.loadDataWithBaseURL("base://url/", this.getCurrentDisplay(), "text/html", "utf-8", "base://url/");
         this.a("rendered", Collections.emptyMap(), this.getAdUnit(), this.getAdLog(), this.getAdFrameIndex(), 0);
         this.g.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
         this.B();
         if(this.e()) {
            this.a(var2);
         }

         this.s();
         return;
      case 3:
         this.a(this.getCurrentDisplay().toString(), false);
         return;
      default:
         HashMap var5 = new HashMap();
         var5.put("errorCode", Integer.toString(com.flurry.sdk.b.f.a()));
         this.a("renderFailed", var5, this.getAdUnit(), this.getAdLog(), this.getAdFrameIndex(), 0);
      }
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.G = true;
   }

   @TargetApi(11)
   public void onDestroy() {
      eo.a(3, this.b, "onDestroy");
      if(this.getCurrentBinding() == 3 && this.e != null && this.e.isPlaying()) {
         this.e.c();
      }

      this.B();
      if(this.A != null && this.A.isShowing()) {
         this.A.dismiss();
      }

      if(this.e != null) {
         this.e.f();
      }

      if(this.g != null) {
         if(this.m != null && this.l != null) {
            this.l.onHideCustomView();
         }

         if(this.s != null) {
            this.b(0, 0);
         }

         this.removeView(this.g);
         this.g.stopLoading();
         if(VERSION.SDK_INT >= 11) {
            this.g.onPause();
         }

         this.g.destroy();
         this.g = null;
      }

      if(this.e()) {
         this.a("adClosed", Collections.emptyMap(), this.getAdUnit(), this.getAdLog(), this.getAdFrameIndex(), 0);
      }

   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.G = false;
   }

   public boolean onKey(DialogInterface var1, int var2, KeyEvent var3) {
      eo.a(3, "listeners", "onkey,keycode=" + var2 + ",event=" + var3.getAction());
      if(var1 == this.d && var2 == 4 && var3.getAction() == 1) {
         this.a();
         var1.dismiss();
         return true;
      } else {
         return false;
      }
   }

   public void setFullScreenTakeover(FlurryFullscreenTakeoverActivity var1) {
      this.z = var1;
   }

   public void setVideoState(com.flurry.sdk.am var1) {
      if(this.e != null) {
         this.e.setVideoState(var1);
      }

   }
}
