package com.sps.todo.domain.todoRepo

import com.sps.todo.data.models.Todo

interface ToDoRepo {
    suspend fun addTodoItem(todo: Todo)
    suspend fun getTodoItemById(id: Int): Todo
    suspend fun getAllTodoList(): List<Todo>
}