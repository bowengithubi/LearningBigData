package cn.xiaodong.scala.chapter02

import scala.io.StdIn

/**
 * 键盘输入测试
 */
object S5_TestInput {
  def main(args: Array[String]): Unit = {

    // 获取用户的键盘输入
    println("请输入你的名字：")
    var name: String = StdIn.readLine()
    println("请输入你的年龄：")
    var age: Int = StdIn.readInt()

    // 输出用户输入的数据
    println(s"name = ${name},age = ${age}")
  }
}
