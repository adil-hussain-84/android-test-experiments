package androidx.test.experiments.app

class Calculator {

    fun calculate(operation: Operation, input1: Int, input2: Int): Int {
        return when (operation) {
            Operation.PLUS -> input1 + input2
        }
    }
}

enum class Operation {
    PLUS
}