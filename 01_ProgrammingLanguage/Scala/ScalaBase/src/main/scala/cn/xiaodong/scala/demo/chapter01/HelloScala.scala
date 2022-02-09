package cn.xiaodong.scala.demo.chapter01

/**
 * 定义一个Scala类
 * （1）简单理解，Scala代码中的关键字
 * （2）简单理解，伴生对象（单例对象）的概念
 */

/*
Object:定义一个单例对象(伴生对象)
  （0）单例对象，相当于Java中的Static关键字。
   Scala是完全面向对象的，去除了java中的Static关键字，使用伴生对象，模拟Static的效果
  （1）单例对象，采用object关键字声明
  （2）单例对象，对应的类，叫伴生类，伴生对象和伴生类的名字，应当一致
  （3）单例对象中的属性和方法，可用通过伴生类名，直接调用访问
 */

object HelloScala {


  // 相当于Java的静态变量
  var commonVar: String = "Hello Scala!"

  /*
 【函数定义，详细解释】
   def：Scala关键字，表示定义一个方法
   main：方法名
   args：入参的名称，即变量名
   Array：入参的类型，参数类型，写在变量名称的后面，用：进行分隔
   Unit：定义方法的返回数据类型。
       Unit是一个特殊的数据类型，是一个类，相当于Java中的关键字void，表示函数没有返回类型
       返回值类型，与函数体之间，使用等号进行连接
  */

  def main(args: Array[String]): Unit = {
    /*
    println:Scala中的方法，用于输出，相当于Java中的System.out.println()
     */
    println("Hello Scala!")
  }


}

class HelloScala {

  // 定义一个属性，姓名
  var name: String = ""
  // 年龄
  var age: Int = _

  /*
   Scala中的代码，如果一行，只写一个语句，代码结束，不需要写分号
   如果一行写多个语句，每个语句结束，需要写分号
  */
  // 一行代码，写多个语句
  var a: Int = 1;  var b: Int = 2;
}

/**
 * 编写测试代码
 */
object Test {

  def main(args: Array[String]): Unit = {
    // 访问类中的静态变量（伴生对象中的成员变量）
    println(HelloScala.commonVar);

    // 伴生对象中的成员变量的值，可以修改
    HelloScala.commonVar = "Hello New Scala!";
    println(HelloScala.commonVar);
  }
}
