/**
  * Created by Anthony on 16/09/2016.
  */
object ChecksumAccumulator {
  import scala.collection.mutable.Map
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
