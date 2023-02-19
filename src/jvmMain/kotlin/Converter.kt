class Converter {
    companion object{
        fun byteToHex(byte : Byte) : String{

            var string = ""
            val first =  byte.toUByte().toInt() / 16
            val second = byte.toUByte().toInt() % 16

            string += String.format("%01X", first)
            string += String.format("%01X", second)

            return string
        }

        fun byteToHex(byteArray : ByteArray) : String{
            var string = ""

            byteArray.forEach {

                val first =  it.toUByte().toInt() / 16
                val second = it.toUByte().toInt() % 16

                string += String.format("%01X", first)
                string += String.format("%01X", second)
            }

            return string
        }

        fun intToHex(int : Int) : String{

            if(int == 0){
                return "0"
            }

            var hexString = ""
            var num = int
            while (num > 0){
                val hex = when(num % 16){
                    0 -> "0"
                    1 -> "1"
                    2 -> "2"
                    3 -> "3"
                    4 -> "4"
                    5 -> "5"
                    6 -> "6"
                    7 -> "7"
                    8 -> "8"
                    9 -> "9"
                    10 -> "A"
                    11 -> "B"
                    12 -> "C"
                    13 -> "D"
                    14 -> "E"
                    15 -> "F"
                    else -> "0"
                }
                hexString += hex
                num /= 16
            }
            return hexString.reversed()
        }
    }
}