package vtsen.hashnode.dev.newemptycomposeapp.ui.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class FlowerState {

    var selectedPetalId by mutableStateOf<Int?>(null)
        private set

    fun selectPetal(id: Int) {
        selectedPetalId = id
    }

    fun clearSelection() {
        selectedPetalId = null
    }
}
