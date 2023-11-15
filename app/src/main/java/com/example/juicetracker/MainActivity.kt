package com.example.juicetracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.juicetracker.data.JuiceColor
import com.example.juicetracker.data.JuiceEntity
import com.example.juicetracker.databinding.ActivityMainBinding
import com.example.juicetracker.databinding.FragmentTrackerBinding
import com.example.juicetracker.ui.JuiceTrackerViewModel
import com.example.juicetracker.ui.bottomsheet.ColorSpinnerRow
import com.example.juicetracker.ui.bottomsheet.InputRow

// Burda main'i artik Compose ile calismasi icin ComponentActivity inherit aldim.
// Simdi hem compose hemde view'in bir arada kullanildigi bir sey yapcam
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //MyAppStart()
            AppStarter()
        }
    }
}


@Composable
fun AppStarter(
    // view modeli initialize ettim.
    myViewModel: JuiceTrackerViewModel = viewModel(factory = JuiceTrackerViewModel.myFactory)
) {
    JuiceTrackerScreen(myViewModel = myViewModel, onUpdateJuice = myViewModel::changeState)
}


@Composable
fun JuiceTrackerScreen(
    onUpdateJuice: (JuiceEntity) -> Unit,
    myViewModel: JuiceTrackerViewModel

) {
    // Simdi UI tarafinda state'i collect etcem.
    val juice by myViewModel.currentJuiceStream.collectAsState()

   Column {
       ColorSpinnerRow(
           colorSpinnerPosition = 0,
           onColorChange = { index ->
               onUpdateJuice(juice.copy(color = JuiceColor.values()[index].name))
               println(" secilen index: $index")
           }
       )
       // view modeldeki metotu cagirdim. Benden parametre olarak bir JuiceEntity nesnesi istiyor.
       // var olan ui state'im de oydu zaten. Var olani kopyaladim.Degistirmek istedigim parametreyi degistirdim
       // Daha sonra view modele geri gonderdim. Simdi artik metot aldigi nesneye gore state'i update edecek.
       OutlinedTextField(value = juice.name,  onValueChange = {
           myViewModel.changeState(juice.copy(name = it))
       })
   }
}

private fun findColorIndex(color: String): Int {
    val juiceColor = JuiceColor.valueOf(color)
    return JuiceColor.values().indexOf(juiceColor)
}

