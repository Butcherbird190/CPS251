package com.example.contactsproject

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
@Dao
interface ContactDAO {
    @Insert
    fun insertContact(contact: Contact)
    @Query("SELECT * FROM contacts WHERE contactName LIKE '%' || :name || '%'")
    fun findContact(name: String): List<Contact>
    @Query("DELETE FROM contacts WHERE contactID = :id")
    fun deleteContact(id: Int)

    @Query("SELECT * FROM contacts")
    fun getAllContacts(): LiveData<List<Contact>>

    @Query("SELECT * FROM contacts ORDER BY contactName ASC")
    fun getAllAsc(): LiveData<List<Contact>>
    @Query("SELECT * FROM contacts ORDER BY contactName DESC")
    fun getAllDesc(): LiveData<List<Contact>>
}