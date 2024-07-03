package com.sps.todo.domain.todoRepo

import com.sps.todo.data.models.Todo
import kotlinx.coroutines.flow.Flow

interface ToDoRepo {
    suspend fun addTodoItem(todo: Todo)
    suspend fun getTodoItemById(id: Int): Todo
     fun getAllTodoList(): Flow<List<Todo>>
}