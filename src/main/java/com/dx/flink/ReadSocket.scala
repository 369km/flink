package com.dx.flink

import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment, _}

/**
 * @Description
 * @Date 2020/11/30 下午3:30
 * @Created by yangfudong
 */
object ReadSocket {
  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    env.setParallelism(2)
    val initStream: DataStream[String] = env.socketTextStream("localhost", 8080)//nc -lk 8080
    val wordStream = initStream.flatMap(_.split(" "))
    val pairStream = wordStream.map((_, 1))
    val keyByStream = pairStream.keyBy(0)
    val restStream = keyByStream.sum(1)
    restStream.print()
    env.execute()
  }

}
