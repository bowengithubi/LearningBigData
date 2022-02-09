package cn.xiaodong.scala.practice.chapter01


/**
 * 入门案例
 * @author: xiaodong
 * @create: 2022-02-08 16:51
 * */
object P1_1_HelloScala {

  def func1(): Unit = {
    println("Hello Scala!");
  }


  def func2():Unit = {
    println("Hello Xiaodong!");
  }

  def main(args: Array[String]): Unit = {
    func1();
    func2();
  }

}
