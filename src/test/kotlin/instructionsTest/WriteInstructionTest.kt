package instructionsTest

import org.example.CPU
import org.example.instructions.WriteInstruction
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test


class WriteInstructionTest {

    @Test
    fun testWriteInstructionToRAM() {
        // Create a CPU instance
        val cpu = CPU()

        // Initialize the special address register A and write a value to RAM
        cpu.addressRegister = 10 // Address register A contains the address 10
        cpu.registers[1] = 5 //Value to write

        // Create the ReadInstruction instance
        val writeInstruction = WriteInstruction()

        val instruction = "4100" // This means read from memory at address in register A (10) and store in register 1

        // Execute the instruction
        writeInstruction.execute(cpu, instruction)

        // Check if the result is correct
        assertEquals(5.toByte(), cpu.memory.read(10))
        // Check if the program counter was incremented correctly
        assertEquals(2, cpu.programCounter.value)
    }

    // For Future Proofing
//    @Test
//    fun testWriteInstructionToROM() {
//        // Create a CPU instance
//        val cpu = CPU()
//        cpu.memory.memoryFlag = 1
//
//        // Initialize the special address register A and write a value to RAM
//        cpu.addressRegister = 12 // Address register A contains the address 10
//        cpu.registers[1] = 22 //Value to write
//
//        // Create the ReadInstruction instance
//        val writeInstruction = WriteInstruction()
//
//        val instruction = "4100" // This means read from memory at address in register A (10) and store in register 1
//
//        // Execute the instruction
//        writeInstruction.execute(cpu, instruction)
//
//        // Check if the result is correct
//        assertEquals(22.toByte(), cpu.memory.readROM(12))
//        // Check if the program counter was incremented correctly
//        assertEquals(2, cpu.programCounter.value)
//    }
}
