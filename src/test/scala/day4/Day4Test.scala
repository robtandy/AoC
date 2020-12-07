package day4

import aoc.day4.Day4
import org.scalatest._
import org.scalatest.flatspec._
import org.scalatest.matchers._


class Day4Test extends AnyFlatSpec with should.Matchers {
  val input =
    """eyr:2017 hcl:z pid:#2f9848 iyr:2024
      |hgt:170cm
      |
      |pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980
      |hcl:#623a2f
      |""".stripMargin

  val invalid =
    """eyr:1972 cid:100
      |hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926
      |
      |iyr:2019
      |hcl:#602927 eyr:1967 hgt:170cm
      |ecl:grn pid:012533040 byr:1946
      |
      |hcl:dab227 iyr:2012
      |ecl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277
      |
      |hgt:59cm ecl:zzz
      |eyr:2038 hcl:74454a iyr:2023
      |pid:3556412378 byr:2007""".stripMargin

  val valid =
    """pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980
      |hcl:#623a2f
      |
      |eyr:2029 ecl:blu cid:129 byr:1989
      |iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm
      |
      |hcl:#888785
      |hgt:164cm byr:2001 iyr:2015 cid:88
      |pid:545766238 ecl:hzl
      |eyr:2022
      |
      |iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719
      |""".stripMargin


  "example input " should "parse into passports" in {
    val passports = Day4.getPassports(input)
    assert(passports.length == 2)

    val Seq(p1, p2) = passports
    for (k <- Array("eyr", "hcl", "pid", "iyr", "hgt")) {
      p1 -= k
      p2 -= k
    }
    p2 -= "byr"
    p2 -= "ecl"
    assert(p1.size == 0)
    assert(p2.size == 0)
  }
  "passports" should "validate correctly" in {
    val Seq(p1, p2, _*) = Day4.getPassports(input)
    assert(!Day4.isValid(p1))
    assert(Day4.isValid(p2))
  }

  "field validations" should "work" in {
    assert(Day4.validByr("2002"))
    assert(!Day4.validByr("2003"))

    assert(Day4.validHgt("60in"))
    assert(Day4.validHgt("190cm"))
    assert(!Day4.validHgt("190in"))
    assert(!Day4.validHgt("190"))

    assert(Day4.validHcl("#123abc"))
    assert(!Day4.validHcl("#123abz"))
    assert(!Day4.validHcl("123abc"))

    assert(Day4.validEcl("brn"))
    assert(!Day4.validEcl("wat"))

    assert(!Day4.validEyr("1967"))

    assert(Day4.validPid("000000001"))
    assert(!Day4.validPid("0123456789"))
  }

  "part 2 invalid passports" should "be marked invalid" in {
    val invalids = Day4.getPassports(invalid).map(Day4.isValidPart2)
    assert(!invalids.contains(true))
  }

  "part 2 valid passports" should "be marked valid" in {
    val valids = Day4.getPassports(valid).map(Day4.isValidPart2)
    assert(!valids.contains(false))
  }



}
