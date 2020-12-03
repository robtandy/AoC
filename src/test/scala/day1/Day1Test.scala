package day1

import aoc.day1.Day1
import org.scalatest._
import flatspec._
import matchers._

class Day1Test extends AnyFlatSpec with should.Matchers {
  "twoSum" should "work on test input" in  {
    val input = Array(1721, 979, 366, 299,675, 1456)
    assert(Day1.twoSum(input, 2020) == 514579)
  }
  "threeSum" should "work on test input" in  {
    val input = Array(1721, 979, 366, 299,675, 1456)
    assert(Day1.threeSum(input, 2020) == 241861950)
  }

}
