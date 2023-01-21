package encryptdecrypt

fun main() {

    val function = readln() //dec or enc
    val phrase = readln()
    val key = readln().toInt()

    for (ch in phrase) {

        if (function == "enc") {
            print(ch.toChar() + key)
        } else
        {
            print(ch.toChar() - key)
        }
    }

}