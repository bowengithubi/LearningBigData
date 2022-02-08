package cn.xiaodong.scala.chapter05

/**
 * 高阶函数(函数可以作为值进行传递）
 */
object S07_HighLevelFunction {

  def main(args: Array[String]): Unit = {

    /**
     * 定义一个函数
     *
     * @return
     */
    def foo(): Int = {
      println("foo...")
      10
    }

    println("-------------- demo01 ---------------")
    // 调用函数
    foo()

    println("-------------- demo02 ---------------")
    // 调用函数，并输出函数的返回值
    println(foo())

    // 函数作为值进行传递
    // 语法 函数名 + 空格 + 下划线
    var f1: () => Int = foo _ // 完整写法
    var f2 = foo _ // 省略f2的变量类型，自动推导
    var f3: () => Int = foo // 如果明确了函数的类型 空格和下换线可以省略
    var f4 = foo // 将函数返回值，复制给f4
    var f5 = foo() // 将函数返回值，复制给f4

    println("-------------- f1 ---------------")
    println(f1)
    println(f1()) // f1此时是一个函数，如果想要运行f1，必须加括号

    println("-------------- f2 ---------------")
    println(f2)
    println("-------------- f3 ---------------")
    println(f3)
    println("-------------- f4 ---------------")
    println(f4)
    println("-------------- f5 ---------------")
    println(f5)
  }
}
