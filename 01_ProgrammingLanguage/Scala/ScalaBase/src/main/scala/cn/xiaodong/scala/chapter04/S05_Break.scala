package cn.xiaodong.scala.chapter04

import scala.util.control.Breaks

/**
 * Scala中循环中断
 */
object S05_Break {

  def main(args: Array[String]): Unit = {
    Breaks.breakable(for (i <- 1 to 10) {
      if (i == 6) {
        Breaks.break()
      }
      println(i)
    })
  }

}
