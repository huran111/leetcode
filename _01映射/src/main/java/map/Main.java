package map;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Double.doubleToLongBits;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-06-20 13:18
 */
public class Main {
    public static void main(String[] args) {
        Person p1=new Person(1,2L,"huran");
        Person p2=new Person(1,2L,"huran");
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        //只实现equals 不稳定
        Map<Object,Object> map=new HashMap<>();
        map.put(p1,"a");
        map.put(p2,"b");
        map.put("test","b");

        System.out.println(map.size());
    }


    //Double的hash值
    public static int hashCode(double value) {
        long bits = doubleToLongBits(value);
        return (int)(bits ^ (bits >>> 32));
    }
    //String的hash值
    public static int hashCode(String value) {
        int len=value.length();
        int hashcode=0;
        for(int i=0;i<len;i++){
            char c=value.charAt(i);
            hashcode=hashcode*31+c;
        }
        return  hashcode;
    }

}