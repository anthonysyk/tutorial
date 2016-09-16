
object Chapitre4_Classes_and_objects {

  def main(args: Array[String]): Unit = {

    // ------ Classes, fields, methods ------

    // Classe compagnon de l'objet ChecksumAccumulator
    class ChecksumAccumulator {

      private var sum = 0

      def add(b: Byte): Unit = {
        sum += b
      }
      //def add(b : Byte) {sum += b} // retourne un type Unit (pas de =)

      def checksum(): Int = {
        return ~(sum & 0xFF) + 1
      }
      // def checksum(): Int = ~(sum & 0xFF) + 1

    }

    val acc = new ChecksumAccumulator

    // Puzzler Unit type
    def f() : Unit = "This string gets lost"

    def g() {"this string gets lost too"} // retourne un Unit

    def e() = {"This is a string"} // avec le "=" retourne le bon type
    println(e)

    // Semicolon inference
    // optional

    val s = "hello"; println(s)

    def function(x: Int) : Unit =
    if (x < 2)
      println("too small")
    else
      println("ok")

    // Le saut de ligne compte comme un semicolon sauf dans certains cas
    val value = (1
    +2
    +3)

    val value2 = 1 +
      2 +
      3

    println(value2)

    // ------ Singleton objects ------

    import scala.collection.mutable.Map

    // Objet compagnon de la classe ChecksumAccumulator
    // une classe et son compagnon ont accès à leurs membres private
    // Un singleton ne peut pas prendre de paramètres
    // un singleton qui n'a pas le même nom qu'une classe est un standalone singleton
    object ChecksumAccumulator {

      private val cache = Map[String, Int]()

      def calculate(s: String) : Int =
        if(cache.contains(s))
          cache(s)
        else {
          val acc = new ChecksumAccumulator
          for (c <- s)
            acc.add(c.toByte)

          val cs = acc.checksum()
          cache += (s -> cs)
          cs
        }
    }

    println(ChecksumAccumulator.calculate("Ceci est un test"))
    println(ChecksumAccumulator.calculate("Ceci est un test 3"))
    //println(ChecksumAccumulator.cache)


    // ------ Scala Application ------
    // Voir Summer Object

    import ChecksumAccumulator.calculate

    object Summer {

      def call(i: Array[String]): Unit = {
        for (arg <- i)
          println(arg + ": "+ calculate(arg))
      }
    }
    Summer.call(Array("Salut", "comment ça va ?"))
  }

}

// Utilisation du trait App
import ChecksumAccumulator.calculate

object FallWinterSpringSummer extends App {

  for (season <- List("fall", "winter", "spring"))
    println(season + ": " + calculate(season))
}
