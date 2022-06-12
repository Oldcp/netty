package cn.itcast.netty.c1;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static cn.itcast.netty.c1.ByteBufferUtil.debugAll;

/**
 * @author old money
 * @create 2022-06-12 16:10
 */
public class TestByteBufferString {

    public static void main(String[] args) {
        //1.将字符串转为ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.put("hello".getBytes());
        debugAll(buffer);

        //2.Charset
        ByteBuffer hello = StandardCharsets.UTF_8.encode("hello");
        debugAll(hello);

        //3.wrap
        ByteBuffer buffer3 = ByteBuffer.wrap("hello".getBytes());
        debugAll(buffer3);

        //转为字符串
        String string = StandardCharsets.UTF_8.decode(hello).toString();
        System.out.println(string);
    }
}
