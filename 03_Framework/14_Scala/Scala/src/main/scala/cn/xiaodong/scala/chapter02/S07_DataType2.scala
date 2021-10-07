package cn.xiaodong.scala.chapter02

import scala.reflect.internal.util.StringOps

/**
 * 数据类型：字符型、布尔型
 */
object S07_DataType2 {
  def main(args: Array[String]): Unit = {
    // ---------------------Part 03、 字符类型类型 -------------------------------------
    //（1）字符常量是用单引号 ' ' 括起来的单个字符。
    var c1: Char = 'a'
    println("c1=" + c1)
    //注意：这里涉及自动类型提升，其实编译器可以自定判断是否超出范围，
    //不过idea提示报错
    var c2: Char = 'a' + 1
    println("c2=" + c2)

    //（2）\t ：一个制表位，实现对齐的功能
    println("姓名\t年龄")

    //（3）\n ：换行符
    println("西门庆\n潘金莲")

    //（4）\\ ：表示\
    println("c:\\岛国\\avi")

    //（5）\" ：表示"
    println("同学们都说：\"大海哥最帅\"")

    var str1: String = "123456"
    println("str1=" + str1)

    // ---------------------Part 04、 布尔类型 -------------------------------------
    var boolean1: Boolean = true
    var boolean2: Boolean = false
    println(boolean1)
    println(boolean2)

  }
}
