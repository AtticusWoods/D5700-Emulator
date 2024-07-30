package org.example

class Timer {
    var value: Int = 0

    fun decrement() {
        if (value > 0) {
            value--
        }
    }
}
