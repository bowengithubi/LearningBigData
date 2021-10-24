package cn.xiaodong.scala.chapter05

/**
 * 匿名函数（2个参数案例）
 */
object S06_lambdaFunctio2 {

  def main(args: Array[String]): Unit = {

    def fun10(fun: (Int, Int) => Int): Unit = {
     println(fun(1, 6))
    }

    println("-------------------  测试1  --------------------")
    // 全写
    fun10((a: Int, b: Int) => {
       a + b
    })

    println("-------------------  测试2  --------------------")
    // 省略变量类型，省略return
    fun10((a, b) => {
       a + b
    })

    println("-------------------  测试3  --------------------")
    // 省略变量名称，省略大括号
    fun10(
      _ + _
    )


  }


}
