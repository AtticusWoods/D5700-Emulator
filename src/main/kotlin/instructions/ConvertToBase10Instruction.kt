package org.example.instructions

import org.example.Emulator

@kotlin.ExperimentalUnsignedTypes
class ConvertToBase10Instruction : Instruction() {
    override fun execute(emulator: Emulator, instruction: String) {
        val cpu = emulator.cpu
        val memory = emulator.memory
        // Extract register index from the instruction
        val xRegisterIndex = instruction[1].toString().toInt(16)

        // Get the byte value from the specified register and convert it to an unsigned integer
        val value = cpu.registers[xRegisterIndex].toInt() and 0xFF

        // Convert the value to base-10 digits
        val hundreds = value / 100
        val tens = (value / 10) % 10
        val ones = value % 10

        // Store the digits in the memory locations specified by register A
        val address = cpu.addressRegister
        memory.ram[address] = hundreds.toUByte()
        memory.ram[address + 1] = tens.toUByte()
        memory.ram[address + 2] = ones.toUByte()

        // Increment the program counter
        cpu.programCounter.increment()
    }
}
