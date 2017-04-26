package com.inmobi.commons.thinICE.icedatacollector;

public class ThinICEConfigSettings {
   public static final int CELL_OP_FLAG_DISABLE_CURRENT_DETAILS = 2;
   public static final int CELL_OP_FLAG_DISABLE_SIM_DETAILS = 1;
   public static final int WIFI_FLAG_DISABLE_NOMAP_EXCLUSION = 2;
   public static final int WIFI_FLAG_DISABLE_SSID_COLLECTION = 1;
   private boolean a = true;
   private boolean b = true;
   private boolean c = true;
   private boolean d = true;
   private boolean e = true;
   private boolean f = true;
   private boolean g = true;
   private long h = 60000L;
   private long i = 3000L;
   private int j = 50;
   private int k = 0;
   private int l = 0;

   public ThinICEConfigSettings() {
   }

   public ThinICEConfigSettings(ThinICEConfigSettings var1) {
      this.a = var1.a;
      this.b = var1.b;
      this.c = var1.c;
      this.d = var1.d;
      this.e = var1.e;
      this.f = var1.f;
      this.g = var1.g;
      this.h = var1.h;
      this.i = var1.i;
      this.j = var1.j;
      this.k = var1.k;
      this.l = var1.l;
   }

   public static boolean bitTest(int var0, int var1) {
      return (var0 & var1) == var1;
   }

   public int getCellOpFlags() {
      return this.l;
   }

   public int getSampleHistorySize() {
      return this.j;
   }

   public long getSampleInterval() {
      return this.h;
   }

   public long getStopRequestTimeout() {
      return this.i;
   }

   public int getWifiFlags() {
      return this.k;
   }

   public boolean isEnabled() {
      return this.a;
   }

   public boolean isSampleCellEnabled() {
      return this.c;
   }

   public boolean isSampleCellOperatorEnabled() {
      return this.b;
   }

   public boolean isSampleConnectedWifiEnabled() {
      return this.d;
   }

   public boolean isSampleLocationEnabled() {
      return this.e;
   }

   public boolean isSampleVisibleCellTowerEnabled() {
      return this.g;
   }

   public boolean isSampleVisibleWifiEnabled() {
      return this.f;
   }

   public ThinICEConfigSettings setCellOpFlags(int var1) {
      this.l = var1;
      return this;
   }

   public ThinICEConfigSettings setEnabled(boolean var1) {
      this.a = var1;
      return this;
   }

   public ThinICEConfigSettings setSampleCellEnabled(boolean var1) {
      this.c = var1;
      return this;
   }

   public ThinICEConfigSettings setSampleCellOperatorEnabled(boolean var1) {
      this.b = var1;
      return this;
   }

   public ThinICEConfigSettings setSampleConnectedWifiEnabled(boolean var1) {
      this.d = var1;
      return this;
   }

   public ThinICEConfigSettings setSampleHistorySize(int var1) {
      if(var1 <= 0) {
         throw new IllegalArgumentException("Sample history size must be greater than 0");
      } else {
         this.j = var1;
         return this;
      }
   }

   public ThinICEConfigSettings setSampleInterval(long var1) {
      if(var1 <= 0L) {
         throw new IllegalArgumentException("Sample interval must be greater than 0");
      } else {
         this.h = var1;
         return this;
      }
   }

   public ThinICEConfigSettings setSampleLocationEnabled(boolean var1) {
      this.e = var1;
      return this;
   }

   public ThinICEConfigSettings setSampleVisibleCellTowerEnabled(boolean var1) {
      this.g = var1;
      return this;
   }

   public ThinICEConfigSettings setSampleVisibleWifiEnabled(boolean var1) {
      this.f = var1;
      return this;
   }

   public ThinICEConfigSettings setStopRequestTimeout(long var1) {
      if(var1 <= 0L) {
         throw new IllegalArgumentException("Stop request timeout must be greater than 0");
      } else {
         this.i = var1;
         return this;
      }
   }

   public ThinICEConfigSettings setWifiFlags(int var1) {
      this.k = var1;
      return this;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.getClass().getSimpleName()).append("[");
      var1.append("mEnabled=").append(this.a).append(", ");
      var1.append("mSampleCellOperatorEnabled=").append(this.b).append(", ");
      var1.append("mSampleCellEnabled=").append(this.c).append(", ");
      var1.append("mSampleConnectedWifiEnabled=").append(this.d).append(", ");
      var1.append("mSampleLocationEnabled=").append(this.e).append(", ");
      var1.append("mSampleVisibleWifiEnabled=").append(this.f).append(", ");
      var1.append("mSampleVisibleCellTowerEnabled=").append(this.g).append(", ");
      var1.append("mSampleInterval=").append(this.h).append(", ");
      var1.append("mStopRequestTimeout=").append(this.i).append(", ");
      var1.append("mWifiFlags=").append(Integer.toBinaryString(this.k)).append(", ");
      var1.append("mCellOpFlags=").append(Integer.toBinaryString(this.l));
      var1.append("]");
      return var1.toString();
   }
}
