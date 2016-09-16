import java.math.BigInteger

object Chapitre3 {

  def main(args: Array[String]): Unit = {

    // ----- Tableaux -----
    // Mutable et même type
    val tableau_test = new Array[String](4)
    // alternative val tableau_test: Array[String] = Array[String](

    tableau_test(0) = "Je"
    tableau_test(1) = "suis"
    tableau_test(2) = "un"
    tableau_test(3) = "array\n"
    //équivaut à tableau_test.update(1, "Je")

    for (i <- 0 to 3) println(tableau_test(i))
    // 0 to 3 est un raccourci pour (0).to(3)
    // Principe : All operations are method calls in Sala ex: 1 + 2 vaut (1).+(2)

    tableau_test(3) = "tableau"
    // possible de changer un objet de Array[String] même s'il est dans un val
    // Array[String] est mutable, mais val tableau_test pointera TOUJOURS vers cet array, pas un autre

    val numNames = Array("zero", "one", "two")
    // raccourci de val numNames = Array.apply("zero", "one", "two")

    // ------ Lists ------
    // Immuable et même types
    // zero-based

    val unDeux = List(1,2)
    val troisQuatre = List(3,4)

    val unDeuxTroisQuatre = unDeux ::: troisQuatre

    val deuxTrois = List(2,3)
    val unDeuxTrois = 1 :: deuxTrois
    println(unDeuxTrois)

    // Test si on inverse les deux arguments
    // val unDeuxTroisQuatreCinq = unDeuxTroisQuatre :: 5
    // println(unDeuxTroisQuatreCinq)
    // Ne fonctionne pas parceque "::" est une méthode de List et pas de Int
    // --> les ":" opèrent sur l'argument de droite

    // Utilisation de Nil :
    val unDeuxTrois2 = 1 :: 2 :: 3 :: Nil
    println(unDeuxTrois2)
    // Prepend de plusieurs int à Nil une liste vide

    // Append existe aussi :
    val unDeuxTroisQuatre2 = unDeuxTrois :+ 4
    println(unDeuxTroisQuatre2)
    // Mais il est préférable d'utiliser ListBuffer ou Reverse

    // Manipulations de listes :




    // ------ Tuples ------
    // Immuable et types différents
    // one-based

    val exemple_tuple = (99, "luftbaloons")
    println(exemple_tuple._1)
    println(exemple_tuple._2)

    // ------ Sets ------

    // Set immuable par défaut
    var jetSet = Set("Boeing", "Airbus")
    jetSet += "Lear"
    println(jetSet.contains("Lear"))
    println(jetSet)
    // += n'aurait pas été possible avec un val parceque Set est immutable et ne possède pas de méthode +=
    // ici jetSet += "Lear" est un raccourci pour jetSet = jetSet + "Lear"

    // Set mutable
    import scala.collection.mutable
    val movieSet = mutable.Set("Hitch", "Poltergeist")
    movieSet += "Shrek"
    println(movieSet)
    // += est possible avec val parceque le Set est mutable et possède la méthode +=

    // HashSet (Set de valeurs non ordonnées ou triées) plus rapide
    import scala.collection.immutable.HashSet
    val hashSet = HashSet("Concombre", "Tomates")
    println(hashSet + "Coriandre")

    // ------ Maps ------
    import scala.collection.mutable.Map
    val treasureMap = Map[Int, String]()
    treasureMap += (1 -> "Go to the Island")
    treasureMap += (2 -> "Find the big X on the ground")
    treasureMap += (3 -> "Dig")
    println(treasureMap(2))


    val romanNumric = Map[Int, String](1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V")
    println(romanNumric(4))

    // Encourager le fonctionnel plutôt que l'impératif
    // Moins d'erreur et plus lisible

    // Exemple avec et sans effets de bords :
    def withSideEffects(phrase: Array[String]): Unit = phrase.foreach(println)

    def withoutSideEffects(phrase: Array[String]): String = phrase.mkString("\n")

    // mkString converti une collection en String avec le sépérateur (préfix ou suffixe)
    val a = Array("apple", "banana", "ananas")
    a.foreach(print)
    println()
    // avec sépérateur ","
    a.mkString(",").foreach(print)
    println()
    // avec préfixe et suffixe
    a.mkString("[",",","]\n").foreach(print)

    // Bonne pratiques :
    // Prefer vals, immutable objects, methods without side effects
    // Else  vars, mutable objects, methods with side effects for specific needs


    // ------ Read Lines from a file ------
    import scala.io.Source

    //if (args.length > 0){
      //for (line <- Source.fromFile(args(0)).getLines())
        //println(line.length + " " + line)
    //}
    //else
      //Console.err.println("Please enter Filename")

    def widthOfLength(s: String) = s.length.toString.length // Nombre de mots

    val lines = Array("ceci est une adaptation du code ", "à un tableau ", "Test")

    var maxWidth = 0

    for (line <- lines) maxWidth = maxWidth.max(widthOfLength(line))

  }

}
