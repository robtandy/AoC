package aoc.day3

import scala.io.Source

object Day3 {
  val slopes = Array((1, 1), (3, 1), (5, 1), (7, 1), (1, 2))

  def main(args: Array[String]) {
    val grid = Source.fromFile("src/main/resources/day3/input.txt").getLines.toArray[String]

    // for part 1
    println(countTrees(grid, 3, 1))

    // for part 2
    println(Day3.slopes.map({ case (r, d) => Day3.countTrees(grid, r, d)}).map(_.toLong).product)
    Day3.slopes.foreach({ case (r, d) =>
      val trees = Day3.countTrees(grid, r, d)
      println(s"for ($r, $d) => $trees")
    })
  }

  def countTrees(grid: Array[String], rightSlope: Int, downSlope: Int): Int = {
    var numTrees = 0
    var x = 0
    var y = 0

    do {
      if (isTree(grid, x, y)) {
        numTrees += 1
      }
      x += rightSlope
      y += downSlope

      // check for wrap
      if (x >= grid(0).length) {
        x %= grid(0).length
      }
    } while (y < grid.length)

    numTrees
  }

  def isTree(grid: Array[String], x: Int, y: Int): Boolean = {
    grid(y)(x) == '#'
  }
}
