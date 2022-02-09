package cn.xiaodong.scala.demo.chapter02

import java.io.{File, PrintWriter}
import scala.io.{BufferedSource, Source}

/**
 * io测试
 */
object S05_IO {

  def main(args: Array[String]): Unit = {
//    function1()

    function2()
  }

  /**
   * 从文件中获取输入,并打印输出
   */
  def function1(): Unit = {

    // 文件路径
    // 绝对路径：不可改变的路径
    //     本地路径：file:///c:/test/test.txt
    //     网络路径：http://www.xxx.com
    // 相对路径：可以改变的路径,一定存在一个基准路径
    //     ./ => 当前路径（可以省略）
    //    ../ => 当前路径的上一级路径
    //    IDEA中基准路径为项目Projects的根路径(不是moudle的所在路径)

    var fileSource: BufferedSource = Source.fromFile("data/word.txt")
    var iterator: Iterator[String] = fileSource.getLines()

    while (iterator.hasNext) {
      var str: String = iterator.next()
      println(str)
    }
  }

  def function2() :Unit = {
    val writer = new PrintWriter(new File("data/output.txt" ))
    writer.write("Hello Scala!")
    writer.close()

  }

}
