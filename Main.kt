package encryptdecrypt
import java.io.File

fun main(args: Array<String>) {

    val mode = if (args.contains("-mode")) args[args.indexOf("-mode") + 1] else "enc"
    val data = if (args.contains("-data")) args[args.indexOf("-data") + 1] else ""
    val key = if (args.contains("-key")) args[args.indexOf("-key") + 1].toInt() else 0
    val input = if (args.contains("-in")) args[args.indexOf("-in") + 1] else ""
    val output = if (args.contains("-out")) args[args.indexOf("-out") + 1] else ""
    var buffer = ""

    fun cipherMachine(data: String, mode: String, key: Int): String {
        var temp = ""
        for (ch in data) {
            temp += if (mode == "enc") ch + key else ch - key
        }
        return temp
    }

    if (((data != "") and (input != "")) or ((data != "") and (input == ""))) {
        buffer = cipherMachine(data, mode, key)
    } else if ((input != "") and (data == "")) {
        val text = File(input).readText()
        buffer =  cipherMachine(text, mode, key)
    }

    if (output != "") {
        File(output).writeText(buffer)
    } else {
        print(buffer)
    }

}