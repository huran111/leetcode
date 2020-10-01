package proxy.staticproxy;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-27 21:57
 */
public class Father {
    private Person person;
    public Father(Person person){
        this.person=person;
    }
    public  void findLove(){
        System.out.println("父亲物色对象");
        this.person.findLove();
        System.out.println("双方父母同意，确认关系");
    }
}