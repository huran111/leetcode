package 代理;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-12 22:13
 */
 interface ClothFactory {
    void produceCloth();
}
class ProxyClothFactory implements ClothFactory{
    private ClothFactory clothFactory;
    public ProxyClothFactory(ClothFactory clothFactory){
        this.clothFactory=clothFactory;
    }
    @Override
    public void produceCloth() {
        System.out.println("代理准备");
        clothFactory.produceCloth();
        System.out.println("代理结束");
    }
}

class NickClothFacory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Neck生产鞋子");
    }
}
public class StaticProxyTest{
    public static void main(String[] args) {
        NickClothFacory nick=new NickClothFacory();
        final ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nick);
        proxyClothFactory.produceCloth();
    }
}