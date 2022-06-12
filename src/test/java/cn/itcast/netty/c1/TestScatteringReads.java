package cn.itcast.netty.c1;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import static cn.itcast.netty.c1.ByteBufferUtil.debugAll;

/**
 * @author old money
 * @create 2022-06-12 16:24
 */
public class TestScatteringReads {
    public static void main(String[] args) {


        //分散读取
        try (FileChannel channel = new FileInputStream("words.txt").getChannel()) {

            ByteBuffer b1 = ByteBuffer.allocate(3);
            ByteBuffer b2 = ByteBuffer.allocate(3);
            ByteBuffer b3 = ByteBuffer.allocate(5);

            channel.read(new ByteBuffer[]{b1,b2,b3});
            b1.flip();
            b2.flip();
            b3.flip();

            debugAll(b1);
            debugAll(b2);
            debugAll(b3);

        } catch (IOException e) {
        }

    }

}
