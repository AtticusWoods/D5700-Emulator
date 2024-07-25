package org.example

class Timer {
    var value: Int = 0
    //Todo
    // Timer needs to be able to store up to 8 bits for timer val

    fun decrement() {
        if (value > 0) {
            value--
        }
    }
}
