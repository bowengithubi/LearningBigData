package cn.xiaodong.scala.demo.chapter02

/**
 * Scala，String与基本数据类型的转换
 */
object S11_DataTypeChange03 {

  def main(args: Array[String]): Unit = {
    // ---------------------Part 03、String与基本数据类型的转换 -------------------------------------
    // （1）基本类型转String类型（语法：将基本类型的值+"" 即可）
    var d1: Double = 10.12345D
    println(d1 + "")

    // （2）String类型转基本数值类型（语法：s1.toInt、s1.toFloat、s1.toDouble、s1.toByte、s1.toLong、s1.toShort）
    var s1: String = "3.114115"
    println("s1=" + s1.toDouble)

  }

}
