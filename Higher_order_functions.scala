object Higher_order_functions {

  def main(args: Array[String]): Unit = {

    // ---------- Higher Order Function -----------
    // Somme des chiffres entre a et b :
    def sumInts(a: Int, b: Int) : Int =
    if (a > b) 0 else a + sumInts(a + 1, b)

    // Appliqué au cube des chiffres :
    def cube(x: Int): Int = x * x * x

    def sumCubes(a: Int, b: Int) : Int =
      if (a > b) 0 else cube(a) + sumCubes(a + 1, b)

    println("La somme des chiffres de 1 à 5 est de : " + sumInts(1,5))

  }

  def sumCub(f:Int=>Int, x:Int) : Int = f(x)+x
}
