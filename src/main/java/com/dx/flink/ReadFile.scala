package com.dx.flink

import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}

/**
 * @Description
 * @Date 2020/12/1 下午3:12
 * @Created by yangfudong
 */
object ReadFile {
  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val stream: DataStream[String] = env.readTextFile("file://Users/yangfudong/Downloads/a.txt")
    stream.print()
    env.execute()
  }
}
