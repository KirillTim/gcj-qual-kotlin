import java.io.PrintStream
import java.util.*

fun main(args: Array<String>) {
    (object : GCJTask("A-large-practice.in", "A.out") {
        override fun solve(input: Scanner, output: PrintStream) {
            val line = input.nextLine()
            val s = line.split(' ')[0].toCharArray()
            val k = line.split(' ')[1].toInt()
            var rv = 0
            val rev = mapOf('-' to '+', '+' to '-')
            for (i in (0..s.size - 1)) {
                if (s[i] == '-') {
                    if (s.size - i < k) {
                        output.println("IMPOSSIBLE")
                        return
                    }
                    rv++
                    for (j in (0..k - 1))
                        s[i + j] = rev[s[i + j]]!!
                }
            }
            output.println(rv)
        }
    }).run()
}