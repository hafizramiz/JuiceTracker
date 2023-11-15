package com.example.juicetracker.data
import kotlinx.coroutines.flow.Flow
// Dorduncu adim Repository katmanini olustur.

// Repository'i once bir interface tanimlayip ondan inherit almak daha uygun oluyor.
// Burda bir interface tanimlatim. Repository katmanini olustururken asaginda bundan inherit alcam.
// Bu sayede bunu inherit  alan siniflar bu metotlar implemente etmek zorunda kalacaklar.
interface IRoomRepository{
    fun getAllJuice(): Flow<List<JuiceEntity>>
    fun getJuiceWithId(id:Long): Flow<JuiceEntity?>
    suspend fun addJuice(juiceEntity: JuiceEntity)
    suspend fun deleteJuice(juiceEntity: JuiceEntity)
    suspend fun updateJuice(juiceEntity: JuiceEntity)
}

// SImdi ondan inherit alip Repository katmani olusturdum
// RoomRepository'den bir nesne olusturulurken bizden bir juiceDao istiyecek. Bunu ona saglamamiz gerekiyor.
class RoomRepository(private val juiceDao:JuiceDao):IRoomRepository {
    // Repository icin bir tane Dao objesine ihtiyac vardir. Bununla dao'nun metotlarina eriscem.
    // Boyle yapabildigim gibi kisaa da yazabilirim
//    override suspend fun addJuice(juiceEntity: JuiceEntity) {
//        return juiceDao.insert(juiceEntity)
//    }
//    Yani boyle:
    override fun getAllJuice(): Flow<List<JuiceEntity>> =juiceDao.getAllJuices()
    override fun getJuiceWithId(id:Long): Flow<JuiceEntity?> =juiceDao.getWithId(id)
    override suspend fun addJuice(juiceEntity: JuiceEntity)=juiceDao.insert(juiceEntity)
    override suspend fun deleteJuice(juiceEntity: JuiceEntity) =juiceDao.delete(juiceEntity)
    override suspend fun updateJuice(juiceEntity: JuiceEntity) =juiceDao.update(juiceEntity)
}

// Bunu da yaptiktan sonra Besinci adim AppContainer'a gec ki Manuel Dependecy Enjection yap