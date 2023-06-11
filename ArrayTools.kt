package lab2

import java.util.Scanner

fun main() {

    // val sc = Scanner(System.`in`)
    // print("Enter the text you want to Cipher: ")
    // val text = sc.next()
    // print("Enter the value of how many shifts you want to Cipher: ")
    // val shift = sc.nextInt()
    // val cipherresult = caeserCipher(text, shift)
    // println("The Ciphertext for $text is $cipherresult")
    // var arr1 = arrayOf(3, 20, 30, 40, 50, 60)
    // val avgarr = avgArray(arr1)
    // println("The average is: %.2f".format(avgarr))
    // var arr2 = arrayOf(3, 20, 30, 40, 50, 60)
    // println(arrContains(arr2, 6))
    var arr3 = arrayOf(3, 20, 30, 40, 50, 60)
    println(arrReverse(arr3).joinToString())

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
