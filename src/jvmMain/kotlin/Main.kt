import Converter.Companion.byteToHex
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.awt.ComposeWindow
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import java.awt.FileDialog
import java.io.File

val HEXA = 16

@Composable
@Preview
fun App() {
    var fileChooser = FileDialog(ComposeWindow())
    var hexString by remember { mutableStateOf("") }

    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar() {
                    Row {
                        Button(onClick = {
                            fileChooser.isVisible = true
                            if(fileChooser.file != null){
                                val byteArray = File(fileChooser.file).readBytes()
                                hexString = byteToHex(byteArray)
                            }
                        }){
                            Text("Open")
                        }

                        Button(onClick = {

                        }){
                            Text("About")
                        }
                    }
                }
            },
            bottomBar = {
                BottomAppBar() { /* Bottom app bar content */ }
            }){
            Column {
                Text(hexString)
            }

        }
    }
}

//private fun extract(byteArray: ByteArray) : Array<Array<String>>  {
//    val row = byteArray.size / HEXA + 1
//    val col = HEXA
//
//    val array = Array(row) { Array(col) { "" } }
//
//    array.forEachIndexed { index, strings ->
//        strings.forEachIndexed { idx, _ ->
//            strings[idx] = if(index * HEXA + idx < byteArray.size) {
//                byteToHex(byteArray[index * HEXA + idx])
//            }else{
//                ""
//            }
//        }
//    }
//    return array
//}


fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Byte Viewer"
    ) {
        App()
    }
}
