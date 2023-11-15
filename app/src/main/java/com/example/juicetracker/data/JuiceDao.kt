package com.example.juicetracker.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

// Ikinci olarak buraya geldim.
/// Burda interface icinde butun db metotlarini tanimladim.
// Burdan ucuncu adim olarak Db yi baslatacak sinifi olusturcam. Yani JuiceDatabase sinifina git
@Dao
interface JuiceDao {
    @Query("Select * from JuiceTable")
    fun getAllJuices(): Flow<List<JuiceEntity>>

    @Query("Select * from JuiceTable where id=:id")
    fun getWithId(id: Long):Flow<JuiceEntity>

    @Insert
    suspend fun insert(juiceEntity: JuiceEntity)

    @Delete
    suspend fun  delete(juiceEntity: JuiceEntity)

    @Update
    suspend fun update(juiceEntity: JuiceEntity)

}