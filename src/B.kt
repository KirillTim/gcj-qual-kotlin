import java.io.PrintStream
import java.util.*

fun main(args: Array<String>) {
    (object : GCJTask("B-large-practice.in", "B.out") {
        override fun solve(input: Scanner, output: PrintStream) {
           val s = input.nextLong().toString().toCharArray()
            var i = 0
            while (i < s.size - 1 && s[i] <= s[i + 1])
                i++
            if (i == s.size - 1) {
                output.println(String(s))
                return
            }
            while (i > 0 && s[i] == s[i - 1])
                i--
            s[i]--
            for (j in i + 1..s.size - 1)
                s[j] = '9'
            if (s[i] == '0')
                output.println(String(s).drop(1))
            else
                output.println(String(s))
        }
    }).run()
}