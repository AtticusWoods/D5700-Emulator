import org.example.CPU
import java.lang.Thread.sleep
import kotlin.test.Test
import kotlin.test.assertEquals

class CPUTest {
    val cpu = CPU()

    @Test
    fun testCPUInitialization() {
        // Verify that all general-purpose registers are initialized to 0
        for (i in cpu.registers.indices) {
            assertEquals(0.toUByte(), cpu.registers[i])
        }

        // Verify that the address register 'A' is initialized to 0
        assertEquals(0, cpu.addressRegister)

        // Verify that the program counter is initialized to 0
        assertEquals(0, cpu.programCounter.value)
    }

    @Test
    fun testTimerInitialization() {
        // Verify that the timer is started when the CPU is initialized
        cpu.timer.value = 100
        sleep(1000)
        assertEquals(true, cpu.timer.value < 100)
    }

    @Test
    fun testStopCPU() {
        // Stop the CPU and verify that the timer is stopped
        cpu.stop()
        cpu.timer.value = 1000
        sleep(100)
        assertEquals(false, cpu.timer.value == 100)
    }
}