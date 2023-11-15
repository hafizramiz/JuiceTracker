package com.example.juicetracker.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Ucuncu adim. DB'yi create eden sinifi olustur,
// SOnra repository'e gececeksin

@Database(entities = arrayOf(JuiceEntity::class), version = 1)
abstract class JuiceDatabase : RoomDatabase() {
    // Burdaki abstract method neden var anlamadim daha? Bunu bakalim bir yerde kullancak miyim?
    abstract fun juiceDao(): JuiceDao


    //    Simdi statik alan icinde yani companion object icinde database'i olusturcam.
    // Return type'i JuiceDatabase olan bir fonksiyon yazdim.
    companion object {
        // Companion object nedir?
//    Companion object kullanarak baska bir sinif icinde bir singleton nesne olusturabiliriz.
        // Yani burda JuiceDatabase isimli bir sinifin icindeyim. Bu sinifin singleton'ni olusturmak istiyorum
        // Bunun icin companion object kullanabilirim. Bu alanda donen nesne her zaman ayni nesne olacak.

        //  Volatile neden yaptim? Bu nesnede meydana gelen degisiklik digerlerine hemen aktiralacak.
//ve karmasiklik bu sayede giderilecek

        @Volatile
        private var instance: JuiceDatabase? = null

        // Bu metot herhalukarda bir nesne donecek
        fun getDatabase(context: Context): JuiceDatabase {
            // Burda instance nesnesini dondur. Eger null ise o zamanda icini doldurcam.
            // syncrozied blogu icinde bunu initialize edip dondurem.
            return instance ?: synchronized(this) {
                Room.databaseBuilder(context, JuiceDatabase::class.java, "juice_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {
                        // burda instance icini doldurdum
                        instance = it
                    }
            }
        }
    }
}
// Bu katmani da olusturduktan sonra. Repository katmanina gec
