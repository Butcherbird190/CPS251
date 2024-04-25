package com.example.contactsproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel (application: Application) : AndroidViewModel(application) {
    private val repository: ContactRepository = ContactRepository(application)
    private val allContacts: LiveData<List<Contact>>?
    private val searchResults: MutableLiveData<List<Contact>>
    private val sortedContacts: MutableLiveData<List<Contact>>
    init {
        allContacts = repository.allContacts
        searchResults = repository.searchResults
        sortedContacts = MutableLiveData()
    }

    fun insertContact(contact: Contact) {
        repository.insertContact(contact)
    }
    fun findContact(name: String) {
        repository.findContact(name)
    }
    fun deleteContact(id: Int) {
        repository.deleteContact(id = id)
    }
    fun getSearchResults(): MutableLiveData<List<Contact>> {
        return searchResults
    }
    fun getAllContacts(): LiveData<List<Contact>>? {
        return allContacts
    }
    fun getSortedContacts(): LiveData<List<Contact>> {
        return sortedContacts
    }
    fun getAllASC(){
        repository.getAllAsc()?.observeForever { sortedList ->
            sortedContacts.value = sortedList
        }
    }
    fun getAllDESC(){
        repository.getAllDesc()?.observeForever { sortedList ->
            sortedContacts.value = sortedList
        }
    }

}