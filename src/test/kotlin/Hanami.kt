import dev.lunarcoffee.narumi.internal.core.DiscordClient
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.io.File

fun main() = runBlocking {
    val token = File("src/test/resources/token.txt").readText()
    val client = DiscordClient(token)
    client.start()
    delay(1000000)
}
