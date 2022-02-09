package cn.xiaodong.scala.demo.chapter02

/**
 * Scala特殊数据类型：Unit、Null、Nothing
 */
object S08_DataType3 {

  def main(args: Array[String]): Unit = {
    // 测试Unit
    println(m1())

    // 测试Nothing
    //    println(m2(1))

  }

  def m1(): Unit = {
    println("m1方法被执行了！")
  }

  //  def m2(n: Int): Nothing = {
  //    if (n == 0) {
  //      return new NullPointerException
  //    }else{
  //      return new RuntimeException
  //    }
  //  }
}
