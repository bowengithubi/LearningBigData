package cn.xiaodong.scala.demo.chapter02

/**
 * Scala变量
 *
 * @author: xiaodong
 * @create: 2021-10-02 12:05
 * */
object S02_Var {

  /*
  变量：在程序执行的过程中，其值，可以改变
    Java：
      数据类型 变量名 = 值;
      int a=10;
    Scala：
      var 变量名称:变量类型 = 值
      var a:Int = 10

  常量：在程序执行的过程中，其值，不会发生改变
    Java:
      final 数据类型 变量名 = 值;
    Scala:
      val 变量名称:变量类型 = 值
   */

  def main(args: Array[String]): Unit = {

    // 声明一个变量a，并赋值为10
    var a: Int = 10
    println(a)
    // （1）声明变量时，类型可以省略，编译器自动推导，即类型推导
    var b = 10
    println(b)

    // （2）类型确定后，就不能修改，说明Scala是强数据类型语言。
    //    b="10"  // 此行代码会报错，因为之前声明b的时候，赋值为Int，现在赋值改为String，不允许

    // （3）变量声明时，必须要有初始值
    var c: Int = 100

    // （4）在声明/定义一个变量时，可以使用var或者val来修饰，var修饰的变量可改变，val修饰的变量不可改。
    val d: Int = 20
    //    d = 40 // 此行代码报错

    // （5）var修饰的对象引用可以改变，val修饰的对象则不可改变，但对象的状态（值）却是可以改变的。（比如：自定义对象、数组、集合等等）

    var student01 = new Student()
    student01 = new Student()

    val student02 = new Student()
    //    student02 = new Student() // 此行代码报错
    student02.name = "lisi"
  }

}

class Student {
  // 姓名
  var name: String = "zhangsan"
  //  年龄
  var i: Int = 18
}
