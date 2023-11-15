package com.example.juicetracker.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

// Besinci adim Container classi olusturmak Bunun icin once AppContainer isimli interface olsutur
// SOnra bundan inherit alman gerkiyor
// Bu adimda bittikten sonra Application sinifina gecmem gerekiyor. Hani Application sinifindan inherit alip
// yazdigim sinif vardiya ona geccem.
interface AppContainer {
    val iRoomRepository: IRoomRepository
}

class DataContainer(context: Context): AppContainer {

    //    JuiceDatabase.getDatabase(context)
    // Burasini JuiceDatabase sinifi icindeki getDatabase isimli statik metota erismek icin kullandim.
    // getDatabase bir JuiceDatabase nesnesi donduruyor. Yani kendini donduruyor. Bu sayede onun icindeki
    // abstract sinifa eristim. Abstract sinifta hangisi
//    abstract fun juiceDao(): JuiceDao  Bu abstract sinif. Bu metotu cagirdim.

    override val iRoomRepository: IRoomRepository by lazy {
        RoomRepository(JuiceDatabase.getDatabase(context).juiceDao())
    }
}



//JuiceDatabase nasil birsey gormek icin buraya kopyasini ekledim.
//abstract class JuiceDatabase : RoomDatabase() {
//    abstract fun juiceDao(): JuiceDao
//    companion object {
//        @Volatile
//        private var instance: JuiceDatabase? = null
//        // getDatabase isimli Statik metot var
//        fun getDatabase(context: Context): JuiceDatabase {
//            return instance ?: synchronized(this) {
//                Room.databaseBuilder(context, JuiceDatabase::class.java, "juice_database")
//                    .fallbackToDestructiveMigration()
//                    .build()
//                    .also {
//                        instance = it
//                    }
//            }
//        }
//    }
//}