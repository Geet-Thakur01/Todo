package com.sps.todo.di

import com.sps.todo.domain.todoRepo.ToDoRepo
import com.sps.todo.domain.usecases.InsertTodoUseCase
import com.sps.todo.domain.usecases.TodoListUseCase
import com.sps.todo.domain.usecases.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object UseCaseModule {

    @Provides
    fun getInsertTodoUseCase(toDoRepo: ToDoRepo): InsertTodoUseCase {
        return InsertTodoUseCase(toDoRepo)
    }

    @Provides
    fun getTodoListUseCase(toDoRepo: ToDoRepo): TodoListUseCase {
        return TodoListUseCase(toDoRepo)
    }

    @Provides
    fun getUseCasesList(insertTodoUseCase: InsertTodoUseCase,todoListUseCase: TodoListUseCase):UseCases{
        return UseCases(insertTodoUseCase,todoListUseCase)
    }

}