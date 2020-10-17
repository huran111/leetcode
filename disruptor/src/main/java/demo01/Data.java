package demo01;


import java.io.Serializable;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-26 12:43
 */
public class Data  implements Serializable {
    private Long id;
    private String name;
    public Data(){}

    public Data(Long id,String name){
        super();
        this.id=id;
        this.name=name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}