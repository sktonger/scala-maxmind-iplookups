package com.snowplowanalytics.maxmind.iplookups
import cats.Id
import com.snowplowanalytics.maxmind.iplookups.model.IpLookupResult
object testApplication extends App {
///Users/stonger/a_conviva/MaxMindData
  //GeoIP2-ISP.mmdb
  //GeoIP2-Connection-Type.mmdb
  println("Hello world2")
  val ipLookups = CreateIpLookups[Id].createFromFilenames(
    geoFile = Some("/Users/stonger/a_conviva/MaxMindData/GeoIP2-City.mmdb"),
    ispFile = Some("/Users/stonger/a_conviva/MaxMindData/GeoIP2-ISP.mmdb"),
    domainFile = None,
    connectionTypeFile = Some("/Users/stonger/a_conviva/MaxMindData/GeoIP2-Connection-Type.mmdb"),
    memCache = false,
    lruCacheSize = 20000
  )

  val idResult: IpLookupResult = ipLookups.performLookups("175.16.199.0")


  println(idResult)
}
