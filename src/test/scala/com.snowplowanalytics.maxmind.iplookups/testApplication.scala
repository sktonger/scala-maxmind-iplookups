package com.snowplowanalytics.maxmind.iplookups
import cats.Id
object testApplication extends App {
///Users/stonger/a_conviva/MaxMindData
  //GeoIP2-ISP.mmdb
  //GeoIP2-Connection-Type.mmdb
  println("Hello world2")
  val ipLookups = CreateIpLookups[Id].createFromFilenames(
    geoFile = Some("/Users/stonger/a_conviva/MaxMindData/GeoIP2-Enterprise.mmdb"),
    ispFile = None,
    domainFile = None,
    connectionTypeFile = None,
    memCache = false,
    lruCacheSize = 20000
  )
  val ips:List[String] = List("142.250.195.3","175.16.199.0")
  ips.map(x => println(ipLookups.performLookups(x)))

}
