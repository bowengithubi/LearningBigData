package cn.xiaodong.scala.chapter03

/**
 * Scala while循环
 */
object S04_while {


  def main(args: Array[String]): Unit = {

    var i:Int = 1
    while(i<10){
      println(i)
      i+=1
    }

    println("----------------------------------")

    var j = 1
    do{
      println(j)
      j+=1
    }while (j<10)
  }



}
