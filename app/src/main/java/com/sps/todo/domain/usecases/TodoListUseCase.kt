package com.sps.todo.domain.usecases

import com.sps.todo.data.models.Todo
import com.sps.todo.domain.todoRepo.ToDoRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TodoListUseCase @Inject constructor(private val toDoRepo: ToDoRepo) {
     fun excecute(): Flow<List<Todo>> {
        return toDoRepo.getAllTodoList()
    }
}