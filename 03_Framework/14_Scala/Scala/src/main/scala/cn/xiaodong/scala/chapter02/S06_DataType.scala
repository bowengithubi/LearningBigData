package cn.xiaodong.scala.chapter02

/**
 * 数据类型：整型、浮点类型
 */
object S06_DataType {

  def main(args: Array[String]): Unit = {

    // ---------------------Part 01、 整型 -------------------------------------
    // 正确
    var n1: Byte = 127
    var n2: Byte = -128

    // 错误
    // var n3:Byte = 128
    // var n4:Byte = -129

    var b: Byte = 10 + 20 // 此行代码IDEA会报错，但是编译器不会报错
    println(b)

    var c: Byte = 10
    //    var d: Byte = c + 10  // 此行代码会报错，需要强转
    //    println("d=" + d)


    // 声明一个整数，默认数据类型是Int
    var n5 = 10
    println(n5)

    // 声明一个整数，声明为Long，后面需要加"l"或者“L”，推荐写大写的L，因为小的l和1非常的相似
    var n6 = 9223372036854775807L
    println(n6)

    // ---------------------Part 02、 浮点类型 -------------------------------------
    // 建议，在开发中需要高精度小数时，请选择Double
    var n7 = 2.2345678912f
    var n8 = 2.2345678912

    println("n7=" + n7)
    println("n8=" + n8)

  }

}
