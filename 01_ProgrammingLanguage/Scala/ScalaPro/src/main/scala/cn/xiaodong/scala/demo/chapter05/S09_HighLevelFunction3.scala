package cn.xiaodong.scala.demo.chapter05

/**
 * 高阶函数（函数可以作为返回值返回）
 */
object S09_HighLevelFunction3 {

  def main(args: Array[String]): Unit = {

    // 函数可以做为返回值进行返回  -- 函数的嵌套
    def f1(): () => Unit = {
      def f2(): Unit = {
        println("f2被调用了")
      }

      // 将f2作为f1的返回值
      f2 _
    }

    println("-------------- ff ---------------")
    // f1()的执行结果，是f2(),即ff变量就是f2
    var ff = f1()
    ff()

    println("-------------- f1()() ---------------")
    // 以上代码简写
    f1()()

  }
}
