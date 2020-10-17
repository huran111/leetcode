## Redis

### string入门操作

#### Set命令
1.NX:标识key不存在才设置，如果存在则返回null
2.XX:标识key存在时才设置，如果不存在则返回null
3.EX:seconds:设置过期时间，过期时间为精确到秒

4.PX:millseconds:设置过期时间，过期时间精确到毫秒
**NX:**

```java
set a a
"OK"
get a
"a"
set a b NX
null
```

**XX：**

```java
62.234.151.151:5> set  xx  xx XX
null
62.234.151.151:5>
```

**EX:**

```java
62.234.151.151:5>set  huran 123456 EX 5
"OK"
```

**PX:**

```java
62.234.151.151:5>set huran 1111 PX 100000
"OK"
```

-------

#### MSET命令

作用：批量获取值

```java
62.234.151.151:5>mset huran1 1 huran2 2 huran3 3
"OK"
62.234.151.151:5>get huran2 
"2"
```

#### MGET命令

作用：批量取值

```java
62.234.151.151:5>mget huran1 huran2 huran3
 1)  "1"
 2)  "2"
 3)  "3"
```

#### GETSET命令

作用：先查key获取value的值在修改新值

62.234.151.151:5>set huran1 1
"OK"
62.234.151.151:5>get huran1
"1"
62.234.151.151:5>getset huran1 2
"1"
62.234.151.151:5>get huran1
"2"



#### SETRANGE命令

作用：按照范围设置值

```java
62.234.151.151:5>set user 123455
"OK"
62.234.151.151:5>get user
"123455"
62.234.151.151:5>setrange user 2 huran
"7"
62.234.151.151:5>get user
"12huran"
```

#### GETRANGE命令

作用：获取指定范围

```java
62.234.151.151:5>get user
"12huran"
62.234.151.151:5>getrange user 0 1
"12"
```

#### APPEND命令

作用：字符串追加

```java
62.234.151.151:5>get user
"12huran"
62.234.151.151:5>append user a
"8"
62.234.151.151:5>get user
"12hurana"
```



#### SUBSTR命令

作用：字符串截取

```java
62.234.151.151:5>get user
"12huran"
62.234.151.151:5>substr user 0 3
"12hu"
```

###  数字操作

#### INCR命令

作用：计数器， 指定的key加1，必须为int类型 返回操作后的值

```
62.234.151.151:5> set count 0
"OK"
62.234.151.151:5>incr count
"1"
62.234.151.151:5>incr count
"2"
62.234.151.151:5>decr count
"1"
```



#### DECR命令

作用：计数器， 指定的key减1，必须为int类型，返操作后的值

```
62.234.151.151:5> set count 0
"OK"
62.234.151.151:5>incr count
"1"
62.234.151.151:5>incr count
"2"
62.234.151.151:5>decr count
"1"
```

#### INCRBY命令

作用：指定增加数量

```java
62.234.151.151:5>get count
"1"
62.234.151.151:5>incrby count 2
"3"
62.234.151.151:5>decrby count 5
"-2"
```



#### DECRBY命令

作用：指定减少数量

```java
62.234.151.151:5>get count
"1"
62.234.151.151:5>incrby count 2
"3"
62.234.151.151:5>decrby count 5
"-2"
```

#### INCRBYFLOUT命令

作用：在原有的key加上浮点数

```java
62.234.151.151:5>set money 5
"OK"
62.234.151.151:5>incrbyfloat money 2.5
"7.5"
```

