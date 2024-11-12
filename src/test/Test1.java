package test;

/**
 * 8.21
 * java方法传参机制
 * 核心思想：
 * 1.java传参只能按值调用，方法不可能修改基本数据类型的参数
 * 2.方法可以改变对象参数的状态（即可以改变对象的属性，但是不可能改变对象的引用）
 * 3.方法不可能让一个对象参数引用一个新的对象
 *
 * 本题与装箱拆箱无关
 */

public class Test1 {

    public static void main(String[] args) {
        int per = 10;
        /**
         *  Integer var1 = new Integer(1)
         *  等同于 Integer var1 = 1
         *  这里是手动装箱，将基本类型变成包装类
         */
        Integer var1 = new Integer(1);
        Integer var2 = var1;
        /**
         * doSomething方法引用了对象参数var2，但是不可能让var2去引用一个新的对象
         * 因此var2 = 1 = var1
         */
        doSomething(var2);
        /**
         * intValue()是手动拆箱，打印结果：1
         */
        System.out.println(var1.intValue());
//        System.out.println("var2 = " + var2);
        System.out.println(var1==var2);

        new Test1().tripleValue(per);
        System.out.println(per);//结果仍为10，方法不会改变基本数据类型的值

    }

    public static void doSomething(Integer integer){
        /**
         * integer初始化为var2的一个副本
         * 之后integer指向一个新的对象 integer = 2
         * 方法结束后，integer就不再使用
         * var2仍然指向原来的地址
         */
        integer = new Integer(2);
    }

    public void tripleValue(int per){
        /**
         * 这里的等号左边的per只是参数值的一个副本，并不是原来的参数变量，
         * 方法结束之后就不再使用
         */
        per = per * 3;
    }
}
