package encryptdecrypt
import java.io.File
import kotlin.math.absoluteValue

fun main(args: Array<String>) {

    val mode = if (args.contains("-mode")) args[args.indexOf("-mode") + 1] else "enc"
    val data = if (args.contains("-data")) args[args.indexOf("-data") + 1] else ""
    val key = if (args.contains("-key")) args[args.indexOf("-key") + 1].toInt() else 0
    val input = if (args.contains("-in")) args[args.indexOf("-in") + 1] else ""
    val output = if (args.contains("-out")) args[args.indexOf("-out") + 1] else ""
    val alg = if (args.contains("-alg")) args[args.indexOf("-alg") + 1] else "shift"
    var buffer = ""


    fun cipherMachine(alg: String, data: String, mode: String, key: Int): String {
        var temp = ""

        for (ch in data) {
            when (alg) {
                "shift"-> {
                        if (ch.isUpperCase()) {
                            temp += if (mode == "enc") ((ch.code + key - 65) % 26 + 65).toChar() else ((ch.code + (26 - key) - 65) % 26 + 65).toChar()
                        } else if (ch.isLowerCase()) {
                            temp += if (mode == "enc") ((ch.code + key - 97) % 26 + 97).toChar() else ((ch.code + (26 - key) - 97) % 26 + 97).toChar()
                        } else {
                            temp += ch
                        }
                    }
                "unicode" -> {
                    temp += if (mode == "enc") ch + key else ch - key
                }
            }
        }
        return temp
    }



    if (((data != "") and (input != "")) or ((data != "") and (input == ""))) {
        buffer = cipherMachine(alg, data, mode, key)
    } else if ((input != "") and (data == "")) {
        val text = File(input).readText()
        buffer =  cipherMachine(alg, text, mode, key)
    }

    if (output != "") {
        File(output).writeText(buffer)
    } else {
        print(buffer)
    }
 }