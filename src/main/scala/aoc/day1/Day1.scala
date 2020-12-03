package aoc.day1

import scala.util.control.Breaks._
import scala.io.Source
import scala.collection.mutable.HashSet

object Day1 {
  def main(args: Array[String]) {
    val list = Source.fromFile("src/main/resources/day1/input.txt").getLines.toList.map {_.toInt}

    // for part 1
    println(twoSum(list, 2020))
    // for part 2
    println(threeSum(list, 2020))
  }

  def twoSum(list: Seq[Int],  sum: Int ): Int = {
    var seen:HashSet[Int] = HashSet.empty

    for (item <- list) {
      val target = 2020 - item
      if(seen contains target) {
        return item * target
      }
      seen add item
    }
    -1
  }

  def threeSum(list: Seq[Int], sum: Int): Int = {
    var seen:HashSet[Int] = HashSet.empty

    for ((i, itemi) <- (0 to list.length) zip list) {
      for ((j, itemj) <- (0 to list.length) zip list) {
        val target = 2020 - itemi - itemj
        if (seen contains target) {
          return itemi * itemj * target
        }
        seen add itemj
      }
    }
    -1
  }
}
