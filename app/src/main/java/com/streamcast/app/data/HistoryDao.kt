package com.streamcast.app.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface HistoryDao {

    @Query("SELECT * FROM history ORDER BY timestamp DESC LIMIT 50")
    fun getRecentHistory(): LiveData<List<HistoryEntry>>

    @Query("SELECT * FROM history WHERE isFavorite = 1 ORDER BY timestamp DESC")
    fun getFavorites(): LiveData<List<HistoryEntry>>

    @Query("SELECT * FROM history WHERE url = :url LIMIT 1")
    suspend fun getByUrl(url: String): HistoryEntry?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entry: HistoryEntry)

    @Update
    suspend fun update(entry: HistoryEntry)

    @Delete
    suspend fun delete(entry: HistoryEntry)

    @Query("DELETE FROM history WHERE isFavorite = 0")
    suspend fun clearHistory()

    @Query("UPDATE history SET isFavorite = :isFavorite WHERE id = :id")
    suspend fun setFavorite(id: Long, isFavorite: Boolean)
}
