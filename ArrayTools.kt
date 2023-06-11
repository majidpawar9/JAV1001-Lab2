package lab2

import java.util.Scanner

fun main() {
    val selection = menu()
    val sc = Scanner(System.`in`)
    when (selection) {
        1 -> {
            print("Enter the text you want to Cipher: ")
            val text = sc.next()
            print("Enter the value of how many shifts you want to Cipher: ")
            val shift = sc.nextInt()
            val cipherresult = caeserCipher(text, shift)
            println("The Ciphertext for $text is $cipherresult")
        }
        2 -> {
            val arr = arrInput()
            val avgarr = avgArray(arr)
            println("The average is: %.2f".format(avgarr))
        }
        3 -> {
            val arr = arrInput()
            print("Enter the value you want to check in Array: ")
            val numToFind = sc.nextInt()
            println(arrContains(arr, numToFind))
        }
        4 -> {
            val arr = arrInput()
            println("The reversed Array is " + arrReverse(arr).joinToString())
        }
        else -> {
            println("Please select a Valid Option!!")
        }
    }
}

fun caeserCipher(plainText: String, shiftNum: Int): String {

    var shift = shiftNum
    if (shift > 26) {
        shift = shift % 26
    } else if (shift < 26) {
        shift = (shift % 26) + 26
    }
    var cipherText = ""

    for (ch in plainText) {
        if (ch.isLetter()) {
            if (ch.isLowerCase()) {
                var c: Char = ch + shift
                if (c > 'z') {
                    cipherText += ch - (26 - shift)
                } else {
                    cipherText += c
                }
            } else if (ch.isUpperCase()) {
                var c = ch + shift
                if (c > 'Z') {
                    cipherText += ch - (26 - shift)
                } else {
                    cipherText += c
                }
            }
        } else {
            cipherText += ch
        }
    }
    return cipherText
}

fun avgArray(arr: Array<Int>): Double {
    var sum = 0.0
    var len = arr.size
    for (i in arr) {
        sum += i
    }
    val avg: Double = sum / len
    return avg
}

fun arrContains(arr: Array<Int>, numToFind: Int): Boolean {
    var flag: Boolean = false
    for (i in arr) {
        if (i == numToFind) {
            flag = true
        }
    }
    return flag
}

fun arrReverse(arr: Array<Int>): Array<Int> {
    val size = arr.size
    for (i in 0 until size / 2) {
        val temp = arr[i]
        arr[i] = arr[size - i - 1]
        arr[size - i - 1] = temp
    }
    return arr
}

fun arrInput(): Array<Int> {
    val sc = Scanner(System.`in`)
    print("Enter the length of Array: ")
    val len: Int = sc.nextInt()
    println("Enter Array values")
    val arr = Array(len) { sc.nextInt() }
    return arr
}

fun menu(): Int {
    var sc = Scanner(System.`in`)
    print(
            """
        *****Menu*****
        Please select the action you would like to do:
        1. Cipher a text
        2. Calculate average of an Array
        3. Check if Array contains a value
        4. Reverse an Array
        **************
        Enter the value: 
    """.trimIndent()
    )
    var userselection: Int = sc.nextInt()
    return userselection
}
