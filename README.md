Requirements

    UML (30 pts)
        1.1 You should do your conceptual model using UML before you write any code.
        1.2 Your UML diagram should include all classes and should correctly model their relationships, attributes, and methods. Be sure to indicate which methods are public or private.
        1.3 Your UML should correctly model the design patterns you plan on implementing.
        1.4 Look for opportunities to use the singleton, template method, facade, factory, and strategy patterns.
        1.5 Make sure to use the correct syntax for representing your relationships
    Implementation (70 pts)
        1.1 When the emulator program starts, the user is asked to type in the path to a program to load
            1.1.2 When the file is loaded the bytes are copied into the ROM portion of the computer
            1.1.3 The loaded program starts executing
        1.2 Instructions
            1.2.1 Each instruction is implemented correctly
                Use the provided programs to test the instructions.
            1.2.2 The program stops when the CPU encounters the instruction 0000.
        1.3 Programs
            1.3.1 Your emulator should be able to execute all of the provided programs
        1.4 Output
            You can decide how to implement the emulator's 8x8 screen. You are welcome to use Jetpack Compose or another GUI framework or just simply draw the "screen" to the console (see my example video). A GUI is a little more work (because input will be harder if you build a GUI) but looks cooler, but it will be your preference. If you are unsure, I recommend just writing to the console.
        1.5 Input
            Same deal as output. You can just do console input and console output, or you can have users provide input through text input in Jetpack compose
    Unit Tests(30 pts)
        1.1 Unit tests should be thorough and cover edge cases.
            It might be wise to write your unit tests as you go so that you know your instructions are working as you write them.
