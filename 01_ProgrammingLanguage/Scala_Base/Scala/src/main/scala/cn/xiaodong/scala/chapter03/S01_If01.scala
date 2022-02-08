package cn.xiaodong.scala.chapter03

import scala.io.StdIn

/**
 * if逻辑控制
 */
object S01_If01 {

  def main(args: Array[String]): Unit = {
    // 单分支
    m1()
    // 双分支
    m2()
    // 多分支
    m3()
  }

  def m1(): Unit = {
    //    需求：输入人的年龄，如果该同志的年龄小于18岁，则输出“童年”
    var age: Int = StdIn.readInt()

    if (age < 18) {
      println("童年")
    }
  }

  def m2(): Unit = {
    // 需求：输入年龄，如果年龄小于18岁，则输出“童年”。否则，输出“成年”。
    var age: Int = StdIn.readInt()

    if (age < 18) {
      println("童年")
    } else {
      println("成年")
    }
  }

  def m3(): Unit = {
    // （1）需求1：需求：输入年龄，如果年龄小于18岁，则输出“童年”。
    // 如果年龄大于等于18且小于等于30，则输出“中年”，否则，输出“老年”。
    var age: Int = StdIn.readInt()

    if (age < 18) {
      println("童年")
    } else if (age>18&& age <= 30) {
      println("中年")
    } else {
      println("老年")
    }
  }

}
