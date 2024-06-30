package com.sps.todo.data.todoRepoImpl

import com.sps.todo.data.models.Todo
import com.sps.todo.domain.todoRepo.ToDoRepo

class TodoRepoImpl: ToDoRepo {
    override suspend fun addTodoItem(text: String) {
        TODO("Not yet implemented")
    }

    override fun showTodoItemById(id: Int): Todo {
        TODO("Not yet implemented")
    }

    override fun getAllTodoList(): List<Todo> {
        TODO("Not yet implemented")
    }
}