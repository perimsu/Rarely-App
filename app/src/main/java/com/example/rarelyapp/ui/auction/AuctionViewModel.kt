import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AuctionViewModel : ViewModel() {
    var startingPrice = mutableStateOf(30.00)
    var userInput = mutableStateOf("")
    var errorMessage = mutableStateOf("")
    var successMessage = mutableStateOf("")
}
