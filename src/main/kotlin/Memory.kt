package org.example

class Memory {
    var programSize: Int = 0
    val ram: ByteArray = ByteArray(4096) //size of 4KB
    val rom: ByteArray = ByteArray(4096)
    var memoryFlag: Int = 0

    fun read(address: Int): Byte {
        return if (address < ram.size) {
            ram[address]
        } else {
            throw IllegalArgumentException("Address out of bounds")
        }
    }

    fun readROM(address: Int): Byte {
        return if (address < rom.size) {
            rom[address]
        } else {
            throw IllegalArgumentException("Address out of bounds")
        }
    }

    fun write(address: Int, value: Byte) {
        if (address < ram.size) {
            ram[address] = value
        } else {
            throw IllegalArgumentException("Address out of bounds")

        }
    }

    fun writeROM(address: Int, value: Byte) {
        if (address < rom.size) {
            rom[address] = value
        } else {
            throw IllegalArgumentException("Address out of bounds")
        }
    }

    fun loadProgram(program: ByteArray) {
        System.arraycopy(program, 0, rom, 0, program.size.coerceAtMost(rom.size))
    }
}
