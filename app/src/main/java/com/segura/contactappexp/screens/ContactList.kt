package com.segura.contactappexp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.segura.contactappexp.destinations.CreateNewContact
import com.segura.contactappexp.model.Contact
import com.segura.contactappexp.model.DataSource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactList(
    navController: NavHostController,
    dataSource: DataSource,

    ) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Contact")
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Filled.Menu , contentDescription = null )
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Filled.Search , contentDescription = null )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(CreateNewContact.route)
            }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) {innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            ListContact(
                navController = navController,
                contactList = dataSource.loadContacts(),
            )
        }

    }
}


@Composable
fun ListContact(
    navController: NavHostController,
    contactList: List<Contact>,
    modifier: Modifier = Modifier
){
    LazyColumn(
        modifier = modifier
    ){
        items(
            contactList
        ){
            it ->
            ContactMinimized(
                contact = it,
                navController = navController,
            )
        }
    }
}