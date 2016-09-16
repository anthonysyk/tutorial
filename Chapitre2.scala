object Chapitre2 {

  def main(args: Array[String]): Unit = {

    // ------ Différence entre val et var ------
    val x = "val est immuable\n"
    println(x)

    //x = "test de l'immutabilité" -- error: "reassignment to val"

    var y = x

    y = "il est possible de passer une val dans une var puis modifier la var\n"
    println(y)

    // ------ Première fonction ------

    def max(x: Int, y: Int): Int = {
      if (x > y) x
      else y
    }

    // Raccourci
    def maxRaccourci(x: Int, y: Int): Int = if (x > y) x else y

    // Similaire à l'opérateur ternaire en Java (x > y) ? x : y
    // Int (type de retour) pas obligatoire mais c'est mieux de l'expliciter


    // Unit : type (similaire à void en Java)
    def greet() = println("Hello, world !")
    // Ce genre de fonction retourne une valeur de type Unit
    // intéréssante pour ses effets de bords, pas pour son résultat

    // Script
    val name:Array[String] = new Array[String](1)
    name(0)="planet"

    println("Hello, "+ name(0) + "!\n")
    // Rq : array(0) premier élément d'un array

    // ------ While et If ------
    //var phrase = new Array[String](4)
    val phrase = Array("This", "Is", "An", "Array", "in", "a", "while", "loop\n\n")
    var i = 0
    while (i < phrase.length){
      if (i != 0)
        print(" ")
      print(phrase(i))
      i+=1
    }

    // ------ iteration with foreach et for ------
    phrase.foreach((mot: String) => println(mot))
    // Functionnal version
    // (x: Int, y: Int) => x + y
    phrase.foreach(println)

    // for expression
    for (mot <- phrase) println(mot)
    // se lit pour mot dans phrase

  }

}
