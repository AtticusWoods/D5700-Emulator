package instructionsTest

import org.example.Emulator
import org.example.instructions.ReadInstruction
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

@OptIn(ExperimentalUnsignedTypes::class)
class ReadInstructionTest {

    @Test
    fun testReadInstructionFromRAM() {
        // Create an emulator instance
        val emulator = Emulator()
        val cpu = emulator.cpu
        val memory = emulator.memory

        // Initialize the special address register A and write a value to RAM
        cpu.addressRegister = 10 // Address register A contains the address 10
        memory.write(10, 42u) // Write value 42 to RAM at address 10

        // Create the ReadInstruction instance
        val readInstruction = ReadInstruction()

        // Create an instruction string "3x00" where x is the register index
        val instruction = "3100" // This means read from memory at address in register A (10) and store in register 1

        // Execute the instruction
        readInstruction.execute(emulator, instruction)

        // Check if the result is correct
        assertEquals(42.toUByte(), cpu.registers[1])
        // Check if the program counter was incremented correctly
        assertEquals(2, cpu.programCounter.value)
    }

    @Test
    fun testReadInstructionFromROM() {
        // Create an emulator instance
        val emulator = Emulator()
        val cpu = emulator.cpu
        val memory = emulator.memory

        // Set the memory flag to read from ROM
        memory.memoryFlag = 1
        cpu.addressRegister = 5 // Address register A contains the address 5
        memory.rom[5] = 84u

        // Create the ReadInstruction instance
        val readInstruction = ReadInstruction()

        // Create an instruction string "3x00" where x is the register index
        val instruction = "3100" // This means read from ROM at address in register A (5) and store in register 1

        // Execute the instruction
        readInstruction.execute(emulator, instruction)

        // Check if the result is correct
        assertEquals(84.toUByte(), cpu.registers[1])
        // Check if the program counter was incremented correctly
        assertEquals(2, cpu.programCounter.value)
    }
}
