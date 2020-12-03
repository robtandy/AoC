import aoc.day3.Day3
import org.scalatest._
import flatspec._
import matchers._


class Day3Test extends AnyFlatSpec with should.Matchers {
  "grid" should "find trees" in {
    val grid = Array("..##..#.",".#.##.#")
    assert(!Day3.isTree(grid, 0, 0))
    assert(Day3.isTree(grid, 2, 0))
    assert(Day3.isTree(grid, 1, 1))
    assert(Day3.isTree(grid, 6, 0))
  }

  "countTrees" should "work for test input" in {
    val grid = Array(
    "..##.......",
    "#...#...#..",
    ".#....#..#.",
    "..#.#...#.#",
    ".#...##..#.",
    "..#.##.....",
    ".#.#.#....#",
    ".#........#",
    "#.##...#...",
    "#...##....#",
    ".#..#...#.#")

    assert(Day3.countTrees(grid, 1, 1) == 2)
    assert(Day3.countTrees(grid, 3, 1) == 7)
    assert(Day3.countTrees(grid, 5, 1) == 3)
    assert(Day3.countTrees(grid, 7, 1) == 4)
    assert(Day3.countTrees(grid, 1, 2) == 2)
    assert(Day3.slopes.map({ case (l, r) => Day3.countTrees(grid,l, r)}).product == 336)

  }
}
