package com.dx.flink

import org.apache.flink.api.java.io.TextInputFormat
import org.apache.flink.core.fs.Path
import org.apache.flink.streaming.api.functions.source.FileProcessingMode
import org.apache.flink.streaming.api.scala._


/**
 * @Description
 * @Date 2020/12/1 下午3:24
 * @Created by yangfudong
 */
object ReadFileContinue {
  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val path = "file:///Users/yangfudong/Downloads/a.txt"
    val format = new TextInputFormat(new Path(path))
    val stream = env.readFile(format, path, FileProcessingMode.PROCESS_CONTINUOUSLY, 10)
    stream.print()
    env.execute()
  }

}
