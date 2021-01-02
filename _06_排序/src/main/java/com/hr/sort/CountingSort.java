package com.hr.sort;

/**
 * 计数排序:1.针对整数进行排序
 * 2. 针对一定范围进行排序
 * 3. 空间换时间
 * 4.核心思想：统一每个整数在序列中出现的次数，进而推导出来每个整数在有序序列中的索引
 * 5.
 */
public class CountingSort extends Sort<Integer> {

    /**
     * 假设array中的最小值是min
     * array中的元素k对应的counts索引是k-min
     * array中的元素k在有序序列中的索引 counts[k-min](次数)-p (p倒数第个k)
     */
    @Override
    protected void sort() {
        // 找出最值
        int max = array[0];//找出最大值
        int min = array[0]; //找出最小值
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            //不要else if 有可能做大和最小时一样的值  所以要分开去判断的
            if (array[i] < min) {
                min = array[i];
            }
        }//O(n)


        // 开辟内存空间，存储次数
        int[] counts = new int[max - min + 1];
        // 统计每个整数出现的次数
        for (int i = 0; i < array.length; i++) {
            int data = array[i] - min;//拿到array数组中的元素对应的索引
            int count_data = counts[data];//该索引值默认为0  该步骤是将data当成counts数组中的索引，如果第一次 此时count_data的值为0
			count_data++;//将出现元素累加对应到counts数组中去
            counts[data] = count_data;
        }//O(n)

        // 累加次数 将数组中的元素分别于小于该索引的元素做累加，包括自己的索引的值
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        // 从后往前遍历元素（此时具备了有序性，为什么，从原始数组），将它放到有序数组中的合适位置 newArray 有序数组
        int[] newArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
			Integer old_data = array[i];//原始数组中的值
			int index=old_data-min;//减去最小值得到它在counts数组中的索引位置
			int count=counts[index];//得到该元素出现的次数的累加值
			--count;
			newArray[count] = array[i];
        }

        // 将有序数组赋值(覆盖)到array
        for (int i = 0; i < newArray.length; i++) {
            array[i] = newArray[i];
        }
    }

    protected void sort0() {
        // 找出最大值
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        } // O(n)

        // 开辟内存空间，存储每个整数出现的次数
        int[] counts = new int[1 + max];
        // 统计每个整数出现的次数
        for (int i = 0; i < array.length; i++) {
            counts[array[i]]++;
        } // O(n)

        // 根据整数的出现次数，对整数进行排序
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i]-- > 0) {
                array[index++] = i;
            }
        } // O(n)
    }

    public static void main(String[] args) {
        Person[] persons = new Person[]{
                new Person(20, "A"),
                new Person(-13, "B"),
                new Person(17, "C"),
                new Person(12, "D"),
                new Person(-13, "E"),
                new Person(20, "F")
        };

        // 找出最值
        int max = persons[0].age;
        int min = persons[0].age;
        for (int i = 1; i < persons.length; i++) {
            if (persons[i].age > max) {
                max = persons[i].age;
            }
            if (persons[i].age < min) {
                min = persons[i].age;
            }
        }

        // 开辟内存空间，存储次数
        int[] counts = new int[max - min + 1];
        // 统计每个整数出现的次数
        for (int i = 0; i < persons.length; i++) {
            counts[persons[i].age - min]++;
        }
        // 累加次数
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        // 从后往前遍历元素，将它放到有序数组中的合适位置
        Person[] newArray = new Person[persons.length];
        for (int i = persons.length - 1; i >= 0; i--) {
            newArray[--counts[persons[i].age - min]] = persons[i];
        }

        // 将有序数组赋值到array
        for (int i = 0; i < newArray.length; i++) {
            persons[i] = newArray[i];
        }

        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]);
        }
    }

    private static class Person {
        int age;
        String name;

        Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person [age=" + age
                    + ", name=" + name + "]";
        }
    }
}
