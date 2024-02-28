package com.segura.contactappexp.model

import androidx.annotation.DrawableRes

data class Contact(
    val fullName: String,
    val phoneNumber: String,
    val email: String,
    @DrawableRes val imageResourceId: Int?
)
