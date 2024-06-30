package com.sps.todo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sps.todo.data.models.Todo

@Database(entities = [Todo::class], version = 1)
abstract class AppDataBase : RoomDatabase(){
    abstract fun todoDao():TodoDao

}