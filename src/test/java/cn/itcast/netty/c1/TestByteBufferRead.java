package cn.itcast.netty.c1;

import java.nio.ByteBuffer;
import static cn.itcast.netty.c1.ByteBufferUtil.debugAll;
/**
 * @author old money
 * @create 2022-06-12 15:37
 */
public class TestByteBufferRead {
    public static void main(String[] args) {

        ByteBuffer buffer = ByteBuffer.allocate(10);

        buffer.put(new byte[]{'a','b','c','d'});

        buffer.flip();

       //从头开始读
         buffer.get(new byte[4]);
        debugAll(buffer);

        //rewind从头开始读
        buffer.rewind();

        //mark & reset
        //mark 做一个标记，记录position位置，rest是将position重置到mark位置

        //get(i) 按照索引读取，不会改变指针位置

    }
}
