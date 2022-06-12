package cn.itcast.netty.c1;

import java.nio.ByteBuffer;

/**
 * @author old money
 * @create 2022-06-12 15:29
 */
public class TestByteBufferAllocate {

    public static void main(String[] args) {
        System.out.println(ByteBuffer.allocate(10).getClass());
        System.out.println(ByteBuffer.allocateDirect(10).getClass());

        /**
         * class java.nio.HeapByteBuffer   - java堆内存,读写效率较低,收到GC的影响
         * class java.nio.DirectByteBuffer - 直接内存，读写效率高(少一次拷贝),不会受到GC的影响
         */

    }
}
