package cn.itcast.netty.c1;


import java.nio.ByteBuffer;
import static cn.itcast.netty.c1.ByteBufferUtil.debugAll;
/**
 * @author old money
 * @create 2022-06-12 15:21
 */
public class TestByteBufferReadWrite {
    public static void main(String[] args) {

        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.clear();
        buffer.put((byte) 97);

        debugAll(buffer);

    }

}
