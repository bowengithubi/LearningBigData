package cn.xiaodong.scala.demo.chapter03

/**
 * Scala操作符测试
 */
object S12_Operator {

  def main(args: Array[String]): Unit = {

    // ---------------------Part 01、算数运算符 -------------------------------------
    println("part 01 -----------------------------------")

    // 整数除整数，结果是整数，小数部分，结果会放弃掉
    var a: Int = 5 / 2
    var a2: Double = 5 / 2
    println("a = " + a)
    println("a2 = " + a2)

    // 小数除小数，结果是小数
    var b: Double = 5.0 / 2.0
    println(b)

    // ---------------------Part 02、关系运算符 -------------------------------------
    println("part 02 -----------------------------------")

    var s1: String = new String("xiaodong")
    var s2: String = "xiaodong"
    println(s1 == s2) // 判断内容
    println(s1.equals(s2)) // 判断内容
    println(s1.eq(s2)) // 判断内存地址

    // ---------------------Part 04、赋值运算符 -------------------------------------
    println("part 04 -----------------------------------")

    var c: Byte = 10
    //    c += 1 // 此行代码报错，需要Byte类型的数据，但是+=计算完成后的结果是Int类型，不会自动进行数据类型的转换
    println(c)

    // ---------------------Part 05、运算符的本质 -------------------------------------
    println("part 05 -----------------------------------")

    var d: Int = 20
    d.+=(10) // 运算符调用，完整的写法
    d += (10) // .号可以省略
    d += 10 // 参数只有一个，或者没有参数，()也可以省略

    println(d)

  }
}
