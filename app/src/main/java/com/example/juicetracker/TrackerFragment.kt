package com.example.juicetracker

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.juicetracker.databinding.FragmentTrackerBinding
import com.example.juicetracker.ui.EntryDialogViewModel

class TrackerFragment:Fragment() {
    // Burda view modeli degistirecem.
//    private val entryViewModel = viewModels<EntryDialogViewModel> { EntryDialogViewModel.myFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("test","onCreateView called" )
       return FragmentTrackerBinding.inflate(inflater, container,false).root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i("test","onViewCreated called" )

        // View olustuktan sonra once binding'e eristim.
        val binding:FragmentTrackerBinding=FragmentTrackerBinding.bind(view)
        // Artik findViewById demek yerine binding. diyerek xml tarafinda olusturmus oldugum view'larin idsini
//        yazarak erisecem. Eristikten sonra onlara setOnClickListener ekleyecem.
        binding.fab.setOnClickListener{
            // Bu bize bir view veriyor.
            fabView-> println("Elde edilen fabview: $fabView")
            Log.i("test", "Elde edilen fabview: $fabView")
        }
    }

}
