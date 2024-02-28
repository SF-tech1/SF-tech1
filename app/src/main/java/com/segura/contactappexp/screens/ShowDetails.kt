package com.segura.contactappexp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.segura.contactappexp.model.Contact

@Composable
fun ShowDetails(
    navController: NavHostController,
    contact: Contact,
    modifier: Modifier = Modifier
){
    //Add your scaffold code here for back navigation
    Column {
        Card(
            elevation = CardDefaults.cardElevation(2.dp),
            colors = CardDefaults.cardColors(Color.Yellow),
            modifier = Modifier
                .fillMaxWidth().padding(16.dp)
                .padding(horizontal = 16.dp)

        ){
            Text(contact.fullName,modifier = Modifier.padding(10.dp))
            Text(contact.phoneNumber,modifier = Modifier.padding(18.dp))
            Text(contact.email,modifier = Modifier.padding(10.dp))
        }
    }
}

/*@Composable
fun ReusableCard(
    text: String
){
    Card(
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(Color.Yellow),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = text,
            //add your own font settings here
            modifier = Modifier.padding(6.dp)
        )
    }
}*/