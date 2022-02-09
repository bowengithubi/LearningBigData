package cn.xiaodong.scala.demo.chapter05

/**
 * 函数的定义（函数入参、以及函数返回值）
 */
object S02_TsetFunction {


  def main(args: Array[String]): Unit = {
    println("-------------------  f1()  --------------------")

    //    （1）函数1：无参，无返回值
    def f1(): Unit = {
      println("函数1：无参，无返回值")
    }

    f1()

    println("-------------------  f2()  --------------------")

    //    （2）函数2：无参，有返回值
    def f2(): Unit = {
      println("无参，有返回值")
      return "无参，有返回值"
    }

    println(f2())

    println("-------------------  f3()  --------------------")

    //    （3）函数3：有参，无返回值
    def f3(name: String): Unit = {
      println("函数3：有参，无返回值")
    }

    println(f3("xiaodong"))

    println("-------------------  f4()  --------------------")

    //    （4）函数4：有参，有返回值
    def f4(name: String): String = {
      println("函数4：有参，有返回值")
      return "hello -- >" + name
    }

    println(f4("xiaodong"))

    println("-------------------  f5()  --------------------")

    //    （5）函数5：多参，无返回值
    def f5(name: String, age: Int): Unit = {
      //      println("函数5：多参，无返回值" + "姓名："+name + "年龄："+age)
      println(s"函数5：多参，无返回值,姓名:${name},年龄:${age}")
    }

    println(f5("xiaodong", 18))

    println("-------------------  f6()  --------------------")

    //    （6）函数6：多参，有返回值
    def f6(name: String, age: Int): String = {

      println(s"函数6：多参，有返回值,姓名:${name},年龄:${age}")
      return "hello -- >" + name
    }

    println(f6("xiaodong", 18))

  }

}
