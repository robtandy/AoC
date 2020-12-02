import scala.util.control.Breaks._
import scala.io.Source
import scala.collection.mutable.HashSet

object Part1 {
  def main(args: Array[String]) {
    var seen:HashSet[Int] = HashSet.empty
    val list = Source.fromFile("input").getLines.toList.map {_.toInt}

    breakable {
      for (item <- list) {
        val target = 2020 - item
        if(seen contains target) {
          println(item * target)
          break
        }
        seen add item
      }
    }
  }
}
