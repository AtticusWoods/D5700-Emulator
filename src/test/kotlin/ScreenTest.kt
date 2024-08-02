import org.example.Screen
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalUnsignedTypes::class)
class ScreenTest {
    private var screen = Screen()


    @Test
    fun testScreenInitialization() {
        // Verify that the screen RAM is initialized to 0
        for (i in screen.ram.indices) {
            assertEquals(0.toUByte(), screen.ram[i])
        }
    }

    @Test
    fun testClearScreen() {
        // Draw some characters on the screen
        val address = 3 * screen.width + 5
        val address2 = 0 * screen.width + 2

        val value = 46

        // Write the ASCII character to the screen's internal RAM
        screen.ram[address] = value.toUByte()

        // Clear the screen
        screen.clear()

        // Verify that the screen RAM is cleared to 0
        for (i in screen.ram.indices) {
            assertEquals(0.toUByte(), screen.ram[i])
        }
    }
}