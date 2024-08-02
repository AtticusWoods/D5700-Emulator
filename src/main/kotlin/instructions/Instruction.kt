package org.example.instructions

import org.example.Emulator

abstract class Instruction {
    abstract fun execute(emulator: Emulator, instruction: String)
}