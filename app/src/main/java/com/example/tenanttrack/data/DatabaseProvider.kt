package com.example.tenanttrack.data

import android.content.Context
import androidx.room.Room
import com.example.tenanttrack.BuildConfig
import net.sqlcipher.database.SupportFactory

object DatabaseProvider {
    private var INSTANCE: AppDatabase? = null
    private val factory = SupportFactory(BuildConfig.PASS_PHRASE.toByteArray())

    fun getInstance(context: Context): AppDatabase {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "tenantStack.db"
            )
                .openHelperFactory(factory)
                .build()
        }
        return INSTANCE!!
    }
}
