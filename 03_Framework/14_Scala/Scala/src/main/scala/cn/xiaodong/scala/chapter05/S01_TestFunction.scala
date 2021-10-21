package cn.xiaodong.scala.chapter05

/**
 * 函数定义测试
 */
object S01_TestFunction {
  /**
   * 定义一个方法
   * @param name
   * @return
   */
  def hello(name:String) :String = {
    return "Hello-->" + name
  }

  /**
   * 定义一个方法（方法可以重载）
   * @param name
   * @return
   */
  def hello(name:Int) :String = {
    return "Hello-->" + name
  }

  def main(args: Array[String]): Unit = {

    /**
     * 定义一个函数
     * @param name
     * @return
     */
    def hello(name:String) :String = {
      /**
       * 定义一个函数（函数可以嵌套定义）
       * @param name
       * @return
       */
      def hello2(name:String) :String = {
        return "Hello2-->" + name
      }

      return hello2(name)
    }

    // 函数调用（优先调用函数，而不是方法）
    println(hello("xiaodong"))

  }
}
