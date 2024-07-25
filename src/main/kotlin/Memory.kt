package org.example

class Memory {
    private val ram: ByteArray = ByteArray(4096) //size of 4KB
    private val rom: ByteArray = ByteArray(4096)
    private val memoryFlag: Int = 0

    fun read(address: Int): Byte {
        return if (address < ram.size) {
            ram[address]
        } else {
            rom[address - ram.size]
        }
    }

    fun write(address: Int, value: Byte) {
        if (address < ram.size) {
            ram[address] = value
        } else {
            throw IllegalAccessException("Cannot write to ROM")
        }
    }

    fun loadProgram(program: ByteArray) {
        System.arraycopy(program, 0, rom, 0, program.size.coerceAtMost(rom.size))
    }
}
