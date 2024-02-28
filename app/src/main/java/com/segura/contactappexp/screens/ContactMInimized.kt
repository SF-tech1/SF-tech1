package com.segura.contactappexp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.segura.contactappexp.R
import com.segura.contactappexp.destinations.ViewContact
import com.segura.contactappexp.model.Contact

@Composable
fun ContactMinimized(
    navController: NavHostController,
    contact: Contact,
    modifier: Modifier = Modifier
){
    Spacer(modifier = modifier.padding(top = 10.dp))
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                //navController.navigate("Send to Show Details")
                //Come back and send to correct route
                navController.navigate("${ViewContact.route}/${contact.fullName}")
            }
    ) {
        Row(
            modifier = Modifier
                .height(72.dp)
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))

            ) {
                Image(
                    painter = painterResource(id = R.drawable.android_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .background(Color.Black)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(
            ){
                Text(text = contact.fullName)
                Text(text = contact.phoneNumber)
            }
        }
    }
}

@Preview
@Composable
fun ContactMinimizedPreview(){
    //ContactMinimized()
}