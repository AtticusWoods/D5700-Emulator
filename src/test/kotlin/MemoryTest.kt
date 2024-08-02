import org.example.Memory
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@OptIn(ExperimentalUnsignedTypes::class)
class MemoryTest {
    private val memory = Memory()

    @Test
    fun testMemoryInitialization() {
        // Verify that RAM and ROM are initialized to 0
        for (i in memory.ram.indices) {
            assertEquals(0.toUByte(), memory.ram[i])
        }

        for (i in memory.rom.indices) {
            assertEquals(0.toUByte(), memory.rom[i])
        }

        // Verify that programSize and memoryFlag are initialized to 0
        assertEquals(0, memory.programSize)
        assertEquals(0, memory.memoryFlag)
    }

    @Test
    fun testReadWriteRAM() {
        // Write a value to RAM and read it back
        val address = 0x100
        val value: UByte = 66u
        memory.write(address, value)
        assertEquals(value, memory.read(address))

        // Test out-of-bounds write to RAM
        assertFailsWith<IllegalArgumentException> {
            memory.write(memory.ram.size, value)
        }

        // Test out-of-bounds read from RAM
        assertFailsWith<IllegalArgumentException> {
            memory.read(memory.ram.size)
        }
    }

    @Test
    fun testReadWriteROM() {
        // Write a value to ROM and read it back
        val address = 0x100
        val value: UByte = 66u
        memory.writeROM(address, value)
        assertEquals(value, memory.readROM(address))

        // Test out-of-bounds write to ROM
        assertFailsWith<IllegalArgumentException> {
            memory.writeROM(memory.rom.size, value)
        }

        // Test out-of-bounds read from ROM
        assertFailsWith<IllegalArgumentException> {
            memory.readROM(memory.rom.size)
        }
    }

}