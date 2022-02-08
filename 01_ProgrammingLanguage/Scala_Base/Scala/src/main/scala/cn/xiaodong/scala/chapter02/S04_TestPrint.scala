package cn.xiaodong.scala.chapter02

/**
 * 字符串输出
 *
 * @author: xiaodong
 * @create: 2021-10-02 13:27
 * */
object S04_TestPrint {

  def main(args: Array[String]): Unit = {
    var name: String = "xiaodong"
    var age: Int = 18

    // （1）字符串，通过+号连接
    println(age + "岁的" + name + "在学习Scala编程！")

    // （2）printf用法：字符串，通过%传值。
    printf("%d岁的%s在学习Scala编程！", age, name)

    // （3）多行字符串定义
    var s01: String =
      """
        abc
        bcd
        efd
        """
    println(s01)

    // 将多行字符串顶格输出
    // 应用scala的stripMargin方法，在scala中stripMargin默认是“|”作为连接符，
    // 在多行换行的行头前面加一个“|”符号即可。
    var s02: String =
    """
      |select *
      |from student
      |where id = 001
      |and name = 'xiaodong'
      |""".stripMargin
    println(s02)

    // （4）字符串模板（插值字符串）：通过$获取变量值
    // 4.1 插值字符串 s
    var s1 = s"${age}岁的${name}在学习Scala编程！"
    println(s1)
    // 表达式可以进行运算
    var s2 = s"${age * 2}岁的${name + name}在学习Scala编程！"
    println(s2)

    // 4.2 插值字符串 f
    // f插值
    val int1: Int = 8;
    val int2: Int = 32;
    val short1: Short = 8;
    val long1: Long = 8;
    val float1: Float = 8.0f;
    val double1: Double = 8.0d;
    println(f" I am int, value = $int1%d")
    println(f" I am int, value = $int1%d")
    println(f" I am int, value = $int2%e")
    println(f" I am int, value = $int2%E")
    println(f" I am short, value = $int1%d")
    println(f" I am long, value = $int1%d")
    println(f" I am float, value = $int1%f")
    println(f" I am double, value = $double1%f")
    println(f" I am double, value = $double1%s")

    // 4.3 插值字符串 raw
    println(s"This is s-interpolation a\nb")
    println(raw"This is raw-interpolation a\nb")
    println(raw"This is raw-interpolation a\nb${name}")
  }
}
