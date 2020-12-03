package com.dx.flink

import java.util.Properties

import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.streaming.api.scala.{StreamExecutionEnvironment, _}
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer
import org.apache.kafka.common.serialization.StringSerializer


/**
 * @Description
 * @Date 2020/12/1 下午4:19
 * @Created by yangfudong
 */
object ReadKafka {
  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val props = new Properties
    props.put("bootstrap.servers", "localhost:9092")
    props.put("zookeeper.connect", "localhost:2181")
    props.put("group.id", "test")
    props.put("key.deserializer", classOf[StringSerializer].getName)

    props.put("value.deserializer", classOf[StringSerializer].getName)
    props.put("auto.offset.reset", "latest")

    val stream: DataStream[String] = env.addSource(new FlinkKafkaConsumer[String]("test", new SimpleStringSchema, props))
    stream.print
    env.execute()
  }
}
