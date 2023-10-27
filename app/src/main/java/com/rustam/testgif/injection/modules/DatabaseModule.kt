package com.rustam.testgif.injection.modules

import android.content.Context
import androidx.room.Room
import com.rustam.testgif.data.database.AppDatabase
import com.rustam.testgif.data.database.dao.GifsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room
            .databaseBuilder(context, AppDatabase::class.java, AppDatabase.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideGifsDao(database: AppDatabase): GifsDao {
        return database.gifsDao
    }
}