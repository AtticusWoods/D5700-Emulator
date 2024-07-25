package org.example.instructions

import org.example.CPU

abstract class Instruction {
    abstract fun execute(cpu: CPU, instruction: String)
}