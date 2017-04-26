package org.a.a.j;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;

class e extends org.a.a.j.a {
   public static Pattern i = Pattern.compile("[\\x00-\\x08\\x0B\\x0C\\x0E-\\x1F]");
   public static Pattern j = Pattern.compile("\n|\u0085|\u2028|\u2029");
   protected Map g;
   protected TimeZone h = null;

   public e() {
      this.b = new org.a.a.j.n(this);
      this.a.put(String.class, new org.a.a.j.q(this));
      this.a.put(Boolean.class, new org.a.a.j.g(this));
      this.a.put(Character.class, new org.a.a.j.q(this));
      this.a.put(byte[].class, new org.a.a.j.h(this));
      this.c.put(Number.class, new org.a.a.j.o(this));
      this.c.put(List.class, new org.a.a.j.l(this));
      this.c.put(Map.class, new org.a.a.j.m(this));
      this.c.put(Set.class, new org.a.a.j.p(this));
      this.c.put(Iterator.class, new org.a.a.j.k(this));
      this.c.put((new Object[0]).getClass(), new org.a.a.j.f(this));
      this.c.put(Date.class, new org.a.a.j.i(this));
      this.c.put(Enum.class, new org.a.a.j.j(this));
      this.c.put(Calendar.class, new org.a.a.j.i(this));
      this.g = new HashMap();
   }

   public void a(TimeZone var1) {
      this.h = var1;
   }
}
