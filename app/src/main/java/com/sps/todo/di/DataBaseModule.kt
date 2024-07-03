package com.sps.todo.di

import android.content.Context
import androidx.room.Room
import com.sps.todo.data.db.AppDataBase
import com.sps.todo.data.db.TodoDao
import com.sps.todo.data.todoRepoImpl.TodoRepoImpl
import com.sps.todo.domain.todoRepo.ToDoRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDataBase {
        return Room.databaseBuilder(appContext, AppDataBase::class.java, AppDataBase.DB_NAME)
            .build()
    }

    @Provides
    @Singleton
    fun provideTodoDao(appDatabase: AppDataBase): TodoDao {
        return appDatabase.todoDao()
    }

    @Provides
    @Singleton
    fun provideTodoRepository(todoDao: TodoDao): ToDoRepo{
        return TodoRepoImpl(todoDao)
    }
}