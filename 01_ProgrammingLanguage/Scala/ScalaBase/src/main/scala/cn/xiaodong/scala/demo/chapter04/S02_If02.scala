package cn.xiaodong.scala.demo.chapter04

import scala.io.StdIn

/**
 * if逻辑控制
 */
object S02_If02 {

  def main(args: Array[String]): Unit = {

    // if else 返回值
    //    m4()

    // if else 返回值，取共同的祖先类型
    //    m5()

    // Scala实现Java中的三元运算符
    m6()

  }


  def m4(): Unit = {
    var age: Int = StdIn.readInt()

    // Scala中if else表达式其实是有返回值的，具体返回值取决于满足条件的代码体的最后一行内容。
    var str: String = if (age < 18) {
      "童年"
    } else if (age > 18 && age <= 30) {
      "中年"
    } else {
      "老年"
    }

    println(str)
  }

  def m5(): Unit = {
    var age: Int = StdIn.readInt()

    // Scala中返回值类型不一致，取它们共同的祖先类型。
    var str: Any = if (age < 18) {
      "童年"
    } else if (age > 18 && age <= 30) {
      "中年"
    } else {
      age
    }

    println(str)
  }

  def m6(): Unit = {
    var age: Int = StdIn.readInt()

    // Java中的三元运算符可以用if else实现
    //    如果大括号{}内的逻辑代码只有一行，大括号可以省略。如果省略大括号，if只对最近的一行逻辑代码起作用。
    var str: String = if (age < 18) "童年" else "成年"
    println(str)
  }
}
