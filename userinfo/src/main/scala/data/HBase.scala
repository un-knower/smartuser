package data

import config.HbaseConfig
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.hbase.client._
import org.apache.hadoop.hbase.mapreduce.TableInputFormat
import org.apache.hadoop.hbase.protobuf.ProtobufUtil
import org.apache.hadoop.hbase.protobuf.generated.ClientProtos
import org.apache.hadoop.hbase.util.Base64

/**
  * Created by yangshuai on 2016/1/26.
  */
class HBase {

  private[this] var _tableName: String = new Predef.String

  def tableName: String = _tableName

  def tableName_=(value: String): Unit = {
    _tableName = value
  }

  private[this] var _columnFamily: String = new Predef.String

  def columnFamily: String = _columnFamily

  def columnFamily_=(value: String): Unit = {
    _columnFamily = value
  }

  private[this] var _column: String = new Predef.String

  def column: String = _column

  def column_=(value: String): Unit = {
    _column = value
  }

  private var conf = new Configuration()

  def setScan(scan:Scan): Unit ={
    val proto:ClientProtos.Scan = ProtobufUtil.toScan(scan)
    val scanToString = Base64.encodeBytes(proto.toByteArray)
    conf.set(TableInputFormat.SCAN, scanToString)
  }

  def getConfigure(table:String, columnFamily:String, column:String): Configuration = {

    conf = HBaseConfiguration.create()
    conf.set("hbase.rootdir", HbaseConfig.dir)
    conf.set("hbase.zookeeper.quorum", HbaseConfig.quorum)
    conf.set("hbase.zookeeper.property.clientPort", HbaseConfig.port)
    conf.set(TableInputFormat.INPUT_TABLE, table)
    conf.set(TableInputFormat.SCAN_COLUMN_FAMILY,columnFamily)
    conf.set(TableInputFormat.SCAN_COLUMNS,column)
    conf
  }
}
