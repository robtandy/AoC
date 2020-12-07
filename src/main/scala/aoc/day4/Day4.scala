package aoc.day4

import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer
import scala.io.Source
import scala.util.{Failure, Success, Try}

object Day4 {
  val requiredKeys = Array("byr","iyr","eyr","hgt","hcl","ecl","pid")

  def main(args: Array[String]) {
    val data = Source.fromFile("src/main/resources/day4/input.txt").mkString

    // for part 1
    println(getPassports(data).map(isValid).count(_ == true))
    // for part 2
    println(getPassports(data).map(isValidPart2).count(_ == true))

  }

  def getPassports(pdata: String): Seq[HashMap[String,String]] = {
    var passports = ArrayBuffer[HashMap[String,String]]()

    for(pstring <- pdata.split("""\n\n""")) {
      var passport = HashMap.empty[String,String]
      for(kv:String <- pstring.split("""[\n\s]+""")) {
        val Array(key, value) = kv.split(":")
        passport += (key -> value)
      }
      passports += passport
    }
    passports.toList
  }

  def isValid(passport:HashMap[String,String]): Boolean = {
    val found = requiredKeys.map(passport.contains _)
    !found.contains(false)
  }

  def isValidPart2(passport:HashMap[String,String]): Boolean = {
    val found = requiredKeys.map(passport.contains _)
    if(found.contains(false)) return false

    for((k, v) <- passport)  {
      val valid = k match {
        case "byr" => validByr(v)
        case "iyr" => validIyr(v)
        case "hgt" => validHgt(v)
        case "hcl" => validHcl(v)
        case "ecl" => validEcl(v)
        case "pid" => validPid(v)
        case "eyr" => validEyr(v)
        case "cid" => true
        case _ => false
      }
      if(!valid) { return false }
    }
    true
  }

  def validByr(byr: String):Boolean = 1920 <= byr.toInt && byr.toInt <= 2002

  def validIyr(iyr: String):Boolean = 2010 <= iyr.toInt && iyr.toInt <= 2020

  def validEyr(eyr: String):Boolean = 2020 <= eyr.toInt && eyr.toInt <= 2030

  def validHgt(hgt: String):Boolean = {
    Try(hgt.slice(0, hgt.length - 2).toInt) match {
      case Success(num:Int) =>
        if (hgt.endsWith("cm"))
          150 <= num && num <= 193
        else if(hgt.endsWith("in"))
          59 <= num && num <= 76
        else false
      case Failure(_) => false
    }
  }

  def validHcl(hcl: String): Boolean = """#[0-9,a-f]{6}""".r.matches(hcl)

  def validEcl(ecl: String): Boolean =  {
    !Array("amb", "blu", "brn", "gry", "grn", "hzl", "oth").find(_ == ecl).isEmpty
  }

  def validPid(pid:String): Boolean = """\d{9}""".r.matches(pid)

}


