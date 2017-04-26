package com.flurry.sdk;

public enum co {
   a("unknown"),
   b("creativeView"),
   c("start"),
   d("midpoint"),
   e("firstQuartile"),
   f("thirdQuartile"),
   g("complete"),
   h("mute"),
   i("unmute"),
   j("pause"),
   k("rewind"),
   l("resume"),
   m("fullscreen"),
   n("expand"),
   o("collapse"),
   p("acceptInvitation"),
   q("close");

   private String r;

   private co(String var3) {
      this.r = var3;
   }

   public static com.flurry.sdk.co a(String var0) {
      return b.a().equals(var0)?b:(c.a().equals(var0)?c:(d.a().equals(var0)?d:(e.a().equals(var0)?e:(f.a().equals(var0)?f:(g.a().equals(var0)?g:(h.a().equals(var0)?h:(i.a().equals(var0)?i:(j.a().equals(var0)?j:(k.a().equals(var0)?k:(l.a().equals(var0)?l:(m.a().equals(var0)?m:(n.a().equals(var0)?n:(o.a().equals(var0)?o:(p.a().equals(var0)?p:(q.a().equals(var0)?q:a)))))))))))))));
   }

   public final String a() {
      return this.r;
   }
}
