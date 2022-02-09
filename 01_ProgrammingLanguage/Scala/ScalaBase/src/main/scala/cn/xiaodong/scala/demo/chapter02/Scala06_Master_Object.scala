package cn.xiaodong.scala.demo.chapter02

import cn.xiaodong.scala.demo.po.User

import java.io.{ObjectOutputStream, OutputStream}
import java.net.Socket

object Scala06_Master_Object {

    def main(args: Array[String]): Unit = {

        // TODO 连接服务器
        val client = new Socket("localhost", 9999)

        val user = new User()

        val objOut = new ObjectOutputStream(client.getOutputStream)
        objOut.writeObject(user)
        objOut.flush()
        objOut.close()
        println("客户端向服务器发送数据 ：1")

        client.close
    }
}
