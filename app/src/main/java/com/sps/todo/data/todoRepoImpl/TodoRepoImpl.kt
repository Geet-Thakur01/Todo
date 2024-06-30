package com.sps.todo.data.todoRepoImpl

import android.app.Application
import com.sps.todo.TodoApp
import com.sps.todo.data.db.TodoDao
import com.sps.todo.data.models.Todo
import com.sps.todo.domain.todoRepo.ToDoRepo

class TodoRepoImpl(private val todoDao: TodoDao=TodoApp.database.todoDao()): ToDoRepo {
    override suspend fun addTodoItem(todo: Todo) {
        todoDao.insert(todo)
    }

    override suspend fun getTodoItemById(id: Int): Todo {
       return todoDao.getTodoTaskById(id)
    }

    override suspend fun getAllTodoList(): List<Todo> {
        return todoDao.getAllTodoItems()
    }
}