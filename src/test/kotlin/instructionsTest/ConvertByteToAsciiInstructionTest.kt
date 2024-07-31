package instructionsTest

import org.example.CPU
import org.example.instructions.ConvertByteToAsciiInstruction
import org.junit.jupiter.api.Assertions.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals

class ConvertByteToAsciiInstructionTest {

    @Test
    fun testConvertByteToAsciiInstruction() {
        // Create a CPU instance
        val cpu = CPU()

        // Set initial values in the registers
        cpu.registers[0] = 0xA.toByte() // Set r0 to 0xA (10 in decimal)

        // Create the ConvertByteToAsciiInstruction instance
        val convertByteToAsciiInstruction = ConvertByteToAsciiInstruction()

        // Create an instruction string "ErXrY0" where X is the source register and Y is the destination register
        val instruction = "E010"

        // Execute the instruction
        convertByteToAsciiInstruction.execute(cpu, instruction)

        // Check if the ASCII value was stored correctly in r1
        println(cpu.registers[1])
        assertEquals('A'.code.toByte(), cpu.registers[1])
        // Check if the program counter was incremented correctly
        assertEquals(2, cpu.programCounter.value)
    }

    @Test
    fun testConvertByteToAsciiInstructionValueOutOfRange() {
        // Create a CPU instance
        val cpu = CPU()

        // Set initial values in the registers
        cpu.registers[0] = 0x10.toByte() // Set r0 to 0x10 (16 in decimal, out of range for hex digit)

        // Create the ConvertByteToAsciiInstruction instance
        val convertByteToAsciiInstruction = ConvertByteToAsciiInstruction()

        // Create an instruction string "ErXrY0" where X is the source register and Y is the destination register
        val instruction = "E010"


        // Execute the instruction and expect an exception
        val exception = assertThrows(IllegalArgumentException::class.java) {
            convertByteToAsciiInstruction.execute(cpu, instruction)
        }
        assertEquals("Value in register is greater than F", exception.message)

    }
}