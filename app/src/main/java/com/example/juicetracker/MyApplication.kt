package com.example.juicetracker

import android.app.Application
import com.example.juicetracker.data.AppContainer
import com.example.juicetracker.data.DataContainer

// Altinci adim olarak bu sinifa devam etcem.
// Burda  Application sinifindan inherit aldim.

class MyApplication:Application() {
    lateinit var appContainer: AppContainer
    override fun onCreate() {
        super.onCreate()
        appContainer=DataContainer(this)
    }

}

// Bunu da yatim artik manifest dosyasinda degisiklige gitcem.
// Yedince adim o olcak
// Bundan sonrasi artik viewModel olacak ve View olacak. View model'e repository katmanindan bir nesne
// enjekte etmem gerekiyor ki ordaki metotlari cagirabileyim. Her view model'in bir initialize metotu olacak
// o da view modeli initialize etmeye yaziyor. Her view model'de olacagi icin bunu
// ayri bir yerde tutup oraya da saglayabilirim.