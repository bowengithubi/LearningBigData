package cn.xiaodong.scala.demo.chapter02

import java.io.OutputStream
import java.net.Socket
import scala.io.{BufferedSource, Source}

object Scala06_Master {

    def main(args: Array[String]): Unit = {

        // TODO 连接服务器
        val client = new Socket("localhost", 9999)

        val out: OutputStream = client.getOutputStream
        out.write(300)
        out.flush()
        out.close()
        println("客户端向服务器发送数据 ：1")

        client.close
    }
}
