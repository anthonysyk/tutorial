/**
  * Created by Anthony on 14/09/2016.
  */
object Function_Evaluation {

  def main(args: Array[String]): Unit = {

    // -------- Règles d'évaluation -----

    def square(x : Double) = x * x

    println("le carré de 2 est : "+square(2))
    println("le carré de 5 + 4 (9) est : "+(square(5+4)))

    def sum_square(x : Double, y : Double) =  square(x) + square(y)

    // Substitution model

    println("la somme des deux carrés précédents est : "+ sum_square(2, 5+4))

    // 2 règles d'évaluation

    // Call by value
    // sum_square(2, 5+4)
    // sum_square(2, 9)
    // square(2) + square(9)
    // 2 * 2 + square(9)
    // 4 + square(9)
    // 4 + 9 * 9
    // 4 + 81
    // 85
    // Consiste à réduire les expressions en valeurs
    // Permet d'éviter les effets de bords (C++) qui nécessite de stocker la valeur intermédiaire

    // Call by name
    // sum_square(2, 5+4)
    // square(2) + square(5+4)
    // 2 * 2 + square(5+4)
    // 4 + square(5+4)
    // 4 + (5+4) * (5+4)
    // 4 + 9 * (5+4)
    // 4 + 9 * 9
    // 4 + 81
    // 85

    // Les deux stratégies d'évaluation réduisent à la même valeur du moment que :
    // - l'expression réduite est constituée de fonctions pures
    // - les deux évaluations se terminent (pas de boucle)

    def test_CbV(x : Int, y : Int) = x * x

    println(test_CbV(2,3)) // Les deux stratégies d'évaluation ont le même nombre d'étapes
    println(test_CbV(3+4, 8)) // CBV plus rapide : on réduit d'abord en valeur ce qui rajoute une étape
    println(test_CbV(7, 2*4)) // CBN plus rapide : le deuxième argument est évité on passe directement à 7 * 7
    println(test_CbV(3+4, 2*4)) // Même nombre d'étapes : combinaison des exemples 2 et 3

    def test_CbN(x : Int, y : => Int) = x * x // Avec call-by-name

    // Call-By-Value est en général plus efficient puisqu'il permet d'éviter de recalculer des expressions en argument
    // et est plus facile à gérer pour les effets impératifs et les effets de bords
    // Call-By-Name en revanche terminate plus souvent

    def constOne(x : Int, y : => Int) = x


    // ---------- Conditions and value definition ----------

    def abs(x: Int) = if (x >= 0) x else -x

    println(abs(-20))

  }

}
