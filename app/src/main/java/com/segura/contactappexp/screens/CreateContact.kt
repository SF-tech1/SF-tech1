package com.segura.contactappexp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavHostController
import com.segura.contactappexp.R
import com.segura.contactappexp.model.Contact
import com.segura.contactappexp.model.DataSource

@Composable
fun CreateContact(
    navController: NavHostController,
    dataSource: DataSource,
    modifier: Modifier = Modifier
) {
    var fullName by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth().padding()
    ) {
        OutlinedTextField(
            value = fullName, onValueChange = { fullName = it }, label = { Text(text = "Full name") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = "Person") }
        )
        OutlinedTextField(
            value = phone, onValueChange = { phone = it }, label = { Text(text = "Phone") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            leadingIcon = { Icon(Icons.Default.Phone, contentDescription = "Person") }
        )
        OutlinedTextField(
            value = email, onValueChange = { email = it }, label = { Text(text = "email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = "Email") }
        )

        FilledTonalButton(onClick = {
            val newContact = Contact(
                fullName,
                phone,
                email,
                null
            )

            dataSource.addContact(newContact)

            fullName = ""
            phone = ""
            email = ""


            navController.popBackStack()
        }) {
            Text(text = stringResource(R.string.save_btn))
        }
    }
}