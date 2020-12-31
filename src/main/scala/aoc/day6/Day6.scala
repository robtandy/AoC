package aoc.day6

import scala.collection.mutable.{ArrayBuffer, HashMap}
import scala.io.Source

object Day6 {

  def main(args: Array[String]) {
    val data = Source.fromFile("src/main/resources/day3/input.txt").mkString

    // for part 1

    // for part 2
  }
  def getGroups(data: String): List[Set[Char]] = {
    var groups = List[Set[Char]]()
    val groupdata =  data.split("""\n\n""")
    groupdata.map({s => val set = Set.from(s. toCharArray) })
             .toList
  }
}
