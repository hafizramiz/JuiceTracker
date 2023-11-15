package com.example.juicetracker.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.juicetracker.MyApplication
import com.example.juicetracker.data.IRoomRepository
import com.example.juicetracker.data.JuiceEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class JuiceTrackerViewModel(private val iRoomRepository: IRoomRepository) : ViewModel() {
    val emptyJuice = JuiceEntity(0, "bos", "bos descrption", "Red", 0)

    var _currentJuiceStream= MutableStateFlow(emptyJuice)
    val currentJuiceStream:StateFlow<JuiceEntity> =_currentJuiceStream


    val getAllJuice: Flow<List<JuiceEntity>> = iRoomRepository.getAllJuice()

    // View model'de method tanimladim.Bu metot bir nesne alacak ve state'i update edecek.
    // Ui tarafinda bu metotu cagirinca metota parametre olarak nesne vermem gerekiyor.Simdi ui tarafinda
    // cagiralim ve nesneyi buna parametre olarak verelim
    fun changeState(juiceEntity: JuiceEntity) {
      //  currentJuiceStream.copy(name = "Name degistirdim")
        val newJuice = JuiceEntity(1, "Demismis Juice", "bos descrption", "Red", 0)
        _currentJuiceStream.update { juiceEntity }
    }


    companion object {
        val myFactory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MyApplication)
                JuiceTrackerViewModel(application.appContainer.iRoomRepository)
            }
        }
    }
}