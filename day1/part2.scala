import scala.util.control.Breaks._
import scala.io.Source
import scala.collection.mutable.HashSet

object Part2 {
  def main(args: Array[String]) {
    var seen:HashSet[Int] = HashSet.empty
    val list = Source.fromFile("input").getLines.toList.map {_.toInt}

    breakable {
      for ((i, itemi) <- (0 to list.length) zip list) {
        for ((j, itemj) <- (0 to list.length) zip list) {
          if (i != j) {
            val target = 2020 - itemj - itemi
            if(seen contains target) {
              println(itemi * itemj * target)
              break
            }
          }
        }
        seen add itemi
      }
    }
  }
}
