package cn.xiaodong.scala.chapter05

/**
 * 函数参数的特性
 */
object S03_TsetFunction {


  def main(args: Array[String]): Unit = {
    println("-------------------  f1()  --------------------")

    //（1）可变参数
    def f1(names: String*): Unit = {
      println(names)
    }
    f1();
    f1("xiaodong");
    f1("xiaodong","xiaoming");

    println("-------------------  f2()  --------------------")
    //（2）如果参数列表中存在多个参数，那么可变参数一般放置在最后
    def f2(age:Int,names: String*): Unit = {
      println(age+"  "+names)
    }
    f2(18,"xiaodong","xiaoming")


    println("-------------------  f3()  --------------------")
    //（3）参数默认值，一般将有默认值的参数放置在参数列表的后面
    def f3(age:Int,names: String="xiaodong"): Unit = {
      println(age+"  "+names)
    }
    f3(18)
    f3(18,"xiaoming")


    println("-------------------  f4()  --------------------")
    //（4）带名参数
    def f4(age:Int = 18,names:String): Unit = {
      println(age+"  "+names)
    }
    f4(names = "xiaodong")

  }
}
