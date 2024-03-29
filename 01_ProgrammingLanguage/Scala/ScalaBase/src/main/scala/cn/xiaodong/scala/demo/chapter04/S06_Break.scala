package cn.xiaodong.scala.demo.chapter04

import scala.util.control.Breaks.{break, breakable}

/**
 * Scala中循环中断(简写)
 */
object S06_Break {

  def main(args: Array[String]): Unit = {
    breakable( for (i <- 1 to 10) {
      if (i == 6) {
        break
      }
      println(i)
  })
}

}
