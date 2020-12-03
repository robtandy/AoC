import aoc.day2.Day2
import org.scalatest._
import flatspec._
import matchers._

class Day2Test extends AnyFlatSpec with should.Matchers {
  "pattern" should "extract fields properly" in {

    assert(
    "23-45 c: xyxyxy" match {
      case Day2.pattern (min, max, chr, password) => {
        assert(min == "23")
        assert(max == "45")
        assert(chr == "c")
        assert(password == "xyxyxy")
        true
      }
      case _ => false
    })
  }

  "part 1 passwords" should "validate correctly" in {
    val input = Array("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc")
    input.map(Day2.isValidLinePart1) shouldEqual Array(true, false, true)
  }

  "part 2 passwords" should "validate correctly" in {
    val input = Array("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc")
    input.map(Day2.isValidLinePart2) shouldEqual Array(true, false, false)
  }
}
