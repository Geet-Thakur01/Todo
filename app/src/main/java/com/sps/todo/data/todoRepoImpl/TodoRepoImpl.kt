package com.sps.todo.data.todoRepoImpl

import com.sps.todo.data.db.TodoDao
import com.sps.todo.data.models.Todo
import com.sps.todo.domain.todoRepo.ToDoRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TodoRepoImpl @Inject constructor(private val todoDao: TodoDao) : ToDoRepo {
    override suspend fun addTodoItem(todo: Todo) {
        todoDao.insert(todo)
    }

    override suspend fun getTodoItemById(id: Int): Todo {
        return todoDao.getTodoTaskById(id)
    }

    override fun getAllTodoList(): Flow<List<Todo>> {
        return todoDao.getAllTodoItems()
    }
}