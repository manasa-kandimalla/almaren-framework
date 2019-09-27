package com.github.music.of.the.ainur.almaren.core

import org.apache.spark.sql.DataFrame
import com.github.music.of.the.ainur.almaren.State

private[almaren] abstract class Source() extends State {
  override def state(df: DataFrame): DataFrame = source(df)
  def source(df: DataFrame): DataFrame
}

class SourceSql(sql: String) extends Source {
  override def source(df: DataFrame): DataFrame = {
    logger.info(s"sql:{$sql}")
    val sqlDf = df.sparkSession.sql(sql)
    sqlDf
  }
}