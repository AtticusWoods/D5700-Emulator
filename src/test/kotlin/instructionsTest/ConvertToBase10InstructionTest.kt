package instructionsTest

import org.example.Emulator
import org.example.instructions.ConvertToBase10Instruction
import kotlin.test.Test
import kotlin.test.assertEquals

class ConvertToBase10InstructionTest {

    @Test
    fun testConvertToBase10Instruction() {
        // Create an emulator instance
        val emulator = Emulator()
        val cpu = emulator.cpu
        val memory = emulator.memory

        // Set the initial values
        cpu.addressRegister = 100 // Arbitrary address for testing
        cpu.registers[2] = 123.toByte() // Set r2 to 123

        // Create the ConvertToBase10Instruction instance
        val convertToBase10Instruction = ConvertToBase10Instruction()

        // Create an instruction string "DrX00" where X is the register index
        val instruction = "D200" // This means convert r2 and store digits in A, A+1, and A+2

        // Execute the instruction
        convertToBase10Instruction.execute(emulator, instruction)

        // Check if the digits were stored correctly
        assertEquals(1.toByte(), memory.ram[100])
        assertEquals(2.toByte(), memory.ram[101])
        assertEquals(3.toByte(), memory.ram[102])
        // Check if the program counter was incremented correctly
        assertEquals(2, cpu.programCounter.value)
    }
}