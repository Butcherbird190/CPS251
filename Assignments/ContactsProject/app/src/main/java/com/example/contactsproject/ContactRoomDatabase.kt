package com.example.contactsproject

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(Contact::class)], version = 2)
abstract class ContactRoomDatabase: RoomDatabase() {
    abstract fun contactDao(): ContactDAO
    companion object {
        private var INSTANCE: ContactRoomDatabase? = null
        internal fun getDatabase(context: Context): ContactRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(ContactRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE =
                            Room.databaseBuilder(
                                context.applicationContext,
                                ContactRoomDatabase::class.java,
                                "contact_database"
                            )
                                .fallbackToDestructiveMigration()
                                .build()
                    }
                }
            }
            return INSTANCE
        }
    }

}