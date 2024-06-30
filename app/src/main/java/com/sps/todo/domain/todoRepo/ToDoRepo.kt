package com.sps.todo.domain.todoRepo

import com.sps.todo.data.models.Todo

interface ToDoRepo {
    suspend fun addTodoItem(text: String)
    fun showTodoItemById(id: Int): Todo
    fun getAllTodoList(): List<Todo>
}