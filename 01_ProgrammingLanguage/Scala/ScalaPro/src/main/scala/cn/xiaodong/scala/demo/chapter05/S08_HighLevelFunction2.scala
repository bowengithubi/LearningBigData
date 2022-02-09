package cn.xiaodong.scala.demo.chapter05

/**
 * 高阶函数（函数可以作为参数进行传递）
 */
object S08_HighLevelFunction2 {

  def main(args: Array[String]): Unit = {


    // 函数做为参数进行传递（大多数做为匿名函数的形式）

    /**
     * 定义一个函数
     *
     * @param f 一个函数，指定变量x、变量y进行的运算
     * @param x 变量x
     * @param y 变量y
     * @return
     */
    def f0(f: (Int, Int) => Int, x: Int, y: Int): Int = {
      f(x, y)
    }

    // 调用函数f0
    println(f0((x: Int, y: Int) => {
      x + y
    }, 10, 20))

    // 省略写法
    println(f0(_ + _, 10, 20))

  }
}
