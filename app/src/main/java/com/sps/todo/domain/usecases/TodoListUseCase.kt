package com.sps.todo.domain.usecases

import com.sps.todo.data.models.Todo
import com.sps.todo.data.todoRepoImpl.TodoRepoImpl
import com.sps.todo.domain.todoRepo.ToDoRepo
import javax.inject.Inject

class TodoListUseCase @Inject constructor(private val toDoRepo: ToDoRepo) {
   suspend fun excecute(): List<Todo> {
        return toDoRepo.getAllTodoList()
    }
}