package aoc.day5

import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer
import scala.io.Source
import scala.util.{Failure, Success, Try}

object Day5 {

  def main(args: Array[String]) {
    val data = Source.fromFile("src/main/resources/day5/input.txt").getLines

    // for part 1
    println(data.map(seatId).max)
    // for part 2
    val seatIds = data.map(seatId).toArray.sorted
    val diffs =  seatIds.zipWithIndex.map { case (sid, i) => if(i < seatIds.length-1) seatIds(i+1) - sid else 0 }
    println(seatIds.zip(diffs).mkString("\n"))
    println(seatIds.zip(diffs).filter({case (a, b) => b !=  1}).mkString(""))
  }

  def seatId(boardingPass:String): Int = {
    val row = findRow(boardingPass.slice(0,7))
    val col = findColumn(boardingPass.slice(7,10))
    row * 8 + col
  }

  def partition(start:Int, end:Int, isLower: Boolean): (Int,Int) = {
    val mid = (end - start + 1) / 2 + start
    if(isLower) (start, mid-1) else (mid, end)
  }

  def findRow(fbs: String):Int = {
    val loc =  fbs.foldLeft((0,127)) { (range,chr) => partition(range._1, range._2, if(chr == 'F') true else false) }
    loc._1
  }

  def findColumn(lrs: String):Int = {
    val loc =  lrs.foldLeft((0,8)) { (range,chr) => partition(range._1, range._2, if(chr == 'L') true else false) }
    loc._1
  }
}

