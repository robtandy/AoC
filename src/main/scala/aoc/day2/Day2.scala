package aoc.day2

import scala.io.Source
import scala.util.matching.Regex

object Day2 {
  val pattern = """(\d+)-(\d+) ([a-z]): ([a-z]+)""".r

  def main(args: Array[String]) {
    val data = Source.fromFile("src/main/resources/day2/input.txt").getLines.toList

    // for part 1
    println(data.map(isValidLinePart1).count(_ == true))

    // for part 2
    println(data.map(isValidLinePart2).count(_ == true))
  }

  def isValidLinePart1(line:String): Boolean = {
    line match {
      case Day2.pattern(min, max, chr, password) => isValidPart1(min.toInt, max.toInt, chr.charAt(0), password)
      case _ => false
    }
  }

  def isValidLinePart2(line:String): Boolean = {
    line match {
      case Day2.pattern(pos1, pos2, chr, password) => isValidPart2(pos1.toInt, pos2.toInt, chr.charAt(0), password)
      case _ => false
    }
  }


  def isValidPart1(min:Int, max: Int, chr: Char, password: String): Boolean = {
    var count = 0;

    for(c <- password) {
      if(chr == c) { count += 1 }
      if(count > max) { return false }
    }
    count >= min
  }
  def isValidPart2(pos1:Int, pos2: Int, chr: Char, password: String): Boolean = {
    val (p1, p2) = (pos1-1, pos2-1)
    if(p1 >= password.length | p2 >= password.length) { return false}

    val found = Array(password.charAt(p1), password.charAt(p2))
    found.count(_ == chr) == 1
  }

}
