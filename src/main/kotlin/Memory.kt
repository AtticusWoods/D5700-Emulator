package org.example

@kotlin.ExperimentalUnsignedTypes
class Memory {
    var programSize: Int = 0
    val ram: UByteArray = UByteArray(4096) //size of 4KB
    val rom: UByteArray = UByteArray(4096)
    var memoryFlag: Int = 0

    fun read(address: Int): UByte {
        return if (address < ram.size) {
            ram[address]
        } else {
            throw IllegalArgumentException("Address out of bounds")
        }
    }

    fun readROM(address: Int): UByte {
        return if (address < rom.size) {
            rom[address]
        } else {
            throw IllegalArgumentException("Address out of bounds")
        }
    }

    fun write(address: Int, value: UByte) {
        if (address < ram.size) {
            ram[address] = value
        } else {
            throw IllegalArgumentException("Address out of bounds")

        }
    }

    fun writeROM(address: Int, value: UByte) {
        if (address < rom.size) {
            rom[address] = value
        } else {
            throw IllegalArgumentException("Address out of bounds")
        }
    }


}
