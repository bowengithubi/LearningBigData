package cn.xiaodong.scala.practice.chapter02

/**
 * 常量与变量练习
 */
object P1_1_var {

  // 变量
  var a: Int = 5;
  // 常量
  val b: Int = 10;

  def main(args: Array[String]): Unit = {
    a = 10;
//    b = 20; // 常量不能重新赋值
    println(a);
    println(b);
  }

}
