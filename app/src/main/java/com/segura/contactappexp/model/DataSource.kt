package com.segura.contactappexp.model

class DataSource{
    private val contacts = mutableListOf<Contact>()

    fun loadContacts(): List<Contact>{
        return contacts.toList()
    }

    fun addContact(contact: Contact){
        contacts.add(contact)
    }
}