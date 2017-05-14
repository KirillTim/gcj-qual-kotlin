import java.io.*
import java.lang.Math.min
import java.util.*

fun main(args: Array<String>) {
    (object : GCJTask("C-large-practice.in", "C.out") {
        override fun solve(input: Scanner, output: PrintStream) {
            val n = input.nextLong()
            var k = input.nextLong() - 1
            val map = TreeMap<Long, Long>()
            map[n] = 1L
            while (k > 0) {
                val max = map.lastKey()
                val num = map.remove(max)!!
                val cnt = min(num, k)
                if (num - cnt > 0) {
                    map.put(max, num - cnt)
                }
                if (max / 2 != 0L) {
                    map.merge(max / 2, cnt) { a, b -> a + b }
                }
                if ((max - 1) / 2 != 0L) {
                    map.merge((max - 1) / 2, cnt) { a, b -> a + b }
                }
                k -= cnt
            }
            val max = map.lastKey()
            output.println("${max / 2} ${(max - 1) / 2}")
        }
    }.run())
}