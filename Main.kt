package encryptdecrypt
import java.io.File

fun main(args: Array<String>) {


    val mode = if (args.indexOf("-mode") != null) args[args.indexOf("-mode") + 1] else "enc"
    val data = if (args.indexOf("-data") != null) args[args.indexOf("-data") + 1] else ""
    val key = if (args.indexOf("-key") != null) args[args.indexOf("-key") + 1].toInt() else 0
    val input = if (args.indexOf("-in") != null) args[args.indexOf("-in") + 1] else ""
    val output = if (args.indexOf("-out") != null) args[args.indexOf("-out") + 1] else ""
    var buffer: String

    fun changeString(data: String, mode: String, key: Int): String {
        return if (mode == "end") {
            data.map { it.toChar() + key }.toString()
        } else {
            data.map { it.toChar() - key }.toString()
        }
    }


    buffer = if (((data != "") and (input != "")) or ((data != "") and (input == ""))) {
        changeString(data, mode, key)
    } else if ((input != "") and (data == "")) {
        val text = File(input).readText()
        changeString(text, mode, key)
    } else {
        ""
    }


    if (output != "") {
        val outputFile = File(output).writeText(buffer)
    } else {
        print(buffer)
    }




}