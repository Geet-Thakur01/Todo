package com.sps.todo.domain.usecases

import javax.inject.Inject

data class UseCases @Inject constructor(
    val insertTodoUseCase: InsertTodoUseCase,
    val todoListUseCase: TodoListUseCase
)
