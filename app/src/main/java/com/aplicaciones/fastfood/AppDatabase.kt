package com.aplicaciones.fastfood

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Order :: class], version = 1)

abstract class AppDatabase : RoomDatabase() {

    abstract  fun orders(): OrdersDAO
    companion object{
        @Volatile
        private var INSTANCE: AppDatabase?= null
        fun getDatabase(context: Context):AppDatabase{
            val tempInstance = INSTANCE

            if(tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}