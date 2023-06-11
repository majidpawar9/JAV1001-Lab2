package lab2

import java.util.Scanner

fun main() {

    val sc = Scanner(System.`in`)
    print("Enter the text you want to Cipher: ")
    val text = sc.next()
    print("Enter the value of how many shifts you want to Cipher: ")
    val shift = sc.nextInt()
    val cipherresult = caeserCipher(text,shift)
    println("The Ciphertext for $text is $cipherresult")
    
}

fun caeserCipher(plainText: String, shiftNum: Int): String{

    var shift = shiftNum
    if(shift > 26){
        shift = shift % 26
    }
    else if (shift <26){
        shift = (shift % 26) + 26
    }
    var cipherText = ""

    for (ch in plainText) {
        if (ch.isLetter()){
            if (ch.isLowerCase()){
                var c: Char = ch + shift
                if(c > 'z'){
                    cipherText += ch - (26-shift)
                }
                else{
                    cipherText += c 
                }
            }
            else if (ch.isUpperCase()){
                var c = ch + shift
                if ( c > 'Z'){
                    cipherText += ch - (26 - shift) 
                }
                else{
                    cipherText += c
                }
            }
        }
        else{
            cipherText += ch
        }
    }
    return cipherText
}