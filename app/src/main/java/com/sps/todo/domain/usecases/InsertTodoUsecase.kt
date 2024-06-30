package com.sps.todo.domain.usecases

import com.sps.todo.data.models.Todo
import com.sps.todo.data.todoRepoImpl.TodoRepoImpl
import com.sps.todo.domain.todoRepo.ToDoRepo

class InsertTodoUseCase(private val toDoRepo: ToDoRepo = TodoRepoImpl()) {
    suspend fun excecute(todo: Todo) {
         toDoRepo.addTodoItem(todo)
    }
}