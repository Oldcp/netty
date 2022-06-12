package cn.itcast.netty.c1;

import java.nio.ByteBuffer;

import static cn.itcast.netty.c1.ByteBufferUtil.debugAll;

/**
 * @author old money
 * @create 2022-06-12 16:42
 */
public class TestByteBufferExam {

    public static void main(String[] args) {


        // 粘包 半包
        ByteBuffer buffer = ByteBuffer.allocate(32);
        buffer.put("Hello,word\nI'm zhangsan\nHo".getBytes());
        split(buffer);
        buffer.put("w are you?\n".getBytes());
        split(buffer);

    }

    private static void split(ByteBuffer buffer){
        buffer.flip();
        for (int i = 0; i < buffer.limit(); i++) {

            //找到一条完整消息
            if (buffer.get(i) == '\n'){
                int length = i +1 - buffer.position();
                ByteBuffer target = ByteBuffer.allocate(length);

                //从buffer中读取完整消息写入
                for (int j = 0; j < length; j++) {
                    byte b = buffer.get();
                    target.put(b);
                }
                debugAll(target);
            }

        }

        buffer.compact();


    }
}
