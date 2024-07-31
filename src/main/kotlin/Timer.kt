package org.example

class Timer {
    var value: Int = 0
    private var running = true

    fun start() {
        Thread {
            while (running) {
                if (value > 0) {
                    value--
                }
                Thread.sleep(16) // Decrement the timer every 16ms
            }
        }.start()
    }

    fun stop() {
        running = false
    }

}
