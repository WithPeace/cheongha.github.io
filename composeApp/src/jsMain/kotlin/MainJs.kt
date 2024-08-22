import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.skiko.wasm.onWasmReady

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    onWasmReady {
        ComposeViewport(document.body!!) {
            App(
                onPlayStoreClick = {
                    window.open("https://play.google.com/store/apps/details?id=com.withpeace.withpeace")
                },
                onAppStoreClick = {
                    window.open("https://apps.apple.com/kr/app/%EC%B2%AD%ED%95%98/id6504498223")
                }
            )
        }
    }
}
