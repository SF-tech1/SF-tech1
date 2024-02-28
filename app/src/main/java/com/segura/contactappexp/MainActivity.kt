package com.segura.contactappexp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.segura.contactappexp.destinations.CreateNewContact
import com.segura.contactappexp.destinations.Home
import com.segura.contactappexp.destinations.ViewContact
import com.segura.contactappexp.model.DataSource
import com.segura.contactappexp.screens.ContactList
import com.segura.contactappexp.screens.CreateContact
import com.segura.contactappexp.screens.ShowDetails
import com.segura.contactappexp.ui.theme.ContactAppExpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactAppExpTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ContactApp()
                }
            }
        }
    }
}

private val dataSource = DataSource()
@Composable
fun ContactApp(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Home.route
    ){
        composable(
            Home.route
        ){
            ContactList(navController, dataSource = dataSource)
        }
        composable(
            CreateNewContact.route
        ){
            CreateContact(navController = navController, dataSource = dataSource)
        }
        composable(
            "${ViewContact.route}/{fullName}"
        ){it ->
            val fullName = it.arguments?.getString("fullName")
            val contact = dataSource.loadContacts().find {
                it.fullName == fullName
            }
            if (contact != null){
                ShowDetails(
                    navController = navController,
                    contact = contact
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ContactAppExpTheme {

    }
}