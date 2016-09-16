/**
  * Created by Anthony on 16/09/2016.
  */

import ChecksumAccumulator.calculate

object Summer {
  def main(args: Array[String]): Unit = {
    val array = Array("Ceci est un test", "Samy est fort")
    for (arg <- array)
      println(arg + ": " + calculate(arg))
  }

}
