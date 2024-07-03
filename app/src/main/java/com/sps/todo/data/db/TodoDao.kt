package com.sps.todo.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sps.todo.data.models.Todo
import kotlinx.coroutines.flow.Flow


@Dao
interface TodoDao {
    @Insert
    fun insert(todo: Todo)

    @Query("SELECT * FROM todo")
    fun getAllTodoItems(): Flow<List<Todo>>

    @Query("SELECT * FROM todo WHERE id = :id")
    fun getTodoTaskById(id: Int): Todo

    @Update
    fun update(todo: Todo)

    @Delete
    fun delete(todo: Todo)
}