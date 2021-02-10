import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2021-01-02 18:16
 */
public class Main {
    public static void main(String[] args) {
        UnionFine_QU qu=new UnionFine_QU(1);
        long l = System.currentTimeMillis();
        qu.testTimeUnionFine_QU();
        System.out.println((System.currentTimeMillis() - l) / 1000);
    }

}