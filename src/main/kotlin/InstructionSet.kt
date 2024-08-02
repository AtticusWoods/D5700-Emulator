package org.example

import org.example.instructions.*

@kotlin.ExperimentalUnsignedTypes
object   InstructionSet {
    private val instructions: MutableMap<String, Instruction> = mutableMapOf()

    init {
        // Register instructions
        instructions["0"] = StoreInstruction()
        instructions["1"] = AddInstruction()
        instructions["2"] = SubInstruction()
        instructions["3"] = ReadInstruction()
        instructions["4"] = WriteInstruction()
        instructions["5"] = JumpInstruction()
        instructions["6"] = ReadKeyboardInstruction()
        instructions["7"] = SwitchMemoryInstruction()
        instructions["8"] = SkipEqualInstruction()
        instructions["9"] = SkipEqualInstruction()
        instructions["A"] = SetAInstruction()
        instructions["B"] = SetTInstruction()
        instructions["C"] = ReadTInstruction()
        instructions["D"] = ConvertToBase10Instruction()
        instructions["E"] = ConvertByteToAsciiInstruction()
        instructions["F"] = DrawInstruction()

    }

    fun execute(instruction: String, emulator: Emulator) {
        val opcode = instruction[0].toString() // Get the opcode from the instruction
        val instructionHandler = instructions[opcode]
        instructionHandler?.execute(emulator, instruction) ?: throw IllegalArgumentException("Unknown instruction: $instruction")
    }
}