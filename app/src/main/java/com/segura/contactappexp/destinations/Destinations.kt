package com.segura.contactappexp.destinations

interface Destinations {
    val route:String
}

object Home: Destinations{
    override val route = "ContactList"
}

object CreateNewContact: Destinations{
    override val route = "CreateNewContact"
}

object ViewContact: Destinations{
    override val route = "CreateNewContact"
}