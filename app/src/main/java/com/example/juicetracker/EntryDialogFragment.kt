package com.example.juicetracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.juicetracker.ui.EntryDialogViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.navArgs
import com.example.juicetracker.data.JuiceColor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import androidx.navigation.fragment.navArgs
import com.example.juicetracker.databinding.FragmentEntryDialogBinding

// Fragmenti olusturdum artik benim View Modele de ihtiyacim var. Statelrimi buraya aktarcam
class EntryDialogFragment : BottomSheetDialogFragment() {

    // Burda viewModelden bir nesne olusturcam
    private val entryViewModel = viewModels<EntryDialogViewModel> { EntryDialogViewModel.myFactory }
    var selectedColor: JuiceColor = JuiceColor.RED

    // Burda kendi icindeki fonksiyonu override ettim. Return type'i View olan bir fonksiyonu
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Bu metot su anda superini cagiriyor. Ama biz bunu customize edecegiz.
        // return super.onCreateView(inflater, container, savedInstanceState)
        // FragmentEntryDialogBinding  tanimli bir siniftir.
        return FragmentEntryDialogBinding.inflate(inflater, container, false).root
        // Bu metot buna verdigimiz xml'i kotlin koduna donduruyor. Ve sonunda bize bir view donuyor
    }

    //onCreateView'dan sonra onViewCreated metotu calisacak. Cunku fragmentin de ayri bir lifecycle'i var
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = FragmentEntryDialogBinding.bind(view)
        // Burda argument'i elde etmem gerekiyor
        // view modeldeki save metotunu calistir.

        dismiss()
    }

}
