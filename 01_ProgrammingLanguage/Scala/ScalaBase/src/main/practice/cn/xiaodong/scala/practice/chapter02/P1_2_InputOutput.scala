package cn.xiaodong.scala.practice.chapter02

import scala.io.StdIn

/**
 * 输入输出测试
 */
object P1_2_InputOutput {

  def main(args: Array[String]): Unit = {
    var age :Int = 0
    var name :String = ""

    age = StdIn.readInt()
    name = StdIn.readLine()

    printf("年龄=%d, 姓名=%s",age,name)
  }

}
