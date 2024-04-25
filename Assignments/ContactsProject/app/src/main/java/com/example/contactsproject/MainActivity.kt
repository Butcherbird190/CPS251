package com.example.contactsproject

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactsproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var adapter: ContactListAdapter? = null
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        recyclerSetup()
        observerSetup()
        listenerSetup()
    }

    private fun recyclerSetup() {
        adapter = ContactListAdapter(R.layout.contact_list_item)
        binding.contactRecycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
        binding.contactRecycler.adapter = adapter
    }

    private fun observerSetup() {
        viewModel.getAllContacts()?.observe(this) { contacts ->
            contacts?.let {
                adapter?.updateContacts(it)
            }
        }
        viewModel.getSearchResults().observe(this) { contacts ->
            contacts?.let {
                if (it.isNotEmpty()) {
                    val contact = it[0]
                    binding.contactName.setText(contact.contactName)
                    binding.contactNumber.setText(contact.phNumber)
                    currentContactId = contact.id
                } else {
                    currentContactId = null
                }
            }
        }

        viewModel.getSortedContacts().observe(this) { sortedContacts ->
            sortedContacts?.let {
                adapter?.updateContacts(it) // Update RecyclerView with sorted data
            }
        }



    }

    private fun clearFields() {
        binding.contactName.setText("")
        binding.contactNumber.setText("")
    }


    private var currentContactId: Int? = null

    private fun listenerSetup() {

        binding.buttonAdd.setOnClickListener {
            val name = binding.contactName.text.toString()
            val number = binding.contactNumber.text.toString()

            if (name != "" && number != "") {
                val contact = Contact(name, number)
                viewModel.insertContact(contact)
                clearFields()
            } else {
                binding.contactName.hint = "Incomplete information"
                binding.contactNumber.hint="Incomplete information"
                Toast.makeText(this, "You must enter a name and number", Toast.LENGTH_SHORT).show()
            }
        }
        binding.buttonFind.setOnClickListener {
            val name = binding.contactName.text.toString()

            if (name.isBlank()) {
                Toast.makeText(this, "You must enter a search criteria in the name field", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.findContact(name)
            }
        }

        binding.buttonDelete.setOnClickListener {
            currentContactId?.let { id ->
                viewModel.deleteContact(id)
            clearFields()
            } ?: run {
                Toast.makeText(this, "No entered contact to delete", Toast.LENGTH_SHORT).show()

            }

        }

        binding.buttonASC.setOnClickListener{
            viewModel.getAllASC()
        }
        binding.buttonDESC.setOnClickListener{
            viewModel.getAllDESC()
        }


    }




}


