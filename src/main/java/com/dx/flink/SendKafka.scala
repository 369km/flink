package com.dx.flink

import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import org.apache.kafka.common.serialization.StringSerializer

/**
 * @Description
 * @Date 2020/12/3 上午9:24
 * @Created by yangfudong
 */
object SendKafka {
  def main(args: Array[String]): Unit = {
    val properties = new Properties()
    properties.setProperty("bootstrap.servers", "localhost:9092")
    properties.setProperty("key.serializer", classOf[StringSerializer].getName)
    properties.setProperty("value.serializer", classOf[StringSerializer].getName)
    val producer: KafkaProducer[String, String] = new KafkaProducer[String, String](properties)
    val record = new ProducerRecord[String, String]("test", null, null, "flink send to kafka")
    producer.send(record)
    producer.flush()
  }
}
