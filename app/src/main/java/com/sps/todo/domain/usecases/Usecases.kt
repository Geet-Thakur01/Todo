package com.sps.todo.domain.usecases

data class Useases(
    val insertTodoUseCase: InsertTodoUseCase=InsertTodoUseCase(),
    val todoListUseCase: TodoListUseCase=TodoListUseCase()){
}
