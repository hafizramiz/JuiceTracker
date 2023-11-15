package com.example.juicetracker.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.juicetracker.MyApplication
import com.example.juicetracker.data.IRoomRepository
import com.example.juicetracker.data.JuiceEntity
import kotlinx.coroutines.flow.Flow


// Flow da bu importu yapmayinca hata veriyor. kendi de import etmiyor
/// import kotlinx.coroutines.flow.Flow

// Burda sayfanin view modelini olusturdum.
class EntryDialogViewModel(private val iRoomRepository: IRoomRepository) : ViewModel() {
    // Burda repodaki metotlari yazcam.
    // Burda bana gerekli olan metotlari alcam sadece Bu UI icin gerekli olanlari alcam
    fun getJuiceWithId(id: Long): Flow<JuiceEntity?> = iRoomRepository.getJuiceWithId(id)

    // Buraya bir metot daha yazcam



    // Simdi metotlari tanimladiktan sonra sira geldi viewmodelden bir nesne olusturmaya
    // Bunu companion object icinde olusturcam
    companion object {
        val myFactory: ViewModelProvider.Factory= viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MyApplication)
                EntryDialogViewModel(application.appContainer.iRoomRepository)
            }
        }
    }
}


// Eger AppViewModelProvider ile yapsam arayuzde view modeli boyle baslattim
//private val entryViewModel by viewModels<EntryViewModel> { AppViewModelProvider.Factory }
// Eger initializer metotumu yani compainon obejct ile birlikte
// view model icinde yazarsam arayuzde view modeli nasil baslatcam bakalim
//myViewModel: WordViewModel = viewModel(factory = WordViewModel.myFactory),
//o zaman da boyle baslattim
// Ayni sey hic bir farki yok.
//viewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory)