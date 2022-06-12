package cn.itcast.netty.c1;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author old money
 * @create 2022-06-12 14:46
 */
@Slf4j
public class TestByteBuffer {

    public static void main(String[] args) {

        //FileChannel
        //1.输入输出流 2.RandomAccessFile
        try (FileChannel channel = new FileInputStream("data.txt").getChannel()) {
            //准备缓冲区 ByteBuffer
            ByteBuffer buffer = ByteBuffer.allocate(10);

           while (true){
               // 从channel 读取数据，向buffer写入
               int read = channel.read(buffer);
               log.debug("读取到的字节数量"+read);
                if (read == -1){ //缓冲区无内容 则退出
                    break;
                }
               buffer.flip(); //切换到读模式
               while (buffer.hasRemaining()){//是否还有剩余数据
                   byte b = buffer.get();
                   log.debug("实际字节"+(char)b);
               }
               //buffer切换为写模式
               buffer.clear();
           }

        } catch (IOException e) {
        }

    }

}
