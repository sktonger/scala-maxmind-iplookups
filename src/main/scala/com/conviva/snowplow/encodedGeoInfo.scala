package com.conviva.snowplow
import scala.collection.mutable.Map
import scala.io.Source

object encodedGeoInfo {

  val cityMap        = loadCityMap()
  val continentMap   = loadContinentMap()
  val asnMap         = loadAsnMap()
  val countryMap     = loadCountryMap()
  val connectionMap = loadConnnectionMap()
  val ispMap         = loadIspMap()

  def loadCityMap(): Map[String, String] =
    loadFileToMap("src/main/config/cities.dat.gp")

  def loadContinentMap(): Map[String, String] =
    loadFileToMap("src/main/config/continents.dat.gp")

  def loadAsnMap(): Map[String, String] =
    loadFileToMap("src/main/config/asn.dat")

  def loadCountryMap(): Map[String, String] =
    loadFileToMap("src/main/config/countries.dat.gp")

  def loadConnnectionMap(): Map[String, String] =
    loadFileToMap("src/main/config/connectionTypes.dat.gp")

  def loadIspMap(): Map[String, String] =
    loadFileToMap("src/main/config/isp.dat")

  def loadFileToMap(path: String): Map[String, String] = {
    val result = scala.collection.mutable.Map[String, String]()
    Source.fromFile(path).getLines().map(_.split('|')).foreach { case x =>
      result.put(x(1).toLowerCase(), x(0))
    }
    result
  }

}
