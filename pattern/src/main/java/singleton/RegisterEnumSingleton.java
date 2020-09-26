package singleton;

/**
 * @program: leetcode
 * @description: 注册式单利
 * @author: HuRan
 * @create: 2020-09-25 23:02
 */
public enum  RegisterEnumSingleton {
    INSTANCE;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static RegisterEnumSingleton getInstance(){
        return INSTANCE;
    }
}