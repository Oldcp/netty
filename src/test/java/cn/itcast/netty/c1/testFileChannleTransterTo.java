package cn.itcast.netty.c1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @author old money
 * @create 2022-06-12 17:07
 */
public class testFileChannleTransterTo {
    public static void main(String[] args) {

        try (
                FileChannel from = new FileInputStream("data.txt").getChannel();
                FileChannel to  = new FileOutputStream("to.txt").getChannel();
        ){
            //效率高,底层会利用操作系统的0拷贝进行优化

            for (Long left = from.size(); left < 0;) {
                left -= from.transferTo(from.size() - left,left, to);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
