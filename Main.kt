package encryptdecrypt

fun main() {

    val alphabet = "abcdefghijklmnopqrstuvwxyz"
    val phrase = readln()
    val key = readln().toByte()

    for (ch in phrase) {

        if (ch.isWhitespace()) {
            print(" ")
        }
        else {

            val index = alphabet.indexOf(ch)
            var shift = index + key
            if (shift > alphabet.length - 1) {
                shift = shift - alphabet.length
                print(alphabet[shift])
            }
            else {
                print(alphabet[shift])
            }
        }

    }


}