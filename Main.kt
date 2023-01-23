package encryptdecrypt

fun main(args: Array<String>) {

    val function = if (args.indexOf("-mode") != null) args[args.indexOf("-mode") + 1] else "enc"
    val phrase = if (args.indexOf("-data") != null) args[args.indexOf("-dataф") + 1] else ""
    val key  = if (args.indexOf("-key") != null) args[args.indexOf("-key") + 1].toInt() else 0

    for (ch in phrase) {

        if (function == "enc") {
            print(ch.toChar() + key)
        } else {
           print(ch.toChar() - key)
        }
    }
}