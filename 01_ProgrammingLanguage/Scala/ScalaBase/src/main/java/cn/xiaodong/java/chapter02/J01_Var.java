package cn.xiaodong.java.chapter02;

/**
 * Java静态变量测试
 *
 * @author: xiaodong
 * @create: 2022-02-08 17:18
 **/
public class J01_Var {

    final static String name = "xiaodong";

    final static Person p1 = new Person("xiaodong", 18);

    public static void main(String[] args) {
        //        name = "xiaoxi";
        //        p1 = new Person("jingjing",16);


        // Java与Scala一样，当静态变量是引用类型时，对象则不可改变，但对象的状态（值）却是可以改变的。（比如：自定义对象、数组、集合等等）
        p1.setName("lisi");
        System.out.println(p1.getName());


    }
}
