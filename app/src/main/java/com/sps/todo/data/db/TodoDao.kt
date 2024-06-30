package com.sps.todo.data.db

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sps.todo.data.models.Todo

interface TodoDao {
    @Insert
    fun insert(todo: Todo?)

    @Query("SELECT * FROM todo")
    fun getAllTodoItems(): List<Todo>

    @Query("SELECT * FROM todo WHERE id = :id")
    fun getTodoTaskById(id: Int?): Todo?

    @Update
    fun update(todo: Todo?)

    @Delete
    fun delete(todo: Todo?)
}