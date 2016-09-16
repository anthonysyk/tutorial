object Chapitre5_Types_and_Operations {

  def main(args: Array[String]): Unit = {

    // ------ Types ------


    // Int
    val hex = 0x00FF //0x5, 0xcafebabe base 16 hexadecimal

    val oct = 035 //base 8 octal

    val dec1 = 31 //base 10 decimal

    // Long
    val prog = 31L // 31l, 0XCAFEBABEL

    // Double
    val big = 1.23e3 // 1.2345, 123E45
    val anotherBig = 3E5D // 300000.0

    //Short
    val little: Short = 367

    //Byte
    val littler: Byte = 38

    // Float
    val little2 = 1.2345F //3e5f (300000.0)

    // ------------------

    //Char
    // single quote
    val a = 'A'

    val c = '\101' // octal

    val d = '\u0041' // unicode

    val B\u0041\u0044 = 1 // BAD : Int = 1

    val backslash = '\\' // \

    // String
    // double quotes

    val hello = "hello"

    val escapes = "\\\"\'"

    //triple quote : raw string & | stripMargin
    println(
      """Welcome to Scala
        |Type "Help" for help.
      """.stripMargin)

    // Symbol
    val s = 'aSymbol //identifier non déclaré sans erreur dans une méthode
    println(s.name)

    // Boolean
    val bool = true
    val fool = false

    // ------ Operators are methods ------





  }

}
