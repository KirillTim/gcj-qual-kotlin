import java.io.*
import java.util.*

abstract class GCJTask(inputFile: String = "", outputFile: String = "") {
    private val input = Scanner(BufferedInputStream(if (inputFile.isNotEmpty()) FileInputStream(inputFile) else System.`in`))
    private val output = PrintStream(if (outputFile.isNotEmpty()) FileOutputStream(outputFile) else System.out)

    abstract fun solve(input: Scanner, output: PrintStream)

    fun run() {
        val t = input.nextInt()
        input.nextLine()
        for (i in (1..t)) {
            output.print("Case #$i: ")
            solve(input, output)
        }
    }
}