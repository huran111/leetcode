package com.hr.对象创建;

/**
 * @program: leetcode
 * @description: 加载类元信息，为对象分配内存，处理并发问题，属性默认初始化，设置对象头信息，属性的显示初始化，代码块中初始化，构造器中初始化
 * @author: HuRan
 * @create: 2021-02-24 20:25
 */
public class Customer {
    int id = 1001;
    String name;
    Account account;

    {
        name = "胡冉";
    }

    public Customer() {
        account = new Account();
    }
}

class Account {

}