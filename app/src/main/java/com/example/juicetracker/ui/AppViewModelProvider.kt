
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.juicetracker.MyApplication


// Burda view model'i initialize edecegim metotlari yazcam. Bu sayede her viewModel'de tekrar tekrar
//yazmama gerek kalmiyacak
// Uygulamanin tamami icin ViewModel'in ornegini olusturmak icin kolaylik sagliyacak bu
//object AppViewModelProvider {
//    val Factory = viewModelFactory {
//
//        initializer {
//            // Burda View modeli initialize etcem
//            EntryDialogViewModel(juiceTrackerApplication().appContainer.iRoomRepository)
//        }
//    }
//}
//
//fun CreationExtras.juiceTrackerApplication(): MyApplication =
//    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MyApplication)