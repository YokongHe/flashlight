package com.mopub.common;

import com.mopub.common.DiskLruCache$Editor;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class DiskLruCache$Editor$FaultHidingOutputStream extends FilterOutputStream {
   // $FF: synthetic field
   final DiskLruCache$Editor this$1;

   private DiskLruCache$Editor$FaultHidingOutputStream(DiskLruCache$Editor var1, OutputStream var2) {
      super(var2);
      this.this$1 = var1;
   }

   // $FF: synthetic method
   DiskLruCache$Editor$FaultHidingOutputStream(DiskLruCache$Editor var1, OutputStream var2, DiskLruCache$Editor$FaultHidingOutputStream var3) {
      this(var1, var2);
   }

   public void close() {
      try {
         this.out.close();
      } catch (IOException var2) {
         DiskLruCache$Editor.access$0(this.this$1, true);
      }
   }

   public void flush() {
      try {
         this.out.flush();
      } catch (IOException var2) {
         DiskLruCache$Editor.access$0(this.this$1, true);
      }
   }

   public void write(int var1) {
      try {
         this.out.write(var1);
      } catch (IOException var3) {
         DiskLruCache$Editor.access$0(this.this$1, true);
      }
   }

   public void write(byte[] var1, int var2, int var3) {
      try {
         this.out.write(var1, var2, var3);
      } catch (IOException var4) {
         DiskLruCache$Editor.access$0(this.this$1, true);
      }
   }
}
