package cz.vehovsky

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import me.tongfei.progressbar.ProgressBar


suspend fun bar(name: String, d: Long) {
    ProgressBar(name, 100).use { pb ->
        repeat(10) {
            pb.stepBy(10)
            delay(d)
        }
    }
}

fun main() = runBlocking {
    coroutineScope {
        launch { bar("a", 400) }
        launch { bar("b", 800) }
        launch { bar("c", 100) }
        launch { bar("d", 600) }
        delay(2000)
        launch { bar("e", 200) }
    }
    //delay(5000)
    println("DONE!")
}
