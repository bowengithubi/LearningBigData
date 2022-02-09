package cn.xiaodong.scala.demo.chapter02

import java.io.{InputStream, ObjectInputStream}
import java.net.{ServerSocket, Socket}

object Scala06_Slaver_Object {

    def main(args: Array[String]): Unit = {

        // TODO 启动服务器
        val server = new ServerSocket(9999)
        println("服务器已经启动，等待客户端的连接。。。")
        val client: Socket = server.accept()

        val objIn = new ObjectInputStream(client.getInputStream)
        val user = objIn.readObject()
        println("从客户端接收的数据为 " + user)
        objIn.close()

        client.close()
        server.close()
    }
}
