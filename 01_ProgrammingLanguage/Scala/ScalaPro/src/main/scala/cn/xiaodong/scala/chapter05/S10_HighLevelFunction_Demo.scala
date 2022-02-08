package cn.xiaodong.scala.chapter05

/**
 * 高阶函数(扩展练习)
 *
 * 函数可以作为值传递的好处：
 * 扩展函数的功能
 * 提高函数的灵活度
 */
object S10_HighLevelFunction_Demo {

  def main(args: Array[String]): Unit = {
    // 需求：对一个集合，进行每个元素 + 1操作的处理

    def arrayOperation(array: Array[Int], op: (Int) => Int): Array[Int] = {
      for (ele <- array) yield op(ele)
    }

    def op(i: Int): Int = {
      i + 1
    }

    println("-------------- f1 ---------------")
    var newArray = arrayOperation(Array(1, 2, 3, 4, 5), op)
    println(newArray.mkString(","))

    println("-------------- f2 ---------------")
    // 匿名函数调用
    println(arrayOperation(Array(1, 2, 3, 4, 5), (x: Int) => {
      x * 2
    }).mkString(","))

    println("-------------- f3 ---------------")
    // 匿名函数简写
    println(arrayOperation(Array(1, 2, 3, 4, 5), _ * 2).mkString(","))
  }
}
