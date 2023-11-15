package com.example.juicetracker.data

import android.graphics.Color
import androidx.annotation.StringRes
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.juicetracker.R

fun main() {
    println(" bos")
}
// Birinci yapmam gereken.
// Burasi benim Entity classim. Ilk once burdan basladim

@Entity(tableName = "JuiceTable")
data class JuiceEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val description: String = "",
    val color: String,
    val rating: Int
)

// Enum class kullarak renkelri eslestirmeye calisiyorum
enum class JuiceColor(val colorCode: Int, @StringRes val label: Int) {
    RED(Color.RED, R.string.red),
    BLUE(Color.BLUE, R.string.blue),
    GREEN(Color.GREEN, R.string.green),
    CYAN(Color.CYAN, R.string.cyan),
    YELLOW(Color.YELLOW, R.string.yellow)
}



