package cn.xiaodong.scala.chapter03

/**
 * Scala for循环
 */
object S03_for01 {


  def main(args: Array[String]): Unit = {
    // 范围循环 to
    //    m1()

    // 范围循环 until
    //    m2()

    // 循环步长
    //    m3()

    // 循环嵌套
    //    m4()

    // 练习1：打印九九乘法表
    //    p1()

    // 练习2：打印九层妖塔（等腰三角形）
    //    p2()

    // 循环返回值
    //    m5()

    // 倒序打印
    m6()
  }


  /**
   * 范围循环 to
   */
  def m1(): Unit = {
    for (i: Int <- 1 to 5) {
      println(i + "小东最帅了！")
    }

    //    // 简写
    //    for (i <- 1 to 5) {
    //      println("小东最帅了！")
    //    }
  }

  // 范围循环 until
  def m2(): Unit = {
    for (i: Int <- 1 until 5) {
      println(i + "小东最帅了！")
    }
  }

  // 循环步长
  def m3(): Unit = {
    for (i: Int <- 1 until 5 by 2) {
      println(i + "小东最帅了！")
    }
  }

  // 循环嵌套
  def m4(): Unit = {

    for (i: Int <- 1 to 5; j <- 1 to 5) {
      println(i + "  " + j + "  小东最帅了！")
    }

    // 等价于
    for (i: Int <- 1 to 5) {
      for (j <- 1 to 5) {
        println(i + "  " + j + "  小东最帅了！")
      }
    }
  }

  // 练习1：打印九九乘法表
  def p1(): Unit = {
    for (i <- 1 to 9; j <- 1 to i) {
      print(j + "*" + i + "=" + i * j + "  ")

      if (i == j)
        println()
    }
  }

  // 练习2：打印九层妖塔（等腰三角形）
  /*

        *
       ***
      *****
     *******
    *********
   ***********
  *************
 ***************
*****************

   */
  def p2(): Unit = {
    for (i <- 1 to 9) {
      // 打印空格
      print(" " * (9 - i))
      // 打印星星
      print("*" * (i * 2 - 1))
      // 换行
      println()
    }
  }

  // 循环返回值
  def m5(): Unit = {
    // 直接返回循环遍历的数据
    var a = for (i <- 1 to 5) yield i
    println(a)

    // 对循环遍历的数据，进行简单的处理
    var b = for (i <- 1 to 5) yield i * 2
    println(b)

    // 对循环遍历的数据，进行复杂的数据处理
    var c = for (i <- 1 to 5) yield {
      if (i % 2 == 1) {
        i * 2
      } else {
        i + 1
      }
    }
    println(c)
  }

  // 倒序打印
  def m6(): Unit = {
    for (i <- 1 to 5 reverse) {
      println(i)
    }
  }
}
