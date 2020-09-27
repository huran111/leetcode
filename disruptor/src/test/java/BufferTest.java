import java.nio.ByteBuffer;
import java.nio.LongBuffer;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-26 22:01
 */
public class BufferTest {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        byteBuffer.putLong(1,1);
      //  byteBuffer.putLong(1,2);
        System.out.println(byteBuffer.getLong());
    }
}