package day5

import aoc.day5.Day5
import org.scalatest.flatspec._
import org.scalatest.matchers._


class Dayt5Test extends AnyFlatSpec with should.Matchers {
  "partition" should "work for different input" in {
    assert(Day5.partition(0,127, true) == (0,63))
    assert(Day5.partition(0,63, false)  == (32,63))
    assert(Day5.partition(32,63, true)  == (32,47))
    assert(Day5.partition(32,47,false)  == (40,47))
    assert(Day5.partition(40,47,false)  == (44,47))
    assert(Day5.partition(44,47,true)  == (44,45))
    assert(Day5.partition(44,45,true)  == (44,44))
  }

  "find row" should "work" in  {
    assert(Day5.findRow("FBFBBFF")==44)
  }
  "find column" should "work" in {
    assert(Day5.findColumn("RLR")==5)
  }
  "seat id" should "work"  in {
    assert(Day5.seatId("BFFFBBFRRR") == 567)
    assert(Day5.seatId("FFFBBBFRRR") == 119)
    assert(Day5.seatId("BBFFBBFRLL") == 820)
  }
}
