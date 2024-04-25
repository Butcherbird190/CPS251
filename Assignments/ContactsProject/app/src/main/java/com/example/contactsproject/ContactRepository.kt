package com.example.contactsproject
import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
class ContactRepository (application: Application) {
    val searchResults = MutableLiveData<List<Contact>>()
    private var contactDao: ContactDAO?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val allContacts: LiveData<List<Contact>>?
    init {
        val db: ContactRoomDatabase? =
            ContactRoomDatabase.getDatabase(application)
        contactDao = db?.contactDao()
        allContacts = contactDao?.getAllContacts()
    }

    fun insertContact(newcontact: Contact) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncInsert(newcontact)
        }
    }
    private fun asyncInsert(contact: Contact) {
        contactDao?.insertContact(contact)
    }

    fun deleteContact(id: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncDelete(id)
        }
    }
    private fun asyncDelete(id: Int) {
        contactDao?.deleteContact(id)
    }

    fun getAllAsc(): LiveData<List<Contact>>? {
        return contactDao?.getAllAsc()
    }

    fun getAllDesc(): LiveData<List<Contact>>? {
        return contactDao?.getAllDesc()
    }




    fun findContact(name: String) {
            coroutineScope.launch(Dispatchers.Main) {
                searchResults.value = asyncFind(name).await()
            }
        }

        //USES THE DEFERRED TO RETURN THE VALUES TO THE AWAIT OF THE FIND PRODUCT
        private fun asyncFind(name: String): Deferred<List<Contact>?> =
            coroutineScope.async(Dispatchers.IO) {
                //NOTICE THIS IS A RETURN HERE BECAUSE IT IS A SELECT QUERY IT RETURNS A VALUE
                return@async contactDao?.findContact(name)
            }
    }
