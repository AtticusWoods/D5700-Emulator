package instructionsTest

import org.example.CPU
import org.example.instructions.ReadInstruction
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test


class ReadInstructionTest {

    @Test
    fun testReadInstructionFromRAM() {
        // Create a CPU instance
        val cpu = CPU()

        // Initialize the special address register A and write a value to RAM
        cpu.addressRegister = 10 // Address register A contains the address 10
        cpu.memory.write(10, 42) // Write value 42 to RAM at address 10

        // Create the ReadInstruction instance
        val readInstruction = ReadInstruction()

        // Create an instruction string "3x00" where x is the register index
        val instruction = "3100" // This means read from memory at address in register A (10) and store in register 1

        // Execute the instruction
        readInstruction.execute(cpu, instruction)

        // Check if the result is correct
        assertEquals(42.toByte(), cpu.registers[1])
        // Check if the program counter was incremented correctly
        assertEquals(2, cpu.programCounter.value)
    }

    @Test
    fun testReadInstructionFromROM() {
        // Create a CPU instance
        val cpu = CPU()

        // Set the memory flag to read from ROM
        cpu.memory.memoryFlag = 1
        cpu.addressRegister = 5 // Address register A contains the address 5
        cpu.memory.loadProgram(byteArrayOf(0, 0, 0, 0, 0, 84)) // Write value 84 to ROM at address 5

        // Create the ReadInstruction instance
        val readInstruction = ReadInstruction()

        // Create an instruction string "3x00" where x is the register index
        val instruction = "3100" // This means read from ROM at address in register A (5) and store in register 1

        // Execute the instruction
        readInstruction.execute(cpu, instruction)

        // Check if the result is correct
        assertEquals(84.toByte(), cpu.registers[1])
        // Check if the program counter was incremented correctly
        assertEquals(2, cpu.programCounter.value)
    }
}
